package com.unity3d.splash.services.core.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class ConnectivityChangeReceiver extends BroadcastReceiver {
    private static ConnectivityChangeReceiver a;

    public static void a() {
        if (a == null) {
            a = new ConnectivityChangeReceiver();
            com.unity3d.splash.services.c.b.a.b().registerReceiver(a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public static void b() {
        if (a != null) {
            com.unity3d.splash.services.c.b.a.b().unregisterReceiver(a);
            a = null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if (intent.getBooleanExtra("noConnectivity", false)) {
            a.d();
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        a.b();
    }
}
