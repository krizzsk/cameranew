package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class y7 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzp f3997d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f3998e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ g8 f3999f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y7(g8 g8Var, AtomicReference atomicReference, String str, String str2, String str3, zzp zzpVar, boolean z) {
        this.f3999f = g8Var;
        this.a = atomicReference;
        this.b = str2;
        this.c = str3;
        this.f3997d = zzpVar;
        this.f3998e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        a3 a3Var;
        synchronized (this.a) {
            try {
                a3Var = this.f3999f.f3807d;
            } catch (RemoteException e2) {
                this.f3999f.a.a().m().d("(legacy) Failed to get user properties; remote exception", null, this.b, e2);
                this.a.set(Collections.emptyList());
                atomicReference = this.a;
            }
            if (a3Var == null) {
                this.f3999f.a.a().m().d("(legacy) Failed to get user properties; not connected to service", null, this.b, this.c);
                this.a.set(Collections.emptyList());
                this.a.notify();
                return;
            }
            if (TextUtils.isEmpty(null)) {
                com.google.android.gms.common.internal.q.j(this.f3997d);
                this.a.set(a3Var.o(this.b, this.c, this.f3998e, this.f3997d));
            } else {
                this.a.set(a3Var.E(null, this.b, this.c, this.f3998e));
            }
            this.f3999f.B();
            atomicReference = this.a;
            atomicReference.notify();
        }
    }
}
