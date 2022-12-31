package com.ironsource.mediationsdk.events;

import android.os.Handler;
import android.os.HandlerThread;
/* compiled from: SuperLooper.java */
/* loaded from: classes2.dex */
public class f extends Thread {
    private static f b;
    private a a;

    /* compiled from: SuperLooper.java */
    /* loaded from: classes2.dex */
    private class a extends HandlerThread {
        private Handler a;

        a(f fVar, String str) {
            super(str);
            setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.f());
        }

        Handler a() {
            return this.a;
        }

        void b() {
            this.a = new Handler(getLooper());
        }
    }

    private f() {
        a aVar = new a(this, f.class.getSimpleName());
        this.a = aVar;
        aVar.start();
        this.a.b();
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f();
            }
            fVar = b;
        }
        return fVar;
    }

    public synchronized void b(Runnable runnable) {
        a aVar = this.a;
        if (aVar == null) {
            return;
        }
        Handler a2 = aVar.a();
        if (a2 != null) {
            a2.post(runnable);
        }
    }
}
