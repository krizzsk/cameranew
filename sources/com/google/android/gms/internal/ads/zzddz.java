package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddz implements zzeqb<zzddx> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdzv> zzhak;
    private final zzeqo<Set<String>> zzhax;

    private zzddz(zzeqo<zzdzv> zzeqoVar, zzeqo<Context> zzeqoVar2, zzeqo<Set<String>> zzeqoVar3) {
        this.zzhak = zzeqoVar;
        this.zzewk = zzeqoVar2;
        this.zzhax = zzeqoVar3;
    }

    public static zzddz zzab(zzeqo<zzdzv> zzeqoVar, zzeqo<Context> zzeqoVar2, zzeqo<Set<String>> zzeqoVar3) {
        return new zzddz(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzddx(this.zzhak.get(), this.zzewk.get(), this.zzhax.get());
    }
}
