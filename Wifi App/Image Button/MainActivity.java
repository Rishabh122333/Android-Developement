package com.example.acer.wifi2;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    private boolean wifi=false;
    WifiManager wm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifi==false)
                {
                    wm.setWifiEnabled(true);
                    wifi=true;
                    ib.setImageResource(R.drawable.on);
                }
                else
                {
                    wm.setWifiEnabled(false);
                    wifi=false;
                    ib.setImageResource(R.drawable.off);
                }

            }
        });
    }
}
