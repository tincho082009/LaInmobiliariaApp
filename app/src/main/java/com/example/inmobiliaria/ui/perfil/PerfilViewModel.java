package com.example.inmobiliaria.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Propietario;
import com.example.inmobiliaria.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {
    private MutableLiveData<Propietario> propietarioMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private MutableLiveData<String> resultado;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context = getApplication().getApplicationContext();
    }

    public LiveData<Propietario> getPropietario(){
        if(propietarioMutableLiveData == null) {
            propietarioMutableLiveData = new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }

    public LiveData<Boolean> getEstado(){
        if(estado == null){
            estado = new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton(){
        if(textoBoton == null){
            textoBoton = new MutableLiveData<>();
        }
        return textoBoton;
    }

    public LiveData<String> getResultado(){
        if(resultado == null){
            resultado = new MutableLiveData<>();
        }
        return resultado;
    }

    public void rellenar(){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");
        Call<Propietario> propietario = ApiClient.getMyApiClient().obtenerPropietario(t);
        propietario.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietarioMutableLiveData.setValue(response.body());
                    estado.setValue(false);
                }else{
                    Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
    public void editar(){
        if(estado.getValue()){
            textoBoton.setValue("Guardar");
            resultado.setValue("");
        }else{
            textoBoton.setValue("Editar");
        }
    }
    public void guardar(Propietario prop){
        if(estado.getValue()){
            SharedPreferences pref = context.getSharedPreferences("token", 0);
            String t = pref.getString("token", "vacio");

            Call<Propietario> propietarioActualizado = ApiClient.getMyApiClient().editarPropietario(t, prop.getId(), prop);
            propietarioActualizado.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    if(response.isSuccessful()){
                        propietarioMutableLiveData.setValue(response.body());
                        resultado.setValue("Guardado exitoso!!!");
                        textoBoton.setValue("Editar");
                        estado.setValue(false);
                    }else{
                        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }else{
            estado.setValue(true);
        }
    }
}
