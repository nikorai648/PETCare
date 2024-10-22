package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class OpcionEliminarVeterinariaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_opcion_eliminar_veterinaria, container, false);

        // Ajustar el padding según las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configuración del botón "Eliminar"
        Button btnEliminar = view.findViewById(R.id.button28);
        btnEliminar.setOnClickListener(v -> {
            // Iniciar la actividad de Confirmación de Eliminación
            Intent intent = new Intent(getActivity(), ConfirmacionEliminacionProductoActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
