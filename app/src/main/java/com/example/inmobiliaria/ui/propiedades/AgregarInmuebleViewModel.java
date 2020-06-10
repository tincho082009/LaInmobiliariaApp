package com.example.inmobiliaria.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.modelos.Inmueble;
import com.example.inmobiliaria.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgregarInmuebleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<List<String>> listadoTipos;

    public AgregarInmuebleViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<String>> getListadoTipos(){
        if(listadoTipos == null){
            listadoTipos = new MutableLiveData<>();
        }
        return listadoTipos;
    }

    public void cargarSpinner(){
        List<String> listaTipos = new ArrayList<>();
        listaTipos.add("Casa");
        listaTipos.add("Departamento");
        listaTipos.add("Monoambiente");
        listaTipos.add("Mansion");
        listadoTipos.setValue(listaTipos);
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
