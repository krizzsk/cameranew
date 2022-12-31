package com.google.android.gms.internal.places;
/* loaded from: classes2.dex */
final class zzeb extends zzec {
    @Override // com.google.android.gms.internal.places.zzec
    final int zzc(int i2, byte[] bArr, int i3, int i4) {
        int zzg;
        int zzg2;
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
                    if (i5 >= i4) {
                        return b;
                    }
                    if (b >= -62) {
                        i3 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                } else if (b >= -16) {
                    if (i5 >= i4 - 2) {
                        zzg2 = zzea.zzg(bArr, i5, i4);
                        return zzg2;
                    }
                    int i6 = i5 + 1;
                    byte b2 = bArr[i5];
                    if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i5 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i5 >= i4 - 1) {
                    zzg = zzea.zzg(bArr, i5, i4);
                    return zzg;
                } else {
                    int i8 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        i3 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i3 = i5;
        }
        return 0;
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
                byte b = bArr[i2];
                zze3 = zzdz.zze(b);
                if (!zze3) {
                    break;
                }
                i2++;
                zzdz.zzb(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte b2 = bArr[i2];
                zze = zzdz.zze(b2);
                if (zze) {
                    int i8 = i6 + 1;
                    zzdz.zzb(b2, cArr, i6);
                    while (i7 < i4) {
                        byte b3 = bArr[i7];
                        zze2 = zzdz.zze(b3);
                        if (!zze2) {
                            break;
                        }
                        i7++;
                        zzdz.zzb(b3, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else {
                    zzf = zzdz.zzf(b2);
                    if (!zzf) {
                        zzg = zzdz.zzg(b2);
                        if (zzg) {
                            if (i7 < i4 - 1) {
                                int i9 = i7 + 1;
                                zzdz.zzb(b2, bArr[i7], bArr[i9], cArr, i6);
                                i2 = i9 + 1;
                                i6++;
                            } else {
                                throw zzbk.zzbu();
                            }
                        } else if (i7 < i4 - 2) {
                            int i10 = i7 + 1;
                            byte b4 = bArr[i7];
                            int i11 = i10 + 1;
                            zzdz.zzb(b2, b4, bArr[i10], bArr[i11], cArr, i6);
                            i2 = i11 + 1;
                            i6 = i6 + 1 + 1;
                        } else {
                            throw zzbk.zzbu();
                        }
                    } else if (i7 < i4) {
                        zzdz.zzb(b2, bArr[i7], cArr, i6);
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
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.places.zzec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzeb.zzc(java.lang.CharSequence, byte[], int, int):int");
    }
}
