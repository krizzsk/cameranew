package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzban implements Runnable {
    private final /* synthetic */ zzbam zzejo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzban(zzbam zzbamVar) {
        this.zzejo = zzbamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbaw zzbawVar;
        zzbaw zzbawVar2;
        zzbawVar = this.zzejo.zzejm;
        if (zzbawVar != null) {
            zzbawVar2 = this.zzejo.zzejm;
            zzbawVar2.zzaam();
        }
    }
}
