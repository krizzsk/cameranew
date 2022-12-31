package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdi implements zzeqb<zzcdg> {
    private final zzeqo<zzcgk> zzfjj;
    private final zzeqo<Clock> zzfsz;

    public zzcdi(zzeqo<zzcgk> zzeqoVar, zzeqo<Clock> zzeqoVar2) {
        this.zzfjj = zzeqoVar;
        this.zzfsz = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcdg(this.zzfjj.get(), this.zzfsz.get());
    }
}
