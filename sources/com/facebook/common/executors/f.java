package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
/* compiled from: StatefulRunnable.java */
/* loaded from: classes.dex */
public abstract class f<T> implements Runnable {
    protected final AtomicInteger a = new AtomicInteger(0);

    public void a() {
        if (this.a.compareAndSet(0, 2)) {
            d();
        }
    }

    protected abstract void b(@Nullable T t);

    @Nullable
    protected abstract T c() throws Exception;

    protected abstract void d();

    protected abstract void e(Exception exc);

    protected abstract void f(@Nullable T t);

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.compareAndSet(0, 1)) {
            try {
                T c = c();
                this.a.set(3);
                try {
                    f(c);
                } finally {
                    b(c);
                }
            } catch (Exception e2) {
                this.a.set(4);
                e(e2);
            }
        }
    }
}
