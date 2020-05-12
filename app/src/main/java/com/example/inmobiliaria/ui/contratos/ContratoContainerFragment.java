package com.example.inmobiliaria.ui.contratos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
    private ContratosViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.fragment_contrato_container, container, false);

        lista.add(new ContratoAlquiler(1000, "2020-05-15","2020-05-30",true, 1, 1));

        ArrayAdapter<ContratoAlquiler> adapter = new ListAdapter(view.getContext(), R.layout.fragment_contratos, lista, getLayoutInflater());
        ListView lv = view.findViewById(R.id.listaContratos);
        lv.setAdapter(adapter);

        return view;
    }
    public class ListAdapter extends ArrayAdapter<ContratoAlquiler> {
        private Context context;
        private List<ContratoAlquiler> lista;
        private LayoutInflater li;
        public ListAdapter(@NonNull Context context, int resource, @NonNull List<ContratoAlquiler> objects, LayoutInflater li) {
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
}
