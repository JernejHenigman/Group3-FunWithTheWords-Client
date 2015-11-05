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
    Firebase assignUserRoleFBGameInProgress;
    ValueEventListener aurfb;
    public AssignUserRole() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_assign_user_role, container, false);
        assignUserRoleFB = Constants.myFirebaseRef.child(Constants.userName+"AssignUserRole");
        Constants.myFirebaseRef.child(Constants.userName).setValue("UserAdded");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assignUserRoleFB.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("AssignUserRole", "We are in dataChanged: ");
                Object valueFB = dataSnapshot.getValue();
                if (valueFB != null) {

                    String assignURole = valueFB.toString();
                    Log.i("AssignUserRole", "We are in onDataChange: " + "BLA" + assignURole);
                    Toast.makeText(getActivity(), "" + assignURole, Toast.LENGTH_LONG).show();
                    Log.i("AssignUserRole: ", assignURole);
                    FragmentManager fm;
                    FragmentTransaction ft;

                    switch (Integer.parseInt(assignURole)) {
                        case 0:
                            Log.i("AssignUserRole", "0");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.RED;
                            Toast.makeText(getActivity(), "RED", Toast.LENGTH_LONG).show();
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragmentGameOwner());
                            ft.commit();
                            //assignUserRoleFBGameInProgress.removeEventListener(this);
                            break;
                        case 1:
                            Log.i("AssignUserRole", "1");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.GREEN;
                            Toast.makeText(getActivity(), "GREEN", Toast.LENGTH_LONG).show();
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            // assignUserRoleFBGameInProgress.removeEventListener(this);
                            break;
                        case 2:
                            Log.i("AssignUserRole", "2");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.BLUE;
                            Toast.makeText(getActivity(), "BLUE", Toast.LENGTH_LONG).show();
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            // assignUserRoleFBGameInProgress.removeEventListener(this);
                            break;
                        case 3:
                            Log.i("AssignUserRole", "3");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.YELLOW;
                            Toast.makeText(getActivity(), "YELLOW", Toast.LENGTH_LONG).show();
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            // assignUserRoleFBGameInProgress.removeEventListener(this);
                            break;
                        case 4:
                            Log.i("AssignUserRole", "4");
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            Constants.color = Color.CYAN;
                            Toast.makeText(getActivity(), "CYAN", Toast.LENGTH_LONG).show();
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            //assignUserRoleFBGameInProgress.removeEventListener(this);
                            break;
                        case 5:
                            Log.i("AssignUserRole", "5");
                            Constants.color = Color.DKGRAY;
                            Constants.uniqueID = Integer.parseInt(assignURole);
                            fm = getActivity().getSupportFragmentManager();
                            ft = fm.beginTransaction();
                            ft.replace(R.id.container, new WaitingScreenFragment());
                            ft.commit();
                            //assignUserRoleFBGameInProgress.removeEventListener(this);
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
