package com.example.testimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this,information.class);
        startActivity(intent);
    }

    public void onClickLan(View view) {
    }

    public void onClickSetting(View view) {
    }

    public void onClickQuit(View view) {
    }
}