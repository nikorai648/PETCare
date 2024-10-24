package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class InventarioOtrosProductosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_inventario_otros_productos, container, false);

        // Inicializar los botones
        Button btnAgregar = view.findViewById(R.id.btnAgregar);
        Button btnModificar = view.findViewById(R.id.btnModificar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);

        // Configurar las acciones de los botones para navegar a los fragmentos
        btnAgregar.setOnClickListener(v -> {
            // Reemplazar con OpcionAgregarVeterinariaFragment
            replaceFragment(new OpcionAgregarVeterinariaFragment());
        });

        btnModificar.setOnClickListener(v -> {
            // Reemplazar con OpcionModificarVeterinariaFragment
            replaceFragment(new OpcionModificarVeterinariaFragment());
        });

        btnEliminar.setOnClickListener(v -> {
            // Reemplazar con OpcionEliminarVeterinariaFragment
            replaceFragment(new OpcionEliminarVeterinariaFragment());
        });

        return view;
    }

    // Método para reemplazar el fragmento actual
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment); // 'fragment_container' es el id del contenedor de fragmentos en tu layout principal
        transaction.addToBackStack(null); // Permitir volver atrás al fragmento anterior
        transaction.commit();
    }
}
