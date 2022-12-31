package com.unity3d.splash.services.core.connectivity;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
@TargetApi(21)
/* loaded from: classes3.dex */
public class b extends ConnectivityManager.NetworkCallback {
    private static b a;

    public static void a() {
        if (a == null) {
            a = new b();
            ((ConnectivityManager) com.unity3d.splash.services.c.b.a.b().getSystemService("connectivity")).registerNetworkCallback(new NetworkRequest.Builder().build(), a);
        }
    }

    public static void b() {
        if (a != null) {
            ((ConnectivityManager) com.unity3d.splash.services.c.b.a.b().getSystemService("connectivity")).unregisterNetworkCallback(a);
            a = null;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        a.b();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        a.c();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        a.c();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        a.d();
    }
}
