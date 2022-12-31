package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdcg<S extends zzdfj<?>> {
    private final Clock zzbqg;
    public final zzdzw<S> zzhbl;
    private final long zzhbm;

    public zzdcg(zzdzw<S> zzdzwVar, long j2, Clock clock) {
        this.zzhbl = zzdzwVar;
        this.zzbqg = clock;
        this.zzhbm = clock.a() + j2;
    }

    public final boolean hasExpired() {
        return this.zzhbm < this.zzbqg.a();
    }
}
