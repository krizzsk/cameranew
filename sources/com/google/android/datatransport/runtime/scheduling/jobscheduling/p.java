package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.concurrent.Executor;
import javax.inject.Inject;
/* compiled from: WorkInitializer.java */
/* loaded from: classes2.dex */
public class p {
    private final Executor a;
    private final com.google.android.datatransport.runtime.w.j.c b;
    private final r c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f3412d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public p(Executor executor, com.google.android.datatransport.runtime.w.j.c cVar, r rVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.a = executor;
        this.b = cVar;
        this.c = rVar;
        this.f3412d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(p pVar) {
        for (com.google.android.datatransport.runtime.m mVar : pVar.b.G()) {
            pVar.c.a(mVar, 1);
        }
        return null;
    }

    public void a() {
        this.a.execute(n.a(this));
    }
}
