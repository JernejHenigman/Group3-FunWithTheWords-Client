package com.example.hrust16.group3_funwithwords_client;



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
public class AssignUserRole extends Fragment implements ValueEventListener {

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
        aurfb = assignUserRoleFB.addValueEventListener(AssignUserRole.this);
        Log.i("AssignUserRole", "We are in onCreateView");
        return v;
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Object valueFB = dataSnapshot.getValue();
        if (valueFB != null) {
            String assignURole = valueFB.toString();
            Log.i("AssignUserRole", "We are in onDataChange: "+assignURole);
            Log.i("AssignUserRole: ",assignURole);
            if (assignURole.equals("0"))
            { // if gameOwner
                //MasterUser
                //GameOwnerFragment
                Constants.uniqueID = Integer.parseInt(assignURole);
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new WaitingScreenFragmentGameOwner());
                ft.commit();

            }
            else if (assignURole.toString().equals("-1"))
            {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new GameInProgress());
                ft.commit();
                Constants.myFirebaseRef.child(Constants.userName).removeValue();

            }

            else
            { //If normal player
                Log.i("AssignUserRole",""+assignURole);
                Constants.uniqueID = Integer.parseInt(assignURole);
                Log.i("getActivity: ",""+getActivity());
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new WaitingScreenFragment());
                ft.commit();


            }
            assignUserRoleFB.removeEventListener(aurfb);
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
