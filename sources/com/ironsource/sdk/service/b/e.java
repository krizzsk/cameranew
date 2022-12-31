package com.ironsource.sdk.service.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: NetworkCallbackStrategy.java */
/* loaded from: classes2.dex */
public class e implements c {
    private String a = e.class.getSimpleName();
    private int b = 23;
    private final d c;

    /* renamed from: d  reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f5775d;

    /* compiled from: NetworkCallbackStrategy.java */
    /* loaded from: classes2.dex */
    class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network != null) {
                e.this.c.c(d.e.c.b.c(network, this.a), d.e.c.b.e(this.a, network));
                return;
            }
            d dVar = e.this.c;
            String b = d.e.c.b.b(this.a);
            Context context = this.a;
            dVar.c(b, d.e.c.b.e(context, d.e.c.b.a(context)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network != null) {
                e.this.c.b(d.e.c.b.c(network, this.a), d.e.c.b.e(this.a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (network != null) {
                e.this.c.b(d.e.c.b.c(network, this.a), d.e.c.b.e(this.a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (d.e.c.b.b(this.a).equals(PortalFollowFeeds.TYPE_NONE)) {
                e.this.c.a();
            }
        }
    }

    public e(d dVar) {
        this.c = dVar;
    }

    @Override // com.ironsource.sdk.service.b.c
    public JSONObject a(Context context) {
        return d.e.c.b.e(context, d.e.c.b.a(context));
    }

    @Override // com.ironsource.sdk.service.b.c
    @SuppressLint({"NewApi", "MissingPermission"})
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.b) {
            c(context);
            if (d.e.c.b.b(context).equals(PortalFollowFeeds.TYPE_NONE)) {
                this.c.a();
            }
            if (this.f5775d == null) {
                this.f5775d = new a(context);
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(build, this.f5775d);
                }
            } catch (Exception unused) {
                Log.e(this.a, "NetworkCallback was not able to register");
            }
        }
    }

    @Override // com.ironsource.sdk.service.b.c
    @SuppressLint({"NewApi"})
    public void c(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < this.b || this.f5775d == null || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.f5775d);
        } catch (Exception unused) {
            Log.e(this.a, "NetworkCallback for was not registered or already unregistered");
        }
    }

    @Override // com.ironsource.sdk.service.b.c
    public void release() {
        this.f5775d = null;
    }
}
