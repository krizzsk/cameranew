package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzyo extends zzym {
    private final MuteThisAdListener zzcjw;

    public zzyo(MuteThisAdListener muteThisAdListener) {
        this.zzcjw = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onAdMuted() {
        this.zzcjw.onAdMuted();
    }
}
