package com.example.isma.serviciomusica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MiBroadcast extends BroadcastReceiver {
    public MiBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        context.stopService(new Intent(context,MiservicioMusica.class));
    }
}
