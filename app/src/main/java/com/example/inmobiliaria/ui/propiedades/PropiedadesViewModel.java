package com.example.inmobiliaria.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Inmueble;
import com.example.inmobiliaria.request.ApiClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropiedadesViewModel extends AndroidViewModel {
    private MutableLiveData<Inmueble> inmuebleMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private boolean alquilada;
    private Inmueble inm1 ;
    private MutableLiveData<String> cartel;
    private MutableLiveData<List<String>> listaDirecciones;
    private Context context;
    private MutableLiveData<List<String>> listadoTipos;

    public PropiedadesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Inmueble> getInmueble(){
        if(inmuebleMutableLiveData == null) {
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }

    public LiveData<List<String>> getListadoTipos(){
        if(listadoTipos == null){
            listadoTipos = new MutableLiveData<>();
        }
        return listadoTipos;
    }

    public LiveData<String> getCartel(){
        if(cartel ==null){
            cartel = new MutableLiveData<>();
        }
        return cartel;
    }

    public LiveData<Boolean> getEstado(){
        if(estado == null) {
            estado = new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton(){
        if(textoBoton == null) {
            textoBoton = new MutableLiveData<>();
        }
        return textoBoton;
    }

    public void rellenar(Inmueble inm){
        List<String> listaTipos = new ArrayList<>();
        inm1 = inm;
        inmuebleMutableLiveData.setValue(inm);
        estado.setValue(false);
        switch (inm.getTipo()){
            case "Casa":
                listaTipos.add("Casa");
                listaTipos.add("Departamento");
                listaTipos.add("Monoambiente");
                listaTipos.add("Mansion");
            break;
            case "Departamento":
                listaTipos.add("Departamento");
                listaTipos.add("Casa");
                listaTipos.add("Monoambiente");
                listaTipos.add("Mansion");
                break;
            case "Monoambiente":
                listaTipos.add("Monoambiente");
                listaTipos.add("Departamento");
                listaTipos.add("Casa");
                listaTipos.add("Mansion");
                break;
            case "Mansion":
                listaTipos.add("Mansion");
                listaTipos.add("Monoambiente");
                listaTipos.add("Departamento");
                listaTipos.add("Casa");
                break;
        }
        listadoTipos.setValue(listaTipos);
        alquilada = !inm.isAlquilada();

    }

    public void editar(){
        if(estado.getValue() && alquilada){
            textoBoton.setValue("Guardar");
        }else{
            textoBoton.setValue("Editar");
        }
        if(!alquilada){
            cartel.setValue("No se puede editar porque la propiedad esta alquilada actualmente");
            estado.setValue(false);
        }else{
            cartel.setValue("");
        }
    }

    public void guardar(Inmueble inm){
        if(estado.getValue() && alquilada){
            SharedPreferences pref = context.getSharedPreferences("token", 0);
            String t = pref.getString("token", "vacio");

            Call<Inmueble> inmuebleActualizado = ApiClient.getMyApiClient().editarInmueble(t, inm.getId(), inm);
            inmuebleActualizado.enqueue(new Callback<Inmueble>() {
                @Override
                public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                    if(response.isSuccessful()){
                        inmuebleMutableLiveData.setValue(response.body());
                        textoBoton.setValue("Editar");
                        estado.setValue(false);
                        cartel.setValue("Propiedad editada exitosamente");
                    }
                }

                @Override
                public void onFailure(Call<Inmueble> call, Throwable t) {

                }
            });

        }else{
            estado.setValue(true);
        }
    }

    public void borrar(int id){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");
        Call<String> textoDelBorrado = ApiClient.getMyApiClient().borrarInmueble(t, id);
        textoDelBorrado.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, response.body() + "",Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Toast.makeText(context, response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }
}
