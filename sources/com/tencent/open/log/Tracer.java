package com.tencent.open.log;

import com.tencent.open.log.d;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public abstract class Tracer {
    private volatile int a;
    private volatile boolean b;
    private g c;

    public Tracer() {
        this(c.a, true, g.a);
    }

    public void a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.a, i2)) {
            doTrace(i2, thread, j2, str, str2, th);
        }
    }

    public boolean d() {
        return this.b;
    }

    protected abstract void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th);

    public g e() {
        return this.c;
    }

    public Tracer(int i2, boolean z, g gVar) {
        this.a = c.a;
        this.b = true;
        this.c = g.a;
        a(i2);
        a(z);
        a(gVar);
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(g gVar) {
        this.c = gVar;
    }
}
