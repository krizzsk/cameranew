package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzekl extends zzejo {
    private static final Logger logger = Logger.getLogger(zzekl.class.getName());
    private static final boolean zzinc = zzeoh.zzblc();
    zzekn zzind;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekl.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzekl() {
    }

    public static int zzag(int i2, int i3) {
        return zzgx(i2 << 3) + zzgw(i3);
    }

    public static int zzah(int i2, int i3) {
        return zzgx(i2 << 3) + zzgx(i3);
    }

    public static int zzai(int i2, int i3) {
        return zzgx(i2 << 3) + zzgx(zzhc(i3));
    }

    public static int zzaj(int i2, int i3) {
        return zzgx(i2 << 3) + 4;
    }

    public static int zzak(int i2, int i3) {
        return zzgx(i2 << 3) + 4;
    }

    public static int zzal(int i2, int i3) {
        return zzgx(i2 << 3) + zzgw(i3);
    }

    public static int zzbs(boolean z) {
        return 1;
    }

    public static int zzd(double d2) {
        return 8;
    }

    public static int zzd(int i2, zzejr zzejrVar) {
        return (zzgx(8) << 1) + zzah(2, i2) + zzc(3, zzejrVar);
    }

    public static int zzfk(long j2) {
        return zzfl(j2);
    }

    public static int zzfl(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int zzfm(long j2) {
        return zzfl(zzfp(j2));
    }

    public static int zzfn(long j2) {
        return 8;
    }

    public static int zzfo(long j2) {
        return 8;
    }

    private static long zzfp(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int zzg(float f2) {
        return 4;
    }

    public static int zzgv(int i2) {
        return zzgx(i2 << 3);
    }

    public static int zzgw(int i2) {
        if (i2 >= 0) {
            return zzgx(i2);
        }
        return 10;
    }

    public static int zzgx(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzgy(int i2) {
        return zzgx(zzhc(i2));
    }

    public static int zzgz(int i2) {
        return 4;
    }

    public static int zzh(zzemo zzemoVar) {
        int zzbik = zzemoVar.zzbik();
        return zzgx(zzbik) + zzbik;
    }

    public static int zzha(int i2) {
        return 4;
    }

    public static int zzhb(int i2) {
        return zzgw(i2);
    }

    private static int zzhc(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    @Deprecated
    public static int zzhd(int i2) {
        return zzgx(i2);
    }

    public static int zzi(int i2, boolean z) {
        return zzgx(i2 << 3) + 1;
    }

    public static int zzia(String str) {
        int length;
        try {
            length = zzeok.zzd(str);
        } catch (zzeon unused) {
            length = str.getBytes(zzeld.UTF_8).length;
        }
        return zzgx(length) + length;
    }

    public static int zzl(int i2, long j2) {
        return zzgx(i2 << 3) + zzfl(j2);
    }

    public static int zzm(int i2, long j2) {
        return zzgx(i2 << 3) + zzfl(j2);
    }

    public static int zzn(int i2, long j2) {
        return zzgx(i2 << 3) + zzfl(zzfp(j2));
    }

    public static int zzo(int i2, long j2) {
        return zzgx(i2 << 3) + 8;
    }

    public static int zzp(int i2, long j2) {
        return zzgx(i2 << 3) + 8;
    }

    public static zzekl zzv(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzw(byte[] bArr) {
        int length = bArr.length;
        return zzgx(length) + length;
    }

    public abstract void writeTag(int i2, int i3) throws IOException;

    public final void zza(int i2, float f2) throws IOException {
        zzaf(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i2, zzejr zzejrVar) throws IOException;

    public abstract void zza(int i2, zzemo zzemoVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(int i2, zzemo zzemoVar, zzenj zzenjVar) throws IOException;

    public abstract void zzac(int i2, int i3) throws IOException;

    public abstract void zzad(int i2, int i3) throws IOException;

    public final void zzae(int i2, int i3) throws IOException {
        zzad(i2, zzhc(i3));
    }

    public abstract void zzaf(int i2, int i3) throws IOException;

    public abstract void zzai(zzejr zzejrVar) throws IOException;

    public final void zzb(int i2, double d2) throws IOException {
        zzk(i2, Double.doubleToRawLongBits(d2));
    }

    public abstract void zzb(int i2, zzejr zzejrVar) throws IOException;

    public abstract int zzbhs();

    public final void zzbht() {
        if (zzbhs() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzbr(boolean z) throws IOException {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public final void zzc(double d2) throws IOException {
        zzfj(Double.doubleToRawLongBits(d2));
    }

    public abstract void zzd(byte b) throws IOException;

    public final void zzf(float f2) throws IOException {
        zzgu(Float.floatToRawIntBits(f2));
    }

    public abstract void zzfh(long j2) throws IOException;

    public final void zzfi(long j2) throws IOException {
        zzfh(zzfp(j2));
    }

    public abstract void zzfj(long j2) throws IOException;

    public abstract void zzg(zzemo zzemoVar) throws IOException;

    public abstract void zzgr(int i2) throws IOException;

    public abstract void zzgs(int i2) throws IOException;

    public final void zzgt(int i2) throws IOException {
        zzgs(zzhc(i2));
    }

    public abstract void zzgu(int i2) throws IOException;

    public abstract void zzh(int i2, boolean z) throws IOException;

    public abstract void zzhz(String str) throws IOException;

    public abstract void zzi(int i2, long j2) throws IOException;

    public abstract void zzi(int i2, String str) throws IOException;

    public final void zzj(int i2, long j2) throws IOException {
        zzi(i2, zzfp(j2));
    }

    public abstract void zzk(int i2, long j2) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i2, int i3) throws IOException;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    private static class zzb extends zzekl {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i2, int i3) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            if ((i3 | 0 | (bArr.length - i3)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
        }

        private final void write(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.buffer, this.position, i3);
                this.position += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void writeTag(int i2, int i3) throws IOException {
            zzgs((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zza(int i2, zzejr zzejrVar) throws IOException {
            writeTag(i2, 2);
            zzai(zzejrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzac(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            zzgr(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzad(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            zzgs(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzaf(int i2, int i3) throws IOException {
            writeTag(i2, 5);
            zzgu(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzai(zzejr zzejrVar) throws IOException {
            zzgs(zzejrVar.size());
            zzejrVar.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzb(int i2, zzejr zzejrVar) throws IOException {
            writeTag(1, 3);
            zzad(2, i2);
            zza(3, zzejrVar);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final int zzbhs() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzfh(long j2) throws IOException {
            if (zzekl.zzinc && zzbhs() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzeoh.zza(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzeoh.zza(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                }
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzfj(long j2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) j2;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) (j2 >> 8);
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (j2 >> 16);
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) (j2 >> 24);
                int i7 = i6 + 1;
                this.position = i7;
                bArr[i6] = (byte) (j2 >> 32);
                int i8 = i7 + 1;
                this.position = i8;
                bArr[i7] = (byte) (j2 >> 40);
                int i9 = i8 + 1;
                this.position = i9;
                bArr[i8] = (byte) (j2 >> 48);
                this.position = i9 + 1;
                bArr[i9] = (byte) (j2 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzg(zzemo zzemoVar) throws IOException {
            zzgs(zzemoVar.zzbik());
            zzemoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzgr(int i2) throws IOException {
            if (i2 >= 0) {
                zzgs(i2);
            } else {
                zzfh(i2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzgs(int i2) throws IOException {
            if (!zzekl.zzinc || zzejk.zzbgc() || zzbhs() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i3 = this.position;
                        this.position = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr2[i4] = (byte) i2;
            } else if ((i2 & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzeoh.zza(bArr3, i5, (byte) i2);
            } else {
                byte[] bArr4 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                zzeoh.zza(bArr4, i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & (-128)) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    zzeoh.zza(bArr5, i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                zzeoh.zza(bArr6, i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & (-128)) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    zzeoh.zza(bArr7, i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                zzeoh.zza(bArr8, i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & (-128)) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i14 = this.position;
                    this.position = i14 + 1;
                    zzeoh.zza(bArr9, i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzeoh.zza(bArr10, i15, (byte) (i13 | 128));
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzeoh.zza(bArr11, i16, (byte) (i13 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzgu(int i2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) i2;
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (i2 >> 8);
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) (i2 >> 16);
                this.position = i6 + 1;
                bArr[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzh(int i2, boolean z) throws IOException {
            writeTag(i2, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzhz(String str) throws IOException {
            int i2 = this.position;
            try {
                int zzgx = zzekl.zzgx(str.length() * 3);
                int zzgx2 = zzekl.zzgx(str.length());
                if (zzgx2 == zzgx) {
                    int i3 = i2 + zzgx2;
                    this.position = i3;
                    int zza = zzeok.zza(str, this.buffer, i3, zzbhs());
                    this.position = i2;
                    zzgs((zza - i2) - zzgx2);
                    this.position = zza;
                    return;
                }
                zzgs(zzeok.zzd(str));
                this.position = zzeok.zza(str, this.buffer, this.position, zzbhs());
            } catch (zzeon e2) {
                this.position = i2;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzi(int i2, long j2) throws IOException {
            writeTag(i2, 0);
            zzfh(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzk(int i2, long j2) throws IOException {
            writeTag(i2, 1);
            zzfj(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        final void zza(int i2, zzemo zzemoVar, zzenj zzenjVar) throws IOException {
            writeTag(i2, 2);
            zzejh zzejhVar = (zzejh) zzemoVar;
            int zzbga = zzejhVar.zzbga();
            if (zzbga == -1) {
                zzbga = zzenjVar.zzau(zzejhVar);
                zzejhVar.zzfv(zzbga);
            }
            zzgs(zzbga);
            zzenjVar.zza(zzemoVar, this.zzind);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void zzh(byte[] bArr, int i2, int i3) throws IOException {
            write(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzi(int i2, String str) throws IOException {
            writeTag(i2, 2);
            zzhz(str);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zzk(byte[] bArr, int i2, int i3) throws IOException {
            zzgs(i3);
            write(bArr, 0, i3);
        }

        @Override // com.google.android.gms.internal.ads.zzekl
        public final void zza(int i2, zzemo zzemoVar) throws IOException {
            writeTag(1, 3);
            zzad(2, i2);
            writeTag(3, 2);
            zzg(zzemoVar);
            writeTag(1, 4);
        }
    }

    public static int zza(int i2, zzelt zzeltVar) {
        int zzgx = zzgx(i2 << 3);
        int zzbik = zzeltVar.zzbik();
        return zzgx + zzgx(zzbik) + zzbik;
    }

    public static int zzaj(zzejr zzejrVar) {
        int size = zzejrVar.size();
        return zzgx(size) + size;
    }

    public static int zzb(int i2, float f2) {
        return zzgx(i2 << 3) + 4;
    }

    public static int zzc(int i2, double d2) {
        return zzgx(i2 << 3) + 8;
    }

    @Deprecated
    public static int zzi(zzemo zzemoVar) {
        return zzemoVar.zzbik();
    }

    public static int zzj(int i2, String str) {
        return zzgx(i2 << 3) + zzia(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, zzemo zzemoVar, zzenj zzenjVar) {
        return zzgx(i2 << 3) + zza(zzemoVar, zzenjVar);
    }

    public static int zzc(int i2, zzejr zzejrVar) {
        int zzgx = zzgx(i2 << 3);
        int size = zzejrVar.size();
        return zzgx + zzgx(size) + size;
    }

    public static int zza(zzelt zzeltVar) {
        int zzbik = zzeltVar.zzbik();
        return zzgx(zzbik) + zzbik;
    }

    public static int zzb(int i2, zzemo zzemoVar) {
        return (zzgx(8) << 1) + zzah(2, i2) + zzgx(24) + zzh(zzemoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzc(int i2, zzemo zzemoVar, zzenj zzenjVar) {
        int zzgx = zzgx(i2 << 3) << 1;
        zzejh zzejhVar = (zzejh) zzemoVar;
        int zzbga = zzejhVar.zzbga();
        if (zzbga == -1) {
            zzbga = zzenjVar.zzau(zzejhVar);
            zzejhVar.zzfv(zzbga);
        }
        return zzgx + zzbga;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzemo zzemoVar, zzenj zzenjVar) {
        zzejh zzejhVar = (zzejh) zzemoVar;
        int zzbga = zzejhVar.zzbga();
        if (zzbga == -1) {
            zzbga = zzenjVar.zzau(zzejhVar);
            zzejhVar.zzfv(zzbga);
        }
        return zzgx(zzbga) + zzbga;
    }

    public static int zzb(int i2, zzelt zzeltVar) {
        return (zzgx(8) << 1) + zzah(2, i2) + zza(3, zzeltVar);
    }

    final void zza(String str, zzeon zzeonVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzeonVar);
        byte[] bytes = str.getBytes(zzeld.UTF_8);
        try {
            zzgs(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (zza e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zza(e3);
        }
    }
}
