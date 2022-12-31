package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzlz {
    private static final SparseIntArray zzbdb;
    private static final SparseIntArray zzbdc;
    private static final Map<String, Integer> zzbdd;
    private static final zzlw zzbcy = zzlw.zzay("OMX.google.raw.decoder");
    private static final Pattern zzbcz = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzlw>> zzbda = new HashMap<>();
    private static int zzbde = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza {
        public final String mimeType;
        public final boolean zzbcs;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzbcs = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zzaVar = (zza) obj;
                if (TextUtils.equals(this.mimeType, zzaVar.mimeType) && this.zzbcs == zzaVar.zzbcs) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzbcs ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzbdb = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzbdc = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzbdd = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0126, code lost:
        if ("C1605".equals(r14) == false) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0182 A[Catch: Exception -> 0x027c, TryCatch #1 {Exception -> 0x027c, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:29:0x006c, B:33:0x0078, B:35:0x0080, B:40:0x0090, B:42:0x0098, B:44:0x00a2, B:46:0x00aa, B:48:0x00b2, B:50:0x00ba, B:52:0x00c2, B:54:0x00ca, B:56:0x00d2, B:58:0x00da, B:60:0x00e2, B:62:0x00ea, B:64:0x00f2, B:68:0x00fe, B:70:0x0106, B:72:0x0110, B:74:0x0118, B:76:0x0120, B:81:0x012f, B:83:0x0137, B:85:0x0141, B:87:0x014b, B:89:0x0153, B:91:0x0159, B:93:0x0161, B:97:0x016c, B:99:0x0174, B:105:0x0182, B:107:0x018a, B:147:0x0200, B:150:0x0208, B:152:0x020e, B:153:0x0232, B:154:0x0266), top: B:164:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cb A[Catch: Exception -> 0x01c6, TryCatch #3 {Exception -> 0x01c6, blocks: (B:112:0x01a2, B:114:0x01ac, B:116:0x01b4, B:118:0x01bc, B:125:0x01cb, B:133:0x01d9, B:130:0x01d4, B:137:0x01e7), top: B:168:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0271 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzlw> zza(com.google.android.gms.internal.ads.zzlz.zza r17, com.google.android.gms.internal.ads.zzmc r18) throws com.google.android.gms.internal.ads.zzmd {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlz.zza(com.google.android.gms.internal.ads.zzlz$zza, com.google.android.gms.internal.ads.zzmc):java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r3.equals(com.coremedia.iso.boxes.sampleentry.VisualSampleEntry.TYPE3) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbb(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlz.zzbb(java.lang.String):android.util.Pair");
    }

    public static zzlw zzc(String str, boolean z) throws zzmd {
        List<zzlw> zzd = zzd(str, z);
        if (zzd.isEmpty()) {
            return null;
        }
        return zzd.get(0);
    }

    private static synchronized List<zzlw> zzd(String str, boolean z) throws zzmd {
        synchronized (zzlz.class) {
            zza zzaVar = new zza(str, z);
            HashMap<zza, List<zzlw>> hashMap = zzbda;
            List<zzlw> list = hashMap.get(zzaVar);
            if (list != null) {
                return list;
            }
            int i2 = zzpt.SDK_INT;
            List<zzlw> zza2 = zza(zzaVar, i2 >= 21 ? new zzme(z) : new zzmf());
            if (z && zza2.isEmpty() && 21 <= i2 && i2 <= 23) {
                zza2 = zza(zzaVar, new zzmf());
                if (!zza2.isEmpty()) {
                    String str2 = zza2.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzlw> unmodifiableList = Collections.unmodifiableList(zza2);
            hashMap.put(zzaVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static zzlw zzhj() {
        return zzbcy;
    }

    public static int zzhk() throws zzmd {
        if (zzbde == -1) {
            int i2 = 0;
            zzlw zzc = zzc("video/avc", false);
            if (zzc != null) {
                MediaCodecInfo.CodecProfileLevel[] zzhi = zzc.zzhi();
                int length = zzhi.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzhi[i2].level;
                    int i5 = 9437184;
                    if (i4 == 1 || i4 == 2) {
                        i5 = 25344;
                    } else {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i5 = 101376;
                                continue;
                            case 64:
                                i5 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i5 = 414720;
                                continue;
                            case 512:
                                i5 = 921600;
                                continue;
                            case 1024:
                                i5 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i5 = 2097152;
                                continue;
                            case 8192:
                                i5 = 2228224;
                                continue;
                            case 16384:
                                i5 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i5 = -1;
                                continue;
                        }
                    }
                    i3 = Math.max(i5, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzpt.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzbde = i2;
        }
        return zzbde;
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            String valueOf2 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf3;
            } else {
                String valueOf4 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf4) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf5 = Integer.valueOf(zzbdb.get(num.intValue()));
            if (valueOf5 == null) {
                String valueOf6 = String.valueOf(num);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf6).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf6);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf7 = Integer.valueOf(zzbdc.get(valueOf.intValue()));
            if (valueOf7 == null) {
                String valueOf8 = String.valueOf(valueOf);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf8).length() + 19);
                sb2.append("Unknown AVC level: ");
                sb2.append(valueOf8);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(valueOf5, valueOf7);
        } catch (NumberFormatException unused) {
            String valueOf9 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf9) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }
}
