package com.example.appsistemasolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private MyAdapter adapter;
    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent it = null;
        if (R.id.menu_sol == item.getItemId()){
            it = new Intent(MainActivity.this, SolActivity.class);
            startActivity(it);
            return true;
        }
        if (R.id.menu_lua == item.getItemId()) {
            it = new Intent(MainActivity.this, LuaActivity.class);
            startActivity(it);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.meu_toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listViewPlanetas);
        adapter = new MyAdapter(MainActivity.this, RepositorioPlaneta.obterPlanetas(this));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Planeta planeta = (Planeta) parent.getItemAtPosition(position);
        Intent intent = new Intent(MainActivity.this, InformacoesActivity.class);
        intent.putExtra("planeta", planeta);
        startActivity(intent);
    }
}
