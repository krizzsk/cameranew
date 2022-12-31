package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmj implements zzeqb<Set<zzbya<zzbtb>>> {
    private final zzeqo<zzbno> zzftr;
    private final zzbmc zzfvc;

    public zzbmj(zzbmc zzbmcVar, zzeqo<zzbno> zzeqoVar) {
        this.zzfvc = zzbmcVar;
        this.zzftr = zzeqoVar;
    }

    public static Set<zzbya<zzbtb>> zza(zzbmc zzbmcVar, zzbno zzbnoVar) {
        return (Set) zzeqh.zza(Collections.singleton(new zzbya(zzbnoVar, zzazp.zzeih)), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfvc, this.zzftr.get());
    }
}
