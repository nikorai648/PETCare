package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public abstract class VeterinarioMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinario_menu);

        // Configuración del DrawerLayout y NavigationView
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Toggle para el menú lateral
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Opción seleccionada por defecto
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_record_clients);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Manejo del menú lateral usando if-else
        int recordClientsId = R.id.nav_record_clients;
        int statePetsId = R.id.nav_state_pets;
        int inventoryVetId = R.id.nav_inventory_vet;
        int callClientsId = R.id.nav_call_clients;

        if (item.getItemId() == recordClientsId) {
            startActivity(new Intent(this, RegistroClienteparte1Activity.class));
        } else if (item.getItemId() == statePetsId) {
            startActivity(new Intent(this, RegistroClienteparte2Activity.class));
        } else if (item.getItemId() == inventoryVetId) {
            mostrarSubmenuInventario();  // Mostrar el submenú de inventario
        } else if (item.getItemId() == callClientsId) {
            startActivity(new Intent(this, OpcionLLamadoClienteActivity.class));
        }

        // Cerrar el Drawer después de la selección
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Método para mostrar el submenú de inventario
    private void mostrarSubmenuInventario() {
        findViewById(R.id.submenu_inventario_title).setVisibility(View.VISIBLE);
        findViewById(R.id.button17).setVisibility(View.VISIBLE);  // Medicamentos
        findViewById(R.id.button18).setVisibility(View.VISIBLE);  // Herramientas
        findViewById(R.id.button19).setVisibility(View.VISIBLE);  // Comida Mascotas
        findViewById(R.id.button20).setVisibility(View.VISIBLE);  // Otros Productos
    }
}
