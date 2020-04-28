package ru.startandroid.firstproject;

import android.content.Intent;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class FragmentRegistration extends Fragment {

    public static final String TAG = "myLogs";

    private FirebaseAuth mAuth;


    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etLogin = view.findViewById(R.id.edit_text_login);
        EditText etPassword = view.findViewById(R.id.edit_text_password);
        EditText etRepeatPassword = view.findViewById(R.id.edit_text_repeat_password);

        Button buttonToRegister = view.findViewById(R.id.buttonToRegister);

        mAuth = FirebaseAuth.getInstance();

        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        buttonToRegister.setOnClickListener(v -> {
            if (etPassword.getText().toString().equals(etRepeatPassword.getText().toString())){
                createAccount(etLogin.getText().toString(),etPassword.getText().toString());
            } else {
                Toast.makeText(getActivity(), "Ваши пароли не совпадают",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void createAccount(String email, String password) {

            Log.d(TAG, "createAccount:" + email);

            //showProgressBar();

            // [START create_user_with_email]
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getActivity(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // [START_EXCLUDE]
                            //hideProgressBar();
                            // [END_EXCLUDE]
                        }
                    });


        // [END create_user_with_email]
    }



}


           /*
            if (etPassword.getText() == etRepeatPassword.getText()){
                Preferences preferences = App.instance.getPreferences();
                preferences.saveLogin(etLogin.getText().toString());
                preferences.savePassword(etPassword.getText().toString());
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

             */
