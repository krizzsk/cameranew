package com.facebook.s.a.b.f;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.s.a.b.c;
import javax.annotation.Nullable;
/* compiled from: AnimatedDrawableBackendFrameRenderer.java */
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: e  reason: collision with root package name */
    private static final Class<?> f3178e = b.class;
    private final com.facebook.s.a.b.b a;
    private com.facebook.imagepipeline.animated.base.a b;
    private AnimatedImageCompositor c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatedImageCompositor.b f3179d;

    /* compiled from: AnimatedDrawableBackendFrameRenderer.java */
    /* loaded from: classes.dex */
    class a implements AnimatedImageCompositor.b {
        a() {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.b
        public void a(int i2, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.b
        @Nullable
        public com.facebook.common.references.a<Bitmap> b(int i2) {
            return b.this.a.f(i2);
        }
    }

    public b(com.facebook.s.a.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        a aVar2 = new a();
        this.f3179d = aVar2;
        this.a = bVar;
        this.b = aVar;
        this.c = new AnimatedImageCompositor(aVar, aVar2);
    }

    @Override // com.facebook.s.a.b.c
    public boolean a(int i2, Bitmap bitmap) {
        try {
            this.c.g(i2, bitmap);
            return true;
        } catch (IllegalStateException e2) {
            com.facebook.common.logging.a.g(f3178e, e2, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i2));
            return false;
        }
    }

    @Override // com.facebook.s.a.b.c
    public int c() {
        return this.b.getHeight();
    }

    @Override // com.facebook.s.a.b.c
    public void d(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a e2 = this.b.e(rect);
        if (e2 != this.b) {
            this.b = e2;
            this.c = new AnimatedImageCompositor(e2, this.f3179d);
        }
    }

    @Override // com.facebook.s.a.b.c
    public int e() {
        return this.b.getWidth();
    }
}
