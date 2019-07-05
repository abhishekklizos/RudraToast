package com.example.rudratoastlibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class RudraToastClass {

    public interface OnDialogClickListener {
        void onDialogImageRunClick(String success);
    }
    static OnDialogClickListener listener;
    static PopupWindow mpopup;
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
                listener.onDialogImageRunClick("Hogaya re Baba");
                // Close dialog
                dialog.dismiss();

            }
        });
    }

    public static void getPopUpForUserDetail(final Activity context, String message, OnDialogClickListener clickListener){
        listener=clickListener;
        View popUpView = context.getLayoutInflater().inflate(R.layout.view_popup_layout,
                null); // inflating popup layout
        mpopup = new PopupWindow(popUpView, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, true); // Creation of popup
        mpopup.setAnimationStyle(android.R.style.Animation_Dialog);
        mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);

        Button btnCancel = (Button) popUpView.findViewById(R.id.button);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onDialogImageRunClick("Hogaya re Baba");
            }
        });




    }

}
