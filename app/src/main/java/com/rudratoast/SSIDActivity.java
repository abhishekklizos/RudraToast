package com.rudratoast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rudratoastlibrary.RudraToastClass;

public class SSIDActivity extends AppCompatActivity {
    RudraToastClass.OnDialogClickListener listener;
    RudraToastClass rudraToastClass=new RudraToastClass();

    static OnDialogClickListener clickListener;

    public static void getvalidate(Intent success, SSIDActivity activity, OnDialogClickListener clickListe) {
        clickListener=clickListe;
    }

    public interface OnDialogClickListener {
        void OnDialogClickListener(Activity activity,String success);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.ssid_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rudraToastClass.s(SSIDActivity.this,getApplicationContext().getPackageName(),listener);
                Log.d("TAG", "Clicked Button 1");
            }
        });


        listener=new RudraToastClass.OnDialogClickListener() {
            @Override
            public void onDialogImageRunClick(String success) {

                Log.d("Abhsihe","---------------------------------------------------"+success);


                clickListener.OnDialogClickListener(SSIDActivity.this,success);

            }
        };


        rudraToastClass.getvalidate(getIntent(),this,listener);

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

}
