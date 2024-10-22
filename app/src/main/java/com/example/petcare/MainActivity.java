package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEmpleado = findViewById(R.id.btnEmpleado);
        Button btnCliente = findViewById(R.id.btnCliente);

        // Cargar el fragmento VeterinarioMenuFragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new VeterinarioMenuFragment());
        transaction.commit();

        // código para el botón de Empleado
        btnEmpleado.setOnClickListener(v -> {
            // Redirigir a la actividad de Empleado
            Intent intent = new Intent(MainActivity.this, EmpleadoActivity.class);
            startActivity(intent);
        });

        // código para el botón de Cliente
        btnCliente.setOnClickListener(v -> {
            // Cargar el fragmento OpcionOrdenarVeterinariaFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new OpcionOrdenarVeterinariaFragment())
                    .addToBackStack(null) // Para permitir volver al anterior
                    .commit();

            // Cargar el fragmento RevisionHorarioAtencionFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RevisionHorarioAtencionFragment())
                    .addToBackStack(null) // Para permitir volver al anterior
                    .commit();

            // Cargar el fragmento SeleccionAtencionHoraFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SeleccionAtencionHoraFragment())
                    .addToBackStack(null) // Para permitir volver al anterior
                    .commit();

            // Cargar el fragmento OpcionesPagoClienteFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new OpcionesPagoClienteFragment())
                    .addToBackStack(null) // Para permitir volver al anterior
                    .commit();
        });
    }
}
