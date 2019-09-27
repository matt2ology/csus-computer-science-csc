package com.example.logism_layout_test;

import android.app.Activity;
import android.view.Display;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the current device's screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        setContentView(R.layout.activity_main);
    }
}
