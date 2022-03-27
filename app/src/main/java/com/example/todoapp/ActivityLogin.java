package com.example.todoapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

public class ActivityLogin extends AppCompatActivity {

    EditText edttask, edtjenis, edttime;
    FloatingActionButton fab;
    String task, jenis, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edttask = findViewById(R.id.edtask);
        edtjenis = findViewById(R.id.edtjtask);
        edttime = findViewById(R.id.edtltask);

        fab = findViewById(R.id.fbutton2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task = edttask.getText().toString();
                jenis = edtjenis.getText().toString();
                time = edttime.getText().toString();

                if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
                    Snackbar.make(view, "Isi Semua Data!", Snackbar.LENGTH_LONG).show();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Berhasil", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", task.trim());
                    b.putString("b", jenis.trim());
                    b.putString("c", time.trim());

                    Intent i = new Intent(getApplicationContext(), ActivityHasil2.class);
                    i.putExtras(b);
                    startActivity(i);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId()== R.id.psubmit)
            task = edttask.getText().toString();
            jenis = edtjenis.getText().toString();
            time = edttime.getText().toString();

        if (edttask.getText().toString().length()==0){
            edttask.setError("Task Diperlukan!!!!!");
        }
        if (edtjenis.getText().toString().length()==0){
            edtjenis.setError("Jenis Task Diperlukan!!!!!");
        }
        if (edttime.getText().toString().length()==0){
            edttime.setError("Time Task Diperlukan!!!!!");
        }
        if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Isi semua data!!!", Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Berhasil", Toast.LENGTH_LONG);
            t.show();

            Bundle b = new Bundle();

            b.putString("a", task.trim());
            b.putString("b", jenis.trim());
            b.putString("c", time.trim());
            Intent i = new Intent(getApplicationContext(), com.example.todoapp.ActivityHasil.class);
            i.putExtras(b);
            startActivity(i);
        }
        if (item.getItemId() == R.id.plogout) {
            Intent l = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(l);
        }

        return super.onOptionsItemSelected(item);
    }

}
