package com.clancy.conor.jerseyapp;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by boutell on 11/14/2015.
 */
public class Item {
    private String mPlayerName;
    private int mJerseyNumber;
    private Boolean mJerseyColor;

    // Empty constructor, set to default (Calendar defaults to todays date
    public Item() {
        mPlayerName = "_ _ _";
        mJerseyNumber = 0;
        mJerseyColor = true;
    }

    // Constructor to initialize the object of the class with a string, int and calendar
    public Item(String name, int number, boolean color) {
        mPlayerName = name;
        mJerseyNumber = number;
        mJerseyColor = color;
    }

    // Default for
    public static Item getDefaultItem()
    {
        return new Item("Android", 17, false);
    }

    public String getName() {
        return mPlayerName;
    }

    public void setName(String name) {
        mPlayerName = name;
    }

    public int getJerseyNumber() {
        return mJerseyNumber;
    }

    public void setPlayerNumber(int number) {
        mJerseyNumber = number;
    }

    // returns string date - used to print out
    public boolean getJerseyColor() {
        return mJerseyColor;

    }

    // gives time in ms
    public void getJerseyColor(boolean color) {

        mJerseyColor = color;
    }

}
