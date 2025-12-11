package com.example.appsistemasolar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Toolbar barraDeFerramentas;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragmento = null;

        if (R.id.menu_sol == itemId) {
            fragmento = new SolFragment();
        } else if (R.id.menu_lua == itemId) {
            fragmento = new LuaFragment();
        } else {
            return super.onOptionsItemSelected(item);
        }

        if (fragmento != null) {
            substituirFragmento(fragmento, "FragmentoMenu");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        barraDeFerramentas = findViewById(R.id.meu_toolbar);
        setSupportActionBar(barraDeFerramentas);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlanetasListaFragment(), "PlanetasListaFragment").commit();
        }
    }

    public void substituirFragmento(Fragment fragmento, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmento, tag)
                .addToBackStack(null) // Permite que o botão Voltar retorne ao fragmento anterior
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}