package com.example.inmobiliaria.ui.inquilinos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria.R;

public class InquilinosFragment extends Fragment {
    private InquilinosViewModel vm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = new InquilinosViewModel();
        View root= inflater.inflate(R.layout.fragment_inquilinos, container, false);
        final TextView textView = root.findViewById(R.id.text_inquilinos);
        vm.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
