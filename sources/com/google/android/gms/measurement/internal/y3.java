package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class y3 {
    private final String a;
    private boolean b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z3 f3991d;

    public y3(z3 z3Var, String str, String str2) {
        this.f3991d = z3Var;
        com.google.android.gms.common.internal.q.f(str);
        this.a = str;
    }

    @WorkerThread
    public final String a() {
        if (!this.b) {
            this.b = true;
            this.c = this.f3991d.n().getString(this.a, null);
        }
        return this.c;
    }

    @WorkerThread
    public final void b(String str) {
        SharedPreferences.Editor edit = this.f3991d.n().edit();
        edit.putString(this.a, str);
        edit.apply();
        this.c = str;
    }
}
