package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbno implements zzbtb, zzqw {
    private final zzdmw zzfrj;
    private final zzbsd zzfvw;
    private final zzbtf zzfvx;
    private final AtomicBoolean zzfvy = new AtomicBoolean();
    private final AtomicBoolean zzfvz = new AtomicBoolean();

    public zzbno(zzdmw zzdmwVar, zzbsd zzbsdVar, zzbtf zzbtfVar) {
        this.zzfrj = zzdmwVar;
        this.zzfvw = zzbsdVar;
        this.zzfvx = zzbtfVar;
    }

    private final void zzako() {
        if (this.zzfvy.compareAndSet(false, true)) {
            this.zzfvw.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final synchronized void onAdLoaded() {
        if (this.zzfrj.zzhiz != 1) {
            zzako();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        if (this.zzfrj.zzhiz == 1 && zzqxVar.zzbrj) {
            zzako();
        }
        if (zzqxVar.zzbrj && this.zzfvz.compareAndSet(false, true)) {
            this.zzfvx.zzalq();
        }
    }
}
