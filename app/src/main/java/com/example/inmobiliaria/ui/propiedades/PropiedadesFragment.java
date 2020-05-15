package com.example.inmobiliaria.ui.propiedades;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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

public class PropiedadesFragment extends Fragment {
    private EditText etDomicilio, etAmbientes, etTipo, etUso, etPrecio;
    private TextView tvCartel;
    private CheckBox cbDisponible;
    private Button btnEditar;
    private PropiedadesViewModel vm;
    private Inmueble inm;

    public PropiedadesFragment(Inmueble inm1){
        this.inm = inm1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);;
        vm.getInmueble().observe(this, new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                etDomicilio.setText(inmueble.getDireccion());
                etDomicilio.setEnabled(false);
                etAmbientes.setText(inmueble.getCantAmbientes()+"");
                etAmbientes.setEnabled(false);
                etTipo.setText(inmueble.getTipo());
                etTipo.setEnabled(false);
                etUso.setText(inmueble.getUso());
                etUso.setEnabled(false);
                etPrecio.setText(inmueble.getPrecio() +"");
                etPrecio.setEnabled(false);
                cbDisponible.setChecked(inmueble.isEstado());
            }
       });
        vm.getEstado().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                cbDisponible.setEnabled(aBoolean);
            }
        });
        vm.getTextoBoton().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btnEditar.setText(s);
            }
        });
        vm.getCartel().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvCartel.setText(s);
                tvCartel.setTextColor(Color.parseColor("#D35400"));
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_propiedades, container, false);
        tvCartel = root.findViewById(R.id.tvCartelPropiedades);
        etDomicilio = root.findViewById(R.id.etDomicilio);
        etAmbientes = root.findViewById(R.id.etAmbiente);
        etTipo = root.findViewById(R.id.etTipo);
        etUso = root.findViewById(R.id.etUso);
        etPrecio = root.findViewById(R.id.etPrecio);
        cbDisponible = root.findViewById(R.id.cbDisponible);
        btnEditar = root.findViewById(R.id.btnEditarPropiedad);
        vm.rellenar(inm);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.guardar(cbDisponible.isChecked());
                vm.editar();
            }
        });

        return root;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
