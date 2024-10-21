package com.example.petcare;



import static com.example.petcare.R.id.nav_record_clients;
import static com.example.petcare.R.id.nav_state_pets;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

public class VeterinarioMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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

        // Si se desea que una actividad se cargue por defecto
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(nav_record_clients);  // Usamos la constante de R.id directamente
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Manejo del menú lateral
        switch (item.getItemId()) {
            case R.id.nav_record_clients:
                startActivity(new Intent(VeterinarioMenuActivity.this, RegistroClienteparte1Activity.class));
                break;
            case  R.id.nav_state_pets:
                startActivity(new Intent(VeterinarioMenuActivity.this, RegistroClienteparte2Activity.class));
                break;
            case R.id.nav_inventory_vet:
                mostrarSubmenuInventario();  // Mostrar el submenú de inventario
                break;
            case R.id.nav_call_clients:
                startActivity(new Intent(VeterinarioMenuActivity.this, OpcionLLamadoClienteActivity.class));
                break;

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
