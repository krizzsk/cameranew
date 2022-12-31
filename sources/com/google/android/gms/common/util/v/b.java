package com.google.android.gms.common.util.v;

import com.google.android.gms.common.internal.q;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class b implements ThreadFactory {
    private final String a;
    private final AtomicInteger b;
    private final ThreadFactory c;

    public b(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.c.newThread(new c(runnable, 0));
        String str = this.a;
        int andIncrement = this.b.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }

    private b(String str, int i2) {
        this.b = new AtomicInteger();
        this.c = Executors.defaultThreadFactory();
        q.k(str, "Name must not be null");
        this.a = str;
    }
}
