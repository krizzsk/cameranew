package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class y5 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f3992d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ r6 f3993e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y5(r6 r6Var, String str, String str2, Object obj, long j2) {
        this.f3993e = r6Var;
        this.a = str;
        this.b = str2;
        this.c = obj;
        this.f3992d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3993e.n(this.a, this.b, this.c, this.f3992d);
    }
}
