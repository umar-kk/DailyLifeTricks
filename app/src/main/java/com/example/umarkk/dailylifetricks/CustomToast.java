package com.example.umarkk.dailylifetricks;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CustomToast {
    public CustomToast(Context context) {
    }

    public void setCustomToast(Context context, String message) {
        if (VERSION.SDK_INT >= 21) {
            View toastRoot = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
            TextView textView = (TextView) toastRoot.findViewById(R.id.my_custom_toast);
            textView.setText(message);
//            textView.setTypeface(TypefaceUtil.getCalibriLight());
            Toast toast = new Toast(context);
            toast.setView(toastRoot);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Toast.makeText(context, message, 0).show();
    }
}
