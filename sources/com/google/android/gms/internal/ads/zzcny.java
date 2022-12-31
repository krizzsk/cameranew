package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcny implements zzcnz {
    private final zzdzv zzghl;
    private final Map<String, zzeqo<zzcnz>> zzgpd;
    private final zzbtz zzgpe;

    public zzcny(Map<String, zzeqo<zzcnz>> map, zzdzv zzdzvVar, zzbtz zzbtzVar) {
        this.zzgpd = map;
        this.zzghl = zzdzvVar;
        this.zzgpe = zzbtzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final zzdzw<zzdnl> zzh(final zzatq zzatqVar) {
        this.zzgpe.zzd(zzatqVar);
        zzdzw<zzdnl> immediateFailedFuture = zzdzk.immediateFailedFuture(new zzcmb(zzdom.NO_FILL));
        for (String str : ((String) zzwr.zzqr().zzd(zzabp.zzczv)).split(",")) {
            final zzeqo<zzcnz> zzeqoVar = this.zzgpd.get(str.trim());
            if (zzeqoVar != null) {
                immediateFailedFuture = zzdzk.zzb(immediateFailedFuture, zzcmb.class, new zzdyu(zzeqoVar, zzatqVar) { // from class: com.google.android.gms.internal.ads.zzcnx
                    private final zzatq zzgnq;
                    private final zzeqo zzgpc;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgpc = zzeqoVar;
                        this.zzgnq = zzatqVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyu
                    public final zzdzw zzf(Object obj) {
                        zzeqo zzeqoVar2 = this.zzgpc;
                        zzcmb zzcmbVar = (zzcmb) obj;
                        return ((zzcnz) zzeqoVar2.get()).zzh(this.zzgnq);
                    }
                }, this.zzghl);
            }
        }
        zzdzk.zza(immediateFailedFuture, new zzcoa(this), zzazp.zzeih);
        return immediateFailedFuture;
    }
}
