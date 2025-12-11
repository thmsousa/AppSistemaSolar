package com.example.appsistemasolar;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPlaneta {

    public static List<Planeta> obterPlanetas(Context context) {
        String[] nomes = context.getResources().getStringArray(R.array.nomes_planetas);
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(new Planeta(nomes[0], R.drawable.mercury, 3.70));
        planetas.add(new Planeta(nomes[1], R.drawable.venus, 8.87));
        planetas.add(new Planeta(nomes[2], R.drawable.earth, 9.80));
        planetas.add(new Planeta(nomes[3], R.drawable.mars, 3.71));
        planetas.add(new Planeta(nomes[4], R.drawable.jupiter, 24.79));
        planetas.add(new Planeta(nomes[5], R.drawable.saturn, 10.44));
        planetas.add(new Planeta(nomes[6], R.drawable.uranus, 8.69));
        planetas.add(new Planeta(nomes[7], R.drawable.neptune, 11.15));

        return planetas;
    }
}
