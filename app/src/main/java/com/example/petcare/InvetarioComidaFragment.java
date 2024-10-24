package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class InvetarioComidaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_invetario_comida, container, false);

        // Configuración de las insets para el fragmento
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los botones
        Button btnAgregar = view.findViewById(R.id.btnAgregar);
        Button btnModificar = view.findViewById(R.id.btnModificar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);

        // Configurar los eventos de los botones
        btnAgregar.setOnClickListener(v -> {
            // Navegar al fragmento OpcionAgregarVeterinariaFragment
            OpcionAgregarVeterinariaFragment fragmentAgregar = new OpcionAgregarVeterinariaFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragmentAgregar); // Asegúrate de usar el id correcto del contenedor de fragmentos
            transaction.addToBackStack(null);
            transaction.commit();
        });

        btnModificar.setOnClickListener(v -> {
            // Navegar al fragmento OpcionModificarVeterinariaFragment
            OpcionModificarVeterinariaFragment fragmentModificar = new OpcionModificarVeterinariaFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragmentModificar); // Asegúrate de usar el id correcto del contenedor de fragmentos
            transaction.addToBackStack(null);
            transaction.commit();
        });

        btnEliminar.setOnClickListener(v -> {
            // Navegar al fragmento OpcionEliminarVeterinariaFragment
            OpcionEliminarVeterinariaFragment fragmentEliminar = new OpcionEliminarVeterinariaFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragmentEliminar); // Asegúrate de usar el id correcto del contenedor de fragmentos
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}

