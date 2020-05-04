package com.example.inmobiliaria.ui.salida;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalidaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SalidaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Salida fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
