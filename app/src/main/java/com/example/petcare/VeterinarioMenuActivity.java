package com.example.petcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class VeterinarioMenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_veterinario_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Configurar el botón de menú en el action bar
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Manejar los clicks en el menú lateral
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_record_clients:
                    Intent intentClientes = new Intent(VeterinarioMenuActivity.this, RegistroClienteparte1Activity.class);
                    startActivity(intentClientes);
                    break;

                case R.id.nav_state_pets:
                    Intent intentEstadoMascotas = new Intent(VeterinarioMenuActivity.this, RegistroClienteparte2Activity.class);
                    startActivity(intentEstadoMascotas);
                    break;

                case R.id.nav_inventory_vet:
                    Intent intentInventario = new Intent(VeterinarioMenuActivity.this, OpcionesMenuInventarioActivity.class);
                    startActivity(intentInventario);
                    break;

                case R.id.nav_call_clients:
                    Intent intentLlamado = new Intent(VeterinarioMenuActivity.this, OpcionLLamadoClienteActivity.class);
                    startActivity(intentLlamado);
                    break;

                default:
                    Toast.makeText(VeterinarioMenuActivity.this, "Opción no válida", Toast.LENGTH_SHORT).show();
                    break;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    // Manejar el evento de abrir el menú lateral cuando se hace clic en el ícono del menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
