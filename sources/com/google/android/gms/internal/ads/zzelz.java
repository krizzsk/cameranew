package com.google.android.gms.internal.ads;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzelz extends zzely {
    private zzelz() {
        super();
    }

    private static <E> zzell<E> zzc(Object obj, long j2) {
        return (zzell) zzeoh.zzp(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzely
    public final <L> List<L> zza(Object obj, long j2) {
        zzell zzc = zzc(obj, j2);
        if (zzc.zzbge()) {
            return zzc;
        }
        int size = zzc.size();
        zzell zzfy = zzc.zzfy(size == 0 ? 10 : size << 1);
        zzeoh.zza(obj, j2, zzfy);
        return zzfy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzely
    public final void zzb(Object obj, long j2) {
        zzc(obj, j2).zzbgf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.ads.zzely
    public final <E> void zza(Object obj, Object obj2, long j2) {
        zzell<E> zzc = zzc(obj, j2);
        zzell<E> zzc2 = zzc(obj2, j2);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzell<E> zzellVar = zzc;
        zzellVar = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzbge = zzc.zzbge();
            zzell<E> zzellVar2 = zzc;
            if (!zzbge) {
                zzellVar2 = zzc.zzfy(size2 + size);
            }
            zzellVar2.addAll(zzc2);
            zzellVar = zzellVar2;
        }
        if (size > 0) {
            zzc2 = zzellVar;
        }
        zzeoh.zza(obj, j2, zzc2);
    }
}
