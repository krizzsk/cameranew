package com.google.android.datatransport.runtime.w;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import javax.inject.Provider;
/* compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* loaded from: classes2.dex */
public final class i implements com.google.android.datatransport.runtime.dagger.internal.b<r> {
    private final Provider<Context> a;
    private final Provider<com.google.android.datatransport.runtime.w.j.c> b;
    private final Provider<SchedulerConfig> c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.x.a> f3422d;

    public i(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.w.j.c> provider2, Provider<SchedulerConfig> provider3, Provider<com.google.android.datatransport.runtime.x.a> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.f3422d = provider4;
    }

    public static i a(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.w.j.c> provider2, Provider<SchedulerConfig> provider3, Provider<com.google.android.datatransport.runtime.x.a> provider4) {
        return new i(provider, provider2, provider3, provider4);
    }

    public static r c(Context context, com.google.android.datatransport.runtime.w.j.c cVar, SchedulerConfig schedulerConfig, com.google.android.datatransport.runtime.x.a aVar) {
        r a = h.a(context, cVar, schedulerConfig, aVar);
        com.google.android.datatransport.runtime.dagger.internal.d.c(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public r get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.f3422d.get());
    }
}
