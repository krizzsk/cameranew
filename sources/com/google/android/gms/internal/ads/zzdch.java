package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdch<S extends zzdfj<?>> implements zzdfi<S> {
    private final Clock zzbqg;
    private final AtomicReference<zzdcg<S>> zzhbn = new AtomicReference<>();
    private final zzdfi<S> zzhbo;
    private final long zzhbp;

    public zzdch(zzdfi<S> zzdfiVar, long j2, Clock clock) {
        this.zzbqg = clock;
        this.zzhbo = zzdfiVar;
        this.zzhbp = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<S> zzasy() {
        zzdcg<S> zzdcgVar = this.zzhbn.get();
        if (zzdcgVar == null || zzdcgVar.hasExpired()) {
            zzdcgVar = new zzdcg<>(this.zzhbo.zzasy(), this.zzhbp, this.zzbqg);
            this.zzhbn.set(zzdcgVar);
        }
        return zzdcgVar.zzhbl;
    }
}
