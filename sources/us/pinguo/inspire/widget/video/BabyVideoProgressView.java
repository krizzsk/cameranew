package us.pinguo.inspire.widget.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes9.dex */
public class BabyVideoProgressView extends View implements Runnable {
    private static Bitmap v;
    protected int a;
    private int b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11466d;

    /* renamed from: e  reason: collision with root package name */
    private int f11467e;

    /* renamed from: f  reason: collision with root package name */
    private int f11468f;

    /* renamed from: g  reason: collision with root package name */
    private float f11469g;

    /* renamed from: h  reason: collision with root package name */
    private float f11470h;

    /* renamed from: i  reason: collision with root package name */
    protected Paint f11471i;

    /* renamed from: j  reason: collision with root package name */
    private float f11472j;

    /* renamed from: k  reason: collision with root package name */
    private float f11473k;

    /* renamed from: l  reason: collision with root package name */
    private float f11474l;
    private float m;
    private float n;
    private RectF o;
    private RectF p;
    private RectF q;
    private int r;
    private float s;
    private boolean t;
    private int u;

    public BabyVideoProgressView(Context context) {
        super(context);
        this.f11467e = 2;
        this.f11468f = -436207617;
        this.f11469g = 0.5f;
        this.f11470h = 0.8f;
        this.p = new RectF();
        this.q = new RectF();
        this.r = -90;
        this.t = false;
        b();
    }

    private int a(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.c;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.s;
        if (f2 > 0.0f) {
            int i4 = (int) (i3 * f2);
            return (int) (i4 + ((i3 - i4) * (i2 / i3)));
        }
        return i2;
    }

    private void b() {
        this.f11472j = us.pinguo.foundation.t.b.a.a(getContext(), 1.0f);
        this.u = us.pinguo.foundation.t.b.a.a(getContext(), 4.0f);
        Paint paint = new Paint();
        this.f11471i = paint;
        paint.setColor(this.f11468f);
        this.f11471i.setStrokeWidth(this.f11472j);
        this.f11471i.setAntiAlias(true);
        this.o = new RectF();
    }

    public void c() {
        if (this.f11466d) {
            return;
        }
        this.f11466d = true;
        post(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f11471i.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.f11474l, this.m, this.n, this.f11471i);
        if (this.t) {
            us.pinguo.common.log.a.m("zhouwei", "progress:" + this.a + "     max:" + this.c, new Object[0]);
            this.f11471i.setStyle(Paint.Style.FILL);
            int i2 = this.c;
            canvas.drawArc(this.q, this.r, i2 == 0 ? 0.0f : (this.a / i2) * 360.0f, true, this.f11471i);
        } else if (v != null) {
            this.p.offset(this.u, 0.0f);
            canvas.drawBitmap(v, (Rect) null, this.p, (Paint) null);
            this.p.offset(-this.u, 0.0f);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f11473k = Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.f11474l = getMeasuredWidth() / 2.0f;
        float measuredHeight = getMeasuredHeight() / 2.0f;
        this.m = measuredHeight;
        float f2 = (this.f11473k - this.f11472j) / 2.0f;
        this.n = f2;
        float f3 = this.f11470h * f2;
        float f4 = this.f11469g * f2;
        RectF rectF = this.o;
        float f5 = this.f11474l;
        rectF.set(f5 - f2, measuredHeight - f2, f5 + f2, measuredHeight + f2);
        RectF rectF2 = this.q;
        float f6 = this.f11474l;
        float f7 = this.m;
        rectF2.set(f6 - f3, f7 - f3, f6 + f3, f7 + f3);
        RectF rectF3 = this.p;
        float f8 = this.f11474l;
        float f9 = this.m;
        rectF3.set(f8 - f4, f9 - f4, f8 + f4, f9 + f4);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.a;
        int i3 = this.b;
        if (i2 < i3) {
            int i4 = i3 - i2;
            int i5 = this.f11467e;
            if (i4 < i5) {
                this.a = i3;
            } else {
                this.a = i2 + i5;
            }
        } else if (i2 > i3) {
            int i6 = i2 - i3;
            int i7 = this.f11467e;
            if (i6 > i7) {
                this.a = i2 - i7;
            } else {
                this.a = i3;
            }
        } else {
            this.f11467e = 2;
            this.f11466d = false;
            return;
        }
        invalidate();
        postDelayed(this, 20L);
    }

    public void setAnimProgress(int i2) {
        this.b = a(i2);
        c();
    }

    public void setBaseRate(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.s = f2;
    }

    public void setMax(int i2) {
        this.c = i2;
    }

    public void setProgress(int i2) {
        this.a = a(i2);
        invalidate();
    }

    public void setProgressMode(boolean z) {
        this.t = z;
        invalidate();
    }

    public BabyVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11467e = 2;
        this.f11468f = -436207617;
        this.f11469g = 0.5f;
        this.f11470h = 0.8f;
        this.p = new RectF();
        this.q = new RectF();
        this.r = -90;
        this.t = false;
        b();
    }

    public BabyVideoProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11467e = 2;
        this.f11468f = -436207617;
        this.f11469g = 0.5f;
        this.f11470h = 0.8f;
        this.p = new RectF();
        this.q = new RectF();
        this.r = -90;
        this.t = false;
        b();
    }
}
