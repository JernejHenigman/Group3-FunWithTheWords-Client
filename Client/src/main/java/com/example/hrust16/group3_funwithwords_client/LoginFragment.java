package com.example.hrust16.group3_funwithwords_client;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;



public class LoginFragment extends Fragment implements ValueEventListener {


    Firebase fb;
    ValueEventListener vel;
    Firebase firebaseEntryForScreenNbr;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View returnView = inflater.inflate(R.layout.fragment_login, container, false);
        View v = returnView.findViewById(R.id.btnLogon);
        Log.i("LoginFragment","we are in onCreateView");
        v.setOnClickListener(new View.OnClickListener() {
            //Click on loginButton
            @Override
            public void onClick(View v) {

                firebaseEntryForScreenNbr = Constants.myFirebaseRef.child("ScreenNbr");
                vel = firebaseEntryForScreenNbr.addValueEventListener(LoginFragment.this);
                v.setClickable(false);

            }
        });
        return returnView;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Object value = dataSnapshot.getValue();
        if (value != null) {
            Log.i("LoginFragmen", "We are in onDataChange: "+value);
            String screenNbrFromFirebase = String.valueOf((long) value);
            EditText screenNumber = (EditText) getActivity().findViewById(R.id.screenNumber);
            EditText name = (EditText) getActivity().findViewById(R.id.name);
            Constants.userName = name.getText().toString();
            //Are we on the right screen
            if (screenNbrFromFirebase.equals(screenNumber.getText().toString()))
            {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new AssignUserRole());
                ft.commit();

            }
            else
            {
                Toast.makeText(getActivity(),"Not the correct Screen",Toast.LENGTH_LONG).show();
            }


        }

    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
