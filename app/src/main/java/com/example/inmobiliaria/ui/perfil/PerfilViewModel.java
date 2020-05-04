package com.example.inmobiliaria.ui.perfil;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Propietario;

public class PerfilViewModel extends ViewModel {
    private MutableLiveData<Propietario> propietarioMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private MutableLiveData<String> resultado;
    private Propietario p ;

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
        p = new Propietario("12338862", "Pepe", "Dwason", "2664503984", "pepe@gmail.com", "pepe");
        propietarioMutableLiveData.setValue(p);
        estado.setValue(false);
    }
    public void editar(){
        if(estado.getValue()){
            textoBoton.setValue("Guardar");
            resultado.setValue("");
        }else{
            textoBoton.setValue("Editar");
        }
    }
    public void guardar(String documento, String ap, String nom, String tel, String mail, String contra){
        if(estado.getValue()){
            p.setDni(documento);
            p.setApellido(ap);
            p.setNombre(nom);
            p.setTelefono(tel);
            p.setEmail(mail);
            p.setContrasenia(contra);
            propietarioMutableLiveData.setValue(p);
            resultado.setValue("Guardado exitoso!!!");
            textoBoton.setValue("Editar");
            estado.setValue(false);
        }else{
            estado.setValue(true);
        }
    }
}
