package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class l6 implements Runnable {
    final /* synthetic */ Boolean a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l6(r6 r6Var, Boolean bool) {
        this.b = r6Var;
        this.a = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.J(this.a, true);
    }
}
