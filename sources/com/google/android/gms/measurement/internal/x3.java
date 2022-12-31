package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.location.LocationRequestCompat;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class x3 {
    final String a;
    private final String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3973d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ z3 f3974e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x3(z3 z3Var, String str, long j2, t3 t3Var) {
        this.f3974e = z3Var;
        com.google.android.gms.common.internal.q.f("health_monitor");
        com.google.android.gms.common.internal.q.a(j2 > 0);
        this.a = "health_monitor:start";
        this.b = "health_monitor:count";
        this.c = "health_monitor:value";
        this.f3973d = j2;
    }

    @WorkerThread
    private final void c() {
        this.f3974e.f();
        long currentTimeMillis = this.f3974e.a.zzax().currentTimeMillis();
        SharedPreferences.Editor edit = this.f3974e.n().edit();
        edit.remove(this.b);
        edit.remove(this.c);
        edit.putLong(this.a, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    private final long d() {
        return this.f3974e.n().getLong(this.a, 0L);
    }

    @WorkerThread
    public final void a(String str, long j2) {
        this.f3974e.f();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = "";
        }
        long j3 = this.f3974e.n().getLong(this.b, 0L);
        if (j3 <= 0) {
            SharedPreferences.Editor edit = this.f3974e.n().edit();
            edit.putString(this.c, str);
            edit.putLong(this.b, 1L);
            edit.apply();
            return;
        }
        long nextLong = this.f3974e.a.E().f0().nextLong();
        long j4 = j3 + 1;
        long j5 = LocationRequestCompat.PASSIVE_INTERVAL / j4;
        SharedPreferences.Editor edit2 = this.f3974e.n().edit();
        if ((nextLong & LocationRequestCompat.PASSIVE_INTERVAL) < j5) {
            edit2.putString(this.c, str);
        }
        edit2.putLong(this.b, j4);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> b() {
        long abs;
        this.f3974e.f();
        this.f3974e.f();
        long d2 = d();
        if (d2 == 0) {
            c();
            abs = 0;
        } else {
            abs = Math.abs(d2 - this.f3974e.a.zzax().currentTimeMillis());
        }
        long j2 = this.f3973d;
        if (abs < j2) {
            return null;
        }
        if (abs > j2 + j2) {
            c();
            return null;
        }
        String string = this.f3974e.n().getString(this.c, null);
        long j3 = this.f3974e.n().getLong(this.b, 0L);
        c();
        if (string != null && j3 > 0) {
            return new Pair<>(string, Long.valueOf(j3));
        }
        return z3.C;
    }
}
