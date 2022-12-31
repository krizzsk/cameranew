package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbao implements Runnable {
    private final /* synthetic */ zzbam zzejo;
    private final /* synthetic */ MediaPlayer zzejp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbao(zzbam zzbamVar, MediaPlayer mediaPlayer) {
        this.zzejo = zzbamVar;
        this.zzejp = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbaw zzbawVar;
        zzbaw zzbawVar2;
        this.zzejo.zza(this.zzejp);
        zzbawVar = this.zzejo.zzejm;
        if (zzbawVar != null) {
            zzbawVar2 = this.zzejo.zzejm;
            zzbawVar2.zzfb();
        }
    }
}
