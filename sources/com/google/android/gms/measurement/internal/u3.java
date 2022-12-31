package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class u3 {
    private final String a;
    private final boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3943d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ z3 f3944e;

    public u3(z3 z3Var, String str, boolean z) {
        this.f3944e = z3Var;
        com.google.android.gms.common.internal.q.f(str);
        this.a = str;
        this.b = z;
    }

    @WorkerThread
    public final boolean a() {
        if (!this.c) {
            this.c = true;
            this.f3943d = this.f3944e.n().getBoolean(this.a, this.b);
        }
        return this.f3943d;
    }

    @WorkerThread
    public final void b(boolean z) {
        SharedPreferences.Editor edit = this.f3944e.n().edit();
        edit.putBoolean(this.a, z);
        edit.apply();
        this.f3943d = z;
    }
}
