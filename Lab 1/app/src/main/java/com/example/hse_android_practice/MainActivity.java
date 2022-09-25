package com.example.hse_android_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView userUrlField;
    Button btnGetSiteName;
    Button btnGoToTheSite;
    String userSiteName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userUrlField = findViewById(R.id.textView);

        btnGetSiteName = findViewById(R.id.btn1);
        btnGetSiteName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startNewActivity();
            }
        });

        btnGoToTheSite = findViewById(R.id.btn2);
        btnGoToTheSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userSiteName != null)
                {
                    Uri address = Uri.parse("http://" + userSiteName);
                    Intent openUrl = new Intent(Intent.ACTION_VIEW, address);
                    startActivity(openUrl);
                }
            }
        });
    }

    int getInfoActivityRequestCode = 16;
    public void startNewActivity()
    {
        Intent intent = new Intent(this, GetInfoActivity.class);
        startActivityForResult(intent, getInfoActivityRequestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent Data) {
        super.onActivityResult(requestCode, resultCode, Data);

        if (requestCode == getInfoActivityRequestCode)
        {
            if (resultCode == RESULT_OK)
            {
                userSiteName = Data.getStringExtra("UserSiteName");
                userUrlField.setText(userSiteName);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("UserSiteName", userSiteName);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        userSiteName = savedInstanceState.getString("UserSiteName");
        userUrlField.setText(userSiteName);
    }

}