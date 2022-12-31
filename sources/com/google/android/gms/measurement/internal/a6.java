package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class a6 implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a6(r6 r6Var, Bundle bundle) {
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
        String string = bundle.getString("name");
        String string2 = bundle.getString(FirebaseAnalytics.Param.ORIGIN);
        com.google.android.gms.common.internal.q.f(string);
        com.google.android.gms.common.internal.q.f(string2);
        com.google.android.gms.common.internal.q.j(bundle.get(FirebaseAnalytics.Param.VALUE));
        if (!r6Var.a.i()) {
            r6Var.a.a().u().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkg zzkgVar = new zzkg(string, bundle.getLong("triggered_timestamp"), bundle.get(FirebaseAnalytics.Param.VALUE), string2);
        try {
            zzas H = r6Var.a.E().H(bundle.getString(TapjoyConstants.TJC_APP_ID), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, false);
            r6Var.a.P().K(new zzaa(bundle.getString(TapjoyConstants.TJC_APP_ID), string2, zzkgVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), r6Var.a.E().H(bundle.getString(TapjoyConstants.TJC_APP_ID), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, false), bundle.getLong("trigger_timeout"), H, bundle.getLong("time_to_live"), r6Var.a.E().H(bundle.getString(TapjoyConstants.TJC_APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
