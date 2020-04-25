package ru.startandroid.firstproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.startandroid.firstproject.utils.Preferences;

public class FragmentRegistration extends Fragment {

    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etFirstName = view.findViewById(R.id.edit_text_first_name);
        EditText etSecondName = view.findViewById(R.id.edit_text_second_name);
        EditText etLogin = view.findViewById(R.id.edit_text_login);
        EditText etPassword = view.findViewById(R.id.edit_text_password);

        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        Button buttonToRegister = view.findViewById(R.id.buttonToRegister);
        buttonToRegister.setOnClickListener(v -> {
            Preferences preferences = App.instance.getPreferences();
            preferences.saveFirstName(etFirstName.getText().toString());
            preferences.saveSecondName(etSecondName.getText().toString());
            preferences.saveLogin(etLogin.getText().toString());
            preferences.savePassword(etPassword.getText().toString());

            navController.navigate(R.id.fragmentLogin);
        });
    }
}
