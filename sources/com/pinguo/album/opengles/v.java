package com.pinguo.album.opengles;

import com.pinguo.album.views.b;
import java.util.ArrayDeque;
/* compiled from: TextureUploader.java */
/* loaded from: classes3.dex */
public class v implements b.a {
    private final com.pinguo.album.views.b c;
    private final ArrayDeque<y> a = new ArrayDeque<>(64);
    private final ArrayDeque<y> b = new ArrayDeque<>(64);

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f6090d = false;

    public v(com.pinguo.album.views.b bVar) {
        this.c = bVar;
    }

    private void f() {
        if (this.f6090d) {
            return;
        }
        this.f6090d = true;
        this.c.j(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r7 == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
        r0.c(r4, 0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        r6 = r6 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int g(com.pinguo.album.opengles.l r4, java.util.ArrayDeque<com.pinguo.album.opengles.y> r5, int r6, boolean r7) {
        /*
            r3 = this;
        L0:
            if (r6 <= 0) goto L2c
            monitor-enter(r3)
            boolean r0 = r5.isEmpty()     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto Lb
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L29
            goto L2c
        Lb:
            java.lang.Object r0 = r5.removeFirst()     // Catch: java.lang.Throwable -> L29
            com.pinguo.album.opengles.y r0 = (com.pinguo.album.opengles.y) r0     // Catch: java.lang.Throwable -> L29
            r1 = 0
            r0.D(r1)     // Catch: java.lang.Throwable -> L29
            boolean r2 = r0.y()     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L29
            goto L0
        L1d:
            r0.F(r4)     // Catch: java.lang.Throwable -> L29
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L26
            r0.c(r4, r1, r1)
        L26:
            int r6 = r6 + (-1)
            goto L0
        L29:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L29
            throw r4
        L2c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.album.opengles.v.g(com.pinguo.album.opengles.l, java.util.ArrayDeque, int, boolean):int");
    }

    @Override // com.pinguo.album.views.b.a
    public void a() {
        synchronized (this) {
            this.f6090d = false;
        }
    }

    @Override // com.pinguo.album.views.b.a
    public boolean b(l lVar, boolean z) {
        boolean z2;
        boolean z3 = true;
        int g2 = g(lVar, this.a, 1, false);
        if (g2 < 1) {
            this.c.requestRender();
        }
        g(lVar, this.b, g2, true);
        synchronized (this) {
            if (this.a.isEmpty() && this.b.isEmpty()) {
                z3 = false;
            }
            this.f6090d = z3;
            z2 = this.f6090d;
        }
        return z2;
    }

    public synchronized void c(y yVar) {
        if (yVar.y()) {
            return;
        }
        this.b.addLast(yVar);
        yVar.D(true);
        f();
    }

    public synchronized void d(y yVar) {
        if (yVar.y()) {
            return;
        }
        this.a.addLast(yVar);
        yVar.D(true);
        f();
    }

    public synchronized void e() {
        while (!this.a.isEmpty()) {
            this.a.pop().D(false);
        }
        while (!this.b.isEmpty()) {
            this.b.pop().D(false);
        }
    }
}
