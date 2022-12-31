package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.a;
import com.google.firebase.analytics.connector.AnalyticsConnector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzf implements a.InterfaceC0166a {
    final /* synthetic */ zzg zza;

    public zzf(zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.measurement.api.a.InterfaceC0166a, com.google.android.gms.measurement.internal.q5
    public final void onEvent(String str, String str2, Bundle bundle, long j2) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str == null || str.equals("crash") || !zzc.zzc(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j2);
        bundle2.putBundle("params", bundle);
        analyticsConnectorListener = this.zza.zza;
        analyticsConnectorListener.onMessageTriggered(3, bundle2);
    }
}
