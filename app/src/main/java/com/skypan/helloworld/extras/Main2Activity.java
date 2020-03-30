package com.skypan.helloworld.extras;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.skypan.helloworld.R;

public class Main2Activity extends AppCompatActivity {
    public int index=0;
    private int[] imagePath = new int[]{
            R.drawable.image1,R.drawable.image2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ImageView img = findViewById(R.id.image_1);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (index==0){
                    index=index+1;
                }else {
                    index=index-1;
                }
                Glide.with(Main2Activity.this).load(imagePath[index]).into(img);
                return false;
            }
        });
    }
}
