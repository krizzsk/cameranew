package com.pinguo.album.opengles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* compiled from: NinePatchTexture.java */
/* loaded from: classes3.dex */
public class p extends r {
    private n v;
    private b<o> w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NinePatchTexture.java */
    /* loaded from: classes3.dex */
    public static class b<V> {
        private int[] a;
        private V[] b;
        private int c;

        private b() {
            this.a = new int[16];
            this.b = (V[]) new Object[16];
        }

        public void a() {
            for (int i2 = 0; i2 < this.c; i2++) {
                this.b[i2] = null;
            }
            this.c = 0;
        }

        public V b(int i2) {
            int i3 = 0;
            while (true) {
                int i4 = this.c;
                if (i3 >= i4) {
                    return null;
                }
                int[] iArr = this.a;
                if (iArr[i3] == i2) {
                    if (i4 > 8 && i3 > 0) {
                        int i5 = iArr[i3];
                        int i6 = i3 - 1;
                        iArr[i3] = iArr[i6];
                        iArr[i6] = i5;
                        V[] vArr = this.b;
                        V v = vArr[i3];
                        vArr[i3] = vArr[i6];
                        vArr[i6] = v;
                    }
                    return this.b[i3];
                }
                i3++;
            }
        }

        public V c(int i2, V v) {
            int i3 = this.c;
            if (i3 == 16) {
                V[] vArr = this.b;
                V v2 = vArr[15];
                this.a[15] = i2;
                vArr[15] = v;
                return v2;
            }
            this.a[i3] = i2;
            this.b[i3] = v;
            this.c = i3 + 1;
            return null;
        }

        public int d() {
            return this.c;
        }

        public V e(int i2) {
            return this.b[i2];
        }
    }

    public p(Context context, int i2) {
        super(context, i2);
        this.w = new b<>();
    }

    private o I(l lVar, int i2, int i3) {
        o c;
        int i4 = (i2 << 16) | i3;
        o b2 = this.w.b(i4);
        if (b2 == null && (c = this.w.c(i4, (b2 = new o(this, i2, i3)))) != null) {
            c.e(lVar);
        }
        return b2;
    }

    @Override // com.pinguo.album.opengles.r, com.pinguo.album.opengles.y
    protected Bitmap B() {
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            return bitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeResource = BitmapFactory.decodeResource(this.t.getResources(), this.u, options);
        this.o = decodeResource;
        r(decodeResource.getWidth(), decodeResource.getHeight());
        n b2 = decodeResource.getNinePatchChunk() == null ? null : n.b(decodeResource.getNinePatchChunk());
        this.v = b2;
        if (b2 != null) {
            return decodeResource;
        }
        throw new RuntimeException("invalid nine-patch image: " + this.u);
    }

    public n J() {
        if (this.v == null) {
            B();
        }
        return this.v;
    }

    @Override // com.pinguo.album.opengles.a, com.pinguo.album.opengles.u
    public void a(l lVar, int i2, int i3, int i4, int i5) {
        if (!m()) {
            this.w.a();
        }
        if (i4 == 0 || i5 == 0) {
            return;
        }
        I(lVar, i4, i5).b(lVar, this, i2, i3);
    }

    @Override // com.pinguo.album.opengles.y, com.pinguo.album.opengles.a
    public void o() {
        super.o();
        l lVar = this.f6055h;
        if (lVar == null) {
            return;
        }
        int d2 = this.w.d();
        for (int i2 = 0; i2 < d2; i2++) {
            this.w.e(i2).e(lVar);
        }
        this.w.a();
    }
}
