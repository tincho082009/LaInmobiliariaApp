package com.example.inmobiliaria.ui.inquilinos;

import android.app.Application;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapters.ListAdapterInquilino;
import com.example.inmobiliaria.modelos.Inquilino;

import java.util.ArrayList;

public class InquilinoContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayAdapter<Inquilino>> adapterMutableLiveData;

    public InquilinoContainerViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayAdapter<Inquilino>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }

    public void cargarDatos(LayoutInflater li){
        int x = 1;
        ArrayList<Inquilino> lista = new ArrayList<>();
        lista.add(new Inquilino("12334521","Funes","Martin","CIA","14532124","Joaquin"));
        lista.add(new Inquilino("12334522","Funez","Martina","FBI","14532125","Joaquina"));
        lista.add(new Inquilino("12334523","Funesh","Martini","Interpol","14532126","Joaquini"));
        ArrayAdapter<Inquilino> adapter = new ListAdapterInquilino(getApplication().getApplicationContext(), R.layout.fragment_inquilinos, lista, li);
        adapterMutableLiveData.setValue(adapter);
    }

}
