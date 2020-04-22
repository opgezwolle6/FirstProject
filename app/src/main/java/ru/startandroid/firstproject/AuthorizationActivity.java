package ru.startandroid.firstproject;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AuthorizationActivity extends FragmentActivity implements View.OnClickListener {

    SharedPreferences sharedPreferencesLogAndPass;
    EditText etLogin;
    EditText etPassword;

    final static String LOGIN = "login";
    final static String PASSWORD = "password";


    private FragmentRegistration fragmentRegistration;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        etLogin = (EditText) findViewById(R.id.edit_text_login);
        etPassword = (EditText) findViewById(R.id.edit_text_password);

        Button buttonGo = (Button) findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(this);

        loadLoginAndPassword();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonGo:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                saveLoginAndPassword();
                break;
        }
    }

    // сохранение логина и пароля в преференс
    public void saveLoginAndPassword(){
        sharedPreferencesLogAndPass = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesLogAndPass.edit();
        editor.putString(LOGIN, etLogin.getText().toString());
        editor.putString(PASSWORD, etPassword.getText().toString());
        editor.commit();
    }

    // загрузка логина и пароля из преференс
    public void loadLoginAndPassword(){
        sharedPreferencesLogAndPass = getPreferences(Context.MODE_PRIVATE);
        String login = sharedPreferencesLogAndPass.getString(LOGIN, "");
        String password = sharedPreferencesLogAndPass.getString(PASSWORD, "");
        etLogin.setText(login);
        etPassword.setText(password);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveLoginAndPassword();
    }


}
