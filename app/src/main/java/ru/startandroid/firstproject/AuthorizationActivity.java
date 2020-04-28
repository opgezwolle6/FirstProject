package ru.startandroid.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorResolver;

import ru.startandroid.firstproject.utils.Preferences;

public class AuthorizationActivity extends BaseActivity  {

    private static final String TAG = "myLogs";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        mAuth = FirebaseAuth.getInstance();

    }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}