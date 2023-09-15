package com.example.migpsclase;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.ActivityCompat;

public class MiGPS implements LocationListener {

    private Context context;
    private LocationManager locationManager;

    public MiGPS(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            //return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, this);
    }

    public void stopLocationUpdates() {
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Log.d("Coordenadas", "Latitud: " + latitude + ", Longitud: " + longitude);
        // Aquí puedes usar la ubicación obtenida (location)
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Manejar cambios en el estado del proveedor de ubicación
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Manejar la habilitación del proveedor de ubicación
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Manejar la deshabilitación del proveedor de ubicación
    }
}