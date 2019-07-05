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
