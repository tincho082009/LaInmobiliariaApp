package com.example.inmobiliaria.ui.propiedades;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

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
import com.example.inmobiliaria.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PropiedadesContainerViewModel extends AndroidViewModel {
    private MutableLiveData<ViewPageAdapter> adapterMutableLiveData;
    private Application app;
    private Context context;

    public PropiedadesContainerViewModel(@NonNull Application application) {
        super(application);
        app = application;
        context = application.getApplicationContext();
    }

    public LiveData<ViewPageAdapter> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }

    public void cargarDatos(final FragmentManager fm){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "vacio");
        Call<List<Inmueble>> token = ApiClient.getMyApiClient().obtenerMisInmuebles(t);
        token.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    int x = 1;
                    ViewPageAdapter vpa = new ViewPageAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
                    for (Inmueble i: response.body()) {
                        vpa.addFragment(new PropiedadesFragment(i), "Propiedad " + x);
                        x++;
                    }
                    adapterMutableLiveData.setValue(vpa);
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(getApplication().getApplicationContext(), t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }
}
