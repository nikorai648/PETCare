package com.example.petcare;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public abstract class ClienteMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_menu);

        // Configuración del DrawerLayout y NavigationView
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Toggle para el menú lateral
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Cargar el fragmento por defecto si es la primera vez que se crea la actividad
        if (savedInstanceState == null) {
            cargarFragmento(new ClienteMenuFragment());
            navigationView.setCheckedItem(R.id.nav_request_opening_hours);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Declarar IDs constantes
        int requestOpeningHoursId = R.id.nav_request_opening_hours;
        int checkDateOperationHoursId = R.id.nav_check_date_operation_hours;
        int orderProductId = R.id.nav_order_product;

        Fragment fragment = null;

        // Usar if-else para manejar los casos, en lugar de switch
        if (item.getItemId() == requestOpeningHoursId) {
            fragment = new SeleccionAtencionHoraFragment();
        } else if (item.getItemId() == checkDateOperationHoursId) {
            fragment = new RevisionHorarioAtencionFragment();
        } else if (item.getItemId() == orderProductId) {
            fragment = new OpcionOrdenarVeterinariaFragment();
        }

        if (fragment != null) {
            cargarFragmento(fragment);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Método para cargar fragmentos en el contenedor
    private void cargarFragmento(Fragment fragmento) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmento);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
