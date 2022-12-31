package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgz implements zzair {
    private final zzbsm zzfwu;
    @Nullable
    private final zzavj zzgjq;
    private final String zzgjr;
    private final String zzgjs;

    public zzcgz(zzbsm zzbsmVar, zzdmw zzdmwVar) {
        this.zzfwu = zzbsmVar;
        this.zzgjq = zzdmwVar.zzdwm;
        this.zzgjr = zzdmwVar.zzdmf;
        this.zzgjs = zzdmwVar.zzdmg;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    @ParametersAreNonnullByDefault
    public final void zza(zzavj zzavjVar) {
        String str;
        int i2;
        zzavj zzavjVar2 = this.zzgjq;
        if (zzavjVar2 != null) {
            zzavjVar = zzavjVar2;
        }
        if (zzavjVar != null) {
            str = zzavjVar.type;
            i2 = zzavjVar.zzdzc;
        } else {
            str = "";
            i2 = 1;
        }
        this.zzfwu.zzb(new zzaui(str, i2), this.zzgjr, this.zzgjs);
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final void zzuc() {
        this.zzfwu.onRewardedVideoStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final void zzud() {
        this.zzfwu.onRewardedVideoCompleted();
    }
}
