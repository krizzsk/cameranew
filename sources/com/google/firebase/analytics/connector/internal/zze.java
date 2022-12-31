package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.measurement.api.a;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zze implements zza {
    final Set<String> zza;
    private final AnalyticsConnector.AnalyticsConnectorListener zzb;
    private final a zzc;
    private final zzd zzd;

    public zze(a aVar, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = aVar;
        zzd zzdVar = new zzd(this);
        this.zzd = zzdVar;
        aVar.q(zzdVar);
        this.zza = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set<String> set) {
        this.zza.clear();
        Set<String> set2 = this.zza;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzc.zzj(str) && zzc.zzi(str)) {
                String zzl = zzc.zzl(str);
                q.j(zzl);
                hashSet.add(zzl);
            }
        }
        set2.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
        this.zza.clear();
    }
}
