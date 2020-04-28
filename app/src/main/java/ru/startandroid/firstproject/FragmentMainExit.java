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

import com.google.firebase.auth.FirebaseAuth;


public class FragmentMainExit extends Fragment {

    private FirebaseAuth mAuth;
    private Button buttonExit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_exit, null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        buttonExit = view.findViewById(R.id.btnExit);
        buttonExit.setOnClickListener(v -> {
            if (getActivity() != null){
                ((MainActivity)getActivity()).clearLoginAndPassword();
            }
            Intent intent = new Intent(getActivity(), AuthorizationActivity.class);
            startActivity(intent);
            onDestroyView();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAuth.signOut();
    }

}