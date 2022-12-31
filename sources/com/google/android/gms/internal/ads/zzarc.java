package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzarc extends zzagp {
    private final NativeAd.UnconfirmedClickListener zzdqv;

    public zzarc(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdqv = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagm
    public final void onUnconfirmedClickCancelled() {
        this.zzdqv.onUnconfirmedClickCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzagm
    public final void onUnconfirmedClickReceived(String str) {
        this.zzdqv.onUnconfirmedClickReceived(str);
    }
}
