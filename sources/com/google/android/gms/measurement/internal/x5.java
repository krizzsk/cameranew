package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class x5 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f3975d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f3976e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ boolean f3977f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f3978g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ String f3979h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ r6 f3980i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x5(r6 r6Var, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f3980i = r6Var;
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.f3975d = bundle;
        this.f3976e = z;
        this.f3977f = z2;
        this.f3978g = z3;
        this.f3979h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3980i.X(this.a, this.b, this.c, this.f3975d, this.f3976e, this.f3977f, this.f3978g, this.f3979h);
    }
}
