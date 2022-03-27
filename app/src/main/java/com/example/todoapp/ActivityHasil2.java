package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHasil2 extends AppCompatActivity {

    TextView txTask, txJenis, txTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil2);

        txTask = findViewById(R.id.txtask);
        txJenis = findViewById(R.id.txjenis);
        txTime = findViewById(R.id.txtime);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String time = bundle.getString("c");

        txTask.setText(task);
        txJenis.setText(jenis);
        txTime.setText(time);
    }
}