package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzema extends zzely {
    private static final Class<?> zzise = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzema() {
        super();
    }

    private static <E> List<E> zzd(Object obj, long j2) {
        return (List) zzeoh.zzp(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzely
    public final <L> List<L> zza(Object obj, long j2) {
        return zza(obj, j2, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzely
    public final void zzb(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) zzeoh.zzp(obj, j2);
        if (list instanceof zzelv) {
            unmodifiableList = ((zzelv) list).zzbjn();
        } else if (zzise.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzena) && (list instanceof zzell)) {
                zzell zzellVar = (zzell) list;
                if (zzellVar.zzbge()) {
                    zzellVar.zzbgf();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzeoh.zza(obj, j2, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j2, int i2) {
        zzelw zzelwVar;
        List<L> arrayList;
        List<L> zzd = zzd(obj, j2);
        if (zzd.isEmpty()) {
            if (zzd instanceof zzelv) {
                arrayList = new zzelw(i2);
            } else if ((zzd instanceof zzena) && (zzd instanceof zzell)) {
                arrayList = ((zzell) zzd).zzfy(i2);
            } else {
                arrayList = new ArrayList<>(i2);
            }
            zzeoh.zza(obj, j2, arrayList);
            return arrayList;
        }
        if (zzise.isAssignableFrom(zzd.getClass())) {
            ArrayList arrayList2 = new ArrayList(zzd.size() + i2);
            arrayList2.addAll(zzd);
            zzeoh.zza(obj, j2, arrayList2);
            zzelwVar = arrayList2;
        } else if (zzd instanceof zzeog) {
            zzelw zzelwVar2 = new zzelw(zzd.size() + i2);
            zzelwVar2.addAll((zzeog) zzd);
            zzeoh.zza(obj, j2, zzelwVar2);
            zzelwVar = zzelwVar2;
        } else if ((zzd instanceof zzena) && (zzd instanceof zzell)) {
            zzell zzellVar = (zzell) zzd;
            if (zzellVar.zzbge()) {
                return zzd;
            }
            zzell zzfy = zzellVar.zzfy(zzd.size() + i2);
            zzeoh.zza(obj, j2, zzfy);
            return zzfy;
        } else {
            return zzd;
        }
        return zzelwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzely
    public final <E> void zza(Object obj, Object obj2, long j2) {
        List zzd = zzd(obj2, j2);
        List zza = zza(obj, j2, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzeoh.zza(obj, j2, zzd);
    }
}
