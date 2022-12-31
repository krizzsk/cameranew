package de.greenrobot.event;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundPoster.java */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    private final g a = new g();
    private volatile boolean b;
    private final c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.c = cVar;
    }

    public void a(k kVar, Object obj) {
        f a = f.a(kVar, obj);
        synchronized (this) {
            this.a.a(a);
            if (!this.b) {
                this.b = true;
                c.f8616l.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                f c = this.a.c(1000);
                if (c == null) {
                    synchronized (this) {
                        c = this.a.b();
                        if (c == null) {
                            return;
                        }
                    }
                }
                this.c.e(c);
            } catch (InterruptedException e2) {
                Log.w("Event", String.valueOf(Thread.currentThread().getName()) + " was interruppted", e2);
                return;
            } finally {
                this.b = false;
            }
        }
    }
}
