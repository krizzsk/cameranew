package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzgx extends zzgz {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgx(byte[] bArr, int i2, int i3) {
        super(null);
        int length = bArr.length;
        if (((length - i3) | i3) >= 0) {
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i3;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i3)));
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zza(int i2, int i3) throws IOException {
        zzl((i2 << 3) | i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzb(int i2, int i3) throws IOException {
        zzl(i2 << 3);
        zzk(i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzc(int i2, int i3) throws IOException {
        zzl(i2 << 3);
        zzl(i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzd(int i2, int i3) throws IOException {
        zzl((i2 << 3) | 5);
        zzm(i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zze(int i2, long j2) throws IOException {
        zzl(i2 << 3);
        zzn(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzf(int i2, long j2) throws IOException {
        zzl((i2 << 3) | 1);
        zzo(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzg(int i2, boolean z) throws IOException {
        zzl(i2 << 3);
        zzj(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzh(int i2, String str) throws IOException {
        zzl((i2 << 3) | 2);
        zzr(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzi(int i2, zzgs zzgsVar) throws IOException {
        zzl((i2 << 3) | 2);
        zzl(zzgsVar.zzc());
        zzgsVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzj(byte b) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            bArr[i2] = b;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgy(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzk(int i2) throws IOException {
        if (i2 >= 0) {
            zzl(i2);
        } else {
            zzn(i2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzl(int i2) throws IOException {
        boolean z;
        z = zzgz.zzc;
        if (z && !zzgd.zza()) {
            int i3 = this.zzc;
            int i4 = this.zzd;
            if (i3 - i4 >= 5) {
                if ((i2 & (-128)) == 0) {
                    byte[] bArr = this.zzb;
                    this.zzd = i4 + 1;
                    zzkh.zzq(bArr, i4, (byte) i2);
                    return;
                }
                byte[] bArr2 = this.zzb;
                this.zzd = i4 + 1;
                zzkh.zzq(bArr2, i4, (byte) (i2 | 128));
                int i5 = i2 >>> 7;
                if ((i5 & (-128)) == 0) {
                    byte[] bArr3 = this.zzb;
                    int i6 = this.zzd;
                    this.zzd = i6 + 1;
                    zzkh.zzq(bArr3, i6, (byte) i5);
                    return;
                }
                byte[] bArr4 = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                zzkh.zzq(bArr4, i7, (byte) (i5 | 128));
                int i8 = i5 >>> 7;
                if ((i8 & (-128)) == 0) {
                    byte[] bArr5 = this.zzb;
                    int i9 = this.zzd;
                    this.zzd = i9 + 1;
                    zzkh.zzq(bArr5, i9, (byte) i8);
                    return;
                }
                byte[] bArr6 = this.zzb;
                int i10 = this.zzd;
                this.zzd = i10 + 1;
                zzkh.zzq(bArr6, i10, (byte) (i8 | 128));
                int i11 = i8 >>> 7;
                if ((i11 & (-128)) == 0) {
                    byte[] bArr7 = this.zzb;
                    int i12 = this.zzd;
                    this.zzd = i12 + 1;
                    zzkh.zzq(bArr7, i12, (byte) i11);
                    return;
                }
                byte[] bArr8 = this.zzb;
                int i13 = this.zzd;
                this.zzd = i13 + 1;
                zzkh.zzq(bArr8, i13, (byte) (i11 | 128));
                byte[] bArr9 = this.zzb;
                int i14 = this.zzd;
                this.zzd = i14 + 1;
                zzkh.zzq(bArr9, i14, (byte) (i11 >>> 7));
                return;
            }
        }
        while ((i2 & (-128)) != 0) {
            try {
                byte[] bArr10 = this.zzb;
                int i15 = this.zzd;
                this.zzd = i15 + 1;
                bArr10[i15] = (byte) ((i2 & 127) | 128);
                i2 >>>= 7;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzgy(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
            }
        }
        byte[] bArr11 = this.zzb;
        int i16 = this.zzd;
        this.zzd = i16 + 1;
        bArr11[i16] = (byte) i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzm(int i2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            int i4 = i3 + 1;
            this.zzd = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i4 + 1;
            this.zzd = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i5 + 1;
            this.zzd = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.zzd = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgy(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzn(long j2) throws IOException {
        boolean z;
        z = zzgz.zzc;
        if (z && this.zzc - this.zzd >= 10) {
            while ((j2 & (-128)) != 0) {
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                zzkh.zzq(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            byte[] bArr2 = this.zzb;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            zzkh.zzq(bArr2, i3, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                j2 >>>= 7;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzgy(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
            }
        }
        byte[] bArr4 = this.zzb;
        int i5 = this.zzd;
        this.zzd = i5 + 1;
        bArr4[i5] = (byte) j2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzo(long j2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            int i3 = i2 + 1;
            this.zzd = i3;
            bArr[i2] = (byte) (((int) j2) & 255);
            int i4 = i3 + 1;
            this.zzd = i4;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
            int i5 = i4 + 1;
            this.zzd = i5;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
            int i6 = i5 + 1;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
            int i7 = i6 + 1;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i7 + 1;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i8 + 1;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.zzd = i9 + 1;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgy(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    public final void zzp(byte[] bArr, int i2, int i3) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i3);
            this.zzd += i3;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgy(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i3)), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final void zzq(byte[] bArr, int i2, int i3) throws IOException {
        zzp(bArr, 0, i3);
    }

    public final void zzr(String str) throws IOException {
        int i2 = this.zzd;
        try {
            int zzw = zzgz.zzw(str.length() * 3);
            int zzw2 = zzgz.zzw(str.length());
            if (zzw2 == zzw) {
                int i3 = i2 + zzw2;
                this.zzd = i3;
                int zzd = zzkn.zzd(str, this.zzb, i3, this.zzc - i3);
                this.zzd = i2;
                zzl((zzd - i2) - zzw2);
                this.zzd = zzd;
                return;
            }
            zzl(zzkn.zzc(str));
            byte[] bArr = this.zzb;
            int i4 = this.zzd;
            this.zzd = zzkn.zzd(str, bArr, i4, this.zzc - i4);
        } catch (zzkl e2) {
            this.zzd = i2;
            zzD(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzgy(e3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final int zzs() {
        return this.zzc - this.zzd;
    }
}
