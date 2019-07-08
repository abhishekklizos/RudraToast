package com.example.rudratoastlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RudraToastClass {

    public static void getvalidate(Intent success,Activity activity,OnDialogClickListener clickListener) {

        handleSendText(success,activity,clickListener);

    }

    public interface OnDialogClickListener {
        void onDialogImageRunClick(String success);
    }

    static OnDialogClickListener listener;


    public static void s(final Context context, String packg,OnDialogClickListener clickListener){
     listener=clickListener;
        abhis(context);
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


    static void handleSendText(Intent intent,Activity activity,OnDialogClickListener clickListener) {

       intent = activity.getIntent();
        String action = intent.getAction();
        String type = intent.getType();
//        myDialog = new Dialog(this);
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {

                Log.d("Abhsihe",""+sharedText);
//               new  Acynk.RetrieveFeedTask().execute();

                showPopup(activity,sharedText,clickListener);


            } else if (type.startsWith("image/")) {

            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {

            }
        } else {
            // Handle other intents, such as being started from the home screen
        }

    }


    public static void showPopup(Activity context, final String sharedText, final OnDialogClickListener clickListener){

        final Dialog dialog = new Dialog(context);
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog);
        // Set dialog title
        dialog.setTitle("Custom Dialog");

        // set values for custom dialog components - text, image and button

        dialog.show();

        Button declineButton = (Button) dialog.findViewById(R.id.button);
        // if decline button is clicked, close the custom dialog
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                clickListener.onDialogImageRunClick(sharedText);
                dialog.dismiss();
            }
        });
    }


}
