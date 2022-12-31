package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdpq {
    private HashMap<zzdpi, zzdpp<? extends zzbnt>> zzhom = new HashMap<>();

    public final <AdT extends zzbnt> zzdpp<AdT> zza(zzdpi zzdpiVar, Context context, zzdov zzdovVar, zzdpx<AdT> zzdpxVar) {
        zzdpp<AdT> zzdppVar = (zzdpp<AdT>) this.zzhom.get(zzdpiVar);
        if (zzdppVar == null) {
            zzdpb zzdpbVar = new zzdpb(zzdpf.zza(zzdpiVar, context));
            zzdpp<AdT> zzdppVar2 = new zzdpp<>(zzdpbVar, new zzdpu(zzdpbVar, zzdovVar, zzdpxVar));
            this.zzhom.put(zzdpiVar, zzdppVar2);
            return zzdppVar2;
        }
        return zzdppVar;
    }
}
