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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


/**
 * A simple {@linffk Fragment} subclass.
 */
public class WaitingScreenFragmentGameOwner extends Fragment implements ValueEventListener {

    Firebase numOfPlayersConnectedListener;
    ValueEventListener nopclr;
    int numOfPlayersConnected;
    View startGameButton;


    public WaitingScreenFragmentGameOwner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_waiting_screen_fragment_game_owner, container, false);
        startGameButton = v.findViewById(R.id.buttonStartGame);
        numOfPlayersConnectedListener = Constants.myFirebaseRef.child("AssignUserRole");
        nopclr = numOfPlayersConnectedListener.addValueEventListener(WaitingScreenFragmentGameOwner.this);
        Log.i("WaitingGamerOwner", "We are in onCreateaView");
        startGameButton.setClickable(true);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            //Click on loginButtono
            @Override
            public void onClick(View v) {
                Constants.myFirebaseRef.child("GameStart").setValue("GameStart");

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new KeyboardFragment());
                ft.commit();
                startGameButton.setClickable(false);

            }
        });

        return v;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Object valueFB = dataSnapshot.getValue();
        if (valueFB != null) {
            Log.i("WaitingGamerOwner", "We are in onDataChange: "+valueFB);
            numOfPlayersConnected = Integer.parseInt(valueFB.toString());
            Log.i("NumOfPlayersConnecetd: ",""+numOfPlayersConnected);
            if (numOfPlayersConnected < 1 ) {
                startGameButton.setClickable(false);
            }
            else
            {
                startGameButton.setClickable(true);
            }
        }

    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }



}
