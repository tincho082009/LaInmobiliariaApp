package com.example.inmobiliaria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelos.Inquilino;

import java.util.List;

public class ListAdapterInquilino extends ArrayAdapter<Inquilino> {
    private Context context;
    private List<Inquilino> lista;
    private LayoutInflater li;

    public ListAdapterInquilino(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView==null){
            itemView = li.inflate(R.layout.fragment_inquilinos, parent, false);
        }
        Inquilino inquilino = lista.get(position);

        TextView dni = itemView.findViewById(R.id.tvDniInq);
        dni.setText(inquilino.getDni());

        TextView nombre = itemView.findViewById(R.id.tvNombreInq);
        nombre.setText(inquilino.getNombre());

        TextView apellido = itemView.findViewById(R.id.tvApellidoInq);
        apellido.setText(inquilino.getApellido());

        TextView trabajo = itemView.findViewById(R.id.tvTrabajoInq);
        trabajo.setText(inquilino.getTrabajo());

        TextView dniGarante = itemView.findViewById(R.id.tvDniGInq);
        dniGarante.setText(inquilino.getDniGarante());

        TextView nombreGarante = itemView.findViewById(R.id.tvNombreGInq);
        nombreGarante.setText(inquilino.getNombreGarante());

        return itemView;
    }
}
