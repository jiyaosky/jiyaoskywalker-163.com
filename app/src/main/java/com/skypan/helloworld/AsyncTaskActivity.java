package com.skypan.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.skypan.helloworld.util.MyAsyncTask;

public class AsyncTaskActivity extends AppCompatActivity {
    private TextView tv_title;
    private ProgressBar pgbar;
    private Button btn_updata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        tv_title = findViewById(R.id.tv_title);
        pgbar = findViewById(R.id.pgbar);
        btn_updata = findViewById(R.id.btn_updata);
        btn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myTask = new MyAsyncTask(tv_title,pgbar);
                myTask.execute(1000);
            }
        });
    }
}
