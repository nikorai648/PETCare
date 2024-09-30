package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ClienteMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cliente_menu);

        // Ajustar ventanas para el modo Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los botones
        Button btnSolicitarHorario = findViewById(R.id.button7);
        Button btnRevisarFechaHorario = findViewById(R.id.button8);
        Button btnOrdenarProducto = findViewById(R.id.button9);

        // Listener para el botón "Solicitar horario de atención"
        btnSolicitarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClienteMenuActivity.this, SeleccionAtencionHoraActivity.class);
                startActivity(intent);
            }
        });

        // Listener para el botón "Revisar fecha y horario de atención"
        btnRevisarFechaHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClienteMenuActivity.this, RevisionHorarioAtencionActivity.class);
                startActivity(intent);
            }
        });

        // Listener para el botón "Ordenar Producto"
        btnOrdenarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClienteMenuActivity.this, OpcionOrdenarVeterinariaActivity.class);
                startActivity(intent);
            }
        });
    }
}
