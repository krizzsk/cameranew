package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwt extends zzye {
    @Nullable
    private final FullScreenContentCallback zzbuy;

    public zzwt(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuy = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void onAdDismissedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbuy;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void onAdShowedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbuy;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void zzb(zzvg zzvgVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zzbuy;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvgVar.zzqb());
        }
    }
}
