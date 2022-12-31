package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.m;
import com.google.android.datatransport.runtime.s;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
/* loaded from: classes2.dex */
public class TransportRuntime implements q {

    /* renamed from: e  reason: collision with root package name */
    private static volatile s f3375e;
    private final com.google.android.datatransport.runtime.x.a a;
    private final com.google.android.datatransport.runtime.x.a b;
    private final com.google.android.datatransport.runtime.w.e c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.l f3376d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public TransportRuntime(com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, com.google.android.datatransport.runtime.w.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.l lVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.p pVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = eVar;
        this.f3376d = lVar;
        pVar.a();
    }

    private h b(l lVar) {
        h.a a = h.a();
        a.i(this.a.a());
        a.k(this.b.a());
        a.j(lVar.g());
        a.h(new g(lVar.b(), lVar.d()));
        a.g(lVar.c().a());
        return a.d();
    }

    private static Set<com.google.android.datatransport.b> c(e eVar) {
        if (eVar instanceof f) {
            return Collections.unmodifiableSet(((f) eVar).a());
        }
        return Collections.singleton(com.google.android.datatransport.b.b("proto"));
    }

    public static void e(Context context) {
        if (f3375e == null) {
            synchronized (TransportRuntime.class) {
                if (f3375e == null) {
                    s.a v = d.v();
                    v.a(context);
                    f3375e = v.build();
                }
            }
        }
    }

    public static TransportRuntime getInstance() {
        s sVar = f3375e;
        if (sVar != null) {
            return sVar.t();
        }
        throw new IllegalStateException("Not initialized!");
    }

    @Override // com.google.android.datatransport.runtime.q
    public void a(l lVar, com.google.android.datatransport.g gVar) {
        this.c.a(lVar.f().e(lVar.c().c()), b(lVar), gVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.google.android.datatransport.runtime.scheduling.jobscheduling.l d() {
        return this.f3376d;
    }

    public com.google.android.datatransport.f f(e eVar) {
        Set<com.google.android.datatransport.b> c = c(eVar);
        m.a a = m.a();
        a.b(eVar.getName());
        a.c(eVar.getExtras());
        return new n(c, a.a(), this);
    }
}
