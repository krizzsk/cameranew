package com.google.android.gms.internal.ads;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzale implements zzaif<zzalx> {
    private final /* synthetic */ zzalq zzdju;
    private final /* synthetic */ zzakm zzdjv;
    private final /* synthetic */ zzakz zzdjw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzale(zzakz zzakzVar, zzalq zzalqVar, zzakm zzakmVar) {
        this.zzdjw = zzakzVar;
        this.zzdju = zzalqVar;
        this.zzdjv = zzakmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzalx zzalxVar, Map map) {
        Object obj;
        com.google.android.gms.ads.internal.util.zzar zzarVar;
        obj = this.zzdjw.lock;
        synchronized (obj) {
            if (this.zzdju.getStatus() != -1 && this.zzdju.getStatus() != 1) {
                this.zzdjw.status = 0;
                zzarVar = this.zzdjw.zzdjo;
                zzarVar.zzg(this.zzdjv);
                this.zzdju.zzl(this.zzdjv);
                this.zzdjw.zzdjq = this.zzdju;
                com.google.android.gms.ads.internal.util.zzd.zzeb("Successfully loaded JS Engine.");
            }
        }
    }
}
