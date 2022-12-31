package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzio implements zziv {
    private final zziv[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zziv... zzivVarArr) {
        this.zza = zzivVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zziv
    public final boolean zzb(Class<?> cls) {
        zziv[] zzivVarArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzivVarArr[i2].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zziv
    public final zziu zzc(Class<?> cls) {
        zziv[] zzivVarArr = this.zza;
        for (int i2 = 0; i2 < 2; i2++) {
            zziv zzivVar = zzivVarArr[i2];
            if (zzivVar.zzb(cls)) {
                return zzivVar.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
