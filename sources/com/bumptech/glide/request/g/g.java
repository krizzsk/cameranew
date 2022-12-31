package com.bumptech.glide.request.g;
/* compiled from: SimpleTarget.java */
/* loaded from: classes.dex */
public abstract class g<Z> extends a<Z> {
    private final int b;
    private final int c;

    public g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.g.j
    public final void i(h hVar) {
        if (com.bumptech.glide.l.h.k(this.b, this.c)) {
            hVar.c(this.b, this.c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.b + " and height: " + this.c + ", either provide dimensions in the constructor or call override()");
    }

    public g(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }
}
