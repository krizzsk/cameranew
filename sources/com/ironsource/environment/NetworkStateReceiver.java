package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes2.dex */
public class NetworkStateReceiver extends BroadcastReceiver {
    private ConnectivityManager a;
    private i b;
    private boolean c;

    public NetworkStateReceiver(Context context, i iVar) {
        this.b = iVar;
        this.a = (ConnectivityManager) context.getSystemService("connectivity");
        a();
    }

    private boolean a() {
        boolean z = this.c;
        NetworkInfo activeNetworkInfo = this.a.getActiveNetworkInfo();
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        this.c = z2;
        return z != z2;
    }

    private void b() {
        i iVar = this.b;
        if (iVar != null) {
            if (this.c) {
                iVar.c(true);
            } else {
                iVar.c(false);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if (intent == null || intent.getExtras() == null || !a()) {
            return;
        }
        b();
    }
}
