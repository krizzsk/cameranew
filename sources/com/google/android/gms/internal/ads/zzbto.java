package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbto extends zzbwf<zzbtt> implements zzbse, zzbtg {
    private final zzdmw zzfrj;
    private AtomicBoolean zzfzo;

    public zzbto(Set<zzbya<zzbtt>> set, zzdmw zzdmwVar) {
        super(set);
        this.zzfzo = new AtomicBoolean();
        this.zzfrj = zzdmwVar;
    }

    private final void zzalr() {
        zzvu zzvuVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczg)).booleanValue() && this.zzfzo.compareAndSet(false, true) && (zzvuVar = this.zzfrj.zzhjv) != null && zzvuVar.type == 3) {
            zza(new zzbwh(this) { // from class: com.google.android.gms.internal.ads.zzbtr
                private final zzbto zzfzp;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfzp = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbwh
                public final void zzo(Object obj) {
                    this.zzfzp.zza((zzbtt) obj);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void onAdImpression() {
        int i2 = this.zzfrj.zzhiy;
        if (i2 == 2 || i2 == 5 || i2 == 4) {
            zzalr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbtt zzbttVar) throws Exception {
        zzbttVar.zzb(this.zzfrj.zzhjv);
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzalq() {
        if (this.zzfrj.zzhiy == 1) {
            zzalr();
        }
    }
}
