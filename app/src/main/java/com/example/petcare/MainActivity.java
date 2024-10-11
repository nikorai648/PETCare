package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnEmpleado = findViewById(R.id.btnEmpleado);
        Button btnCliente = findViewById(R.id.btnCliente);

        // codigo para el botón de Empleado
        btnEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad de Empleado
                Intent intent = new Intent(MainActivity.this, EmpleadoActivity.class);
                startActivity(intent);
            }
        });

        // codigo para el botón de Cliente
        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad de Cliente
                Intent intent = new Intent(MainActivity.this, ClienteSeleccionadoActivity.class);
                startActivity(intent);
            }
        });
    }
}