package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbwr implements zzeqb<Set<zzbya<zzbrm>>> {
    private final zzbwg zzgav;

    private zzbwr(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbwr zzp(zzbwg zzbwgVar) {
        return new zzbwr(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgav.zzaly(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
