package com.example.appsistemasolar;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class PlanetasListaFragment extends Fragment implements PlanetaAdapter.OnPlanetClickListener {

    private RecyclerView recyclerView;
    private PlanetaAdapter adapter;
    private List<Planeta> planetas;

    public PlanetasListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planetas_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = getContext();
        if (context != null) {
            planetas = RepositorioPlaneta.obterPlanetas(context);
            adapter = new PlanetaAdapter(planetas, this);

            recyclerView = view.findViewById(R.id.recyclerViewPlanetas);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onPlanetClick(Planeta planeta) {
        FragmentoInfoPlaneta fragment = new FragmentoInfoPlaneta();
        Bundle bundle = new Bundle();
        bundle.putSerializable("planeta", planeta);
        fragment.setArguments(bundle);

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).substituirFragmento(fragment, "FragmentoPlanetaInfo");
        }
    }
}