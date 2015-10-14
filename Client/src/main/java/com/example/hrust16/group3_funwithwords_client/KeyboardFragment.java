package com.example.hrust16.group3_funwithwords_client;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;


/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment {

    View view;

    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnE;
    Button btnF;
    Button btnG;
    Button btnH;
    Button btnI;
    Button btnJ;
    Button btnK;
    Button btnL;
    Button btnM;
    Button btnN;
    Button btnO;
    Button btnP;
    Button btnQ;
    Button btnR;
    Button btnS;
    Button btnT;
    Button btnU;
    Button btnV;
    Button btnW;
    Button btnX;
    Button btnY;
    Button btnZ;

    Button btnDelete;

    EditText etWord;
    TextView tvWord;
    String[] incoming = new String[20];
    int change = 0;
    String word = "WELCOME";


    public KeyboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_keyboard, container, false);

        btnQ = (Button)view.findViewById(R.id.btn_1);
        btnW = (Button)view.findViewById(R.id.btn_2);
        btnE = (Button)view.findViewById(R.id.btn_3);
        btnR = (Button)view.findViewById(R.id.btn_4);
        btnT = (Button)view.findViewById(R.id.btn_5);
        btnY = (Button)view.findViewById(R.id.btn_6);
        btnU = (Button)view.findViewById(R.id.btn_7);
        btnI = (Button)view.findViewById(R.id.btn_8);
        btnO = (Button)view.findViewById(R.id.btn_9);
        btnP = (Button)view.findViewById(R.id.btn_10);

        btnA = (Button)view.findViewById(R.id.btn_11);
        btnS = (Button)view.findViewById(R.id.btn_12);
        btnD = (Button)view.findViewById(R.id.btn_13);
        btnF = (Button)view.findViewById(R.id.btn_14);
        btnG = (Button)view.findViewById(R.id.btn_15);
        btnH = (Button)view.findViewById(R.id.btn_16);
        btnJ = (Button)view.findViewById(R.id.btn_17);
        btnK = (Button)view.findViewById(R.id.btn_18);
        btnL = (Button)view.findViewById(R.id.btn_19);

        btnZ = (Button)view.findViewById(R.id.btn_20);
        btnX = (Button)view.findViewById(R.id.btn_21);
        btnC = (Button)view.findViewById(R.id.btn_22);
        btnV = (Button)view.findViewById(R.id.btn_23);
        btnB = (Button)view.findViewById(R.id.btn_24);
        btnN = (Button)view.findViewById(R.id.btn_25);
        btnM = (Button)view.findViewById(R.id.btn_26);

        btnDelete = (Button)view.findViewById(R.id.btn_99);

        etWord = (EditText)view.findViewById(R.id.et_word);
        tvWord = (TextView)view.findViewById(R.id.tv_word);

        tvWord.setText(word);
        ButtonInitializer();

        Firebase fireBaseEntryForMyID = Constants.myFirebaseRef.child(Constants.userName);

        return view;
    }

    public void ButtonInitializer()
    {
        //btnH.setOnClickListener(new BLH());
        btnA.setOnClickListener(new BLAdd(btnA.getText().toString()));
        btnB.setOnClickListener(new BLAdd(btnB.getText().toString()));
        btnC.setOnClickListener(new BLAdd(btnC.getText().toString()));
        btnD.setOnClickListener(new BLAdd(btnD.getText().toString()));
        btnE.setOnClickListener(new BLAdd(btnE.getText().toString()));
        btnF.setOnClickListener(new BLAdd(btnF.getText().toString()));
        btnG.setOnClickListener(new BLAdd(btnG.getText().toString()));

        btnH.setOnClickListener(new BLAdd(btnH.getText().toString()));
        btnI.setOnClickListener(new BLAdd(btnI.getText().toString()));
        btnJ.setOnClickListener(new BLAdd(btnJ.getText().toString()));
        btnK.setOnClickListener(new BLAdd(btnK.getText().toString()));
        btnL.setOnClickListener(new BLAdd(btnL.getText().toString()));
        btnM.setOnClickListener(new BLAdd(btnM.getText().toString()));
        btnN.setOnClickListener(new BLAdd(btnN.getText().toString()));

        btnO.setOnClickListener(new BLAdd(btnO.getText().toString()));
        btnP.setOnClickListener(new BLAdd(btnP.getText().toString()));
        btnQ.setOnClickListener(new BLAdd(btnQ.getText().toString()));
        btnR.setOnClickListener(new BLAdd(btnR.getText().toString()));
        btnS.setOnClickListener(new BLAdd(btnS.getText().toString()));
        btnT.setOnClickListener(new BLAdd(btnT.getText().toString()));
        btnU.setOnClickListener(new BLAdd(btnU.getText().toString()));

        btnV.setOnClickListener(new BLAdd(btnV.getText().toString()));
        btnW.setOnClickListener(new BLAdd(btnW.getText().toString()));
        btnX.setOnClickListener(new BLAdd(btnX.getText().toString()));
        btnY.setOnClickListener(new BLAdd(btnY.getText().toString()));
        btnZ.setOnClickListener(new BLAdd(btnZ.getText().toString()));

        btnDelete.setOnClickListener(new BLDelete());
    }

    private class BLAdd implements View.OnClickListener {

        String key = null;

        public BLAdd(String key)
        {
            this.key = key;
        }

        @Override
        public void onClick(View v)
        {

            Button b = (Button) v;
            String buttonText = b.getText().toString();
            Constants.myFirebaseRef.child(Constants.userName).child("Letter").setValue(buttonText);


        }
    }

    private class BLDelete implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Constants.myFirebaseRef.child(Constants.userName).child("DeleteButton").setValue("del1");
            Log.i("Delete", "Delete");
        }
    }



}
