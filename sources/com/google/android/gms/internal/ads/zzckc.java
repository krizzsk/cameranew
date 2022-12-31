package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzckc implements zzeqb<zzcjx> {
    private final zzeqo<zztu> zzgjp;
    private final zzeqo<Map<zzdrk, zzcjz>> zzglm;

    private zzckc(zzeqo<zztu> zzeqoVar, zzeqo<Map<zzdrk, zzcjz>> zzeqoVar2) {
        this.zzgjp = zzeqoVar;
        this.zzglm = zzeqoVar2;
    }

    public static zzckc zzae(zzeqo<zztu> zzeqoVar, zzeqo<Map<zzdrk, zzcjz>> zzeqoVar2) {
        return new zzckc(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcjx(this.zzgjp.get(), this.zzglm.get());
    }
}
