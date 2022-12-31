package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxn implements zzeqb<zzcxj> {
    private final zzeqo<Executor> zzewf;

    public zzcxn(zzeqo<Executor> zzeqoVar) {
        this.zzewf = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcxj(this.zzewf.get());
    }
}
