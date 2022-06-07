package com.example.acer.flashlight3;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    CameraManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=(ToggleButton)findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try
            {
                if(b==false)
                {
                    String cameraid=cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraid,true);
                }
                else
                {
                    String cameraid=cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraid,false);
                }
            }
            catch (CameraAccessException e)
            {

            }
            }
        });

    }
}
