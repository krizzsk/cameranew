package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
/* compiled from: TestHelperUtils.java */
/* loaded from: classes.dex */
public class aa {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087 A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #7 {Exception -> 0x0083, blocks: (B:41:0x007f, B:45:0x0087), top: B:54:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.FileReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "com.union_test.internationad"
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.lang.String r5 = "data/data/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            r4.append(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            r4.append(r7)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            boolean r7 = r3.exists()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            if (r7 != 0) goto L2d
            return r1
        L2d:
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
        L37:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L7b
            if (r1 == 0) goto L41
            r0.append(r1)     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L7b
            goto L37
        L41:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L51 java.lang.Throwable -> L7b
            r7.close()     // Catch: java.lang.Exception -> L4c
            r2.close()     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r7 = move-exception
            r7.printStackTrace()
        L50:
            return r0
        L51:
            r1 = move-exception
            goto L62
        L53:
            r0 = move-exception
            r2 = r1
            goto L7c
        L56:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L62
        L5b:
            r0 = move-exception
            r2 = r1
            goto L7d
        L5e:
            r7 = move-exception
            r2 = r1
            r1 = r7
            r7 = r2
        L62:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            if (r7 == 0) goto L6d
            r7.close()     // Catch: java.lang.Exception -> L6b
            goto L6d
        L6b:
            r7 = move-exception
            goto L73
        L6d:
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.lang.Exception -> L6b
            goto L76
        L73:
            r7.printStackTrace()
        L76:
            java.lang.String r7 = r0.toString()
            return r7
        L7b:
            r0 = move-exception
        L7c:
            r1 = r7
        L7d:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.lang.Exception -> L83
            goto L85
        L83:
            r7 = move-exception
            goto L8b
        L85:
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.lang.Exception -> L83
            goto L8e
        L8b:
            r7.printStackTrace()
        L8e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.aa.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        return "5001121".equals(com.bytedance.sdk.openadsdk.core.h.b().c()) && "com.union_test.internationad".equals(ab.f()) && o.c();
    }

    public static String a(String str, String str2) {
        if (str.contains("https://pangolin.snssdk.com")) {
            return str.replace("https://pangolin.snssdk.com", str2);
        }
        if (str.contains("https://is.snssdk.com")) {
            return str.replace("https://is.snssdk.com", str2);
        }
        return str.contains("https://pangolin16.snssdk.com") ? str.replace("https://pangolin16.snssdk.com", str2) : str;
    }
}
