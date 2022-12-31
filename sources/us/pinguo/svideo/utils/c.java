package us.pinguo.svideo.utils;

import java.util.concurrent.CountDownLatch;
/* compiled from: TimeOutThread.java */
/* loaded from: classes6.dex */
public class c extends Thread {
    protected CountDownLatch a;

    public c(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.a.countDown();
    }

    public c(Runnable runnable, String str, CountDownLatch countDownLatch) {
        super(runnable, str);
        this.a = countDownLatch;
    }
}
