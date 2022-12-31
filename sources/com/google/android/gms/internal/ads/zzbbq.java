package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbbq implements Runnable {
    private boolean zzbsx = false;
    private zzbax zzekr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbq(zzbax zzbaxVar) {
        this.zzekr = zzbaxVar;
    }

    private final void zzabo() {
        zzdvl zzdvlVar = com.google.android.gms.ads.internal.util.zzj.zzeen;
        zzdvlVar.removeCallbacks(this);
        zzdvlVar.postDelayed(this, 250L);
    }

    public final void pause() {
        this.zzbsx = true;
        this.zzekr.zzaas();
    }

    public final void resume() {
        this.zzbsx = false;
        zzabo();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbsx) {
            return;
        }
        this.zzekr.zzaas();
        zzabo();
    }
}
