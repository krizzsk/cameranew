package com.google.android.gms.internal.ads;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbyi implements zzbyf {
    private final List<String> zzdwa;
    private final zzdss zzfrf;
    private boolean zzgbc;

    public zzbyi(zzdmw zzdmwVar, zzdss zzdssVar) {
        this.zzdwa = zzdmwVar.zzdwa;
        this.zzfrf = zzdssVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyf
    public final void zzamr() {
        if (this.zzgbc) {
            return;
        }
        this.zzfrf.zzk(this.zzdwa);
        this.zzgbc = true;
    }
}
