package ru.startandroid.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment implements View.OnClickListener {
    Button btnNext;
    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment1, null);

        btnNext = (Button) v.findViewById(R.id.btnNext);

        return v;
    }


    @Override
    public void onClick(View v) {
        fragmentTransaction = getFragmentManager().beginTransaction();
    }
}
