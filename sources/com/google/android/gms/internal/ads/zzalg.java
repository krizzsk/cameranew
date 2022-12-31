package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalg implements Runnable {
    private final /* synthetic */ zzalq zzdju;
    private final /* synthetic */ zzakm zzdjv;
    private final /* synthetic */ zzakz zzdjw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalg(zzakz zzakzVar, zzalq zzalqVar, zzakm zzakmVar) {
        this.zzdjw = zzakzVar;
        this.zzdju = zzalqVar;
        this.zzdjv = zzakmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzdjw.lock;
        synchronized (obj) {
            if (this.zzdju.getStatus() != -1 && this.zzdju.getStatus() != 1) {
                this.zzdju.reject();
                zzdzv zzdzvVar = zzazp.zzeig;
                zzakm zzakmVar = this.zzdjv;
                zzakmVar.getClass();
                zzdzvVar.execute(zzalj.zzb(zzakmVar));
                com.google.android.gms.ads.internal.util.zzd.zzeb("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
