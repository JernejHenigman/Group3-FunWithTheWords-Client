package com.example.hrust16.group3_funwithwords_client;

/**
 * Created by hrust16 on 10/14/15.
 */
public class User {
    private String userName;
    private StringBuffer word;
    private int uniqueID;
    private boolean isWinner;
    private boolean keyboardState;
    private boolean gameAlreadyStarted;

    public User(String userName) {
        this.userName = userName;
        this.word = new StringBuffer();
        this.isWinner = false;
        this.keyboardState = false;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }


    public void addLetter(String letter) {
        this.word.append(letter);
    }

    public void removeLetter() {
        int currentWordLength = word.length();
        if (currentWordLength > 0)
            word.deleteCharAt(currentWordLength - 1);
    }

    public StringBuffer getWord() {
        return word;
    }

    public void resetWord() {
        this.word = new StringBuffer();
    }

    public boolean getWinner() {
        return this.isWinner;
    }

    public void setWinnerTrue() {
        this.isWinner = true;
    }

    public void setWinnerFalse() {
        this.isWinner = false;
    }
    public void setEnableKeybaord() {
        this.keyboardState = true;
    }

    public void setDisableKeybaord() {
        this.keyboardState = false;
    }

    public boolean getKeyboardState() {
         return keyboardState;
    }



}
