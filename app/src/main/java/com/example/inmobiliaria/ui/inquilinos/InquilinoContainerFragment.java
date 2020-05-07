package com.example.inmobiliaria.ui.inquilinos;

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
import com.example.inmobiliaria.modelos.Inquilino;
import com.example.inmobiliaria.ui.propiedades.PropiedadesContainerFragment;

import java.util.ArrayList;
import java.util.List;

public class InquilinoContainerFragment extends Fragment {
    private ArrayList<Inquilino> lista = new ArrayList<Inquilino>();
    private InquilinosViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_inquilino_container, container, false);

        lista.add(new Inquilino("12334521","Funes","Martin","CIA","14532124","Joaquin"));
        lista.add(new Inquilino("12334522","Funez","Martina","FBI","14532125","Joaquina"));
        lista.add(new Inquilino("12334523","Funesh","Martini","Interpol","14532126","Joaquini"));

        ArrayAdapter<Inquilino> adapter = new ListAdapter(view.getContext(), R.layout.fragment_inquilinos, lista, getLayoutInflater());
        ListView lv = view.findViewById(R.id.listaInquilinos);
        lv.setAdapter(adapter);
        return view;
    }

    public class ListAdapter extends ArrayAdapter<Inquilino> {
        private Context context;
        private List<Inquilino> lista;
        private LayoutInflater li;
        public ListAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
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
}
