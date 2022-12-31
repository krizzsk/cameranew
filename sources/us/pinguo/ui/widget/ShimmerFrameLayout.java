package us.pinguo.ui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode r = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Paint a;
    private Paint b;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private e f12218d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f12219e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f12220f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12221g;

    /* renamed from: h  reason: collision with root package name */
    private int f12222h;

    /* renamed from: i  reason: collision with root package name */
    private int f12223i;

    /* renamed from: j  reason: collision with root package name */
    private int f12224j;

    /* renamed from: k  reason: collision with root package name */
    private int f12225k;

    /* renamed from: l  reason: collision with root package name */
    private int f12226l;
    private int m;
    private boolean n;
    private ViewTreeObserver.OnGlobalLayoutListener o;
    protected ValueAnimator p;
    protected Bitmap q;

    /* loaded from: classes6.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes6.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z = ShimmerFrameLayout.this.n;
            ShimmerFrameLayout.this.p();
            if (ShimmerFrameLayout.this.f12221g || z) {
                ShimmerFrameLayout.this.u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (ShimmerFrameLayout.this.getContext() != null && (ShimmerFrameLayout.this.getContext() instanceof Activity) && ((Activity) ShimmerFrameLayout.this.getContext()).isFinishing()) {
                ShimmerFrameLayout.this.l();
                return;
            }
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
            float f2 = 1.0f - max;
            shimmerFrameLayout.s((int) ((shimmerFrameLayout.f12218d.a * f2) + (ShimmerFrameLayout.this.f12218d.c * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.t((int) ((shimmerFrameLayout2.f12218d.b * f2) + (ShimmerFrameLayout.this.f12218d.f12233d * max)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d {
        public MaskAngle a;
        public float b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public int f12227d;

        /* renamed from: e  reason: collision with root package name */
        public int f12228e;

        /* renamed from: f  reason: collision with root package name */
        public float f12229f;

        /* renamed from: g  reason: collision with root package name */
        public float f12230g;

        /* renamed from: h  reason: collision with root package name */
        public float f12231h;

        /* renamed from: i  reason: collision with root package name */
        public MaskShape f12232i;

        private d() {
        }

        public int[] a() {
            return c.a[this.f12232i.ordinal()] != 2 ? new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0} : new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
        }

        public float[] b() {
            return c.a[this.f12232i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f12229f) - this.c) / 2.0f, 0.0f), Math.max((1.0f - this.f12229f) / 2.0f, 0.0f), Math.min((this.f12229f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f12229f + 1.0f) + this.c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f12229f, 1.0f), Math.min(this.f12229f + this.c, 1.0f)};
        }

        public int c(int i2) {
            int i3 = this.f12228e;
            return i3 > 0 ? i3 : (int) (i2 * this.f12231h);
        }

        public int d(int i2) {
            int i3 = this.f12227d;
            return i3 > 0 ? i3 : (int) (i2 * this.f12230g);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f12233d;

        private e() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.f12233d = i5;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    private static float g(float f2, float f3, float f4) {
        return Math.min(f3, Math.max(f2, f4));
    }

    protected static Bitmap h(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }

    private boolean i(Canvas canvas) {
        Bitmap y = y();
        Bitmap x = x();
        if (y == null || x == null) {
            return false;
        }
        k(new Canvas(y));
        canvas.drawBitmap(y, 0.0f, 0.0f, this.a);
        j(new Canvas(x));
        canvas.drawBitmap(x, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private void j(Canvas canvas) {
        Bitmap n = n();
        if (n == null) {
            return;
        }
        int i2 = this.f12226l;
        canvas.clipRect(i2, this.m, n.getWidth() + i2, this.m + n.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(n, this.f12226l, this.m, this.b);
    }

    private void k(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private ViewTreeObserver.OnGlobalLayoutListener m() {
        return new a();
    }

    private Bitmap n() {
        Shader radialGradient;
        int sqrt;
        int i2;
        int i3;
        int i4;
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            return bitmap;
        }
        int d2 = this.c.d(getWidth());
        int c2 = this.c.c(getHeight());
        this.q = h(d2, c2);
        Canvas canvas = new Canvas(this.q);
        if (c.a[this.c.f12232i.ordinal()] != 2) {
            int i5 = c.b[this.c.a.ordinal()];
            int i6 = 0;
            if (i5 != 2) {
                if (i5 == 3) {
                    i6 = d2;
                    i3 = 0;
                } else if (i5 != 4) {
                    i4 = d2;
                    i3 = 0;
                    i2 = 0;
                } else {
                    i3 = c2;
                }
                i4 = 0;
                i2 = 0;
            } else {
                i2 = c2;
                i3 = 0;
                i4 = 0;
            }
            radialGradient = new LinearGradient(i6, i3, i4, i2, this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
        } else {
            radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.c.b, d2 / 2, c2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        float f2 = -(((int) (Math.sqrt(2.0d) * Math.max(d2, c2))) / 2);
        canvas.drawRect(f2, f2, d2 + sqrt, c2 + sqrt, paint);
        return this.q;
    }

    private Animator o() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i2 = c.a[this.c.f12232i.ordinal()];
        int i3 = c.b[this.c.a.ordinal()];
        if (i3 == 2) {
            this.f12218d.a(0, -height, 0, height);
        } else if (i3 == 3) {
            this.f12218d.a(width, 0, -width, 0);
        } else if (i3 != 4) {
            this.f12218d.a(-width, 0, width, 0);
        } else {
            this.f12218d.a(0, height, 0, -height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.f12224j / this.f12222h) + 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(this.f12222h + this.f12224j);
        this.p.setRepeatCount(this.f12223i);
        this.p.setRepeatMode(this.f12225k);
        this.p.addUpdateListener(new b());
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        v();
        q();
        r();
    }

    private void q() {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            bitmap.recycle();
            this.q = null;
        }
    }

    private void r() {
        Bitmap bitmap = this.f12220f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f12220f = null;
        }
        Bitmap bitmap2 = this.f12219e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f12219e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i2) {
        if (this.f12226l == i2) {
            return;
        }
        this.f12226l = i2;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i2) {
        if (this.m == i2) {
            return;
        }
        this.m = i2;
        invalidate();
    }

    private Bitmap w() {
        int width = getWidth();
        int height = getHeight();
        try {
            return h(width, height);
        } catch (OutOfMemoryError unused) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            Log.d("ShimmerFrameLayout", sb.toString());
            return null;
        }
    }

    private Bitmap x() {
        if (this.f12219e == null) {
            this.f12219e = w();
        }
        return this.f12219e;
    }

    private Bitmap y() {
        if (this.f12220f == null) {
            this.f12220f = w();
        }
        return this.f12220f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.n && getWidth() > 0 && getHeight() > 0) {
            i(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public void l() {
        r();
        this.o = null;
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.o == null) {
            this.o = m();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        v();
        if (this.o != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.o);
            this.o = null;
        }
        super.onDetachedFromWindow();
    }

    public void setAngle(MaskAngle maskAngle) {
        this.c.a = maskAngle;
        p();
    }

    public void setAutoStart(boolean z) {
        this.f12221g = z;
        p();
    }

    public void setBaseAlpha(float f2) {
        this.a.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
        p();
    }

    public void setDropoff(float f2) {
        this.c.c = f2;
        p();
    }

    public void setDuration(int i2) {
        this.f12222h = i2;
        p();
    }

    public void setFixedHeight(int i2) {
        this.c.f12228e = i2;
        p();
    }

    public void setFixedWidth(int i2) {
        this.c.f12227d = i2;
        p();
    }

    public void setIntensity(float f2) {
        this.c.f12229f = f2;
        p();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.c.f12232i = maskShape;
        p();
    }

    public void setRelativeHeight(int i2) {
        this.c.f12231h = i2;
        p();
    }

    public void setRelativeWidth(int i2) {
        this.c.f12230g = i2;
        p();
    }

    public void setRepeatCount(int i2) {
        this.f12223i = i2;
        p();
    }

    public void setRepeatDelay(int i2) {
        this.f12224j = i2;
        p();
    }

    public void setRepeatMode(int i2) {
        this.f12225k = i2;
        p();
    }

    public void setTilt(float f2) {
        this.c.b = f2;
        p();
    }

    public void u() {
        if (this.n) {
            return;
        }
        o().start();
        this.n = true;
    }

    public void v() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.p.removeAllUpdateListeners();
            this.p.cancel();
        }
        this.p = null;
        this.n = false;
    }

    public void z() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.c;
        dVar.a = MaskAngle.CW_0;
        dVar.f12232i = MaskShape.LINEAR;
        dVar.c = 0.5f;
        dVar.f12227d = 0;
        dVar.f12228e = 0;
        dVar.f12229f = 0.0f;
        dVar.f12230g = 1.0f;
        dVar.f12231h = 1.0f;
        dVar.b = 20.0f;
        this.f12218d = new e(null);
        setBaseAlpha(0.3f);
        p();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        this.c = new d(null);
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setFilterBitmap(true);
        this.b.setXfermode(r);
        z();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                int i3 = R.styleable.ShimmerFrameLayout_auto_start;
                if (obtainStyledAttributes.hasValue(i3)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(i3, false));
                }
                int i4 = R.styleable.ShimmerFrameLayout_base_alpha;
                if (obtainStyledAttributes.hasValue(i4)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(i4, 0.0f));
                }
                int i5 = R.styleable.ShimmerFrameLayout_duration;
                if (obtainStyledAttributes.hasValue(i5)) {
                    setDuration(obtainStyledAttributes.getInt(i5, 0));
                }
                int i6 = R.styleable.ShimmerFrameLayout_repeat_count;
                if (obtainStyledAttributes.hasValue(i6)) {
                    setRepeatCount(obtainStyledAttributes.getInt(i6, 0));
                }
                int i7 = R.styleable.ShimmerFrameLayout_repeat_delay;
                if (obtainStyledAttributes.hasValue(i7)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(i7, 0));
                }
                int i8 = R.styleable.ShimmerFrameLayout_repeat_mode;
                if (obtainStyledAttributes.hasValue(i8)) {
                    setRepeatMode(obtainStyledAttributes.getInt(i8, 0));
                }
                int i9 = R.styleable.ShimmerFrameLayout_angle;
                if (obtainStyledAttributes.hasValue(i9)) {
                    int i10 = obtainStyledAttributes.getInt(i9, 0);
                    if (i10 == 90) {
                        this.c.a = MaskAngle.CW_90;
                    } else if (i10 == 180) {
                        this.c.a = MaskAngle.CW_180;
                    } else if (i10 != 270) {
                        this.c.a = MaskAngle.CW_0;
                    } else {
                        this.c.a = MaskAngle.CW_270;
                    }
                }
                int i11 = R.styleable.ShimmerFrameLayout_dropoff;
                if (obtainStyledAttributes.hasValue(i11)) {
                    this.c.c = obtainStyledAttributes.getFloat(i11, 0.0f);
                }
                int i12 = R.styleable.ShimmerFrameLayout_fixed_width;
                if (obtainStyledAttributes.hasValue(i12)) {
                    this.c.f12227d = obtainStyledAttributes.getDimensionPixelSize(i12, 0);
                }
                int i13 = R.styleable.ShimmerFrameLayout_fixed_height;
                if (obtainStyledAttributes.hasValue(i13)) {
                    this.c.f12228e = obtainStyledAttributes.getDimensionPixelSize(i13, 0);
                }
                int i14 = R.styleable.ShimmerFrameLayout_intensity;
                if (obtainStyledAttributes.hasValue(i14)) {
                    this.c.f12229f = obtainStyledAttributes.getFloat(i14, 0.0f);
                }
                int i15 = R.styleable.ShimmerFrameLayout_relative_width;
                if (obtainStyledAttributes.hasValue(i15)) {
                    this.c.f12230g = obtainStyledAttributes.getFloat(i15, 0.0f);
                }
                int i16 = R.styleable.ShimmerFrameLayout_relative_height;
                if (obtainStyledAttributes.hasValue(i16)) {
                    this.c.f12231h = obtainStyledAttributes.getFloat(i16, 0.0f);
                }
                int i17 = R.styleable.ShimmerFrameLayout_tilt;
                if (obtainStyledAttributes.hasValue(i17)) {
                    this.c.b = obtainStyledAttributes.getFloat(i17, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
