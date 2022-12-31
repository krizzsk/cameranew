package com.pinguo.album;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: PriorityThreadFactory.java */
/* loaded from: classes3.dex */
public class f implements ThreadFactory {
    private final int a;
    private final AtomicInteger b = new AtomicInteger();
    private final String c;

    /* compiled from: PriorityThreadFactory.java */
    /* loaded from: classes3.dex */
    class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(f.this.a);
            super.run();
        }
    }

    public f(String str, int i2) {
        this.c = str;
        this.a = i2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.c + '-' + this.b.getAndIncrement());
    }
}
