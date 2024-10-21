package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ClienteMenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_cliente_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Aquí puedes agregar los listeners y configuraciones para los botones o elementos del fragmento.
        // Ejemplo:
        view.findViewById(R.id.button7).setOnClickListener(v -> {
            // Código para manejar el clic en el botón 7
        });

        view.findViewById(R.id.button8).setOnClickListener(v -> {
            // Código para manejar el clic en el botón 8
        });

        view.findViewById(R.id.button9).setOnClickListener(v -> {
            // Código para manejar el clic en el botón 9
        });
    }
}
