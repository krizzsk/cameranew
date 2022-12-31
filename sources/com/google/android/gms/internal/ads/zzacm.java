package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzacm extends zzack {
    private final OnCustomRenderedAdLoadedListener zzcko;

    public zzacm(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcko = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zza(zzacg zzacgVar) {
        this.zzcko.onCustomRenderedAdLoaded(new zzach(zzacgVar));
    }
}
