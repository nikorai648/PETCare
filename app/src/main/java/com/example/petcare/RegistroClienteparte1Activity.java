package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroClienteparte1Activity extends AppCompatActivity {

    private String[] clients = {"Cliente 1", "Cliente 2", "Cliente 3", "Cliente 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registro_clienteparte1);

        // Aplicar márgenes de ventana para el diseño
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar ListView
        ListView listViewClients = findViewById(R.id.listViewClients);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clients);
        listViewClients.setAdapter(adapter);

        // Manejar clic en los elementos de la lista
        listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Manda a la actividad RegistroClienteparte2Activity
                Intent intent = new Intent(RegistroClienteparte1Activity.this, RegistroClienteparte2Activity.class);
                startActivity(intent);
            }
        });
    }
}
