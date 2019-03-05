package com.example.interntest.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interntest.R;
import com.example.interntest.activities.DashBoard;

import static com.example.interntest.utils.Constants.EMPTY_STRING;
import static com.example.interntest.utils.Constants.PASS_NOT_MATCH;
import static com.example.interntest.utils.SharedPreferenceDetails.storeUserAndPass;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    //Declared Global for future Purpose

    private EditText nameET;
    private EditText passwordET;
    private EditText passwordConfirmET;
    private Button signUpButton;
    private Context context;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View signUpView;

        signUpView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        nameET = (EditText) signUpView.findViewById(R.id.name);
        passwordET = (EditText) signUpView.findViewById(R.id.password);
        passwordConfirmET = (EditText) signUpView.findViewById(R.id.confirmPassword);
        signUpButton = (Button) signUpView.findViewById(R.id.signup);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(nameET.getText().toString().trim()))
                {
                    nameET.setError(EMPTY_STRING);
                }
                else if(TextUtils.isEmpty(passwordET.getText().toString().trim()))
                {
                    passwordET.setError(EMPTY_STRING);
                }
                else if(TextUtils.isEmpty(passwordConfirmET.getText().toString().trim()))
                {
                    passwordConfirmET.setError(EMPTY_STRING);
                }
                else
                {
                    if(!passwordET.getText().toString().equals(passwordConfirmET.getText().toString()))
                    {
                        passwordConfirmET.setError(PASS_NOT_MATCH);
                    }
                    else
                    {
                        storeUserAndPass(context,nameET.getText().toString().trim(),passwordET.getText().toString().trim());
                        Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context, DashBoard.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                }
            }
        });

        return signUpView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
