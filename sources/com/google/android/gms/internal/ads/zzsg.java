package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsg extends zzso {
    @Nullable
    private final AppOpenAd.AppOpenAdLoadCallback zzbus;
    private final String zzbut;

    public zzsg(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zzbus = appOpenAdLoadCallback;
        this.zzbut = str;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void onAppOpenAdFailedToLoad(int i2) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbus;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzsk zzskVar) {
        if (this.zzbus != null) {
            zzsi zzsiVar = new zzsi(zzskVar, this.zzbut);
            this.zzbus.onAppOpenAdLoaded(zzsiVar);
            this.zzbus.onAdLoaded(zzsiVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzvg zzvgVar) {
        if (this.zzbus != null) {
            LoadAdError zzqc = zzvgVar.zzqc();
            this.zzbus.onAppOpenAdFailedToLoad(zzqc);
            this.zzbus.onAdFailedToLoad(zzqc);
        }
    }
}
