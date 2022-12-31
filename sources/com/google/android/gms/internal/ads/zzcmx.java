package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcmx {
    private final ScheduledExecutorService zzfri;
    private final zzdzv zzghl;
    private final zzepv<zzcol> zzgnt;
    private final zzcnn zzgod;

    public zzcmx(ScheduledExecutorService scheduledExecutorService, zzdzv zzdzvVar, zzcnn zzcnnVar, zzepv<zzcol> zzepvVar) {
        this.zzfri = scheduledExecutorService;
        this.zzghl = zzdzvVar;
        this.zzgod = zzcnnVar;
        this.zzgnt = zzepvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzatq zzatqVar, int i2, Throwable th) throws Exception {
        return this.zzgnt.get().zzd(zzatqVar, i2);
    }

    public final zzdzw<InputStream> zzg(final zzatq zzatqVar) {
        zzdzw<InputStream> zzj;
        String str = zzatqVar.packageName;
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzek(str)) {
            zzj = zzdzk.immediateFailedFuture(new zzcoc(zzdom.INTERNAL_ERROR));
        } else {
            zzj = this.zzgod.zzj(zzatqVar);
        }
        final int callingUid = Binder.getCallingUid();
        return zzdzf.zzg(zzj).zza(((Integer) zzwr.zzqr().zzd(zzabp.zzcwn)).intValue(), TimeUnit.SECONDS, this.zzfri).zza(Throwable.class, new zzdyu(this, zzatqVar, callingUid) { // from class: com.google.android.gms.internal.ads.zzcna
            private final int zzeff;
            private final zzatq zzgnq;
            private final zzcmx zzgoe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgoe = this;
                this.zzgnq = zzatqVar;
                this.zzeff = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgoe.zza(this.zzgnq, this.zzeff, (Throwable) obj);
            }
        }, this.zzghl);
    }
}
