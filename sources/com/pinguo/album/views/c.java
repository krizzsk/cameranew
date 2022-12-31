package com.pinguo.album.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.collection.LongSparseArray;
import com.pinguo.album.a;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.album.opengles.l;
import com.pinguo.album.opengles.s;
import com.pinguo.album.opengles.w;
import com.pinguo.album.opengles.y;
import com.pinguo.album.views.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: TileImageView.java */
/* loaded from: classes3.dex */
public class c extends com.pinguo.album.views.a {
    private static int M;
    protected int B;
    protected int C;
    protected float D;
    protected int E;
    private boolean I;
    private com.pinguo.album.c<Void> J;
    private final com.pinguo.album.a K;
    private boolean L;

    /* renamed from: l  reason: collision with root package name */
    private e f6116l;
    private s m;
    protected int n;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private int o = 0;
    private final RectF t = new RectF();
    private final RectF u = new RectF();
    private final LongSparseArray<b> v = new LongSparseArray<>();
    private final d w = new d();
    private final d x = new d();
    private final d y = new d();
    public int z = -1;
    public int A = -1;
    private final Rect F = new Rect();
    private final Rect[] G = {new Rect(), new Rect()};
    private final f H = new f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TileImageView.java */
    /* loaded from: classes3.dex */
    public class b extends y {
        public int t;
        public int u;
        public int v;
        public b w;
        public Bitmap x;
        public volatile int y = 1;

        public b(int i2, int i3, int i4) {
            this.t = i2;
            this.u = i3;
            this.v = i4;
        }

        @Override // com.pinguo.album.opengles.y
        protected void A(Bitmap bitmap) {
            PGAlbumBitmapPool.getInstance().e(bitmap);
        }

        @Override // com.pinguo.album.opengles.y
        protected Bitmap B() {
            com.pinguo.album.j.a.a(this.y == 8);
            c cVar = c.this;
            int i2 = cVar.z - this.t;
            int i3 = this.v;
            r(Math.min(c.M, i2 >> i3), Math.min(c.M, (cVar.A - this.u) >> i3));
            Bitmap bitmap = this.x;
            this.x = null;
            this.y = 1;
            return bitmap;
        }

        boolean I() {
            try {
                this.x = com.pinguo.album.data.utils.a.g(c.this.f6116l.l(this.v, this.t, this.u, c.M));
            } catch (Throwable th) {
                us.pinguo.common.log.a.f(th);
            }
            return this.x != null;
        }

        public b J() {
            if (this.v + 1 == c.this.n) {
                return null;
            }
            int i2 = c.M;
            int i3 = this.v;
            int i4 = i2 << (i3 + 1);
            return c.this.S((this.t / i4) * i4, i4 * (this.u / i4), i3 + 1);
        }

        public void K(int i2, int i3, int i4) {
            this.t = i2;
            this.u = i3;
            this.v = i4;
            x();
        }

        @Override // com.pinguo.album.opengles.a
        public int g() {
            return c.M;
        }

        @Override // com.pinguo.album.opengles.a
        public int h() {
            return c.M;
        }

        public String toString() {
            return String.format("tile(%s, %s, %s / %s)", Integer.valueOf(this.t / c.M), Integer.valueOf(this.u / c.M), Integer.valueOf(c.this.o), Integer.valueOf(c.this.n));
        }
    }

    /* compiled from: TileImageView.java */
    /* renamed from: com.pinguo.album.views.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0233c implements a.b<Void> {
        private a.InterfaceC0229a a;

        /* compiled from: TileImageView.java */
        /* renamed from: com.pinguo.album.views.c$c$a */
        /* loaded from: classes3.dex */
        class a implements a.InterfaceC0229a {
            a() {
            }

            @Override // com.pinguo.album.a.InterfaceC0229a
            public void onCancel() {
                synchronized (c.this) {
                    c.this.notifyAll();
                }
            }
        }

        private C0233c() {
            this.a = new a();
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public Void a(a.c cVar) {
            b b;
            cVar.b(0);
            cVar.a(this.a);
            while (!cVar.isCancelled()) {
                synchronized (c.this) {
                    b = c.this.y.b();
                    if (b == null && !cVar.isCancelled()) {
                        com.pinguo.album.j.a.r(c.this);
                    }
                }
                if (b != null && c.this.M(b)) {
                    c.this.d0(b);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TileImageView.java */
    /* loaded from: classes3.dex */
    public static class d {
        private b a;

        private d() {
        }

        public void a() {
            this.a = null;
        }

        public b b() {
            b bVar = this.a;
            if (bVar != null) {
                this.a = bVar.w;
            }
            return bVar;
        }

        public boolean c(b bVar) {
            b bVar2 = this.a;
            boolean z = bVar2 == null;
            bVar.w = bVar2;
            this.a = bVar;
            return z;
        }
    }

    /* compiled from: TileImageView.java */
    /* loaded from: classes3.dex */
    public interface e {
        int b();

        int h();

        s j();

        int k();

        Bitmap l(int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TileImageView.java */
    /* loaded from: classes3.dex */
    public class f implements b.a {
        AtomicBoolean a;

        private f() {
            this.a = new AtomicBoolean(false);
        }

        @Override // com.pinguo.album.views.b.a
        public void a() {
            this.a.set(false);
        }

        @Override // com.pinguo.album.views.b.a
        public boolean b(l lVar, boolean z) {
            if (z) {
                return true;
            }
            b bVar = null;
            int i2 = 1;
            while (i2 > 0) {
                synchronized (c.this) {
                    bVar = c.this.x.b();
                }
                if (bVar == null) {
                    break;
                } else if (!bVar.y()) {
                    boolean m = bVar.m();
                    bVar.F(lVar);
                    if (!m) {
                        bVar.c(lVar, 0, 0);
                    }
                    i2--;
                }
            }
            if (bVar == null) {
                this.a.set(false);
            }
            return bVar != null;
        }
    }

    public c(Context context, com.pinguo.album.a aVar) {
        this.K = aVar;
        this.J = aVar.a(new C0233c());
        if (M == 0) {
            if (U(context)) {
                M = 512;
            } else {
                M = 256;
            }
        }
    }

    private void L(int i2, int i3, int i4) {
        long Y = Y(i2, i3, i4);
        b bVar = this.v.get(Y);
        if (bVar != null) {
            if (bVar.y == 2) {
                bVar.y = 1;
                return;
            }
            return;
        }
        this.v.put(Y, a0(i2, i3, i4));
    }

    static boolean O(b bVar, l lVar, RectF rectF, RectF rectF2) {
        while (!bVar.y()) {
            b J = bVar.J();
            if (J == null) {
                return false;
            }
            if (bVar.t == J.t) {
                rectF.left /= 2.0f;
                rectF.right /= 2.0f;
            } else {
                int i2 = M;
                rectF.left = (i2 + rectF.left) / 2.0f;
                rectF.right = (i2 + rectF.right) / 2.0f;
            }
            if (bVar.u == J.u) {
                rectF.top /= 2.0f;
                rectF.bottom /= 2.0f;
            } else {
                int i3 = M;
                rectF.top = (i3 + rectF.top) / 2.0f;
                rectF.bottom = (i3 + rectF.bottom) / 2.0f;
            }
            bVar = J;
        }
        lVar.i(bVar, rectF, rectF2);
        return true;
    }

    private void Q(Rect rect, int i2, int i3, int i4, float f2, int i5) {
        double radians = Math.toRadians(-i5);
        double p = p();
        double n = n();
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d2 = cos * p;
        double d3 = sin * n;
        double d4 = sin * p;
        double d5 = cos * n;
        float ceil = (int) Math.ceil(Math.max(Math.abs(d2 - d3), Math.abs(d2 + d3)));
        float f3 = 2.0f * f2;
        int floor = (int) Math.floor(i2 - (ceil / f3));
        float ceil2 = (int) Math.ceil(Math.max(Math.abs(d4 + d5), Math.abs(d4 - d5)));
        int floor2 = (int) Math.floor(i3 - (ceil2 / f3));
        int ceil3 = (int) Math.ceil(floor + (ceil / f2));
        int ceil4 = (int) Math.ceil(floor2 + (ceil2 / f2));
        int i6 = M << i4;
        rect.set(Math.max(0, (floor / i6) * i6), Math.max(0, i6 * (floor2 / i6)), Math.min(this.z, ceil3), Math.min(this.A, ceil4));
    }

    private void R(Rect rect, int i2, int i3, int i4, int i5) {
        Q(rect, i2, i3, i4, 1.0f / (1 << (i4 + 1)), i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b S(int i2, int i3, int i4) {
        return this.v.get(Y(i2, i3, i4));
    }

    public static boolean U(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels > 2048 || displayMetrics.widthPixels > 2048;
    }

    private boolean W() {
        s sVar = this.m;
        return (sVar instanceof w) && ((w) sVar).d();
    }

    private void X(int i2, int i3, float f2, int i4) {
        int i5;
        Rect rect;
        int p = p();
        int n = n();
        int i6 = 0;
        int e2 = com.pinguo.album.j.a.e(com.pinguo.album.j.a.l(1.0f / f2), 0, this.n);
        this.o = e2;
        if (e2 != this.n) {
            Q(this.F, i2, i3, e2, f2, i4);
            this.p = Math.round((p / 2.0f) + ((rect.left - i2) * f2));
            this.q = Math.round((n / 2.0f) + ((rect.top - i3) * f2));
            i5 = this.o;
            if ((1 << i5) * f2 > 0.75f) {
                i5--;
            }
        } else {
            i5 = e2 - 2;
            this.p = Math.round((p / 2.0f) - (i2 * f2));
            this.q = Math.round((n / 2.0f) - (i3 * f2));
        }
        int max = Math.max(0, Math.min(i5, this.n - 2));
        int min = Math.min(max + 2, this.n);
        Rect[] rectArr = this.G;
        for (int i7 = max; i7 < min; i7++) {
            R(rectArr[i7 - max], i2, i3, i7, i4);
        }
        if (i4 % 90 != 0) {
            return;
        }
        synchronized (this) {
            this.y.a();
            this.x.a();
            this.L = false;
            int size = this.v.size();
            while (i6 < size) {
                b valueAt = this.v.valueAt(i6);
                int i8 = valueAt.v;
                if (i8 < max || i8 >= min || !rectArr[i8 - max].contains(valueAt.t, valueAt.u)) {
                    this.v.removeAt(i6);
                    i6--;
                    size--;
                    e0(valueAt);
                }
                i6++;
            }
        }
        for (int i9 = max; i9 < min; i9++) {
            int i10 = M << i9;
            Rect rect2 = rectArr[i9 - max];
            int i11 = rect2.bottom;
            for (int i12 = rect2.top; i12 < i11; i12 += i10) {
                int i13 = rect2.right;
                for (int i14 = rect2.left; i14 < i13; i14 += i10) {
                    L(i14, i12, i9);
                }
            }
        }
        q();
    }

    private static long Y(int i2, int i3, int i4) {
        return (((i2 << 16) | i3) << 16) | i4;
    }

    private synchronized b a0(int i2, int i3, int i4) {
        b b2 = this.w.b();
        if (b2 != null) {
            b2.y = 1;
            b2.K(i2, i3, i4);
            return b2;
        }
        return new b(i2, i3, i4);
    }

    private void i0(l lVar) {
        this.L = true;
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = this.v.valueAt(i2);
            if (!valueAt.y()) {
                c0(valueAt);
            }
        }
    }

    boolean M(b bVar) {
        synchronized (this) {
            if (bVar.y != 2) {
                return false;
            }
            bVar.y = 4;
            boolean I = bVar.I();
            synchronized (this) {
                if (bVar.y == 32) {
                    bVar.y = 64;
                    if (bVar.x != null) {
                        PGAlbumBitmapPool.getInstance().e(bVar.x);
                        bVar.x = null;
                    }
                    this.w.c(bVar);
                    return false;
                }
                bVar.y = I ? 8 : 16;
                return I;
            }
        }
    }

    public void N(l lVar, int i2, int i3, int i4, float f2, float f3, float f4) {
        RectF rectF = this.t;
        RectF rectF2 = this.u;
        rectF2.set(f2, f3, f2 + f4, f4 + f3);
        int i5 = M;
        rectF.set(0.0f, 0.0f, i5, i5);
        b S = S(i2, i3, i4);
        if (S != null) {
            if (!S.y()) {
                if (S.y == 8) {
                    int i6 = this.r;
                    if (i6 > 0) {
                        this.r = i6 - 1;
                        S.F(lVar);
                    } else {
                        this.s = false;
                    }
                } else if (S.y != 16) {
                    this.s = false;
                    c0(S);
                }
            }
            if (O(S, lVar, rectF, rectF2)) {
                return;
            }
        }
        s sVar = this.m;
        if (sVar != null) {
            int i7 = M << i4;
            float width = sVar.getWidth() / this.z;
            float height = this.m.getHeight() / this.A;
            rectF.set(i2 * width, i3 * height, (i2 + i7) * width, (i3 + i7) * height);
            this.m.c(lVar, rectF, rectF2);
        }
    }

    public void P() {
        this.I = true;
        com.pinguo.album.c<Void> cVar = this.J;
        if (cVar != null) {
            cVar.cancel();
            this.J.get();
            this.J = null;
        }
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.v.valueAt(i2).o();
        }
        this.v.clear();
        this.F.set(0, 0, 0, 0);
        synchronized (this) {
            this.x.a();
            this.y.a();
            b b2 = this.w.b();
            while (b2 != null) {
                b2.o();
                b2 = this.w.b();
            }
        }
        h0(null);
    }

    protected synchronized void T() {
        this.y.a();
        this.x.a();
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            e0(this.v.valueAt(i2));
        }
        this.v.clear();
    }

    public boolean V() {
        s sVar = this.m;
        return (sVar instanceof com.pinguo.album.opengles.b) && ((com.pinguo.album.opengles.b) sVar).g();
    }

    public void Z() {
        T();
        e eVar = this.f6116l;
        if (eVar == null) {
            this.m = null;
            this.z = 0;
            this.A = 0;
            this.n = 0;
        } else {
            h0(eVar.j());
            this.z = this.f6116l.k();
            this.A = this.f6116l.h();
            this.n = this.f6116l.b();
        }
        X(this.B, this.C, this.D, this.E);
        q();
    }

    public void b0() {
        if (this.J == null) {
            this.J = this.K.a(new C0233c());
        }
        if (this.I) {
            X(this.B, this.C, this.D, this.E);
            this.I = false;
            e eVar = this.f6116l;
            h0(eVar != null ? eVar.j() : null);
        }
    }

    synchronized void c0(b bVar) {
        if (bVar.y == 1) {
            bVar.y = 2;
            if (this.y.c(bVar)) {
                notifyAll();
            }
        }
    }

    void d0(b bVar) {
        synchronized (this) {
            this.x.c(bVar);
        }
        if (this.H.a.compareAndSet(false, true)) {
            m().j(this.H);
        }
    }

    synchronized void e0(b bVar) {
        if (bVar.y == 4) {
            bVar.y = 32;
            return;
        }
        bVar.y = 64;
        if (bVar.x != null) {
            PGAlbumBitmapPool.getInstance().e(bVar.x);
            bVar.x = null;
        }
        this.w.c(bVar);
    }

    public void f0(e eVar) {
        this.f6116l = eVar;
        if (eVar != null) {
            Z();
        }
    }

    public boolean g0(int i2, int i3, float f2, int i4) {
        if (this.B == i2 && this.C == i3 && this.D == f2 && this.E == i4) {
            return false;
        }
        this.B = i2;
        this.C = i3;
        this.D = f2;
        this.E = i4;
        X(i2, i3, f2, i4);
        q();
        return true;
    }

    public void h0(s sVar) {
        this.m = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.views.a
    public void v(boolean z, int i2, int i3, int i4, int i5) {
        super.v(z, i2, i3, i4, i5);
        if (z) {
            X(this.B, this.C, this.D, this.E);
        }
    }

    @Override // com.pinguo.album.views.a
    public void y(l lVar) {
        this.r = 1;
        this.s = true;
        int i2 = this.o;
        int i3 = this.E;
        int i4 = i3 != 0 ? 2 : 0;
        if (i4 != 0) {
            lVar.s(i4);
            if (i3 != 0) {
                int p = p() / 2;
                int n = n() / 2;
                lVar.a(p, n);
                lVar.v(i3, 0.0f, 0.0f, 1.0f);
                lVar.a(-p, -n);
            }
        }
        try {
            if (i2 != this.n && !W()) {
                s sVar = this.m;
                if (sVar != null) {
                    sVar.b();
                }
                int i5 = M << i2;
                float f2 = i5 * this.D;
                Rect rect = this.F;
                int i6 = rect.top;
                int i7 = 0;
                while (i6 < rect.bottom) {
                    float f3 = this.q + (i7 * f2);
                    int i8 = rect.left;
                    int i9 = 0;
                    while (i8 < rect.right) {
                        N(lVar, i8, i6, i2, this.p + (i9 * f2), f3, f2);
                        i8 += i5;
                        i9++;
                        i7 = i7;
                        i6 = i6;
                    }
                    i6 += i5;
                    i7++;
                }
            } else {
                s sVar2 = this.m;
                if (sVar2 != null) {
                    sVar2.a(lVar, this.p, this.q, Math.round(this.z * this.D), Math.round(this.A * this.D));
                    if (W()) {
                        q();
                    }
                }
            }
            if (this.s) {
                if (this.L) {
                    return;
                }
                i0(lVar);
                return;
            }
            q();
        } finally {
            if (i4 != 0) {
                lVar.b();
            }
        }
    }
}
