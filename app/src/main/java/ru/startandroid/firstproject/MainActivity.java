package ru.startandroid.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    SharedPreferences sharedPreferencesLogAndPass;
    public static final String FILE_NAME = "logAndPass";
    final static String LOGIN = "login";
    final static String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // добавление фрагмента с кнопкой Далее
        FragmentMainNext fragmentMainNext = new FragmentMainNext();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainerMain, fragmentMainNext);
        fragmentTransaction.commit();
        // фрагмент добавлен в мейн

    }


    public void sharedPreferencesIsNull(){
        sharedPreferencesLogAndPass = getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesLogAndPass.edit();
        editor.putString(LOGIN, "");
        editor.putString(PASSWORD, "");
        editor.commit();
    }

}

