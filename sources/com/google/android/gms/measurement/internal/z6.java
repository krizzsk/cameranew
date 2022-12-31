package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class z6 implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ y6 b;
    final /* synthetic */ y6 c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f4010d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g7 f4011e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z6(g7 g7Var, Bundle bundle, y6 y6Var, y6 y6Var2, long j2) {
        this.f4011e = g7Var;
        this.a = bundle;
        this.b = y6Var;
        this.c = y6Var2;
        this.f4010d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g7.C(this.f4011e, this.a, this.b, this.c, this.f4010d);
    }
}
