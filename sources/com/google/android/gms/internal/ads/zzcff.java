package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcff implements zzeqb<zzcfb> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzcer> zzgib;

    public zzcff(zzeqo<Executor> zzeqoVar, zzeqo<zzcer> zzeqoVar2) {
        this.zzewf = zzeqoVar;
        this.zzgib = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcfb(this.zzewf.get(), this.zzgib.get());
    }
}
