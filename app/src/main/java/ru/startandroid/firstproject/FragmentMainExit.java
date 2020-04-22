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

public class FragmentMainExit extends Fragment {

    final String LOG_TAG = "myLogs";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_exit, null);

        Button buttonExit = v.findViewById(R.id.btnExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null){
                    MainActivity ma = (MainActivity)getActivity();
                    ma.sharedPreferencesIsNull();
                }
                Intent intent = new Intent(getActivity(), AuthorizationActivity.class);
                startActivity(intent);
                onDestroyView();
            }
        });

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
