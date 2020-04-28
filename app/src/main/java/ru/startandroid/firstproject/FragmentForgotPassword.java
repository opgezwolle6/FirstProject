package ru.startandroid.firstproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentForgotPassword extends Fragment {

    private static final String TAG = "myLogs";

    private FirebaseAuth mAuth;

    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forgot_password, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etEmail = (EditText) view.findViewById(R.id.edit_text_email);
        Button btnRemindPassword = (Button) view.findViewById(R.id.buttonRemindPassword);

        mAuth = FirebaseAuth.getInstance();

        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        btnRemindPassword.setOnClickListener(v -> {
            sendPassword(etEmail.getText().toString());
        });


    }

    public void sendPassword(String emailAddress){

        mAuth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Пароль был успешно выслан на ваш почтовый адрес.",Toast.LENGTH_LONG).show();
                            navController.navigate(R.id.fragmentLogin);
                        } else {
                            Toast.makeText(getActivity(), "Пользователя с таким email не существует",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
