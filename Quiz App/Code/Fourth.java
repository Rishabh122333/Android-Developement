package com.example.acer.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fourth extends AppCompatActivity {
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        t1=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.button4);
        t1.setText("Your Score is"+MainActivity.result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Fourth.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
