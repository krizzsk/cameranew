package com.pinguo.camera360.gallery.util;

import android.content.Context;
/* loaded from: classes3.dex */
public class ScrollerHelper {
    private OverScroller a;
    private int b = 0;
    private boolean c;

    public ScrollerHelper(Context context) {
        this.a = new OverScroller(context);
    }

    public boolean a(long j2) {
        return this.a.b();
    }

    public void b(int i2, int i3, int i4) {
        this.a.d(0, e(), 0, i2, 0, 0, i3, i4, this.c ? this.b : 0, 0);
    }

    public void c() {
        this.a.e(true);
    }

    public float d() {
        return this.a.f();
    }

    public int e() {
        return this.a.h();
    }

    public boolean f() {
        return this.a.k();
    }

    public void g(int i2) {
        this.a.l(0, i2, 0, 0, 0);
        this.a.a();
    }

    public int h(int i2, int i3, int i4) {
        int h2 = this.a.h();
        int j2 = (this.a.k() ? h2 : this.a.j()) + i2;
        int e2 = com.pinguo.album.j.a.e(j2, i3, i4);
        if (e2 != h2) {
            this.a.l(0, h2, 0, e2 - h2, 0);
        }
        return j2 - e2;
    }
}
