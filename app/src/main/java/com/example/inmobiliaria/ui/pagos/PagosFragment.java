package com.example.inmobiliaria.ui.pagos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria.R;

public class PagosFragment extends Fragment {
    private PagosViewModel vm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = new PagosViewModel();
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);

        return root;
    }
}
