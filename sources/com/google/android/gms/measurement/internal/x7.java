package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class x7 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ zzp c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzs f3981d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f3982e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x7(g8 g8Var, String str, String str2, zzp zzpVar, zzs zzsVar) {
        this.f3982e = g8Var;
        this.a = str;
        this.b = str2;
        this.c = zzpVar;
        this.f3981d = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o4 o4Var;
        a3 a3Var;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                a3Var = this.f3982e.f3807d;
                if (a3Var == null) {
                    this.f3982e.a.a().m().c("Failed to get conditional properties; not connected to service", this.a, this.b);
                    o4Var = this.f3982e.a;
                } else {
                    com.google.android.gms.common.internal.q.j(this.c);
                    arrayList = n9.W(a3Var.k(this.a, this.b, this.c));
                    this.f3982e.B();
                    o4Var = this.f3982e.a;
                }
            } catch (RemoteException e2) {
                this.f3982e.a.a().m().d("Failed to get conditional properties; remote exception", this.a, this.b, e2);
                o4Var = this.f3982e.a;
            }
            o4Var.E().V(this.f3981d, arrayList);
        } catch (Throwable th) {
            this.f3982e.a.E().V(this.f3981d, arrayList);
            throw th;
        }
    }
}
