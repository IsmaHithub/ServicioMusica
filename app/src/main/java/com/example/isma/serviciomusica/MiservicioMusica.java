package com.example.isma.serviciomusica;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MiservicioMusica extends Service {
    //Variables
    private  MediaPlayer reproductor;
    private MiBroadcast mibroadcast;

    public MiservicioMusica() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show();
        reproductor = MediaPlayer.create(this, R.raw.pista1);

        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
        mibroadcast=new MiBroadcast();
        registerReceiver(mibroadcast,screenStateFilter);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        reproductor.start();
        return START_STICKY;  //aunque pulses varias veces el botón “Arrancar servicio”, este no vuelve a crearse, pero sí que vuelve a llamarse al método onStartCommand()
        //Además, con solo una vez que pulses en “Detener servicio” este parará.
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        reproductor.stop();
        unregisterReceiver(mibroadcast);
        super.onDestroy();
    }
}
