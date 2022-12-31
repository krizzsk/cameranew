package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* compiled from: DelayProducer.java */
/* loaded from: classes.dex */
public class o implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> a;
    @Nullable
    private final ScheduledExecutorService b;

    /* compiled from: DelayProducer.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ l a;
        final /* synthetic */ o0 b;

        a(l lVar, o0 o0Var) {
            this.a = lVar;
            this.b = o0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.b(this.a, this.b);
        }
    }

    public o(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var, @Nullable ScheduledExecutorService scheduledExecutorService) {
        this.a = n0Var;
        this.b = scheduledExecutorService;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        ImageRequest j2 = o0Var.j();
        ScheduledExecutorService scheduledExecutorService = this.b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new a(lVar, o0Var), j2.e(), TimeUnit.MILLISECONDS);
        } else {
            this.a.b(lVar, o0Var);
        }
    }
}
