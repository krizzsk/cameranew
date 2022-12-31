package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzbtd implements zzbwh {
    static final zzbwh zzfzg = new zzbtd();

    private zzbtd() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwh
    public final void zzo(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
