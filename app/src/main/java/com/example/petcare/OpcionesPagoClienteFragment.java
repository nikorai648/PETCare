package com.example.petcare;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OpcionesPagoClienteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Infla el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_opciones_pago_cliente, container, false);

        // Ajustar los insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar botones si es necesario
        Button btnFirstOption = view.findViewById(R.id.button10);
        Button btnSecondOption = view.findViewById(R.id.button11);
        Button btnThirdOption = view.findViewById(R.id.button12);

        // Configura las acciones para los botones aquí
        btnFirstOption.setOnClickListener(v -> {
            // Acción para la primera opción
        });

        btnSecondOption.setOnClickListener(v -> {
            // Acción para la segunda opción
        });

        btnThirdOption.setOnClickListener(v -> {
            // Acción para la tercera opción
        });

        return view;
    }
}

