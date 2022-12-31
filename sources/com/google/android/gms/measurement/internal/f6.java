package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class f6 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f3786d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ r6 f3787e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f6(r6 r6Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f3787e = r6Var;
        this.a = atomicReference;
        this.b = str2;
        this.c = str3;
        this.f3786d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3787e.a.P().N(this.a, null, this.b, this.c, this.f3786d);
    }
}
