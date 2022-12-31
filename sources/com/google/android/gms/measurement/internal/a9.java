package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class a9 implements Runnable {
    final /* synthetic */ zzke a;
    final /* synthetic */ i9 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a9(i9 i9Var, zzke zzkeVar) {
        this.b = i9Var;
        this.a = zzkeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9.E(this.b, this.a);
        this.b.T();
    }
}
