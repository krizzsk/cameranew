package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbas implements Runnable {
    private final /* synthetic */ zzbam zzejo;
    private final /* synthetic */ int zzejs;
    private final /* synthetic */ int zzejt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbas(zzbam zzbamVar, int i2, int i3) {
        this.zzejo = zzbamVar;
        this.zzejs = i2;
        this.zzejt = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbaw zzbawVar;
        zzbaw zzbawVar2;
        zzbawVar = this.zzejo.zzejm;
        if (zzbawVar != null) {
            zzbawVar2 = this.zzejo.zzejm;
            zzbawVar2.zzk(this.zzejs, this.zzejt);
        }
    }
}
