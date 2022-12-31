package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import java.util.Timer;
import java.util.TimerTask;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcri extends TimerTask {
    private final /* synthetic */ AlertDialog zzgsq;
    private final /* synthetic */ Timer zzgsr;
    private final /* synthetic */ com.google.android.gms.ads.internal.overlay.zzc zzgss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcri(AlertDialog alertDialog, Timer timer, com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzgsq = alertDialog;
        this.zzgsr = timer;
        this.zzgss = zzcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzgsq.dismiss();
        this.zzgsr.cancel();
        com.google.android.gms.ads.internal.overlay.zzc zzcVar = this.zzgss;
        if (zzcVar != null) {
            zzcVar.close();
        }
    }
}
