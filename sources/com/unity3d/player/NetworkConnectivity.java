package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
/* loaded from: classes3.dex */
public class NetworkConnectivity extends Activity {
    private final int a = 0;
    private final int b = 1;
    private final int c = 2;

    /* renamed from: d  reason: collision with root package name */
    private int f8346d;

    /* renamed from: e  reason: collision with root package name */
    private ConnectivityManager f8347e;

    /* renamed from: f  reason: collision with root package name */
    private final ConnectivityManager.NetworkCallback f8348f;

    public NetworkConnectivity(Context context) {
        this.f8346d = 0;
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.unity3d.player.NetworkConnectivity.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                NetworkConnectivity networkConnectivity;
                int i2;
                super.onCapabilitiesChanged(network, networkCapabilities);
                if (networkCapabilities.hasTransport(0)) {
                    networkConnectivity = NetworkConnectivity.this;
                    i2 = 1;
                } else {
                    networkConnectivity = NetworkConnectivity.this;
                    i2 = 2;
                }
                networkConnectivity.f8346d = i2;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                NetworkConnectivity.this.f8346d = 0;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onUnavailable() {
                super.onUnavailable();
                NetworkConnectivity.this.f8346d = 0;
            }
        };
        this.f8348f = networkCallback;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f8347e = connectivityManager;
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
        NetworkInfo activeNetworkInfo = this.f8347e.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        this.f8346d = activeNetworkInfo.getType() != 0 ? 2 : 1;
    }

    public final int a() {
        return this.f8346d;
    }

    public final void b() {
        this.f8347e.unregisterNetworkCallback(this.f8348f);
    }
}
