package com.example.hrust16.group3_funwithwords_client;



import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class AssignUserRole extends Fragment {

    Firebase assignUserRoleFB;
    ValueEventListener aurfb;
    public AssignUserRole() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_assign_user_role, container, false);
        Constants.myFirebaseRef.child(Constants.userName).setValue("UserAdded");
        assignUserRoleFB = Constants.myFirebaseRef.child("AssignUserRole");

        assignUserRoleFB.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object valueFB = dataSnapshot.getValue();
                if (valueFB != null) {

                    String assignURole = valueFB.toString();
                    Log.i("AssignUserRole", "We are in onDataChange: "+assignURole);
                    Log.i("AssignUserRole: ", assignURole);
                    FragmentManager fm;
                    FragmentTransaction ft;

                    switch (Integer.parseInt(assignURole)) {
                        case -1:
                            Log.i("AssignUserRole","-1");
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new GameInProgress());
                            ft.commit();
                            Constants.myFirebaseRef.child(Constants.userName).removeValue();
                            break;
                        case 0:
                            Log.i("AssignUserRole","0");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.RED;
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragmentGameOwner());
                            ft.commit();
                            break;
                        case 1:
                            Log.i("AssignUserRole","1");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.GREEN;
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            break;
                        case 2:
                            Log.i("AssignUserRole","2");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.BLUE;
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            break;
                        case 3:
                            Log.i("AssignUserRole","3");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.YELLOW;
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            break;
                        case 4:
                            Log.i("AssignUserRole","4");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.CYAN;
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            break;
                        case 5:
                            Log.i("AssignUserRole","5");
                            Constants.color = Color.DKGRAY;
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            break;
                    }

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });


        return v;
    }



}
