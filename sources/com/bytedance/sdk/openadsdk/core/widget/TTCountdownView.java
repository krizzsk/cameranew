package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* loaded from: classes.dex */
public class TTCountdownView extends View {
    public static final String a = t.a(o.a(), "tt_count_down_view");
    private ValueAnimator A;
    private boolean B;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f1854d;

    /* renamed from: e  reason: collision with root package name */
    private int f1855e;

    /* renamed from: f  reason: collision with root package name */
    private float f1856f;

    /* renamed from: g  reason: collision with root package name */
    private float f1857g;

    /* renamed from: h  reason: collision with root package name */
    private float f1858h;

    /* renamed from: i  reason: collision with root package name */
    private int f1859i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1860j;

    /* renamed from: k  reason: collision with root package name */
    private float f1861k;

    /* renamed from: l  reason: collision with root package name */
    private float f1862l;
    private float m;
    private String n;
    private boolean o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Paint s;
    private float t;
    private float u;
    private RectF v;
    private a w;
    private AnimatorSet x;
    private ValueAnimator y;
    private ValueAnimator z;

    /* loaded from: classes.dex */
    public interface a {
    }

    public TTCountdownView(Context context) {
        this(context, null);
    }

    private void c() {
        float f2 = this.f1858h;
        this.v = new RectF(-f2, -f2, f2, f2);
    }

    private int d() {
        return (int) ((((this.f1856f / 2.0f) + this.f1858h) * 2.0f) + a(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.t, 0.0f);
        this.z = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.z.setDuration(a(this.t, this.f1861k) * 1000.0f);
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownView.this.t = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.z;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.u, 0.0f);
        this.y = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.y.setDuration(a(this.u, this.f1862l) * 1000.0f);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownView.this.u = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.y;
    }

    public float a(float f2, float f3) {
        return f2 * f3;
    }

    public float a(float f2, int i2) {
        return i2 * f2;
    }

    public a getCountdownListener() {
        return this.w;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            size = d();
        }
        if (mode2 != 1073741824) {
            size2 = d();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCountDownTime(int i2) {
        float f2 = i2;
        this.f1862l = f2;
        this.f1861k = f2;
        a();
    }

    public void setCountdownListener(a aVar) {
        this.w = aVar;
    }

    public TTCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.s.getFontMetrics();
        String str2 = a;
        if (this.o) {
            str = "" + ((int) Math.ceil(a(this.u, this.f1862l)));
        } else {
            str = this.n;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        canvas.drawText(str2, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.s);
        canvas.restore();
    }

    private void b() {
        Paint paint = new Paint(1);
        this.p = paint;
        paint.setColor(this.b);
        this.p.setStrokeWidth(this.f1856f);
        this.p.setAntiAlias(true);
        this.p.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.q = paint2;
        paint2.setColor(this.f1854d);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(this.f1856f);
        this.q.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.r = paint3;
        paint3.setColor(this.c);
        this.r.setAntiAlias(true);
        this.r.setStrokeWidth(this.f1856f / 2.0f);
        this.r.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.s = paint4;
        paint4.setColor(this.f1855e);
        this.r.setAntiAlias(true);
        this.s.setTextSize(this.f1857g);
        this.s.setTextAlign(Paint.Align.CENTER);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = Color.parseColor("#fce8b6");
        this.c = Color.parseColor("#f0f0f0");
        this.f1854d = Color.parseColor("#ffffff");
        this.f1855e = Color.parseColor("#7c7c7c");
        this.f1856f = 2.0f;
        this.f1857g = 12.0f;
        this.f1858h = 18.0f;
        this.f1859i = BaseBlurEffect.ROTATION_270;
        this.f1860j = false;
        this.f1861k = 5.0f;
        this.f1862l = 5.0f;
        this.m = 0.8f;
        this.n = a;
        this.o = false;
        this.t = 1.0f;
        this.u = 1.0f;
        this.B = false;
        this.f1856f = a(2.0f);
        this.f1858h = a(18.0f);
        this.f1857g = b(12.0f);
        this.f1859i %= BaseBlurEffect.ROTATION_360;
        b();
        c();
    }

    public void a() {
        AnimatorSet animatorSet = this.x;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.x = null;
        }
        ValueAnimator valueAnimator = this.A;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.A = null;
        }
        ValueAnimator valueAnimator2 = this.y;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.y = null;
        }
        ValueAnimator valueAnimator3 = this.z;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.z = null;
        }
        this.t = 1.0f;
        this.u = 1.0f;
        invalidate();
    }

    private void b(Canvas canvas) {
        float f2;
        canvas.save();
        float a2 = a(this.t, BaseBlurEffect.ROTATION_360);
        if (this.f1860j) {
            f2 = this.f1859i - a2;
        } else {
            f2 = this.f1859i;
        }
        canvas.drawCircle(0.0f, 0.0f, this.f1858h, this.q);
        canvas.drawCircle(0.0f, 0.0f, this.f1858h, this.r);
        canvas.drawArc(this.v, f2, a2, false, this.p);
        canvas.restore();
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private float b(float f2) {
        return TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }
}
