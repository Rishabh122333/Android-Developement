package com.example.acer.flashlight2;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    boolean torch=false;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton2);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (torch == false) {
                    try {
                        String cameraid=cm.getCameraIdList()[0];
                        cm.setTorchMode(cameraid,true);
                        torch=true;
                        ib.setImageResource(R.drawable.on);
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
                else
                {
                    try {
                        String cameraid=cm.getCameraIdList()[0];
                        cm.setTorchMode(cameraid,false);
                        torch=false;
                        ib.setImageResource(R.drawable.off);
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
            }
        });
    }
}
