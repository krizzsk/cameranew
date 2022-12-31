package com.google.android.datatransport.runtime.w;

import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;
/* compiled from: DefaultScheduler.java */
/* loaded from: classes2.dex */
public class c implements e {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f3417f = Logger.getLogger(TransportRuntime.class.getName());
    private final r a;
    private final Executor b;
    private final com.google.android.datatransport.runtime.backends.e c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.w.j.c f3418d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f3419e;

    @Inject
    public c(Executor executor, com.google.android.datatransport.runtime.backends.e eVar, r rVar, com.google.android.datatransport.runtime.w.j.c cVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.b = executor;
        this.c = eVar;
        this.a = rVar;
        this.f3418d = cVar;
        this.f3419e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(c cVar, m mVar, com.google.android.datatransport.runtime.h hVar) {
        cVar.f3418d.M(mVar, hVar);
        cVar.a.a(mVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(c cVar, m mVar, com.google.android.datatransport.g gVar, com.google.android.datatransport.runtime.h hVar) {
        try {
            l lVar = cVar.c.get(mVar.b());
            if (lVar == null) {
                String format = String.format("Transport backend '%s' is not registered", mVar.b());
                f3417f.warning(format);
                gVar.onSchedule(new IllegalArgumentException(format));
                return;
            }
            cVar.f3419e.a(b.a(cVar, mVar, lVar.a(hVar)));
            gVar.onSchedule(null);
        } catch (Exception e2) {
            Logger logger = f3417f;
            logger.warning("Error scheduling event " + e2.getMessage());
            gVar.onSchedule(e2);
        }
    }

    @Override // com.google.android.datatransport.runtime.w.e
    public void a(m mVar, com.google.android.datatransport.runtime.h hVar, com.google.android.datatransport.g gVar) {
        this.b.execute(a.a(this, mVar, gVar, hVar));
    }
}
