package com.example.hrust16.group3_funwithwords_client;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.os.Vibrator;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment implements ValueEventListener {

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

    LinearLayout background;



    int change;
    Random rand;
    Vibrator vibrator;
    int wordCounter = 0;
    User mUser;
    Firebase enKey;
    ValueEventListener enbKeyB;


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

        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        ButtonInitializer();

        mUser = new User(Constants.userName);
        change = 1;
        rand = new Random();
        background = (LinearLayout)view.findViewById(R.id.keyboard_background);
        background.setBackgroundColor(Constants.colors[Constants.uniqueID]);
        HideKeyboard();

        enKey = Constants.myFirebaseRef.child("InfoToClient");
        enbKeyB = enKey.addValueEventListener(KeyboardFragment.this);
        Log.i("KeyBoardFragment","We are in onCreateView");



        return view;
    }

    public void HideKeyboard()
    {
        InputMethodManager mgr = (InputMethodManager)getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);

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

    public void ChangeBackgroundcolor(int color)
    {
        if(color == 0)
        {
            background.setBackgroundColor(Color.RED);
        }
        if(color == 1)
        {
            background.setBackgroundColor(Color.GREEN);
        }
        if(color == 2)
        {
            background.setBackgroundColor(Color.YELLOW);
        }
        if(color == 3)
        {
            background.setBackgroundColor(Color.BLUE);
        }
        if(color == 4)
        {
            background.setBackgroundColor(Color.MAGENTA);
        }
        if(color == 5)
        {
            background.setBackgroundColor(Color.LTGRAY);
        }
    }

    public void DefaultKeyboard()
    {
        btnA.setText("A");
        btnB.setText("B");
        btnC.setText("C");
        btnD.setText("D");
        btnE.setText("E");

        btnF.setText("F");
        btnG.setText("G");
        btnH.setText("H");
        btnI.setText("I");
        btnJ.setText("J");

        btnK.setText("K");
        btnL.setText("L");
        btnM.setText("M");
        btnN.setText("N");
        btnO.setText("O");

        btnP.setText("P");
        btnQ.setText("Q");
        btnR.setText("R");
        btnS.setText("S");
        btnT.setText("T");

        btnU.setText("U");
        btnV.setText("V");
        btnW.setText("W");
        btnX.setText("X");
        btnY.setText("Y");
        btnZ.setText("Z");

        ButtonInitializer();
    }

    public void ChangeKeyboard(int change)
    {
        if(change == 1) {
            btnA.setText("W");
            btnB.setText("U");
            btnC.setText("C");
            btnD.setText("M");
            btnE.setText("V");

            btnF.setText("I");
            btnG.setText("G");
            btnH.setText("X");
            btnI.setText("F");
            btnJ.setText("J");

            btnK.setText("P");
            btnL.setText("Q");
            btnM.setText("D");
            btnN.setText("Y");
            btnO.setText("S");

            btnP.setText("K");
            btnQ.setText("L");
            btnR.setText("Z");
            btnS.setText("O");
            btnT.setText("T");

            btnU.setText("B");
            btnV.setText("E");
            btnW.setText("A");
            btnX.setText("H");
            btnY.setText("N");
            btnZ.setText("R");
        }

        if(change == 2) {
            btnA.setText("B");
            btnB.setText("E");
            btnC.setText("A");
            btnD.setText("H");
            btnE.setText("N");

            btnF.setText("J");
            btnG.setText("F");
            btnH.setText("X");
            btnI.setText("G");
            btnJ.setText("I");

            btnK.setText("K");
            btnL.setText("L");
            btnM.setText("Z");
            btnN.setText("O");
            btnO.setText("T");

            btnP.setText("P");
            btnQ.setText("Q");
            btnR.setText("D");
            btnS.setText("Y");
            btnT.setText("S");

            btnU.setText("W");
            btnV.setText("U");
            btnW.setText("C");
            btnX.setText("M");
            btnY.setText("V");
            btnZ.setText("R");
        }

        if(change == 3) {
            btnA.setText("B");
            btnB.setText("E");
            btnC.setText("A");
            btnD.setText("H");
            btnE.setText("N");

            btnF.setText("J");
            btnG.setText("F");
            btnH.setText("X");
            btnI.setText("G");
            btnJ.setText("I");

            btnK.setText("K");
            btnL.setText("L");
            btnM.setText("Z");
            btnN.setText("O");
            btnO.setText("T");

            btnP.setText("P");
            btnQ.setText("Q");
            btnR.setText("D");
            btnS.setText("Y");
            btnT.setText("S");

            btnU.setText("W");
            btnV.setText("U");
            btnW.setText("C");
            btnX.setText("M");
            btnY.setText("V");
            btnZ.setText("R");
        }

        wordCounter = 0;
        ButtonInitializer();
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Object valueFromFB = dataSnapshot.getValue();
        if (valueFromFB != null) {
            String stringValueFB = valueFromFB.toString();
            Log.i("KeyBoardFragment","We are in dataChange: "+stringValueFB);
            if (stringValueFB.equals("True")) // enable keyBoard
            {

                mUser.setEnableKeybaord();
                Log.i("KEYe", "KeyboardEnabled");

            }
            else if (stringValueFB.equals("False")) //Disable keybaord
            {
                mUser.setDisableKeybaord();
                Log.i("KEYd", "KeyboardDisabled");
            }
            else if (stringValueFB.equals("NewRound")) //New round
            {
                mUser.setWinnerFalse();
                mUser.resetWord();
                DefaultKeyboard();
            }
            else if (stringValueFB.equals("GameIsFinished"))
            {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new Results());
                ft.commit();
                enKey.removeEventListener(enbKeyB);

            }

            else // If none of the above, then client recieves unique number of winning player
            {
                if (Integer.parseInt(stringValueFB) == Constants.uniqueID) { //if winner
                    mUser.setWinnerTrue();
                }
                else //if not winner, keybaord gets scrambled
                {
                    if (change == 1) {
                        change = 2;
                    }
                    else if (change == 2)
                    {
                        change = 3;
                    }
                    else if (change == 3)
                    {
                        change = 1;
                    }
                    if (!mUser.getWinner()) {
                        Log.i("Change: ",""+change);
                        vibrator.vibrate(500);
                        ChangeKeyboard(change);
                    }
                }
            }

        }
    }


    @Override
    public void onCancelled(FirebaseError firebaseError) {

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
            if (mUser.getKeyboardState() && !mUser.getWinner()) {
                mUser.addLetter(buttonText);
                Constants.myFirebaseRef.child(Constants.userName).child("KeyboardEvent").setValue(mUser.getWord());
            }

        }
    }

    private class BLDelete implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (mUser.getKeyboardState() && !mUser.getWinner() ) {
                mUser.removeLetter();
                Constants.myFirebaseRef.child(Constants.userName).child("KeyboardEvent").setValue(mUser.getWord());

            }

        }
    }

}
