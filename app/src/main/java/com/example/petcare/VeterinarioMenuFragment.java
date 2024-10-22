package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VeterinarioMenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_veterinario_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Asignar listeners a los botones usando if-else
        view.findViewById(R.id.button_record_clients).setOnClickListener(v -> {
            // Acción para el botón "Registrar Clientes"
        });

        view.findViewById(R.id.button_state_pets).setOnClickListener(v -> {
            // Acción para el botón "Estado de las Mascotas"
        });

        view.findViewById(R.id.button_inventory_vet).setOnClickListener(v -> {
            // Acción para el botón "Inventario"
            mostrarSubmenuInventario(view);
        });

        view.findViewById(R.id.button_call_clients).setOnClickListener(v -> {
            // Acción para el botón "Llamar a Clientes"
        });
    }

    // Método para mostrar el submenú de inventario
    private void mostrarSubmenuInventario(View view) {
        // Mostrar botones de submenú de inventario
        view.findViewById(R.id.submenu_inventario_title).setVisibility(View.VISIBLE);
        view.findViewById(R.id.button17).setVisibility(View.VISIBLE);  // Medicamentos
        view.findViewById(R.id.button18).setVisibility(View.VISIBLE);  // Herramientas
        view.findViewById(R.id.button19).setVisibility(View.VISIBLE);  // Comida Mascotas
        view.findViewById(R.id.button20).setVisibility(View.VISIBLE);  // Otros Productos
    }
}
