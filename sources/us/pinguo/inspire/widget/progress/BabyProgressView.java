package us.pinguo.inspire.widget.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class BabyProgressView extends View implements Runnable {
    protected int a;
    private int b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11430d;

    /* renamed from: e  reason: collision with root package name */
    private int f11431e;

    /* renamed from: f  reason: collision with root package name */
    private int f11432f;

    /* renamed from: g  reason: collision with root package name */
    private int f11433g;

    /* renamed from: h  reason: collision with root package name */
    private int f11434h;

    /* renamed from: i  reason: collision with root package name */
    private float f11435i;

    /* renamed from: j  reason: collision with root package name */
    protected Paint f11436j;

    /* renamed from: k  reason: collision with root package name */
    private float f11437k;

    /* renamed from: l  reason: collision with root package name */
    private float f11438l;
    private float m;
    private float n;
    private float o;
    private RectF p;
    private int q;
    private float r;

    public BabyProgressView(Context context) {
        super(context);
        this.f11431e = 2;
        this.f11432f = 0;
        this.f11433g = -592138;
        this.f11435i = 0.77f;
        this.q = -90;
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
        float f2 = this.r;
        if (f2 > 0.0f) {
            int i4 = (int) (i3 * f2);
            return (int) (i4 + ((i3 - i4) * (i2 / i3)));
        }
        return i2;
    }

    private void b() {
        Paint paint = new Paint();
        this.f11436j = paint;
        paint.setAntiAlias(true);
        this.f11437k = us.pinguo.foundation.t.b.a.a(getContext(), 2.0f);
        this.f11434h = getResources().getColor(R.color.color_accent);
        this.p = new RectF();
    }

    public void c() {
        if (this.f11430d) {
            return;
        }
        this.f11430d = true;
        post(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f11436j.setColor(this.f11432f);
        this.f11436j.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.m, this.n, this.o, this.f11436j);
        this.f11436j.setStyle(Paint.Style.STROKE);
        this.f11436j.setStrokeWidth(this.f11437k);
        this.f11436j.setColor(this.f11433g);
        canvas.drawCircle(this.m, this.n, this.o * this.f11435i, this.f11436j);
        int i2 = this.c;
        float f2 = i2 == 0 ? 0.0f : 360.0f * (this.a / i2);
        this.f11436j.setColor(this.f11434h);
        canvas.drawArc(this.p, this.q, f2, false, this.f11436j);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f11438l = Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.m = getMeasuredWidth() / 2.0f;
        float measuredHeight = getMeasuredHeight() / 2.0f;
        this.n = measuredHeight;
        float f2 = this.f11438l / 2.0f;
        this.o = f2;
        RectF rectF = this.p;
        float f3 = this.m;
        rectF.set(f3 - f2, measuredHeight - f2, f3 + f2, measuredHeight + f2);
        Matrix matrix = new Matrix();
        float f4 = this.f11435i;
        matrix.setScale(f4, f4, this.m, this.n);
        matrix.mapRect(this.p);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.a;
        int i3 = this.b;
        if (i2 < i3) {
            int i4 = i3 - i2;
            int i5 = this.f11431e;
            if (i4 < i5) {
                this.a = i3;
            } else {
                this.a = i2 + i5;
            }
        } else if (i2 > i3) {
            int i6 = i2 - i3;
            int i7 = this.f11431e;
            if (i6 > i7) {
                this.a = i2 - i7;
            } else {
                this.a = i3;
            }
        } else {
            this.f11431e = 2;
            this.f11430d = false;
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
        this.r = f2;
    }

    public void setMax(int i2) {
        this.c = i2;
    }

    public void setProgress(int i2) {
        this.a = a(i2);
        invalidate();
    }

    public BabyProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11431e = 2;
        this.f11432f = 0;
        this.f11433g = -592138;
        this.f11435i = 0.77f;
        this.q = -90;
        b();
    }

    public BabyProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11431e = 2;
        this.f11432f = 0;
        this.f11433g = -592138;
        this.f11435i = 0.77f;
        this.q = -90;
        b();
    }
}
