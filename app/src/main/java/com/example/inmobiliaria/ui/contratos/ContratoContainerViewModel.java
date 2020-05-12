package com.example.inmobiliaria.ui.contratos;

import android.app.Application;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapters.ListAdapterContrato;
import com.example.inmobiliaria.modelos.ContratoAlquiler;

import java.util.ArrayList;

public class ContratoContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayAdapter<ContratoAlquiler>> adapterMutableLiveData;
    public ContratoContainerViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayAdapter<ContratoAlquiler>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }
    public void cargarDatos(LayoutInflater li){
        ArrayList<ContratoAlquiler> lista = new ArrayList<>();
        lista.add(new ContratoAlquiler(1000, "2020-05-15","2020-05-30",true, 1, 1));
        lista.add(new ContratoAlquiler(2000, "2021-06-16","2021-06-31",true, 1, 1));
        lista.add(new ContratoAlquiler(3000, "2022-07-17","2022-08-1",false, 1, 2));
        ArrayAdapter<ContratoAlquiler> adapter = new ListAdapterContrato(getApplication().getApplicationContext(), R.layout.fragment_contratos, lista, li);
        adapterMutableLiveData.setValue(adapter);
    }
}
