package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzckv {
    private final Executor executor;
    private final boolean zzdbd;
    protected final zzazo zzegt;
    private final zzdsj zzgmc;
    private final String zzdat = zzadf.zzddh.get();
    protected final Map<String, String> zzgls = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzckv(Executor executor, zzazo zzazoVar, zzdsj zzdsjVar) {
        boolean z;
        this.executor = executor;
        this.zzegt = zzazoVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue()) {
            z = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrn)).booleanValue();
        } else {
            z = ((double) zzwr.zzqu().nextFloat()) <= zzadf.zzddg.get().doubleValue();
        }
        this.zzdbd = z;
        this.zzgmc = zzdsjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzaqw();

    public final void zzo(Map<String, String> map) {
        final String zzp = zzp(map);
        if (this.zzdbd) {
            this.executor.execute(new Runnable(this, zzp) { // from class: com.google.android.gms.internal.ads.zzcky
                private final String zzdjf;
                private final zzckv zzgmf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgmf = this;
                    this.zzdjf = zzp;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzckv zzckvVar = this.zzgmf;
                    zzckvVar.zzegt.zzel(this.zzdjf);
                }
            });
        }
        com.google.android.gms.ads.internal.util.zzd.zzeb(zzp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzp(Map<String, String> map) {
        return this.zzgmc.zzr(map);
    }
}
