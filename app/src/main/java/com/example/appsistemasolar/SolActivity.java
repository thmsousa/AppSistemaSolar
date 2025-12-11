package com.example.appsistemasolar;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SolActivity extends AppCompatActivity {
    private TextView textViewSolTemperatura;
    private TextView textViewSolDistancia;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sol);

        textViewSolTemperatura = findViewById(R.id.textViewSolTemperatura);
        textViewSolDistancia = findViewById(R.id.textViewSolDistancia);
        toolbar = findViewById(R.id.meu_toolbar);
        setSupportActionBar(toolbar);

        textViewSolTemperatura.setText("Temperatura media: Variam de 5,5 mil ºC e 15 milhoes ºC");
        textViewSolDistancia.setText("Distancia da Terra: 150 milhões de km ");

    }
}