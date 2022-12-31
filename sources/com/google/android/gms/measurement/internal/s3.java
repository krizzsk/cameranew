package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class s3 extends BroadcastReceiver {
    private final i9 a;
    private boolean b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(i9 i9Var) {
        com.google.android.gms.common.internal.q.j(i9Var);
        this.a = i9Var;
    }

    @WorkerThread
    public final void a() {
        this.a.f0();
        this.a.c().f();
        if (this.b) {
            return;
        }
        this.a.zzaw().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.c = this.a.W().k();
        this.a.a().u().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.c));
        this.b = true;
    }

    @WorkerThread
    public final void b() {
        this.a.f0();
        this.a.c().f();
        this.a.c().f();
        if (this.b) {
            this.a.a().u().a("Unregistering connectivity change receiver");
            this.b = false;
            this.c = false;
            try {
                this.a.zzaw().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.a.a().m().b("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        this.a.f0();
        String action = intent.getAction();
        this.a.a().u().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean k2 = this.a.W().k();
            if (this.c != k2) {
                this.c = k2;
                this.a.c().p(new r3(this, k2));
                return;
            }
            return;
        }
        this.a.a().p().b("NetworkBroadcastReceiver received unknown action", action);
    }
}
