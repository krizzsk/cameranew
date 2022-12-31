package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeoo extends zzeol {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r13[r14] > (-65)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
        if (r13[r14] > (-65)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0082, code lost:
        if (r13[r14] > (-65)) goto L48;
     */
    @Override // com.google.android.gms.internal.ads.zzeol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoo.zzb(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeol
    public final String zzo(byte[] bArr, int i2, int i3) throws zzelo {
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
                zze3 = zzeom.zze(b);
                if (!zze3) {
                    break;
                }
                i2++;
                zzeom.zza(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte b2 = bArr[i2];
                zze = zzeom.zze(b2);
                if (zze) {
                    int i8 = i6 + 1;
                    zzeom.zza(b2, cArr, i6);
                    while (i7 < i4) {
                        byte b3 = bArr[i7];
                        zze2 = zzeom.zze(b3);
                        if (!zze2) {
                            break;
                        }
                        i7++;
                        zzeom.zza(b3, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else {
                    zzf = zzeom.zzf(b2);
                    if (!zzf) {
                        zzg = zzeom.zzg(b2);
                        if (zzg) {
                            if (i7 < i4 - 1) {
                                int i9 = i7 + 1;
                                zzeom.zza(b2, bArr[i7], bArr[i9], cArr, i6);
                                i2 = i9 + 1;
                                i6++;
                            } else {
                                throw zzelo.zzbji();
                            }
                        } else if (i7 < i4 - 2) {
                            int i10 = i7 + 1;
                            byte b4 = bArr[i7];
                            int i11 = i10 + 1;
                            zzeom.zza(b2, b4, bArr[i10], bArr[i11], cArr, i6);
                            i2 = i11 + 1;
                            i6 = i6 + 1 + 1;
                        } else {
                            throw zzelo.zzbji();
                        }
                    } else if (i7 < i4) {
                        zzeom.zza(b2, bArr[i7], cArr, i6);
                        i2 = i7 + 1;
                        i6++;
                    } else {
                        throw zzelo.zzbji();
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
    @Override // com.google.android.gms.internal.ads.zzeol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoo.zzb(java.lang.CharSequence, byte[], int, int):int");
    }
}
