package com.tapjoy.internal;

import com.tapjoy.internal.kf;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public abstract class ka implements kf {
    private static final Logger a = Logger.getLogger(ka.class.getName());
    private final kf b = new kc() { // from class: com.tapjoy.internal.ka.1
        @Override // com.tapjoy.internal.kc
        protected final void a() {
            final ka kaVar = ka.this;
            new Executor() { // from class: com.tapjoy.internal.ka.2
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    new Thread(runnable, ka.this.getClass().getSimpleName()).start();
                }
            }.execute(new Runnable() { // from class: com.tapjoy.internal.ka.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ka.this.b();
                        c();
                        if (f() == kf.a.RUNNING) {
                            ka.this.d();
                        }
                        ka.this.c();
                        d();
                    } catch (Throwable th) {
                        a(th);
                        throw jr.a(th);
                    }
                }
            });
        }

        @Override // com.tapjoy.internal.kc
        protected final void b() {
            ka.this.a();
        }
    };

    static /* synthetic */ Logger g() {
        return a;
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public abstract void d();

    @Override // com.tapjoy.internal.kf
    public final ke e() {
        return this.b.e();
    }

    @Override // com.tapjoy.internal.kf
    public final kf.a f() {
        return this.b.f();
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + f() + "]";
    }
}
