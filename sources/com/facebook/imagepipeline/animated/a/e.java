package com.facebook.imagepipeline.animated.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.f;
import com.facebook.imagepipeline.image.h;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: AnimatedImageFactoryImpl.java */
/* loaded from: classes.dex */
public class e implements d {
    @Nullable
    static c c = g("com.facebook.animated.gif.GifImage");
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    static c f2662d = g("com.facebook.animated.webp.WebPImage");
    private final com.facebook.imagepipeline.animated.impl.b a;
    private final f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedImageFactoryImpl.java */
    /* loaded from: classes.dex */
    public class a implements AnimatedImageCompositor.b {
        a(e eVar) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.b
        public void a(int i2, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.b
        @Nullable
        public com.facebook.common.references.a<Bitmap> b(int i2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedImageFactoryImpl.java */
    /* loaded from: classes.dex */
    public class b implements AnimatedImageCompositor.b {
        final /* synthetic */ List a;

        b(e eVar, List list) {
            this.a = list;
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.b
        public void a(int i2, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.b
        @Nullable
        public com.facebook.common.references.a<Bitmap> b(int i2) {
            return com.facebook.common.references.a.w((com.facebook.common.references.a) this.a.get(i2));
        }
    }

    public e(com.facebook.imagepipeline.animated.impl.b bVar, f fVar) {
        this.a = bVar;
        this.b = fVar;
    }

    @SuppressLint({"NewApi"})
    private com.facebook.common.references.a<Bitmap> c(int i2, int i3, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> d2 = this.b.d(i2, i3, config);
        d2.A().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            d2.A().setHasAlpha(true);
        }
        return d2;
    }

    private com.facebook.common.references.a<Bitmap> d(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config, int i2) {
        com.facebook.common.references.a<Bitmap> c2 = c(bVar.getWidth(), bVar.getHeight(), config);
        new AnimatedImageCompositor(this.a.a(com.facebook.imagepipeline.animated.base.d.b(bVar), null), new a(this)).g(i2, c2.A());
        return c2;
    }

    private List<com.facebook.common.references.a<Bitmap>> e(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.a a2 = this.a.a(com.facebook.imagepipeline.animated.base.d.b(bVar), null);
        ArrayList arrayList = new ArrayList(a2.a());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a2, new b(this, arrayList));
        for (int i2 = 0; i2 < a2.a(); i2++) {
            com.facebook.common.references.a<Bitmap> c2 = c(a2.getWidth(), a2.getHeight(), config);
            animatedImageCompositor.g(i2, c2.A());
            arrayList.add(c2);
        }
        return arrayList;
    }

    private com.facebook.imagepipeline.image.c f(com.facebook.imagepipeline.common.b bVar, com.facebook.imagepipeline.animated.base.b bVar2, Bitmap.Config config) {
        List<com.facebook.common.references.a<Bitmap>> list;
        com.facebook.common.references.a<Bitmap> aVar = null;
        try {
            int a2 = bVar.f2700d ? bVar2.a() - 1 : 0;
            if (bVar.f2702f) {
                com.facebook.imagepipeline.image.d dVar = new com.facebook.imagepipeline.image.d(d(bVar2, config, a2), h.f2818d, 0);
                com.facebook.common.references.a.y(null);
                com.facebook.common.references.a.z(null);
                return dVar;
            }
            if (bVar.f2701e) {
                list = e(bVar2, config);
                try {
                    aVar = com.facebook.common.references.a.w(list.get(a2));
                } catch (Throwable th) {
                    th = th;
                    com.facebook.common.references.a.y(aVar);
                    com.facebook.common.references.a.z(list);
                    throw th;
                }
            } else {
                list = null;
            }
            if (bVar.c && aVar == null) {
                aVar = d(bVar2, config, a2);
            }
            com.facebook.imagepipeline.animated.base.e e2 = com.facebook.imagepipeline.animated.base.d.e(bVar2);
            e2.j(aVar);
            e2.i(a2);
            e2.h(list);
            e2.g(bVar.f2706j);
            com.facebook.imagepipeline.image.a aVar2 = new com.facebook.imagepipeline.image.a(e2.a());
            com.facebook.common.references.a.y(aVar);
            com.facebook.common.references.a.z(list);
            return aVar2;
        } catch (Throwable th2) {
            th = th2;
            list = null;
        }
    }

    @Nullable
    private static c g(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.image.c a(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.b f2;
        if (c != null) {
            com.facebook.common.references.a<PooledByteBuffer> t = eVar.t();
            com.facebook.common.internal.h.g(t);
            try {
                PooledByteBuffer A = t.A();
                if (A.C() != null) {
                    f2 = c.d(A.C(), bVar);
                } else {
                    f2 = c.f(A.E(), A.size(), bVar);
                }
                return f(bVar, f2, config);
            } finally {
                com.facebook.common.references.a.y(t);
            }
        }
        throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.image.c b(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.b f2;
        if (f2662d != null) {
            com.facebook.common.references.a<PooledByteBuffer> t = eVar.t();
            com.facebook.common.internal.h.g(t);
            try {
                PooledByteBuffer A = t.A();
                if (A.C() != null) {
                    f2 = f2662d.d(A.C(), bVar);
                } else {
                    f2 = f2662d.f(A.E(), A.size(), bVar);
                }
                return f(bVar, f2, config);
            } finally {
                com.facebook.common.references.a.y(t);
            }
        }
        throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
    }
}
