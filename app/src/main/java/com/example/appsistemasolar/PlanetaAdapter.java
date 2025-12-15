package com.example.appsistemasolar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetaAdapter extends RecyclerView.Adapter<PlanetaAdapter.ViewHolder> {
    private final List<Planeta> planetas;
    private final OnPlanetClickListener listener;

    public interface OnPlanetClickListener {
        void onPlanetClick(Planeta planeta);
    }

    public PlanetaAdapter(List<Planeta> planetas, OnPlanetClickListener listener) {
        this.planetas = planetas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planeta_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Planeta planeta = planetas.get(position);
        holder.mostrarDados(planeta, listener);
    }

    @Override
    public int getItemCount() {
        return planetas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewPlanetas);
            imageView = itemView.findViewById(R.id.imageViewPlanetas);
        }

        public void mostrarDados(final Planeta planeta, final OnPlanetClickListener listener) {
            nameTextView.setText(planeta.getNome());
            imageView.setImageResource(planeta.getImagem());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlanetClick(planeta);
                }
            });
        }
    }
}