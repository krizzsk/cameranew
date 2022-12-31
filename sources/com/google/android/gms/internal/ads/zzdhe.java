package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhe implements zzdfi<zzdhf> {
    private Context context;
    private ScheduledExecutorService zzfri;
    private zzarw zzhes;

    public zzdhe(zzarw zzarwVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzhes = zzarwVar;
        this.zzfri = scheduledExecutorService;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdhf> zzasy() {
        return zzdzk.zzb(zzdzk.zza(this.zzhes.zzo(this.context), ((Long) zzwr.zzqr().zzd(zzabp.zzctx)).longValue(), TimeUnit.MILLISECONDS, this.zzfri), zzdhh.zzeaj, zzazp.zzeic);
    }
}
