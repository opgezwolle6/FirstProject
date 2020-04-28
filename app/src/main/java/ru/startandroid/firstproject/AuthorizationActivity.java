package ru.startandroid.firstproject;

import android.os.Bundle;

public class AuthorizationActivity extends BaseActivity  {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
 /*
    // сохранение логина и пароля в преференс
    public void saveLoginAndPassword(EditText etLogin, EditText etPassword){
        Preferences preferences = App.instance.getPreferences();
        preferences.saveLogin(etLogin.getText().toString());
        preferences.savePassword(etPassword.getText().toString());
    }

    // загрузка логина и пароля из преференс
    public void loadLoginAndPassword(EditText etLogin, EditText etPassword){
        Preferences preferences = App.instance.getPreferences();
        etLogin.setText(preferences.getLogin());
        etPassword.setText(preferences.getPassword());
    }

 */