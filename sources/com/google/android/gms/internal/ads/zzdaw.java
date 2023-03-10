package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdaw implements zzeqb<zzdav> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzdzw<String>> zzhan;

    private zzdaw(zzeqo<zzdzw<String>> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        this.zzhan = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    public static zzdaw zzar(zzeqo<zzdzw<String>> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        return new zzdaw(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdav(this.zzhan.get(), this.zzewf.get());
    }
}
