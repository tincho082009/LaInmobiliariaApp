package com.example.inmobiliaria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria.adapters.SeccionesAdapter;
import com.example.inmobiliaria.ui.propiedades.PropiedadesFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class ContenedorFragment extends Fragment {

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;


    public ContenedorFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ContenedorFragment newInstance(String param1, String param2) {
        ContenedorFragment fragment = new ContenedorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista =  inflater.inflate(R.layout.fragment_contenedor, container, false);
        View parent = (View) container.getParent();
        if(appBar==null){
            appBar =(AppBarLayout) parent.findViewById(R.id.appBar);
            pestanas = new TabLayout(getActivity());
            appBar.addView(pestanas);

            viewPager = vista.findViewById(R.id.viewPagerPropiedades);
            llenarViewPager(viewPager);
            viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }
            });
            pestanas.setupWithViewPager(viewPager);
        }
        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter adapter = new SeccionesAdapter(getFragmentManager());
        adapter.addFragment(new PropiedadesFragment(), "Propiedad1");
        adapter.addFragment(new PropiedadesFragment(), "Propiedad2");
        adapter.addFragment(new PropiedadesFragment(), "Propiedad3");

        viewPager.setAdapter(adapter);
    }
}
