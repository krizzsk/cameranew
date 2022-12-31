package cn.sharesdk.framework.utils;

import android.os.Build;
import android.text.TextUtils;
/* compiled from: CheckRomAll.java */
/* loaded from: classes.dex */
public class b {
    private static String a;
    private static String b;

    public static boolean a() {
        return a("MIUI");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r8) {
        /*
            java.lang.String r0 = "CheckRomAll getProp finally catch "
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r4.<init>()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r4.append(r8)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L9a
            r4.close()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L9a
            r4.close()     // Catch: java.io.IOException -> L38
            goto L51
        L38:
            r8 = move-exception
            com.mob.tools.log.NLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r1.d(r8, r0)
        L51:
            return r3
        L52:
            r3 = move-exception
            goto L58
        L54:
            r8 = move-exception
            goto L9c
        L56:
            r3 = move-exception
            r4 = r1
        L58:
            com.mob.tools.log.NLog r5 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r6.<init>()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = "CheckRomAll unable to read prop "
            r6.append(r7)     // Catch: java.lang.Throwable -> L9a
            r6.append(r8)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r8 = " ex "
            r6.append(r8)     // Catch: java.lang.Throwable -> L9a
            r6.append(r3)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r8 = r6.toString()     // Catch: java.lang.Throwable -> L9a
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L9a
            r5.d(r8, r3)     // Catch: java.lang.Throwable -> L9a
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L80
            goto L99
        L80:
            r8 = move-exception
            com.mob.tools.log.NLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r3.d(r8, r0)
        L99:
            return r1
        L9a:
            r8 = move-exception
            r1 = r4
        L9c:
            if (r1 == 0) goto Lbb
            r1.close()     // Catch: java.io.IOException -> La2
            goto Lbb
        La2:
            r1 = move-exception
            com.mob.tools.log.NLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r3.d(r0, r1)
        Lbb:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.b.b(java.lang.String):java.lang.String");
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
}
