package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class w3 {
    private final String a;
    private final long b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private long f3959d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ z3 f3960e;

    public w3(z3 z3Var, String str, long j2) {
        this.f3960e = z3Var;
        com.google.android.gms.common.internal.q.f(str);
        this.a = str;
        this.b = j2;
    }

    @WorkerThread
    public final long a() {
        if (!this.c) {
            this.c = true;
            this.f3959d = this.f3960e.n().getLong(this.a, this.b);
        }
        return this.f3959d;
    }

    @WorkerThread
    public final void b(long j2) {
        SharedPreferences.Editor edit = this.f3960e.n().edit();
        edit.putLong(this.a, j2);
        edit.apply();
        this.f3959d = j2;
    }
}
