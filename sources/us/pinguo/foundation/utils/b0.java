package us.pinguo.foundation.utils;

import android.os.Build;
import android.text.TextUtils;
/* compiled from: RomUtils.java */
/* loaded from: classes4.dex */
public class b0 {
    private static String a;
    private static String b;

    public static boolean a(String str) {
        String str2 = a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String b2 = b("ro.miui.ui.version.name");
        b = b2;
        if (!TextUtils.isEmpty(b2)) {
            a = "MIUI";
        } else {
            String b3 = b("ro.build.version.emui");
            b = b3;
            if (!TextUtils.isEmpty(b3)) {
                a = "EMUI";
            } else {
                String b4 = b("ro.build.version.opporom");
                b = b4;
                if (!TextUtils.isEmpty(b4)) {
                    a = "OPPO";
                } else {
                    String b5 = b("ro.vivo.os.version");
                    b = b5;
                    if (!TextUtils.isEmpty(b5)) {
                        a = "VIVO";
                    } else {
                        String b6 = b("ro.smartisan.version");
                        b = b6;
                        if (!TextUtils.isEmpty(b6)) {
                            a = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            b = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                a = "FLYME";
                            } else {
                                b = "unknown";
                                a = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return a.equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r8) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.append(r8)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r1 = r2.readLine()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L6a
            r2.close()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L6a
            r2.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r8 = move-exception
            r8.printStackTrace()
        L39:
            return r1
        L3a:
            r1 = move-exception
            goto L40
        L3c:
            r8 = move-exception
            goto L6c
        L3e:
            r1 = move-exception
            r2 = r0
        L40:
            java.lang.String r3 = "Rom"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L6a
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r6.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r7 = "Unable to read prop "
            r6.append(r7)     // Catch: java.lang.Throwable -> L6a
            r6.append(r8)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = r6.toString()     // Catch: java.lang.Throwable -> L6a
            r4[r5] = r8     // Catch: java.lang.Throwable -> L6a
            r8 = 1
            r4[r8] = r1     // Catch: java.lang.Throwable -> L6a
            us.pinguo.common.log.a.e(r3, r4)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L69
            r2.close()     // Catch: java.io.IOException -> L65
            goto L69
        L65:
            r8 = move-exception
            r8.printStackTrace()
        L69:
            return r0
        L6a:
            r8 = move-exception
            r0 = r2
        L6c:
            if (r0 == 0) goto L76
            r0.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r0 = move-exception
            r0.printStackTrace()
        L76:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.utils.b0.b(java.lang.String):java.lang.String");
    }

    public static boolean c() {
        return a("OPPO");
    }

    public static boolean d() {
        return a("VIVO");
    }
}
