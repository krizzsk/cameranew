package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzkm extends zzkj {
    private static int zze(byte[] bArr, int i2, long j2, int i3) {
        int zzj;
        int zzk;
        int zzl;
        if (i3 == 0) {
            zzj = zzkn.zzj(i2);
            return zzj;
        } else if (i3 == 1) {
            zzk = zzkn.zzk(i2, zzkh.zzp(bArr, j2));
            return zzk;
        } else if (i3 == 2) {
            zzl = zzkn.zzl(i2, zzkh.zzp(bArr, j2), zzkh.zzp(bArr, j2 + 1));
            return zzl;
        } else {
            throw new AssertionError();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkj
    final int zzb(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        long j2;
        int length = bArr.length;
        if ((i3 | i4 | (length - i4)) >= 0) {
            long j3 = i3;
            int i6 = (int) (i4 - j3);
            if (i6 >= 16) {
                long j4 = j3;
                i5 = 0;
                while (true) {
                    if (i5 >= i6) {
                        i5 = i6;
                        break;
                    }
                    long j5 = j4 + 1;
                    if (zzkh.zzp(bArr, j4) < 0) {
                        break;
                    }
                    i5++;
                    j4 = j5;
                }
            } else {
                i5 = 0;
            }
            int i7 = i6 - i5;
            long j6 = j3 + i5;
            while (true) {
                byte b = 0;
                while (true) {
                    if (i7 <= 0) {
                        break;
                    }
                    long j7 = j6 + 1;
                    b = zzkh.zzp(bArr, j6);
                    if (b < 0) {
                        j6 = j7;
                        break;
                    }
                    i7--;
                    j6 = j7;
                }
                if (i7 != 0) {
                    int i8 = i7 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i8 < 3) {
                                return zze(bArr, b, j6, i8);
                            }
                            i7 = i8 - 3;
                            long j8 = j6 + 1;
                            byte zzp = zzkh.zzp(bArr, j6);
                            if (zzp > -65 || (((b << 28) + (zzp + 112)) >> 30) != 0) {
                                break;
                            }
                            long j9 = j8 + 1;
                            if (zzkh.zzp(bArr, j8) > -65) {
                                break;
                            }
                            j2 = j9 + 1;
                            if (zzkh.zzp(bArr, j9) > -65) {
                                break;
                            }
                            j6 = j2;
                        } else if (i8 < 2) {
                            return zze(bArr, b, j6, i8);
                        } else {
                            i7 = i8 - 2;
                            long j10 = j6 + 1;
                            byte zzp2 = zzkh.zzp(bArr, j6);
                            if (zzp2 > -65 || ((b == -32 && zzp2 < -96) || (b == -19 && zzp2 >= -96))) {
                                break;
                            }
                            j6 = j10 + 1;
                            if (zzkh.zzp(bArr, j10) > -65) {
                                break;
                            }
                        }
                    } else if (i8 == 0) {
                        return b;
                    } else {
                        i7 = i8 - 1;
                        if (b < -62) {
                            break;
                        }
                        j2 = j6 + 1;
                        if (zzkh.zzp(bArr, j6) > -65) {
                            break;
                        }
                        j6 = j2;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkj
    public final String zzc(byte[] bArr, int i2, int i3) throws zzic {
        int length = bArr.length;
        if ((i2 | i3 | ((length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte zzp = zzkh.zzp(bArr, i2);
                if (!zzki.zza(zzp)) {
                    break;
                }
                i2++;
                cArr[i5] = (char) zzp;
                i5++;
            }
            while (i2 < i4) {
                int i6 = i2 + 1;
                byte zzp2 = zzkh.zzp(bArr, i2);
                if (zzki.zza(zzp2)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) zzp2;
                    i2 = i6;
                    while (true) {
                        i5 = i7;
                        if (i2 < i4) {
                            byte zzp3 = zzkh.zzp(bArr, i2);
                            if (!zzki.zza(zzp3)) {
                                break;
                            }
                            i2++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) zzp3;
                        }
                    }
                } else if (zzki.zzb(zzp2)) {
                    if (i6 < i4) {
                        zzki.zzc(zzp2, zzkh.zzp(bArr, i6), cArr, i5);
                        i2 = i6 + 1;
                        i5++;
                    } else {
                        throw zzic.zzf();
                    }
                } else if (zzki.zzd(zzp2)) {
                    if (i6 < i4 - 1) {
                        int i8 = i6 + 1;
                        zzki.zze(zzp2, zzkh.zzp(bArr, i6), zzkh.zzp(bArr, i8), cArr, i5);
                        i2 = i8 + 1;
                        i5++;
                    } else {
                        throw zzic.zzf();
                    }
                } else if (i6 < i4 - 2) {
                    int i9 = i6 + 1;
                    int i10 = i9 + 1;
                    zzki.zzf(zzp2, zzkh.zzp(bArr, i6), zzkh.zzp(bArr, i9), zzkh.zzp(bArr, i10), cArr, i5);
                    i5 += 2;
                    i2 = i10 + 1;
                } else {
                    throw zzic.zzf();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkj
    public final int zzd(CharSequence charSequence, byte[] bArr, int i2, int i3) {
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
            zzkh.zzq(bArr, j5, (byte) charAt);
            i5++;
            j5 = 1 + j5;
        }
        if (i5 != length) {
            while (i5 < length) {
                char charAt3 = charSequence.charAt(i5);
                if (charAt3 >= c || j5 >= j6) {
                    if (charAt3 < 2048 && j5 <= (-2) + j6) {
                        long j7 = j5 + j2;
                        zzkh.zzq(bArr, j5, (byte) ((charAt3 >>> 6) | 960));
                        zzkh.zzq(bArr, j7, (byte) ((charAt3 & '?') | 128));
                        j3 = j7 + j2;
                        j4 = j2;
                    } else if ((charAt3 >= 55296 && charAt3 <= 57343) || j5 > (-3) + j6) {
                        if (j5 <= (-4) + j6) {
                            int i6 = i5 + 1;
                            if (i6 != length) {
                                char charAt4 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    long j8 = j5 + 1;
                                    zzkh.zzq(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                    long j9 = j8 + 1;
                                    zzkh.zzq(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j9 + 1;
                                    zzkh.zzq(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 = 1;
                                    j3 = j10 + 1;
                                    zzkh.zzq(bArr, j10, (byte) ((codePoint & 63) | 128));
                                    i5 = i6;
                                } else {
                                    i5 = i6;
                                }
                            }
                            throw new zzkl(i5 - 1, length);
                        } else if (charAt3 >= 55296 && charAt3 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i4)))) {
                            throw new zzkl(i5, length);
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
                        zzkh.zzq(bArr, j5, (byte) ((charAt3 >>> '\f') | 480));
                        long j12 = j11 + j2;
                        zzkh.zzq(bArr, j11, (byte) (((charAt3 >>> 6) & 63) | 128));
                        zzkh.zzq(bArr, j12, (byte) ((charAt3 & '?') | 128));
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
                    zzkh.zzq(bArr, j5, (byte) charAt3);
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
        return (int) j5;
    }
}
