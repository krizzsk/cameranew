package com.facebook.imagepipeline.producers;

import java.util.concurrent.Executor;
/* compiled from: ExperimentalThreadHandoffProducerQueueImpl.java */
/* loaded from: classes.dex */
public class v implements y0 {
    private final Executor a;

    public v(Executor executor) {
        com.facebook.common.internal.h.g(executor);
        this.a = executor;
    }

    @Override // com.facebook.imagepipeline.producers.y0
    public void a(Runnable runnable) {
    }

    @Override // com.facebook.imagepipeline.producers.y0
    public void b(Runnable runnable) {
        this.a.execute(runnable);
    }
}
