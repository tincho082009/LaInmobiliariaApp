package com.example.inmobiliaria;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelos.Propietario;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<Boolean> email;
    private MutableLiveData<Boolean> contrasenia;
    private MutableLiveData<String> cartelEmail;
    private  MutableLiveData<String> cartelContrasenia;
    private MutableLiveData<Boolean> activadorIntent;

    public LiveData<Boolean> getEmail(){
        if(email==null){
            email =  new MutableLiveData<Boolean>();
        }
        return email;
    }
    public LiveData<Boolean> getContrasenia(){
        if(contrasenia==null){
            contrasenia = new MutableLiveData<Boolean>();
        }
        return contrasenia;
    }

    public LiveData<String> getCartelEmail(){
        if(cartelEmail==null){
            cartelEmail =  new MutableLiveData<String>();
        }
        return cartelEmail;
    }

    public LiveData<String> getCartelContrasenia(){
        if(cartelContrasenia==null){
            cartelContrasenia= new MutableLiveData<String>();
        }
        return cartelContrasenia;
    }

    public LiveData<Boolean> getActivadorIntent(){
        if(activadorIntent == null){
            activadorIntent = new MutableLiveData<Boolean>();
        }
        return activadorIntent;
    }

    public void enfocarEmail(Boolean booleanito){
        email.setValue(booleanito);
    }
    public void enfocarContrasenia(Boolean booleanito){
        contrasenia.setValue(booleanito);
    }

    public void validar(String mail, String contra) {
        Propietario p = new Propietario("12338862", "Pepe", "Dwason", "2664503984", "pepe@gmail.com", "pepe");
        int cantMail = mail.length();
        int cantContra = contra.length();
        if (cantMail <= 0) {
            cartelEmail.setValue("*Obligatorio");
        }else{
            cartelEmail.setValue("");
        }
        if (cantContra <= 0) {
            cartelContrasenia.setValue("*Obligatorio");
        }else{
            cartelEmail.setValue("");
        }
        if ((mail.equals(p.getEmail())) && (contra.equals(p.getContrasenia()))) {
            activadorIntent.setValue(true);
        } else if(cantMail > 0 && cantContra > 0) {
            cartelEmail.setValue("User o pass incorrectas");
            cartelContrasenia.setValue("");
        }
    }


}
