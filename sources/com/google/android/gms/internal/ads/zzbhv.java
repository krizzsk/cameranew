package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbhv implements zzbzx {
    private zzbqx zzeyy;
    private zzdnl zzeyz;
    private zzdkv zzezc;
    private zzdjx zzezd;
    private zzbwg zzezg;
    private final /* synthetic */ zzbgz zzffq;
    private zzcxa zzfmf;

    private zzbhv(zzbgz zzbgzVar) {
        this.zzffq = zzbgzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqy
    public final /* synthetic */ zzbqy<zzbzy> zza(zzdjx zzdjxVar) {
        this.zzezd = zzdjxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbqy
    /* renamed from: zzahx */
    public final zzbzy zzagm() {
        zzeqh.zza(this.zzezg, zzbwg.class);
        zzeqh.zza(this.zzeyy, zzbqx.class);
        zzeqh.zza(this.zzfmf, zzcxa.class);
        return new zzbhu(this.zzffq, new zzbpa(), new zzdon(), new zzbqh(), new zzcle(), this.zzezg, this.zzeyy, new zzdor(), this.zzfmf, this.zzeyz, this.zzezc, this.zzezd);
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* synthetic */ zzbzx zzb(zzcxa zzcxaVar) {
        this.zzfmf = (zzcxa) zzeqh.checkNotNull(zzcxaVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* synthetic */ zzbzx zze(zzbqx zzbqxVar) {
        this.zzeyy = (zzbqx) zzeqh.checkNotNull(zzbqxVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbqy
    public final /* synthetic */ zzbqy<zzbzy> zza(zzdkv zzdkvVar) {
        this.zzezc = zzdkvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* synthetic */ zzbzx zze(zzbwg zzbwgVar) {
        this.zzezg = (zzbwg) zzeqh.checkNotNull(zzbwgVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbqy
    public final /* synthetic */ zzbqy<zzbzy> zza(zzdnl zzdnlVar) {
        this.zzeyz = zzdnlVar;
        return this;
    }
}
