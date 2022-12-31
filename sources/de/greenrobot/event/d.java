package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandlerPoster.java */
/* loaded from: classes3.dex */
public final class d extends Handler {
    private final g a;
    private final int b;
    private final c c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8625d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Looper looper, int i2) {
        super(looper);
        this.c = cVar;
        this.b = i2;
        this.a = new g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar, Object obj) {
        f a = f.a(kVar, obj);
        synchronized (this) {
            this.a.a(a);
            if (!this.f8625d) {
                this.f8625d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                f b = this.a.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.a.b();
                        if (b == null) {
                            this.f8625d = false;
                            return;
                        }
                    }
                }
                this.c.e(b);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.b);
            if (sendMessage(obtainMessage())) {
                this.f8625d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f8625d = false;
        }
    }
}
