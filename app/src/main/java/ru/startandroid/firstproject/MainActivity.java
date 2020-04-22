package ru.startandroid.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



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


    @Override
    public void onClick(View v) {
    }
}

