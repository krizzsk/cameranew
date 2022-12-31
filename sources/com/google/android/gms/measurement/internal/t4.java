package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class t4 implements Callable<List<l9>> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ h5 f3940d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t4(h5 h5Var, String str, String str2, String str3) {
        this.f3940d = h5Var;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ List<l9> call() throws Exception {
        i9 i9Var;
        i9 i9Var2;
        i9Var = this.f3940d.a;
        i9Var.n();
        i9Var2 = this.f3940d.a;
        return i9Var2.X().S(this.a, this.b, this.c);
    }
}
