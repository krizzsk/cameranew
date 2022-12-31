package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjt implements zzaif<Object> {
    final /* synthetic */ zzbju zzfrx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjt(zzbju zzbjuVar) {
        this.zzfrx = zzbjuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        boolean zzn;
        Executor executor;
        zzn = this.zzfrx.zzn(map);
        if (zzn) {
            executor = this.zzfrx.executor;
            executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbjw
                private final zzbjt zzfsc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfsc = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbjz zzbjzVar;
                    zzbjzVar = this.zzfsc.zzfrx.zzfrz;
                    zzbjzVar.zzaiy();
                }
            });
        }
    }
}
