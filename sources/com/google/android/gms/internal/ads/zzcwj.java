package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcwj implements zzbsx {
    private final /* synthetic */ zzcrl zzgvx;
    private boolean zzgwj = false;
    private final /* synthetic */ zzbaa zzgwk;
    private final /* synthetic */ zzcwi zzgwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcwj(zzcwi zzcwiVar, zzcrl zzcrlVar, zzbaa zzbaaVar) {
        this.zzgwl = zzcwiVar;
        this.zzgvx = zzcrlVar;
        this.zzgwk = zzbaaVar;
    }

    private final void zzm(zzvg zzvgVar) {
        zzdom zzdomVar = zzdom.INTERNAL_ERROR;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcwj)).booleanValue()) {
            zzdomVar = zzdom.NO_FILL;
        }
        this.zzgwk.setException(new zzcrn(zzdomVar, zzvgVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbsx
    public final void onAdFailedToLoad(int i2) {
        if (this.zzgwj) {
            return;
        }
        zzm(new zzvg(i2, zzcwi.zza(this.zzgvx.zzcio, i2), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbsx
    public final synchronized void onAdLoaded() {
        this.zzgwk.set(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbsx
    public final synchronized void zzc(zzvg zzvgVar) {
        this.zzgwj = true;
        zzm(zzvgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbsx
    public final synchronized void zzf(int i2, @Nullable String str) {
        if (this.zzgwj) {
            return;
        }
        this.zzgwj = true;
        if (str == null) {
            str = zzcwi.zza(this.zzgvx.zzcio, i2);
        }
        zzm(new zzvg(i2, str, AdError.UNDEFINED_DOMAIN, null, null));
    }
}
