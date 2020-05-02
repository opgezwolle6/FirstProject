package ru.startandroid.firstproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCall extends Fragment {

    private EditText etNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_call, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etNumber = view.findViewById(R.id.edit_text_number);
        Button btnCallNumber = view.findViewById(R.id.btnCallInFragment);

        btnCallNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialTheNumber();
            }
        });

    }

    private void dialTheNumber(){
        String number =  "tel:" + etNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
        startActivity(intent);
    }
}
