package ru.startandroid.firstproject;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.startandroid.firstproject.utils.Preferences;

public class MainActivity extends BaseActivity  {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // добавление фрагмента с кнопкой Далее


        // фрагмент добавлен в мейн

    }

    public void clearLoginAndPassword(){
        Preferences preferences = App.instance.getPreferences();
        preferences.clearLogin();
        preferences.clearPassword();
    }

}

