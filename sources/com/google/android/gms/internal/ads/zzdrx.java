package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdrx implements zzeqb<zzdrv> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzazo> zzexv;

    public zzdrx(zzeqo<Executor> zzeqoVar, zzeqo<zzazo> zzeqoVar2) {
        this.zzewf = zzeqoVar;
        this.zzexv = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdrv(this.zzewf.get(), this.zzexv.get());
    }
}
