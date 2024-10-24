package com.example.petcare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InventarioMedicamentosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_inventario_medicamentos, container, false);

        // Aplicar WindowInsetsListener para bordes del sistema
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los botones
        Button btnAgregar = view.findViewById(R.id.btnAgregar);
        Button btnModificar = view.findViewById(R.id.btnModificar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);

        // Obtener el FragmentManager
        FragmentManager fragmentManager = getParentFragmentManager();

        // Acciones de los botones para navegar entre fragmentos
        btnAgregar.setOnClickListener(v -> {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, new OpcionAgregarVeterinariaFragment());
            transaction.addToBackStack(null);  // Agregar la transacción a la pila para poder volver
            transaction.commit();
        });

        btnModificar.setOnClickListener(v -> {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, new OpcionModificarVeterinariaFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Usar NavController para la navegación del botón Eliminar
        btnEliminar.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_medicamentos_to_confirmacion_eliminacion);
        });

        return view;
    }
}

