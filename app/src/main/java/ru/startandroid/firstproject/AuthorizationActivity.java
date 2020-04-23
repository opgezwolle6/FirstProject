package ru.startandroid.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.startandroid.firstproject.utils.Preferences;


public class AuthorizationActivity extends BaseActivity implements View.OnClickListener {

    EditText etLogin;
    EditText etPassword;
    Button buttonGo;

    final static String LOGIN = "login";
    final static String PASSWORD = "password";
    final static String NAME = "password";

    private FragmentRegistration fragmentRegistration;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        etLogin = (EditText) findViewById(R.id.edit_text_login);
        etPassword = (EditText) findViewById(R.id.edit_text_password);

        buttonGo = (Button) findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            saveLoginAndPassword();
        });

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
        Preferences preferences = App.instance.getPreferences();
        preferences.saveLogin(etLogin.getText().toString());

        editor.putString(PASSWORD, etPassword.getText().toString());
        editor.commit();
    }

    // загрузка логина и пароля из преференс
    public void loadLoginAndPassword(){
        String login = App.instance.getPreferences().getString(LOGIN, "");
        String password = App.instance.getPreferences().getString(PASSWORD, "");
        etLogin.setText(login);
        etPassword.setText(password);
    }

    @Override
    protected void onDestroy() {
        saveLoginAndPassword();
        super.onDestroy();
    }


}