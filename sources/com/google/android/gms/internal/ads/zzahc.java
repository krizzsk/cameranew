package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahc extends zzafv {
    private final NativeContentAd.OnContentAdLoadedListener zzdgs;

    public zzahc(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdgs = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final void zza(zzafj zzafjVar) {
        this.zzdgs.onContentAdLoaded(new zzafk(zzafjVar));
    }
}
