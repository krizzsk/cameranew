package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdlq implements zzdkc {
    static final zzdkc zzgya = new zzdlq();

    private zzdlq() {
    }

    @Override // com.google.android.gms.internal.ads.zzdkc
    public final void zzp(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
