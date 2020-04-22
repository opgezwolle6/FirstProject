package ru.startandroid.firstproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment implements View.OnClickListener {

    EditText etLogin, etPassword, etFirstName, etSecondName;
    Button btnReg;

    SharedPreferences sharedPreferencesLogAndPass;
    final String LOGIN = "login";
    final String PASSWORD = "password";
    final String FIRST_NAME = "first_name";
    final String SECOND_NAME = "second_name";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3, null);

        etFirstName = (EditText) v.findViewById(R.id.edit_text_first_name);
        etSecondName = (EditText) v.findViewById(R.id.edit_text_second_name);
        etLogin = (EditText) v.findViewById(R.id.edit_text_login);
        etPassword = (EditText) v.findViewById(R.id.edit_text_password);

        btnReg = (Button) v.findViewById(R.id.button_reg);

        return v;
    }

    @Override
    public void onClick(View v) {
        saveLoginAndPassword();
    }

    public void saveLoginAndPassword(){
        sharedPreferencesLogAndPass = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesLogAndPass.edit();
        editor.putString(FIRST_NAME, etFirstName.getText().toString());
        editor.putString(SECOND_NAME, etSecondName.getText().toString());
        editor.putString(LOGIN, etLogin.getText().toString());
        editor.putString(PASSWORD, etPassword.getText().toString());
        editor.commit();
    }

    public void loadLoginAndPassword(){
        sharedPreferencesLogAndPass = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        String login = sharedPreferencesLogAndPass.getString(LOGIN, "");
        String password = sharedPreferencesLogAndPass.getString(PASSWORD, "");
        etLogin.setText(login);
        etPassword.setText(password);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveLoginAndPassword();
    }


}
