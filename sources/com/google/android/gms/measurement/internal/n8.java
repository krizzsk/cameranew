package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class n8 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ u8 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n8(u8 u8Var, long j2) {
        this.b = u8Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u8.n(this.b, this.a);
    }
}
