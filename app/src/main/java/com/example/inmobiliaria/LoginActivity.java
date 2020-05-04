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
    TextView cartelEmail, cartelContrasenia, tituloEmail, tituloContrasenia;
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
        lvm.getEmail().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
               tituloEmail.setTextColor(Color.parseColor("#03DAC6"));
               tituloContrasenia.setTextColor(0xff000000);
            }
        });
        lvm.getContrasenia().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                tituloContrasenia.setTextColor(Color.parseColor("#03DAC6"));
                tituloEmail.setTextColor(0xff000000);
            }
        });
    }
    private void configurarVista(){
        tituloEmail = findViewById(R.id.tituloEmail);
        tituloContrasenia = findViewById(R.id.tituloContrasenia);
        email = findViewById(R.id.etEmail);
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                lvm.enfocarEmail(hasFocus);
            }
        });
        contrasenia = findViewById(R.id.etContrasenia);
        contrasenia.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                lvm.enfocarContrasenia(hasFocus);
            }
        });
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
