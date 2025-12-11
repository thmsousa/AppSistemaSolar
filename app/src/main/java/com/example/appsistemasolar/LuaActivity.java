package com.example.appsistemasolar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

public class LuaActivity extends AppCompatActivity {
    private TextView textViewLuaTemperatura;
    private TextView textViewLuaDistancia;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lua);

        toolbar = findViewById(R.id.meu_toolbar);
        setSupportActionBar(toolbar);
        textViewLuaTemperatura = findViewById(R.id.textViewLuaTemperatura);
        textViewLuaDistancia = findViewById(R.id.textViewLuaDistancia);

        textViewLuaTemperatura.setText("Temperatura media: Variam de -184ºC (Noite) entre 214ºC (Dia)");
        textViewLuaDistancia.setText("Distância da Terra: 384.400 km");
    }
}
