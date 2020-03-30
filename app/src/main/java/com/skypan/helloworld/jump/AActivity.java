package com.skypan.helloworld.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skypan.helloworld.R;

public class AActivity extends AppCompatActivity {
    private Button mBtnJump;
    private Button mBtnJump2;
    private EditText edName,edAge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","----onCreate----");
        Log.d("AActivity","taskid:"+getTaskId()+",hash:"+hashCode());
        logTaskName();
        mBtnJump = findViewById(R.id.jump);
        mBtnJump2 = findViewById(R.id.jump_2);
        edName = findViewById(R.id.ed_name);
        edAge = findViewById(R.id.ed_age);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                String name = edName.getText().toString();
                String age = edAge.getText().toString();
                bundle.putString("name",name);
                bundle.putString("age", age);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);
                //显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);
                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.skypan.helloworld.jump.BActivity");
//                startActivity(intent);
                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.skypan.helloworld.jump.BActivity"));
//                startActivity(intent);
                //隐式
//                Intent intent = new Intent();
//                intent.setAction("com.skypan.test.BActivity");
//                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","----onNewIntent----");
        Log.d("AActivity","taskid:"+getTaskId()+",hash:"+hashCode());
        logTaskName();
    }

    private void logTaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
