package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class n4 implements Runnable {
    final /* synthetic */ r5 a;
    final /* synthetic */ o4 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n4(o4 o4Var, r5 r5Var) {
        this.b = o4Var;
        this.a = r5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o4.r(this.b, this.a);
        this.b.w(this.a.f3923g);
    }
}
