package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ednama, edpassword, edemail, edrepass;
    Button btnLogin, btnRegister;
    String nama, password, email, repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.button);
        btnRegister=findViewById(R.id.button2);
        ednama=findViewById(R.id.ednama);

        edpassword=findViewById(R.id.edpassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = ednama.getText().toString();
                password = edpassword.getText().toString();

                String Nama = "Paldi";
                String Pass = "Pale23";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Nama dan Password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    t.show();

                } else if (nama.equals(Nama) && password.equals(Pass)) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Berhasil",
                            Toast.LENGTH_LONG);

                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a",nama.trim());
                    b.putString("b", password.trim());

                    Intent i = new Intent(getApplicationContext(), ActivityLogin.class);
                    i.putExtras(b);
                    startActivity(i);


                } else if (nama.equals(Nama)) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password Salah", Toast.LENGTH_LONG);
                    t.show();
                } else if (password.equals(Pass)) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Nama Salah", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Salah", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), ActivityDaftar.class);
                startActivity(i);
            }
        });
    }
}