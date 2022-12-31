package com.google.android.gms.measurement.internal;

import android.os.Process;
import androidx.annotation.GuardedBy;
import androidx.work.WorkRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class k4 extends Thread {
    private final Object a;
    private final BlockingQueue<j4<?>> b;
    @GuardedBy("threadLifeCycleLock")
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l4 f3855d;

    public k4(l4 l4Var, String str, BlockingQueue<j4<?>> blockingQueue) {
        this.f3855d = l4Var;
        com.google.android.gms.common.internal.q.j(str);
        com.google.android.gms.common.internal.q.j(blockingQueue);
        this.a = new Object();
        this.b = blockingQueue;
        setName(str);
    }

    private final void b() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        k4 k4Var;
        k4 k4Var2;
        obj = this.f3855d.f3864i;
        synchronized (obj) {
            if (!this.c) {
                semaphore = this.f3855d.f3865j;
                semaphore.release();
                obj2 = this.f3855d.f3864i;
                obj2.notifyAll();
                k4Var = this.f3855d.c;
                if (this == k4Var) {
                    this.f3855d.c = null;
                } else {
                    k4Var2 = this.f3855d.f3859d;
                    if (this == k4Var2) {
                        this.f3855d.f3859d = null;
                    } else {
                        this.f3855d.a.a().m().a("Current scheduler thread is neither worker nor network");
                    }
                }
                this.c = true;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.f3855d.a.a().p().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z = false;
        while (!z) {
            try {
                semaphore = this.f3855d.f3865j;
                semaphore.acquire();
                z = true;
            } catch (InterruptedException e2) {
                c(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                j4<?> poll = this.b.poll();
                if (poll != null) {
                    Process.setThreadPriority(true != poll.b ? 10 : threadPriority);
                    poll.run();
                } else {
                    synchronized (this.a) {
                        if (this.b.peek() == null) {
                            boolean unused = this.f3855d.f3866k;
                            try {
                                this.a.wait(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                            } catch (InterruptedException e3) {
                                c(e3);
                            }
                        }
                    }
                    obj = this.f3855d.f3864i;
                    synchronized (obj) {
                        if (this.b.peek() == null) {
                            break;
                        }
                    }
                }
            }
            if (this.f3855d.a.x().u(null, x2.q0)) {
                b();
            }
        } finally {
            b();
        }
    }
}
