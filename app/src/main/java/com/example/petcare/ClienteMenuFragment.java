package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ClienteMenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cliente_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Botón 1: Solicitar horario de atención -> SeleccionAtencionHoraFragment
        view.findViewById(R.id.button7).setOnClickListener(v -> {
            SeleccionAtencionHoraFragment fragment = new SeleccionAtencionHoraFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);  // Asegúrate de que `fragment_container` sea el ID del contenedor en tu actividad.
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Botón 2: Revisar fecha y horario de atención -> RevisionHorarioAtencionFragment
        view.findViewById(R.id.button8).setOnClickListener(v -> {
            RevisionHorarioAtencionFragment fragment = new RevisionHorarioAtencionFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Botón 3: Ordenar Producto -> OpcionOrdenarVeterinariaFragment
        view.findViewById(R.id.button9).setOnClickListener(v -> {
            OpcionOrdenarVeterinariaFragment fragment = new OpcionOrdenarVeterinariaFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}
