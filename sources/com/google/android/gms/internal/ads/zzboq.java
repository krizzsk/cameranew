package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzboq implements com.google.android.gms.ads.internal.overlay.zzq {
    private final zzbsm zzfwu;
    private AtomicBoolean zzfwv = new AtomicBoolean(false);

    public zzboq(zzbsm zzbsmVar) {
        this.zzfwu = zzbsmVar;
    }

    public final boolean isClosed() {
        return this.zzfwv.get();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        this.zzfwv.set(true);
        this.zzfwu.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
        this.zzfwu.onAdOpened();
    }
}
