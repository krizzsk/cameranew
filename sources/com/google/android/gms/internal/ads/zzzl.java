package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzl extends zzwu {
    private final /* synthetic */ zzzm zzckj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzl(zzzm zzzmVar) {
        this.zzckj = zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i2) {
        VideoController videoController;
        videoController = this.zzckj.zzckl;
        videoController.zza(this.zzckj.zzdw());
        super.onAdFailedToLoad(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.zzckj.zzckl;
        videoController.zza(this.zzckj.zzdw());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        VideoController videoController;
        videoController = this.zzckj.zzckl;
        videoController.zza(this.zzckj.zzdw());
        super.onAdFailedToLoad(loadAdError);
    }
}
