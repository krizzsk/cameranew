package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdeh implements zzeqb<zzdef> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<Bundle> zzhcn;

    private zzdeh(zzeqo<zzdzv> zzeqoVar, zzeqo<Bundle> zzeqoVar2) {
        this.zzewf = zzeqoVar;
        this.zzhcn = zzeqoVar2;
    }

    public static zzdeh zzay(zzeqo<zzdzv> zzeqoVar, zzeqo<Bundle> zzeqoVar2) {
        return new zzdeh(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdef(this.zzewf.get(), this.zzhcn.get());
    }
}
