package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class i3 {
    private final int a;
    private final boolean b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ k3 f3833d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3(k3 k3Var, int i2, boolean z, boolean z2) {
        this.f3833d = k3Var;
        this.a = i2;
        this.b = z;
        this.c = z2;
    }

    public final void a(String str) {
        this.f3833d.w(this.a, this.b, this.c, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        this.f3833d.w(this.a, this.b, this.c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f3833d.w(this.a, this.b, this.c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f3833d.w(this.a, this.b, this.c, str, obj, obj2, obj3);
    }
}
