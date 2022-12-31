package com.facebook.s.a.b.e;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.imagepipeline.bitmaps.f;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
/* compiled from: DefaultBitmapFramePreparer.java */
/* loaded from: classes.dex */
public class c implements b {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?> f3173f = c.class;
    private final f a;
    private final com.facebook.s.a.b.c b;
    private final Bitmap.Config c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f3174d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<Runnable> f3175e = new SparseArray<>();

    /* compiled from: DefaultBitmapFramePreparer.java */
    /* loaded from: classes.dex */
    private class a implements Runnable {
        private final com.facebook.s.a.b.b a;
        private final com.facebook.s.a.a.a b;
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3176d;

        public a(com.facebook.s.a.a.a aVar, com.facebook.s.a.b.b bVar, int i2, int i3) {
            this.b = aVar;
            this.a = bVar;
            this.c = i2;
            this.f3176d = i3;
        }

        private boolean a(int i2, int i3) {
            com.facebook.common.references.a<Bitmap> d2;
            int i4 = 2;
            try {
                if (i3 == 1) {
                    d2 = this.a.d(i2, this.b.e(), this.b.c());
                } else if (i3 != 2) {
                    return false;
                } else {
                    d2 = c.this.a.b(this.b.e(), this.b.c(), c.this.c);
                    i4 = -1;
                }
                boolean b = b(i2, d2, i3);
                com.facebook.common.references.a.y(d2);
                return (b || i4 == -1) ? b : a(i2, i4);
            } catch (RuntimeException e2) {
                com.facebook.common.logging.a.w(c.f3173f, "Failed to create frame bitmap", e2);
                return false;
            } finally {
                com.facebook.common.references.a.y(null);
            }
        }

        private boolean b(int i2, @Nullable com.facebook.common.references.a<Bitmap> aVar, int i3) {
            if (com.facebook.common.references.a.Q(aVar) && c.this.b.a(i2, aVar.A())) {
                com.facebook.common.logging.a.p(c.f3173f, "Frame %d ready.", Integer.valueOf(this.c));
                synchronized (c.this.f3175e) {
                    this.a.a(this.c, aVar, i3);
                }
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.a.e(this.c)) {
                    com.facebook.common.logging.a.p(c.f3173f, "Frame %d is cached already.", Integer.valueOf(this.c));
                    synchronized (c.this.f3175e) {
                        c.this.f3175e.remove(this.f3176d);
                    }
                    return;
                }
                if (a(this.c, 1)) {
                    com.facebook.common.logging.a.p(c.f3173f, "Prepared frame frame %d.", Integer.valueOf(this.c));
                } else {
                    com.facebook.common.logging.a.f(c.f3173f, "Could not prepare frame %d.", Integer.valueOf(this.c));
                }
                synchronized (c.this.f3175e) {
                    c.this.f3175e.remove(this.f3176d);
                }
            } catch (Throwable th) {
                synchronized (c.this.f3175e) {
                    c.this.f3175e.remove(this.f3176d);
                    throw th;
                }
            }
        }
    }

    public c(f fVar, com.facebook.s.a.b.c cVar, Bitmap.Config config, ExecutorService executorService) {
        this.a = fVar;
        this.b = cVar;
        this.c = config;
        this.f3174d = executorService;
    }

    private static int g(com.facebook.s.a.a.a aVar, int i2) {
        return (aVar.hashCode() * 31) + i2;
    }

    @Override // com.facebook.s.a.b.e.b
    public boolean a(com.facebook.s.a.b.b bVar, com.facebook.s.a.a.a aVar, int i2) {
        int g2 = g(aVar, i2);
        synchronized (this.f3175e) {
            if (this.f3175e.get(g2) != null) {
                com.facebook.common.logging.a.p(f3173f, "Already scheduled decode job for frame %d", Integer.valueOf(i2));
                return true;
            } else if (bVar.e(i2)) {
                com.facebook.common.logging.a.p(f3173f, "Frame %d is cached already.", Integer.valueOf(i2));
                return true;
            } else {
                a aVar2 = new a(aVar, bVar, i2, g2);
                this.f3175e.put(g2, aVar2);
                this.f3174d.execute(aVar2);
                return true;
            }
        }
    }
}
