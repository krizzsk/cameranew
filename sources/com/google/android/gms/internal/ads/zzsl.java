package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsl extends zzsu {
    @Nullable
    private FullScreenContentCallback zzbuy;

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void onAdDismissedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbuy;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void onAdShowedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbuy;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuy = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzb(zzvg zzvgVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zzbuy;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvgVar.zzqb());
        }
    }
}
