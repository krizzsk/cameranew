package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdt implements Runnable {
    private final /* synthetic */ zzds zzvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(zzds zzdsVar) {
        this.zzvz = zzdsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        zzdsy zzdsyVar;
        Object obj2;
        obj = this.zzvz.zzvx;
        synchronized (obj) {
            z = this.zzvz.zzvy;
            if (z) {
                return;
            }
            this.zzvz.zzvy = true;
            try {
                this.zzvz.zzbs();
            } catch (Exception e2) {
                zzdsyVar = this.zzvz.zzvs;
                zzdsyVar.zza(2023, -1L, e2);
            }
            obj2 = this.zzvz.zzvx;
            synchronized (obj2) {
                this.zzvz.zzvy = false;
            }
        }
    }
}
