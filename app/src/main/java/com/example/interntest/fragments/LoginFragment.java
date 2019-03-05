package com.example.interntest.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interntest.R;
import com.example.interntest.activities.DashBoard;

import static com.example.interntest.utils.Constants.EMPTY_STRING;
import static com.example.interntest.utils.Constants.PASS_NOT_MATCH;
import static com.example.interntest.utils.SharedPreferenceDetails.getPass;
import static com.example.interntest.utils.SharedPreferenceDetails.getUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private EditText nameET;
    private EditText passwordET;
    private Button signInButton;
    private TextView signUp;
    private Context context;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View loginView;
        loginView = inflater.inflate(R.layout.fragment_login, container, false);

        nameET = (EditText) loginView.findViewById(R.id.name);
        passwordET = (EditText) loginView.findViewById(R.id.password);

        signInButton = (Button) loginView.findViewById(R.id.login);

        signUp = (TextView) loginView.findViewById(R.id.signup);

        signInButton.setOnClickListener(new View.OnClickListener() {
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
                else
                {
                    //Check Shared Preferences
                    if(getUser(context).equals(nameET.getText().toString())  && getPass(context).equals(passwordET.getText().toString()))
                    {
                        Toast.makeText(context, "Sign Ip Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context, DashBoard.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.loginFragment, new SignUpFragment(), "SignUp");
                ft.addToBackStack(null);
                ft.commit();
            }
        });



        return loginView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }
}
