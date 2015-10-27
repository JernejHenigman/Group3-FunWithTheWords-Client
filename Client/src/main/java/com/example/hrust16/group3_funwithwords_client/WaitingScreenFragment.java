package com.example.hrust16.group3_funwithwords_client;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class WaitingScreenFragment extends Fragment implements ValueEventListener{

    Firebase transitToKeyboardFB;
    ValueEventListener ttKbFB;
    public WaitingScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View returnView =  inflater.inflate(R.layout.fragment_waiting_screen, container, false);
        Log.i("WaitingScreenFragment","We are in onCreateView");
        transitToKeyboardFB = Constants.myFirebaseRef.child("GameStart");
        ttKbFB = transitToKeyboardFB.addValueEventListener(WaitingScreenFragment.this);


        return returnView;
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Object value = dataSnapshot.getValue();
        if (value != null) {
            if (value.toString().equals("GameStart")) {
                Log.i("WaitingScreenFragment","We are in on change");
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new KeyboardFragment());
                ft.commit();
            }
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
