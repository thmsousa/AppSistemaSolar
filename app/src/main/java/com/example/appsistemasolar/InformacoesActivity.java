package com.example.appsistemasolar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

public class InformacoesActivity extends AppCompatActivity {

    private ImageView imageViewPlaneta;
    private TextView textViewNome;
    private TextView textViewGravidade;
    private EditText editTextMassa;
    private Button buttonCalcular;
    private ProgressBar progressBar;
    private TextView textViewResultado;
    private Toolbar toolbar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        toolbar = findViewById(R.id.meu_toolbar);
        setSupportActionBar(toolbar);

        imageViewPlaneta = findViewById(R.id.imageViewPlaneta);
        textViewNome = findViewById(R.id.textViewNome);
        textViewGravidade = findViewById(R.id.textViewGravidade);
        editTextMassa = findViewById(R.id.editTextMassa);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        progressBar = findViewById(R.id.progressBar);
        textViewResultado = findViewById(R.id.textViewResultado);

        Planeta planeta = (Planeta) getIntent().getSerializableExtra("planeta");

        imageViewPlaneta.setImageResource(planeta.getImagem());
        textViewNome.setText("Planeta: " + planeta.getNome());
        textViewGravidade.setText("Gravidade: " + planeta.getGravidade() + " m/s²");

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double massa = Double.parseDouble(editTextMassa.getText().toString());
                double peso = planeta.calcularPeso(massa);
                executarProgressBar(peso);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent it = null;
        if (R.id.menu_sol == item.getItemId()){
            it = new Intent(InformacoesActivity.this, SolActivity.class);
            startActivity(it);
            return true;
        }
        if (R.id.menu_lua == item.getItemId()) {
            it = new Intent(InformacoesActivity.this, LuaActivity.class);
            startActivity(it);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void executarProgressBar(double peso){
        progressBar.setProgress(progress);
        progressBar.setVisibility(View.VISIBLE);
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progress<100){
                    progress+=10;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);

                            if(progress>=100){
                                textViewResultado.setText("Seu peso neste planeta: " + String.format("%.1f", peso) + "Newtons");
                                progressBar.setVisibility(View.INVISIBLE);                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        }).start();
    }

}
