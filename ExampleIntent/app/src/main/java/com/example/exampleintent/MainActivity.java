package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,number,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        link = findViewById(R.id.link);

    }

    public void next(View view) {
        //WorkSpace for explicit intent
        //Intent is a class name
        //Intent obj = new Intent(present class, Next class)
        //startActivity(obj)
        String n = name.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("key",n);// n value is stored in a variable key.We will acess it through key.
        //put is used to hold the data to carry from one place to another
        startActivity(i);
    }

    public void dail(View view) {
        //Implicit Intent
        String n = number.getText().toString();
        //Uri - Unified Resource Identifier
        //Phone - tel:
        // web - https://
        // loc - geo:lat,lon
        Uri uri = Uri.parse("tel:"+n);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void search(View view) {
        String n = link.getText().toString();
        Uri uri = Uri.parse("https://"+n);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}