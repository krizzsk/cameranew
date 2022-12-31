package com.tapjoy.internal;

import com.tapjoy.internal.gf;
/* loaded from: classes3.dex */
public final class fw {
    public fq a;
    public volatile gf.a b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public volatile gf.a f7546d;

    /* renamed from: e  reason: collision with root package name */
    public volatile gf.a f7547e;

    public final void a() {
        a(16);
        gf.a aVar = this.f7546d;
        if (aVar != null) {
            this.f7546d = null;
            aVar.b().c();
        }
    }

    public final synchronized void a(int i2) {
        int i3;
        gf.a aVar = this.b;
        if (aVar != null && (i3 = this.c) < i2) {
            int i4 = i2 | i3;
            this.c = i4;
            aVar.a("state", Integer.valueOf(i4)).b().c();
        }
    }
}
