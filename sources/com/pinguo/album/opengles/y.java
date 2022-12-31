package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import java.util.HashMap;
/* compiled from: UploadedTexture.java */
/* loaded from: classes3.dex */
public abstract class y extends com.pinguo.album.opengles.a {
    private static HashMap<b, Bitmap> q = new HashMap<>();
    private static b r = new b();
    private static int s;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6096k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6097l;
    private boolean m;
    private boolean n;
    protected Bitmap o;
    private int p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UploadedTexture.java */
    /* loaded from: classes3.dex */
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
    public y() {
        this(false);
    }

    public static void C() {
        s = 0;
    }

    public static boolean G() {
        return s > 100;
    }

    private void H(l lVar) {
        boolean z;
        Bitmap v = v();
        if (v != null) {
            try {
                if (!v.isRecycled()) {
                    try {
                        int width = v.getWidth();
                        int height = v.getHeight();
                        int h2 = h();
                        int g2 = g();
                        this.a = lVar.f().b();
                        lVar.y(this);
                        if (width == h2 && height == g2) {
                            lVar.x(this, v);
                        } else {
                            int internalFormat = GLUtils.getInternalFormat(v);
                            int type = GLUtils.getType(v);
                            Bitmap.Config config = v.getConfig();
                            lVar.t(this, internalFormat, type);
                            int i2 = this.p;
                            lVar.u(this, i2, i2, v, internalFormat, type);
                            if (this.p > 0) {
                                z = false;
                                lVar.u(this, 0, 0, w(true, config, g2), internalFormat, type);
                                lVar.u(this, 0, 0, w(false, config, h2), internalFormat, type);
                            } else {
                                z = false;
                            }
                            if (this.p + width < h2) {
                                lVar.u(this, this.p + width, 0, w(true, config, g2), internalFormat, type);
                            }
                            if (this.p + height < g2) {
                                lVar.u(this, 0, this.p + height, w(z, config, h2), internalFormat, type);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    u();
                    p(lVar);
                    this.b = 1;
                    this.f6096k = true;
                    return;
                }
            } catch (Throwable th) {
                u();
                throw th;
            }
        }
        this.b = -1;
        throw new RuntimeException("Texture load fail, no bitmap:" + v);
    }

    private void u() {
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            A(bitmap);
        }
        this.o = null;
    }

    private Bitmap v() {
        if (this.o == null) {
            Bitmap B = B();
            this.o = B;
            int width = B.getWidth() + (this.p * 2);
            int height = this.o.getHeight() + (this.p * 2);
            if (this.c == -1) {
                r(width, height);
            }
        }
        return this.o;
    }

    private static Bitmap w(boolean z, Bitmap.Config config, int i2) {
        Bitmap createBitmap;
        b bVar = r;
        bVar.a = z;
        bVar.b = config;
        bVar.c = i2;
        Bitmap bitmap = q.get(bVar);
        if (bitmap == null) {
            if (z) {
                createBitmap = Bitmap.createBitmap(1, i2, config);
            } else {
                createBitmap = Bitmap.createBitmap(i2, 1, config);
            }
            Bitmap bitmap2 = createBitmap;
            q.put(bVar.clone(), bitmap2);
            return bitmap2;
        }
        return bitmap;
    }

    protected abstract void A(Bitmap bitmap);

    protected abstract Bitmap B();

    public void D(boolean z) {
        this.f6097l = z;
    }

    public void E(boolean z) {
        this.m = z;
    }

    public void F(l lVar) {
        if (!m()) {
            if (this.n) {
                int i2 = s + 1;
                s = i2;
                if (i2 > 100) {
                    return;
                }
            }
            if (lVar == null) {
                return;
            }
            H(lVar);
        } else if (this.f6096k) {
        } else {
            Bitmap v = v();
            int internalFormat = GLUtils.getInternalFormat(v);
            int type = GLUtils.getType(v);
            int i3 = this.p;
            lVar.u(this, i3, i3, v, internalFormat, type);
            u();
            this.f6096k = true;
        }
    }

    @Override // com.pinguo.album.opengles.u
    public boolean b() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.opengles.a
    public int f() {
        return 3553;
    }

    @Override // com.pinguo.album.opengles.a, com.pinguo.album.opengles.u
    public int getHeight() {
        if (this.c == -1) {
            v();
        }
        return this.f6051d;
    }

    @Override // com.pinguo.album.opengles.a, com.pinguo.album.opengles.u
    public int getWidth() {
        if (this.c == -1) {
            v();
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.opengles.a
    public boolean n(l lVar) {
        F(lVar);
        return y();
    }

    @Override // com.pinguo.album.opengles.a
    public void o() {
        super.o();
        if (this.o != null) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        if (this.o != null) {
            u();
        }
        this.f6096k = false;
        this.c = -1;
        this.f6051d = -1;
    }

    public boolean y() {
        return m() && this.f6096k;
    }

    public boolean z() {
        return this.f6097l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(boolean z) {
        super(null, 0, 0);
        this.f6096k = true;
        this.f6097l = false;
        this.m = true;
        this.n = false;
        if (z) {
            q(true);
            this.p = 1;
        }
    }
}
