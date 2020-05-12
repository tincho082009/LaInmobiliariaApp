package com.example.inmobiliaria.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Pago;

import java.util.ArrayList;
import java.util.List;

public class PagosViewModel extends ViewModel {
    private MutableLiveData<List<Pago>> listaPagos;

    public LiveData<List<Pago>> getListaPagos(){
        if(listaPagos == null) {
            listaPagos = new MutableLiveData<>();
        }
        return listaPagos;
    }

    public void cargarDatos(){
        ArrayList<Pago> lista = new ArrayList<>();
        lista.add(new Pago(1, "2020-05-15",2600,1));
        lista.add(new Pago(2,"2020-05-16",2600,1));
        lista.add(new Pago(3,"2020-05-17",2600,1));
        listaPagos.setValue(lista);
    }
}
