package com.skypan.helloworld;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.skypan.helloworld.broadcast.BroadActivity;
import com.skypan.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI,mbtnEvent,mBtnData,mBtnBroad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mbtnEvent = findViewById(R.id.btn_event);
        mBtnData =findViewById(R.id.btn_data);
        mBtnBroad =findViewById(R.id.btn_broadcast);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mbtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroad.setOnClickListener(onClick);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
