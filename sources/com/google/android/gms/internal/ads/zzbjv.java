package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjv implements zzaif<Object> {
    final /* synthetic */ zzbju zzfrx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjv(zzbju zzbjuVar) {
        this.zzfrx = zzbjuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        boolean zzn;
        Executor executor;
        zzn = this.zzfrx.zzn(map);
        if (zzn) {
            executor = this.zzfrx.executor;
            executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbjy
                private final zzbjv zzfse;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfse = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbjz zzbjzVar;
                    zzbjzVar = this.zzfse.zzfrx.zzfrz;
                    zzbjzVar.zzaja();
                }
            });
        }
    }
}
