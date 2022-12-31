package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzemp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzemo zzemoVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzemoVar, sb, 0);
        return sb.toString();
    }

    private static final String zzib(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01f1, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01f3, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0204, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0215, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0227, code lost:
        if (((java.lang.Double) r6).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.ads.zzemo r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemp.zza(com.google.android.gms.internal.ads.zzemo, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zza(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zza(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zza(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzenx.zzan(zzejr.zzhy((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzejr) {
                sb.append(": \"");
                sb.append(zzenx.zzan((zzejr) obj));
                sb.append('\"');
            } else if (obj instanceof zzelb) {
                sb.append(" {");
                zza((zzelb) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i2 + 2;
                zza(sb, i5, "key", entry2.getKey());
                zza(sb, i5, FirebaseAnalytics.Param.VALUE, entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }
}
