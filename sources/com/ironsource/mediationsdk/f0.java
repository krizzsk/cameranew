package com.ironsource.mediationsdk;

import java.util.Timer;
import java.util.TimerTask;
/* compiled from: RvLoadTrigger.java */
/* loaded from: classes2.dex */
public class f0 {
    private com.ironsource.mediationsdk.utils.b a;
    private g0 b;
    private Timer c = null;

    /* compiled from: RvLoadTrigger.java */
    /* loaded from: classes2.dex */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f0.this.b.E();
        }
    }

    /* compiled from: RvLoadTrigger.java */
    /* loaded from: classes2.dex */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f0.this.b.E();
        }
    }

    /* compiled from: RvLoadTrigger.java */
    /* loaded from: classes2.dex */
    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f0.this.b.E();
        }
    }

    public f0(com.ironsource.mediationsdk.utils.b bVar, g0 g0Var) {
        this.a = bVar;
        this.b = g0Var;
    }

    private void f() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public synchronized void b() {
        f();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new c(), this.a.c());
    }

    public synchronized void c() {
        if (!this.a.e()) {
            f();
            Timer timer = new Timer();
            this.c = timer;
            timer.schedule(new b(), this.a.l());
        }
    }

    public void d() {
        synchronized (this) {
            f();
        }
        this.b.E();
    }

    public synchronized void e() {
        if (this.a.e()) {
            f();
            Timer timer = new Timer();
            this.c = timer;
            timer.schedule(new a(), this.a.l());
        }
    }
}
