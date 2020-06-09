package com.example.inmobiliaria.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelos.Inmueble;

public class AgregarInmuebleFragment extends Fragment {
    private AgregarInmuebleViewModel vm;
    private EditText etDomicilio, etAmbientes, etTipo, etUso, etPrecio;
    private CheckBox cbDisponible;
    private Button btnAgregar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(AgregarInmuebleViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=  inflater.inflate(R.layout.fragment_agregar_inmueble, container, false);
        etDomicilio = root.findViewById(R.id.etDireccionAgregar);
        etAmbientes = root.findViewById(R.id.etCantAmbientesAgregar);
        etTipo = root.findViewById(R.id.etTipoAgregar);
        etUso = root.findViewById(R.id.etUsoAgregar);
        etPrecio = root.findViewById(R.id.etPrecioAgregar);
        cbDisponible = root.findViewById(R.id.cbDisponibleAgregar);
        btnAgregar = root.findViewById(R.id.btnEnviarAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inmueble inm = new Inmueble();
                inm.setDireccion(etDomicilio.getText().toString());
                inm.setCantAmbientes(Integer.parseInt(etAmbientes.getText().toString()));
                inm.setTipo(etTipo.getText().toString());
                inm.setUso(etUso.getText().toString());
                inm.setPrecio(Double.valueOf(etPrecio.getText().toString()));
                inm.setEstado(cbDisponible.isChecked());
                vm.guardar(inm);
            }
        });
        return root;
    }
}
