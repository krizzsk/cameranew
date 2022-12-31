package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.coremedia.iso.boxes.MetaBox;
import com.google.android.gms.internal.ads.zzmh;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzkx {
    private static final int zzawm = zzpt.zzbh("vide");
    private static final int zzawn = zzpt.zzbh("soun");
    private static final int zzawo = zzpt.zzbh("text");
    private static final int zzawp = zzpt.zzbh("sbtl");
    private static final int zzawq = zzpt.zzbh("subt");
    private static final int zzawr = zzpt.zzbh("clcp");
    private static final int zzaws = zzpt.zzbh("cenc");
    private static final int zzavy = zzpt.zzbh(MetaBox.TYPE);

    /* JADX WARN: Removed duplicated region for block: B:199:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0825 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzls zza(com.google.android.gms.internal.ads.zzkv r49, com.google.android.gms.internal.ads.zzky r50, long r51, com.google.android.gms.internal.ads.zzjo r53, boolean r54) throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instructions count: 2143
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkx.zza(com.google.android.gms.internal.ads.zzkv, com.google.android.gms.internal.ads.zzky, long, com.google.android.gms.internal.ads.zzjo, boolean):com.google.android.gms.internal.ads.zzls");
    }

    private static Pair<String, byte[]> zzb(zzpn zzpnVar, int i2) {
        zzpnVar.zzbi(i2 + 8 + 4);
        zzpnVar.zzbj(1);
        zzc(zzpnVar);
        zzpnVar.zzbj(2);
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpnVar.zzbj(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpnVar.zzbj(zzpnVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpnVar.zzbj(2);
        }
        zzpnVar.zzbj(1);
        zzc(zzpnVar);
        int readUnsignedByte2 = zzpnVar.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzpnVar.zzbj(12);
        zzpnVar.zzbj(1);
        int zzc = zzc(zzpnVar);
        byte[] bArr = new byte[zzc];
        zzpnVar.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zzc(zzpn zzpnVar) {
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        int i2 = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpnVar.readUnsignedByte();
            i2 = (i2 << 7) | (readUnsignedByte & 127);
        }
        return i2;
    }

    public static zzlt zza(zzls zzlsVar, zzkv zzkvVar, zzke zzkeVar) throws zzhw {
        zzkz zzleVar;
        boolean z;
        int i2;
        int i3;
        zzls zzlsVar2;
        int i4;
        long[] jArr;
        int[] iArr;
        int i5;
        long[] jArr2;
        int[] iArr2;
        long j2;
        long j3;
        long[] jArr3;
        long[] jArr4;
        boolean z2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int i6;
        int i7;
        int i8;
        int i9;
        zzky zzap = zzkvVar.zzap(zzkw.zzavn);
        if (zzap != null) {
            zzleVar = new zzlb(zzap);
        } else {
            zzky zzap2 = zzkvVar.zzap(zzkw.zzavo);
            if (zzap2 != null) {
                zzleVar = new zzle(zzap2);
            } else {
                throw new zzhw("Track has no sample table size information");
            }
        }
        int zzgx = zzleVar.zzgx();
        if (zzgx == 0) {
            return new zzlt(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzky zzap3 = zzkvVar.zzap(zzkw.zzavp);
        if (zzap3 == null) {
            zzap3 = zzkvVar.zzap(zzkw.zzavq);
            z = true;
        } else {
            z = false;
        }
        zzpn zzpnVar = zzap3.zzawt;
        zzpn zzpnVar2 = zzkvVar.zzap(zzkw.zzavm).zzawt;
        zzpn zzpnVar3 = zzkvVar.zzap(zzkw.zzavj).zzawt;
        zzky zzap4 = zzkvVar.zzap(zzkw.zzavk);
        zzpn zzpnVar4 = null;
        zzpn zzpnVar5 = zzap4 != null ? zzap4.zzawt : null;
        zzky zzap5 = zzkvVar.zzap(zzkw.zzavl);
        zzpn zzpnVar6 = zzap5 != null ? zzap5.zzawt : null;
        zzla zzlaVar = new zzla(zzpnVar2, zzpnVar, z);
        zzpnVar3.zzbi(12);
        int zzja = zzpnVar3.zzja() - 1;
        int zzja2 = zzpnVar3.zzja();
        int zzja3 = zzpnVar3.zzja();
        if (zzpnVar6 != null) {
            zzpnVar6.zzbi(12);
            i2 = zzpnVar6.zzja();
        } else {
            i2 = 0;
        }
        int i10 = -1;
        if (zzpnVar5 != null) {
            zzpnVar5.zzbi(12);
            i3 = zzpnVar5.zzja();
            if (i3 > 0) {
                i10 = zzpnVar5.zzja() - 1;
                zzpnVar4 = zzpnVar5;
            }
        } else {
            zzpnVar4 = zzpnVar5;
            i3 = 0;
        }
        long j4 = 0;
        if (!(zzleVar.zzgz() && "audio/raw".equals(zzlsVar.zzahz.zzahe) && zzja == 0 && i2 == 0 && i3 == 0)) {
            long[] jArr5 = new long[zzgx];
            iArr = new int[zzgx];
            jArr2 = new long[zzgx];
            int i11 = i3;
            iArr2 = new int[zzgx];
            int i12 = i10;
            long j5 = 0;
            j2 = 0;
            int i13 = 0;
            i5 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = i2;
            int i18 = zzja3;
            int i19 = zzja2;
            int i20 = zzja;
            int i21 = i11;
            while (i13 < zzgx) {
                while (i15 == 0) {
                    zzpg.checkState(zzlaVar.zzha());
                    j5 = zzlaVar.zzawv;
                    i15 = zzlaVar.zzawu;
                    i18 = i18;
                    i19 = i19;
                }
                int i22 = i19;
                int i23 = i18;
                if (zzpnVar6 != null) {
                    while (i14 == 0 && i17 > 0) {
                        i14 = zzpnVar6.zzja();
                        i16 = zzpnVar6.readInt();
                        i17--;
                    }
                    i14--;
                }
                int i24 = i16;
                jArr5[i13] = j5;
                iArr[i13] = zzleVar.zzgy();
                if (iArr[i13] > i5) {
                    i5 = iArr[i13];
                }
                int i25 = zzgx;
                zzkz zzkzVar = zzleVar;
                jArr2[i13] = j2 + i24;
                iArr2[i13] = zzpnVar4 == null ? 1 : 0;
                if (i13 == i12) {
                    iArr2[i13] = 1;
                    i21--;
                    if (i21 > 0) {
                        i12 = zzpnVar4.zzja() - 1;
                    }
                }
                long[] jArr6 = jArr5;
                j2 += i23;
                int i26 = i22 - 1;
                if (i26 != 0 || i20 <= 0) {
                    i8 = i23;
                    i9 = i26;
                } else {
                    i9 = zzpnVar3.zzja();
                    i8 = zzpnVar3.zzja();
                    i20--;
                }
                int i27 = i9;
                j5 += iArr[i13];
                i15--;
                i13++;
                zzgx = i25;
                jArr5 = jArr6;
                i12 = i12;
                i16 = i24;
                i19 = i27;
                i18 = i8;
                zzleVar = zzkzVar;
            }
            i4 = zzgx;
            long[] jArr7 = jArr5;
            int i28 = i19;
            zzpg.checkArgument(i14 == 0);
            while (i17 > 0) {
                zzpg.checkArgument(zzpnVar6.zzja() == 0);
                zzpnVar6.readInt();
                i17--;
            }
            if (i21 == 0 && i28 == 0) {
                i7 = i15;
                if (i7 == 0 && i20 == 0) {
                    zzlsVar2 = zzlsVar;
                    jArr = jArr7;
                }
            } else {
                i7 = i15;
            }
            zzlsVar2 = zzlsVar;
            int i29 = zzlsVar2.id;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i29);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i21);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i28);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i7);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i20);
            Log.w("AtomParsers", sb.toString());
            jArr = jArr7;
        } else {
            zzlsVar2 = zzlsVar;
            i4 = zzgx;
            zzkz zzkzVar2 = zzleVar;
            int i30 = zzlaVar.length;
            long[] jArr8 = new long[i30];
            int[] iArr6 = new int[i30];
            while (zzlaVar.zzha()) {
                int i31 = zzlaVar.index;
                jArr8[i31] = zzlaVar.zzawv;
                iArr6[i31] = zzlaVar.zzawu;
            }
            int zzgy = zzkzVar2.zzgy();
            long j6 = zzja3;
            int i32 = 8192 / zzgy;
            int i33 = 0;
            for (int i34 = 0; i34 < i30; i34++) {
                i33 += zzpt.zzf(iArr6[i34], i32);
            }
            long[] jArr9 = new long[i33];
            int[] iArr7 = new int[i33];
            long[] jArr10 = new long[i33];
            int[] iArr8 = new int[i33];
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            while (i35 < i30) {
                int i39 = iArr6[i35];
                long j7 = jArr8[i35];
                int i40 = i30;
                int i41 = i39;
                while (i41 > 0) {
                    int min = Math.min(i32, i41);
                    jArr9[i37] = j7;
                    iArr7[i37] = zzgy * min;
                    i38 = Math.max(i38, iArr7[i37]);
                    jArr10[i37] = i36 * j6;
                    iArr8[i37] = 1;
                    j7 += iArr7[i37];
                    i36 += min;
                    i41 -= min;
                    i37++;
                    jArr8 = jArr8;
                    iArr6 = iArr6;
                }
                i35++;
                i30 = i40;
            }
            zzli zzliVar = new zzli(jArr9, iArr7, i38, jArr10, iArr8);
            jArr = zzliVar.zzaov;
            iArr = zzliVar.zzaou;
            i5 = zzliVar.zzayj;
            jArr2 = zzliVar.zzayk;
            iArr2 = zzliVar.zzayl;
            j2 = 0;
        }
        if (zzlsVar2.zzbal != null && !zzkeVar.zzgt()) {
            long[] jArr11 = zzlsVar2.zzbal;
            if (jArr11.length == 1 && zzlsVar2.type == 1 && jArr2.length >= 2) {
                long j8 = zzlsVar2.zzbam[0];
                long zza = zzpt.zza(jArr11[0], zzlsVar2.zzdf, zzlsVar2.zzbai) + j8;
                if (jArr2[0] <= j8 && j8 < jArr2[1] && jArr2[jArr2.length - 1] < zza && zza <= j2) {
                    long j9 = j2 - zza;
                    long zza2 = zzpt.zza(j8 - jArr2[0], zzlsVar2.zzahz.zzahp, zzlsVar2.zzdf);
                    long zza3 = zzpt.zza(j9, zzlsVar2.zzahz.zzahp, zzlsVar2.zzdf);
                    if ((zza2 != 0 || zza3 != 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                        zzkeVar.zzahr = (int) zza2;
                        zzkeVar.zzahs = (int) zza3;
                        zzpt.zza(jArr2, 1000000L, zzlsVar2.zzdf);
                        return new zzlt(jArr, iArr, i5, jArr2, iArr2);
                    }
                }
            }
            long[] jArr12 = zzlsVar2.zzbal;
            if (jArr12.length == 1) {
                char c = 0;
                if (jArr12[0] == 0) {
                    int i42 = 0;
                    while (i42 < jArr2.length) {
                        jArr2[i42] = zzpt.zza(jArr2[i42] - zzlsVar2.zzbam[c], 1000000L, zzlsVar2.zzdf);
                        i42++;
                        c = 0;
                    }
                    return new zzlt(jArr, iArr, i5, jArr2, iArr2);
                }
            }
            boolean z3 = zzlsVar2.type == 1;
            boolean z4 = false;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            while (true) {
                long[] jArr13 = zzlsVar2.zzbal;
                j3 = -1;
                if (i45 >= jArr13.length) {
                    break;
                }
                int i46 = i5;
                int[] iArr9 = iArr;
                long j10 = zzlsVar2.zzbam[i45];
                if (j10 != -1) {
                    i6 = i46;
                    long zza4 = zzpt.zza(jArr13[i45], zzlsVar2.zzdf, zzlsVar2.zzbai);
                    int zzb = zzpt.zzb(jArr2, j10, true, true);
                    int zzb2 = zzpt.zzb(jArr2, j10 + zza4, z3, false);
                    i43 += zzb2 - zzb;
                    z4 |= i44 != zzb;
                    i44 = zzb2;
                } else {
                    i6 = i46;
                }
                i45++;
                iArr = iArr9;
                i5 = i6;
            }
            int i47 = i5;
            int[] iArr10 = iArr;
            boolean z5 = z4 | (i43 != i4);
            long[] jArr14 = z5 ? new long[i43] : jArr;
            int[] iArr11 = z5 ? new int[i43] : iArr10;
            int i48 = z5 ? 0 : i47;
            int[] iArr12 = z5 ? new int[i43] : iArr2;
            long[] jArr15 = new long[i43];
            int i49 = i48;
            int i50 = 0;
            int i51 = 0;
            while (true) {
                long[] jArr16 = zzlsVar2.zzbal;
                if (i50 >= jArr16.length) {
                    break;
                }
                int[] iArr13 = iArr11;
                int[] iArr14 = iArr12;
                long j11 = zzlsVar2.zzbam[i50];
                long j12 = jArr16[i50];
                if (j11 != j3) {
                    jArr3 = jArr14;
                    long[] jArr17 = jArr;
                    int zzb3 = zzpt.zzb(jArr2, j11, true, true);
                    int zzb4 = zzpt.zzb(jArr2, zzpt.zza(j12, zzlsVar2.zzdf, zzlsVar2.zzbai) + j11, z3, false);
                    if (z5) {
                        int i52 = zzb4 - zzb3;
                        System.arraycopy(jArr17, zzb3, jArr3, i51, i52);
                        iArr4 = iArr10;
                        z2 = z3;
                        iArr3 = iArr13;
                        System.arraycopy(iArr4, zzb3, iArr3, i51, i52);
                        jArr4 = jArr17;
                        iArr5 = iArr14;
                        System.arraycopy(iArr2, zzb3, iArr5, i51, i52);
                    } else {
                        iArr4 = iArr10;
                        jArr4 = jArr17;
                        iArr5 = iArr14;
                        z2 = z3;
                        iArr3 = iArr13;
                    }
                    int i53 = i49;
                    while (zzb3 < zzb4) {
                        int[] iArr15 = iArr5;
                        int[] iArr16 = iArr4;
                        long j13 = j11;
                        jArr15[i51] = zzpt.zza(j4, 1000000L, zzlsVar2.zzbai) + zzpt.zza(jArr2[zzb3] - j11, 1000000L, zzlsVar2.zzdf);
                        if (z5 && iArr3[i51] > i53) {
                            i53 = iArr16[zzb3];
                        }
                        i51++;
                        zzb3++;
                        iArr4 = iArr16;
                        j11 = j13;
                        iArr5 = iArr15;
                    }
                    iArr14 = iArr5;
                    iArr10 = iArr4;
                    i49 = i53;
                } else {
                    jArr3 = jArr14;
                    jArr4 = jArr;
                    z2 = z3;
                    iArr3 = iArr13;
                }
                j4 += j12;
                i50++;
                iArr11 = iArr3;
                jArr14 = jArr3;
                z3 = z2;
                iArr12 = iArr14;
                jArr = jArr4;
                j3 = -1;
            }
            long[] jArr18 = jArr14;
            int[] iArr17 = iArr11;
            int[] iArr18 = iArr12;
            boolean z6 = false;
            for (int i54 = 0; i54 < iArr18.length && !z6; i54++) {
                z6 |= (iArr18[i54] & 1) != 0;
            }
            if (z6) {
                return new zzlt(jArr18, iArr17, i49, jArr15, iArr18);
            }
            throw new zzhw("The edited sample sequence does not contain a sync sample.");
        }
        int[] iArr19 = iArr;
        zzpt.zza(jArr2, 1000000L, zzlsVar2.zzdf);
        return new zzlt(jArr, iArr19, i5, jArr2, iArr2);
    }

    public static zzmh zza(zzky zzkyVar, boolean z) {
        if (z) {
            return null;
        }
        zzpn zzpnVar = zzkyVar.zzawt;
        zzpnVar.zzbi(8);
        while (zzpnVar.zziv() >= 8) {
            int position = zzpnVar.getPosition();
            int readInt = zzpnVar.readInt();
            if (zzpnVar.readInt() == zzkw.zzavy) {
                zzpnVar.zzbi(position);
                int i2 = position + readInt;
                zzpnVar.zzbj(12);
                while (true) {
                    if (zzpnVar.getPosition() >= i2) {
                        break;
                    }
                    int position2 = zzpnVar.getPosition();
                    int readInt2 = zzpnVar.readInt();
                    if (zzpnVar.readInt() == zzkw.zzavz) {
                        zzpnVar.zzbi(position2);
                        int i3 = position2 + readInt2;
                        zzpnVar.zzbj(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpnVar.getPosition() < i3) {
                            zzmh.zza zzd = zzll.zzd(zzpnVar);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmh(arrayList);
                        }
                    } else {
                        zzpnVar.zzbj(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpnVar.zzbj(readInt - 8);
        }
        return null;
    }

    private static int zza(zzpn zzpnVar, int i2, int i3, zzlc zzlcVar, int i4) {
        int position = zzpnVar.getPosition();
        while (true) {
            if (position - i2 >= i3) {
                return 0;
            }
            zzpnVar.zzbi(position);
            int readInt = zzpnVar.readInt();
            zzpg.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpnVar.readInt() == zzkw.zzaus) {
                int i5 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzlr zzlrVar = null;
                boolean z = false;
                while (i5 - position < readInt) {
                    zzpnVar.zzbi(i5);
                    int readInt2 = zzpnVar.readInt();
                    int readInt3 = zzpnVar.readInt();
                    if (readInt3 == zzkw.zzauy) {
                        num = Integer.valueOf(zzpnVar.readInt());
                    } else if (readInt3 == zzkw.zzaut) {
                        zzpnVar.zzbj(4);
                        z = zzpnVar.readInt() == zzaws;
                    } else if (readInt3 == zzkw.zzauu) {
                        int i6 = i5 + 8;
                        while (true) {
                            if (i6 - i5 >= readInt2) {
                                zzlrVar = null;
                                break;
                            }
                            zzpnVar.zzbi(i6);
                            int readInt4 = zzpnVar.readInt();
                            if (zzpnVar.readInt() == zzkw.zzauv) {
                                zzpnVar.zzbj(6);
                                boolean z2 = zzpnVar.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpnVar.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpnVar.zze(bArr, 0, 16);
                                zzlrVar = new zzlr(z2, readUnsignedByte, bArr);
                            } else {
                                i6 += readInt4;
                            }
                        }
                    }
                    i5 += readInt2;
                }
                if (z) {
                    zzpg.checkArgument(num != null, "frma atom is mandatory");
                    zzpg.checkArgument(zzlrVar != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlrVar);
                }
                if (pair != null) {
                    zzlcVar.zzaxd[i4] = (zzlr) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }
}
