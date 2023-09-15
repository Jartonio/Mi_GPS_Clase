package com.example.migpsclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private MiGPS miGPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la instancia de MiGPS
        miGPS = new MiGPS(this);

        // Iniciar las actualizaciones de ubicación
        miGPS.startLocationUpdates();
    }
/*
    @Override
    protected void onStop() {
        super.onStop();

        // Detener las actualizaciones de ubicación cuando la actividad se detenga
        miGPS.stopLocationUpdates();
    }
  */

}