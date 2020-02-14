package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MulticastSocket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView textView = (TextView)findViewById(R.id.textView);
//        textView.setOnClickListener(new View.OnClickListener() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Clicked client");
//                MultiThreadFactory.ClientThread ct = new MultiThreadFactory.ClientThread();
//                ct.start();
//                MultiThreadFactory.ServerThread st = new MultiThreadFactory.ServerThread();
//                st.start();
//            }
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CrossZero.class));
}
        });
    }
}
