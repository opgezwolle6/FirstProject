package ru.startandroid.firstproject;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    // final static int FRAGMENT_CONTAINER_MAIN = R.id.fragmentContainerMain;
    // final static int FRAGMENT_CONTAINER_AUTHORIZATION = R.id.fragmentContainerAuthorization;




    // метод добавление фрагмента в контейнер
    public void openFragment(int fragmentContainer, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentContainer, fragment);
        fragmentTransaction.commit();
    }

    // метод замены фрагмента в контейнере
    public void replaceFragment(int fragmentContainer, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
