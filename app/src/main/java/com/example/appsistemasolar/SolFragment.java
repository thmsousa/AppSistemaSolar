package com.example.appsistemasolar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SolFragment extends Fragment {
    private TextView textViewSolTemperatura;
    private TextView textViewSolDistancia;

    public SolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewSolTemperatura = view.findViewById(R.id.textViewSolTemperatura);
        textViewSolDistancia = view.findViewById(R.id.textViewSolDistancia);

        textViewSolTemperatura.setText("Temperatura media: Variam de 5,5 mil ºC e 15 milhoes ºC");
        textViewSolDistancia.setText("Distancia da Terra: 150 milhões de km ");
    }
}