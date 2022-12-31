package com.ironsource.lifecycle;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
/* compiled from: LifecycleSensitiveTimer.java */
/* loaded from: classes2.dex */
public class b implements com.ironsource.lifecycle.a {
    private Timer a;
    private boolean b = false;
    private Long c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f5361d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f5362e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleSensitiveTimer.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.f5362e.run();
        }
    }

    public b(long j2, Runnable runnable, boolean z) {
        this.f5361d = j2;
        this.f5362e = runnable;
        if (z) {
            h();
        }
    }

    private void g() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }

    private void i() {
        if (this.a == null) {
            Timer timer = new Timer();
            this.a = timer;
            timer.schedule(new a(), this.f5361d);
            Calendar.getInstance().setTimeInMillis(this.c.longValue());
        }
    }

    @Override // com.ironsource.lifecycle.a
    public void a() {
    }

    @Override // com.ironsource.lifecycle.a
    public void b() {
    }

    @Override // com.ironsource.lifecycle.a
    public void c() {
        if (this.a != null) {
            g();
        }
    }

    @Override // com.ironsource.lifecycle.a
    public void d() {
        Long l2;
        if (this.a == null && (l2 = this.c) != null) {
            long longValue = l2.longValue() - System.currentTimeMillis();
            this.f5361d = longValue;
            if (longValue <= 0) {
                f();
                this.f5362e.run();
                return;
            }
            i();
        }
    }

    public void f() {
        g();
        this.b = false;
        this.c = null;
        IronsourceLifecycleManager.getInstance().l(this);
    }

    public void h() {
        if (this.b) {
            return;
        }
        this.b = true;
        IronsourceLifecycleManager.getInstance().g(this);
        this.c = Long.valueOf(System.currentTimeMillis() + this.f5361d);
        if (IronsourceLifecycleManager.getInstance().k()) {
            return;
        }
        i();
    }
}
