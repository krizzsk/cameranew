package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* compiled from: ThreadHandoffProducerQueueImpl.java */
/* loaded from: classes.dex */
public class z0 implements y0 {
    private boolean a = false;
    private final Deque<Runnable> b;
    private final Executor c;

    public z0(Executor executor) {
        com.facebook.common.internal.h.g(executor);
        this.c = executor;
        this.b = new ArrayDeque();
    }

    @Override // com.facebook.imagepipeline.producers.y0
    public synchronized void a(Runnable runnable) {
        this.b.remove(runnable);
    }

    @Override // com.facebook.imagepipeline.producers.y0
    public synchronized void b(Runnable runnable) {
        if (this.a) {
            this.b.add(runnable);
        } else {
            this.c.execute(runnable);
        }
    }
}
