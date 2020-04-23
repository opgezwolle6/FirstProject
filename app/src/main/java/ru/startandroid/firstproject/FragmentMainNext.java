package ru.startandroid.firstproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMainNext extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_next, null);

        Button buttonNext = v.findViewById(R.id.btnNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMainExit fragmentMainExit = new FragmentMainExit();
                ((MainActivity) getActivity()).replaceFragment(BaseActivity.FRAGMENT_CONTAINER_MAIN, fragmentMainExit);
            }
        });

        return v;
    }

}
