package com.example.hse_android_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetInfoActivity extends AppCompatActivity {

    EditText textField;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_info);

        textField = findViewById(R.id.editText);
        btnFinish = findViewById(R.id.finish);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.putExtra("UserSiteName", textField.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}