package com.example.inmobiliaria.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.inmobiliaria.modelos.Inmueble;
import com.example.inmobiliaria.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgregarInmuebleViewModel extends AndroidViewModel {
    private Context context;
    public AgregarInmuebleViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void guardar(Inmueble inm){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");

        Call<Inmueble> nuevoInmueble = ApiClient.getMyApiClient().agregarInmueble(t, inm);
        nuevoInmueble.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, "Usuario agregado correctamente", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "Usuario NO AGREGADO", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context, t.getMessage() + "", Toast.LENGTH_LONG).show();
            }
        });

    }
}
