package com.example.petcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OpcionesMenuInventarioActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones_menu_inventario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnMedicamentos = findViewById(R.id.button17);
        Button btnHerramientas = findViewById(R.id.button18);
        Button btnComidaMascotas = findViewById(R.id.button19);
        Button btnOtrosProductos = findViewById(R.id.button20);


        btnMedicamentos.setOnClickListener(v -> {
            Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InventarioMedicamentosActivity.class);
            startActivity(intent);
        });


        btnHerramientas.setOnClickListener(v -> {
            Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InventarioHerramientasActivity.class);
            startActivity(intent);
        });


        btnComidaMascotas.setOnClickListener(v -> {
            Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InvetarioComidaActivity.class);
            startActivity(intent);
        });


        btnOtrosProductos.setOnClickListener(v -> {
            Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InventarioOtrosProductosActivity.class);
            startActivity(intent);
        });
    }
}
