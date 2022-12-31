package com.pinguo.camera360.h;
/* compiled from: DownLoadTool.java */
/* loaded from: classes3.dex */
public class a {
    private static final String a = "a";

    /* JADX WARN: Removed duplicated region for block: B:32:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.lang.String r5, java.io.File r6, java.io.File r7) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            java.lang.String r3 = "download"
            java.lang.String r4 = ".tmp"
            java.io.File r7 = java.io.File.createTempFile(r3, r4, r7)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            java.net.URL r3 = new java.net.URL     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            r3.<init>(r5)     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            java.io.InputStream r1 = r3.openStream()     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            us.pinguo.util.k.j(r7, r1)     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            boolean r5 = r6.exists()     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            if (r5 == 0) goto L2c
            boolean r5 = r6.delete()     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            if (r5 != 0) goto L2c
            java.lang.String r5 = com.pinguo.camera360.h.a.a     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            java.lang.String r3 = "Delete file failed!"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            us.pinguo.common.log.a.g(r5, r3, r4)     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
        L2c:
            boolean r5 = r7.renameTo(r6)     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            if (r5 != 0) goto L3b
            java.lang.String r5 = com.pinguo.camera360.h.a.a     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            java.lang.String r6 = "Rename file failed!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
            us.pinguo.common.log.a.g(r5, r6, r3)     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L53
        L3b:
            java.io.Closeable[] r5 = new java.io.Closeable[r0]
            r5[r2] = r1
            us.pinguo.util.f.a(r5)
            return
        L43:
            r5 = move-exception
            goto L4a
        L45:
            r5 = move-exception
            r6 = r1
            goto L56
        L48:
            r5 = move-exception
            r7 = r1
        L4a:
            us.pinguo.common.log.a.f(r5)     // Catch: java.lang.Throwable -> L53
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L53
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L53
            throw r6     // Catch: java.lang.Throwable -> L53
        L53:
            r5 = move-exception
            r6 = r1
            r1 = r7
        L56:
            if (r1 == 0) goto L60
            r1.delete()     // Catch: java.lang.Exception -> L5c
            goto L60
        L5c:
            r7 = move-exception
            us.pinguo.common.log.a.f(r7)
        L60:
            java.io.Closeable[] r7 = new java.io.Closeable[r0]
            r7[r2] = r6
            us.pinguo.util.f.a(r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.h.a.a(java.lang.String, java.io.File, java.io.File):void");
    }
}
