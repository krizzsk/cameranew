package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvm extends zzxr {
    private final AdMetadataListener zzcid;

    public zzvm(AdMetadataListener adMetadataListener) {
        this.zzcid = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcid;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
