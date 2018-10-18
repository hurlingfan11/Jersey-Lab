package com.clancy.conor.jerseyapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mNameTextView;
    private TextView mNumberTextView;
    private ImageView mImageView;
    private Item mCurrentItem;
    private Item mPreviousItem;
    private Button mButtonColor;
    private boolean buttonColor;
    private ArrayList<Item> mItems;
    private int current_image_index;
    int[] images ={R.drawable.green_jersey, R.drawable.purple_jersey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capture views
        //names in content_main
        // Capture views
        mNameTextView=findViewById(R.id.name_text);
        mNumberTextView=findViewById(R.id.number_text);
        mImageView=(ImageView)findViewById(R.id.image_view);
        mButtonColor = (Button) findViewById(R.id.edit_button);

        mCurrentItem = Item.getDefaultItem();
        showCurrentItem();

        //mCurrentItem.setName("Android");
        //mCurrentItem.setPlayerNumber(17);

        // boiler plate code
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // finding the fab by its ID
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Edit item (Snackbar)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //mItems.add(new Item( "Salah", 20, true ));
                showEditDialog();
                //mCurrentItem = Item.getDefaultItem2();
                //showCurrentItem();
                /*if(!buttonColor)
                    {
                        mImageView.setImageResource(R.drawable.green_jersey);
                        buttonColor =false;
                    }else
                    {
                       mImageView.setImageResource(R.drawable.purple_jersey);
                       buttonColor=true;
                    }
                }
                */
            }
        });
       }

    private void showEditDialog() {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle(R.string.edit);
            View view = getLayoutInflater().inflate(R.layout.dialog_add, null, false);
            alertDialog.setView(view);

            final EditText nameDialogEditText = view.findViewById(R.id.edit_name);
            final EditText numberDialogEditText = view.findViewById(R.id.edit_number);
            final Button colorDialogButton = view.findViewById(R.id.edit_button);

            colorDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorDialogButton.setText("OOOO");
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                //mImageView.setImageResource(R.drawable.purple_jersey);

            }
        });

            nameDialogEditText.setText(mCurrentItem.getName());
            numberDialogEditText.setText(""+mCurrentItem.getJerseyNumber());


            alertDialog.setNegativeButton(android.R.string.cancel,null);
            alertDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //ok button clicked
                    String name = nameDialogEditText.getText().toString();

                    int numberOfJersey = Integer.parseInt(numberDialogEditText.getText().toString());
                    //make the current item

                    String text = (String) colorDialogButton.getText();

                    mCurrentItem.setName(name);
                    mCurrentItem.setPlayerNumber(numberOfJersey);
                    //mCurrentItem.setDeliveryDate(calendar);
                    //buttonClick();
                    mCurrentItem.setButtonText(text);
                    if(buttonColor)
                    {
                        mImageView.setImageResource(R.drawable.green_jersey);
                        //buttonColor =false;
                        //mButtonColor.setText("Green");
                    }else
                    {
                       mImageView.setImageResource(R.drawable.purple_jersey);
                       //buttonColor=true;
                       //mButtonColor.setText("Purple");
                    }
                    // show the current item
                    showCurrentItem();
                }
            });

            alertDialog.create().show();

        }


      private void editItem(final boolean isEdit) {

        AlertDialog.Builder alertDialogEdit = new AlertDialog.Builder(this);

        alertDialogEdit.setTitle(R.string.dialog_title);
        View view = getLayoutInflater().inflate(R.layout.dialog_add, null, false);
        alertDialogEdit.setView(view);

        // if you want to capture edit text field, capture where they added in the name
        // final because it is used in side this private and points to this object and will never change
        // If you use findViewById(R.id.edit_name); it will only search inside the xml file for aactivity main
        // by using view.findViewById(R.id.edit_name); it searches in the local variable view in dialog

        final EditText nameEditText = view.findViewById(R.id.edit_name);
        final EditText numberEditText = view.findViewById(R.id.edit_number);
        final Button colorButton = view.findViewById(R.id.edit_button);


        nameEditText.setText(mCurrentItem.getName());
        numberEditText.setText(""+mCurrentItem.getJerseyNumber());
        colorButton.setText(mCurrentItem.getName());

        alertDialogEdit.setNegativeButton(android.R.string.cancel,null);
        alertDialogEdit.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = nameEditText.getText().toString();
                int number = Integer.parseInt(numberEditText.getText().toString());

                    mCurrentItem.setName(name);
                    mCurrentItem.setPlayerNumber(number);
                    mCurrentItem.setJerseyColor(true);
                    mItems.add(mCurrentItem);

                    showCurrentItem();
            }
        });

        alertDialogEdit.create().show();

    }

    //public void setButtonCol

    private void showCurrentItem() {
        mNameTextView.setText(mCurrentItem.getName());
        mNumberTextView.setText(getString(R.string.number_format, mCurrentItem.getJerseyNumber()));
        //mImageView.setImageResource(mCurrentItem.getJerseyColor());
        //if(mCurrentItem.getJerseyColor()== true){
        //    mImageView.setImageResource()
        //}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // function that gets called when user presses a menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch(item.getItemId())
        {
            case R.id.action_reset:
                mPreviousItem = mCurrentItem;
                // Make a new current item so get rid of it

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                AlertDialog.Builder alertDialogReset = new AlertDialog.Builder(this);
                //Customize the dialog for needs
                // Simple Dialog

                alertDialogReset.setTitle("Reset");
                alertDialogReset.setMessage("Are you sure you want to reset the jersey");
                alertDialogReset.setNegativeButton(android.R.string.cancel,null);
                alertDialogReset.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mCurrentItem = new Item();
                        dialog.dismiss();
                        mImageView.setImageResource(R.drawable.green_jersey);
                        showCurrentItem();
                        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator_layout), "Item Cleared", Snackbar.LENGTH_LONG);
                    }
                });
                alertDialogReset.show();

                mCurrentItem = mPreviousItem;
                showCurrentItem();
                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator_layout), "Reset Action completed", Snackbar.LENGTH_LONG);

                break;
            case R.id.action_settings:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                break;
            case R.id.action_clear_all:
                AlertDialog.Builder alertDialogClearAll = new AlertDialog.Builder(this);
                //alertDialogClearAll.setTitle(getString(R.string.remove_all));
                alertDialogClearAll.setMessage("Are you sure you want to remove all items?");
                alertDialogClearAll.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        mItems.clear();
                    }
                });
                // Add a cancel button
                alertDialogClearAll.setNegativeButton(android.R.string.cancel, null);

                alertDialogClearAll.create().show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    public void SetInitialImage()
    {
        setCurrentDefaultImage();
    }

    private void setCurrentDefaultImage()
    {
        final ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(0);
    }
}
