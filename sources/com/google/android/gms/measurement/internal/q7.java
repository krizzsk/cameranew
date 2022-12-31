package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class q7 implements Runnable {
    final /* synthetic */ zzas a;
    final /* synthetic */ String b;
    final /* synthetic */ zzs c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g8 f3918d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q7(g8 g8Var, zzas zzasVar, String str, zzs zzsVar) {
        this.f3918d = g8Var;
        this.a = zzasVar;
        this.b = str;
        this.c = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o4 o4Var;
        a3 a3Var;
        byte[] bArr = null;
        try {
            try {
                a3Var = this.f3918d.f3807d;
                if (a3Var == null) {
                    this.f3918d.a.a().m().a("Discarding data. Failed to send event to service to bundle");
                    o4Var = this.f3918d.a;
                } else {
                    bArr = a3Var.e0(this.a, this.b);
                    this.f3918d.B();
                    o4Var = this.f3918d.a;
                }
            } catch (RemoteException e2) {
                this.f3918d.a.a().m().b("Failed to send event to the service to bundle", e2);
                o4Var = this.f3918d.a;
            }
            o4Var.E().S(this.c, bArr);
        } catch (Throwable th) {
            this.f3918d.a.E().S(this.c, bArr);
            throw th;
        }
    }
}
