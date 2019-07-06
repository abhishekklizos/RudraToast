package com.example.rudratoastlibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
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

import java.util.ArrayList;

public class RudraToastClass {
    static Dialog myDialog;

    public interface OnDialogClickListener {
        void onDialogImageRunClick(String success);
    }
    static OnDialogClickListener listener;

    public static void s(final Activity context, String message,OnDialogClickListener clickListener){
     listener=clickListener;


        Intent intent = context.getIntent();
        String action = intent.getAction();
        String type = intent.getType();
//        myDialog = new Dialog(this);

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            } else if (type.startsWith("image/")) {
                handleSendImage(intent); // Handle single image being sent
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                handleSendMultipleImages(intent); // Handle multiple images being sent
            }
        } else {
            // Handle other intents, such as being started from the home screen
        }



        abhis(context);

//        // Create custom dialog object
//        final Dialog dialog = new Dialog(context);
//        // Include dialog.xml file
//        dialog.setContentView(R.layout.dialog);
//
//        dialog.show();
//
//        Button declineButton = (Button) dialog.findViewById(R.id.button);
//        // if decline button is clicked, close the custom dialog
//        declineButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onDialogImageRunClick("Hogaya re Baba");
//                // Close dialog
//                dialog.dismiss();
//
//            }
//        });


//        myDialog = new Dialog(context);
//        myDialog.setContentView(R.layout.dialog);
//        Button declineButton = (Button) myDialog.findViewById(R.id.button);
//        declineButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onDialogImageRunClick("Hogaya re Baba");
//
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.setComponent(new ComponentName("com.admin.ssid","com.admin.ssid.ui.login"));
//                context.startActivity(intent);
//            }
//        });
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        myDialog.show();
    }


    public static void abhis(Context context)
    {

        String appName = "SSID";
        String packageName = "com.admin.ssid";
        openApp(context, appName, packageName);
    }

    public static void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName)){


//                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName).putExtra("AppName","com.example.myapplication"));

                Intent sendIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"com.example.myapplication");
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);


            }

            else {Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();}
        else {Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();}
    }


    private static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return false;
    }

    private static boolean isAppEnabled(Context context, String packageName) {
        boolean appStatus = false;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(packageName, 0);
            if (ai != null) {
                appStatus = ai.enabled;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appStatus;
    }


    static void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);


        if (sharedText != null) {
            // Update UI to reflect text being shared
            Log.d("Abhsihe","Nandita"+sharedText);
            listener.onDialogImageRunClick(sharedText);


        }
    }

    static void handleSendImage(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            // Update UI to reflect image being shared
        }
    }

    static void handleSendMultipleImages(Intent intent) {
        ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if (imageUris != null) {
            // Update UI to reflect multiple images being shared
        }
    }

}
