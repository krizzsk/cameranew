package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddy<S extends zzdfj<?>> implements zzdfi<S> {
    private final ScheduledExecutorService zzfth;
    private final zzdfi<S> zzhbo;
    private final long zzhcl;

    public zzddy(zzdfi<S> zzdfiVar, long j2, ScheduledExecutorService scheduledExecutorService) {
        this.zzhbo = zzdfiVar;
        this.zzhcl = j2;
        this.zzfth = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<S> zzasy() {
        zzdzw<S> zzasy = this.zzhbo.zzasy();
        long j2 = this.zzhcl;
        if (j2 > 0) {
            zzasy = zzdzk.zza(zzasy, j2, TimeUnit.MILLISECONDS, this.zzfth);
        }
        return zzdzk.zzb(zzasy, Throwable.class, zzdeb.zzboq, zzazp.zzeih);
    }
}
