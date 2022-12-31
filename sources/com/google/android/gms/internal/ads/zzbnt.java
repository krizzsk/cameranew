package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbnt {
    protected final zzdmw zzesr;
    protected final zzdnl zzfrd;
    private final zzbsg zzfwe;
    private final zzbsw zzfwf;
    @Nullable
    private final zzdkk zzfwg;
    private final zzbrh zzfwh;
    private final zzbud zzfwi;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbnt(zzbnw zzbnwVar) {
        this.zzfrd = zzbnw.zza(zzbnwVar);
        this.zzesr = zzbnw.zzb(zzbnwVar);
        this.zzfwe = zzbnw.zzc(zzbnwVar);
        this.zzfwf = zzbnw.zzd(zzbnwVar);
        this.zzfwg = zzbnw.zze(zzbnwVar);
        this.zzfwh = zzbnw.zzf(zzbnwVar);
        this.zzfwi = zzbnw.zzg(zzbnwVar);
    }

    public void destroy() {
        this.zzfwe.zzcd(null);
    }

    public void zzakb() {
        this.zzfwf.onAdLoaded();
    }

    public final zzbsg zzakq() {
        return this.zzfwe;
    }

    public final zzbrh zzakr() {
        return this.zzfwh;
    }

    @Nullable
    public final zzdkk zzaks() {
        return this.zzfwg;
    }

    public final zzbve zzakt() {
        return this.zzfwi.zzakt();
    }
}
