package us.pinguo.camera2020.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.s;
/* compiled from: ObjectLatch.kt */
/* loaded from: classes3.dex */
public final class c<R> {
    private R a;
    private final CountDownLatch b = new CountDownLatch(1);

    private final boolean a() {
        return this.b.getCount() == 0;
    }

    public static /* synthetic */ Object e(c cVar, long j2, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            j2 = -1;
        }
        return cVar.d(j2);
    }

    public final void b() {
        this.b.countDown();
    }

    public final synchronized void c(R r) {
        if (!a()) {
            this.a = r;
            this.b.countDown();
        }
    }

    public final R d(long j2) throws InterruptedException {
        R r;
        R r2;
        us.pinguo.common.log.a.q("start waitUntilGet", new Object[0]);
        if (j2 == -1) {
            this.b.await();
            synchronized (this) {
                r2 = this.a;
            }
            return r2;
        } else if (this.b.await(j2, TimeUnit.MILLISECONDS)) {
            synchronized (this) {
                us.pinguo.common.log.a.q(s.q("await pass return value:", this.a), new Object[0]);
                r = this.a;
            }
            return r;
        } else {
            us.pinguo.common.log.a.q("waitUntilGet is timeout in:" + j2 + " milliseconds! return null", new Object[0]);
            return null;
        }
    }
}
