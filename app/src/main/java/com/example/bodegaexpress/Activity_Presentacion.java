package com.example.bodegaexpress;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de presentación (Splash Screen).
 * Conceptos clave para los alumnos:
 * 1. Handler y Looper para ejecutar código de forma diferida (temporizador).
 * 2. Intent explícito para navegar de una actividad a otra.
 * 3. Método finish() para destruir la actividad actual y evitar regresar a ella con el botón "Atrás".
 */
public class Activity_Presentacion extends AppCompatActivity {

    // Tiempo de espera en milisegundos (3 segundos)
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        // Usamos Handler asociado al hilo principal (Looper.getMainLooper())
        // para programar el paso al Login después de SPLASH_TIME_OUT milisegundos.
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Crear el Intent para ir a LoginActivity
            Intent intent = new Intent(Activity_Presentacion.this, LoginActivity.class);
            startActivity(intent);

            // Destruir SplashActivity para que no quede en la pila de navegación (Back Stack)
            finish();
        }, SPLASH_TIME_OUT);
    }
}