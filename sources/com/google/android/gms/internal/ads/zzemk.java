package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzemk implements zzemh {
    @Override // com.google.android.gms.internal.ads.zzemh
    public final Map<?, ?> zzan(Object obj) {
        return (zzemi) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final Map<?, ?> zzao(Object obj) {
        return (zzemi) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final boolean zzap(Object obj) {
        return !((zzemi) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final Object zzaq(Object obj) {
        ((zzemi) obj).zzbgf();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final Object zzar(Object obj) {
        return zzemi.zzbjs().zzbjt();
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final zzemf<?, ?> zzas(Object obj) {
        zzemg zzemgVar = (zzemg) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final int zzb(int i2, Object obj, Object obj2) {
        zzemi zzemiVar = (zzemi) obj;
        zzemg zzemgVar = (zzemg) obj2;
        if (zzemiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzemiVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw new NoSuchMethodError();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzemh
    public final Object zzf(Object obj, Object obj2) {
        zzemi zzemiVar = (zzemi) obj;
        zzemi zzemiVar2 = (zzemi) obj2;
        if (!zzemiVar2.isEmpty()) {
            if (!zzemiVar.isMutable()) {
                zzemiVar = zzemiVar.zzbjt();
            }
            zzemiVar.zza(zzemiVar2);
        }
        return zzemiVar;
    }
}
