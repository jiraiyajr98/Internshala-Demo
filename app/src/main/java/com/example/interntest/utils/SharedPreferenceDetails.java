package com.example.interntest.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static com.example.interntest.utils.Constants.MY_PREFS_NAME;
import static com.example.interntest.utils.Constants.PASSWORD;
import static com.example.interntest.utils.Constants.USER;

public class SharedPreferenceDetails {

    //Store UserID and Password

    public static void storeUserAndPass(Context context ,String user, String password){

        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(USER, user);
        editor.putString(PASSWORD, password);
        editor.apply();
    }

    public static String getUser(Context context ){
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(USER, "");
    }
    public static String getPass(Context context ){
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(PASSWORD, "");
    }

//
//    private void getSSIDPassLocal(){
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//        localBrockerSSID = prefs.getString(LOCAL_BROKER_SSID, "");
//        localBrokerPass = prefs.getString(LOCAL_BROKER_PASS, "");
//
//    }
}
