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
    static Dialog myDialog;

    public interface OnDialogClickListener {
        void onDialogImageRunClick(String success);
    }
    static OnDialogClickListener listener;

    public static void s(final Context context, String message,OnDialogClickListener clickListener){
     listener=clickListener;




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

                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
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

    public static class ActionReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.android.test2.Main2method".equalsIgnoreCase(intent.getAction())) {
                listener.onDialogImageRunClick("Hogaya re Baba");
            }
        }
    }


}
