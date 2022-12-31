package com.bytedance.sdk.openadsdk.core.g;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: SdkSwitch.java */
/* loaded from: classes.dex */
public class g {
    private static AtomicInteger a = new AtomicInteger(1);

    public static boolean a() {
        return a.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r3) {
        /*
            r0 = 1
            if (r3 == r0) goto L7
            r1 = 2
            if (r3 == r1) goto L7
            return
        L7:
            r1 = 0
            java.util.concurrent.atomic.AtomicInteger r2 = com.bytedance.sdk.openadsdk.core.g.g.a     // Catch: java.lang.Throwable -> L1a
            int r2 = r2.get()     // Catch: java.lang.Throwable -> L1a
            if (r2 == r3) goto L18
            java.util.concurrent.atomic.AtomicInteger r1 = com.bytedance.sdk.openadsdk.core.g.g.a     // Catch: java.lang.Throwable -> L16
            r1.set(r3)     // Catch: java.lang.Throwable -> L16
            goto L1f
        L16:
            r3 = move-exception
            goto L1c
        L18:
            r0 = 0
            goto L1f
        L1a:
            r3 = move-exception
            r0 = 0
        L1c:
            r3.printStackTrace()
        L1f:
            if (r0 == 0) goto L95
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "switch status changed: "
            r3.append(r0)
            boolean r0 = a()
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "SdkSwitch"
            android.util.Log.e(r0, r3)
            boolean r3 = a()
            if (r3 == 0) goto L45
            com.bytedance.sdk.openadsdk.core.o.b()
            goto L95
        L45:
            com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.o.c()     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L52
            com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.o.c()     // Catch: java.lang.Throwable -> L6d
            r3.b()     // Catch: java.lang.Throwable -> L6d
        L52:
            com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.o.e()     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L5f
            com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.o.e()     // Catch: java.lang.Throwable -> L6d
            r3.b()     // Catch: java.lang.Throwable -> L6d
        L5f:
            com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L71
            com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch: java.lang.Throwable -> L6d
            r3.b()     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r3 = move-exception
            r3.printStackTrace()
        L71:
            com.bytedance.sdk.openadsdk.j.a r3 = com.bytedance.sdk.openadsdk.core.o.g()     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L83
            com.bytedance.sdk.openadsdk.j.a r3 = com.bytedance.sdk.openadsdk.core.o.g()     // Catch: java.lang.Throwable -> L7f
            r3.b()     // Catch: java.lang.Throwable -> L7f
            goto L83
        L7f:
            r3 = move-exception
            r3.printStackTrace()
        L83:
            com.bytedance.sdk.openadsdk.f.b.a r3 = com.bytedance.sdk.openadsdk.core.o.j()     // Catch: java.lang.Throwable -> L91
            if (r3 == 0) goto L95
            com.bytedance.sdk.openadsdk.f.b.a r3 = com.bytedance.sdk.openadsdk.core.o.j()     // Catch: java.lang.Throwable -> L91
            r3.b()     // Catch: java.lang.Throwable -> L91
            goto L95
        L91:
            r3 = move-exception
            r3.printStackTrace()
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.g.a(int):void");
    }
}
