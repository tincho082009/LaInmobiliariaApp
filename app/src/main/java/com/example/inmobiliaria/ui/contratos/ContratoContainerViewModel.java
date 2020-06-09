package com.example.inmobiliaria.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapters.ListAdapterContrato;
import com.example.inmobiliaria.modelos.ContratoAlquiler;
import com.example.inmobiliaria.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;

public class ContratoContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayAdapter<ContratoAlquiler>> adapterMutableLiveData;
    private Context context;

    public ContratoContainerViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public LiveData<ArrayAdapter<ContratoAlquiler>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }
    public void cargarDatos(LayoutInflater li){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");

        //Call<ContratoAlquiler> listaContratos = ApiClient.getMyApiClient().obtenerContratoPorInmueble(t, );
        ArrayList<ContratoAlquiler> lista = new ArrayList<>();
        lista.add(new ContratoAlquiler(1000, "2020-05-15","2020-05-30",true, 1, 1));
        lista.add(new ContratoAlquiler(2000, "2021-06-16","2021-06-31",true, 1, 1));
        lista.add(new ContratoAlquiler(3000, "2022-07-17","2022-08-1",false, 1, 2));
        ArrayAdapter<ContratoAlquiler> adapter = new ListAdapterContrato(getApplication().getApplicationContext(), R.layout.fragment_contratos, lista, li);
        adapterMutableLiveData.setValue(adapter);
    }
}
