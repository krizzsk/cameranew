package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class g0 extends h {

    /* renamed from: e  reason: collision with root package name */
    private final Context f3676e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f3677f;
    @GuardedBy("connectionStatus")

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<h.a, i0> f3675d = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final ConnectionTracker f3678g = ConnectionTracker.getInstance();

    /* renamed from: h  reason: collision with root package name */
    private final long f3679h = 5000;

    /* renamed from: i  reason: collision with root package name */
    private final long f3680i = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(Context context) {
        this.f3676e = context.getApplicationContext();
        this.f3677f = new zzi(context.getMainLooper(), new h0(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.h
    public final boolean d(h.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        q.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3675d) {
            i0 i0Var = this.f3675d.get(aVar);
            if (i0Var == null) {
                i0Var = new i0(this, aVar);
                i0Var.a(serviceConnection, serviceConnection, str);
                i0Var.c(str);
                this.f3675d.put(aVar, i0Var);
            } else {
                this.f3677f.removeMessages(0, aVar);
                if (!i0Var.e(serviceConnection)) {
                    i0Var.a(serviceConnection, serviceConnection, str);
                    int f2 = i0Var.f();
                    if (f2 == 1) {
                        serviceConnection.onServiceConnected(i0Var.j(), i0Var.i());
                    } else if (f2 == 2) {
                        i0Var.c(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = i0Var.d();
        }
        return d2;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final void e(h.a aVar, ServiceConnection serviceConnection, String str) {
        q.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3675d) {
            i0 i0Var = this.f3675d.get(aVar);
            if (i0Var != null) {
                if (i0Var.e(serviceConnection)) {
                    i0Var.b(serviceConnection, str);
                    if (i0Var.h()) {
                        this.f3677f.sendMessageDelayed(this.f3677f.obtainMessage(0, aVar), this.f3679h);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 76);
                    sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 50);
                sb2.append("Nonexistent connection status for service config: ");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
