package com.example.acer.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    Button b1,b2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button3);
        iv=(ImageView)findViewById(R.id.imageView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,8);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Second.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==8)
        {
            Bitmap bm=(Bitmap)data.getExtras().get("data");
            iv.setImageBitmap(bm);
        }
        else
        {
            Toast.makeText(Second.this, "Camera not working", Toast.LENGTH_SHORT).show();
        }
    }
}
