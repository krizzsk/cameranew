package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public class l {
    private final Context a;
    private final com.google.android.datatransport.runtime.backends.e b;
    private final com.google.android.datatransport.runtime.w.j.c c;

    /* renamed from: d  reason: collision with root package name */
    private final r f3404d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f3405e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f3406f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.x.a f3407g;

    @Inject
    public l(Context context, com.google.android.datatransport.runtime.backends.e eVar, com.google.android.datatransport.runtime.w.j.c cVar, r rVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, com.google.android.datatransport.runtime.x.a aVar2) {
        this.a = context;
        this.b = eVar;
        this.c = cVar;
        this.f3404d = rVar;
        this.f3405e = executor;
        this.f3406f = aVar;
        this.f3407g = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object c(l lVar, BackendResponse backendResponse, Iterable iterable, com.google.android.datatransport.runtime.m mVar, int i2) {
        if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
            lVar.c.K(iterable);
            lVar.f3404d.a(mVar, i2 + 1);
            return null;
        }
        lVar.c.c(iterable);
        if (backendResponse.c() == BackendResponse.Status.OK) {
            lVar.c.f(mVar, lVar.f3407g.a() + backendResponse.b());
        }
        if (lVar.c.J(mVar)) {
            lVar.f3404d.b(mVar, 1, true);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(l lVar, com.google.android.datatransport.runtime.m mVar, int i2, Runnable runnable) {
        try {
            try {
                com.google.android.datatransport.runtime.synchronization.a aVar = lVar.f3406f;
                com.google.android.datatransport.runtime.w.j.c cVar = lVar.c;
                cVar.getClass();
                aVar.a(j.a(cVar));
                if (!lVar.a()) {
                    lVar.f3406f.a(k.a(lVar, mVar, i2));
                } else {
                    lVar.f(mVar, i2);
                }
            } catch (SynchronizationException unused) {
                lVar.f3404d.a(mVar, i2 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void f(com.google.android.datatransport.runtime.m mVar, int i2) {
        BackendResponse b;
        com.google.android.datatransport.runtime.backends.l lVar = this.b.get(mVar.b());
        Iterable<com.google.android.datatransport.runtime.w.j.i> iterable = (Iterable) this.f3406f.a(h.a(this, mVar));
        if (iterable.iterator().hasNext()) {
            if (lVar == null) {
                com.google.android.datatransport.runtime.u.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", mVar);
                b = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (com.google.android.datatransport.runtime.w.j.i iVar : iterable) {
                    arrayList.add(iVar.b());
                }
                f.a a = com.google.android.datatransport.runtime.backends.f.a();
                a.b(arrayList);
                a.c(mVar.c());
                b = lVar.b(a.a());
            }
            this.f3406f.a(i.a(this, b, iterable, mVar, i2));
        }
    }

    public void g(com.google.android.datatransport.runtime.m mVar, int i2, Runnable runnable) {
        this.f3405e.execute(g.a(this, mVar, i2, runnable));
    }
}
