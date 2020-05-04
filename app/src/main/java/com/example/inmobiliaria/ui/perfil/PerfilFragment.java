package com.example.inmobiliaria.ui.perfil;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelos.Propietario;

public class PerfilFragment extends Fragment {
    private TextView tvResultado;
    private EditText etDni, etApellido, etNombre, etTelefono, etEmail, etContrasenia;
    private Button btnEditarPerfil;
    private PerfilViewModel vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new PerfilViewModel();

        vm.getPropietario().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etDni.setText(propietario.getDni());
                etApellido.setText(propietario.getApellido());
                etNombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTelefono());
                etEmail.setText(propietario.getEmail());
                etContrasenia.setText(propietario.getContrasenia());

            }
        });
        vm.getEstado().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDni.setEnabled(aBoolean);
                etApellido.setEnabled(aBoolean);
                etNombre.setEnabled(aBoolean);
                etTelefono.setEnabled(aBoolean);
                etEmail.setEnabled(aBoolean);
                etContrasenia.setEnabled(aBoolean);
            }
        });
        vm.getTextoBoton().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btnEditarPerfil.setText(s);
            }
        });
        vm.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResultado.setText(s);
                tvResultado.setTextColor(Color.parseColor("#00CB11"));
                tvResultado.setTextSize(17);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
         tvResultado = root.findViewById(R.id.tvMensaje);
         etDni = root.findViewById(R.id.etNroDocumento);
         etApellido = root.findViewById(R.id.etApellido);
         etNombre = root.findViewById(R.id.etNombre);
         etTelefono = root.findViewById(R.id.etTelefono);
         etEmail = root.findViewById(R.id.etEmail);
         etContrasenia = root.findViewById(R.id.etContrasenia);
         btnEditarPerfil = root.findViewById(R.id.btnEditarPerfil);

         vm.rellenar();

         btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 vm.guardar(etDni.getText().toString(), etApellido.getText().toString(), etNombre.getText().toString(), etTelefono.getText().toString(), etEmail.getText().toString(), etContrasenia.getText().toString());
                vm.editar();
             }
         });

        return root;
    }

}
