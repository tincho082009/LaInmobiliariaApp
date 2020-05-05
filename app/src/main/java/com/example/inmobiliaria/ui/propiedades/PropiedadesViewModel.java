package com.example.inmobiliaria.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Inmueble;

public class PropiedadesViewModel extends ViewModel {
    private MutableLiveData<Inmueble> inmuebleMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private MutableLiveData<Boolean> alquilada;
    private Inmueble i ;

    public LiveData<Inmueble> getInmueble(){
        if(inmuebleMutableLiveData == null) {
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
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

    public void rellenar(){
        i = new Inmueble("Nose", 2, "Casa", "Residencial", 10000, true, 1, true);
        inmuebleMutableLiveData.setValue(i);
        estado.setValue(false);
        alquilada.setValue(inmuebleMutableLiveData.getValue().isAlquilada());
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
            i.setEstado(estado1);
            inmuebleMutableLiveData.setValue(i);
            textoBoton.setValue("Editar");
            estado.setValue(false);
        }else{
            estado.setValue(true);
        }
    }
}
