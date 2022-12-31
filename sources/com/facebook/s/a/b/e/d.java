package com.facebook.s.a.b.e;
/* compiled from: FixedNumberBitmapFramePreparationStrategy.java */
/* loaded from: classes.dex */
public class d implements a {
    private static final Class<?> b = d.class;
    private final int a;

    public d() {
        this(3);
    }

    @Override // com.facebook.s.a.b.e.a
    public void a(b bVar, com.facebook.s.a.b.b bVar2, com.facebook.s.a.a.a aVar, int i2) {
        for (int i3 = 1; i3 <= this.a; i3++) {
            int a = (i2 + i3) % aVar.a();
            if (com.facebook.common.logging.a.m(2)) {
                com.facebook.common.logging.a.q(b, "Preparing frame %d, last drawn: %d", Integer.valueOf(a), Integer.valueOf(i2));
            }
            if (!bVar.a(bVar2, aVar, a)) {
                return;
            }
        }
    }

    public d(int i2) {
        this.a = i2;
    }
}
