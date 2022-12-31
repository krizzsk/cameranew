package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class k8 implements Runnable {
    final /* synthetic */ i9 a;
    final /* synthetic */ Runnable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k8(zzjh zzjhVar, i9 i9Var, Runnable runnable) {
        this.a = i9Var;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.n();
        this.a.m(this.b);
        this.a.i();
    }
}
