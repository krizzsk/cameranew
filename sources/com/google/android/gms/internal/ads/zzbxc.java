package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxc implements zzeqb<Set<zzbya<zzbyf>>> {
    private final zzbwg zzgav;

    private zzbxc(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbxc zzab(zzbwg zzbwgVar) {
        return new zzbxc(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
