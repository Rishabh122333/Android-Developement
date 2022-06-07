package com.example.acer.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Third extends AppCompatActivity {
    Button b1,b2;
    VideoView v1;
    MediaController m1;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button4);
        m1=new MediaController(this);
        v1=(VideoView)findViewById(R.id.videoView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(j,100);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Third.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {
            uri=data.getData();
            v1.setVideoURI(uri);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.start();
        }
        else
        {
            Toast.makeText(Third.this, "Camera not working", Toast.LENGTH_SHORT).show();
        }
    }
}
