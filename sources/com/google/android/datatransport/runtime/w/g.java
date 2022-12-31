package com.google.android.datatransport.runtime.w;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import javax.inject.Provider;
/* compiled from: SchedulingConfigModule_ConfigFactory.java */
/* loaded from: classes2.dex */
public final class g implements com.google.android.datatransport.runtime.dagger.internal.b<SchedulerConfig> {
    private final Provider<com.google.android.datatransport.runtime.x.a> a;

    public g(Provider<com.google.android.datatransport.runtime.x.a> provider) {
        this.a = provider;
    }

    public static SchedulerConfig a(com.google.android.datatransport.runtime.x.a aVar) {
        SchedulerConfig a = f.a(aVar);
        com.google.android.datatransport.runtime.dagger.internal.d.c(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public static g b(Provider<com.google.android.datatransport.runtime.x.a> provider) {
        return new g(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public SchedulerConfig get() {
        return a(this.a.get());
    }
}
