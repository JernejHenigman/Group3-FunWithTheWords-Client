package com.example.hrust16.group3_funwithwords_client;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Results extends Fragment {


    public Results() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_results, container, false);
        View reconnectBtn = v.findViewById(R.id.newGameBtn);
        Log.i("ResultsFragment", "We are in onCreateView");

        reconnectBtn.setOnClickListener(new View.OnClickListener() {
            //Click on loginButton
            @Override
            public void onClick(View v) {


                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new LoginFragment());
                ft.commit();

            }
        });
        return v;
    }


}
