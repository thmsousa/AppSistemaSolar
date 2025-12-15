package com.example.appsistemasolar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LuaFragment extends Fragment {
    private TextView textViewLuaTemperatura;
    private TextView textViewLuaDistancia;

    public LuaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewLuaTemperatura = view.findViewById(R.id.textViewLuaTemperatura);
        textViewLuaDistancia = view.findViewById(R.id.textViewLuaDistancia);

        textViewLuaTemperatura.setText("Temperatura media: Variam de -184ºC (Noite) entre 214ºC (Dia)");
        textViewLuaDistancia.setText("Distância da Terra: 384.400 km");
    }
}
