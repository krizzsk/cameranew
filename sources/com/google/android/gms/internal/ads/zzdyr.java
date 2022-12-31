package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdyr implements Runnable {
    private final /* synthetic */ zzdyo zzhzv;
    private final /* synthetic */ zzdzw zzhzw;
    private final /* synthetic */ int zzhzx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyr(zzdyo zzdyoVar, zzdzw zzdzwVar, int i2) {
        this.zzhzv = zzdyoVar;
        this.zzhzw = zzdzwVar;
        this.zzhzx = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzhzw.isCancelled()) {
                this.zzhzv.zzhzr = null;
                this.zzhzv.cancel(false);
            } else {
                this.zzhzv.zza(this.zzhzx, this.zzhzw);
            }
        } finally {
            this.zzhzv.zza((zzdwy) null);
        }
    }
}
