package com.michelle.mainapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yarward.yarwardlib.utils.SystemOperationUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("****","test----------------------------");
            }
        }).start();

        ((Button)findViewById(R.id.btn_ota)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemOperationUtils.otaupdate(MainActivity.this,true, Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"update.zip");
            }
        });
    }
}
