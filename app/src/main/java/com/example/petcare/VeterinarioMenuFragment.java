package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class VeterinarioMenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_veterinario_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtén el NavController
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Asignar listeners a los botones
        view.findViewById(R.id.button_record_clients).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_registroClienteParte1)
        );

        view.findViewById(R.id.button_state_pets).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_registroClienteParte2)
        );

        view.findViewById(R.id.button_inventory_vet).setOnClickListener(v ->
                mostrarSubmenuInventario(view)
        );

        view.findViewById(R.id.button_call_clients).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_opcionLlamadoCliente)
        );
    }

    // Método para mostrar el submenú de inventario
    private void mostrarSubmenuInventario(View view) {
        // Mostrar botones de submenú de inventario
        view.findViewById(R.id.submenu_inventario_title).setVisibility(View.VISIBLE);
        view.findViewById(R.id.button17).setVisibility(View.VISIBLE);  // Medicamentos
        view.findViewById(R.id.button18).setVisibility(View.VISIBLE);  // Herramientas
        view.findViewById(R.id.button19).setVisibility(View.VISIBLE);  // Comida Mascotas
        view.findViewById(R.id.button20).setVisibility(View.VISIBLE);  // Otros Productos

        // Obtener el NavController una vez
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Asignar acciones a los botones del submenú
        view.findViewById(R.id.button17).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_medicamentosFragment)
        );

        view.findViewById(R.id.button18).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_herramientasFragment)
        );

        view.findViewById(R.id.button19).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_comidaMascotasFragment)
        );

        view.findViewById(R.id.button20).setOnClickListener(v ->
                navController.navigate(R.id.action_veterinarioMenu_to_otrosProductosFragment)
        );
    }
}
