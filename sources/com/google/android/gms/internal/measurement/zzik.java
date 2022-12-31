package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzik extends zzil {
    private zzik() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzik(zzii zziiVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzil
    public final void zza(Object obj, long j2) {
        ((zzhz) zzkh.zzn(obj, j2)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    @Override // com.google.android.gms.internal.measurement.zzil
    public final <E> void zzb(Object obj, Object obj2, long j2) {
        zzhz<E> zzhzVar = (zzhz) zzkh.zzn(obj, j2);
        zzhz<E> zzhzVar2 = (zzhz) zzkh.zzn(obj2, j2);
        int size = zzhzVar.size();
        int size2 = zzhzVar2.size();
        zzhz<E> zzhzVar3 = zzhzVar;
        zzhzVar3 = zzhzVar;
        if (size > 0 && size2 > 0) {
            boolean zza = zzhzVar.zza();
            zzhz<E> zzhzVar4 = zzhzVar;
            if (!zza) {
                zzhzVar4 = zzhzVar.zze(size2 + size);
            }
            zzhzVar4.addAll(zzhzVar2);
            zzhzVar3 = zzhzVar4;
        }
        if (size > 0) {
            zzhzVar2 = zzhzVar3;
        }
        zzkh.zzo(obj, j2, zzhzVar2);
    }
}
