package com.example.inmobiliaria.ui.propiedades;

import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelos.Inmueble;

import java.util.List;

public class PropiedadesFragment extends Fragment {
    private EditText etDomicilio, etAmbientes,etUso, etPrecio;
    private Spinner spTipo;
    private TextView tvCartel;
    private CheckBox cbDisponible;
    private Button btnEditar, btnBorrar;
    private PropiedadesViewModel vm;
    private View v;
    private Inmueble inm;
    private Inmueble inmRenovado = new Inmueble();

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
                spTipo.setEnabled(false);
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
                etDomicilio.setEnabled(aBoolean);
                etAmbientes.setEnabled(aBoolean);
                spTipo.setEnabled(aBoolean);
                etUso.setEnabled(aBoolean);
                etPrecio.setEnabled(aBoolean);
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
        vm.getListadoTipos().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, strings);
                spTipo.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_propiedades, container, false);
        v = root;
        tvCartel = root.findViewById(R.id.tvCartelPropiedades);
        etDomicilio = root.findViewById(R.id.etDomicilio);
        etAmbientes = root.findViewById(R.id.etAmbiente);
        spTipo = root.findViewById(R.id.spTipo);
        etUso = root.findViewById(R.id.etUso);
        etPrecio = root.findViewById(R.id.etPrecio);
        cbDisponible = root.findViewById(R.id.cbDisponible);
        btnEditar = root.findViewById(R.id.btnEditarPropiedad);
        btnBorrar = root.findViewById(R.id.btnBorrarInmueble);
        vm.rellenar(inm);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inmRenovado.setId(inm.getId());
                inmRenovado.setDireccion(etDomicilio.getText().toString());
                inmRenovado.setUso(etUso.getText().toString());
                inmRenovado.setTipo(spTipo.getSelectedItem().toString());
                inmRenovado.setPrecio(Double.valueOf(etPrecio.getText().toString()));
                inmRenovado.setCantAmbientes(Integer.parseInt(etAmbientes.getText().toString()));
                inmRenovado.setEstado(cbDisponible.isChecked());
                vm.guardar(inmRenovado);
                vm.editar();
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificacion();
            }
        });

        return root;
    }

    private void notificacion() { new AlertDialog.Builder(getContext()).setTitle("Borrar")
            .setMessage("¿Desea borrar este inmueble?")
            .setCancelable(false)
            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    vm.borrar(inm.getId());
                    Navigation.findNavController(v).navigate(R.id.nav_contenedor, null);
                }
            })
            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            }).show();

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
