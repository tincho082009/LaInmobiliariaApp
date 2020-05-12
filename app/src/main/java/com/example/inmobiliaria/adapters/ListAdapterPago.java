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
import com.example.inmobiliaria.modelos.Pago;

import java.util.List;

public class ListAdapterPago extends ArrayAdapter<Pago> {
    private Context context;
    private List<Pago> lista;
    private LayoutInflater li;
    public ListAdapterPago(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
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
            itemView = li.inflate(R.layout.fragment_pagos, parent, false);
        }
        Pago pago = lista.get(position);

        TextView nroPago = itemView.findViewById(R.id.tvNroPago);
        nroPago.setText(pago.getNroPago() +"");

        TextView fechaPago = itemView.findViewById(R.id.tvFechaPago);
        fechaPago.setText(pago.getFechaPago());

        TextView importe = itemView.findViewById(R.id.tvImporte);
        importe.setText(pago.getImporte() +"");

        return itemView;
    }
}