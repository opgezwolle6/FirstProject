package ru.startandroid.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;


public class AuthorizationActivity extends AppCompatActivity  {

    Fragment3 fragment3;
    Fragment4 fragment4;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainerAuthorization, fragment3);
        fragmentTransaction.commit();
    }

}
