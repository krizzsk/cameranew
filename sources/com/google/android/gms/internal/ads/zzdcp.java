package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcp implements zzeqb<zzdmu> {
    private final zzeqo<Clock> zzfsz;

    public zzdcp(zzeqo<Clock> zzeqoVar) {
        this.zzfsz = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzdmu) zzeqh.zza(new zzdmu(this.zzfsz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
