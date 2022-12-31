package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public abstract class zzaj extends zzt {
    private static final Logger logger = Logger.getLogger(zzaj.class.getName());
    private static final boolean zzer = zzdy.zzdl();
    zzam zzes;

    /* loaded from: classes2.dex */
    static class zzb extends zzaj {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i2, int i3) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i4 = i3 + 0;
            if ((i3 | 0 | (bArr.length - i4)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i4;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
        }

        private final void write(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.buffer, this.position, i3);
                this.position += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final int zzak() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i2, long j2) throws IOException {
            zzc(i2, 0);
            zzc(j2);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(int i2, int i3) throws IOException {
            zzo((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzd(int i2, int i3) throws IOException {
            zzc(i2, 0);
            zzn(i3);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zze(int i2, int i3) throws IOException {
            zzc(i2, 0);
            zzo(i3);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzg(int i2, int i3) throws IOException {
            zzc(i2, 5);
            zzq(i3);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzj(String str) throws IOException {
            int i2 = this.position;
            try {
                int zzt = zzaj.zzt(str.length() * 3);
                int zzt2 = zzaj.zzt(str.length());
                if (zzt2 == zzt) {
                    int i3 = i2 + zzt2;
                    this.position = i3;
                    int zzb = zzea.zzb(str, this.buffer, i3, zzak());
                    this.position = i2;
                    zzo((zzb - i2) - zzt2);
                    this.position = zzb;
                    return;
                }
                zzo(zzea.zzb(str));
                this.position = zzea.zzb(str, this.buffer, this.position, zzak());
            } catch (zzee e2) {
                this.position = i2;
                zzb(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzn(int i2) throws IOException {
            if (i2 >= 0) {
                zzo(i2);
            } else {
                zzc(i2);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzo(int i2) throws IOException {
            if (!zzaj.zzer || zzp.zzy() || zzak() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i3 = this.position;
                        this.position = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
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
                zzdy.zzb(bArr3, i5, (byte) i2);
            } else {
                byte[] bArr4 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                zzdy.zzb(bArr4, i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & (-128)) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    zzdy.zzb(bArr5, i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                zzdy.zzb(bArr6, i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & (-128)) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    zzdy.zzb(bArr7, i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                zzdy.zzb(bArr8, i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & (-128)) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i14 = this.position;
                    this.position = i14 + 1;
                    zzdy.zzb(bArr9, i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzdy.zzb(bArr10, i15, (byte) (i13 | 128));
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzdy.zzb(bArr11, i16, (byte) (i13 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzq(int i2) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(int i2, boolean z) throws IOException {
            zzc(i2, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i2, String str) throws IOException {
            zzc(i2, 2);
            zzj(str);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzd(int i2, long j2) throws IOException {
            zzc(i2, 1);
            zze(j2);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zze(byte[] bArr, int i2, int i3) throws IOException {
            zzo(i3);
            write(bArr, 0, i3);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(int i2, zzw zzwVar) throws IOException {
            zzc(1, 3);
            zze(2, i2);
            zzb(3, zzwVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i2, zzw zzwVar) throws IOException {
            zzc(i2, 2);
            zzb(zzwVar);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zze(long j2) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(zzw zzwVar) throws IOException {
            zzo(zzwVar.size());
            zzwVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(zzck zzckVar) throws IOException {
            zzo(zzckVar.zzbh());
            zzckVar.zzc(this);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        final void zzb(int i2, zzck zzckVar, zzda zzdaVar) throws IOException {
            zzc(i2, 2);
            zzm zzmVar = (zzm) zzckVar;
            int zzw = zzmVar.zzw();
            if (zzw == -1) {
                zzw = zzdaVar.zzn(zzmVar);
                zzmVar.zze(zzw);
            }
            zzo(zzw);
            zzdaVar.zzb(zzckVar, this.zzes);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(long j2) throws IOException {
            if (zzaj.zzer && zzak() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzdy.zzb(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzdy.zzb(bArr2, i3, (byte) j2);
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                }
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i2, zzck zzckVar) throws IOException {
            zzc(1, 3);
            zze(2, i2);
            zzc(3, 2);
            zzc(zzckVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzt
        public final void zzb(byte[] bArr, int i2, int i3) throws IOException {
            write(bArr, i2, i3);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzaj.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzaj() {
    }

    public static int zzc(double d2) {
        return 8;
    }

    public static zzaj zzc(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzd(boolean z) {
        return 1;
    }

    public static int zze(float f2) {
        return 4;
    }

    public static int zze(int i2, long j2) {
        return zzr(i2) + zzg(j2);
    }

    public static int zzg(int i2, long j2) {
        return zzr(i2) + zzg(zzk(j2));
    }

    public static int zzg(long j2) {
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

    public static int zzh(int i2, int i3) {
        return zzr(i2) + zzs(i3);
    }

    public static int zzi(int i2, int i3) {
        return zzr(i2) + zzt(i3);
    }

    public static int zzi(long j2) {
        return 8;
    }

    public static int zzj(int i2, int i3) {
        return zzr(i2) + zzt(zzy(i3));
    }

    public static int zzj(long j2) {
        return 8;
    }

    public static int zzk(int i2, int i3) {
        return zzr(i2) + 4;
    }

    private static long zzk(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int zzl(int i2, int i3) {
        return zzr(i2) + 4;
    }

    public static int zzm(int i2, int i3) {
        return zzr(i2) + zzs(i3);
    }

    public static int zzr(int i2) {
        return zzt(i2 << 3);
    }

    public static int zzs(int i2) {
        if (i2 >= 0) {
            return zzt(i2);
        }
        return 10;
    }

    public static int zzt(int i2) {
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

    public static int zzu(int i2) {
        return zzt(zzy(i2));
    }

    public static int zzv(int i2) {
        return 4;
    }

    public static int zzw(int i2) {
        return 4;
    }

    public static int zzx(int i2) {
        return zzs(i2);
    }

    private static int zzy(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    @Deprecated
    public static int zzz(int i2) {
        return zzt(i2);
    }

    public abstract int zzak();

    public final void zzb(int i2, float f2) throws IOException {
        zzg(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void zzb(int i2, long j2) throws IOException;

    public abstract void zzb(int i2, zzck zzckVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(int i2, zzck zzckVar, zzda zzdaVar) throws IOException;

    public abstract void zzb(int i2, zzw zzwVar) throws IOException;

    public abstract void zzb(int i2, String str) throws IOException;

    public abstract void zzb(zzw zzwVar) throws IOException;

    public abstract void zzc(int i2, int i3) throws IOException;

    public abstract void zzc(int i2, zzw zzwVar) throws IOException;

    public abstract void zzc(int i2, boolean z) throws IOException;

    public abstract void zzc(long j2) throws IOException;

    public abstract void zzc(zzck zzckVar) throws IOException;

    public abstract void zzd(byte b) throws IOException;

    public abstract void zzd(int i2, int i3) throws IOException;

    public abstract void zzd(int i2, long j2) throws IOException;

    public final void zzd(long j2) throws IOException {
        zzc(zzk(j2));
    }

    public abstract void zze(int i2, int i3) throws IOException;

    public abstract void zze(long j2) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i2, int i3) throws IOException;

    public final void zzf(int i2, int i3) throws IOException {
        zze(i2, zzy(i3));
    }

    public abstract void zzg(int i2, int i3) throws IOException;

    public abstract void zzj(String str) throws IOException;

    public abstract void zzn(int i2) throws IOException;

    public abstract void zzo(int i2) throws IOException;

    public final void zzp(int i2) throws IOException {
        zzo(zzy(i2));
    }

    public abstract void zzq(int i2) throws IOException;

    public static int zzf(int i2, long j2) {
        return zzr(i2) + zzg(j2);
    }

    public static int zzh(int i2, long j2) {
        return zzr(i2) + 8;
    }

    public static int zzi(int i2, long j2) {
        return zzr(i2) + 8;
    }

    public static int zzk(String str) {
        int length;
        try {
            length = zzea.zzb(str);
        } catch (zzee unused) {
            length = str.getBytes(zzbd.UTF_8).length;
        }
        return zzt(length) + length;
    }

    public final void zzb(int i2, double d2) throws IOException {
        zzd(i2, Double.doubleToRawLongBits(d2));
    }

    public final void zzd(float f2) throws IOException {
        zzq(Float.floatToRawIntBits(f2));
    }

    public static int zzd(int i2, boolean z) {
        return zzr(i2) + 1;
    }

    public static int zze(int i2, zzw zzwVar) {
        return (zzr(1) << 1) + zzi(2, i2) + zzd(3, zzwVar);
    }

    public static int zzf(long j2) {
        return zzg(j2);
    }

    public static int zzh(long j2) {
        return zzg(zzk(j2));
    }

    public final void zzb(double d2) throws IOException {
        zze(Double.doubleToRawLongBits(d2));
    }

    public final void zzc(int i2, long j2) throws IOException {
        zzb(i2, zzk(j2));
    }

    public static int zzb(int i2, zzbp zzbpVar) {
        int zzr = zzr(i2);
        int zzbh = zzbpVar.zzbh();
        return zzr + zzt(zzbh) + zzbh;
    }

    public static int zzd(int i2, zzw zzwVar) {
        int zzr = zzr(i2);
        int size = zzwVar.size();
        return zzr + zzt(size) + size;
    }

    public final void zzc(boolean z) throws IOException {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public static int zzc(int i2, float f2) {
        return zzr(i2) + 4;
    }

    public static int zzc(int i2, double d2) {
        return zzr(i2) + 8;
    }

    @Deprecated
    public static int zze(zzck zzckVar) {
        return zzckVar.zzbh();
    }

    public static int zzb(zzbp zzbpVar) {
        int zzbh = zzbpVar.zzbh();
        return zzt(zzbh) + zzbh;
    }

    public static int zzc(int i2, String str) {
        return zzr(i2) + zzk(str);
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i2, zzck zzckVar, zzda zzdaVar) {
        return zzr(i2) + zzb(zzckVar, zzdaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzck zzckVar, zzda zzdaVar) {
        zzm zzmVar = (zzm) zzckVar;
        int zzw = zzmVar.zzw();
        if (zzw == -1) {
            zzw = zzdaVar.zzn(zzmVar);
            zzmVar.zze(zzw);
        }
        return zzt(zzw) + zzw;
    }

    public static int zzc(int i2, zzck zzckVar) {
        return (zzr(1) << 1) + zzi(2, i2) + zzr(3) + zzd(zzckVar);
    }

    public static int zzd(zzck zzckVar) {
        int zzbh = zzckVar.zzbh();
        return zzt(zzbh) + zzbh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzd(int i2, zzck zzckVar, zzda zzdaVar) {
        int zzr = zzr(i2) << 1;
        zzm zzmVar = (zzm) zzckVar;
        int zzw = zzmVar.zzw();
        if (zzw == -1) {
            zzw = zzdaVar.zzn(zzmVar);
            zzmVar.zze(zzw);
        }
        return zzr + zzw;
    }

    public static int zzc(int i2, zzbp zzbpVar) {
        return (zzr(1) << 1) + zzi(2, i2) + zzb(3, zzbpVar);
    }

    final void zzb(String str, zzee zzeeVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzeeVar);
        byte[] bytes = str.getBytes(zzbd.UTF_8);
        try {
            zzo(bytes.length);
            zzb(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }

    public static int zzc(zzw zzwVar) {
        int size = zzwVar.size();
        return zzt(size) + size;
    }
}
