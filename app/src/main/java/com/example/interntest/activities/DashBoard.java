package com.example.interntest.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.interntest.R;
import com.example.interntest.fragments.FragmentHolder;

import static com.example.interntest.utils.Constants.MY_PREFS_NAME;
import static com.example.interntest.utils.Constants.USER;
import static com.example.interntest.utils.SharedPreferenceDetails.getUser;
import static com.example.interntest.utils.SharedPreferenceDetails.storeUserAndPass;
import static com.example.interntest.utils.TableUtils.workshopDataInsertion;

public class DashBoard extends AppCompatActivity {

    private TextView name;
    private Button myDashboard;
    private Button workshopList;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        name = findViewById(R.id.name);
        myDashboard = findViewById(R.id.myWorkshop);
        workshopList = findViewById(R.id.workshopList);
        signOut = findViewById(R.id.signOut);

        String user = getUser(DashBoard.this);
        if(user != null && !TextUtils.isEmpty(user.trim()))
        {
            name.setText(user);
        }
        else
        {
            Intent i = new Intent(DashBoard.this, FragmentHolder.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

        myDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashBoard.this,MyWorkshop.class));
            }
        });

        workshopList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this,Workshops.class));
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DashBoard.this, FragmentHolder.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });


//        for(int i=0;i<10;i++)
//        {
//            workshopDataInsertion(DashBoard.this,"Workshop "+i,"This is Workshop "+i
//            +" This is for only demo purpose . All the datas here are dummy data's for the internship purpose only");
//        }



    }


}
