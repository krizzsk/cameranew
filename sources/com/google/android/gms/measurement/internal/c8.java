package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class c8 implements Runnable {
    final /* synthetic */ f8 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c8(f8 f8Var) {
        this.a = f8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g8 g8Var = this.a.c;
        Context zzaw = g8Var.a.zzaw();
        this.a.c.a.d();
        g8.v(g8Var, new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
