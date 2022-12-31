package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeg implements Runnable {
    private final /* synthetic */ int zzxq;
    private final /* synthetic */ int zzxr;
    private final /* synthetic */ int zzxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeg(zzea zzeaVar, int i2, int i3, int i4) {
        this.zzxq = i2;
        this.zzxr = i3;
        this.zzxs = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsy zzdsyVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxa;
            zzdsVar.zza(MotionEvent.obtain(0L, this.zzxq, 0, this.zzxr, this.zzxs, 0));
        } catch (Exception e2) {
            zzdsyVar = zzea.zzxc;
            zzdsyVar.zza(2022, -1L, e2);
        }
    }
}
