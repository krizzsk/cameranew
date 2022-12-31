package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbku implements zzeqb<Set<zzbya<zzbtb>>> {
    private final zzbks zzftm;
    private final zzeqo<zzbno> zzftr;

    public zzbku(zzbks zzbksVar, zzeqo<zzbno> zzeqoVar) {
        this.zzftm = zzbksVar;
        this.zzftr = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(Collections.singleton(new zzbya(this.zzftr.get(), zzazp.zzeih)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
