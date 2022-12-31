package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class r3 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ s3 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(s3 s3Var, boolean z) {
        this.b = s3Var;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9Var = this.b.a;
        i9Var.C(this.a);
    }
}
