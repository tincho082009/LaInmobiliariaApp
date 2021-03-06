package com.example.inmobiliaria.ui.inquilinos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ListaPropiedadesInquilinoViewModel extends AndroidViewModel {
    private MutableLiveData<List<String>> listaDirecciones;
    public ListaPropiedadesInquilinoViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<List<String>> getListaDirecciones(){
        if(listaDirecciones == null) {
            listaDirecciones = new MutableLiveData<>();
        }
        return listaDirecciones;
    }

    public void cargarDatos(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Nose");
        lista.add("Nose2");
        listaDirecciones.setValue(lista);
    }
}
