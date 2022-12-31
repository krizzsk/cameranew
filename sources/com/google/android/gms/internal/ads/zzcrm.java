package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcrm<DelegateT, AdapterT> implements zzcrj<AdapterT> {
    private final zzcrj<DelegateT> zzgsv;
    private final zzdvz<DelegateT, AdapterT> zzgsw;

    public zzcrm(zzcrj<DelegateT> zzcrjVar, zzdvz<DelegateT, AdapterT> zzdvzVar) {
        this.zzgsv = zzcrjVar;
        this.zzgsw = zzdvzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        return this.zzgsv.zza(zzdnlVar, zzdmwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<AdapterT> zzb(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        return zzdzk.zzb(this.zzgsv.zzb(zzdnlVar, zzdmwVar), this.zzgsw, zzazp.zzeic);
    }
}
