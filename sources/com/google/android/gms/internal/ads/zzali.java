package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzali implements zzbae<zzakm> {
    private final /* synthetic */ zzakz zzdjw;
    private final /* synthetic */ zzalq zzdka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzali(zzakz zzakzVar, zzalq zzalqVar) {
        this.zzdjw = zzakzVar;
        this.zzdka = zzalqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbae
    public final /* synthetic */ void zzg(zzakm zzakmVar) {
        Object obj;
        zzalq zzalqVar;
        zzalq zzalqVar2;
        zzalq zzalqVar3;
        obj = this.zzdjw.lock;
        synchronized (obj) {
            this.zzdjw.status = 0;
            zzalqVar = this.zzdjw.zzdjq;
            if (zzalqVar != null) {
                zzalq zzalqVar4 = this.zzdka;
                zzalqVar2 = this.zzdjw.zzdjq;
                if (zzalqVar4 != zzalqVar2) {
                    com.google.android.gms.ads.internal.util.zzd.zzeb("New JS engine is loaded, marking previous one as destroyable.");
                    zzalqVar3 = this.zzdjw.zzdjq;
                    zzalqVar3.zzuo();
                }
            }
            this.zzdjw.zzdjq = this.zzdka;
        }
    }
}
