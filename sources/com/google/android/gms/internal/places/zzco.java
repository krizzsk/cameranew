package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;
import us.pinguo.androidsdk.PGImageSDK;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzco<T> implements zzda<T> {
    private static final int[] zzkq = new int[0];
    private static final Unsafe zzkr = zzdy.zzdn();
    private final int[] zzks;
    private final Object[] zzkt;
    private final int zzku;
    private final int zzkv;
    private final zzck zzkw;
    private final boolean zzkx;
    private final boolean zzky;
    private final boolean zzkz;
    private final boolean zzla;
    private final int[] zzlb;
    private final int zzlc;
    private final int zzld;
    private final zzcs zzle;
    private final zzbu zzlf;
    private final zzds<?, ?> zzlg;
    private final zzar<?> zzlh;
    private final zzcd zzli;

    private zzco(int[] iArr, Object[] objArr, int i2, int i3, zzck zzckVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, zzcs zzcsVar, zzbu zzbuVar, zzds<?, ?> zzdsVar, zzar<?> zzarVar, zzcd zzcdVar) {
        this.zzks = iArr;
        this.zzkt = objArr;
        this.zzku = i2;
        this.zzkv = i3;
        this.zzky = zzckVar instanceof zzbc;
        this.zzkz = z;
        this.zzkx = zzarVar != null && zzarVar.zzf(zzckVar);
        this.zzla = false;
        this.zzlb = iArr2;
        this.zzlc = i4;
        this.zzld = i5;
        this.zzle = zzcsVar;
        this.zzlf = zzbuVar;
        this.zzlg = zzdsVar;
        this.zzlh = zzarVar;
        this.zzkw = zzckVar;
        this.zzli = zzcdVar;
    }

    private final zzda zzaf(int i2) {
        int i3 = (i2 / 3) << 1;
        zzda zzdaVar = (zzda) this.zzkt[i3];
        if (zzdaVar != null) {
            return zzdaVar;
        }
        zzda<T> zzf = zzcv.zzcq().zzf((Class) this.zzkt[i3 + 1]);
        this.zzkt[i3] = zzf;
        return zzf;
    }

    private final Object zzag(int i2) {
        return this.zzkt[(i2 / 3) << 1];
    }

    private final zzbf zzah(int i2) {
        return (zzbf) this.zzkt[((i2 / 3) << 1) + 1];
    }

    private final int zzai(int i2) {
        return this.zzks[i2 + 1];
    }

    private final int zzaj(int i2) {
        return this.zzks[i2 + 2];
    }

    private final int zzak(int i2) {
        if (i2 < this.zzku || i2 > this.zzkv) {
            return -1;
        }
        return zzr(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzco<T> zzb(Class<T> cls, zzci zzciVar, zzcs zzcsVar, zzbu zzbuVar, zzds<?, ?> zzdsVar, zzar<?> zzarVar, zzcd zzcdVar) {
        int i2;
        int charAt;
        int charAt2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char charAt3;
        int i9;
        char charAt4;
        int i10;
        char charAt5;
        int i11;
        char charAt6;
        int i12;
        char charAt7;
        int i13;
        char charAt8;
        int i14;
        char charAt9;
        int i15;
        char charAt10;
        int i16;
        int i17;
        boolean z;
        int i18;
        zzcx zzcxVar;
        int i19;
        int objectFieldOffset;
        int i20;
        int i21;
        Class<?> cls2;
        String str;
        int i22;
        int i23;
        Field zzb;
        int i24;
        char charAt11;
        int i25;
        Field zzb2;
        Field zzb3;
        int i26;
        char charAt12;
        int i27;
        char charAt13;
        int i28;
        char charAt14;
        int i29;
        char charAt15;
        char charAt16;
        if (zzciVar instanceof zzcx) {
            zzcx zzcxVar2 = (zzcx) zzciVar;
            int i30 = 0;
            boolean z2 = zzcxVar2.zzcj() == zzbc.zze.zziu;
            String zzcr = zzcxVar2.zzcr();
            int length = zzcr.length();
            int charAt17 = zzcr.charAt(0);
            if (charAt17 >= 55296) {
                int i31 = charAt17 & 8191;
                int i32 = 1;
                int i33 = 13;
                while (true) {
                    i2 = i32 + 1;
                    charAt16 = zzcr.charAt(i32);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i31 |= (charAt16 & 8191) << i33;
                    i33 += 13;
                    i32 = i2;
                }
                charAt17 = i31 | (charAt16 << i33);
            } else {
                i2 = 1;
            }
            int i34 = i2 + 1;
            int charAt18 = zzcr.charAt(i2);
            if (charAt18 >= 55296) {
                int i35 = charAt18 & 8191;
                int i36 = 13;
                while (true) {
                    i29 = i34 + 1;
                    charAt15 = zzcr.charAt(i34);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i35 |= (charAt15 & 8191) << i36;
                    i36 += 13;
                    i34 = i29;
                }
                charAt18 = i35 | (charAt15 << i36);
                i34 = i29;
            }
            if (charAt18 == 0) {
                iArr = zzkq;
                i7 = 0;
                i4 = 0;
                charAt = 0;
                i5 = 0;
                charAt2 = 0;
                i6 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt19 = zzcr.charAt(i34);
                if (charAt19 >= 55296) {
                    int i38 = charAt19 & 8191;
                    int i39 = 13;
                    while (true) {
                        i15 = i37 + 1;
                        charAt10 = zzcr.charAt(i37);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i38 |= (charAt10 & 8191) << i39;
                        i39 += 13;
                        i37 = i15;
                    }
                    charAt19 = i38 | (charAt10 << i39);
                    i37 = i15;
                }
                int i40 = i37 + 1;
                int charAt20 = zzcr.charAt(i37);
                if (charAt20 >= 55296) {
                    int i41 = charAt20 & 8191;
                    int i42 = 13;
                    while (true) {
                        i14 = i40 + 1;
                        charAt9 = zzcr.charAt(i40);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i41 |= (charAt9 & 8191) << i42;
                        i42 += 13;
                        i40 = i14;
                    }
                    charAt20 = i41 | (charAt9 << i42);
                    i40 = i14;
                }
                int i43 = i40 + 1;
                charAt = zzcr.charAt(i40);
                if (charAt >= 55296) {
                    int i44 = charAt & 8191;
                    int i45 = 13;
                    while (true) {
                        i13 = i43 + 1;
                        charAt8 = zzcr.charAt(i43);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i44 |= (charAt8 & 8191) << i45;
                        i45 += 13;
                        i43 = i13;
                    }
                    charAt = i44 | (charAt8 << i45);
                    i43 = i13;
                }
                int i46 = i43 + 1;
                int charAt21 = zzcr.charAt(i43);
                if (charAt21 >= 55296) {
                    int i47 = charAt21 & 8191;
                    int i48 = 13;
                    while (true) {
                        i12 = i46 + 1;
                        charAt7 = zzcr.charAt(i46);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i47 |= (charAt7 & 8191) << i48;
                        i48 += 13;
                        i46 = i12;
                    }
                    charAt21 = i47 | (charAt7 << i48);
                    i46 = i12;
                }
                int i49 = i46 + 1;
                charAt2 = zzcr.charAt(i46);
                if (charAt2 >= 55296) {
                    int i50 = charAt2 & 8191;
                    int i51 = 13;
                    while (true) {
                        i11 = i49 + 1;
                        charAt6 = zzcr.charAt(i49);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i50 |= (charAt6 & 8191) << i51;
                        i51 += 13;
                        i49 = i11;
                    }
                    charAt2 = i50 | (charAt6 << i51);
                    i49 = i11;
                }
                int i52 = i49 + 1;
                int charAt22 = zzcr.charAt(i49);
                if (charAt22 >= 55296) {
                    int i53 = charAt22 & 8191;
                    int i54 = 13;
                    while (true) {
                        i10 = i52 + 1;
                        charAt5 = zzcr.charAt(i52);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i53 |= (charAt5 & 8191) << i54;
                        i54 += 13;
                        i52 = i10;
                    }
                    charAt22 = i53 | (charAt5 << i54);
                    i52 = i10;
                }
                int i55 = i52 + 1;
                int charAt23 = zzcr.charAt(i52);
                if (charAt23 >= 55296) {
                    int i56 = charAt23 & 8191;
                    int i57 = i55;
                    int i58 = 13;
                    while (true) {
                        i9 = i57 + 1;
                        charAt4 = zzcr.charAt(i57);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i56 |= (charAt4 & 8191) << i58;
                        i58 += 13;
                        i57 = i9;
                    }
                    charAt23 = i56 | (charAt4 << i58);
                    i3 = i9;
                } else {
                    i3 = i55;
                }
                int i59 = i3 + 1;
                int charAt24 = zzcr.charAt(i3);
                if (charAt24 >= 55296) {
                    int i60 = charAt24 & 8191;
                    int i61 = i59;
                    int i62 = 13;
                    while (true) {
                        i8 = i61 + 1;
                        charAt3 = zzcr.charAt(i61);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i60 |= (charAt3 & 8191) << i62;
                        i62 += 13;
                        i61 = i8;
                    }
                    charAt24 = i60 | (charAt3 << i62);
                    i59 = i8;
                }
                int i63 = (charAt19 << 1) + charAt20;
                i4 = charAt21;
                i5 = i63;
                i6 = charAt24;
                i30 = charAt19;
                i34 = i59;
                int i64 = charAt22;
                iArr = new int[charAt24 + charAt22 + charAt23];
                i7 = i64;
            }
            Unsafe unsafe = zzkr;
            Object[] zzcs = zzcxVar2.zzcs();
            Class<?> cls3 = zzcxVar2.zzcl().getClass();
            int i65 = i34;
            int[] iArr2 = new int[charAt2 * 3];
            Object[] objArr = new Object[charAt2 << 1];
            int i66 = i6 + i7;
            int i67 = i6;
            int i68 = i65;
            int i69 = i66;
            int i70 = 0;
            int i71 = 0;
            while (i68 < length) {
                int i72 = i68 + 1;
                int charAt25 = zzcr.charAt(i68);
                int i73 = length;
                if (charAt25 >= 55296) {
                    int i74 = charAt25 & 8191;
                    int i75 = i72;
                    int i76 = 13;
                    while (true) {
                        i28 = i75 + 1;
                        charAt14 = zzcr.charAt(i75);
                        i16 = i6;
                        if (charAt14 < 55296) {
                            break;
                        }
                        i74 |= (charAt14 & 8191) << i76;
                        i76 += 13;
                        i75 = i28;
                        i6 = i16;
                    }
                    charAt25 = i74 | (charAt14 << i76);
                    i17 = i28;
                } else {
                    i16 = i6;
                    i17 = i72;
                }
                int i77 = i17 + 1;
                int charAt26 = zzcr.charAt(i17);
                if (charAt26 >= 55296) {
                    int i78 = charAt26 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i27 = i79 + 1;
                        charAt13 = zzcr.charAt(i79);
                        z = z2;
                        if (charAt13 < 55296) {
                            break;
                        }
                        i78 |= (charAt13 & 8191) << i80;
                        i80 += 13;
                        i79 = i27;
                        z2 = z;
                    }
                    charAt26 = i78 | (charAt13 << i80);
                    i18 = i27;
                } else {
                    z = z2;
                    i18 = i77;
                }
                int i81 = charAt26 & 255;
                int i82 = i4;
                if ((charAt26 & 1024) != 0) {
                    iArr[i70] = i71;
                    i70++;
                }
                int i83 = charAt;
                if (i81 >= 51) {
                    int i84 = i18 + 1;
                    int charAt27 = zzcr.charAt(i18);
                    char c = 55296;
                    if (charAt27 >= 55296) {
                        int i85 = charAt27 & 8191;
                        int i86 = 13;
                        while (true) {
                            i26 = i84 + 1;
                            charAt12 = zzcr.charAt(i84);
                            if (charAt12 < c) {
                                break;
                            }
                            i85 |= (charAt12 & 8191) << i86;
                            i86 += 13;
                            i84 = i26;
                            c = 55296;
                        }
                        charAt27 = i85 | (charAt12 << i86);
                        i84 = i26;
                    }
                    int i87 = i81 - 51;
                    int i88 = i84;
                    if (i87 == 9 || i87 == 17) {
                        objArr[((i71 / 3) << 1) + 1] = zzcs[i5];
                        i5++;
                    } else if (i87 == 12 && (charAt17 & 1) == 1) {
                        objArr[((i71 / 3) << 1) + 1] = zzcs[i5];
                        i5++;
                    }
                    int i89 = charAt27 << 1;
                    Object obj = zzcs[i89];
                    if (obj instanceof Field) {
                        zzb2 = (Field) obj;
                    } else {
                        zzb2 = zzb(cls3, (String) obj);
                        zzcs[i89] = zzb2;
                    }
                    zzcxVar = zzcxVar2;
                    String str2 = zzcr;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzb2);
                    int i90 = i89 + 1;
                    Object obj2 = zzcs[i90];
                    if (obj2 instanceof Field) {
                        zzb3 = (Field) obj2;
                    } else {
                        zzb3 = zzb(cls3, (String) obj2);
                        zzcs[i90] = zzb3;
                    }
                    cls2 = cls3;
                    i20 = i5;
                    i18 = i88;
                    str = str2;
                    i23 = 0;
                    i22 = (int) unsafe.objectFieldOffset(zzb3);
                    i21 = i30;
                } else {
                    zzcxVar = zzcxVar2;
                    String str3 = zzcr;
                    int i91 = i5 + 1;
                    Field zzb4 = zzb(cls3, (String) zzcs[i5]);
                    if (i81 == 9 || i81 == 17) {
                        i19 = 1;
                        objArr[((i71 / 3) << 1) + 1] = zzb4.getType();
                    } else {
                        if (i81 == 27 || i81 == 49) {
                            i19 = 1;
                            i25 = i91 + 1;
                            objArr[((i71 / 3) << 1) + 1] = zzcs[i91];
                        } else if (i81 == 12 || i81 == 30 || i81 == 44) {
                            i19 = 1;
                            if ((charAt17 & 1) == 1) {
                                i25 = i91 + 1;
                                objArr[((i71 / 3) << 1) + 1] = zzcs[i91];
                            }
                        } else {
                            if (i81 == 50) {
                                int i92 = i67 + 1;
                                iArr[i67] = i71;
                                int i93 = (i71 / 3) << 1;
                                int i94 = i91 + 1;
                                objArr[i93] = zzcs[i91];
                                if ((charAt26 & 2048) != 0) {
                                    i91 = i94 + 1;
                                    objArr[i93 + 1] = zzcs[i94];
                                    i67 = i92;
                                } else {
                                    i91 = i94;
                                    i19 = 1;
                                    i67 = i92;
                                }
                            }
                            i19 = 1;
                        }
                        i91 = i25;
                    }
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzb4);
                    if ((charAt17 & 1) != i19 || i81 > 17) {
                        i20 = i91;
                        i21 = i30;
                        cls2 = cls3;
                        str = str3;
                        i22 = 0;
                        i23 = 0;
                    } else {
                        int i95 = i18 + 1;
                        str = str3;
                        int charAt28 = str.charAt(i18);
                        if (charAt28 >= 55296) {
                            int i96 = charAt28 & 8191;
                            int i97 = 13;
                            while (true) {
                                i24 = i95 + 1;
                                charAt11 = str.charAt(i95);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i96 |= (charAt11 & 8191) << i97;
                                i97 += 13;
                                i95 = i24;
                            }
                            charAt28 = i96 | (charAt11 << i97);
                            i95 = i24;
                        }
                        int i98 = (i30 << 1) + (charAt28 / 32);
                        Object obj3 = zzcs[i98];
                        i20 = i91;
                        if (obj3 instanceof Field) {
                            zzb = (Field) obj3;
                        } else {
                            zzb = zzb(cls3, (String) obj3);
                            zzcs[i98] = zzb;
                        }
                        i21 = i30;
                        cls2 = cls3;
                        i22 = (int) unsafe.objectFieldOffset(zzb);
                        i23 = charAt28 % 32;
                        i18 = i95;
                    }
                    if (i81 >= 18 && i81 <= 49) {
                        iArr[i69] = objectFieldOffset;
                        i69++;
                    }
                }
                int i99 = i71 + 1;
                iArr2[i71] = charAt25;
                int i100 = i99 + 1;
                iArr2[i99] = objectFieldOffset | ((charAt26 & 256) != 0 ? PGImageSDK.SDK_STATUS_CREATE : 0) | ((charAt26 & 512) != 0 ? 536870912 : 0) | (i81 << 20);
                i71 = i100 + 1;
                iArr2[i100] = (i23 << 20) | i22;
                i30 = i21;
                zzcr = str;
                i68 = i18;
                cls3 = cls2;
                i4 = i82;
                length = i73;
                i6 = i16;
                z2 = z;
                charAt = i83;
                i5 = i20;
                zzcxVar2 = zzcxVar;
            }
            return new zzco<>(iArr2, objArr, charAt, i4, zzcxVar2.zzcl(), z2, false, iArr, i6, i66, zzcsVar, zzbuVar, zzdsVar, zzarVar, zzcdVar);
        }
        ((zzdl) zzciVar).zzcj();
        int i101 = zzbc.zze.zziu;
        throw new NoSuchMethodError();
    }

    private final void zzc(T t, T t2, int i2) {
        int zzai = zzai(i2);
        int i3 = this.zzks[i2];
        long j2 = zzai & 1048575;
        if (zzb((zzco<T>) t2, i3, i2)) {
            Object zzp = zzdy.zzp(t, j2);
            Object zzp2 = zzdy.zzp(t2, j2);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb(t, j2, zzbd.zzb(zzp, zzp2));
                zzc((zzco<T>) t, i3, i2);
            } else if (zzp2 != null) {
                zzdy.zzb(t, j2, zzp2);
                zzc((zzco<T>) t, i3, i2);
            }
        }
    }

    private static List<?> zze(Object obj, long j2) {
        return (List) zzdy.zzp(obj, j2);
    }

    private static <T> double zzf(T t, long j2) {
        return ((Double) zzdy.zzp(t, j2)).doubleValue();
    }

    private static <T> float zzg(T t, long j2) {
        return ((Float) zzdy.zzp(t, j2)).floatValue();
    }

    private static <T> int zzh(T t, long j2) {
        return ((Integer) zzdy.zzp(t, j2)).intValue();
    }

    private static <T> long zzi(T t, long j2) {
        return ((Long) zzdy.zzp(t, j2)).longValue();
    }

    private static <T> boolean zzj(T t, long j2) {
        return ((Boolean) zzdy.zzp(t, j2)).booleanValue();
    }

    private static zzdr zzo(Object obj) {
        zzbc zzbcVar = (zzbc) obj;
        zzdr zzdrVar = zzbcVar.zzih;
        if (zzdrVar == zzdr.zzdh()) {
            zzdr zzdi = zzdr.zzdi();
            zzbcVar.zzih = zzdi;
            return zzdi;
        }
        return zzdrVar;
    }

    private final int zzq(int i2, int i3) {
        if (i2 < this.zzku || i2 > this.zzkv) {
            return -1;
        }
        return zzr(i2, i3);
    }

    private final int zzr(int i2, int i3) {
        int length = (this.zzks.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzks[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzm(r10, r6) == com.google.android.gms.internal.places.zzdy.zzm(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final int hashCode(T t) {
        int i2;
        int zzl;
        int length = this.zzks.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzai = zzai(i4);
            int i5 = this.zzks[i4];
            long j2 = 1048575 & zzai;
            int i6 = 37;
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    zzl = zzbd.zzl(Double.doubleToLongBits(zzdy.zzo(t, j2)));
                    i3 = i2 + zzl;
                    break;
                case 1:
                    i2 = i3 * 53;
                    zzl = Float.floatToIntBits(zzdy.zzn(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 2:
                    i2 = i3 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 3:
                    i2 = i3 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 4:
                    i2 = i3 * 53;
                    zzl = zzdy.zzk(t, j2);
                    i3 = i2 + zzl;
                    break;
                case 5:
                    i2 = i3 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 6:
                    i2 = i3 * 53;
                    zzl = zzdy.zzk(t, j2);
                    i3 = i2 + zzl;
                    break;
                case 7:
                    i2 = i3 * 53;
                    zzl = zzbd.zze(zzdy.zzm(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 8:
                    i2 = i3 * 53;
                    zzl = ((String) zzdy.zzp(t, j2)).hashCode();
                    i3 = i2 + zzl;
                    break;
                case 9:
                    Object zzp = zzdy.zzp(t, j2);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    zzl = zzdy.zzp(t, j2).hashCode();
                    i3 = i2 + zzl;
                    break;
                case 11:
                    i2 = i3 * 53;
                    zzl = zzdy.zzk(t, j2);
                    i3 = i2 + zzl;
                    break;
                case 12:
                    i2 = i3 * 53;
                    zzl = zzdy.zzk(t, j2);
                    i3 = i2 + zzl;
                    break;
                case 13:
                    i2 = i3 * 53;
                    zzl = zzdy.zzk(t, j2);
                    i3 = i2 + zzl;
                    break;
                case 14:
                    i2 = i3 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 15:
                    i2 = i3 * 53;
                    zzl = zzdy.zzk(t, j2);
                    i3 = i2 + zzl;
                    break;
                case 16:
                    i2 = i3 * 53;
                    zzl = zzbd.zzl(zzdy.zzl(t, j2));
                    i3 = i2 + zzl;
                    break;
                case 17:
                    Object zzp2 = zzdy.zzp(t, j2);
                    if (zzp2 != null) {
                        i6 = zzp2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    zzl = zzdy.zzp(t, j2).hashCode();
                    i3 = i2 + zzl;
                    break;
                case 50:
                    i2 = i3 * 53;
                    zzl = zzdy.zzp(t, j2).hashCode();
                    i3 = i2 + zzl;
                    break;
                case 51:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zzl(Double.doubleToLongBits(zzf(t, j2)));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = Float.floatToIntBits(zzg(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zzl(zzi(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zzl(zzi(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzh(t, j2);
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zzl(zzi(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzh(t, j2);
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zze(zzj(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = ((String) zzdy.zzp(t, j2)).hashCode();
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzdy.zzp(t, j2).hashCode();
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzdy.zzp(t, j2).hashCode();
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzh(t, j2);
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzh(t, j2);
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzh(t, j2);
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zzl(zzi(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzh(t, j2);
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzbd.zzl(zzi(t, j2));
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzb((zzco<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzl = zzdy.zzp(t, j2).hashCode();
                        i3 = i2 + zzl;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzlg.zzr(t).hashCode();
        return this.zzkx ? (hashCode * 53) + this.zzlh.zzb(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final T newInstance() {
        return (T) this.zzle.newInstance(this.zzkw);
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzd(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.zzks.length; i2 += 3) {
            int zzai = zzai(i2);
            long j2 = 1048575 & zzai;
            int i3 = this.zzks[i2];
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb(t, j2, zzdy.zzo(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzn(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzl(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzl(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzk(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzl(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzk(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb(t, j2, zzdy.zzm(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb(t, j2, zzdy.zzp(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzb(t, t2, i2);
                    break;
                case 10:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb(t, j2, zzdy.zzp(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzk(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzk(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzk(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzl(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzk(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzb((zzco<T>) t2, i2)) {
                        zzdy.zzb((Object) t, j2, zzdy.zzl(t2, j2));
                        zzc((zzco<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzb(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzlf.zzb(t, t2, j2);
                    break;
                case 50:
                    zzdc.zzb(this.zzli, t, t2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzb((zzco<T>) t2, i3, i2)) {
                        zzdy.zzb(t, j2, zzdy.zzp(t2, j2));
                        zzc((zzco<T>) t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzc(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzb((zzco<T>) t2, i3, i2)) {
                        zzdy.zzb(t, j2, zzdy.zzp(t2, j2));
                        zzc((zzco<T>) t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzc(t, t2, i2);
                    break;
            }
        }
        if (this.zzkz) {
            return;
        }
        zzdc.zzb(this.zzlg, t, t2);
        if (this.zzkx) {
            zzdc.zzb(this.zzlh, t, t2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.places.zzda
    public final int zzn(T t) {
        int i2;
        int i3;
        long j2;
        int zze;
        int zzc;
        int zzl;
        int zzw;
        int zzm;
        int zzr;
        int zzt;
        int zzc2;
        int zzm2;
        int zzr2;
        int zzt2;
        int i4 = 267386880;
        int i5 = 1;
        if (this.zzkz) {
            Unsafe unsafe = zzkr;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.zzks.length) {
                int zzai = zzai(i6);
                int i8 = (zzai & i4) >>> 20;
                int i9 = this.zzks[i6];
                long j3 = zzai & 1048575;
                int i10 = (i8 < zzaw.zzgw.id() || i8 > zzaw.zzhj.id()) ? 0 : this.zzks[i6 + 2] & 1048575;
                switch (i8) {
                    case 0:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzc(i9, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 1:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzc(i9, 0.0f);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 2:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zze(i9, zzdy.zzl(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 3:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzf(i9, zzdy.zzl(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 4:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzh(i9, zzdy.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 5:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzh(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 6:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzk(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 7:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzd(i9, true);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 8:
                        if (zzb((zzco<T>) t, i6)) {
                            Object zzp = zzdy.zzp(t, j3);
                            if (zzp instanceof zzw) {
                                zzc2 = zzaj.zzd(i9, (zzw) zzp);
                                break;
                            } else {
                                zzc2 = zzaj.zzc(i9, (String) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 9:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzdc.zzd(i9, zzdy.zzp(t, j3), zzaf(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 10:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzd(i9, (zzw) zzdy.zzp(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 11:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzi(i9, zzdy.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 12:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzm(i9, zzdy.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 13:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzl(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 14:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzi(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 15:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzj(i9, zzdy.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 16:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzg(i9, zzdy.zzl(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 17:
                        if (zzb((zzco<T>) t, i6)) {
                            zzc2 = zzaj.zzd(i9, (zzck) zzdy.zzp(t, j3), zzaf(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 18:
                        zzc2 = zzdc.zzx(i9, zze(t, j3), false);
                        break;
                    case 19:
                        zzc2 = zzdc.zzw(i9, zze(t, j3), false);
                        break;
                    case 20:
                        zzc2 = zzdc.zzp(i9, zze(t, j3), false);
                        break;
                    case 21:
                        zzc2 = zzdc.zzq(i9, zze(t, j3), false);
                        break;
                    case 22:
                        zzc2 = zzdc.zzt(i9, zze(t, j3), false);
                        break;
                    case 23:
                        zzc2 = zzdc.zzx(i9, zze(t, j3), false);
                        break;
                    case 24:
                        zzc2 = zzdc.zzw(i9, zze(t, j3), false);
                        break;
                    case 25:
                        zzc2 = zzdc.zzy(i9, zze(t, j3), false);
                        break;
                    case 26:
                        zzc2 = zzdc.zzd(i9, zze(t, j3));
                        break;
                    case 27:
                        zzc2 = zzdc.zzd(i9, zze(t, j3), zzaf(i6));
                        break;
                    case 28:
                        zzc2 = zzdc.zze(i9, (List<zzw>) zze(t, j3));
                        break;
                    case 29:
                        zzc2 = zzdc.zzu(i9, zze(t, j3), false);
                        break;
                    case 30:
                        zzc2 = zzdc.zzs(i9, zze(t, j3), false);
                        break;
                    case 31:
                        zzc2 = zzdc.zzw(i9, zze(t, j3), false);
                        break;
                    case 32:
                        zzc2 = zzdc.zzx(i9, zze(t, j3), false);
                        break;
                    case 33:
                        zzc2 = zzdc.zzv(i9, zze(t, j3), false);
                        break;
                    case 34:
                        zzc2 = zzdc.zzr(i9, zze(t, j3), false);
                        break;
                    case 35:
                        zzm2 = zzdc.zzm((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 36:
                        zzm2 = zzdc.zzl((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 37:
                        zzm2 = zzdc.zze((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 38:
                        zzm2 = zzdc.zzf((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 39:
                        zzm2 = zzdc.zzi((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 40:
                        zzm2 = zzdc.zzm((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 41:
                        zzm2 = zzdc.zzl((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 42:
                        zzm2 = zzdc.zzn((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 43:
                        zzm2 = zzdc.zzj((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 44:
                        zzm2 = zzdc.zzh((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 45:
                        zzm2 = zzdc.zzl((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 46:
                        zzm2 = zzdc.zzm((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 47:
                        zzm2 = zzdc.zzk((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 48:
                        zzm2 = zzdc.zzg((List) unsafe.getObject(t, j3));
                        if (zzm2 > 0) {
                            if (this.zzla) {
                                unsafe.putInt(t, i10, zzm2);
                            }
                            zzr2 = zzaj.zzr(i9);
                            zzt2 = zzaj.zzt(zzm2);
                            zzc2 = zzr2 + zzt2 + zzm2;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 49:
                        zzc2 = zzdc.zze(i9, zze(t, j3), zzaf(i6));
                        break;
                    case 50:
                        zzc2 = this.zzli.zzc(i9, zzdy.zzp(t, j3), zzag(i6));
                        break;
                    case 51:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzc(i9, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 52:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzc(i9, 0.0f);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 53:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zze(i9, zzi(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 54:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzf(i9, zzi(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 55:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzh(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 56:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzh(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 57:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzk(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 58:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzd(i9, true);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 59:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            Object zzp2 = zzdy.zzp(t, j3);
                            if (zzp2 instanceof zzw) {
                                zzc2 = zzaj.zzd(i9, (zzw) zzp2);
                                break;
                            } else {
                                zzc2 = zzaj.zzc(i9, (String) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 60:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzdc.zzd(i9, zzdy.zzp(t, j3), zzaf(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 61:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzd(i9, (zzw) zzdy.zzp(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 62:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzi(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 63:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzm(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 64:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzl(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 65:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzi(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 66:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzj(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 67:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzg(i9, zzi(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    case 68:
                        if (zzb((zzco<T>) t, i9, i6)) {
                            zzc2 = zzaj.zzd(i9, (zzck) zzdy.zzp(t, j3), zzaf(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i4 = 267386880;
                        }
                    default:
                        i6 += 3;
                        i4 = 267386880;
                }
                i7 += zzc2;
                i6 += 3;
                i4 = 267386880;
            }
            return i7 + zzb(this.zzlg, t);
        }
        Unsafe unsafe2 = zzkr;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < this.zzks.length) {
            int zzai2 = zzai(i12);
            int[] iArr = this.zzks;
            int i15 = iArr[i12];
            int i16 = (zzai2 & 267386880) >>> 20;
            if (i16 <= 17) {
                int i17 = iArr[i12 + 2];
                int i18 = i17 & 1048575;
                i3 = i5 << (i17 >>> 20);
                if (i18 != i11) {
                    i14 = unsafe2.getInt(t, i18);
                    i11 = i18;
                }
                i2 = i17;
            } else {
                i2 = (!this.zzla || i16 < zzaw.zzgw.id() || i16 > zzaw.zzhj.id()) ? 0 : this.zzks[i12 + 2] & 1048575;
                i3 = 0;
            }
            long j4 = zzai2 & 1048575;
            switch (i16) {
                case 0:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        i13 += zzaj.zzc(i15, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    }
                    break;
                case 1:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        i13 += zzaj.zzc(i15, 0.0f);
                        break;
                    }
                case 2:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        zze = zzaj.zze(i15, unsafe2.getLong(t, j4));
                        i13 += zze;
                    }
                    break;
                case 3:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        zze = zzaj.zzf(i15, unsafe2.getLong(t, j4));
                        i13 += zze;
                    }
                    break;
                case 4:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        zze = zzaj.zzh(i15, unsafe2.getInt(t, j4));
                        i13 += zze;
                    }
                    break;
                case 5:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        zze = zzaj.zzh(i15, 0L);
                        i13 += zze;
                    }
                    break;
                case 6:
                    if ((i14 & i3) != 0) {
                        i13 += zzaj.zzk(i15, 0);
                        j2 = 0;
                        break;
                    }
                    j2 = 0;
                case 7:
                    if ((i14 & i3) != 0) {
                        i13 += zzaj.zzd(i15, true);
                        j2 = 0;
                        break;
                    }
                    j2 = 0;
                case 8:
                    if ((i14 & i3) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzw) {
                            zzc = zzaj.zzd(i15, (zzw) object);
                        } else {
                            zzc = zzaj.zzc(i15, (String) object);
                        }
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 9:
                    if ((i14 & i3) != 0) {
                        zzc = zzdc.zzd(i15, unsafe2.getObject(t, j4), zzaf(i12));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 10:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzd(i15, (zzw) unsafe2.getObject(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 11:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzi(i15, unsafe2.getInt(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 12:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzm(i15, unsafe2.getInt(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 13:
                    if ((i14 & i3) != 0) {
                        zzl = zzaj.zzl(i15, 0);
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 14:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzi(i15, 0L);
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 15:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzj(i15, unsafe2.getInt(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 16:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzg(i15, unsafe2.getLong(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 17:
                    if ((i14 & i3) != 0) {
                        zzc = zzaj.zzd(i15, (zzck) unsafe2.getObject(t, j4), zzaf(i12));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 18:
                    zzc = zzdc.zzx(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 19:
                    zzw = zzdc.zzw(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 20:
                    zzw = zzdc.zzp(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 21:
                    zzw = zzdc.zzq(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 22:
                    zzw = zzdc.zzt(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 23:
                    zzw = zzdc.zzx(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 24:
                    zzw = zzdc.zzw(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 25:
                    zzw = zzdc.zzy(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 26:
                    zzc = zzdc.zzd(i15, (List) unsafe2.getObject(t, j4));
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 27:
                    zzc = zzdc.zzd(i15, (List<?>) unsafe2.getObject(t, j4), zzaf(i12));
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 28:
                    zzc = zzdc.zze(i15, (List) unsafe2.getObject(t, j4));
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 29:
                    zzc = zzdc.zzu(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 30:
                    zzw = zzdc.zzs(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 31:
                    zzw = zzdc.zzw(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 32:
                    zzw = zzdc.zzx(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 33:
                    zzw = zzdc.zzv(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 34:
                    zzw = zzdc.zzr(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += zzw;
                    j2 = 0;
                    break;
                case 35:
                    zzm = zzdc.zzm((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 36:
                    zzm = zzdc.zzl((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 37:
                    zzm = zzdc.zze((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 38:
                    zzm = zzdc.zzf((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 39:
                    zzm = zzdc.zzi((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 40:
                    zzm = zzdc.zzm((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 41:
                    zzm = zzdc.zzl((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 42:
                    zzm = zzdc.zzn((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 43:
                    zzm = zzdc.zzj((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 44:
                    zzm = zzdc.zzh((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 45:
                    zzm = zzdc.zzl((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 46:
                    zzm = zzdc.zzm((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 47:
                    zzm = zzdc.zzk((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 48:
                    zzm = zzdc.zzg((List) unsafe2.getObject(t, j4));
                    if (zzm > 0) {
                        if (this.zzla) {
                            unsafe2.putInt(t, i2, zzm);
                        }
                        zzr = zzaj.zzr(i15);
                        zzt = zzaj.zzt(zzm);
                        zzl = zzr + zzt + zzm;
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 49:
                    zzc = zzdc.zze(i15, (List) unsafe2.getObject(t, j4), zzaf(i12));
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 50:
                    zzc = this.zzli.zzc(i15, unsafe2.getObject(t, j4), zzag(i12));
                    i13 += zzc;
                    j2 = 0;
                    break;
                case 51:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzc(i15, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 52:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzl = zzaj.zzc(i15, 0.0f);
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 53:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zze(i15, zzi(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 54:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzf(i15, zzi(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 55:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzh(i15, zzh(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 56:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzh(i15, 0L);
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 57:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzl = zzaj.zzk(i15, 0);
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 58:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzl = zzaj.zzd(i15, true);
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 59:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzw) {
                            zzc = zzaj.zzd(i15, (zzw) object2);
                        } else {
                            zzc = zzaj.zzc(i15, (String) object2);
                        }
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 60:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzdc.zzd(i15, unsafe2.getObject(t, j4), zzaf(i12));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 61:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzd(i15, (zzw) unsafe2.getObject(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 62:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzi(i15, zzh(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 63:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzm(i15, zzh(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 64:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzl = zzaj.zzl(i15, 0);
                        i13 += zzl;
                    }
                    j2 = 0;
                    break;
                case 65:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzi(i15, 0L);
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 66:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzj(i15, zzh(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 67:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzg(i15, zzi(t, j4));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                case 68:
                    if (zzb((zzco<T>) t, i15, i12)) {
                        zzc = zzaj.zzd(i15, (zzck) unsafe2.getObject(t, j4), zzaf(i12));
                        i13 += zzc;
                    }
                    j2 = 0;
                    break;
                default:
                    j2 = 0;
                    break;
            }
            i12 += 3;
            i5 = 1;
        }
        int i19 = 0;
        int zzb = i13 + zzb(this.zzlg, t);
        if (this.zzkx) {
            zzav<?> zzb2 = this.zzlh.zzb(t);
            for (int i20 = 0; i20 < zzb2.zzfj.zzcu(); i20++) {
                Map.Entry<?, Object> zzam = zzb2.zzfj.zzam(i20);
                i19 += zzav.zzc((zzax) zzam.getKey(), zzam.getValue());
            }
            for (Map.Entry<?, Object> entry : zzb2.zzfj.zzcv()) {
                i19 += zzav.zzc((zzax) entry.getKey(), entry.getValue());
            }
            return zzb + i19;
        }
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.places.zzda] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.places.zzda] */
    @Override // com.google.android.gms.internal.places.zzda
    public final boolean zzp(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= this.zzlc) {
                return !this.zzkx || this.zzlh.zzb(t).isInitialized();
            }
            int i6 = this.zzlb[i4];
            int i7 = this.zzks[i6];
            int zzai = zzai(i6);
            if (this.zzkz) {
                i2 = 0;
            } else {
                int i8 = this.zzks[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = zzkr.getInt(t, i9);
                    i3 = i9;
                }
            }
            if (((268435456 & zzai) != 0) && !zzb((zzco<T>) t, i6, i5, i2)) {
                return false;
            }
            int i10 = (267386880 & zzai) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (zzb((zzco<T>) t, i7, i6) && !zzb(t, zzai, zzaf(i6))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzh = this.zzli.zzh(zzdy.zzp(t, zzai & 1048575));
                            if (!zzh.isEmpty()) {
                                if (this.zzli.zzl(zzag(i6)).zzkl.zzdr() == zzem.MESSAGE) {
                                    zzda<T> zzdaVar = 0;
                                    Iterator<?> it = zzh.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzdaVar == null) {
                                            zzdaVar = zzcv.zzcq().zzf(next.getClass());
                                        }
                                        boolean zzp = zzdaVar.zzp(next);
                                        zzdaVar = zzdaVar;
                                        if (!zzp) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzdy.zzp(t, zzai & 1048575);
                if (!list.isEmpty()) {
                    ?? zzaf = zzaf(i6);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        } else if (!zzaf.zzp(list.get(i11))) {
                            z = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zzb((zzco<T>) t, i6, i5, i2) && !zzb(t, zzai, zzaf(i6))) {
                return false;
            }
            i4++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0496  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzc(T r19, com.google.android.gms.internal.places.zzel r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzc(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzd(T t) {
        int i2;
        int i3 = this.zzlc;
        while (true) {
            i2 = this.zzld;
            if (i3 >= i2) {
                break;
            }
            long zzai = zzai(this.zzlb[i3]) & 1048575;
            Object zzp = zzdy.zzp(t, zzai);
            if (zzp != null) {
                zzdy.zzb(t, zzai, this.zzli.zzj(zzp));
            }
            i3++;
        }
        int length = this.zzlb.length;
        while (i2 < length) {
            this.zzlf.zzb(t, this.zzlb[i2]);
            i2++;
        }
        this.zzlg.zzd(t);
        if (this.zzkx) {
            this.zzlh.zzd(t);
        }
    }

    private final boolean zzd(T t, T t2, int i2) {
        return zzb((zzco<T>) t, i2) == zzb((zzco<T>) t2, i2);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzb(T t, T t2, int i2) {
        long zzai = zzai(i2) & 1048575;
        if (zzb((zzco<T>) t2, i2)) {
            Object zzp = zzdy.zzp(t, zzai);
            Object zzp2 = zzdy.zzp(t2, zzai);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb(t, zzai, zzbd.zzb(zzp, zzp2));
                zzc((zzco<T>) t, i2);
            } else if (zzp2 != null) {
                zzdy.zzb(t, zzai, zzp2);
                zzc((zzco<T>) t, i2);
            }
        }
    }

    private static <UT, UB> int zzb(zzds<UT, UB> zzdsVar, T t) {
        return zzdsVar.zzn(zzdsVar.zzr(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(T r14, com.google.android.gms.internal.places.zzel r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    private final void zzc(T t, int i2) {
        if (this.zzkz) {
            return;
        }
        int zzaj = zzaj(i2);
        long j2 = zzaj & 1048575;
        zzdy.zzb((Object) t, j2, zzdy.zzk(t, j2) | (1 << (zzaj >>> 20)));
    }

    private final void zzc(T t, int i2, int i3) {
        zzdy.zzb((Object) t, zzaj(i3) & 1048575, i2);
    }

    private final <K, V> void zzb(zzel zzelVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            zzelVar.zzb(i2, this.zzli.zzl(zzag(i3)), this.zzli.zzh(obj));
        }
    }

    private static <UT, UB> void zzb(zzds<UT, UB> zzdsVar, T t, zzel zzelVar) throws IOException {
        zzdsVar.zzb(zzdsVar.zzr(t), zzelVar);
    }

    private static int zzb(byte[] bArr, int i2, int i3, zzef zzefVar, Class<?> cls, zzr zzrVar) throws IOException {
        switch (zzcn.zzfi[zzefVar.ordinal()]) {
            case 1:
                int zzc = zzs.zzc(bArr, i2, zzrVar);
                zzrVar.zzeb = Boolean.valueOf(zzrVar.zzea != 0);
                return zzc;
            case 2:
                return zzs.zzf(bArr, i2, zzrVar);
            case 3:
                zzrVar.zzeb = Double.valueOf(zzs.zzd(bArr, i2));
                return i2 + 8;
            case 4:
            case 5:
                zzrVar.zzeb = Integer.valueOf(zzs.zzb(bArr, i2));
                return i2 + 4;
            case 6:
            case 7:
                zzrVar.zzeb = Long.valueOf(zzs.zzc(bArr, i2));
                return i2 + 8;
            case 8:
                zzrVar.zzeb = Float.valueOf(zzs.zze(bArr, i2));
                return i2 + 4;
            case 9:
            case 10:
            case 11:
                int zzb = zzs.zzb(bArr, i2, zzrVar);
                zzrVar.zzeb = Integer.valueOf(zzrVar.zzdz);
                return zzb;
            case 12:
            case 13:
                int zzc2 = zzs.zzc(bArr, i2, zzrVar);
                zzrVar.zzeb = Long.valueOf(zzrVar.zzea);
                return zzc2;
            case 14:
                return zzs.zzb(zzcv.zzcq().zzf(cls), bArr, i2, i3, zzrVar);
            case 15:
                int zzb2 = zzs.zzb(bArr, i2, zzrVar);
                zzrVar.zzeb = Integer.valueOf(zzai.zzm(zzrVar.zzdz));
                return zzb2;
            case 16:
                int zzc3 = zzs.zzc(bArr, i2, zzrVar);
                zzrVar.zzeb = Long.valueOf(zzai.zzb(zzrVar.zzea));
                return zzc3;
            case 17:
                return zzs.zze(bArr, i2, zzrVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0233 -> B:116:0x0234). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x016b -> B:67:0x016c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01e5 -> B:96:0x01e6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzb(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.places.zzr r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zzb(T t, byte[] bArr, int i2, int i3, int i4, long j2, zzr zzrVar) throws IOException {
        Unsafe unsafe = zzkr;
        Object zzag = zzag(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.zzli.zzi(object)) {
            Object zzk = this.zzli.zzk(zzag);
            this.zzli.zzc(zzk, object);
            unsafe.putObject(t, j2, zzk);
            object = zzk;
        }
        zzcb<?, ?> zzl = this.zzli.zzl(zzag);
        Map<?, ?> zzg = this.zzli.zzg(object);
        int zzb = zzs.zzb(bArr, i2, zzrVar);
        int i5 = zzrVar.zzdz;
        if (i5 >= 0 && i5 <= i3 - zzb) {
            int i6 = i5 + zzb;
            Object obj = (K) zzl.zzkk;
            Object obj2 = (V) zzl.zzkm;
            while (zzb < i6) {
                int i7 = zzb + 1;
                int i8 = bArr[zzb];
                if (i8 < 0) {
                    i7 = zzs.zzb(i8, bArr, i7, zzrVar);
                    i8 = zzrVar.zzdz;
                }
                int i9 = i7;
                int i10 = i8 >>> 3;
                int i11 = i8 & 7;
                if (i10 != 1) {
                    if (i10 == 2 && i11 == zzl.zzkl.zzds()) {
                        zzb = zzb(bArr, i9, i3, zzl.zzkl, zzl.zzkm.getClass(), zzrVar);
                        obj2 = zzrVar.zzeb;
                    }
                    zzb = zzs.zzb(i8, bArr, i9, i3, zzrVar);
                } else if (i11 == zzl.zzkj.zzds()) {
                    zzb = zzb(bArr, i9, i3, zzl.zzkj, (Class<?>) null, zzrVar);
                    obj = (K) zzrVar.zzeb;
                } else {
                    zzb = zzs.zzb(i8, bArr, i9, i3, zzrVar);
                }
            }
            if (zzb == i6) {
                zzg.put(obj, obj2);
                return i6;
            }
            throw zzbk.zzbt();
        }
        throw zzbk.zzbp();
    }

    private final int zzb(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzr zzrVar) throws IOException {
        int zzc;
        Unsafe unsafe = zzkr;
        long j3 = this.zzks[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(zzs.zzd(bArr, i2)));
                    zzc = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(zzs.zze(bArr, i2)));
                    zzc = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    zzc = zzs.zzc(bArr, i2, zzrVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzrVar.zzea));
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    zzc = zzs.zzb(bArr, i2, zzrVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzrVar.zzdz));
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(zzs.zzc(bArr, i2)));
                    zzc = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(zzs.zzb(bArr, i2)));
                    zzc = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    zzc = zzs.zzc(bArr, i2, zzrVar);
                    unsafe.putObject(t, j2, Boolean.valueOf(zzrVar.zzea != 0));
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int zzb = zzs.zzb(bArr, i2, zzrVar);
                    int i10 = zzrVar.zzdz;
                    if (i10 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & 536870912) != 0 && !zzea.zzf(bArr, zzb, zzb + i10)) {
                        throw zzbk.zzbu();
                    } else {
                        unsafe.putObject(t, j2, new String(bArr, zzb, i10, zzbd.UTF_8));
                        zzb += i10;
                    }
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int zzb2 = zzs.zzb(zzaf(i9), bArr, i2, i3, zzrVar);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, zzrVar.zzeb);
                    } else {
                        unsafe.putObject(t, j2, zzbd.zzb(object, zzrVar.zzeb));
                    }
                    unsafe.putInt(t, j3, i5);
                    return zzb2;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    zzc = zzs.zzf(bArr, i2, zzrVar);
                    unsafe.putObject(t, j2, zzrVar.zzeb);
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int zzb3 = zzs.zzb(bArr, i2, zzrVar);
                    int i11 = zzrVar.zzdz;
                    zzbf zzah = zzah(i9);
                    if (zzah != null && !zzah.zzad(i11)) {
                        zzo(t).zzc(i4, Long.valueOf(i11));
                        return zzb3;
                    }
                    unsafe.putObject(t, j2, Integer.valueOf(i11));
                    zzc = zzb3;
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    zzc = zzs.zzb(bArr, i2, zzrVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzai.zzm(zzrVar.zzdz)));
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    zzc = zzs.zzc(bArr, i2, zzrVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzai.zzb(zzrVar.zzea)));
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    zzc = zzs.zzb(zzaf(i9), bArr, i2, i3, (i4 & (-8)) | 4, zzrVar);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, zzrVar.zzeb);
                    } else {
                        unsafe.putObject(t, j2, zzbd.zzb(object2, zzrVar.zzeb));
                    }
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(T t, byte[] bArr, int i2, int i3, int i4, zzr zzrVar) throws IOException {
        Unsafe unsafe;
        int i5;
        T t2;
        zzco<T> zzcoVar;
        int i6;
        int i7;
        int i8;
        int i9;
        zzbf zzah;
        byte b;
        int i10;
        int zzak;
        int i11;
        int i12;
        int i13;
        T t3;
        zzr zzrVar2;
        int i14;
        int i15;
        int i16;
        zzr zzrVar3;
        int i17;
        zzr zzrVar4;
        int i18;
        int i19;
        zzr zzrVar5;
        int i20;
        int i21;
        int i22;
        zzco<T> zzcoVar2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i23 = i3;
        int i24 = i4;
        zzr zzrVar6 = zzrVar;
        Unsafe unsafe2 = zzkr;
        int i25 = i2;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = -1;
        while (true) {
            if (i25 < i23) {
                int i31 = i25 + 1;
                byte b2 = bArr2[i25];
                if (b2 < 0) {
                    i10 = zzs.zzb(b2, bArr2, i31, zzrVar6);
                    b = zzrVar6.zzdz;
                } else {
                    b = b2;
                    i10 = i31;
                }
                int i32 = b >>> 3;
                int i33 = b & 7;
                if (i32 > i26) {
                    zzak = zzcoVar2.zzq(i32, i27 / 3);
                } else {
                    zzak = zzcoVar2.zzak(i32);
                }
                int i34 = zzak;
                if (i34 == -1) {
                    i11 = i32;
                    i12 = i10;
                    i7 = b;
                    unsafe = unsafe2;
                    i5 = i24;
                    i13 = 0;
                } else {
                    int[] iArr = zzcoVar2.zzks;
                    int i35 = iArr[i34 + 1];
                    int i36 = (i35 & 267386880) >>> 20;
                    int i37 = b;
                    long j2 = i35 & 1048575;
                    if (i36 <= 17) {
                        int i38 = iArr[i34 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i30) {
                            if (i30 != -1) {
                                unsafe2.putInt(t4, i30, i29);
                            }
                            i29 = unsafe2.getInt(t4, i40);
                            i30 = i40;
                        }
                        switch (i36) {
                            case 0:
                                i14 = i34;
                                i15 = i32;
                                i17 = i30;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                i18 = i10;
                                if (i33 == 1) {
                                    zzdy.zzb(t4, j2, zzs.zzd(bArr2, i18));
                                    i25 = i18 + 8;
                                    i29 |= i39;
                                    i30 = i17;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 1:
                                i14 = i34;
                                i15 = i32;
                                i17 = i30;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                i18 = i10;
                                if (i33 == 5) {
                                    zzdy.zzb((Object) t4, j2, zzs.zze(bArr2, i18));
                                    i25 = i18 + 4;
                                    i29 |= i39;
                                    i30 = i17;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 2:
                            case 3:
                                i14 = i34;
                                i15 = i32;
                                i17 = i30;
                                i16 = i37;
                                bArr2 = bArr;
                                i18 = i10;
                                if (i33 == 0) {
                                    int zzc = zzs.zzc(bArr2, i18, zzrVar);
                                    unsafe2.putLong(t, j2, zzrVar.zzea);
                                    i29 |= i39;
                                    i25 = zzc;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar;
                                    i30 = i17;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 4:
                            case 11:
                                i14 = i34;
                                i15 = i32;
                                i17 = i30;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                i18 = i10;
                                if (i33 == 0) {
                                    i25 = zzs.zzb(bArr2, i18, zzrVar4);
                                    unsafe2.putInt(t4, j2, zzrVar4.zzdz);
                                    i29 |= i39;
                                    i30 = i17;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 5:
                            case 14:
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i33 == 1) {
                                    i17 = i30;
                                    i18 = i10;
                                    unsafe2.putLong(t, j2, zzs.zzc(bArr2, i10));
                                    i25 = i18 + 8;
                                    i29 |= i39;
                                    i30 = i17;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 6:
                            case 13:
                                i19 = i3;
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i33 == 5) {
                                    unsafe2.putInt(t4, j2, zzs.zzb(bArr2, i10));
                                    i25 = i10 + 4;
                                    i29 |= i39;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar5;
                                    i24 = i4;
                                    i23 = i19;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 7:
                                i19 = i3;
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i33 == 0) {
                                    int zzc2 = zzs.zzc(bArr2, i10, zzrVar5);
                                    zzdy.zzb(t4, j2, zzrVar5.zzea != 0);
                                    i29 |= i39;
                                    i25 = zzc2;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar5;
                                    i24 = i4;
                                    i23 = i19;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 8:
                                i19 = i3;
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i33 == 2) {
                                    if ((i35 & 536870912) == 0) {
                                        i25 = zzs.zzd(bArr2, i10, zzrVar5);
                                    } else {
                                        i25 = zzs.zze(bArr2, i10, zzrVar5);
                                    }
                                    unsafe2.putObject(t4, j2, zzrVar5.zzeb);
                                    i29 |= i39;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar5;
                                    i24 = i4;
                                    i23 = i19;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 9:
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar5 = zzrVar;
                                if (i33 == 2) {
                                    i19 = i3;
                                    i25 = zzs.zzb(zzcoVar2.zzaf(i14), bArr2, i10, i19, zzrVar5);
                                    if ((i29 & i39) == 0) {
                                        unsafe2.putObject(t4, j2, zzrVar5.zzeb);
                                    } else {
                                        unsafe2.putObject(t4, j2, zzbd.zzb(unsafe2.getObject(t4, j2), zzrVar5.zzeb));
                                    }
                                    i29 |= i39;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar5;
                                    i24 = i4;
                                    i23 = i19;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 10:
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i33 == 2) {
                                    i25 = zzs.zzf(bArr2, i10, zzrVar4);
                                    unsafe2.putObject(t4, j2, zzrVar4.zzeb);
                                    i29 |= i39;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 12:
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i33 == 0) {
                                    i25 = zzs.zzb(bArr2, i10, zzrVar4);
                                    int i41 = zzrVar4.zzdz;
                                    zzbf zzah2 = zzcoVar2.zzah(i14);
                                    if (zzah2 != null && !zzah2.zzad(i41)) {
                                        zzo(t).zzc(i16, Long.valueOf(i41));
                                        i28 = i16;
                                        i27 = i14;
                                        i26 = i15;
                                        zzrVar6 = zzrVar4;
                                        i23 = i3;
                                        i24 = i4;
                                    } else {
                                        unsafe2.putInt(t4, j2, i41);
                                        i29 |= i39;
                                        i28 = i16;
                                        i27 = i14;
                                        i26 = i15;
                                        zzrVar6 = zzrVar4;
                                        i23 = i3;
                                        i24 = i4;
                                        break;
                                    }
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                                break;
                            case 15:
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                bArr2 = bArr;
                                zzrVar4 = zzrVar;
                                if (i33 == 0) {
                                    i25 = zzs.zzb(bArr2, i10, zzrVar4);
                                    unsafe2.putInt(t4, j2, zzai.zzm(zzrVar4.zzdz));
                                    i29 |= i39;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 16:
                                i14 = i34;
                                i15 = i32;
                                i16 = i37;
                                if (i33 == 0) {
                                    bArr2 = bArr;
                                    int zzc3 = zzs.zzc(bArr2, i10, zzrVar);
                                    zzrVar4 = zzrVar;
                                    unsafe2.putLong(t, j2, zzai.zzb(zzrVar.zzea));
                                    i29 |= i39;
                                    i25 = zzc3;
                                    i28 = i16;
                                    i27 = i14;
                                    i26 = i15;
                                    zzrVar6 = zzrVar4;
                                    i23 = i3;
                                    i24 = i4;
                                    break;
                                } else {
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            case 17:
                                if (i33 == 3) {
                                    i25 = zzs.zzb(zzcoVar2.zzaf(i34), bArr, i10, i3, (i32 << 3) | 4, zzrVar);
                                    if ((i29 & i39) == 0) {
                                        zzrVar3 = zzrVar;
                                        unsafe2.putObject(t4, j2, zzrVar3.zzeb);
                                    } else {
                                        zzrVar3 = zzrVar;
                                        unsafe2.putObject(t4, j2, zzbd.zzb(unsafe2.getObject(t4, j2), zzrVar3.zzeb));
                                    }
                                    i29 |= i39;
                                    bArr2 = bArr;
                                    i23 = i3;
                                    i28 = i37;
                                    i27 = i34;
                                    i26 = i32;
                                    i24 = i4;
                                    zzrVar6 = zzrVar3;
                                    break;
                                } else {
                                    i14 = i34;
                                    i15 = i32;
                                    i16 = i37;
                                    i17 = i30;
                                    i18 = i10;
                                    i12 = i18;
                                    i13 = i14;
                                    unsafe = unsafe2;
                                    i11 = i15;
                                    i30 = i17;
                                    i7 = i16;
                                    i5 = i4;
                                    break;
                                }
                            default:
                                i14 = i34;
                                i15 = i32;
                                i17 = i30;
                                i16 = i37;
                                i18 = i10;
                                i12 = i18;
                                i13 = i14;
                                unsafe = unsafe2;
                                i11 = i15;
                                i30 = i17;
                                i7 = i16;
                                i5 = i4;
                                break;
                        }
                    } else {
                        int i42 = i30;
                        int i43 = i10;
                        bArr2 = bArr;
                        zzr zzrVar7 = zzrVar6;
                        if (i36 != 27) {
                            i20 = i29;
                            if (i36 <= 49) {
                                i11 = i32;
                                i22 = i37;
                                i13 = i34;
                                unsafe = unsafe2;
                                i25 = zzb((zzco<T>) t, bArr, i43, i3, i37, i32, i33, i34, i35, i36, j2, zzrVar);
                                if (i25 == i43) {
                                    i5 = i4;
                                    i12 = i25;
                                } else {
                                    zzcoVar2 = this;
                                    t4 = t;
                                    bArr2 = bArr;
                                    i23 = i3;
                                    i24 = i4;
                                    zzrVar6 = zzrVar;
                                    i30 = i42;
                                    i27 = i13;
                                    i29 = i20;
                                    i26 = i11;
                                    i28 = i22;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                i11 = i32;
                                i21 = i43;
                                i22 = i37;
                                i13 = i34;
                                unsafe = unsafe2;
                                if (i36 != 50) {
                                    i25 = zzb((zzco<T>) t, bArr, i21, i3, i22, i11, i33, i35, i36, j2, i13, zzrVar);
                                    if (i25 != i21) {
                                        zzcoVar2 = this;
                                        t4 = t;
                                        i23 = i3;
                                        i24 = i4;
                                        i28 = i22;
                                        i26 = i11;
                                        i30 = i42;
                                        i27 = i13;
                                        i29 = i20;
                                        unsafe2 = unsafe;
                                        bArr2 = bArr;
                                        zzrVar6 = zzrVar;
                                    }
                                } else if (i33 == 2) {
                                    i25 = zzb((zzco<T>) t, bArr, i21, i3, i13, j2, zzrVar);
                                    if (i25 != i21) {
                                        zzcoVar2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i23 = i3;
                                        i24 = i4;
                                        zzrVar6 = zzrVar;
                                        i30 = i42;
                                        i27 = i13;
                                        i29 = i20;
                                        i26 = i11;
                                        i28 = i22;
                                        unsafe2 = unsafe;
                                    }
                                } else {
                                    i5 = i4;
                                    i12 = i21;
                                }
                                i5 = i4;
                                i12 = i25;
                            }
                        } else if (i33 == 2) {
                            zzbh zzbhVar = (zzbh) unsafe2.getObject(t4, j2);
                            if (!zzbhVar.zzaa()) {
                                int size = zzbhVar.size();
                                zzbhVar = zzbhVar.zzh(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j2, zzbhVar);
                            }
                            i25 = zzs.zzb(zzcoVar2.zzaf(i34), i37, bArr, i43, i3, zzbhVar, zzrVar);
                            i24 = i4;
                            i26 = i32;
                            i28 = i37;
                            i27 = i34;
                            zzrVar6 = zzrVar7;
                            i30 = i42;
                            i29 = i29;
                            i23 = i3;
                        } else {
                            i20 = i29;
                            i11 = i32;
                            i21 = i43;
                            i22 = i37;
                            i13 = i34;
                            unsafe = unsafe2;
                            i5 = i4;
                            i12 = i21;
                        }
                        i30 = i42;
                        i29 = i20;
                        i7 = i22;
                    }
                }
                if (i7 != i5 || i5 == 0) {
                    if (this.zzkx) {
                        zzrVar2 = zzrVar;
                        if (zzrVar2.zzec != zzap.zzao()) {
                            int i44 = i11;
                            if (zzrVar2.zzec.zzb(this.zzkw, i44) == null) {
                                i25 = zzs.zzb(i7, bArr, i12, i3, zzo(t), zzrVar);
                                t4 = t;
                                i23 = i3;
                                i28 = i7;
                                zzcoVar2 = this;
                                zzrVar6 = zzrVar2;
                                i26 = i44;
                                i27 = i13;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i24 = i5;
                            } else {
                                zzbc.zzc zzcVar = (zzbc.zzc) t;
                                zzcVar.zzbm();
                                zzav<Object> zzavVar = zzcVar.zzik;
                                throw new NoSuchMethodError();
                            }
                        } else {
                            t3 = t;
                        }
                    } else {
                        t3 = t;
                        zzrVar2 = zzrVar;
                    }
                    i25 = zzs.zzb(i7, bArr, i12, i3, zzo(t), zzrVar);
                    i28 = i7;
                    zzcoVar2 = this;
                    zzrVar6 = zzrVar2;
                    i26 = i11;
                    t4 = t3;
                    i27 = i13;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i23 = i3;
                    i24 = i5;
                } else {
                    zzcoVar = this;
                    t2 = t;
                    i8 = i30;
                    i9 = -1;
                    i6 = i12;
                }
            } else {
                int i45 = i30;
                unsafe = unsafe2;
                i5 = i24;
                t2 = t4;
                zzcoVar = zzcoVar2;
                i6 = i25;
                i7 = i28;
                i8 = i45;
                i9 = -1;
            }
        }
        if (i8 != i9) {
            unsafe.putInt(t2, i8, i29);
        }
        Object obj = null;
        for (int i46 = zzcoVar.zzlc; i46 < zzcoVar.zzld; i46++) {
            int i47 = zzcoVar.zzlb[i46];
            zzds zzdsVar = zzcoVar.zzlg;
            int i48 = zzcoVar.zzks[i47];
            Object zzp = zzdy.zzp(t2, zzcoVar.zzai(i47) & 1048575);
            if (zzp != null && (zzah = zzcoVar.zzah(i47)) != null) {
                obj = zzb(i47, i48, zzcoVar.zzli.zzg(zzp), zzah, (zzbf) obj, (zzds<UT, zzbf>) zzdsVar);
            }
            obj = (zzdr) obj;
        }
        if (obj != null) {
            zzcoVar.zzlg.zzg(t2, obj);
        }
        if (i5 == 0) {
            if (i6 != i3) {
                throw zzbk.zzbt();
            }
        } else if (i6 > i3 || i7 != i5) {
            throw zzbk.zzbt();
        }
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x022e, code lost:
        if (r0 == r15) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0230, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e2, code lost:
        if (r0 == r15) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x020f, code lost:
        if (r0 == r15) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.places.zzr r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, com.google.android.gms.internal.places.zzr):void");
    }

    private final <K, V, UT, UB> UB zzb(int i2, int i3, Map<K, V> map, zzbf zzbfVar, UB ub, zzds<UT, UB> zzdsVar) {
        zzcb<?, ?> zzl = this.zzli.zzl(zzag(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzbfVar.zzad(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzdsVar.zzdk();
                }
                zzae zzk = zzw.zzk(zzcc.zzb(zzl, next.getKey(), next.getValue()));
                try {
                    zzcc.zzb(zzk.zzai(), zzl, next.getKey(), next.getValue());
                    zzdsVar.zzb((zzds<UT, UB>) ub, i3, zzk.zzah());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzb(Object obj, int i2, zzda zzdaVar) {
        return zzdaVar.zzp(zzdy.zzp(obj, i2 & 1048575));
    }

    private static void zzb(int i2, Object obj, zzel zzelVar) throws IOException {
        if (obj instanceof String) {
            zzelVar.zzb(i2, (String) obj);
        } else {
            zzelVar.zzb(i2, (zzw) obj);
        }
    }

    private final boolean zzb(T t, int i2, int i3, int i4) {
        if (this.zzkz) {
            return zzb((zzco<T>) t, i2);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzb(T t, int i2) {
        if (this.zzkz) {
            int zzai = zzai(i2);
            long j2 = zzai & 1048575;
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    return zzdy.zzo(t, j2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return zzdy.zzn(t, j2) != 0.0f;
                case 2:
                    return zzdy.zzl(t, j2) != 0;
                case 3:
                    return zzdy.zzl(t, j2) != 0;
                case 4:
                    return zzdy.zzk(t, j2) != 0;
                case 5:
                    return zzdy.zzl(t, j2) != 0;
                case 6:
                    return zzdy.zzk(t, j2) != 0;
                case 7:
                    return zzdy.zzm(t, j2);
                case 8:
                    Object zzp = zzdy.zzp(t, j2);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    } else if (zzp instanceof zzw) {
                        return !zzw.zzeg.equals(zzp);
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    return zzdy.zzp(t, j2) != null;
                case 10:
                    return !zzw.zzeg.equals(zzdy.zzp(t, j2));
                case 11:
                    return zzdy.zzk(t, j2) != 0;
                case 12:
                    return zzdy.zzk(t, j2) != 0;
                case 13:
                    return zzdy.zzk(t, j2) != 0;
                case 14:
                    return zzdy.zzl(t, j2) != 0;
                case 15:
                    return zzdy.zzk(t, j2) != 0;
                case 16:
                    return zzdy.zzl(t, j2) != 0;
                case 17:
                    return zzdy.zzp(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int zzaj = zzaj(i2);
        return (zzdy.zzk(t, (long) (zzaj & 1048575)) & (1 << (zzaj >>> 20))) != 0;
    }

    private final boolean zzb(T t, int i2, int i3) {
        return zzdy.zzk(t, (long) (zzaj(i3) & 1048575)) == i2;
    }
}
