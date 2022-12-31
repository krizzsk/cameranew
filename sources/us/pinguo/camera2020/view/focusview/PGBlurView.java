package us.pinguo.camera2020.view.focusview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.s;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.utils.n0;
/* compiled from: PGBlurView.kt */
/* loaded from: classes3.dex */
public final class PGBlurView extends View {
    private float a;
    private Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9392d;

    /* renamed from: e  reason: collision with root package name */
    private int f9393e;

    /* renamed from: f  reason: collision with root package name */
    private int f9394f;

    /* renamed from: g  reason: collision with root package name */
    private float f9395g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f9396h;

    /* renamed from: i  reason: collision with root package name */
    private int f9397i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f9398j;

    /* renamed from: k  reason: collision with root package name */
    private int f9399k;

    /* renamed from: l  reason: collision with root package name */
    private float f9400l;
    private float m;
    private Matrix n;
    private float o;
    private float p;
    private Interpolator q;
    private long r;
    private float s;
    private final int t;
    private final int u;
    private final int v;
    private int w;
    private final float x;

    /* compiled from: PGBlurView.kt */
    /* loaded from: classes3.dex */
    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PGBlurView pGBlurView = PGBlurView.this;
            pGBlurView.w = pGBlurView.t;
        }
    }

    /* compiled from: PGBlurView.kt */
    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PGBlurView pGBlurView = PGBlurView.this;
            pGBlurView.w = pGBlurView.t;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PGBlurView(Context context) {
        this(context, null);
        s.h(context, "context");
    }

    private final void e() {
        if (this.f9392d != 3 || this.w == this.t) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.r;
        long j3 = (long) IjkMediaCodecInfo.RANK_SECURE;
        if (currentTimeMillis <= j2 + j3) {
            Interpolator interpolator = this.q;
            if (interpolator != null) {
                float interpolation = interpolator.getInterpolation(((float) ((System.currentTimeMillis() - this.r) / j3)) * 1.0f);
                if (this.w == this.u) {
                    float f2 = this.s;
                    this.p = f2 - ((f2 - this.x) * interpolation);
                } else {
                    float f3 = this.x;
                    this.p = f3 + ((this.s - f3) * interpolation);
                }
                i();
                invalidate();
                return;
            }
            s.z("lineAnimInterpolator");
            throw null;
        }
        int i2 = this.w;
        if (i2 == this.u) {
            this.p = this.x;
            i();
            invalidate();
            this.w = this.t;
        } else if (i2 == this.v) {
            this.p = this.s;
            i();
            invalidate();
            this.w = this.t;
        }
    }

    private final void i() {
        float f2 = this.f9397i * this.p;
        float f3 = 2;
        float f4 = -(((this.f9395g * f3) - getMeasuredWidth()) / f3);
        float f5 = this.m - (f2 / f3);
        float f6 = (f3 * this.f9395g) + f4;
        float f7 = f2 + f5;
        this.f9398j = new float[]{f4, f5, f6, f5, f4, f7, f6, f7};
    }

    public final void c(float f2) {
        int i2 = this.f9392d;
        if (i2 != 2) {
            if (i2 == 3) {
                this.w = this.u;
                this.q = new AccelerateInterpolator();
                this.r = System.currentTimeMillis();
                this.s = f2;
                invalidate();
                return;
            }
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", f2, this.x);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", f2, this.x);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.addListener(new a());
        this.w = this.u;
        ofFloat2.setDuration(300L);
        ofFloat2.start();
    }

    public final void d(float f2) {
        int i2 = this.f9392d;
        if (i2 == 2) {
            ObjectAnimator.ofFloat(this, "scaleX", this.x, f2).setDuration(300L).start();
            ObjectAnimator duration = ObjectAnimator.ofFloat(this, "scaleY", this.x, f2).setDuration(300L);
            s.g(duration, "ofFloat(this, \"scaleY\", …stScale).setDuration(300)");
            duration.addListener(new b());
            this.w = this.v;
            duration.start();
        } else if (i2 == 3) {
            this.w = this.v;
            this.q = new AccelerateInterpolator();
            this.r = System.currentTimeMillis();
            this.s = f2;
            invalidate();
        }
    }

    public final float f() {
        int i2 = this.f9392d;
        if (i2 == 2) {
            return this.a;
        }
        if (i2 == 3) {
            return this.f9397i / 2;
        }
        return 0.0f;
    }

    public final void g() {
        setLayerType(2, null);
        this.b.setStrokeWidth(1.5f);
        this.b.setColor(this.c);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setPathEffect(new DashPathEffect(new float[]{32.0f, 32.0f}, 4.0f));
        this.f9399k = getResources().getDimensionPixelSize(R.dimen.blur_circle_diameter);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        Point point = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point);
        int i2 = point.x;
        this.f9393e = i2;
        this.f9394f = point.y;
        this.f9395g = (float) Math.sqrt(Math.pow(i2, 2.0d) + Math.pow(this.f9394f, 2.0d));
        this.f9397i = getResources().getDimensionPixelSize(R.dimen.focus_circle_radius) + n0.c(20);
        this.f9396h = new float[8];
    }

    public final void h() {
        this.b.setAlpha(255);
        invalidate();
    }

    public final void j(float f2, float f3) {
        this.f9400l = f2;
        this.m = f3;
        int i2 = this.f9392d;
        if (i2 == 2) {
            int measuredWidth = (int) (f2 - (getMeasuredWidth() / 2));
            int measuredHeight = (int) (f3 - (getMeasuredHeight() / 2));
            layout(measuredWidth, measuredHeight, getMeasuredWidth() + measuredWidth, getMeasuredHeight() + measuredHeight);
        } else if (i2 == 3) {
            this.n.reset();
            this.n.setRotate(this.o, f2, f3);
            i();
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2 = this.f9392d;
        if (i2 == 2) {
            if (canvas == null) {
                return;
            }
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.a, this.b);
        } else if (i2 == 3) {
            Matrix matrix = this.n;
            float[] fArr = this.f9396h;
            if (fArr == null) {
                s.z("transformLine");
                throw null;
            }
            float[] fArr2 = this.f9398j;
            if (fArr2 != null) {
                matrix.mapPoints(fArr, fArr2);
                if (canvas != null) {
                    float[] fArr3 = this.f9396h;
                    if (fArr3 == null) {
                        s.z("transformLine");
                        throw null;
                    }
                    canvas.drawLines(fArr3, this.b);
                }
                e();
                return;
            }
            s.z("defaultLine");
            throw null;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4 = this.f9392d;
        if (i4 == 2) {
            int i5 = this.f9399k;
            setMeasuredDimension(i5, i5);
            this.a = this.f9399k / 2;
        } else if (i4 == 3) {
            super.onMeasure(i2, i3);
            this.m = getMeasuredHeight() / 2;
            i();
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public final void setBlurState(int i2) {
        if (i2 != this.f9392d) {
            setScaleX(1.0f);
            setScaleY(1.0f);
            this.f9392d = i2;
            requestLayout();
        }
    }

    public final void setFocusFail() {
        this.b.setAlpha(102);
        invalidate();
    }

    public final void setRotate(float f2) {
        this.o = f2;
        this.n.reset();
        this.n.setRotate(f2, this.f9400l, this.m);
        invalidate();
    }

    public final void setScale(float f2) {
        if (this.w == this.t) {
            int i2 = this.f9392d;
            if (i2 == 3) {
                this.p = f2;
                i();
                invalidate();
            } else if (i2 == 2) {
                setScaleX(f2);
                setScaleY(f2);
                invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PGBlurView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGBlurView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.b = new Paint();
        this.c = -1;
        this.f9392d = 3;
        this.n = new Matrix();
        new Matrix();
        this.p = 1.0f;
        this.u = 1;
        this.v = 2;
        this.w = this.t;
        this.x = 0.7f;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PGBlurView, i2, 0);
        s.g(obtainStyledAttributes, "context.theme.obtainStyl…lurView, defStyleAttr, 0)");
        this.c = obtainStyledAttributes.getColor(R.styleable.PGBlurView_lineColor, -1);
        g();
    }
}
