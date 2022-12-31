package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzmw implements Runnable {
    private final /* synthetic */ zzms zzbdl;
    private final /* synthetic */ IOException zzber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmw(zzms zzmsVar, IOException iOException) {
        this.zzbdl = zzmsVar;
        this.zzber = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmz zzmzVar;
        zzmzVar = this.zzbdl.zzbdn;
        zzmzVar.zzb(this.zzber);
    }
}
