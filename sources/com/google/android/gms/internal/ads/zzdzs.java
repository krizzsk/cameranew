package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzdzs<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zziaq = new zzdzt();
    private static final Runnable zziar = new zzdzt();
    private static final Runnable zzias = new zzdzt();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zziar)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(zziaq) == zzias) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T zzbab;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    zzbab = zzbab();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zziaq)) {
                        Runnable runnable = get();
                        boolean z2 = false;
                        int i2 = 0;
                        while (true) {
                            Runnable runnable2 = zziar;
                            if (runnable != runnable2 && runnable != zzias) {
                                break;
                            }
                            i2++;
                            if (i2 > 1000) {
                                Runnable runnable3 = zzias;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        zzb(null, th);
                        return;
                    }
                    return;
                }
            } else {
                zzbab = null;
            }
            if (!compareAndSet(currentThread, zziaq)) {
                Runnable runnable4 = get();
                boolean z3 = false;
                int i3 = 0;
                while (true) {
                    Runnable runnable5 = zziar;
                    if (runnable4 != runnable5 && runnable4 != zzias) {
                        break;
                    }
                    i3++;
                    if (i3 > 1000) {
                        Runnable runnable6 = zzias;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                zzb(zzbab, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == zziaq) {
            str = "running=[DONE]";
        } else if (runnable == zziar) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzbac = zzbac();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzbac).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzbac);
        return sb2.toString();
    }

    abstract void zzb(@NullableDecl T t, @NullableDecl Throwable th);

    abstract T zzbab() throws Exception;

    abstract String zzbac();
}
