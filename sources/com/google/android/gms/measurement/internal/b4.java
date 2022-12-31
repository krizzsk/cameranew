package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class b4 implements ServiceConnection {
    private final String a;
    final /* synthetic */ d4 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b4(d4 d4Var, String str) {
        this.b = d4Var;
        this.a = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                zzf zzb = zze.zzb(iBinder);
                if (zzb == null) {
                    this.b.a.a().p().a("Install Referrer Service implementation was not found");
                    return;
                }
                this.b.a.a().u().a("Install Referrer Service connected");
                this.b.a.c().p(new a4(this, zzb, this));
                return;
            } catch (Exception e2) {
                this.b.a.a().p().b("Exception occurred while calling Install Referrer API", e2);
                return;
            }
        }
        this.b.a.a().p().a("Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.b.a.a().u().a("Install Referrer Service disconnected");
    }
}
