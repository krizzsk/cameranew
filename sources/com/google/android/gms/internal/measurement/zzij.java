package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzij extends zzil {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzij() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzij(zzii zziiVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzil
    public final void zza(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) zzkh.zzn(obj, j2);
        if (list instanceof zzih) {
            unmodifiableList = ((zzih) list).zzi();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzje) && (list instanceof zzhz)) {
                zzhz zzhzVar = (zzhz) list;
                if (zzhzVar.zza()) {
                    zzhzVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzkh.zzo(obj, j2, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzil
    public final <E> void zzb(Object obj, Object obj2, long j2) {
        ArrayList arrayList;
        List list = (List) zzkh.zzn(obj2, j2);
        int size = list.size();
        List list2 = (List) zzkh.zzn(obj, j2);
        if (list2.isEmpty()) {
            if (list2 instanceof zzih) {
                list2 = new zzig(size);
            } else if ((list2 instanceof zzje) && (list2 instanceof zzhz)) {
                list2 = ((zzhz) list2).zze(size);
            } else {
                list2 = new ArrayList(size);
            }
            zzkh.zzo(obj, j2, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList2 = new ArrayList(list2.size() + size);
                arrayList2.addAll(list2);
                zzkh.zzo(obj, j2, arrayList2);
                arrayList = arrayList2;
            } else if (list2 instanceof zzkb) {
                zzig zzigVar = new zzig(list2.size() + size);
                zzigVar.addAll(zzigVar.size(), (zzkb) list2);
                zzkh.zzo(obj, j2, zzigVar);
                arrayList = zzigVar;
            } else if ((list2 instanceof zzje) && (list2 instanceof zzhz)) {
                zzhz zzhzVar = (zzhz) list2;
                if (!zzhzVar.zza()) {
                    list2 = zzhzVar.zze(list2.size() + size);
                    zzkh.zzo(obj, j2, list2);
                }
            }
            list2 = arrayList;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzkh.zzo(obj, j2, list);
    }
}
