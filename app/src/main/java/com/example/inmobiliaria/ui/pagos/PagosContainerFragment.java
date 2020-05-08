package com.example.inmobiliaria.ui.pagos;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelos.Pago;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class PagosContainerFragment extends Fragment {
    private ArrayList<Pago> lista = new ArrayList<Pago>();
    private PagosViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pagos_container, container, false);

        lista.add(new Pago(1, "2020-05-15",2600,1));
        lista.add(new Pago(2,"2020-05-16",2600,1));
        lista.add(new Pago(3,"2020-05-17",2600,1));

        ArrayAdapter<Pago> adapter = new ListAdapter(view.getContext(), R.layout.fragment_pagos, lista, getLayoutInflater());
        ListView lv = view.findViewById(R.id.listaPagos);
        lv.setAdapter(adapter);

        return view;
    }
    public class ListAdapter extends ArrayAdapter<Pago> {
        private Context context;
        private List<Pago> lista;
        private LayoutInflater li;
        public ListAdapter(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
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
}
