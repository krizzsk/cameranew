package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzf;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.firebase.messaging.Constants;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class a4 implements Runnable {
    final /* synthetic */ zzf a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ b4 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a4(b4 b4Var, zzf zzfVar, ServiceConnection serviceConnection) {
        this.c = b4Var;
        this.a = zzfVar;
        this.b = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Bundle bundle;
        b4 b4Var = this.c;
        d4 d4Var = b4Var.b;
        str = b4Var.a;
        zzf zzfVar = this.a;
        ServiceConnection serviceConnection = this.b;
        d4Var.a.c().f();
        Bundle bundle2 = new Bundle();
        bundle2.putString("package_name", str);
        try {
            bundle = zzfVar.zzd(bundle2);
        } catch (Exception e2) {
            d4Var.a.a().m().b("Exception occurred while retrieving the Install Referrer", e2.getMessage());
        }
        if (bundle == null) {
            d4Var.a.a().m().a("Install Referrer Service returned a null response");
            bundle = null;
        }
        d4Var.a.c().f();
        if (bundle != null) {
            long j2 = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j2 == 0) {
                d4Var.a.a().p().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString(Constants.INSTALL_REFERRER);
                if (string != null && !string.isEmpty()) {
                    d4Var.a.a().u().b("InstallReferrer API result", string);
                    Bundle h0 = d4Var.a.E().h0(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (h0 == null) {
                        d4Var.a.a().m().a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = h0.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j3 = bundle.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j3 == 0) {
                                d4Var.a.a().m().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                h0.putLong("click_timestamp", j3);
                            }
                        }
                        if (j2 == d4Var.a.y().f4008k.a()) {
                            d4Var.a.a().u().a("Install Referrer campaign has already been logged");
                        } else {
                            zzlr.zzb();
                            if (!d4Var.a.x().u(null, x2.s0) || d4Var.a.i()) {
                                d4Var.a.y().f4008k.b(j2);
                                d4Var.a.a().u().b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                h0.putString("_cis", "referrer API");
                                d4Var.a.D().V("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, h0);
                            }
                        }
                    }
                } else {
                    d4Var.a.a().m().a("No referrer defined in Install Referrer response");
                }
            }
        }
        ConnectionTracker.getInstance().b(d4Var.a.zzaw(), serviceConnection);
    }
}
