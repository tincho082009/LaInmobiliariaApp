package com.example.inmobiliaria.ui.propiedades;

import android.widget.LinearLayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {
    private MutableLiveData<Inmueble> inmuebleMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private MutableLiveData<Boolean> alquilada;
    private Inmueble inm1 ;
    private MutableLiveData<String> cartel;
    private MutableLiveData<List<String>> listaDirecciones;

    public LiveData<Inmueble> getInmueble(){
        if(inmuebleMutableLiveData == null) {
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
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

    public LiveData<Boolean> getAlquilada(){
        if(alquilada == null) {
            alquilada = new MutableLiveData<>();
        }
        return alquilada;
    }

    public void rellenar(Inmueble inm){
        inm1 = inm;
        inmuebleMutableLiveData.setValue(inm);
        estado.setValue(false);
        alquilada.setValue(!inm.isAlquilada());
        if(inm1.isAlquilada()){
            cartel.setValue("No se puede editar porque la propiedad esta alquilada actualmente");
        }else{
            cartel.setValue("");
        }
    }

    public void editar(){
        if(estado.getValue() && alquilada.getValue()){
            textoBoton.setValue("Guardar");
        }else{
            textoBoton.setValue("Editar");
        }
    }

    public void guardar(Boolean estado1){
        if(estado.getValue() && alquilada.getValue()){
            inm1.setEstado(estado1);
            inmuebleMutableLiveData.setValue(inm1);
            textoBoton.setValue("Editar");
            estado.setValue(false);
        }else{
            estado.setValue(true);
        }
    }
}
