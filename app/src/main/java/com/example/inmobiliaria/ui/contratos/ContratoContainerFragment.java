package com.example.inmobiliaria.ui.contratos;

import android.content.Context;
import android.graphics.Color;
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
import com.example.inmobiliaria.modelos.ContratoAlquiler;
import com.example.inmobiliaria.ui.pagos.PagosContainerFragment;

import java.util.ArrayList;
import java.util.List;

public class ContratoContainerFragment extends Fragment {
    private ArrayList<ContratoAlquiler> lista = new ArrayList<ContratoAlquiler>();
    private ContratoContainerViewModel vm;
    private TextView tvTitulo;
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoContainerViewModel.class);
        vm.getAdapter().observe(this, new Observer<ArrayAdapter<ContratoAlquiler>>() {
            @Override
            public void onChanged(ArrayAdapter<ContratoAlquiler> pagoArrayAdapter) {
                lv.setAdapter(pagoArrayAdapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.fragment_contrato_container, container, false);
        tvTitulo = view.findViewById(R.id.tvTituloContratoContainer);
        String x = getArguments().getString("direccion");
        tvTitulo.setText(x);
        tvTitulo.setBackgroundColor(Color.parseColor("#212121"));
        vm.cargarDatos(getLayoutInflater());
        lv = view.findViewById(R.id.listaContratos);

        return view;
    }

}
