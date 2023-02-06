package com.example.broadcast_receiver_demo;
import static com.example.broadcast_receiver_demo.MainActivity.dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try
    {
        if (isOnline(context)) {
            dialog(true);
            Log.e("vishu", "Online Connect Intenet ");
        } else {
            dialog(false);
            Log.e("vishu", "Conectivity Failure !!! ");
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
    }




    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
