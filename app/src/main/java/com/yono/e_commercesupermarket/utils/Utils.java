package com.yono.e_commercesupermarket.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public void PesanToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
