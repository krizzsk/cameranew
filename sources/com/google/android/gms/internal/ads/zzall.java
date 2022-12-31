package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzall implements zzbac {
    private final /* synthetic */ zzakz zzdjw;
    private final /* synthetic */ zzalq zzdka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzall(zzakz zzakzVar, zzalq zzalqVar) {
        this.zzdjw = zzakzVar;
        this.zzdka = zzalqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbac
    public final void run() {
        Object obj;
        obj = this.zzdjw.lock;
        synchronized (obj) {
            this.zzdjw.status = 1;
            com.google.android.gms.ads.internal.util.zzd.zzeb("Failed loading new engine. Marking new engine destroyable.");
            this.zzdka.zzuo();
        }
    }
}
