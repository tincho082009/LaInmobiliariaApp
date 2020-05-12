package com.example.inmobiliaria.ui.contratos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria.R;

public class ContratosFragment extends Fragment {
   private ContratosViewModel vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = new ContratosViewModel();
        View root = inflater.inflate(R.layout.fragment_contratos, container, false);

        return root;
    }
}
