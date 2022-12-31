package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcwg extends zzcvj {
    private final zzbvm zzgwf;

    public zzcwg(zzbrl zzbrlVar, zzbsd zzbsdVar, zzbsm zzbsmVar, zzbsw zzbswVar, zzbrt zzbrtVar, zzbvt zzbvtVar, zzbyp zzbypVar, zzbtj zzbtjVar, zzbyk zzbykVar, zzbvm zzbvmVar) {
        super(zzbrlVar, zzbsdVar, zzbsmVar, zzbswVar, zzbrtVar, zzbvtVar, zzbypVar, zzbtjVar, zzbykVar, zzbvmVar);
        this.zzgwf = zzbvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwl, com.google.android.gms.internal.ads.zzank
    public final void onAdImpression() {
        this.zzgwf.zzale();
    }
}
