package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalm extends zzbad<zzalx> {
    private final Object lock = new Object();
    private final zzalq zzdkd;
    private boolean zzdke;

    public zzalm(zzalq zzalqVar) {
        this.zzdkd = zzalqVar;
    }

    public final void release() {
        synchronized (this.lock) {
            if (this.zzdke) {
                return;
            }
            this.zzdke = true;
            zza(new zzalp(this), new zzbab());
            zza(new zzalo(this), new zzalr(this));
        }
    }
}
