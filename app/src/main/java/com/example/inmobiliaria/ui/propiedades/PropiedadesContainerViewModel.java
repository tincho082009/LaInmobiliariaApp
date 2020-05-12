package com.example.inmobiliaria.ui.propiedades;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.adapters.ViewPageAdapter;
import com.example.inmobiliaria.modelos.Inmueble;

import java.util.ArrayList;
import java.util.List;


public class PropiedadesContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ViewPageAdapter> adapterMutableLiveData;
    private Application app;
    public PropiedadesContainerViewModel(@NonNull Application application) {
        super(application);
        app = application;
    }

    public LiveData<ViewPageAdapter> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }

    public void cargarDatos(FragmentManager fm){
        int x = 1;
        ArrayList<Inmueble> lista = new ArrayList<>();
        Inmueble inm1 = new Inmueble("Nose", 2, "Casa", "Residencial", 10000, true, 1, true);
        Inmueble inm2 = new Inmueble("Nose2", 2, "Departamento", "Residencial", 9000, true, 2, false);
        Inmueble inm3 = new Inmueble("Plaza Parque", 3, "Casa", "Residencial", 19000, false, 3, false);
        lista.add(inm1);
        lista.add(inm2);
        lista.add(inm3);
        ViewPageAdapter vpa = new ViewPageAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        for (Inmueble i: lista) {
            vpa.addFragment(new PropiedadesFragment(i), "Propiedad" + x);
            x++;
        }
        adapterMutableLiveData.setValue(vpa);
    }
}
