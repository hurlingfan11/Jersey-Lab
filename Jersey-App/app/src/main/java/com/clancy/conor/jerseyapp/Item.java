package com.clancy.conor.jerseyapp;


import java.security.KeyStore;

/**
 * Created by boutell on 11/14/2015.
 */
public class Item {
    private String mPlayerName;
    private int mJerseyNumber;
    private Boolean mJerseyColor;
    private String mButtonText;

    // Empty constructor, set to default (Calendar defaults to todays date
    public Item() {
        mPlayerName = "Android";
        mJerseyNumber = 17;
        mJerseyColor = true;
        mButtonText = "Green";
    }

    // Constructor to initialize the object of the class with a string, int and calendar
    public Item(String name, int number, boolean color, String text) {
        mPlayerName = name;
        mJerseyNumber = number;
        mJerseyColor = color;
        mButtonText = text;
    }

    // Default for
    public static Item getDefaultItem()
    {
        return new Item("Android", 17, false, "Green");
    }

    public static Item getDefaultItem2(){
        return new Item("Clancy", 14, false, "Purple");
    }

    public String getName()
    {

        return mPlayerName;
    }

    public void setName(String name)
    {
        mPlayerName = name;
    }

    public int getJerseyNumber()
    {
        return mJerseyNumber;
    }

    public void setPlayerNumber(int number)
    {
        mJerseyNumber = number;
    }

    // returns string date - used to print out
    public boolean getJerseyColor()
    {
        return mJerseyColor;

    }

    public void setJerseyColor(boolean color) {

        mJerseyColor = color;
    }

    public void setButtonText(String text){
        mButtonText = text;

    }

    public String getmButtonText(){
        return mButtonText;
    }
}
