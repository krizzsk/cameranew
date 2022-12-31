package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahd extends zzafq {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzdgt;

    public zzahd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzdgt = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void zza(zzaff zzaffVar) {
        this.zzdgt.onAppInstallAdLoaded(new zzafg(zzaffVar));
    }
}
