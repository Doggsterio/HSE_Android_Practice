package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_NO)
        {
            Toast.makeText(this, "Keyboard is open", Toast.LENGTH_LONG).show();
        }

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this, "Landscape orientation", Toast.LENGTH_LONG).show();
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Toast.makeText(this, "Portrait orientation", Toast.LENGTH_LONG).show();
        }
    }
}