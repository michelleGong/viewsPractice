package com.yarward.mango.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //150 dp
        float dpValues_150 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,150,getResources().getDisplayMetrics());
    }
}
