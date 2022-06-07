package com.example.acer.database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                    Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                else
                {
                    SQLiteDatabase sql=openOrCreateDatabase("india",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists student (name varchar,email varchar,password varchar)");
                    String s4="select * from student where email='"+s1+"' and password='"+s2+"'";
                    Cursor c1=sql.rawQuery(s4,null);
                    if(c1.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(MainActivity.this,Third.class);
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
