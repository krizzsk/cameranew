package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.a;
import com.google.firebase.analytics.connector.AnalyticsConnector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzd implements a.InterfaceC0166a {
    final /* synthetic */ zze zza;

    public zzd(zze zzeVar) {
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.measurement.api.a.InterfaceC0166a, com.google.android.gms.measurement.internal.q5
    public final void onEvent(String str, String str2, Bundle bundle, long j2) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzc.zzk(str2));
            analyticsConnectorListener = this.zza.zzb;
            analyticsConnectorListener.onMessageTriggered(2, bundle2);
        }
    }
}
