package com.example.bodegaexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * LoginActivity: Control de acceso simple.
 * Conceptos: Captura de datos de EditText, Validación, Paso de parámetros (putExtra).
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias a los componentes de la interfaz
        EditText etUser = findViewById(R.id.etUser);
        EditText etPass = findViewById(R.id.etPass);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = etUser.getText().toString().trim();
            String pass = etPass.getText().toString().trim();

            // Lógica de negocio básica
            if (!user.isEmpty() && !pass.isEmpty()) {
                // Preparamos el salto a la siguiente actividad
                Intent intent = new Intent(LoginActivity.this, Bienvenida.class);
                // "PutExtra" permite enviar datos a la siguiente pantalla (Clave, Valor)
                intent.putExtra("USER_NAME", user);
                startActivity(intent);
                finish(); // Cerramos el Login para que no vuelva al presionar "atrás"
            } else {
                // Notificación rápida al usuario usando recursos de string
                Toast.makeText(LoginActivity.this, getString(R.string.msg_fill_fields), Toast.LENGTH_SHORT).show();
            }
        });
    }
}