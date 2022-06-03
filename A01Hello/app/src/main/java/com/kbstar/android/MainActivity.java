package com.kbstar.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //R = resource 폴더 의미

        /*
        JS
        bar btn = document.getElementById("btn")
         */
        textview = findViewById(R.id.textView);
        System.out.println("========="+textview.getText().toString());
    }
}