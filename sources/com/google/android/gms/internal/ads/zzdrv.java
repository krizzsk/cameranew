package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdrv implements zzdrw {
    private final Executor executor;
    private final zzazo zzegt;

    public zzdrv(Executor executor, zzazo zzazoVar) {
        this.executor = executor;
        this.zzegt = zzazoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    public final void zzgv(final String str) {
        this.executor.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzdry
            private final String zzdjf;
            private final zzdrv zzhri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhri = this;
                this.zzdjf = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhri.zzgw(this.zzdjf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzgw(String str) {
        this.zzegt.zzel(str);
    }
}
