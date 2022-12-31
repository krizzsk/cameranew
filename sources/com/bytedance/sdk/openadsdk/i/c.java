package com.bytedance.sdk.openadsdk.i;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TTThreadFactory.java */
/* loaded from: classes.dex */
public class c implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);

    /* renamed from: d  reason: collision with root package name */
    private final String f2080d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2081e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i2, String str) {
        ThreadGroup threadGroup;
        this.f2081e = i2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.b = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f2080d = "ttbackground-" + a.getAndIncrement() + "-thread-";
            return;
        }
        this.f2080d = str + a.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.b;
        Thread thread = new Thread(threadGroup, runnable, this.f2080d + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f2081e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
