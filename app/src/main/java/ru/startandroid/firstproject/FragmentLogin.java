package ru.startandroid.firstproject;

import android.content.Intent;
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

public class FragmentLogin extends Fragment {


    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etLogin = (EditText) view.findViewById(R.id.edit_text_login);
        EditText etPassword = (EditText) view.findViewById(R.id.edit_text_password);

        Button buttonGo = (Button) view.findViewById(R.id.buttonGo);
        Button buttonCheckIn = (Button) view.findViewById(R.id.buttonCheckIn);

        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        ((AuthorizationActivity)getActivity()).loadLoginAndPassword(etLogin, etPassword);

        buttonGo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            ((AuthorizationActivity)getActivity()).saveLoginAndPassword(etLogin,etPassword);
        });

        buttonCheckIn.setOnClickListener(v -> {
            navController.navigate(R.id.fragmentRegistration);
        });

    }
}
