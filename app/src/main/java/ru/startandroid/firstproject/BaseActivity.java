package ru.startandroid.firstproject;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    public void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainerMain, fragment);
        fragmentTransaction.commit();
    }

}
