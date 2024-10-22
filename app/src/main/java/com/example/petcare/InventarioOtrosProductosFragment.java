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

public class InventarioOtrosProductosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_inventario_otros_productos, container, false);

        // Aplicar el listener para el manejo de WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los botones
        Button btnAgregar = view.findViewById(R.id.btnAgregar);
        Button btnModificar = view.findViewById(R.id.btnModificar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);

        // Configurar las acciones de los botones
        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), OpcionAgregarVeterinariaActivity.class);
            startActivity(intent);
        });

        btnModificar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), OpcionModificarVeterinariaActivity.class);
            startActivity(intent);
        });

        btnEliminar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), OpcionEliminarVeterinariaActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
