package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdrr implements zzeqb<zzdrm> {
    private final zzeqo<Set<zzbya<zzdrp>>> zzfvd;

    private zzdrr(zzeqo<Set<zzbya<zzdrp>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzdrr zzat(zzeqo<Set<zzbya<zzdrp>>> zzeqoVar) {
        return new zzdrr(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdrm(this.zzfvd.get());
    }
}
