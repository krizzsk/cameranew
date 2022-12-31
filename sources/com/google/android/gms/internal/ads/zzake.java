package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzake extends zzaka {
    private final InstreamAd.InstreamAdLoadCallback zzdjc;

    public zzake(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdjc = instreamAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void onInstreamAdFailedToLoad(int i2) {
        this.zzdjc.onInstreamAdFailedToLoad(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zza(zzajv zzajvVar) {
        this.zzdjc.onInstreamAdLoaded(new zzakc(zzajvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zze(zzvg zzvgVar) {
        this.zzdjc.onInstreamAdFailedToLoad(zzvgVar.zzqc());
    }
}
