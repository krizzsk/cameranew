package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcme {
    private final zzdzv zzghl;
    private final zzdzv zzgnr;
    private final zzcnj zzgns;
    private final zzepv<zzcol> zzgnt;

    public zzcme(zzdzv zzdzvVar, zzdzv zzdzvVar2, zzcnj zzcnjVar, zzepv<zzcol> zzepvVar) {
        this.zzgnr = zzdzvVar;
        this.zzghl = zzdzvVar2;
        this.zzgns = zzcnjVar;
        this.zzgnt = zzepvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzatq zzatqVar, int i2, zzcoc zzcocVar) throws Exception {
        return this.zzgnt.get().zzb(zzatqVar, i2);
    }

    public final zzdzw<InputStream> zze(final zzatq zzatqVar) {
        zzdzw zzb;
        String str = zzatqVar.packageName;
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzek(str)) {
            zzb = zzdzk.immediateFailedFuture(new zzcoc(zzdom.INTERNAL_ERROR));
        } else {
            zzb = zzdzk.zzb(this.zzgnr.zze(new Callable(this, zzatqVar) { // from class: com.google.android.gms.internal.ads.zzcmd
                private final zzcme zzgnp;
                private final zzatq zzgnq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgnp = this;
                    this.zzgnq = zzatqVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgnp.zzf(this.zzgnq);
                }
            }), ExecutionException.class, zzcmg.zzboq, this.zzghl);
        }
        final int callingUid = Binder.getCallingUid();
        return zzdzk.zzb(zzb, zzcoc.class, new zzdyu(this, zzatqVar, callingUid) { // from class: com.google.android.gms.internal.ads.zzcmf
            private final int zzeff;
            private final zzcme zzgnp;
            private final zzatq zzgnq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgnp = this;
                this.zzgnq = zzatqVar;
                this.zzeff = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgnp.zza(this.zzgnq, this.zzeff, (zzcoc) obj);
            }
        }, this.zzghl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzf(zzatq zzatqVar) throws Exception {
        return this.zzgns.zzi(zzatqVar).get(((Integer) zzwr.zzqr().zzd(zzabp.zzcwn)).intValue(), TimeUnit.SECONDS);
    }
}
