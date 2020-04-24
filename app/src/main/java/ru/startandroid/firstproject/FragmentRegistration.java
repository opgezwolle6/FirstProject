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

import ru.startandroid.firstproject.utils.Preferences;

public class FragmentRegistration extends Fragment {


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

        Button buttonToRegister = view.findViewById(R.id.buttonToRegister);
        buttonToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences preferences = App.instance.getPreferences();
                preferences.saveFirstName(etFirstName.getText().toString());
                preferences.saveSecondName(etSecondName.getText().toString());
                preferences.saveLogin(etLogin.getText().toString());
                preferences.savePassword(etPassword.getText().toString());

                FragmentLogin fragmentLogin = new FragmentLogin();
                ((AuthorizationActivity)getActivity()).replaceFragment(BaseActivity.FRAGMENT_CONTAINER_AUTHORIZATION, fragmentLogin);
            }
        });
    }
}
