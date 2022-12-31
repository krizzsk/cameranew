package com.google.android.gms.common.util.v;

import com.google.android.gms.common.internal.q;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class a implements ThreadFactory {
    private final String a;
    private final ThreadFactory b;

    public a(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.b.newThread(new c(runnable, 0));
        newThread.setName(this.a);
        return newThread;
    }

    private a(String str, int i2) {
        this.b = Executors.defaultThreadFactory();
        q.k(str, "Name must not be null");
        this.a = str;
    }
}
