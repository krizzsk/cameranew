package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzed implements Runnable {
    private final /* synthetic */ MotionEvent zzxo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzed(zzea zzeaVar, MotionEvent motionEvent) {
        this.zzxo = motionEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsy zzdsyVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxa;
            zzdsVar.zza(this.zzxo);
        } catch (Exception e2) {
            zzdsyVar = zzea.zzxc;
            zzdsyVar.zza(2022, -1L, e2);
        }
    }
}
