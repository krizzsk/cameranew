package us.pinguo.svideo.utils;

import java.util.concurrent.Semaphore;
/* loaded from: classes6.dex */
public class RecordSemaphore extends Semaphore {
    public RecordSemaphore(int i2) {
        super(i2);
    }

    @Override // java.util.concurrent.Semaphore
    public void acquire(int i2) throws InterruptedException {
        super.acquire(i2);
        b.i("acquire " + i2 + " availablePermits:" + availablePermits(), new Object[0]);
    }

    @Override // java.util.concurrent.Semaphore
    public void release(int i2) {
        super.release(i2);
        b.i("release " + i2 + " availablePermits:" + availablePermits(), new Object[0]);
    }

    @Override // java.util.concurrent.Semaphore
    public boolean tryAcquire(int i2) {
        boolean tryAcquire = super.tryAcquire(i2);
        b.i("tryAcquire " + i2 + " availablePermits:" + availablePermits(), new Object[0]);
        return tryAcquire;
    }

    @Override // java.util.concurrent.Semaphore
    public void acquire() throws InterruptedException {
        super.acquire();
        b.i("acquire availablePermits:" + availablePermits(), new Object[0]);
    }

    @Override // java.util.concurrent.Semaphore
    public void release() {
        super.release();
        b.i("release 1 availablePermits:" + availablePermits(), new Object[0]);
    }
}
