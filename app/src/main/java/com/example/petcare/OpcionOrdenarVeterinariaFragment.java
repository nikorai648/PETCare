package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.Navigation;

public class OpcionOrdenarVeterinariaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opcion_ordenar_veterinaria, container, false);

        // Ajuste para ventanas del sistema
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Botón "OK"
        Button btnOK = view.findViewById(R.id.button25);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los campos de entrada
                EditText productoEditText = view.findViewById(R.id.editTextText12);
                EditText tipoEditText = view.findViewById(R.id.editTextText15);
                EditText emailEditText = view.findViewById(R.id.editTextText16);
                EditText entregaEditText = view.findViewById(R.id.editTextText17);

                // Validar que los campos no estén vacíos
                String producto = productoEditText.getText().toString().trim();
                String tipo = tipoEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String entrega = entregaEditText.getText().toString().trim();

                if (producto.isEmpty() || tipo.isEmpty() || email.isEmpty() || entrega.isEmpty()) {
                    // Mostrar un mensaje de error si los campos están vacíos
                    Toast.makeText(getContext(), "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Usar el componente de navegación para cambiar de fragmento
                    Navigation.findNavController(v).navigate(R.id.action_opcionOrdenarVeterinaria_to_opcionesPagoCliente);
                }
            }
        });

        return view;
    }
}
