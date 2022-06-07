package com.example.acer.bluetooth2;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    boolean bluetooth=false;
    BluetoothAdapter ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        ba=BluetoothAdapter.getDefaultAdapter();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bluetooth==false)
                {
                    ba.enable();
                    bluetooth=true;
                    ib.setImageResource(R.drawable.on);
                }
                else
                {
                    ba.disable();
                    bluetooth=false;
                    ib.setImageResource(R.drawable.off);
                }
            }
        });
    }
}
