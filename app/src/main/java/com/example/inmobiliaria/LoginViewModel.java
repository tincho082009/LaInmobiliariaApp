package com.example.inmobiliaria;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.modelos.Usuario;
import com.example.inmobiliaria.request.ApiClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<String> cartelEmail;
    private  MutableLiveData<String> cartelContrasenia;
    private Context contexto;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        contexto = getApplication().getApplicationContext();
    }

    public LiveData<String> getCartelEmail(){
        if(cartelEmail==null){
            cartelEmail =  new MutableLiveData<String>();
        }
        return cartelEmail;
    }

    public LiveData<String> getCartelContrasenia(){
        if(cartelContrasenia==null){
            cartelContrasenia= new MutableLiveData<String>();
        }
        return cartelContrasenia;
    }

    public void validar(String email, String clave) {
        final int cantMail = email.length();
        final int cantContra = clave.length();
        if (cantMail <= 0) {
            cartelEmail.setValue("*Obligatorio");
        }else{
            cartelEmail.setValue("");
        }
        if (cantContra <= 0) {
            cartelContrasenia.setValue("*Obligatorio");
        }else{
            cartelEmail.setValue("");
        }
        Usuario u = new Usuario();
        u.setClave(clave);
        u.setEmail(email);
        Call<String> token = ApiClient.getMyApiClient().loginPropietario(u);
        token.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    SharedPreferences pref= contexto.getSharedPreferences("token",0);
                    SharedPreferences.Editor editor= pref.edit();
                    String t = "Bearer "+response.body();
                    editor.putString("token",t);
                    editor.commit();

                    Intent i = new Intent(getApplication().getApplicationContext(), MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplication().startActivity(i);
                }else{
                    try {
                        if(cantMail > 0 && cantContra >0){
                            cartelEmail.setValue(response.errorBody().string());
                            cartelContrasenia.setValue("");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplication().getApplicationContext(), t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }
}