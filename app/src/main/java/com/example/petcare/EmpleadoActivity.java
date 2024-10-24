package com.example.petcare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class EmpleadoActivity extends AppCompatActivity {

    // Define los campos del formulario
    private EditText editNombre, editApellido, editTelefono, editRut, editContrasena, editConfirmContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);  // Cambié la disposición para evitar conflictos con EdgeToEdge.

        // Los campos del formulario
        editNombre = findViewById(R.id.editTextText2);         // Nombre
        editApellido = findViewById(R.id.editTextText7);       // Apellido
        editTelefono = findViewById(R.id.editTextPhone2);      // Teléfono
        editRut = findViewById(R.id.editTextText9);            // RUT
        editContrasena = findViewById(R.id.editTextTextPassword3);  // Contraseña
        editConfirmContrasena = findViewById(R.id.editTextTextPassword4);  // Confirmar contraseña

        // Botón para enviar el formulario
        Button btnEnviar = findViewById(R.id.button2);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Valida si los campos están llenos y las contraseñas coinciden
                if (validarFormulario()) {
                    // Manda al VeterinarioMenuFragment si el formulario está completo
                    cargarVeterinarioMenuFragment();
                } else {
                    // Muestra el mensaje de error si algún campo está vacío
                    Toast.makeText(EmpleadoActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
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

        // Valida que todos los campos tienen contenido
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || rut.isEmpty() || contrasena.isEmpty() || confirmContrasena.isEmpty()) {
            return false;
        }

        // Valida que las contraseñas coincidan
        if (!contrasena.equals(confirmContrasena)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    // Método para cargar VeterinarioMenuFragment
    private void cargarVeterinarioMenuFragment() {
        // Crear una instancia de VeterinarioMenuFragment
        Fragment veterinarioMenuFragment = new VeterinarioMenuFragment();

        // Utilizar el FragmentManager para cargar el fragmento en el contenedor
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, veterinarioMenuFragment); // R.id.fragment_container es el contenedor en activity_empleado.xml
        fragmentTransaction.addToBackStack(null); // Esto permite que el usuario pueda regresar si es necesario
        fragmentTransaction.commit(); // Realizar la transacción
    }
}
