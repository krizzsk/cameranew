package com.google.android.gms.internal.ads;

import com.tencent.tauth.AuthActivity;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcph implements zzbrr, zzbtb, zzbua {
    private final zzdrz zzdic;
    private final zzayy zzebw;
    private final zzdsa zzgqf;

    public zzcph(zzdsa zzdsaVar, zzdrz zzdrzVar, zzayy zzayyVar) {
        this.zzgqf = zzdsaVar;
        this.zzdic = zzdrzVar;
        this.zzebw = zzayyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void onAdLoaded() {
        this.zzdic.zzb(this.zzgqf.zzu(AuthActivity.ACTION_KEY, "loaded"));
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzb(zzdnl zzdnlVar) {
        this.zzgqf.zza(zzdnlVar, this.zzebw);
    }

    @Override // com.google.android.gms.internal.ads.zzbrr
    public final void zzc(zzvg zzvgVar) {
        this.zzgqf.zzu(AuthActivity.ACTION_KEY, "ftl").zzu("ftl", String.valueOf(zzvgVar.errorCode)).zzu("ed", zzvgVar.zzchh);
        this.zzdic.zzb(this.zzgqf);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzd(zzatq zzatqVar) {
        this.zzgqf.zzq(zzatqVar.zzdxi);
    }
}
