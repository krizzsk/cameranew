package com.google.android.gms.internal.ads;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalh implements zzaif<zzalx> {
    private final /* synthetic */ zzakm zzdjv;
    private final /* synthetic */ zzakz zzdjw;
    private final /* synthetic */ zzei zzdjy;
    private final /* synthetic */ com.google.android.gms.ads.internal.util.zzbs zzdjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalh(zzakz zzakzVar, zzei zzeiVar, zzakm zzakmVar, com.google.android.gms.ads.internal.util.zzbs zzbsVar) {
        this.zzdjw = zzakzVar;
        this.zzdjy = zzeiVar;
        this.zzdjv = zzakmVar;
        this.zzdjz = zzbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzalx zzalxVar, Map map) {
        Object obj;
        int i2;
        obj = this.zzdjw.lock;
        synchronized (obj) {
            zzazk.zzew("JS Engine is requesting an update");
            i2 = this.zzdjw.status;
            if (i2 == 0) {
                zzazk.zzew("Starting reload.");
                this.zzdjw.status = 2;
                this.zzdjw.zza(this.zzdjy);
            }
            this.zzdjv.zzb("/requestReload", (zzaif) this.zzdjz.get());
        }
    }
}
