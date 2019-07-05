package com.example.rudratoastlibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RudraToastClass {

    public interface OnDialogClickListener {
        void onDialogImageRunClick(String success);
    }
    static OnDialogClickListener listener;
    public static void s(final Context context, String message,OnDialogClickListener clickListener){

     listener=clickListener;

//        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder.setMessage("Login to SSID") .setTitle("SSID");


        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to close this application ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        listener.onDialogImageRunClick("Hogaya re Baba");

                        Toast.makeText(context,"you choose yes action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        listener.onDialogImageRunClick("Hogaya re Baba,Chaap kyo leta hai");
                        dialog.cancel();

                        Toast.makeText(context,"you choose no action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually

        alert.show();


        // Create custom dialog object
        final Dialog dialog = new Dialog(context);
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog);

        dialog.show();

        Button declineButton = (Button) dialog.findViewById(R.id.button);
        // if decline button is clicked, close the custom dialog
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();

            }
        });
    }

}
