package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzkk extends zzkj {
    @Override // com.google.android.gms.internal.measurement.zzkj
    final int zzb(int i2, byte[] bArr, int i3, int i4) {
        while (i3 < i4 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i4) {
            return 0;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b = bArr[i3];
            if (b < 0) {
                if (b < -32) {
                    if (i5 < i4) {
                        if (b >= -62) {
                            i3 = i5 + 1;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    }
                    return b;
                }
                if (b < -16) {
                    if (i5 >= i4 - 1) {
                        return zzkn.zzh(bArr, i5, i4);
                    }
                    int i6 = i5 + 1;
                    byte b2 = bArr[i5];
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i3 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                } else if (i5 >= i4 - 2) {
                    return zzkn.zzh(bArr, i5, i4);
                } else {
                    int i7 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            i5 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i3 = i5;
        }
        return 0;
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
                byte b = bArr[i2];
                if (!zzki.zza(b)) {
                    break;
                }
                i2++;
                cArr[i5] = (char) b;
                i5++;
            }
            while (i2 < i4) {
                int i6 = i2 + 1;
                byte b2 = bArr[i2];
                if (zzki.zza(b2)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) b2;
                    i2 = i6;
                    while (true) {
                        i5 = i7;
                        if (i2 < i4) {
                            byte b3 = bArr[i2];
                            if (!zzki.zza(b3)) {
                                break;
                            }
                            i2++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b3;
                        }
                    }
                } else if (zzki.zzb(b2)) {
                    if (i6 < i4) {
                        zzki.zzc(b2, bArr[i6], cArr, i5);
                        i2 = i6 + 1;
                        i5++;
                    } else {
                        throw zzic.zzf();
                    }
                } else if (zzki.zzd(b2)) {
                    if (i6 < i4 - 1) {
                        int i8 = i6 + 1;
                        zzki.zze(b2, bArr[i6], bArr[i8], cArr, i5);
                        i2 = i8 + 1;
                        i5++;
                    } else {
                        throw zzic.zzf();
                    }
                } else if (i6 < i4 - 2) {
                    int i9 = i6 + 1;
                    int i10 = i9 + 1;
                    zzki.zzf(b2, bArr[i6], bArr[i9], bArr[i10], cArr, i5);
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
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.measurement.zzkj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzd(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkk.zzd(java.lang.CharSequence, byte[], int, int):int");
    }
}
