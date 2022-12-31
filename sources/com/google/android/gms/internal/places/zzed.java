package com.google.android.gms.internal.places;
/* loaded from: classes2.dex */
final class zzed extends zzec {
    private static int zzb(byte[] bArr, int i2, long j2, int i3) {
        int zzao;
        int zzs;
        int zzd;
        if (i3 == 0) {
            zzao = zzea.zzao(i2);
            return zzao;
        } else if (i3 == 1) {
            zzs = zzea.zzs(i2, zzdy.zzb(bArr, j2));
            return zzs;
        } else if (i3 == 2) {
            zzd = zzea.zzd(i2, zzdy.zzb(bArr, j2), zzdy.zzb(bArr, j2 + 1));
            return zzd;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.places.zzec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzed.zzc(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzec
    public final String zzh(byte[] bArr, int i2, int i3) throws zzbk {
        boolean zze;
        boolean zze2;
        boolean zzf;
        boolean zzg;
        boolean zze3;
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte zzb = zzdy.zzb(bArr, i2);
                zze3 = zzdz.zze(zzb);
                if (!zze3) {
                    break;
                }
                i2++;
                zzdz.zzb(zzb, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte zzb2 = zzdy.zzb(bArr, i2);
                zze = zzdz.zze(zzb2);
                if (zze) {
                    int i8 = i6 + 1;
                    zzdz.zzb(zzb2, cArr, i6);
                    while (i7 < i4) {
                        byte zzb3 = zzdy.zzb(bArr, i7);
                        zze2 = zzdz.zze(zzb3);
                        if (!zze2) {
                            break;
                        }
                        i7++;
                        zzdz.zzb(zzb3, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else {
                    zzf = zzdz.zzf(zzb2);
                    if (!zzf) {
                        zzg = zzdz.zzg(zzb2);
                        if (zzg) {
                            if (i7 < i4 - 1) {
                                int i9 = i7 + 1;
                                zzdz.zzb(zzb2, zzdy.zzb(bArr, i7), zzdy.zzb(bArr, i9), cArr, i6);
                                i2 = i9 + 1;
                                i6++;
                            } else {
                                throw zzbk.zzbu();
                            }
                        } else if (i7 < i4 - 2) {
                            int i10 = i7 + 1;
                            int i11 = i10 + 1;
                            zzdz.zzb(zzb2, zzdy.zzb(bArr, i7), zzdy.zzb(bArr, i10), zzdy.zzb(bArr, i11), cArr, i6);
                            i2 = i11 + 1;
                            i6 = i6 + 1 + 1;
                        } else {
                            throw zzbk.zzbu();
                        }
                    } else if (i7 < i4) {
                        zzdz.zzb(zzb2, zzdy.zzb(bArr, i7), cArr, i6);
                        i2 = i7 + 1;
                        i6++;
                    } else {
                        throw zzbk.zzbu();
                    }
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzec
    public final int zzc(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        char c;
        long j2;
        long j3;
        long j4;
        int i4;
        char charAt;
        long j5 = i2;
        long j6 = i3 + j5;
        int length = charSequence.length();
        if (length > i3 || bArr.length - i3 < i2) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i2 + i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c = 128;
            j2 = 1;
            if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            zzdy.zzb(bArr, j5, (byte) charAt);
            i5++;
            j5 = 1 + j5;
        }
        if (i5 == length) {
            return (int) j5;
        }
        while (i5 < length) {
            char charAt3 = charSequence.charAt(i5);
            if (charAt3 >= c || j5 >= j6) {
                if (charAt3 < 2048 && j5 <= j6 - 2) {
                    long j7 = j5 + j2;
                    zzdy.zzb(bArr, j5, (byte) ((charAt3 >>> 6) | 960));
                    zzdy.zzb(bArr, j7, (byte) ((charAt3 & '?') | 128));
                    j3 = j7 + j2;
                    j4 = j2;
                } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j5 > j6 - 3) {
                    if (j5 <= j6 - 4) {
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char charAt4 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j8 = j5 + 1;
                                zzdy.zzb(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                long j9 = j8 + 1;
                                zzdy.zzb(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j10 = j9 + 1;
                                zzdy.zzb(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 = 1;
                                j3 = j10 + 1;
                                zzdy.zzb(bArr, j10, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new zzee(i5 - 1, length);
                    } else if (55296 <= charAt3 && charAt3 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i4)))) {
                        throw new zzee(i5, length);
                    } else {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j5);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                } else {
                    long j11 = j5 + j2;
                    zzdy.zzb(bArr, j5, (byte) ((charAt3 >>> '\f') | 480));
                    long j12 = j11 + j2;
                    zzdy.zzb(bArr, j11, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzdy.zzb(bArr, j12, (byte) ((charAt3 & '?') | 128));
                    j3 = j12 + 1;
                    j4 = 1;
                }
                i5++;
                c = 128;
                long j13 = j4;
                j5 = j3;
                j2 = j13;
            } else {
                long j14 = j5 + j2;
                zzdy.zzb(bArr, j5, (byte) charAt3);
                j4 = j2;
                j3 = j14;
            }
            i5++;
            c = 128;
            long j132 = j4;
            j5 = j3;
            j2 = j132;
        }
        return (int) j5;
    }
}
