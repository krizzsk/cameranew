package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzis {
    public static final int zza(int i2, Object obj, Object obj2) {
        zzir zzirVar = (zzir) obj;
        zziq zziqVar = (zziq) obj2;
        if (zzirVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzirVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzir zzirVar = (zzir) obj;
        zzir zzirVar2 = (zzir) obj2;
        if (!zzirVar2.isEmpty()) {
            if (!zzirVar.zze()) {
                zzirVar = zzirVar.zzc();
            }
            zzirVar.zzb(zzirVar2);
        }
        return zzirVar;
    }
}
