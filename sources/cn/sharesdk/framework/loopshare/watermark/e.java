package cn.sharesdk.framework.loopshare.watermark;

import android.os.Build;
import android.text.TextUtils;
/* compiled from: Rom.java */
/* loaded from: classes.dex */
public class e {
    private static String a;
    private static String b;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean b() {
        return a("VIVO");
    }

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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r9) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.append(r9)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r1 = r2.readLine()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L6e
            r2.close()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L6e
            r2.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r9 = move-exception
            r9.printStackTrace()
        L39:
            return r1
        L3a:
            r1 = move-exception
            goto L40
        L3c:
            r9 = move-exception
            goto L70
        L3e:
            r1 = move-exception
            r2 = r0
        L40:
            com.mob.tools.log.NLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r4 = "ShareSDK"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L6e
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r7.<init>()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = "Unable to read prop "
            r7.append(r8)     // Catch: java.lang.Throwable -> L6e
            r7.append(r9)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r9 = r7.toString()     // Catch: java.lang.Throwable -> L6e
            r5[r6] = r9     // Catch: java.lang.Throwable -> L6e
            r9 = 1
            r5[r9] = r1     // Catch: java.lang.Throwable -> L6e
            r3.e(r4, r5)     // Catch: java.lang.Throwable -> L6e
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L69
            goto L6d
        L69:
            r9 = move-exception
            r9.printStackTrace()
        L6d:
            return r0
        L6e:
            r9 = move-exception
            r0 = r2
        L70:
            if (r0 == 0) goto L7a
            r0.close()     // Catch: java.io.IOException -> L76
            goto L7a
        L76:
            r0 = move-exception
            r0.printStackTrace()
        L7a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.loopshare.watermark.e.b(java.lang.String):java.lang.String");
    }
}
