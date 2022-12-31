package us.pinguo.inspire.widget.photopager;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes9.dex */
public class TouchImageView extends PhotoImageView {
    private View.OnTouchListener A;
    private f B;
    private float a;
    private Matrix b;
    private Matrix c;

    /* renamed from: d  reason: collision with root package name */
    private State f11389d;

    /* renamed from: e  reason: collision with root package name */
    private float f11390e;

    /* renamed from: f  reason: collision with root package name */
    private float f11391f;

    /* renamed from: g  reason: collision with root package name */
    private float f11392g;

    /* renamed from: h  reason: collision with root package name */
    private float f11393h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f11394i;

    /* renamed from: j  reason: collision with root package name */
    private Context f11395j;

    /* renamed from: k  reason: collision with root package name */
    private d f11396k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView.ScaleType f11397l;
    private boolean m;
    private boolean n;
    private i o;
    private int p;
    private int q;
    private int r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private ScaleGestureDetector x;
    private GestureDetector y;
    private GestureDetector.OnDoubleTapListener z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    /* loaded from: classes9.dex */
    public class b {
        Scroller a;
        OverScroller b;
        boolean c;

        public b(TouchImageView touchImageView, Context context) {
            if (Build.VERSION.SDK_INT < 9) {
                this.c = true;
                this.a = new Scroller(context);
                return;
            }
            this.c = false;
            this.b = new OverScroller(context);
        }

        public boolean a() {
            if (this.c) {
                return this.a.computeScrollOffset();
            }
            this.b.computeScrollOffset();
            return this.b.computeScrollOffset();
        }

        public void b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (this.c) {
                this.a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            } else {
                this.b.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            }
        }

        public void c(boolean z) {
            if (this.c) {
                this.a.forceFinished(z);
            } else {
                this.b.forceFinished(z);
            }
        }

        public int d() {
            if (this.c) {
                return this.a.getCurrX();
            }
            return this.b.getCurrX();
        }

        public int e() {
            if (this.c) {
                return this.a.getCurrY();
            }
            return this.b.getCurrY();
        }

        public boolean f() {
            if (this.c) {
                return this.a.isFinished();
            }
            return this.b.isFinished();
        }
    }

    /* loaded from: classes9.dex */
    private class c implements Runnable {
        private long a;
        private float b;
        private float c;

        /* renamed from: d  reason: collision with root package name */
        private float f11398d;

        /* renamed from: e  reason: collision with root package name */
        private float f11399e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11400f;

        /* renamed from: g  reason: collision with root package name */
        private AccelerateDecelerateInterpolator f11401g = new AccelerateDecelerateInterpolator();

        /* renamed from: h  reason: collision with root package name */
        private PointF f11402h;

        /* renamed from: i  reason: collision with root package name */
        private PointF f11403i;

        c(float f2, float f3, float f4, boolean z) {
            TouchImageView.this.S(State.ANIMATE_ZOOM);
            this.a = System.currentTimeMillis();
            this.b = TouchImageView.this.a;
            this.c = f2;
            this.f11400f = z;
            PointF W = TouchImageView.this.W(f3, f4, false);
            float f5 = W.x;
            this.f11398d = f5;
            float f6 = W.y;
            this.f11399e = f6;
            this.f11402h = TouchImageView.this.V(f5, f6);
            this.f11403i = new PointF(TouchImageView.this.p / 2, TouchImageView.this.q / 2);
        }

        private double a(float f2) {
            float f3 = this.b;
            return (f3 + (f2 * (this.c - f3))) / TouchImageView.this.a;
        }

        private float b() {
            return this.f11401g.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.a)) / 500.0f));
        }

        private void c(float f2) {
            PointF pointF = this.f11402h;
            float f3 = pointF.x;
            PointF pointF2 = this.f11403i;
            float f4 = f3 + ((pointF2.x - f3) * f2);
            float f5 = pointF.y;
            float f6 = f5 + (f2 * (pointF2.y - f5));
            PointF V = TouchImageView.this.V(this.f11398d, this.f11399e);
            TouchImageView.this.b.postTranslate(f4 - V.x, f6 - V.y);
        }

        @Override // java.lang.Runnable
        public void run() {
            float b = b();
            TouchImageView.this.R(a(b), this.f11398d, this.f11399e, this.f11400f);
            c(b);
            TouchImageView.this.F();
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.setImageMatrix(touchImageView.b);
            if (TouchImageView.this.B != null) {
                TouchImageView.this.B.a();
            }
            if (b < 1.0f) {
                TouchImageView.this.C(this);
            } else {
                TouchImageView.this.S(State.NONE);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class d implements Runnable {
        b a;
        int b;
        int c;

        d(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            TouchImageView.this.S(State.FLING);
            this.a = new b(TouchImageView.this, TouchImageView.this.f11395j);
            TouchImageView.this.b.getValues(TouchImageView.this.f11394i);
            int i8 = (int) TouchImageView.this.f11394i[2];
            int i9 = (int) TouchImageView.this.f11394i[5];
            if (TouchImageView.this.L() > TouchImageView.this.p) {
                i4 = TouchImageView.this.p - ((int) TouchImageView.this.L());
                i5 = 0;
            } else {
                i4 = i8;
                i5 = i4;
            }
            if (TouchImageView.this.K() > TouchImageView.this.q) {
                i6 = TouchImageView.this.q - ((int) TouchImageView.this.K());
                i7 = 0;
            } else {
                i6 = i9;
                i7 = i6;
            }
            this.a.b(i8, i9, i2, i3, i4, i5, i6, i7);
            this.b = i8;
            this.c = i9;
        }

        public void a() {
            if (this.a != null) {
                TouchImageView.this.S(State.NONE);
                this.a.c(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchImageView.this.B != null) {
                TouchImageView.this.B.a();
            }
            if (this.a.f()) {
                this.a = null;
            } else if (this.a.a()) {
                int d2 = this.a.d();
                int e2 = this.a.e();
                int i2 = d2 - this.b;
                int i3 = e2 - this.c;
                this.b = d2;
                this.c = e2;
                TouchImageView.this.b.postTranslate(i2, i3);
                TouchImageView.this.G();
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.setImageMatrix(touchImageView.b);
                TouchImageView.this.C(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        private e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = TouchImageView.this.z != null ? TouchImageView.this.z.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.f11389d == State.NONE) {
                TouchImageView.this.C(new c(TouchImageView.this.a == TouchImageView.this.f11390e ? TouchImageView.this.f11391f : TouchImageView.this.f11390e, motionEvent.getX(), motionEvent.getY(), false));
                return true;
            }
            return onDoubleTap;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageView.this.z != null) {
                return TouchImageView.this.z.onDoubleTapEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (TouchImageView.this.f11396k != null) {
                TouchImageView.this.f11396k.a();
            }
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.f11396k = new d((int) f2, (int) f3);
            TouchImageView touchImageView2 = TouchImageView.this;
            touchImageView2.C(touchImageView2.f11396k);
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (TouchImageView.this.z != null) {
                return TouchImageView.this.z.onSingleTapConfirmed(motionEvent);
            }
            return TouchImageView.this.performClick();
        }

        /* synthetic */ e(TouchImageView touchImageView, a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class h extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private h() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.R(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (TouchImageView.this.B != null) {
                TouchImageView.this.B.a();
                return true;
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.S(State.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.S(State.NONE);
            float f2 = TouchImageView.this.a;
            boolean z = true;
            if (TouchImageView.this.a > TouchImageView.this.f11391f) {
                f2 = TouchImageView.this.f11391f;
            } else if (TouchImageView.this.a < TouchImageView.this.f11390e) {
                f2 = TouchImageView.this.f11390e;
            } else {
                z = false;
            }
            float f3 = f2;
            if (z) {
                TouchImageView touchImageView = TouchImageView.this;
                TouchImageView.this.C(new c(f3, touchImageView.p / 2, TouchImageView.this.q / 2, true));
            }
        }

        /* synthetic */ h(TouchImageView touchImageView, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class i {
        public float a;
        public float b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView.ScaleType f11406d;

        public i(TouchImageView touchImageView, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.f11406d = scaleType;
        }
    }

    public TouchImageView(Context context) {
        super(context);
        this.z = null;
        this.A = null;
        this.B = null;
        U(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public void C(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16L);
        }
    }

    private void D() {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0 || this.b == null || this.c == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float f2 = intrinsicWidth;
        float f3 = this.p / f2;
        float f4 = intrinsicHeight;
        float f5 = this.q / f4;
        int i2 = a.a[this.f11397l.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    f3 = Math.min(1.0f, Math.min(f3, f5));
                    f5 = f3;
                } else if (i2 != 4) {
                    if (i2 != 5) {
                        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
                    }
                }
                f3 = Math.min(f3, f5);
            } else {
                f3 = Math.max(f3, f5);
            }
            f5 = f3;
        } else {
            f3 = 1.0f;
            f5 = 1.0f;
        }
        int i3 = this.p;
        float f6 = i3 - (f3 * f2);
        int i4 = this.q;
        float f7 = i4 - (f5 * f4);
        this.t = i3 - f6;
        this.u = i4 - f7;
        if (!O() && !this.m) {
            this.b.setScale(f3, f5);
            this.b.postTranslate(f6 / 2.0f, f7 / 2.0f);
            this.a = 1.0f;
        } else {
            if (this.v == 0.0f || this.w == 0.0f) {
                Q();
            }
            this.c.getValues(this.f11394i);
            float[] fArr = this.f11394i;
            float f8 = this.t / f2;
            float f9 = this.a;
            fArr[0] = f8 * f9;
            fArr[4] = (this.u / f4) * f9;
            float f10 = fArr[2];
            float f11 = fArr[5];
            X(2, f10, this.v * f9, L(), this.r, this.p, intrinsicWidth);
            X(5, f11, this.w * this.a, K(), this.s, this.q, intrinsicHeight);
            this.b.setValues(this.f11394i);
        }
        G();
        E(this.f11394i, this.b);
        setImageMatrix(this.b);
    }

    private void E(float[] fArr, Matrix matrix) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = N(fArr[i2]) ? 0.0f : fArr[i2];
        }
        matrix.setValues(fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        G();
        this.b.getValues(this.f11394i);
        float L = L();
        int i2 = this.p;
        if (L < i2) {
            this.f11394i[2] = (i2 - L()) / 2.0f;
        }
        float K = K();
        int i3 = this.q;
        if (K < i3) {
            this.f11394i[5] = (i3 - K()) / 2.0f;
        }
        this.b.setValues(this.f11394i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.b.getValues(this.f11394i);
        float[] fArr = this.f11394i;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float J = J(f2, this.p, L());
        float J2 = J(f3, this.q, K());
        if (J == 0.0f && J2 == 0.0f) {
            return;
        }
        this.b.postTranslate(J, J2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float I(float f2, float f3, float f4) {
        if (f4 <= f3) {
            return 0.0f;
        }
        return f2;
    }

    private float J(float f2, float f3, float f4) {
        float f5;
        float f6;
        if (f4 <= f3) {
            f6 = f3 - f4;
            f5 = 0.0f;
        } else {
            f5 = f3 - f4;
            f6 = 0.0f;
        }
        if (f2 < f5) {
            return (-f2) + f5;
        }
        if (f2 > f6) {
            return (-f2) + f6;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float K() {
        return this.u * this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float L() {
        return this.t * this.a;
    }

    private boolean N(float f2) {
        return f2 <= 0.0f && f2 > 0.0f;
    }

    private void Q() {
        Matrix matrix = this.b;
        if (matrix == null || this.q == 0 || this.p == 0) {
            return;
        }
        matrix.getValues(this.f11394i);
        this.c.setValues(this.f11394i);
        this.w = this.u;
        this.v = this.t;
        this.s = this.q;
        this.r = this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(double d2, float f2, float f3, boolean z) {
        float f4;
        float f5;
        if (z) {
            f4 = this.f11392g;
            f5 = this.f11393h;
        } else {
            f4 = this.f11390e;
            f5 = this.f11391f;
        }
        float f6 = this.a;
        float f7 = (float) (f6 * d2);
        this.a = f7;
        if (f7 > f5) {
            this.a = f5;
            d2 = f5 / f6;
        } else if (f7 < f4) {
            this.a = f4;
            d2 = f4 / f6;
        }
        float f8 = (float) d2;
        this.b.postScale(f8, f8, f2, f3);
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(State state) {
        this.f11389d = state;
    }

    private int T(int i2, int i3, int i4) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 0 ? i3 : i4;
        }
        return Math.min(i4, i3);
    }

    private void U(Context context) {
        super.setClickable(true);
        this.f11395j = context;
        this.x = new ScaleGestureDetector(context, new h(this, null));
        this.y = new GestureDetector(context, new e(this, null));
        this.b = new Matrix();
        this.c = new Matrix();
        this.f11394i = new float[9];
        this.a = 1.0f;
        if (this.f11397l == null) {
            this.f11397l = ImageView.ScaleType.FIT_CENTER;
        }
        this.f11390e = 1.0f;
        this.f11391f = 3.0f;
        this.f11392g = 1.0f * 0.4f;
        this.f11393h = 3.0f * 2.0f;
        setImageMatrix(this.b);
        setScaleType(ImageView.ScaleType.MATRIX);
        S(State.NONE);
        this.n = false;
        super.setOnTouchListener(new g(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF V(float f2, float f3) {
        this.b.getValues(this.f11394i);
        return new PointF(this.f11394i[2] + (L() * (f2 / getDrawable().getIntrinsicWidth())), this.f11394i[5] + (K() * (f3 / getDrawable().getIntrinsicHeight())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF W(float f2, float f3, boolean z) {
        this.b.getValues(this.f11394i);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float[] fArr = this.f11394i;
        float f4 = fArr[2];
        float f5 = fArr[5];
        float L = ((f2 - f4) * intrinsicWidth) / L();
        float K = ((f3 - f5) * intrinsicHeight) / K();
        if (z) {
            L = Math.min(Math.max(L, 0.0f), intrinsicWidth);
            K = Math.min(Math.max(K, 0.0f), intrinsicHeight);
        }
        return new PointF(L, K);
    }

    private void X(int i2, float f2, float f3, float f4, int i3, int i4, int i5) {
        float f5 = i4;
        if (f4 < f5) {
            float[] fArr = this.f11394i;
            fArr[i2] = (f5 - (i5 * fArr[0])) * 0.5f;
        } else if (f2 > 0.0f) {
            this.f11394i[i2] = -((f4 - f5) * 0.5f);
        } else {
            this.f11394i[i2] = -((((Math.abs(f2) + (i3 * 0.5f)) / f3) * f4) - (f5 * 0.5f));
        }
    }

    public boolean B(int i2) {
        return canScrollHorizontally(i2);
    }

    public float H() {
        return this.a;
    }

    public PointF M() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF W = W(this.p / 2, this.q / 2, true);
        W.x /= intrinsicWidth;
        W.y /= intrinsicHeight;
        return W;
    }

    public boolean O() {
        return this.a != 1.0f;
    }

    public void P() {
        this.a = 1.0f;
        D();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        this.b.getValues(this.f11394i);
        float f2 = this.f11394i[2];
        if (L() < this.p) {
            return false;
        }
        if (f2 < -1.0f || i2 >= 0) {
            return (Math.abs(f2) + ((float) this.p)) + 1.0f < L() || i2 <= 0;
        }
        return false;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f11397l;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.n = true;
        this.m = true;
        i iVar = this.o;
        if (iVar != null) {
            setZoom(iVar.a, iVar.b, iVar.c, iVar.f11406d);
            this.o = null;
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p = T(mode, size, intrinsicWidth);
            int T = T(mode2, size2, intrinsicHeight);
            this.q = T;
            setMeasuredDimension(this.p, T);
            D();
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.a = bundle.getFloat("saveScale");
            float[] floatArray = bundle.getFloatArray("matrix");
            this.f11394i = floatArray;
            this.c.setValues(floatArray);
            this.w = bundle.getFloat("matchViewHeight");
            this.v = bundle.getFloat("matchViewWidth");
            this.s = bundle.getInt("viewHeight");
            this.r = bundle.getInt("viewWidth");
            this.m = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.a);
        bundle.putFloat("matchViewHeight", this.u);
        bundle.putFloat("matchViewWidth", this.t);
        bundle.putInt("viewWidth", this.p);
        bundle.putInt("viewHeight", this.q);
        this.b.getValues(this.f11394i);
        bundle.putFloatArray("matrix", this.f11394i);
        bundle.putBoolean("imageRendered", this.m);
        return bundle;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        Q();
        D();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        Q();
        D();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        Q();
        D();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        Q();
        D();
    }

    public void setMaxZoom(float f2) {
        this.f11391f = f2;
        this.f11393h = f2 * 2.0f;
    }

    public void setMinZoom(float f2) {
        this.f11390e = f2;
        this.f11392g = f2 * 0.4f;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.z = onDoubleTapListener;
    }

    public void setOnTouchImageViewListener(f fVar) {
        this.B = fVar;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A = onTouchListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != ImageView.ScaleType.FIT_START && scaleType != ImageView.ScaleType.FIT_END) {
            ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
            if (scaleType == scaleType2) {
                super.setScaleType(scaleType2);
                return;
            }
            this.f11397l = scaleType;
            if (this.n) {
                setZoom(this);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    }

    public void setScrollPosition(float f2, float f3) {
        setZoom(this.a, f2, f3);
    }

    public void setZoom(float f2) {
        setZoom(f2, 0.5f, 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class g implements View.OnTouchListener {
        private PointF a;

        private g() {
            this.a = new PointF();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
            if (r1 != 6) goto L7;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                android.view.ScaleGestureDetector r0 = us.pinguo.inspire.widget.photopager.TouchImageView.b(r0)
                r0.onTouchEvent(r9)
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                android.view.GestureDetector r0 = us.pinguo.inspire.widget.photopager.TouchImageView.c(r0)
                r0.onTouchEvent(r9)
                android.graphics.PointF r0 = new android.graphics.PointF
                float r1 = r9.getX()
                float r2 = r9.getY()
                r0.<init>(r1, r2)
                us.pinguo.inspire.widget.photopager.TouchImageView r1 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$State r1 = us.pinguo.inspire.widget.photopager.TouchImageView.x(r1)
                us.pinguo.inspire.widget.photopager.TouchImageView$State r2 = us.pinguo.inspire.widget.photopager.TouchImageView.State.NONE
                r3 = 1
                if (r1 == r2) goto L3e
                us.pinguo.inspire.widget.photopager.TouchImageView r1 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$State r1 = us.pinguo.inspire.widget.photopager.TouchImageView.x(r1)
                us.pinguo.inspire.widget.photopager.TouchImageView$State r4 = us.pinguo.inspire.widget.photopager.TouchImageView.State.DRAG
                if (r1 == r4) goto L3e
                us.pinguo.inspire.widget.photopager.TouchImageView r1 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$State r1 = us.pinguo.inspire.widget.photopager.TouchImageView.x(r1)
                us.pinguo.inspire.widget.photopager.TouchImageView$State r4 = us.pinguo.inspire.widget.photopager.TouchImageView.State.FLING
                if (r1 != r4) goto Lc0
            L3e:
                int r1 = r9.getAction()
                if (r1 == 0) goto La3
                if (r1 == r3) goto L9d
                r4 = 2
                if (r1 == r4) goto L4d
                r0 = 6
                if (r1 == r0) goto L9d
                goto Lc0
            L4d:
                us.pinguo.inspire.widget.photopager.TouchImageView r1 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$State r1 = us.pinguo.inspire.widget.photopager.TouchImageView.x(r1)
                us.pinguo.inspire.widget.photopager.TouchImageView$State r2 = us.pinguo.inspire.widget.photopager.TouchImageView.State.DRAG
                if (r1 != r2) goto Lc0
                float r1 = r0.x
                android.graphics.PointF r2 = r7.a
                float r4 = r2.x
                float r1 = r1 - r4
                float r4 = r0.y
                float r2 = r2.y
                float r4 = r4 - r2
                us.pinguo.inspire.widget.photopager.TouchImageView r2 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                int r5 = us.pinguo.inspire.widget.photopager.TouchImageView.e(r2)
                float r5 = (float) r5
                us.pinguo.inspire.widget.photopager.TouchImageView r6 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                float r6 = us.pinguo.inspire.widget.photopager.TouchImageView.f(r6)
                float r1 = us.pinguo.inspire.widget.photopager.TouchImageView.g(r2, r1, r5, r6)
                us.pinguo.inspire.widget.photopager.TouchImageView r2 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                int r5 = us.pinguo.inspire.widget.photopager.TouchImageView.h(r2)
                float r5 = (float) r5
                us.pinguo.inspire.widget.photopager.TouchImageView r6 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                float r6 = us.pinguo.inspire.widget.photopager.TouchImageView.i(r6)
                float r2 = us.pinguo.inspire.widget.photopager.TouchImageView.g(r2, r4, r5, r6)
                us.pinguo.inspire.widget.photopager.TouchImageView r4 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                android.graphics.Matrix r4 = us.pinguo.inspire.widget.photopager.TouchImageView.j(r4)
                r4.postTranslate(r1, r2)
                us.pinguo.inspire.widget.photopager.TouchImageView r1 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView.k(r1)
                android.graphics.PointF r1 = r7.a
                float r2 = r0.x
                float r0 = r0.y
                r1.set(r2, r0)
                goto Lc0
            L9d:
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView.d(r0, r2)
                goto Lc0
            La3:
                android.graphics.PointF r1 = r7.a
                r1.set(r0)
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$d r0 = us.pinguo.inspire.widget.photopager.TouchImageView.u(r0)
                if (r0 == 0) goto Lb9
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$d r0 = us.pinguo.inspire.widget.photopager.TouchImageView.u(r0)
                r0.a()
            Lb9:
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$State r1 = us.pinguo.inspire.widget.photopager.TouchImageView.State.DRAG
                us.pinguo.inspire.widget.photopager.TouchImageView.d(r0, r1)
            Lc0:
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                android.graphics.Matrix r1 = us.pinguo.inspire.widget.photopager.TouchImageView.j(r0)
                r0.setImageMatrix(r1)
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                android.view.View$OnTouchListener r0 = us.pinguo.inspire.widget.photopager.TouchImageView.l(r0)
                if (r0 == 0) goto Lda
                us.pinguo.inspire.widget.photopager.TouchImageView r0 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                android.view.View$OnTouchListener r0 = us.pinguo.inspire.widget.photopager.TouchImageView.l(r0)
                r0.onTouch(r8, r9)
            Lda:
                us.pinguo.inspire.widget.photopager.TouchImageView r8 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$f r8 = us.pinguo.inspire.widget.photopager.TouchImageView.m(r8)
                if (r8 == 0) goto Leb
                us.pinguo.inspire.widget.photopager.TouchImageView r8 = us.pinguo.inspire.widget.photopager.TouchImageView.this
                us.pinguo.inspire.widget.photopager.TouchImageView$f r8 = us.pinguo.inspire.widget.photopager.TouchImageView.m(r8)
                r8.a()
            Leb:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.widget.photopager.TouchImageView.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        /* synthetic */ g(TouchImageView touchImageView, a aVar) {
            this();
        }
    }

    public void setZoom(float f2, float f3, float f4) {
        setZoom(f2, f3, f4, this.f11397l);
    }

    public void setZoom(float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        if (!this.n) {
            this.o = new i(this, f2, f3, f4, scaleType);
            return;
        }
        if (scaleType != this.f11397l) {
            setScaleType(scaleType);
        }
        P();
        R(f2, this.p / 2, this.q / 2, true);
        this.b.getValues(this.f11394i);
        this.f11394i[2] = -((f3 * L()) - (this.p * 0.5f));
        this.f11394i[5] = -((f4 * K()) - (this.q * 0.5f));
        this.b.setValues(this.f11394i);
        G();
        setImageMatrix(this.b);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = null;
        this.A = null;
        this.B = null;
        U(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = null;
        this.A = null;
        this.B = null;
        U(context);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF M = touchImageView.M();
        setZoom(touchImageView.H(), M.x, M.y, touchImageView.getScaleType());
    }
}
