package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzgm extends zzgq {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgm(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzgs.zzn(0, i3, bArr.length);
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq, com.google.android.gms.internal.measurement.zzgs
    public final byte zza(int i2) {
        int i3 = this.zzc;
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.zza[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgq, com.google.android.gms.internal.measurement.zzgs
    public final byte zzb(int i2) {
        return this.zza[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzgq, com.google.android.gms.internal.measurement.zzgs
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    protected final int zzd() {
        return 0;
    }
}
