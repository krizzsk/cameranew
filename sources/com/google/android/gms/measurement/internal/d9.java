package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzlc;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class d9 implements Callable<String> {
    final /* synthetic */ zzp a;
    final /* synthetic */ i9 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d9(i9 i9Var, zzp zzpVar) {
        this.b = i9Var;
        this.a = zzpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ String call() throws Exception {
        zzlc.zzb();
        if (!this.b.U().u(null, x2.y0) || (this.b.j0(this.a.zza).h() && f.c(this.a.zzv).h())) {
            return this.b.A(this.a).O();
        }
        this.b.a().u().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
