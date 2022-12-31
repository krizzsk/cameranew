package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public abstract class ca {
    public static ExecutorService a;
    public static cd b;
    private Future c;

    public abstract Object a(URI uri, InputStream inputStream);

    public Map a() {
        return Collections.emptyMap();
    }

    public abstract String b();

    public abstract String c();

    public String d() {
        return null;
    }

    public Map e() {
        return new LinkedHashMap();
    }

    public Object f() {
        return b.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0013 A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:12:0x0013, B:15:0x0020, B:16:0x0025), top: B:20:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0020 A[Catch: all -> 0x0026, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:12:0x0013, B:15:0x0020, B:16:0x0025), top: B:20:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(@javax.annotation.Nullable com.tapjoy.internal.cf r3, java.util.concurrent.ExecutorService r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.Future r0 = r2.c     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Le
            boolean r0 = r0.isDone()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            java.lang.String r1 = "Call has not completed"
            if (r0 == 0) goto L20
            com.tapjoy.internal.cc r0 = new com.tapjoy.internal.cc     // Catch: java.lang.Throwable -> L26
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L26
            java.util.concurrent.Future r3 = r4.submit(r0)     // Catch: java.lang.Throwable -> L26
            r2.c = r3     // Catch: java.lang.Throwable -> L26
            monitor-exit(r2)
            return
        L20:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L26
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L26
            throw r3     // Catch: java.lang.Throwable -> L26
        L26:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ca.a(com.tapjoy.internal.cf, java.util.concurrent.ExecutorService):void");
    }
}
