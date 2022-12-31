package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdet implements zzdfi<zzdeq> {
    private final Context context;
    private final zzaxc zzbqv;
    private final zzdzv zzghl;

    public zzdet(zzaxc zzaxcVar, zzdzv zzdzvVar, Context context) {
        this.zzbqv = zzaxcVar;
        this.zzghl = zzdzvVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdeq> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdes
            private final zzdet zzhcy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhcy = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhcy.zzatn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdeq zzatn() throws Exception {
        if (!this.zzbqv.zzy(this.context)) {
            return new zzdeq(null, null, null, null, null);
        }
        String zzab = this.zzbqv.zzab(this.context);
        String str = zzab == null ? "" : zzab;
        String zzac = this.zzbqv.zzac(this.context);
        String str2 = zzac == null ? "" : zzac;
        String zzad = this.zzbqv.zzad(this.context);
        String str3 = zzad == null ? "" : zzad;
        String zzae = this.zzbqv.zzae(this.context);
        return new zzdeq(str, str2, str3, zzae == null ? "" : zzae, "TIME_OUT".equals(str2) ? (Long) zzwr.zzqr().zzd(zzabp.zzcoi) : null);
    }
}
