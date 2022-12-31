package us.pinguo.camera2020.view.focusview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
/* compiled from: PGFocusShape.kt */
/* loaded from: classes3.dex */
public abstract class PGFocusShape extends View {
    public static final a q = new a(null);
    private static final int r = 0;
    private static final int s = 1;
    private int a;
    private Paint b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f9401d;

    /* renamed from: e  reason: collision with root package name */
    private float f9402e;

    /* renamed from: f  reason: collision with root package name */
    private float f9403f;

    /* renamed from: g  reason: collision with root package name */
    private float f9404g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f9405h;

    /* renamed from: i  reason: collision with root package name */
    private int f9406i;

    /* renamed from: j  reason: collision with root package name */
    private float f9407j;

    /* renamed from: k  reason: collision with root package name */
    private float f9408k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9409l;
    private boolean m;
    private boolean n;
    private long o;
    private int p;

    /* compiled from: PGFocusShape.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final int a() {
            return PGFocusShape.r;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PGFocusShape(Context context) {
        this(context, null);
        s.h(context, "context");
    }

    public void b() {
        long h2 = h();
        int i2 = this.p;
        if (i2 == 0) {
            float f2 = ((float) h2) / 100;
            float f3 = this.f9403f;
            float f4 = (float) (((f2 * 0.3d) + 0.7d) * f3);
            this.f9404g = f4;
            if (f4 > f3) {
                this.f9404g = f3;
            }
            float f5 = 5 - (f2 * 2);
            this.c = f5;
            if (f5 <= 3.0f) {
                this.c = 3.0f;
            }
        } else if (i2 == 1) {
            float f6 = ((float) h2) / 150;
            float f7 = this.f9403f;
            float f8 = (float) ((1 - (f6 * 0.05d)) * f7);
            this.f9404g = f8;
            if (f8 <= f7 * 0.95d) {
                this.f9404g = (float) (f7 * 0.95d);
            }
            float f9 = 3 + f6;
            this.c = f9;
            if (f9 >= 4.0f) {
                this.c = 4.0f;
            }
        } else if (i2 != 2) {
        } else {
            float f10 = ((float) h2) / 100;
            float f11 = this.f9403f;
            float f12 = (float) (((f10 * 0.05d) + 0.95d) * f11);
            this.f9404g = f12;
            if (f12 >= f11) {
                this.f9404g = f11;
            }
            float f13 = 4 - f10;
            this.c = f13;
            if (f13 <= 3.0f) {
                this.c = 3.0f;
            }
        }
    }

    public void c(Canvas canvas) {
        float f2 = 10;
        this.f9408k = this.f9404g / f2;
        float sqrt = ((float) Math.sqrt(2.0d)) / f2;
        if (this.f9409l) {
            if (canvas != null) {
                float f3 = this.f9401d;
                float f4 = this.f9404g;
                float f5 = this.f9402e;
                canvas.drawLine(f3 - f4, f5, (f3 - f4) + this.f9408k, f5, this.f9405h);
            }
            if (canvas != null) {
                float f6 = this.f9401d;
                float f7 = this.f9402e;
                float f8 = this.f9404g;
                canvas.drawLine(f6, f7 - f8, f6, (f7 - f8) + this.f9408k, this.f9405h);
            }
            if (canvas != null) {
                float f9 = this.f9401d;
                float f10 = this.f9404g;
                float f11 = this.f9402e;
                canvas.drawLine((f9 + f10) - this.f9408k, f11, f9 + f10, f11, this.f9405h);
            }
            if (canvas != null) {
                float f12 = this.f9401d;
                float f13 = this.f9402e;
                float f14 = this.f9404g;
                canvas.drawLine(f12, (f13 + f14) - this.f9408k, f12, f13 + f14, this.f9405h);
            }
        }
        if (this.m) {
            if (canvas != null) {
                float f15 = this.f9401d;
                float f16 = this.f9403f;
                float f17 = this.f9402e;
                float f18 = this.f9408k;
                canvas.drawLine(f15 - (sqrt * f16), f17 - f18, (f15 - (sqrt * f16)) + (f16 * 0.05f), f17 - f18, this.f9405h);
            }
            if (canvas != null) {
                float f19 = this.f9401d;
                float f20 = this.f9403f;
                float f21 = this.f9402e;
                float f22 = this.f9408k;
                canvas.drawLine(f19 - (sqrt * f20), f21 - f22, f19 - (f20 * sqrt), f22 + f21, this.f9405h);
            }
            if (canvas != null) {
                float f23 = this.f9401d;
                float f24 = this.f9403f;
                float f25 = this.f9402e;
                float f26 = this.f9408k;
                canvas.drawLine(f23 - (sqrt * f24), f25 + f26, (f23 - (sqrt * f24)) + (f24 * 0.05f), f26 + f25, this.f9405h);
            }
            if (canvas != null) {
                float f27 = this.f9401d;
                float f28 = this.f9403f;
                float f29 = this.f9402e;
                float f30 = this.f9408k;
                canvas.drawLine(((sqrt * f28) + f27) - (f28 * 0.05f), f29 - f30, f27 + (f28 * sqrt), f29 - f30, this.f9405h);
            }
            if (canvas != null) {
                float f31 = this.f9401d;
                float f32 = this.f9403f;
                float f33 = this.f9402e;
                float f34 = this.f9408k;
                canvas.drawLine((sqrt * f32) + f31, f33 - f34, f31 + (f32 * sqrt), f34 + f33, this.f9405h);
            }
            if (canvas == null) {
                return;
            }
            float f35 = this.f9401d;
            float f36 = this.f9403f;
            float f37 = this.f9402e;
            float f38 = this.f9408k;
            canvas.drawLine(((sqrt * f36) + f35) - (0.05f * f36), f37 + f38, (sqrt * f36) + f35, f38 + f37, this.f9405h);
        }
    }

    public abstract void d(Canvas canvas);

    /* JADX INFO: Access modifiers changed from: protected */
    public final float e() {
        return this.f9401d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float f() {
        return this.f9402e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return this.p;
    }

    public long h() {
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        int i2 = (currentTimeMillis > 100L ? 1 : (currentTimeMillis == 100L ? 0 : -1));
        if (i2 <= 0) {
            this.p = 0;
            return currentTimeMillis;
        } else if (i2 > 0 && currentTimeMillis <= 250) {
            this.p = 1;
            return currentTimeMillis;
        } else if (currentTimeMillis > 250 && currentTimeMillis <= 350) {
            long j2 = currentTimeMillis - ((long) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            this.p = 2;
            return j2;
        } else if (currentTimeMillis > 500) {
            this.p = -1;
            return currentTimeMillis;
        } else {
            return currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Paint i() {
        return this.f9405h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float j() {
        return this.f9407j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float k() {
        return this.f9404g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Paint l() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float m() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long n() {
        return this.o;
    }

    protected final void o() {
        this.b.setAntiAlias(true);
        this.b.setColor(this.a);
        this.b.setStrokeWidth(this.c);
        this.b.setStyle(Paint.Style.STROKE);
        this.f9405h.setAntiAlias(true);
        this.f9405h.setColor(this.f9406i);
        this.f9405h.setStrokeWidth(this.f9407j);
        this.f9405h.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.n) {
            return;
        }
        b();
        d(canvas);
        c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        float f2 = 2;
        this.f9401d = getMeasuredWidth() / f2;
        this.f9402e = getMeasuredHeight() / f2;
        float paddingTop = ((((this.f9401d - getPaddingTop()) - getPaddingBottom()) - getPaddingLeft()) - getPaddingRight()) - (this.f9401d / 5);
        this.f9403f = paddingTop;
        this.f9404g = paddingTop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(int i2) {
        this.p = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(float f2) {
        this.f9407j = f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(float f2) {
        this.c = f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(long j2) {
        this.o = j2;
    }

    public final void setFocusFail() {
        this.b.setAlpha(102);
        this.f9405h.setAlpha(102);
    }

    public final void setFocusState(Integer num) {
        s.e(num);
        num.intValue();
        this.b.setAlpha(255);
        this.f9405h.setAlpha(255);
        if (r == num.intValue()) {
            invalidate();
        }
        if (s == num.intValue()) {
            invalidate();
        }
    }

    public void setIsDrawLine(boolean z) {
        this.f9409l = z;
    }

    public void setIsDrawRect(boolean z) {
        this.m = z;
    }

    public void setIsStop(boolean z) {
        this.n = z;
    }

    public void t() {
        this.o = System.currentTimeMillis();
        this.f9404g = this.f9403f;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PGFocusShape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusShape(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.b = new Paint();
        this.c = 5.0f;
        this.f9405h = new Paint();
        this.f9407j = 2.0f;
        this.f9409l = true;
        this.m = true;
        this.p = -1;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PGFocusShape, i2, 0);
        s.g(obtainStyledAttributes, "context.theme.obtainStyl…usShape, defStyleAttr, 0)");
        this.a = obtainStyledAttributes.getColor(R.styleable.PGFocusShape_shapeColor, -1);
        this.f9406i = obtainStyledAttributes.getColor(R.styleable.PGFocusShape_lineColor, -1);
        o();
    }
}
