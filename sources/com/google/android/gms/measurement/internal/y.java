package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class y implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ a2 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a2 a2Var, String str, long j2) {
        this.c = a2Var;
        this.a = str;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a2.k(this.c, this.a, this.b);
    }
}
