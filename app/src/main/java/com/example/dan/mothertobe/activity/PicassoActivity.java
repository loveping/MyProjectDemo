package com.example.dan.mothertobe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dan.mothertobe.R;
import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {

    private Button btn_picasso;
    private ImageView img_picasso;
    private final String IMG_PATH = "http://img1.3lian.com/2015/w7/85/d/105.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        btn_picasso = (Button)findViewById(R.id.btn_picasso);
        img_picasso = (ImageView)findViewById(R.id.img_picasso);

        btn_picasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fit()是自动填充布局
                Picasso.with(PicassoActivity.this).load(IMG_PATH).fit().into(img_picasso);
            }
        });
    }
}
