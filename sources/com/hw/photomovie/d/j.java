package com.hw.photomovie.d;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import java.util.HashMap;
import junit.framework.Assert;
/* compiled from: UploadedTexture.java */
/* loaded from: classes2.dex */
public abstract class j extends com.hw.photomovie.d.a {
    private static HashMap<b, Bitmap> p = new HashMap<>();
    private static b q = new b();
    private static int r;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5175k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5176l;
    private boolean m;
    protected Bitmap n;
    private int o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UploadedTexture.java */
    /* loaded from: classes2.dex */
    public static class b implements Cloneable {
        public boolean a;
        public Bitmap.Config b;
        public int c;

        private b() {
        }

        /* renamed from: b */
        public b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.b.hashCode() ^ this.c;
            return this.a ? hashCode : -hashCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(boolean z) {
        super(null, 0, 0);
        this.f5175k = true;
        this.f5176l = true;
        this.m = false;
        if (z) {
            o(true);
            this.o = 1;
        }
    }

    private void q() {
        Assert.assertTrue(this.n != null);
        u(this.n);
        this.n = null;
    }

    private Bitmap r() {
        if (this.n == null) {
            Bitmap v = v();
            this.n = v;
            int width = v.getWidth() + (this.o * 2);
            int height = this.n.getHeight() + (this.o * 2);
            if (this.c == -1) {
                p(width, height);
            }
        }
        return this.n;
    }

    private static Bitmap s(boolean z, Bitmap.Config config, int i2) {
        Bitmap createBitmap;
        b bVar = q;
        bVar.a = z;
        bVar.b = config;
        bVar.c = i2;
        Bitmap bitmap = p.get(bVar);
        if (bitmap == null) {
            if (z) {
                createBitmap = Bitmap.createBitmap(1, i2, config);
            } else {
                createBitmap = Bitmap.createBitmap(i2, 1, config);
            }
            Bitmap bitmap2 = createBitmap;
            p.put(bVar.clone(), bitmap2);
            return bitmap2;
        }
        return bitmap;
    }

    private void x(f fVar) {
        Bitmap r2 = r();
        if (r2 != null && !r2.isRecycled()) {
            try {
                int width = r2.getWidth();
                int height = r2.getHeight();
                int g2 = g();
                int f2 = f();
                Assert.assertTrue(width <= g2 && height <= f2);
                this.a = fVar.f().b();
                fVar.j(this);
                if (width == g2 && height == f2) {
                    fVar.m(this, r2);
                } else {
                    int internalFormat = GLUtils.getInternalFormat(r2);
                    int type = GLUtils.getType(r2);
                    Bitmap.Config config = r2.getConfig();
                    fVar.i(this, internalFormat, type);
                    int i2 = this.o;
                    fVar.k(this, i2, i2, r2, internalFormat, type);
                    if (this.o > 0) {
                        fVar.k(this, 0, 0, s(true, config, f2), internalFormat, type);
                        fVar.k(this, 0, 0, s(false, config, g2), internalFormat, type);
                    }
                    if (this.o + width < g2) {
                        fVar.k(this, this.o + width, 0, s(true, config, f2), internalFormat, type);
                    }
                    if (this.o + height < f2) {
                        fVar.k(this, 0, this.o + height, s(false, config, g2), internalFormat, type);
                    }
                }
                q();
                n(fVar);
                this.b = 1;
                this.f5175k = true;
                return;
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        this.b = -1;
        throw new RuntimeException("Texture loadSegmentsFromFile fail, no bitmap:" + r2);
    }

    @Override // com.hw.photomovie.d.i
    public boolean b() {
        return this.f5176l;
    }

    @Override // com.hw.photomovie.d.a
    public int c() {
        if (this.c == -1) {
            r();
        }
        return this.f5157d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.d.a
    public int e() {
        return 3553;
    }

    @Override // com.hw.photomovie.d.a
    public int h() {
        if (this.c == -1) {
            r();
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.d.a
    public boolean l(f fVar) {
        w(fVar);
        return t();
    }

    @Override // com.hw.photomovie.d.a
    public void m() {
        super.m();
        if (this.n != null) {
            q();
        }
    }

    public boolean t() {
        return k() && this.f5175k;
    }

    protected abstract void u(Bitmap bitmap);

    protected abstract Bitmap v();

    public void w(f fVar) {
        if (!k()) {
            if (this.m) {
                int i2 = r + 1;
                r = i2;
                if (i2 > 100) {
                    return;
                }
            }
            if (fVar == null) {
                return;
            }
            x(fVar);
        } else if (this.f5175k) {
        } else {
            Bitmap r2 = r();
            int internalFormat = GLUtils.getInternalFormat(r2);
            int type = GLUtils.getType(r2);
            int i3 = this.o;
            fVar.k(this, i3, i3, r2, internalFormat, type);
            q();
            this.f5175k = true;
        }
    }
}
