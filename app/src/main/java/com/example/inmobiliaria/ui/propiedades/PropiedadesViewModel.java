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
    private Inmueble inm1 ;
    private Inmueble inm2;

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
        inm1 = new Inmueble("Nose", 2, "Casa", "Residencial", 10000, true, 1, true);
        inm2 = new Inmueble("Nose2", 2, "Departamento", "Residencial", 9000, true, 2, false);

        inmuebleMutableLiveData.setValue(inm1);
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
            inm1.setEstado(estado1);
            inmuebleMutableLiveData.setValue(inm1);
            textoBoton.setValue("Editar");
            estado.setValue(false);
        }else{
            estado.setValue(true);
        }
    }
}
