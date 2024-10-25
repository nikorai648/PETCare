package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OpcionEliminarVeterinariaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_opcion_eliminar_veterinaria);

        // Aplicar márgenes de ventana para el diseño
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Para el botón "Eliminar"
        Button btnEliminar = findViewById(R.id.button28);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Manda a la actividad ConfirmacionEliminacionProductoActivity
                Intent intent = new Intent(OpcionEliminarVeterinariaActivity.this, ConfirmacionEliminacionProductoActivity.class);
                startActivity(intent);
            }
        });
    }
}

