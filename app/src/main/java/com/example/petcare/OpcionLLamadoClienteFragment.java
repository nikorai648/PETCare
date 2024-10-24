package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OpcionLLamadoClienteFragment extends Fragment {

    private ListView listViewClientes;
    private String[] clientes = {"Cliente 1", "Cliente 2", "Cliente 3"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para el fragmento
        View view = inflater.inflate(R.layout.fragment_opcion_llamado_cliente, container, false);

        // Referencia al ListView
        listViewClientes = view.findViewById(R.id.listViewClientes);

        // Adapter para mostrar la lista de clientes
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.list_item_cliente, R.id.textViewCliente, clientes);
        listViewClientes.setAdapter(adapter);

        // Evento de clic en los elementos de la lista
        listViewClientes.setOnItemClickListener((adapterView, view1, position, id) -> {
            String clienteSeleccionado = clientes[position];
            Toast.makeText(requireContext(), "Llamando a " + clienteSeleccionado, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
