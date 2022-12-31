package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzs implements Runnable {
    private final Runnable mRunnable;
    private final zzab zzaf;
    private final zzag zzag;

    public zzs(zzab zzabVar, zzag zzagVar, Runnable runnable) {
        this.zzaf = zzabVar;
        this.zzag = zzagVar;
        this.mRunnable = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaf.isCanceled();
        if (this.zzag.isSuccess()) {
            this.zzaf.zza((zzab) this.zzag.result);
        } else {
            this.zzaf.zzb(this.zzag.zzbr);
        }
        if (this.zzag.zzbs) {
            this.zzaf.zzc("intermediate-response");
        } else {
            this.zzaf.zzd("done");
        }
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }
}
