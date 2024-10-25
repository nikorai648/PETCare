package com.example.petcare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class ClienteSeleccionadoActivity extends AppCompatActivity {

    // Definición de los campos del formulario
    private EditText editNombre, editApellido, editTelefono, editRut, editContrasena, editConfirmContrasena, editNombresMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_seleccionado);

        // Ajustar ventanas para el modo Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        // Inicialización de los campos del formulario
        editNombre = findViewById(R.id.editTextText3);
        editApellido = findViewById(R.id.editTextText4);
        editTelefono = findViewById(R.id.editTextPhone);
        editRut = findViewById(R.id.editTextText5);
        editContrasena = findViewById(R.id.editTextTextPassword);
        editConfirmContrasena = findViewById(R.id.editTextTextPassword2);
        editNombresMascotas = findViewById(R.id.editTextText6);

        // Botón para enviar el formulario
        Button btnEnviar = findViewById(R.id.button);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Valida si los campos están llenos y las contraseñas coinciden
                if (validarFormulario()) {
                    // Si el formulario está completo, cargar ClienteMenuFragment
                    cargarClienteMenuFragment();
                } else {
                    // Muestra mensaje de error si algún campo está vacío
                    Toast.makeText(ClienteSeleccionadoActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para validar si los campos están llenos y las contraseñas coinciden
    private boolean validarFormulario() {
        String nombre = editNombre.getText().toString().trim();
        String apellido = editApellido.getText().toString().trim();
        String telefono = editTelefono.getText().toString().trim();
        String rut = editRut.getText().toString().trim();
        String contrasena = editContrasena.getText().toString().trim();
        String confirmContrasena = editConfirmContrasena.getText().toString().trim();
        String nombresMascotas = editNombresMascotas.getText().toString().trim();

        // Valida que todos los campos tienen contenido
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || rut.isEmpty() || contrasena.isEmpty() || confirmContrasena.isEmpty() || nombresMascotas.isEmpty()) {
            return false;
        }

        // Valida que las contraseñas coinciden
        if (!contrasena.equals(confirmContrasena)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    // Método para cargar el ClienteMenuFragment
    private void cargarClienteMenuFragment() {
        ClienteMenuFragment clienteMenuFragment = new ClienteMenuFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, clienteMenuFragment);
        transaction.addToBackStack(null); // Permite volver al formulario si se necesita
        transaction.commit();
    }
}
