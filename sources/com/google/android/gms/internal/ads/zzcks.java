package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcks implements zzeqb<zzckn> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzckw> zzexi;

    public zzcks(zzeqo<zzckw> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        this.zzexi = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzckn(this.zzexi.get(), this.zzewf.get());
    }
}
