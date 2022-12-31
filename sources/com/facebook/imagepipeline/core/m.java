package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: PriorityThreadFactory.java */
/* loaded from: classes.dex */
public class m implements ThreadFactory {
    private final int a;
    private final String b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f2776d = new AtomicInteger(1);

    /* compiled from: PriorityThreadFactory.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(m.this.a);
            } catch (Throwable unused) {
            }
            this.a.run();
        }
    }

    public m(int i2, String str, boolean z) {
        this.a = i2;
        this.b = str;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        a aVar = new a(runnable);
        if (this.c) {
            str = this.b + PGTransHeader.CONNECTOR + this.f2776d.getAndIncrement();
        } else {
            str = this.b;
        }
        return new Thread(aVar, str);
    }
}
