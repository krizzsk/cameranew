package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcw implements zzeqb<zzdcu> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<Context> zzewk;

    private zzdcw(zzeqo<Context> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        this.zzewk = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    public static zzdcw zzav(zzeqo<Context> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        return new zzdcw(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdcu(this.zzewk.get(), this.zzewf.get());
    }
}
