package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmpleadoActivity extends AppCompatActivity {

    // Definición de los campos del formulario
    private EditText editNombre, editApellido, editTelefono, editRut, editContrasena, editConfirmContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_empleado);

        // Ajustar ventanas para el modo Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de los campos del formulario
        editNombre = findViewById(R.id.editTextText2);         // Nombre
        editApellido = findViewById(R.id.editTextText7);       // Apellido
        editTelefono = findViewById(R.id.editTextPhone2);      // Teléfono
        editRut = findViewById(R.id.editTextText9);            // RUT
        editContrasena = findViewById(R.id.editTextTextPassword3);  // Contraseña
        editConfirmContrasena = findViewById(R.id.editTextTextPassword4);  // Confirmar contraseña

        // Botón para enviar el formulario
        Button btnEnviar = findViewById(R.id.button2);

        // Evento onClick para el botón de confirmación
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar si los campos están llenos y las contraseñas coinciden
                if (validarFormulario()) {
                    // Redirigir a VeterinarioMenuActivity si el formulario está completo
                    Intent intent = new Intent(EmpleadoActivity.this, VeterinarioMenuActivity.class);
                    startActivity(intent);
                } else {
                    // Mostrar mensaje de error si algún campo está vacío
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

        // Validar que todos los campos tienen contenido
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || rut.isEmpty() || contrasena.isEmpty() || confirmContrasena.isEmpty()) {
            return false;
        }

        // Validar que las contraseñas coinciden
        if (!contrasena.equals(confirmContrasena)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
