package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private CheckBox checkBoxEmpleado;
    private CheckBox checkBoxCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referenciar los elementos del layout
        EditText emailField = findViewById(R.id.emailField);
        EditText passwordField = findViewById(R.id.passwordField);
        checkBoxEmpleado = findViewById(R.id.checkboxEmpleado);
        checkBoxCliente = findViewById(R.id.checkboxCliente);
        CheckBox checkBoxRememberMe = findViewById(R.id.checkboxRememberMe);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView registerLink = findViewById(R.id.registerLink);

        // Listeners para los checkbox
        checkBoxEmpleado.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxCliente.setChecked(false);
            }
        });

        checkBoxCliente.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxEmpleado.setChecked(false);
            }
        });

        // Acción del botón de Login
        btnLogin.setOnClickListener(v -> {
            if (checkBoxCliente.isChecked()) {
                // Si el checkbox de cliente está seleccionado, mostrar ClienteMenuFragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ClienteMenuFragment())
                        .addToBackStack(null)
                        .commit();
            } else if (checkBoxEmpleado.isChecked()) {
                // Si el checkbox de empleado está seleccionado, mostrar VeterinarioMenuFragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new VeterinarioMenuFragment())
                        .addToBackStack(null)
                        .commit();
            } else {
                Toast.makeText(LoginActivity.this, "Selecciona Cliente o Empleado", Toast.LENGTH_SHORT).show();
            }
        });

        // Acción del enlace de registro
        registerLink.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
