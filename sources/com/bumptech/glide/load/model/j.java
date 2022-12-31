package com.bumptech.glide.load.model;

import java.util.Queue;
/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class j<A, B> {
    private final com.bumptech.glide.l.e<b<A>, B> a;

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    class a extends com.bumptech.glide.l.e<b<A>, B> {
        a(j jVar, int i2) {
            super(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.l.e
        /* renamed from: n */
        public void j(b<A> bVar, B b) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f774d = com.bumptech.glide.l.h.c(0);
        private int a;
        private int b;
        private A c;

        private b() {
        }

        static <A> b<A> a(A a, int i2, int i3) {
            b<A> bVar = (b<A>) f774d.poll();
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a, i2, i3);
            return bVar;
        }

        private void b(A a, int i2, int i3) {
            this.c = a;
            this.b = i2;
            this.a = i3;
        }

        public void c() {
            f774d.offer(this);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public j(int i2) {
        this.a = new a(this, i2);
    }

    public B a(A a2, int i2, int i3) {
        b<A> a3 = b.a(a2, i2, i3);
        B g2 = this.a.g(a3);
        a3.c();
        return g2;
    }

    public void b(A a2, int i2, int i3, B b2) {
        this.a.k(b.a(a2, i2, i3), b2);
    }
}
