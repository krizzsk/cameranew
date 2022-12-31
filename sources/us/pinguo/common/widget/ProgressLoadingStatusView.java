package us.pinguo.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ProgressLoadingStatusView.kt */
/* loaded from: classes4.dex */
public final class ProgressLoadingStatusView extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9964d;

    /* renamed from: e  reason: collision with root package name */
    private float f9965e;

    /* renamed from: f  reason: collision with root package name */
    private float f9966f;

    /* renamed from: g  reason: collision with root package name */
    private float f9967g;

    /* renamed from: h  reason: collision with root package name */
    private float f9968h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f9969i;

    /* renamed from: j  reason: collision with root package name */
    private RectF f9970j;

    /* renamed from: k  reason: collision with root package name */
    private LoadingStatusEnum f9971k;

    /* renamed from: l  reason: collision with root package name */
    private float f9972l;
    private float m;
    private float n;
    private PathMeasure o;
    private Path p;
    private Path q;
    private Path r;
    private Path s;
    private Path t;
    private kotlin.jvm.b.a<u> u;
    private kotlin.jvm.b.a<u> v;

    /* compiled from: ProgressLoadingStatusView.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoadingStatusEnum.values().length];
            iArr[LoadingStatusEnum.Loading.ordinal()] = 1;
            iArr[LoadingStatusEnum.Succeed.ordinal()] = 2;
            iArr[LoadingStatusEnum.Failed.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            kotlin.jvm.b.a<u> a = ProgressLoadingStatusView.this.a();
            if (a == null) {
                return;
            }
            a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            kotlin.jvm.b.a<u> b = ProgressLoadingStatusView.this.b();
            if (b == null) {
                return;
            }
            b.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressLoadingStatusView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressLoadingStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ ProgressLoadingStatusView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us.pinguo.commonui.R.styleable.ProgressLoadingStatusView);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…rogressLoadingStatusView)");
        int i2 = us.pinguo.commonui.R.styleable.ProgressLoadingStatusView_pls_progress_reach_color;
        int i3 = us.pinguo.commonui.R.color.primary_text_enable;
        this.a = obtainStyledAttributes.getColor(i2, ContextCompat.getColor(context, i3));
        int i4 = us.pinguo.commonui.R.styleable.ProgressLoadingStatusView_pls_progress_bg_color;
        int i5 = us.pinguo.commonui.R.color.primary_ripple;
        this.b = obtainStyledAttributes.getColor(i4, ContextCompat.getColor(context, i5));
        this.c = obtainStyledAttributes.getColor(us.pinguo.commonui.R.styleable.ProgressLoadingStatusView_pls_load_success_color, ContextCompat.getColor(context, i3));
        this.f9964d = obtainStyledAttributes.getColor(us.pinguo.commonui.R.styleable.ProgressLoadingStatusView_pls_load_failure_color, ContextCompat.getColor(context, i5));
        this.f9965e = obtainStyledAttributes.getDimension(us.pinguo.commonui.R.styleable.ProgressLoadingStatusView_pls_progress_width, 6.0f);
        this.f9966f = obtainStyledAttributes.getDimension(us.pinguo.commonui.R.styleable.ProgressLoadingStatusView_pls_progress_radius, 100.0f);
        obtainStyledAttributes.recycle();
    }

    private final void d() {
        Paint paint = new Paint(1);
        paint.setColor(this.b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setDither(true);
        paint.setStrokeWidth(this.f9965e);
        this.f9969i = paint;
    }

    private final void e() {
        this.q = new Path();
        this.r = new Path();
        this.s = new Path();
        this.t = new Path();
        this.o = new PathMeasure();
        this.p = new Path();
    }

    private final void i() {
        k();
        this.f9971k = LoadingStatusEnum.Failed;
        l();
    }

    private final void j() {
        k();
        this.f9971k = LoadingStatusEnum.Succeed;
        o();
    }

    private final void k() {
        this.f9972l = 0.0f;
        this.n = 0.0f;
        this.m = 0.0f;
        Path path = this.q;
        if (path != null) {
            path.reset();
            Path path2 = this.p;
            if (path2 != null) {
                path2.reset();
                Path path3 = this.s;
                if (path3 != null) {
                    path3.reset();
                    Path path4 = this.t;
                    if (path4 != null) {
                        path4.reset();
                        Path path5 = this.r;
                        if (path5 != null) {
                            path5.reset();
                            return;
                        } else {
                            s.z("successPath");
                            throw null;
                        }
                    }
                    s.z("failurePathRight");
                    throw null;
                }
                s.z("failurePathLeft");
                throw null;
            }
            s.z("pathCircleDst");
            throw null;
        }
        s.z("pathCircle");
        throw null;
    }

    private final void l() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.common.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressLoadingStatusView.m(ProgressLoadingStatusView.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.common.widget.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressLoadingStatusView.n(ProgressLoadingStatusView.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).after(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.start();
        animatorSet.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ProgressLoadingStatusView this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.m = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ProgressLoadingStatusView this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.n = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    private final void o() {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.common.widget.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressLoadingStatusView.p(ProgressLoadingStatusView.this, valueAnimator);
            }
        });
        s.g(animator, "animator");
        animator.addListener(new c());
        animator.setDuration(500L);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ProgressLoadingStatusView this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f9972l = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    public static /* synthetic */ void r(ProgressLoadingStatusView progressLoadingStatusView, Float f2, LoadingStatusEnum loadingStatusEnum, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = null;
        }
        progressLoadingStatusView.q(f2, loadingStatusEnum);
    }

    private final void s(float f2) {
        this.f9967g = f2;
        this.f9971k = LoadingStatusEnum.Loading;
        invalidate();
    }

    public final kotlin.jvm.b.a<u> a() {
        return this.v;
    }

    public final kotlin.jvm.b.a<u> b() {
        return this.u;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.translate(getPaddingLeft(), getPaddingTop());
        float f2 = 2;
        float f3 = this.f9966f * f2;
        LoadingStatusEnum loadingStatusEnum = this.f9971k;
        if (loadingStatusEnum == LoadingStatusEnum.Loading) {
            Paint paint = this.f9969i;
            if (paint != null) {
                paint.setColor(this.b);
                float f4 = this.f9966f;
                Paint paint2 = this.f9969i;
                if (paint2 != null) {
                    canvas.drawCircle(f4, f4, f4, paint2);
                    Paint paint3 = this.f9969i;
                    if (paint3 != null) {
                        paint3.setColor(this.a);
                        float f5 = this.f9967g * ((float) BaseBlurEffect.ROTATION_360);
                        this.f9970j.set(0.0f, 0.0f, f3, f3);
                        RectF rectF = this.f9970j;
                        float f6 = this.f9968h;
                        Paint paint4 = this.f9969i;
                        if (paint4 != null) {
                            canvas.drawArc(rectF, f6, f5, false, paint4);
                            return;
                        } else {
                            s.z("paint");
                            throw null;
                        }
                    }
                    s.z("paint");
                    throw null;
                }
                s.z("paint");
                throw null;
            }
            s.z("paint");
            throw null;
        } else if (loadingStatusEnum == LoadingStatusEnum.Succeed) {
            Paint paint5 = this.f9969i;
            if (paint5 != null) {
                paint5.setColor(this.c);
                this.f9970j.set(0.0f, 0.0f, f3, f3);
                RectF rectF2 = this.f9970j;
                float f7 = this.f9968h;
                Paint paint6 = this.f9969i;
                if (paint6 != null) {
                    canvas.drawArc(rectF2, f7, 360.0f, false, paint6);
                    Path path = this.r;
                    if (path != null) {
                        path.moveTo(0.28f * f3, 0.48f * f3);
                        Path path2 = this.r;
                        if (path2 != null) {
                            path2.lineTo(0.45f * f3, 0.65f * f3);
                            Path path3 = this.r;
                            if (path3 != null) {
                                path3.lineTo(0.7f * f3, f3 * 0.35f);
                                PathMeasure pathMeasure = this.o;
                                if (pathMeasure != null) {
                                    pathMeasure.nextContour();
                                    PathMeasure pathMeasure2 = this.o;
                                    if (pathMeasure2 == null) {
                                        s.z("pathMeasure");
                                        throw null;
                                    }
                                    Path path4 = this.r;
                                    if (path4 != null) {
                                        pathMeasure2.setPath(path4, false);
                                        PathMeasure pathMeasure3 = this.o;
                                        if (pathMeasure3 == null) {
                                            s.z("pathMeasure");
                                            throw null;
                                        }
                                        float f8 = this.f9972l;
                                        if (pathMeasure3 == null) {
                                            s.z("pathMeasure");
                                            throw null;
                                        }
                                        float length = f8 * pathMeasure3.getLength();
                                        Path path5 = this.p;
                                        if (path5 != null) {
                                            pathMeasure3.getSegment(0.0f, length, path5, true);
                                            Path path6 = this.p;
                                            if (path6 == null) {
                                                s.z("pathCircleDst");
                                                throw null;
                                            }
                                            Paint paint7 = this.f9969i;
                                            if (paint7 != null) {
                                                canvas.drawPath(path6, paint7);
                                                return;
                                            } else {
                                                s.z("paint");
                                                throw null;
                                            }
                                        }
                                        s.z("pathCircleDst");
                                        throw null;
                                    }
                                    s.z("successPath");
                                    throw null;
                                }
                                s.z("pathMeasure");
                                throw null;
                            }
                            s.z("successPath");
                            throw null;
                        }
                        s.z("successPath");
                        throw null;
                    }
                    s.z("successPath");
                    throw null;
                }
                s.z("paint");
                throw null;
            }
            s.z("paint");
            throw null;
        } else if (loadingStatusEnum == LoadingStatusEnum.Failed) {
            Paint paint8 = this.f9969i;
            if (paint8 != null) {
                paint8.setColor(this.f9964d);
                this.f9970j.set(0.0f, 0.0f, f3, f3);
                RectF rectF3 = this.f9970j;
                float f9 = this.f9968h;
                Paint paint9 = this.f9969i;
                if (paint9 != null) {
                    canvas.drawArc(rectF3, f9, 360.0f, false, paint9);
                    Path path7 = this.t;
                    if (path7 != null) {
                        float f10 = f3 / 3;
                        float f11 = f2 * f10;
                        path7.moveTo(f11, f10);
                        Path path8 = this.t;
                        if (path8 != null) {
                            path8.lineTo(f10, f11);
                            PathMeasure pathMeasure4 = this.o;
                            if (pathMeasure4 != null) {
                                pathMeasure4.nextContour();
                                PathMeasure pathMeasure5 = this.o;
                                if (pathMeasure5 == null) {
                                    s.z("pathMeasure");
                                    throw null;
                                }
                                Path path9 = this.t;
                                if (path9 != null) {
                                    pathMeasure5.setPath(path9, false);
                                    PathMeasure pathMeasure6 = this.o;
                                    if (pathMeasure6 == null) {
                                        s.z("pathMeasure");
                                        throw null;
                                    }
                                    float f12 = this.m;
                                    if (pathMeasure6 == null) {
                                        s.z("pathMeasure");
                                        throw null;
                                    }
                                    float length2 = f12 * pathMeasure6.getLength();
                                    Path path10 = this.p;
                                    if (path10 != null) {
                                        pathMeasure6.getSegment(0.0f, length2, path10, true);
                                        Path path11 = this.p;
                                        if (path11 == null) {
                                            s.z("pathCircleDst");
                                            throw null;
                                        }
                                        Paint paint10 = this.f9969i;
                                        if (paint10 != null) {
                                            canvas.drawPath(path11, paint10);
                                            if (this.m == 1.0f) {
                                                Path path12 = this.s;
                                                if (path12 != null) {
                                                    path12.moveTo(f10, f10);
                                                    Path path13 = this.s;
                                                    if (path13 != null) {
                                                        path13.lineTo(f11, f11);
                                                        PathMeasure pathMeasure7 = this.o;
                                                        if (pathMeasure7 != null) {
                                                            pathMeasure7.nextContour();
                                                            PathMeasure pathMeasure8 = this.o;
                                                            if (pathMeasure8 == null) {
                                                                s.z("pathMeasure");
                                                                throw null;
                                                            }
                                                            Path path14 = this.s;
                                                            if (path14 != null) {
                                                                pathMeasure8.setPath(path14, false);
                                                                PathMeasure pathMeasure9 = this.o;
                                                                if (pathMeasure9 == null) {
                                                                    s.z("pathMeasure");
                                                                    throw null;
                                                                }
                                                                float f13 = this.n;
                                                                if (pathMeasure9 == null) {
                                                                    s.z("pathMeasure");
                                                                    throw null;
                                                                }
                                                                float length3 = f13 * pathMeasure9.getLength();
                                                                Path path15 = this.p;
                                                                if (path15 != null) {
                                                                    pathMeasure9.getSegment(0.0f, length3, path15, true);
                                                                    Path path16 = this.p;
                                                                    if (path16 == null) {
                                                                        s.z("pathCircleDst");
                                                                        throw null;
                                                                    }
                                                                    Paint paint11 = this.f9969i;
                                                                    if (paint11 != null) {
                                                                        canvas.drawPath(path16, paint11);
                                                                        return;
                                                                    } else {
                                                                        s.z("paint");
                                                                        throw null;
                                                                    }
                                                                }
                                                                s.z("pathCircleDst");
                                                                throw null;
                                                            }
                                                            s.z("failurePathLeft");
                                                            throw null;
                                                        }
                                                        s.z("pathMeasure");
                                                        throw null;
                                                    }
                                                    s.z("failurePathLeft");
                                                    throw null;
                                                }
                                                s.z("failurePathLeft");
                                                throw null;
                                            }
                                            return;
                                        }
                                        s.z("paint");
                                        throw null;
                                    }
                                    s.z("pathCircleDst");
                                    throw null;
                                }
                                s.z("failurePathRight");
                                throw null;
                            }
                            s.z("pathMeasure");
                            throw null;
                        }
                        s.z("failurePathRight");
                        throw null;
                    }
                    s.z("failurePathRight");
                    throw null;
                }
                s.z("paint");
                throw null;
            }
            s.z("paint");
            throw null;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (int) ((2 * this.f9966f) + this.f9965e + getPaddingLeft() + getPaddingRight());
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != 1073741824) {
            size2 = (int) ((2 * this.f9966f) + this.f9965e + getPaddingTop() + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    public final void q(Float f2, LoadingStatusEnum status) {
        s.h(status, "status");
        int i2 = a.a[status.ordinal()];
        if (i2 == 1) {
            s(f2 == null ? 0.0f : f2.floatValue());
        } else if (i2 == 2) {
            j();
        } else if (i2 != 3) {
        } else {
            i();
        }
    }

    public final void setOnFailedAnimFinished(kotlin.jvm.b.a<u> aVar) {
        this.v = aVar;
    }

    public final void setOnSuccessAnimFinished(kotlin.jvm.b.a<u> aVar) {
        this.u = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressLoadingStatusView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.f9968h = -90.0f;
        this.f9971k = LoadingStatusEnum.Loading;
        c(context, attributeSet);
        d();
        e();
        this.f9970j = new RectF();
    }
}
