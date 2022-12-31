package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ClockHandView extends View {
    private ValueAnimator a;
    private boolean b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f4647d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4648e;

    /* renamed from: f  reason: collision with root package name */
    private int f4649f;

    /* renamed from: g  reason: collision with root package name */
    private final List<d> f4650g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4651h;

    /* renamed from: i  reason: collision with root package name */
    private final float f4652i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f4653j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f4654k;
    @Px

    /* renamed from: l  reason: collision with root package name */
    private final int f4655l;
    private float m;
    private boolean n;
    private c o;
    private double p;
    private int q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void c(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void f(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    private void c(Canvas canvas) {
        int width;
        int height = getHeight() / 2;
        float width2 = getWidth() / 2;
        float f2 = height;
        this.f4653j.setStrokeWidth(0.0f);
        canvas.drawCircle((this.q * ((float) Math.cos(this.p))) + width2, (this.q * ((float) Math.sin(this.p))) + f2, this.f4651h, this.f4653j);
        double sin = Math.sin(this.p);
        double cos = Math.cos(this.p);
        this.f4653j.setStrokeWidth(this.f4655l);
        canvas.drawLine(width2, f2, width + ((int) (cos * r6)), height + ((int) (r6 * sin)), this.f4653j);
        canvas.drawCircle(width2, f2, this.f4652i, this.f4653j);
    }

    private int e(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f3 - (getHeight() / 2), f2 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + BaseBlurEffect.ROTATION_360 : degrees;
    }

    private Pair<Float, Float> h(float f2) {
        float f3 = f();
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f3), Float.valueOf(f2));
    }

    private boolean i(float f2, float f3, boolean z, boolean z2, boolean z3) {
        float e2 = e(f2, f3);
        boolean z4 = false;
        boolean z5 = f() != e2;
        if (z2 && z5) {
            return true;
        }
        if (z5 || z) {
            if (z3 && this.b) {
                z4 = true;
            }
            m(e2, z4);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.m = f3;
        this.p = Math.toRadians(f3 - 90.0f);
        float width = (getWidth() / 2) + (this.q * ((float) Math.cos(this.p)));
        float height = (getHeight() / 2) + (this.q * ((float) Math.sin(this.p)));
        RectF rectF = this.f4654k;
        int i2 = this.f4651h;
        rectF.set(width - i2, height - i2, width + i2, height + i2);
        for (d dVar : this.f4650g) {
            dVar.f(f3, z);
        }
        invalidate();
    }

    public void b(d dVar) {
        this.f4650g.add(dVar);
    }

    public RectF d() {
        return this.f4654k;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 360.0d)
    public float f() {
        return this.m;
    }

    public int g() {
        return this.f4651h;
    }

    public void j(boolean z) {
        this.b = z;
    }

    public void k(@Dimension int i2) {
        this.q = i2;
        invalidate();
    }

    public void l(@FloatRange(from = 0.0d, to = 360.0d) float f2) {
        m(f2, false);
    }

    public void m(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            n(f2, false);
            return;
        }
        Pair<Float, Float> h2 = h(f2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h2.first).floatValue(), ((Float) h2.second).floatValue());
        this.a = ofFloat;
        ofFloat.setDuration(200L);
        this.a.addUpdateListener(new a());
        this.a.addListener(new b(this));
        this.a.start();
    }

    public void o(c cVar) {
        this.o = cVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        l(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.c);
                int i3 = (int) (y - this.f4647d);
                this.f4648e = (i2 * i2) + (i3 * i3) > this.f4649f;
                boolean z4 = this.n;
                z = actionMasked == 1;
                z2 = z4;
            } else {
                z = false;
                z2 = false;
            }
            z3 = false;
        } else {
            this.c = x;
            this.f4647d = y;
            this.f4648e = true;
            this.n = false;
            z = false;
            z2 = false;
            z3 = true;
        }
        boolean i4 = i(x, y, z2, z3, z) | this.n;
        this.n = i4;
        if (i4 && z && (cVar = this.o) != null) {
            cVar.c(e(x, y), this.f4648e);
        }
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4650g = new ArrayList();
        Paint paint = new Paint();
        this.f4653j = paint;
        this.f4654k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i2, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f4651h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f4655l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f4652i = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f4649f = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }
}
