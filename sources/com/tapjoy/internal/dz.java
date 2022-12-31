package com.tapjoy.internal;

import com.tapjoy.internal.dy;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class dz implements dy.a {
    private final BlockingQueue a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private dy f7390d = null;

    public dz() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        dy dyVar = (dy) this.c.poll();
        this.f7390d = dyVar;
        if (dyVar != null) {
            dyVar.executeOnExecutor(this.b, new Object[0]);
        }
    }

    @Override // com.tapjoy.internal.dy.a
    public final void a() {
        this.f7390d = null;
        b();
    }

    public final void a(dy dyVar) {
        dyVar.f7388d = this;
        this.c.add(dyVar);
        if (this.f7390d == null) {
            b();
        }
    }
}
