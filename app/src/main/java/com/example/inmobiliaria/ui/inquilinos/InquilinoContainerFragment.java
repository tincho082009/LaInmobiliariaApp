package com.example.inmobiliaria.ui.inquilinos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelos.Inquilino;
import com.example.inmobiliaria.ui.propiedades.PropiedadesContainerFragment;

import java.util.ArrayList;
import java.util.List;

public class InquilinoContainerFragment extends Fragment {
    private ArrayList<Inquilino> lista = new ArrayList<Inquilino>();
    private InquilinoContainerViewModel vm;
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoContainerViewModel.class);
        vm.getAdapter().observe(this, new Observer<ArrayAdapter<Inquilino>>() {
            @Override
            public void onChanged(ArrayAdapter<Inquilino> inquilinoArrayAdapter) {
                lv.setAdapter(inquilinoArrayAdapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_inquilino_container, container, false);
        lv = view.findViewById(R.id.listaInquilinos);

        vm.cargarDatos(getLayoutInflater());

        return view;
    }
}
