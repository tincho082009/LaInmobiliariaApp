package com.example.inmobiliaria.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapters.ViewPageAdapter;
import com.example.inmobiliaria.modelos.Inmueble;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesContainerFragment extends Fragment implements PropiedadesFragment.OnFragmentInteractionListener{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private PropiedadesContainerViewModel vm;
    private Inmueble inm1 = new Inmueble();
    private Inmueble inm2 = new Inmueble();
    // TODO: Rename and change types of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesContainerViewModel.class);

        vm.getAdapter().observe(this, new Observer<ViewPageAdapter>() {
            @Override
            public void onChanged(ViewPageAdapter viewPageAdapter) {
                viewPager.setAdapter(viewPageAdapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_propiedades_container, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        appBarLayout = view.findViewById(R.id.appBar);
        tabLayout = new TabLayout(view.getContext());

        appBarLayout.addView(tabLayout);
        vm.cargarDatos(getParentFragmentManager());

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), tab.getText(), Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
