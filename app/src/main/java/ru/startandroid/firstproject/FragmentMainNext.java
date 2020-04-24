package ru.startandroid.firstproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.startandroid.firstproject.utils.Preferences;

public class FragmentMainNext extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_next, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView helloName = view.findViewById(R.id.tvHelloName);
        Button buttonNext = view.findViewById(R.id.btnNext);

        setTextHelloName(helloName);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMainExit fragmentMainExit = new FragmentMainExit();
                ((MainActivity) getActivity()).replaceFragment(BaseActivity.FRAGMENT_CONTAINER_MAIN, fragmentMainExit);
            }
        });

    }

    public void setTextHelloName(TextView textView){
        Preferences preferences = App.instance.getPreferences();
        textView.setText("Привет, " + preferences.getFirstName() + "!");
    }
}
