package pl.droidsonroids.gif;

import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeRunnable.java */
/* loaded from: classes3.dex */
public abstract class l implements Runnable {
    final c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.a = cVar;
    }

    abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.h()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
