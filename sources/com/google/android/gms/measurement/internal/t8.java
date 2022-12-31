package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzll;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class t8 {
    final /* synthetic */ u8 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t8(u8 u8Var) {
        this.a = u8Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a() {
        this.a.f();
        if (this.a.a.y().u(this.a.a.zzax().currentTimeMillis())) {
            this.a.a.y().q.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.a.a.a().u().a("Detected application was in foreground");
                c(this.a.a.zzax().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(long j2, boolean z) {
        this.a.f();
        this.a.q();
        if (this.a.a.y().u(j2)) {
            this.a.a.y().q.b(true);
        }
        this.a.a.y().t.b(j2);
        if (this.a.a.y().q.a()) {
            c(j2, z);
        }
    }

    @WorkerThread
    final void c(long j2, boolean z) {
        this.a.f();
        if (this.a.a.i()) {
            this.a.a.y().t.b(j2);
            this.a.a.a().u().b("Session started, time", Long.valueOf(this.a.a.zzax().a()));
            Long valueOf = Long.valueOf(j2 / 1000);
            this.a.a.D().n("auto", "_sid", valueOf, j2);
            this.a.a.y().q.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.a.a.x().u(null, x2.j0) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.a.a.D().W("auto", "_s", j2, bundle);
            zzll.zzb();
            if (this.a.a.x().u(null, x2.o0)) {
                String a = this.a.a.y().y.a();
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a);
                this.a.a.D().W("auto", "_ssr", j2, bundle2);
            }
        }
    }
}
