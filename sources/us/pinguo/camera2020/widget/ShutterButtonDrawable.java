package us.pinguo.camera2020.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Keep;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.utils.l;
import us.pinguo.ui.widget.j;
import us.pinguo.util.v;
/* loaded from: classes3.dex */
public class ShutterButtonDrawable extends Drawable {
    private static int u = v.a().getResources().getColor(R.color.color_camera_theme_black);
    private static int v = Color.parseColor("#EEEEEE");
    private int a;
    private float b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9500d;

    /* renamed from: e  reason: collision with root package name */
    private int f9501e;

    /* renamed from: f  reason: collision with root package name */
    private float f9502f;

    /* renamed from: g  reason: collision with root package name */
    private float f9503g;

    /* renamed from: h  reason: collision with root package name */
    private float f9504h;

    /* renamed from: j  reason: collision with root package name */
    private Paint f9506j;

    /* renamed from: l  reason: collision with root package name */
    private ValueAnimator f9508l;
    private ValueAnimator m;
    private ValueAnimator n;
    private boolean o;
    private boolean p;
    private float r;

    /* renamed from: i  reason: collision with root package name */
    private State f9505i = State.CAMERA;

    /* renamed from: k  reason: collision with root package name */
    private RectF f9507k = new RectF();
    private boolean q = true;
    private float s = 0.0f;
    private Drawable t = v.a().getResources().getDrawable(R.drawable.shutter_button_video_light);

    /* loaded from: classes3.dex */
    public enum State {
        CAMERA(6.0f, -13816531, 0.0f, 0.72f),
        CAMERA_TP(6.0f, -1, 0.0f, 0.72f),
        CAMERA_TIMER(6.0f, -13816531, 0.3f, 0.72f),
        CAMERA_TIMER_TP(6.0f, -1, 0.3f, 0.72f),
        VIDEO(6.0f, ShutterButtonDrawable.u, 0.0f, 0.72f, 0.0f, true),
        VIDEO_LONG_TOUCH(6.0f, ShutterButtonDrawable.v, 0.0f, 1.0f, 0.0f, true),
        VIDEO_TIMER(6.0f, ShutterButtonDrawable.v, 0.3f, 0.72f, 3.0f, true),
        VIDEO_TIMER_RECORD(6.0f, ShutterButtonDrawable.v, 0.27f, 1.0f, 3.0f, true);
        
        int circleColor;
        float circleWidth;
        boolean isVideoState;
        float scaleRate;
        float squareCornerRadius;
        float squareRadiusRate;

        State(float f2, int i2, float f3, float f4) {
            this(f2, i2, f3, f4, 3.0f, false);
        }

        public void setSquareCornerRadius(float f2) {
            this.squareCornerRadius = f2;
        }

        State(float f2, int i2, float f3, float f4, float f5, boolean z) {
            float f6 = Resources.getSystem().getDisplayMetrics().density;
            this.circleWidth = f2 * f6;
            this.circleColor = i2;
            this.squareRadiusRate = f3;
            this.scaleRate = f4;
            this.squareCornerRadius = f5 * f6;
            this.isVideoState = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends j {
        a() {
        }

        @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            float f2 = ShutterButtonDrawable.this.f9505i.scaleRate;
            ShutterButtonDrawable shutterButtonDrawable = ShutterButtonDrawable.this;
            shutterButtonDrawable.n = ObjectAnimator.ofFloat(shutterButtonDrawable, "scaleRate", shutterButtonDrawable.f9504h, f2);
            ShutterButtonDrawable.this.n.setDuration(150L);
            ShutterButtonDrawable.this.n.start();
        }
    }

    public ShutterButtonDrawable(State state) {
        Paint paint = new Paint(1);
        this.f9506j = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f9500d = 100;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        this.b = 8.0f * f2;
        this.c = (int) ((f2 * 5.0f) + 0.5f);
        u(state, false);
    }

    private int g(int i2, float f2) {
        return Color.argb(Math.round(Color.alpha(i2) * f2), Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(int i2, int i3, ValueAnimator valueAnimator) {
        this.a = l.a(valueAnimator.getAnimatedFraction(), i2, i3);
        this.b = ((Float) valueAnimator.getAnimatedValue("circleWidth")).floatValue();
        this.f9503g = ((Float) valueAnimator.getAnimatedValue("squareRadiusRate")).floatValue();
        this.f9502f = ((Float) valueAnimator.getAnimatedValue("squareCornerRadius")).floatValue();
        this.f9504h = ((Float) valueAnimator.getAnimatedValue("scaleRate")).floatValue();
        this.s = ((Float) valueAnimator.getAnimatedValue("buttonProgress")).floatValue();
        invalidateSelf();
    }

    private float o(float f2, int i2) {
        View view = (View) ((View) getCallback()).getParent().getParent();
        if (view != null) {
            int height = view.getHeight();
            if (height <= 0) {
                return f2;
            }
            float f3 = height / i2;
            return f2 > f3 ? f3 : f2;
        }
        throw new RuntimeException("获取底部bar高度失败");
    }

    private boolean p() {
        return this.f9503g > 0.0f;
    }

    private void q(boolean z) {
        this.p = z;
        if (z) {
            w();
        } else {
            y();
        }
        invalidateSelf();
    }

    private void u(State state, boolean z) {
        if (this.o) {
            if (state == State.CAMERA) {
                state = State.CAMERA_TP;
            } else if (state == State.CAMERA_TIMER) {
                state = State.CAMERA_TIMER_TP;
            }
        } else if (state == State.CAMERA_TP) {
            state = State.CAMERA;
        } else if (state == State.CAMERA_TIMER_TP) {
            state = State.CAMERA_TIMER;
        }
        State state2 = State.VIDEO;
        if (state == state2) {
            int width = getBounds().width();
            if (width == 0) {
                width = v.a().getResources().getDimensionPixelSize(R.dimen.shutter_size_big);
            }
            state.setSquareCornerRadius((width * state.squareRadiusRate) / 2.0f);
        }
        float f2 = 0.0f;
        if (this.f9505i != state && z) {
            this.f9505i = state;
            if (state != state2) {
                if (state != State.CAMERA && state != State.CAMERA_TP) {
                    if (state != State.VIDEO_TIMER && state != State.VIDEO_TIMER_RECORD) {
                        this.s = 0.0f;
                    } else {
                        this.s = 1.0f;
                    }
                }
                x(f2);
                return;
            }
            f2 = 1.0f;
            x(f2);
            return;
        }
        ValueAnimator valueAnimator = this.f9508l;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f9508l.cancel();
        }
        this.f9505i = state;
        this.a = state.circleColor;
        this.b = state.circleWidth;
        this.f9503g = state.squareRadiusRate;
        this.f9502f = state.squareCornerRadius;
        this.f9504h = state.scaleRate;
        if (state != State.VIDEO_TIMER && state != State.VIDEO_TIMER_RECORD && state != state2) {
            this.s = 0.0f;
        } else {
            this.s = 1.0f;
        }
        invalidateSelf();
    }

    private void w() {
        ValueAnimator valueAnimator = this.f9508l;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f9508l.end();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleRate", this.f9504h, 0.66f);
        this.m = ofFloat;
        ofFloat.setDuration(150L);
        this.m.start();
    }

    private void x(float f2) {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.n.cancel();
        }
        ValueAnimator valueAnimator2 = this.m;
        if (valueAnimator2 != null && valueAnimator2.isStarted()) {
            this.m.cancel();
        }
        ValueAnimator valueAnimator3 = this.f9508l;
        if (valueAnimator3 != null && valueAnimator3.isStarted()) {
            this.f9508l.cancel();
        }
        final int i2 = this.a;
        State state = this.f9505i;
        final int i3 = state.circleColor;
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("circleWidth", this.b, state.circleWidth), PropertyValuesHolder.ofFloat("squareRadiusRate", this.f9503g, this.f9505i.squareRadiusRate), PropertyValuesHolder.ofFloat("squareCornerRadius", this.f9502f, this.f9505i.squareCornerRadius), PropertyValuesHolder.ofFloat("scaleRate", this.f9504h, this.f9505i.scaleRate), PropertyValuesHolder.ofFloat("buttonProgress", this.s, f2));
        this.f9508l = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(200L);
        this.f9508l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.camera2020.widget.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                ShutterButtonDrawable.this.n(i2, i3, valueAnimator4);
            }
        });
        this.f9508l.start();
    }

    private void y() {
        ValueAnimator valueAnimator = this.f9508l;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 != null && valueAnimator2.isStarted()) {
                this.m.addListener(new a());
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleRate", this.f9504h, this.f9505i.scaleRate);
            this.n = ofFloat;
            ofFloat.setDuration(150L);
            this.n.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect bounds = getBounds();
        float centerX = bounds.centerX();
        float centerY = bounds.centerY();
        this.r = (bounds.width() / 2.0f) - (this.b / 2.0f);
        float o = o(this.f9504h, bounds.height());
        this.r *= o;
        if (this.o) {
            this.a = u;
        }
        this.f9506j.setColor(this.a);
        float f2 = this.c;
        this.f9506j.setStrokeWidth(f2);
        this.f9506j.setStyle(Paint.Style.STROKE);
        if (this.o) {
            if (((this.a >> 24) & 255) >= 250) {
                this.f9506j.setShadowLayer(5.0f, 0.0f, 0.0f, 1593835520);
            } else {
                this.f9506j.setShadowLayer(0.0f, 0.0f, 0.0f, 1593835520);
            }
        } else {
            this.f9506j.setShadowLayer(0.0f, 0.0f, 0.0f, 1593835520);
        }
        canvas.drawCircle(centerX, centerY, this.r, this.f9506j);
        if (this.f9505i.isVideoState) {
            this.f9506j.setColor(-1025965);
            RectF rectF = this.f9507k;
            float f3 = this.r;
            rectF.set(centerX - f3, centerY - f3, centerX + f3, f3 + centerY);
            int i4 = this.f9501e;
            if (i4 > 0 && (i3 = this.f9500d) > 0) {
                float f4 = (i4 / i3) * 360.0f;
                this.f9506j.setColor(-1025965);
                RectF rectF2 = this.f9507k;
                float f5 = this.r;
                rectF2.set(centerX - f5, centerY - f5, centerX + f5, f5 + centerY);
                canvas.drawArc(this.f9507k, -90.0f, f4, false, this.f9506j);
            }
        }
        if (p()) {
            float width = (bounds.width() / 2.0f) * this.f9503g * o;
            this.f9507k.set(centerX - width, centerY - width, centerX + width, width + centerY);
            this.f9506j.setStyle(Paint.Style.FILL);
            if (this.q) {
                i2 = this.f9505i.isVideoState ? -1025965 : this.a;
            } else {
                i2 = -3355444;
            }
            this.f9506j.setColor(i2);
            RectF rectF3 = this.f9507k;
            float f6 = this.f9502f;
            canvas.drawRoundRect(rectF3, f6, f6, this.f9506j);
        }
        State state = this.f9505i;
        if ((state == State.VIDEO || state == State.CAMERA || state == State.CAMERA_TP) && this.s >= 0.001f) {
            int intrinsicWidth = this.t.getIntrinsicWidth();
            int intrinsicHeight = this.t.getIntrinsicHeight();
            float f7 = intrinsicWidth / 2;
            float f8 = this.s;
            int i5 = ((int) (centerX - f7)) + ((int) ((((this.r - (f2 / 2.0f)) - f7) * (1.0f - f8)) + 0.5f));
            int i6 = (int) (centerY - (intrinsicHeight / 2));
            this.t.setBounds(i5, i6, intrinsicWidth + i5, intrinsicHeight + i6);
            this.f9506j.setColor(g(u, this.s));
            this.f9506j.setStyle(Paint.Style.FILL);
            j();
            this.t.setAlpha((int) ((f8 * 255.0f) + 0.5f));
            this.t.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public State h() {
        return this.f9505i;
    }

    public int i() {
        return this.f9500d;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public float j() {
        return this.r;
    }

    public boolean k(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == 16842910) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean l(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == 16842919) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean l2 = l(iArr);
        us.pinguo.common.log.a.k("mPressed:" + this.p + " pressed:" + l2, new Object[0]);
        if (this.p != l2) {
            q(l2);
            return true;
        }
        boolean k2 = k(iArr);
        if (this.q != k2) {
            this.q = k2;
            invalidateSelf();
        }
        return false;
    }

    public void r(int i2) {
        this.f9500d = i2;
    }

    public void s(int i2) {
        this.f9501e = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f9506j.getAlpha()) {
            this.f9506j.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9506j.setColorFilter(colorFilter);
    }

    @Keep
    void setScaleRate(float f2) {
        if (f2 != this.f9504h) {
            this.f9504h = f2;
            invalidateSelf();
        }
    }

    public void t(State state) {
        if (this.f9505i == state) {
            return;
        }
        u(state, true);
    }

    public void v(boolean z) {
        if (this.o != z) {
            this.o = z;
            u(this.f9505i, false);
        }
        if (!this.o) {
            v = Color.parseColor("#EEEEEE");
            this.t = v.a().getResources().getDrawable(R.drawable.shutter_button_video_dark);
            u = v.a().getResources().getColor(R.color.color_camera_theme_black);
        } else {
            this.t = v.a().getResources().getDrawable(R.drawable.shutter_button_video_light);
            Resources resources = v.a().getResources();
            int i2 = R.color.color_camera_theme_light;
            u = resources.getColor(i2);
            v = v.a().getResources().getColor(i2);
        }
        invalidateSelf();
    }
}
