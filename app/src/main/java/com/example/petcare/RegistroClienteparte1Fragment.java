package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class RegistroClienteparte1Fragment extends Fragment {

    private final String[] clients = {"Cliente 1", "Cliente 2", "Cliente 3", "Cliente 4"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_registro_clienteparte1, container, false);

        // Aplica los Insets para ajustar el padding según las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar ListView
        ListView listViewClients = view.findViewById(R.id.listViewClients);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, clients);
        listViewClients.setAdapter(adapter);

        // Manejar clic en los elementos de la lista
        listViewClients.setOnItemClickListener((parent, view1, position, id) -> {
            // Dependiendo de la posición, puedes hacer algo diferente
            Intent intent = new Intent(getActivity(), RegistroClienteparte2Activity.class);
            startActivity(intent);
        });

        return view;
    }
}
