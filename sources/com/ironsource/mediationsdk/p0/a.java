package com.ironsource.mediationsdk.p0;

import java.util.Timer;
import java.util.TimerTask;
/* compiled from: AbstractTimer.java */
/* loaded from: classes2.dex */
public abstract class a<T> {
    private Timer a;
    private long b;
    protected T c;

    /* compiled from: AbstractTimer.java */
    /* renamed from: com.ironsource.mediationsdk.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0210a extends TimerTask {
        C0210a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    public a(long j2) {
        this.b = j2;
    }

    protected boolean a() {
        return this.b <= 0;
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(T t) {
        if (a() || t == null) {
            return;
        }
        this.c = t;
        d();
        Timer timer = new Timer();
        this.a = timer;
        timer.schedule(new C0210a(), this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }
}
