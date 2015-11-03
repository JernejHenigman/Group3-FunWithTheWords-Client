package com.example.hrust16.group3_funwithwords_client;


import android.graphics.Color;

import com.firebase.client.Firebase;

/**
 * Created by hrust16 on 10/11/15.
 */
public class Constants {
    public static String userName = "Player";
    //Since this is static it will be instansiated  at startup of the App
    //Use static for variables that you want to reach from anywhere in the app...
    public static Firebase myFirebaseRef = new Firebase("https://funwithwords.firebaseio.com/");
    public static int uniqueID = -1;
    public static int color = -1;

}