package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
/* loaded from: classes.dex */
class EngineRunnable implements Runnable, com.bumptech.glide.load.engine.executor.a {
    private final Priority a;
    private final a b;
    private final com.bumptech.glide.load.engine.a<?, ?, ?> c;

    /* renamed from: d  reason: collision with root package name */
    private Stage f708d = Stage.CACHE;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f709e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Stage {
        CACHE,
        SOURCE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a extends com.bumptech.glide.request.d {
        void d(EngineRunnable engineRunnable);
    }

    public EngineRunnable(a aVar, com.bumptech.glide.load.engine.a<?, ?, ?> aVar2, Priority priority) {
        this.b = aVar;
        this.c = aVar2;
        this.a = priority;
    }

    private i<?> b() throws Exception {
        if (e()) {
            return c();
        }
        return d();
    }

    private i<?> c() throws Exception {
        i<?> iVar;
        try {
            iVar = this.c.f();
        } catch (Exception e2) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e2);
            }
            iVar = null;
        }
        return iVar == null ? this.c.h() : iVar;
    }

    private i<?> d() throws Exception {
        return this.c.d();
    }

    private boolean e() {
        return this.f708d == Stage.CACHE;
    }

    private void f(i iVar) {
        this.b.a(iVar);
    }

    private void g(Exception exc) {
        if (e()) {
            this.f708d = Stage.SOURCE;
            this.b.d(this);
            return;
        }
        this.b.onException(exc);
    }

    public void a() {
        this.f709e = true;
        this.c.c();
    }

    @Override // com.bumptech.glide.load.engine.executor.a
    public int getPriority() {
        return this.a.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f709e) {
            return;
        }
        i<?> iVar = null;
        try {
            e = null;
            iVar = b();
        } catch (Exception e2) {
            e = e2;
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", e);
            }
        }
        if (this.f709e) {
            if (iVar != null) {
                iVar.recycle();
            }
        } else if (iVar == null) {
            g(e);
        } else {
            f(iVar);
        }
    }
}
