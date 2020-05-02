package ru.startandroid.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.startandroid.firstproject.utils.Preferences;

public class FragmentMainNext extends Fragment {

    private FirebaseAuth mAuth;
    private NavController navController;
    private TextView tvHelloName;
    private Button buttonNext, buttonSend, buttonCall;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_next, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHelloName = view.findViewById(R.id.tvHelloName);
        buttonNext = view.findViewById(R.id.btnNext);
        buttonSend = view.findViewById(R.id.btnSend);
        buttonCall = view.findViewById(R.id.btnCall);


        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        tvHelloName.setText("Привет, " + user.getEmail() + "!");


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentMainExit);
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentSend);
            }
        });

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentCall);
            }
        });

    }

}
