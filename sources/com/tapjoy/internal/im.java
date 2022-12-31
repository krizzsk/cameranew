package com.tapjoy.internal;

import android.os.SystemClock;
/* loaded from: classes3.dex */
public abstract class im implements Runnable {
    private final long a = 300;

    public abstract boolean a();

    @Override // java.lang.Runnable
    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime() + this.a;
        while (!a() && elapsedRealtime - SystemClock.elapsedRealtime() > 0) {
            try {
                Thread.sleep(0L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
