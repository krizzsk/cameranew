package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: DefaultExecutorSupplier.java */
/* loaded from: classes.dex */
public class b implements f {
    private final Executor b;
    private final Executor c;

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f2730e;
    private final Executor a = Executors.newFixedThreadPool(2, new m(10, "FrescoIoBoundExecutor", true));

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2729d = Executors.newFixedThreadPool(1, new m(10, "FrescoLightWeightBackgroundExecutor", true));

    public b(int i2) {
        this.b = Executors.newFixedThreadPool(i2, new m(10, "FrescoDecodeExecutor", true));
        this.c = Executors.newFixedThreadPool(i2, new m(10, "FrescoBackgroundExecutor", true));
        this.f2730e = Executors.newScheduledThreadPool(i2, new m(10, "FrescoBackgroundExecutor", true));
    }

    @Override // com.facebook.imagepipeline.core.f
    public Executor a() {
        return this.f2729d;
    }

    @Override // com.facebook.imagepipeline.core.f
    public Executor b() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.core.f
    public ScheduledExecutorService c() {
        return this.f2730e;
    }

    @Override // com.facebook.imagepipeline.core.f
    public Executor d() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.core.f
    public Executor e() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.core.f
    public Executor f() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.core.f
    public Executor g() {
        return this.a;
    }
}
