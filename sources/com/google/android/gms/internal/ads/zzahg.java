package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahg extends zzagp {
    private final UnifiedNativeAd.UnconfirmedClickListener zzdgx;

    public zzahg(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdgx = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagm
    public final void onUnconfirmedClickCancelled() {
        this.zzdgx.onUnconfirmedClickCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzagm
    public final void onUnconfirmedClickReceived(String str) {
        this.zzdgx.onUnconfirmedClickReceived(str);
    }
}
