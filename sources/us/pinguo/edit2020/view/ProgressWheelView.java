package us.pinguo.edit2020.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlinx.coroutines.v1;
import us.pinguo.edit2020.R;
/* compiled from: ProgressWheelView.kt */
/* loaded from: classes4.dex */
public final class ProgressWheelView extends View implements GestureDetector.OnGestureListener {
    private final ValueAnimator a;
    private final OverScroller b;
    private final GestureDetector c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10708d;

    /* renamed from: e  reason: collision with root package name */
    private float f10709e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f10710f;

    /* renamed from: g  reason: collision with root package name */
    private final DisplayMetrics f10711g;

    /* renamed from: h  reason: collision with root package name */
    private float f10712h;

    /* renamed from: i  reason: collision with root package name */
    private float f10713i;

    /* renamed from: j  reason: collision with root package name */
    private int f10714j;

    /* renamed from: k  reason: collision with root package name */
    private int f10715k;

    /* renamed from: l  reason: collision with root package name */
    private final float f10716l;
    private float m;
    private float n;
    private j0 o;
    private boolean p;
    private boolean q;
    private boolean r;
    private kotlin.jvm.b.q<? super Float, ? super Boolean, ? super Boolean, kotlin.u> s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private v1 z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressWheelView(Context context) {
        this(context, null, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ProgressWheelView this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f10709e = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    public static /* synthetic */ void setValue$edit2020_release$default(ProgressWheelView progressWheelView, float f2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        progressWheelView.setValue$edit2020_release(f2, z, z2);
    }

    public final boolean c() {
        return this.x;
    }

    public final float d() {
        return this.n;
    }

    public final void f() {
        kotlin.jvm.b.q<? super Float, ? super Boolean, ? super Boolean, kotlin.u> qVar = this.s;
        if (qVar == null) {
            return;
        }
        qVar.invoke(Float.valueOf(this.n), Boolean.FALSE, Boolean.TRUE);
    }

    public final void g() {
        int b;
        int b2;
        OverScroller overScroller = this.b;
        b = kotlin.y.c.b(this.f10709e);
        b2 = kotlin.y.c.b(this.f10709e);
        overScroller.startScroll(b, 0, -b2, 0);
        invalidate();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.y = true;
        this.b.forceFinished(true);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0235 A[EDGE_INSN: B:109:0x0235->B:78:0x0235 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.ProgressWheelView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        int b;
        int b2;
        if (f2 > 0.0f) {
            b2 = kotlin.y.c.b(this.f10712h);
            this.b.fling((int) this.f10709e, 0, -((int) f2), 0, b2, (int) this.f10709e, 0, 0);
        } else {
            OverScroller overScroller = this.b;
            float f4 = this.f10709e;
            b = kotlin.y.c.b(this.f10713i);
            overScroller.fling((int) f4, 0, -((int) f2), 0, (int) f4, b, 0, 0);
        }
        invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f10709e += f2;
        invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int b;
        if (!isEnabled() || motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = true;
            this.a.cancel();
            kotlin.jvm.b.q<? super Float, ? super Boolean, ? super Boolean, kotlin.u> qVar = this.s;
            if (qVar != null) {
                qVar.invoke(Float.valueOf(this.n), Boolean.valueOf(this.p), Boolean.FALSE);
            }
        } else if (action == 1) {
            this.p = false;
            kotlin.jvm.b.q<? super Float, ? super Boolean, ? super Boolean, kotlin.u> qVar2 = this.s;
            if (qVar2 != null) {
                qVar2.invoke(Float.valueOf(this.n), Boolean.valueOf(this.p), Boolean.FALSE);
            }
        } else if (action == 3) {
            this.p = false;
            kotlin.jvm.b.q<? super Float, ? super Boolean, ? super Boolean, kotlin.u> qVar3 = this.s;
            if (qVar3 != null) {
                qVar3.invoke(Float.valueOf(this.n), Boolean.valueOf(this.p), Boolean.FALSE);
            }
        }
        boolean onTouchEvent = this.c.onTouchEvent(motionEvent);
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.w && this.b.isFinished()) {
            b = kotlin.y.c.b(this.n);
            float f2 = b;
            float f3 = this.n;
            if (!(f3 == f2)) {
                float f4 = this.m;
                this.a.cancel();
                this.a.setFloatValues(f3 * f4, f2 * f4);
                this.a.setDuration(300L);
                this.a.start();
            }
        }
        return onTouchEvent;
    }

    public final void setAutoHideZeroDot(boolean z) {
        this.x = z;
    }

    public final void setEnableSnap(boolean z) {
        this.w = z;
    }

    public final void setEnableVibrate(boolean z) {
        this.t = z;
    }

    public final void setHideCentralLine(boolean z) {
        this.v = z;
    }

    public final void setMaxOffset(float f2) {
        this.f10713i = f2;
    }

    public final void setMaxValue(int i2) {
        this.f10714j = i2;
    }

    public final void setMinOffset(float f2) {
        this.f10712h = f2;
    }

    public final void setMinValue(int i2) {
        this.f10715k = i2;
    }

    public final void setOnWheelChangedListener$edit2020_release(j0 j0Var) {
        this.o = j0Var;
    }

    public final void setStepNumber(int i2) {
        this.u = i2;
    }

    public final void setTouchMovingStatus(kotlin.jvm.b.q<? super Float, ? super Boolean, ? super Boolean, kotlin.u> qVar) {
        this.s = qVar;
    }

    public final void setValue$edit2020_release(float f2, boolean z, boolean z2) {
        int b;
        if (z) {
            float f3 = this.m * f2;
            float f4 = this.f10709e;
            b = kotlin.y.c.b(f3 - f4);
            this.b.startScroll((int) f4, 0, b, 0);
        } else {
            this.b.forceFinished(true);
            this.f10709e = Float.NaN;
            this.n = f2;
        }
        this.y = z2;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressWheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        ValueAnimator valueAnimator = new ValueAnimator();
        this.a = valueAnimator;
        this.b = new OverScroller(getContext());
        this.c = new GestureDetector(getContext(), this);
        this.f10708d = new Rect();
        this.f10709e = Float.NaN;
        Paint paint = new Paint(1);
        this.f10710f = paint;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        kotlin.jvm.internal.s.g(displayMetrics, "context.resources.displayMetrics");
        this.f10711g = displayMetrics;
        this.f10712h = -45.0f;
        this.f10713i = 45.0f;
        this.f10714j = 45;
        this.f10715k = -45;
        this.u = 40;
        this.v = true;
        this.y = true;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.view.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ProgressWheelView.a(ProgressWheelView.this, valueAnimator2);
            }
        });
        paint.setColor(-6710887);
        paint.setStyle(Paint.Style.STROKE);
        float f2 = displayMetrics.density;
        this.f10716l = f2;
        paint.setStrokeWidth(f2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheelView, i2, 0);
        kotlin.jvm.internal.s.g(obtainStyledAttributes, "context.obtainStyledAttr…eelView, defStyleAttr, 0)");
        this.t = obtainStyledAttributes.getBoolean(R.styleable.ProgressWheelView_enableVibrate, false);
        this.u = obtainStyledAttributes.getInt(R.styleable.ProgressWheelView_stepNumber, 40);
        this.v = obtainStyledAttributes.getBoolean(R.styleable.ProgressWheelView_hideCentralLine, true);
        this.w = obtainStyledAttributes.getBoolean(R.styleable.ProgressWheelView_enableSnap, false);
        this.f10715k = obtainStyledAttributes.getInt(R.styleable.ProgressWheelView_minValue, -45);
        this.f10714j = obtainStyledAttributes.getInt(R.styleable.ProgressWheelView_maxValue, 45);
        this.f10712h = obtainStyledAttributes.getFloat(R.styleable.ProgressWheelView_minOffset, -45.0f);
        this.f10713i = obtainStyledAttributes.getFloat(R.styleable.ProgressWheelView_maxOffset, 45.0f);
        this.x = obtainStyledAttributes.getBoolean(R.styleable.ProgressWheelView_autoHideZeroDot, false);
        obtainStyledAttributes.recycle();
    }
}
