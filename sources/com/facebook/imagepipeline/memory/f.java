package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
/* compiled from: Bucket.java */
@NotThreadSafe
@VisibleForTesting
/* loaded from: classes.dex */
class f<V> {
    public final int a;
    public final int b;
    final Queue c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2854d;

    /* renamed from: e  reason: collision with root package name */
    private int f2855e;

    public f(int i2, int i3, int i4, boolean z) {
        com.facebook.common.internal.h.i(i2 > 0);
        com.facebook.common.internal.h.i(i3 >= 0);
        com.facebook.common.internal.h.i(i4 >= 0);
        this.a = i2;
        this.b = i3;
        this.c = new LinkedList();
        this.f2855e = i4;
        this.f2854d = z;
    }

    void a(V v) {
        this.c.add(v);
    }

    public void b() {
        com.facebook.common.internal.h.i(this.f2855e > 0);
        this.f2855e--;
    }

    @Nullable
    @Deprecated
    public V c() {
        V g2 = g();
        if (g2 != null) {
            this.f2855e++;
        }
        return g2;
    }

    int d() {
        return this.c.size();
    }

    public void e() {
        this.f2855e++;
    }

    public boolean f() {
        return this.f2855e + d() > this.b;
    }

    @Nullable
    public V g() {
        return (V) this.c.poll();
    }

    public void h(V v) {
        com.facebook.common.internal.h.g(v);
        if (this.f2854d) {
            com.facebook.common.internal.h.i(this.f2855e > 0);
            this.f2855e--;
            a(v);
            return;
        }
        int i2 = this.f2855e;
        if (i2 > 0) {
            this.f2855e = i2 - 1;
            a(v);
            return;
        }
        com.facebook.common.logging.a.j("BUCKET", "Tried to release value %s from an empty bucket!", v);
    }
}
