package com.example.petcare;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OpcionLLamadoClienteActivity extends AppCompatActivity {

    private ListView listViewClientes;
    private String[] clientes = {"Cliente 1", "Cliente 2", "Cliente 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_opcion_llamado_cliente);

        // Referencia al ListView
        listViewClientes = findViewById(R.id.listViewClientes);

        // Adapter para mostrar la lista de clientes
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_cliente, R.id.textViewCliente, clientes);
        listViewClientes.setAdapter(adapter);

        // Evento de clic en los elementos de la lista
        listViewClientes.setOnItemClickListener((adapterView, view, position, id) -> {
            String clienteSeleccionado = clientes[position];
            Toast.makeText(OpcionLLamadoClienteActivity.this, "Llamando a " + clienteSeleccionado, Toast.LENGTH_SHORT).show();
        });
    }
}
