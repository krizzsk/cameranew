package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdez implements zzeqb<zzdex> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzazn> zzfqo;

    private zzdez(zzeqo<zzdzv> zzeqoVar, zzeqo<Context> zzeqoVar2, zzeqo<zzazn> zzeqoVar3) {
        this.zzewf = zzeqoVar;
        this.zzewk = zzeqoVar2;
        this.zzfqo = zzeqoVar3;
    }

    public static zzdez zzad(zzeqo<zzdzv> zzeqoVar, zzeqo<Context> zzeqoVar2, zzeqo<zzazn> zzeqoVar3) {
        return new zzdez(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdex(this.zzewf.get(), this.zzewk.get(), this.zzfqo.get());
    }
}
