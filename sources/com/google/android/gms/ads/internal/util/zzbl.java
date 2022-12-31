package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzdvl;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbl {
    private HandlerThread a = null;
    private Handler b = null;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final Object f3480d = new Object();

    public final Handler getHandler() {
        return this.b;
    }

    public final Looper zzzp() {
        Looper looper;
        synchronized (this.f3480d) {
            if (this.c == 0) {
                if (this.a == null) {
                    zzd.zzeb("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.a = handlerThread;
                    handlerThread.start();
                    this.b = new zzdvl(this.a.getLooper());
                    zzd.zzeb("Looper thread started.");
                } else {
                    zzd.zzeb("Resuming the looper thread");
                    this.f3480d.notifyAll();
                }
            } else {
                com.google.android.gms.common.internal.q.k(this.a, "Invalid state: mHandlerThread should already been initialized.");
            }
            this.c++;
            looper = this.a.getLooper();
        }
        return looper;
    }
}
