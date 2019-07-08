package com.rudratoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rudratoastlibrary.RudraToastClass;

public class SSIDActivity extends AppCompatActivity {

    RudraToastClass.OnDialogClickListener listener;
    RudraToastClass rudraToastClass=new RudraToastClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.ssid_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rudraToastClass.s(SSIDActivity.this,"",listener);
                Log.d("TAG", "Clicked Button 1");
            }
        });

    }
}
