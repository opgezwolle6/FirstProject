package ru.startandroid.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ru.startandroid.firstproject.utils.Preferences;

public class AuthorizationActivity extends BaseActivity implements View.OnClickListener {

    EditText etLogin;
    EditText etPassword;
    Button buttonGo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        etLogin = (EditText) findViewById(R.id.edit_text_login);
        etPassword = (EditText) findViewById(R.id.edit_text_password);

        buttonGo = (Button) findViewById(R.id.buttonGo);
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
        Preferences preferences = App.instance.getPreferences();
        preferences.saveLogin(etLogin.getText().toString());
        preferences.savePassword(etPassword.getText().toString());
    }

    // загрузка логина и пароля из преференс
    public void loadLoginAndPassword(){
        Preferences preferences = App.instance.getPreferences();
        etLogin.setText(preferences.getLogin());
        etPassword.setText(preferences.getPassword());
    }

    @Override
    protected void onDestroy() {
        saveLoginAndPassword();
        super.onDestroy();
    }
}