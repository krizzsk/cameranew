package com.google.android.gms.internal.ads;

import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqp implements Runnable {
    private final /* synthetic */ zzqj zzbna;
    private final /* synthetic */ Surface zzbnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqp(zzqj zzqjVar, Surface surface) {
        this.zzbna = zzqjVar;
        this.zzbnd = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zzb(this.zzbnd);
    }
}
