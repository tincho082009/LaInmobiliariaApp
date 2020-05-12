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
import com.example.inmobiliaria.modelos.ContratoAlquiler;

import java.util.List;

public class ListAdapterContrato extends ArrayAdapter<ContratoAlquiler> {
    private Context context;
    private List<ContratoAlquiler> lista;
    private LayoutInflater li;
    public ListAdapterContrato(@NonNull Context context, int resource, @NonNull List<ContratoAlquiler> objects, LayoutInflater li) {
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
            itemView = li.inflate(R.layout.fragment_contratos, parent, false);
        }
        ContratoAlquiler contratoAlquiler = lista.get(position);

        TextView precio = itemView.findViewById(R.id.tvPrecioContrato);
        precio.setText(contratoAlquiler.getMonto() +"");

        TextView fechaInicio = itemView.findViewById(R.id.tvFechaInicio);
        fechaInicio.setText(contratoAlquiler.getFechaInicio());

        TextView fechaFinal = itemView.findViewById(R.id.tvFechaFinal);
        fechaFinal.setText(contratoAlquiler.getFechaFinalizacion() +"");

        return itemView;
    }
}
