package com.example.inmobiliaria.ui.pagos;

import android.app.Application;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapters.ListAdapterPago;
import com.example.inmobiliaria.modelos.Pago;

import java.util.ArrayList;

public class PagosContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayAdapter<Pago>> adapterMutableLiveData;

    public PagosContainerViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayAdapter<Pago>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }
    public void cargarDatos(LayoutInflater li){
        ArrayList<Pago> lista = new ArrayList<>();
        lista.add(new Pago(1, "2020-05-15",2600,1));
        lista.add(new Pago(2,"2020-05-16",2600,1));
        lista.add(new Pago(3,"2020-05-17",2600,1));
        ArrayAdapter<Pago> adapter = new ListAdapterPago(getApplication().getApplicationContext(), R.layout.fragment_pagos, lista, li);
        adapterMutableLiveData.setValue(adapter);
    }

}
