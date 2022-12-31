package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.a;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzg implements zza {
    private final AnalyticsConnector.AnalyticsConnectorListener zza;
    private final a zzb;
    private final zzf zzc;

    public zzg(a aVar, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = aVar;
        zzf zzfVar = new zzf(this);
        this.zzc = zzfVar;
        aVar.q(zzfVar);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
    }
}
