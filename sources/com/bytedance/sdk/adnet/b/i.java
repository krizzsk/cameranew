package com.bytedance.sdk.adnet.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: RequestFuture.java */
/* loaded from: classes.dex */
public class i<T> implements m.a<T>, Future<m<T>> {
    private Request<?> a;
    private boolean b = false;
    private m<T> c;

    private i() {
    }

    public static <E> i<E> a() {
        return new i<>();
    }

    @Override // java.util.concurrent.Future
    /* renamed from: b */
    public m<T> get() throws InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.a.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.a;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.b) {
            z = isCancelled();
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    /* renamed from: a */
    public m<T> get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j2, timeUnit)));
    }

    private synchronized m<T> a(Long l2) throws InterruptedException, TimeoutException {
        if (this.b) {
            return this.c;
        }
        if (l2 == null) {
            while (!isDone()) {
                wait(0L);
            }
        } else if (l2.longValue() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long longValue = l2.longValue() + uptimeMillis;
            while (!isDone() && uptimeMillis < longValue) {
                wait(longValue - uptimeMillis);
                uptimeMillis = SystemClock.uptimeMillis();
            }
        }
        if (this.b) {
            return this.c;
        }
        throw new TimeoutException();
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public synchronized void b(m<T> mVar) {
        this.b = true;
        this.c = mVar;
        notifyAll();
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public synchronized void a(m<T> mVar) {
        this.b = true;
        this.c = mVar;
        notifyAll();
    }
}
