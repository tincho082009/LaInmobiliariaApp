package com.example.inmobiliaria.ui.pagos;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import com.example.inmobiliaria.modelos.Pago;

import org.w3c.dom.Text;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class PagosContainerFragment extends Fragment {
    private ArrayList<Pago> lista = new ArrayList<Pago>();
    private TextView tvTitulo;
    private PagosContainerViewModel vm;
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosContainerViewModel.class);
       vm.getAdapter().observe(this, new Observer<ArrayAdapter<Pago>>() {
           @Override
           public void onChanged(ArrayAdapter<Pago> pagoArrayAdapter) {
               lv.setAdapter(pagoArrayAdapter);
           }
       });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pagos_container, container, false);
        tvTitulo = view.findViewById(R.id.tvTituloPagosContainer);
        String x = getArguments().getString("direccion");
        tvTitulo.setText(x);
        tvTitulo.setBackgroundColor(Color.parseColor("#212121"));
        vm.cargarDatos(getLayoutInflater());
        lv = view.findViewById(R.id.listaPagos);

        return view;
    }

}
