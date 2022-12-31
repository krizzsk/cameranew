package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class a implements g {
    private final b a = new b();
    private final e<C0029a, Bitmap> b = new e<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0029a implements h {
        private final b a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f724d;

        public C0029a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
        public void a() {
            this.a.c(this);
        }

        public void b(int i2, int i3, Bitmap.Config config) {
            this.b = i2;
            this.c = i3;
            this.f724d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0029a) {
                C0029a c0029a = (C0029a) obj;
                return this.b == c0029a.b && this.c == c0029a.c && this.f724d == c0029a.f724d;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.b * 31) + this.c) * 31;
            Bitmap.Config config = this.f724d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return a.g(this.b, this.c, this.f724d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    static class b extends com.bumptech.glide.load.engine.bitmap_recycle.b<C0029a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* renamed from: d */
        public C0029a a() {
            return new C0029a(this);
        }

        public C0029a e(int i2, int i3, Bitmap.Config config) {
            C0029a b = b();
            b.b(i2, i3, config);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String h(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public void a(Bitmap bitmap) {
        this.b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String b(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String c(int i2, int i3, Bitmap.Config config) {
        return g(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        return this.b.a(this.a.e(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public int e(Bitmap bitmap) {
        return com.bumptech.glide.l.h.e(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap removeLast() {
        return this.b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
