package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbsd extends zzbwf<zzbse> {
    private boolean zzfzj;

    public zzbsd(Set<zzbya<zzbse>> set) {
        super(set);
        this.zzfzj = false;
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfzj) {
            zza(zzbsc.zzfzg);
            this.zzfzj = true;
        }
    }
}
