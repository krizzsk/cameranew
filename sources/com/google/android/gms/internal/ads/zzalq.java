package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalq extends zzbad<zzakm> {
    private com.google.android.gms.ads.internal.util.zzar<zzakm> zzdjp;
    private final Object lock = new Object();
    private boolean zzdkg = false;
    private int zzdkh = 0;

    public zzalq(com.google.android.gms.ads.internal.util.zzar<zzakm> zzarVar) {
        this.zzdjp = zzarVar;
    }

    private final void zzup() {
        synchronized (this.lock) {
            q.m(this.zzdkh >= 0);
            if (this.zzdkg && this.zzdkh == 0) {
                com.google.android.gms.ads.internal.util.zzd.zzeb("No reference is left (including root). Cleaning up engine.");
                zza(new zzalv(this), new zzbab());
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzeb("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzalm zzum() {
        zzalm zzalmVar = new zzalm(this);
        synchronized (this.lock) {
            zza(new zzalt(this, zzalmVar), new zzals(this, zzalmVar));
            q.m(this.zzdkh >= 0);
            this.zzdkh++;
        }
        return zzalmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzun() {
        synchronized (this.lock) {
            q.m(this.zzdkh > 0);
            com.google.android.gms.ads.internal.util.zzd.zzeb("Releasing 1 reference for JS Engine");
            this.zzdkh--;
            zzup();
        }
    }

    public final void zzuo() {
        synchronized (this.lock) {
            q.m(this.zzdkh >= 0);
            com.google.android.gms.ads.internal.util.zzd.zzeb("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdkg = true;
            zzup();
        }
    }
}
