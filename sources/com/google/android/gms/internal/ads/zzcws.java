package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcws implements com.google.android.gms.ads.internal.zzg {
    private final zzbye zzfuq;
    private final zzbsd zzgci;
    private final zzbrl zzgcj;
    private final zzbjz zzgck;
    private final zzbxz zzgcm;
    private AtomicBoolean zzgwt = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcws(zzbrl zzbrlVar, zzbsd zzbsdVar, zzbye zzbyeVar, zzbxz zzbxzVar, zzbjz zzbjzVar) {
        this.zzgcj = zzbrlVar;
        this.zzgci = zzbsdVar;
        this.zzfuq = zzbyeVar;
        this.zzgcm = zzbxzVar;
        this.zzgck = zzbjzVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        if (this.zzgwt.compareAndSet(false, true)) {
            this.zzgck.onAdImpression();
            this.zzgcm.zzv(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkc() {
        if (this.zzgwt.get()) {
            this.zzgcj.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkd() {
        if (this.zzgwt.get()) {
            this.zzgci.onAdImpression();
            this.zzfuq.zzamr();
        }
    }
}
