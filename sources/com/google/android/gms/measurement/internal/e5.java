package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class e5 implements Callable<List<l9>> {
    final /* synthetic */ String a;
    final /* synthetic */ h5 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e5(h5 h5Var, String str) {
        this.b = h5Var;
        this.a = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ List<l9> call() throws Exception {
        i9 i9Var;
        i9 i9Var2;
        i9Var = this.b.a;
        i9Var.n();
        i9Var2 = this.b.a;
        return i9Var2.X().R(this.a);
    }
}
