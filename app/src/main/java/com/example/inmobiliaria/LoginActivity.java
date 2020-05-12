package com.example.inmobiliaria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

public class LoginActivity extends AppCompatActivity {
    EditText email, contrasenia;
    TextView cartelEmail, cartelContrasenia;
    Button ingresar;
    LoginViewModel lvm;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configurarVista();
        lvm = new LoginViewModel();
        lvm.getCartelEmail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cartelEmail.setText(s);
                cartelEmail.setTextColor(0xffff0000);
            }
        });
        lvm.getCartelContrasenia().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cartelContrasenia.setText(s);
                cartelContrasenia.setTextColor(0xffff0000);
            }
        });
        lvm.getActivadorIntent().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void configurarVista(){
        email = findViewById(R.id.etEmail);
        contrasenia = findViewById(R.id.etContrasenia);
        ingresar = findViewById(R.id.btnIngresar);
        cartelContrasenia = findViewById(R.id.tvContrasenia);
        cartelEmail = findViewById(R.id.tvEmail);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvm.validar(email.getText().toString(), contrasenia.getText().toString());
            }
        });
    }
}
