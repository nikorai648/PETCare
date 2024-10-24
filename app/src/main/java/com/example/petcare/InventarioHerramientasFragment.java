package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class InventarioHerramientasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_inventario_herramientas, container, false);

        // Encuentra los botones
        Button btnAgregar = view.findViewById(R.id.btnAgregar);
        Button btnModificar = view.findViewById(R.id.btnModificar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);

        // Configura los listeners para los botones, cambiando de fragmento según el botón presionado
        btnAgregar.setOnClickListener(v -> {
            // Navegar al fragmento OpcionAgregarVeterinariaFragment
            replaceFragment(new OpcionAgregarVeterinariaFragment());
        });

        btnModificar.setOnClickListener(v -> {
            // Navegar al fragmento OpcionModificarVeterinariaFragment
            replaceFragment(new OpcionModificarVeterinariaFragment());
        });

        btnEliminar.setOnClickListener(v -> {
            // Navegar al fragmento OpcionEliminarVeterinariaFragment
            replaceFragment(new OpcionEliminarVeterinariaFragment());
        });

        return view;
    }

    // Método para reemplazar el fragmento actual por el fragmento deseado
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);  // Cambia 'fragment_container' por el ID del contenedor donde están los fragmentos
        transaction.addToBackStack(null); // Agregar a la pila para poder volver atrás
        transaction.commit();
    }
}


