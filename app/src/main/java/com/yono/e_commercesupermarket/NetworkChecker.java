package com.yono.e_commercesupermarket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkChecker extends BroadcastReceiver {
    public static Boolean status = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null){
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
            || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                status = true;
            }else {
                status = false;
            }
        }else {
            status = false;
        }
    }

    public Boolean getStatusJaringan(){ return status;}
}
