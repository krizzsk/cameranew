package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.android.datatransport.runtime.w.j.b0;
import com.google.android.datatransport.runtime.w.j.c0;
import com.google.android.datatransport.runtime.w.j.i0;
import java.util.concurrent.Executor;
import javax.inject.Provider;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: classes2.dex */
public final class d extends s {
    private Provider<Executor> a;
    private Provider<Context> b;
    private Provider c;

    /* renamed from: d  reason: collision with root package name */
    private Provider f3388d;

    /* renamed from: e  reason: collision with root package name */
    private Provider f3389e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<b0> f3390f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<SchedulerConfig> f3391g;

    /* renamed from: h  reason: collision with root package name */
    private Provider<r> f3392h;

    /* renamed from: i  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.w.c> f3393i;

    /* renamed from: j  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.l> f3394j;

    /* renamed from: k  reason: collision with root package name */
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.p> f3395k;

    /* renamed from: l  reason: collision with root package name */
    private Provider<TransportRuntime> f3396l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerTransportRuntimeComponent.java */
    /* loaded from: classes2.dex */
    public static final class b implements s.a {
        private Context a;

        private b() {
        }

        @Override // com.google.android.datatransport.runtime.s.a
        public /* bridge */ /* synthetic */ s.a a(Context context) {
            b(context);
            return this;
        }

        public b b(Context context) {
            com.google.android.datatransport.runtime.dagger.internal.d.b(context);
            this.a = context;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.s.a
        public s build() {
            com.google.android.datatransport.runtime.dagger.internal.d.a(this.a, Context.class);
            return new d(this.a);
        }
    }

    public static s.a v() {
        return new b();
    }

    private void w(Context context) {
        this.a = com.google.android.datatransport.runtime.dagger.internal.a.a(j.a());
        com.google.android.datatransport.runtime.dagger.internal.b a2 = com.google.android.datatransport.runtime.dagger.internal.c.a(context);
        this.b = a2;
        com.google.android.datatransport.runtime.backends.i a3 = com.google.android.datatransport.runtime.backends.i.a(a2, com.google.android.datatransport.runtime.x.c.a(), com.google.android.datatransport.runtime.x.d.a());
        this.c = a3;
        this.f3388d = com.google.android.datatransport.runtime.dagger.internal.a.a(com.google.android.datatransport.runtime.backends.k.a(this.b, a3));
        this.f3389e = i0.a(this.b, com.google.android.datatransport.runtime.w.j.f.a(), com.google.android.datatransport.runtime.w.j.g.a());
        this.f3390f = com.google.android.datatransport.runtime.dagger.internal.a.a(c0.a(com.google.android.datatransport.runtime.x.c.a(), com.google.android.datatransport.runtime.x.d.a(), com.google.android.datatransport.runtime.w.j.h.a(), this.f3389e));
        com.google.android.datatransport.runtime.w.g b2 = com.google.android.datatransport.runtime.w.g.b(com.google.android.datatransport.runtime.x.c.a());
        this.f3391g = b2;
        com.google.android.datatransport.runtime.w.i a4 = com.google.android.datatransport.runtime.w.i.a(this.b, this.f3390f, b2, com.google.android.datatransport.runtime.x.d.a());
        this.f3392h = a4;
        Provider<Executor> provider = this.a;
        Provider provider2 = this.f3388d;
        Provider<b0> provider3 = this.f3390f;
        this.f3393i = com.google.android.datatransport.runtime.w.d.a(provider, provider2, a4, provider3, provider3);
        Provider<Context> provider4 = this.b;
        Provider provider5 = this.f3388d;
        Provider<b0> provider6 = this.f3390f;
        this.f3394j = com.google.android.datatransport.runtime.scheduling.jobscheduling.m.a(provider4, provider5, provider6, this.f3392h, this.a, provider6, com.google.android.datatransport.runtime.x.c.a());
        Provider<Executor> provider7 = this.a;
        Provider<b0> provider8 = this.f3390f;
        this.f3395k = com.google.android.datatransport.runtime.scheduling.jobscheduling.q.a(provider7, provider8, this.f3392h, provider8);
        this.f3396l = com.google.android.datatransport.runtime.dagger.internal.a.a(t.a(com.google.android.datatransport.runtime.x.c.a(), com.google.android.datatransport.runtime.x.d.a(), this.f3393i, this.f3394j, this.f3395k));
    }

    @Override // com.google.android.datatransport.runtime.s
    com.google.android.datatransport.runtime.w.j.c d() {
        return this.f3390f.get();
    }

    @Override // com.google.android.datatransport.runtime.s
    TransportRuntime t() {
        return this.f3396l.get();
    }

    private d(Context context) {
        w(context);
    }
}
