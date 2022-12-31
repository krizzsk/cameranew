package com.google.android.gms.measurement.internal;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class h3 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Object f3813d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Object f3814e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ k3 f3815f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3(k3 k3Var, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f3815f = k3Var;
        this.a = i2;
        this.b = str;
        this.c = obj;
        this.f3813d = obj2;
        this.f3814e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        long j2;
        char c2;
        long j3;
        z3 y = this.f3815f.a.y();
        if (y.i()) {
            c = this.f3815f.c;
            if (c == 0) {
                if (this.f3815f.a.x().o()) {
                    k3 k3Var = this.f3815f;
                    k3Var.a.d();
                    k3Var.c = 'C';
                } else {
                    k3 k3Var2 = this.f3815f;
                    k3Var2.a.d();
                    k3Var2.c = 'c';
                }
            }
            j2 = this.f3815f.f3846d;
            if (j2 < 0) {
                k3 k3Var3 = this.f3815f;
                k3Var3.a.x().n();
                k3Var3.f3846d = 39000L;
            }
            char charAt = "01VDIWEA?".charAt(this.a);
            c2 = this.f3815f.c;
            j3 = this.f3815f.f3846d;
            String y2 = k3.y(true, this.b, this.c, this.f3813d, this.f3814e);
            StringBuilder sb = new StringBuilder(String.valueOf(y2).length() + 24);
            sb.append("2");
            sb.append(charAt);
            sb.append(c2);
            sb.append(j3);
            sb.append(":");
            sb.append(y2);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.b.substring(0, 1024);
            }
            x3 x3Var = y.f4001d;
            if (x3Var != null) {
                x3Var.a(sb2, 1L);
                return;
            }
            return;
        }
        Log.println(6, this.f3815f.x(), "Persisted config not initialized. Not logging error/warn");
    }
}
