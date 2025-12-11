package com.example.appsistemasolar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Planeta> planetas;

    public MyAdapter(Context context, List<Planeta> planetas) {
        this.planetas = planetas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return planetas.size();
    }

    @Override
    public Planeta getItem(int position) {
        return planetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.planeta_list, parent, false);
        }
        Planeta planeta = getItem(position);
        TextView nome = convertView.findViewById(R.id.textViewPlanetas);
        nome.setText(planeta.getNome());
        ImageView imagem = convertView.findViewById(R.id.imageViewPlanetas);
        imagem.setImageResource(planeta.getImagem());

        return convertView;
    }
}