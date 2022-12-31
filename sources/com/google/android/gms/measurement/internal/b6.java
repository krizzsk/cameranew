package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class b6 implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b6(r6 r6Var, Bundle bundle) {
        this.b = r6Var;
        this.a = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r6 r6Var = this.b;
        Bundle bundle = this.a;
        r6Var.f();
        r6Var.h();
        com.google.android.gms.common.internal.q.j(bundle);
        com.google.android.gms.common.internal.q.f(bundle.getString("name"));
        if (!r6Var.a.i()) {
            r6Var.a.a().u().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            r6Var.a.P().K(new zzaa(bundle.getString(TapjoyConstants.TJC_APP_ID), bundle.getString(FirebaseAnalytics.Param.ORIGIN), new zzkg(bundle.getString("name"), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), r6Var.a.E().H(bundle.getString(TapjoyConstants.TJC_APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString(FirebaseAnalytics.Param.ORIGIN), bundle.getLong("creation_timestamp"), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
