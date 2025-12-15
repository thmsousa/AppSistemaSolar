package com.example.appsistemasolar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

public class FragmentoInfoPlaneta extends Fragment {

    private ImageView imageViewPlaneta;
    private TextView textViewNome;
    private TextView textViewGravidade;
    private EditText editTextNome;
    private EditText editTextMassa;
    private Button buttonCalcular;
    private ProgressBar barraDeProgresso;
    private TextView textViewResultado;
    private Planeta planeta;
    private int progresso;
    private Banco bd;

    public FragmentoInfoPlaneta() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            planeta = (Planeta) getArguments().getSerializable("planeta");
        }
        if (getContext() != null) {
            bd = Banco.getInstancia(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planetas_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageViewPlaneta = view.findViewById(R.id.imageViewPlaneta);
        textViewNome = view.findViewById(R.id.textViewNome);
        textViewGravidade = view.findViewById(R.id.textViewGravidade);
        editTextNome = view.findViewById(R.id.editTextNome);
        editTextMassa = view.findViewById(R.id.editTextMassa);
        buttonCalcular = view.findViewById(R.id.buttonCalcular);
        barraDeProgresso = view.findViewById(R.id.progressBar);
        textViewResultado = view.findViewById(R.id.textViewResultado);

        if (planeta != null) {
            imageViewPlaneta.setImageResource(planeta.getImagem());
            textViewNome.setText("Planeta: " + planeta.getNome());
            textViewGravidade.setText("Gravidade: " + planeta.getGravidade() + " m/s²");
        }

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPeso();
            }
        });
    }

    private void calcularPeso() {
        String nome = editTextNome.getText().toString().trim();
        String massaStr = editTextMassa.getText().toString().trim();

        if (nome.isEmpty() || massaStr.isEmpty()) {
            Toast.makeText(getContext(), "Por favor, preencha seu nome e massa.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double massa = Double.parseDouble(massaStr);
            if (planeta != null) {
                double peso = planeta.calcularPeso(massa);
                executarBarraDeProgresso(nome, massa, peso);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Massa inválida.", Toast.LENGTH_SHORT).show();
        }
    }

    private void executarBarraDeProgresso(String nome, double massa, double peso) {
        progresso = 0;
        barraDeProgresso.setProgress(progresso);
        barraDeProgresso.setVisibility(View.VISIBLE);
        textViewResultado.setText("");

        new Thread(() -> {
            while (progresso < 100) {
                progresso += 10;
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> barraDeProgresso.setProgress(progresso));
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> {
                    textViewResultado.setText(String.format("Seu peso neste planeta: %.1f Newtons", peso));
                    barraDeProgresso.setVisibility(View.INVISIBLE);

                    salvarPesoCalculado(nome, massa, peso);
                });
            }

        }).start();
    }

    private void salvarPesoCalculado(String nome, double massa, double peso) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Peso pesoCalculado = new Peso();
                pesoCalculado.setNomeUsuario(nome);
                pesoCalculado.setMassa(massa);
                pesoCalculado.setPesoCalculado(peso);
                pesoCalculado.setNomePlaneta(planeta.getNome());

                bd.pesoCalculadoDao().inserir(pesoCalculado);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (getContext() != null) {
                    Toast.makeText(getContext(), "Cálculo salvo no banco de dados!", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
}