package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class u4 implements Callable<List<zzaa>> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ h5 f3945d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u4(h5 h5Var, String str, String str2, String str3) {
        this.f3945d = h5Var;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ List<zzaa> call() throws Exception {
        i9 i9Var;
        i9 i9Var2;
        i9Var = this.f3945d.a;
        i9Var.n();
        i9Var2 = this.f3945d.a;
        return i9Var2.X().W(this.a, this.b, this.c);
    }
}
