package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class g5 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f3796d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ h5 f3797e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5(h5 h5Var, String str, String str2, String str3, long j2) {
        this.f3797e = h5Var;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f3796d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9 i9Var2;
        String str = this.a;
        if (str == null) {
            i9Var2 = this.f3797e.a;
            i9Var2.u().O().w(this.b, null);
            return;
        }
        y6 y6Var = new y6(this.c, str, this.f3796d);
        i9Var = this.f3797e.a;
        i9Var.u().O().w(this.b, y6Var);
    }
}
