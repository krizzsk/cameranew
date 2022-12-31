package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzarb extends zzagb {
    private final /* synthetic */ zzaqw zzdqs;

    private zzarb(zzaqw zzaqwVar) {
        this.zzdqs = zzaqwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zza(zzafn zzafnVar) {
        NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener;
        NativeCustomFormatAd zzc;
        onCustomFormatAdLoadedListener = this.zzdqs.zzdqn;
        zzc = this.zzdqs.zzc(zzafnVar);
        onCustomFormatAdLoadedListener.onCustomFormatAdLoaded(zzc);
    }
}
