package ru.startandroid.firstproject;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

}

/*
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
 */
