package ru.startandroid.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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


public class FragmentLogin extends Fragment  {

    private static final String TAG = "myLogs";

    private FirebaseAuth mAuth;

    private SpinnerDialog spinnerDialog;

    private NavController navController;
    private EditText etLogin, etPassword;
    private Button buttonGo;
    private TextView tvCheckIn,tvForgotPass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinnerDialog = new SpinnerDialog();

        etLogin = (EditText) view.findViewById(R.id.edit_text_login);
        etPassword = (EditText) view.findViewById(R.id.edit_text_password);

        buttonGo = (Button) view.findViewById(R.id.buttonGo);
        tvCheckIn = (TextView) view.findViewById(R.id.tvCheckIn);
        tvForgotPass = (TextView) view.findViewById(R.id.tvForgotPass);

        mAuth = FirebaseAuth.getInstance();
        etLogin.setText(mAuth.getCurrentUser().getEmail());

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        // ((AuthorizationActivity) getActivity()).loadLoginAndPassword(etLogin, etPassword);


        buttonGo.setOnClickListener(v -> {
            signIn(etLogin.getText().toString(),etPassword.getText().toString());
            // ((AuthorizationActivity) getActivity()).saveLoginAndPassword(etLogin, etPassword);
        });


        tvCheckIn.setOnClickListener(v -> {
            navController.navigate(R.id.fragmentRegistration);
        });

        tvForgotPass.setOnClickListener(v -> {
            navController.navigate(R.id.fragmentForgotPassword);
        });

    }


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);

        spinnerDialog.show(getChildFragmentManager(),"spinnerDialog");
        //showProgressBar();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Проверьте правильность ввода логина или пароля",
                                    Toast.LENGTH_SHORT).show();
                            // [START_EXCLUDE]
                            // [END_EXCLUDE]
                        }

                        //hideProgressBar();
                        spinnerDialog.dismiss();
                    }
                });
        // [END sign_in_with_email]
    }
}
