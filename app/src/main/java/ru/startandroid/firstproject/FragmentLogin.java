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

public class FragmentLogin extends Fragment {

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

        ((AuthorizationActivity)getActivity()).loadLoginAndPassword(etLogin, etPassword);

        buttonGo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            ((AuthorizationActivity)getActivity()).saveLoginAndPassword(etLogin,etPassword);
        });

        buttonCheckIn.setOnClickListener(v -> {
            FragmentRegistration fragmentRegistration = new FragmentRegistration();
            ((AuthorizationActivity)getActivity()).saveLoginAndPassword(etLogin, etPassword);
            ((AuthorizationActivity)getActivity()).replaceFragment(BaseActivity.FRAGMENT_CONTAINER_AUTHORIZATION, fragmentRegistration);
        });

    }
}
