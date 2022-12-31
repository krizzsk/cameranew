package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.core.view.MotionEventCompat;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes9.dex */
public class l implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float G = 3.0f;
    private static float H = 1.75f;
    private static float I = 1.0f;
    private static int J = 200;
    private static int K = 1;
    private float A;
    private m D;
    private com.github.chrisbanes.photoview.c E;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f3301h;

    /* renamed from: i  reason: collision with root package name */
    private GestureDetector f3302i;

    /* renamed from: j  reason: collision with root package name */
    private com.github.chrisbanes.photoview.b f3303j;
    private com.github.chrisbanes.photoview.e p;
    private g q;
    private f r;
    private k s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private h v;
    private i w;
    private j x;
    private e y;
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = J;
    private float c = I;

    /* renamed from: d  reason: collision with root package name */
    private float f3297d = H;

    /* renamed from: e  reason: collision with root package name */
    private float f3298e = G;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3299f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3300g = false;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f3304k = new Matrix();

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f3305l = new Matrix();
    private final Matrix m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int z = 2;
    private boolean B = true;
    private int C = ImageView.ScaleType.FIT_CENTER.ordinal();
    private com.github.chrisbanes.photoview.d F = new a();

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes9.dex */
    class a implements com.github.chrisbanes.photoview.d {
        a() {
        }

        @Override // com.github.chrisbanes.photoview.d
        public void a(float f2, float f3) {
            if (l.this.f3303j.e()) {
                return;
            }
            if (l.this.x != null) {
                l.this.x.a(f2, f3);
            }
            l.this.m.postTranslate(f2, f3);
            l.this.C();
            ViewParent parent = l.this.f3301h.getParent();
            if (!l.this.f3299f || l.this.f3303j.e() || l.this.f3300g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((l.this.z == 2 || ((l.this.z == 0 && f2 >= 1.0f) || (l.this.z == 1 && f2 <= -1.0f))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // com.github.chrisbanes.photoview.d
        public void b(float f2, float f3, float f4) {
            if (l.this.N() < l.this.f3298e || f2 < 1.0f) {
                if (l.this.N() > l.this.c || f2 > 1.0f) {
                    if (l.this.v != null) {
                        l.this.v.a(f2, f3, f4);
                    }
                    l.this.m.postScale(f2, f2, f3, f4);
                    l.this.C();
                }
            }
        }

        @Override // com.github.chrisbanes.photoview.d
        public void c(float f2, float f3, float f4, float f5) {
            l lVar = l.this;
            lVar.y = new e(lVar.f3301h.getContext());
            e eVar = l.this.y;
            l lVar2 = l.this;
            int J = lVar2.J(lVar2.f3301h);
            l lVar3 = l.this;
            eVar.b(J, lVar3.I(lVar3.f3301h), (int) f4, (int) f5);
            l.this.f3301h.post(l.this.y);
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes9.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (l.this.w == null || l.this.N() > l.I || MotionEventCompat.getPointerCount(motionEvent) > l.K || MotionEventCompat.getPointerCount(motionEvent2) > l.K) {
                return false;
            }
            return l.this.w.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (l.this.u != null) {
                l.this.u.onLongClick(l.this.f3301h);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes9.dex */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            float N;
            float x;
            float y;
            try {
                N = l.this.N();
                x = motionEvent.getX();
                y = motionEvent.getY();
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (l.this.E == null || !l.this.E.a(l.this, N, x, y)) {
                if (N < l.this.L()) {
                    l lVar = l.this;
                    lVar.k0(lVar.L(), x, y, true);
                } else if (N >= l.this.L() && N < l.this.K()) {
                    l lVar2 = l.this;
                    lVar2.k0(lVar2.K(), x, y, true);
                } else {
                    l lVar3 = l.this;
                    lVar3.k0(lVar3.M(), x, y, true);
                }
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (l.this.t != null) {
                l.this.t.onClick(l.this.f3301h);
            }
            RectF E = l.this.E();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (l.this.s != null) {
                l.this.s.a(l.this.f3301h, x, y);
            }
            if (E != null) {
                if (!E.contains(x, y)) {
                    if (l.this.r != null) {
                        l.this.r.a(l.this.f3301h);
                        return false;
                    }
                    return false;
                }
                float width = (x - E.left) / E.width();
                float height = (y - E.top) / E.height();
                if (l.this.q != null) {
                    l.this.q.a(l.this.f3301h, width, height);
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        private final float a;
        private final float b;
        private final long c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f3306d;

        /* renamed from: e  reason: collision with root package name */
        private final float f3307e;

        public d(float f2, float f3, float f4, float f5) {
            this.a = f4;
            this.b = f5;
            this.f3306d = f2;
            this.f3307e = f3;
        }

        private float a() {
            return l.this.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.c)) * 1.0f) / l.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a = a();
            float f2 = this.f3306d;
            l.this.F.b((f2 + ((this.f3307e - f2) * a)) / l.this.N(), this.a, this.b);
            if (a < 1.0f) {
                com.github.chrisbanes.photoview.a.a(l.this.f3301h, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes9.dex */
    public class e implements Runnable {
        private final OverScroller a;
        private int b;
        private int c;

        public e(Context context) {
            this.a = new OverScroller(context);
        }

        public void a() {
            this.a.forceFinished(true);
        }

        public void b(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF E = l.this.E();
            if (E == null) {
                return;
            }
            int round = Math.round(-E.left);
            float f2 = i2;
            if (f2 < E.width()) {
                i7 = Math.round(E.width() - f2);
                i6 = 0;
            } else {
                i6 = round;
                i7 = i6;
            }
            int round2 = Math.round(-E.top);
            float f3 = i3;
            if (f3 < E.height()) {
                i9 = Math.round(E.height() - f3);
                i8 = 0;
            } else {
                i8 = round2;
                i9 = i8;
            }
            this.b = round;
            this.c = round2;
            if (round == i7 && round2 == i9) {
                return;
            }
            this.a.fling(round, round2, i4, i5, i6, i7, i8, i9, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                l.this.m.postTranslate(this.b - currX, this.c - currY);
                l.this.C();
                this.b = currX;
                this.c = currY;
                com.github.chrisbanes.photoview.a.a(l.this.f3301h, this);
            }
        }
    }

    public l(ImageView imageView) {
        this.f3301h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.A = 0.0f;
        this.f3303j = new com.github.chrisbanes.photoview.b(imageView.getContext(), this.F);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f3302i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private void B() {
        e eVar = this.y;
        if (eVar != null) {
            eVar.a();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (D()) {
            T(G());
        }
    }

    private boolean D() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF F = F(G());
        if (F == null) {
            return false;
        }
        float height = F.height();
        float width = F.width();
        float I2 = I(this.f3301h);
        float f7 = 0.0f;
        if (height <= I2) {
            if (this.C == ImageView.ScaleType.FIT_START.ordinal()) {
                f2 = F.top;
                f4 = -f2;
            } else {
                if (this.C == ImageView.ScaleType.FIT_END.ordinal()) {
                    I2 -= height;
                    f3 = F.top;
                } else {
                    I2 = (I2 - height) / 2.0f;
                    f3 = F.top;
                }
                f4 = I2 - f3;
            }
        } else {
            f2 = F.top;
            if (f2 <= 0.0f) {
                f3 = F.bottom;
                if (f3 >= I2) {
                    f4 = 0.0f;
                }
                f4 = I2 - f3;
            }
            f4 = -f2;
        }
        float J2 = J(this.f3301h);
        if (width <= J2) {
            if (this.C == ImageView.ScaleType.FIT_START.ordinal()) {
                f7 = -F.left;
            } else {
                if (this.C == ImageView.ScaleType.FIT_END.ordinal()) {
                    f5 = J2 - width;
                    f6 = F.left;
                } else {
                    f5 = (J2 - width) / 2.0f;
                    f6 = F.left;
                }
                f7 = f5 - f6;
            }
            this.z = 2;
        } else {
            float f8 = F.left;
            if (f8 > 0.0f) {
                this.z = 0;
                f7 = -f8;
            } else {
                float f9 = F.right;
                if (f9 < J2) {
                    f7 = J2 - f9;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.m.postTranslate(f7, f4);
        return true;
    }

    private RectF F(Matrix matrix) {
        Drawable drawable = this.f3301h.getDrawable();
        if (drawable != null) {
            this.n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.n);
            return this.n;
        }
        return null;
    }

    private Matrix G() {
        this.f3305l.set(this.f3304k);
        this.f3305l.postConcat(this.m);
        return this.f3305l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float P(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private void Q() {
        this.m.reset();
        h0(this.A);
        T(G());
        D();
    }

    private void T(Matrix matrix) {
        RectF F;
        this.f3301h.setImageMatrix(matrix);
        if (this.p == null || (F = F(matrix)) == null) {
            return;
        }
        this.p.a(F);
    }

    private void s0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float J2 = J(this.f3301h);
        float I2 = I(this.f3301h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f3304k.reset();
        float f2 = intrinsicWidth;
        float f3 = J2 / f2;
        float f4 = intrinsicHeight;
        float f5 = I2 / f4;
        if (this.C == ImageView.ScaleType.CENTER.ordinal()) {
            this.f3304k.postTranslate((J2 - f2) / 2.0f, (I2 - f4) / 2.0f);
        } else if (this.C == ImageView.ScaleType.CENTER_CROP.ordinal()) {
            float max = Math.max(f3, f5);
            this.f3304k.postScale(max, max);
            this.f3304k.postTranslate((J2 - (f2 * max)) / 2.0f, (I2 - (f4 * max)) / 2.0f);
        } else if (this.C == ImageView.ScaleType.CENTER_INSIDE.ordinal()) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.f3304k.postScale(min, min);
            this.f3304k.postTranslate((J2 - (f2 * min)) / 2.0f, (I2 - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, J2, I2);
            if (((int) this.A) % BaseBlurEffect.ROTATION_180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            if (this.C == ImageView.ScaleType.FIT_CENTER.ordinal()) {
                this.f3304k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (this.C == ImageView.ScaleType.FIT_START.ordinal()) {
                this.f3304k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (this.C == ImageView.ScaleType.FIT_END.ordinal()) {
                this.f3304k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (this.C == ImageView.ScaleType.FIT_XY.ordinal()) {
                this.f3304k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            } else {
                m mVar = this.D;
                if (mVar != null) {
                    mVar.a(rectF, rectF2, this.f3304k, this.C);
                }
            }
        }
        Q();
    }

    public RectF E() {
        D();
        return F(G());
    }

    public Matrix H() {
        return this.f3305l;
    }

    public float K() {
        return this.f3298e;
    }

    public float L() {
        return this.f3297d;
    }

    public float M() {
        return this.c;
    }

    public float N() {
        return (float) Math.sqrt(((float) Math.pow(P(this.m, 0), 2.0d)) + ((float) Math.pow(P(this.m, 3), 2.0d)));
    }

    public int O() {
        return this.C;
    }

    public void R(boolean z) {
        this.f3299f = z;
    }

    public void S(com.github.chrisbanes.photoview.c cVar) {
        this.E = cVar;
    }

    public void U(float f2) {
        n.a(this.c, this.f3297d, f2);
        this.f3298e = f2;
    }

    public void V(float f2) {
        n.a(this.c, f2, this.f3298e);
        this.f3297d = f2;
    }

    public void W(float f2) {
        n.a(f2, this.f3297d, this.f3298e);
        this.c = f2;
    }

    public void X(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void Y(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f3302i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void Z(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void a0(com.github.chrisbanes.photoview.e eVar) {
        this.p = eVar;
    }

    public void b0(f fVar) {
        this.r = fVar;
    }

    public void c0(g gVar) {
        this.q = gVar;
    }

    public void d0(h hVar) {
        this.v = hVar;
    }

    public void e0(i iVar) {
        this.w = iVar;
    }

    public void f0(j jVar) {
        this.x = jVar;
    }

    public void g0(k kVar) {
        this.s = kVar;
    }

    public void h0(float f2) {
        this.m.postRotate(f2 % 360.0f);
        C();
    }

    public void i0(float f2) {
        this.m.setRotate(f2 % 360.0f);
        C();
    }

    public void j0(float f2) {
        l0(f2, false);
    }

    public void k0(float f2, float f3, float f4, boolean z) {
        if (f2 < this.c || f2 > this.f3298e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.f3301h.post(new d(N(), f2, f3, f4));
            return;
        }
        this.m.setScale(f2, f2, f3, f4);
        C();
    }

    public void l0(float f2, boolean z) {
        k0(f2, this.f3301h.getRight() / 2, this.f3301h.getBottom() / 2, z);
    }

    public void m0(float f2, float f3, float f4) {
        n.a(f2, f3, f4);
        this.c = f2;
        this.f3297d = f3;
        this.f3298e = f4;
    }

    public void n0(int i2) {
        if (!n.e(i2) || i2 == this.C) {
            return;
        }
        this.C = i2;
        r0();
    }

    public void o0(m mVar) {
        this.D = mVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        s0(this.f3301h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.B
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.github.chrisbanes.photoview.n.d(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.N()
            float r3 = r10.c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L7a
            com.github.chrisbanes.photoview.l$d r9 = new com.github.chrisbanes.photoview.l$d
            float r5 = r10.N()
            float r6 = r10.c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.N()
            float r3 = r10.f3298e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L7a
            com.github.chrisbanes.photoview.l$d r9 = new com.github.chrisbanes.photoview.l$d
            float r5 = r10.N()
            float r6 = r10.f3298e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = 1
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.B()
        L7a:
            r11 = 0
        L7b:
            com.github.chrisbanes.photoview.b r0 = r10.f3303j
            if (r0 == 0) goto Lb2
            boolean r11 = r0.e()
            com.github.chrisbanes.photoview.b r0 = r10.f3303j
            boolean r0 = r0.d()
            com.github.chrisbanes.photoview.b r3 = r10.f3303j
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L9b
            com.github.chrisbanes.photoview.b r11 = r10.f3303j
            boolean r11 = r11.e()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            com.github.chrisbanes.photoview.b r0 = r10.f3303j
            boolean r0 = r0.d()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.f3300g = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.f3302i
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p0(int i2) {
        this.b = i2;
    }

    public void q0(boolean z) {
        this.B = z;
        r0();
    }

    public void r0() {
        if (this.B) {
            s0(this.f3301h.getDrawable());
        } else {
            Q();
        }
    }
}
