package com.facebook.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
/* compiled from: LockOnGetVariable.java */
/* loaded from: classes.dex */
public class q<T> {
    private T a;
    private CountDownLatch b = new CountDownLatch(1);

    /* compiled from: LockOnGetVariable.java */
    /* loaded from: classes.dex */
    class a implements Callable<Void> {
        final /* synthetic */ Callable a;

        a(Callable callable) {
            this.a = callable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            try {
                q.this.a = this.a.call();
                q.this.b.countDown();
                return null;
            } catch (Throwable th) {
                q.this.b.countDown();
                throw th;
            }
        }
    }

    public q(Callable<T> callable) {
        com.facebook.f.p().execute(new FutureTask(new a(callable)));
    }

    private void d() {
        CountDownLatch countDownLatch = this.b;
        if (countDownLatch == null) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public T c() {
        d();
        return this.a;
    }
}
