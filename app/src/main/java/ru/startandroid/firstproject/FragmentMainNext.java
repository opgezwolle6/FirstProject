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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.startandroid.firstproject.utils.Preferences;

public class FragmentMainNext extends Fragment {

    private NavController navController;
    private TextView helloName;
    private Button buttonNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_next, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helloName = view.findViewById(R.id.tvHelloName);
        buttonNext = view.findViewById(R.id.btnNext);
        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        setTextHelloName(helloName);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentMainExit);
            }
        });

    }

    private void setTextHelloName(TextView textView){
        Preferences preferences = App.instance.getPreferences();
        textView.setText("Привет, " + preferences.getFirstName() + "!");
    }
}
