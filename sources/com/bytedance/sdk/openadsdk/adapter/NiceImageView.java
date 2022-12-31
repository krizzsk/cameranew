package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.ac;
/* loaded from: classes.dex */
public class NiceImageView extends ImageView {
    private Context a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f1373d;

    /* renamed from: e  reason: collision with root package name */
    private int f1374e;

    /* renamed from: f  reason: collision with root package name */
    private int f1375f;

    /* renamed from: g  reason: collision with root package name */
    private int f1376g;

    /* renamed from: h  reason: collision with root package name */
    private int f1377h;

    /* renamed from: i  reason: collision with root package name */
    private int f1378i;

    /* renamed from: j  reason: collision with root package name */
    private int f1379j;

    /* renamed from: k  reason: collision with root package name */
    private int f1380k;

    /* renamed from: l  reason: collision with root package name */
    private int f1381l;
    private int m;
    private Xfermode n;
    private int o;
    private int p;
    private float q;
    private float[] r;
    private float[] s;
    private RectF t;
    private RectF u;
    private Paint v;
    private Path w;
    private Path x;

    public NiceImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (this.b) {
            int i2 = this.f1373d;
            if (i2 > 0) {
                a(canvas, i2, this.f1374e, this.q - (i2 / 2.0f));
            }
            int i3 = this.f1375f;
            if (i3 > 0) {
                a(canvas, i3, this.f1376g, (this.q - this.f1373d) - (i3 / 2.0f));
                return;
            }
            return;
        }
        int i4 = this.f1373d;
        if (i4 > 0) {
            a(canvas, i4, this.f1374e, this.u, this.r);
        }
    }

    private void b() {
        if (this.b) {
            float min = Math.min(this.o, this.p) / 2.0f;
            this.q = min;
            RectF rectF = this.t;
            int i2 = this.o;
            int i3 = this.p;
            rectF.set((i2 / 2.0f) - min, (i3 / 2.0f) - min, (i2 / 2.0f) + min, (i3 / 2.0f) + min);
            return;
        }
        this.t.set(0.0f, 0.0f, this.o, this.p);
        if (this.c) {
            this.t = this.u;
        }
    }

    private void c() {
        if (this.b) {
            return;
        }
        int i2 = 0;
        if (this.f1377h <= 0) {
            float[] fArr = this.r;
            int i3 = this.f1378i;
            float f2 = i3;
            fArr[1] = f2;
            fArr[0] = f2;
            int i4 = this.f1379j;
            float f3 = i4;
            fArr[3] = f3;
            fArr[2] = f3;
            int i5 = this.f1381l;
            float f4 = i5;
            fArr[5] = f4;
            fArr[4] = f4;
            int i6 = this.f1380k;
            float f5 = i6;
            fArr[7] = f5;
            fArr[6] = f5;
            float[] fArr2 = this.s;
            int i7 = this.f1373d;
            float f6 = i3 - (i7 / 2.0f);
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = i4 - (i7 / 2.0f);
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = i5 - (i7 / 2.0f);
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = i6 - (i7 / 2.0f);
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.r;
            if (i2 >= fArr3.length) {
                return;
            }
            int i8 = this.f1377h;
            fArr3[i2] = i8;
            this.s[i2] = i8 - (this.f1373d / 2.0f);
            i2++;
        }
    }

    private void d() {
        if (this.b) {
            return;
        }
        this.f1375f = 0;
    }

    public void isCircle(boolean z) {
        this.b = z;
        d();
        b();
        invalidate();
    }

    public void isCoverSrc(boolean z) {
        this.c = z;
        b();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.t, null, 31);
        if (!this.c) {
            int i2 = this.o;
            int i3 = this.f1373d;
            int i4 = this.f1375f;
            int i5 = this.p;
            canvas.scale((((i2 - (i3 * 2)) - (i4 * 2)) * 1.0f) / i2, (((i5 - (i3 * 2)) - (i4 * 2)) * 1.0f) / i5, i2 / 2.0f, i5 / 2.0f);
        }
        super.onDraw(canvas);
        this.v.reset();
        this.w.reset();
        if (this.b) {
            this.w.addCircle(this.o / 2.0f, this.p / 2.0f, this.q, Path.Direction.CCW);
        } else {
            this.w.addRoundRect(this.t, this.s, Path.Direction.CCW);
        }
        this.v.setAntiAlias(true);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setXfermode(this.n);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.w, this.v);
        } else {
            this.x.addRect(this.t, Path.Direction.CCW);
            this.x.op(this.w, Path.Op.DIFFERENCE);
            canvas.drawPath(this.x, this.v);
        }
        this.v.setXfermode(null);
        int i6 = this.m;
        if (i6 != 0) {
            this.v.setColor(i6);
            canvas.drawPath(this.w, this.v);
        }
        canvas.restore();
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.o = i2;
        this.p = i3;
        a();
        b();
    }

    public void setBorderColor(@ColorInt int i2) {
        this.f1374e = i2;
        invalidate();
    }

    public void setBorderWidth(int i2) {
        this.f1373d = ac.c(this.a, i2);
        a(false);
    }

    public void setCornerBottomLeftRadius(int i2) {
        this.f1380k = ac.c(this.a, i2);
        a(true);
    }

    public void setCornerBottomRightRadius(int i2) {
        this.f1381l = ac.c(this.a, i2);
        a(true);
    }

    public void setCornerRadius(int i2) {
        this.f1377h = ac.c(this.a, i2);
        a(false);
    }

    public void setCornerTopLeftRadius(int i2) {
        this.f1378i = ac.c(this.a, i2);
        a(true);
    }

    public void setCornerTopRightRadius(int i2) {
        this.f1379j = ac.c(this.a, i2);
        a(true);
    }

    public void setInnerBorderColor(@ColorInt int i2) {
        this.f1376g = i2;
        invalidate();
    }

    public void setInnerBorderWidth(int i2) {
        this.f1375f = ac.c(this.a, i2);
        d();
        invalidate();
    }

    public void setMaskColor(@ColorInt int i2) {
        this.m = i2;
        invalidate();
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1374e = -1;
        this.f1376g = -1;
        this.a = context;
        this.f1377h = ac.c(context, 10.0f);
        this.r = new float[8];
        this.s = new float[8];
        this.u = new RectF();
        this.t = new RectF();
        this.v = new Paint();
        this.w = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.x = new Path();
        }
        c();
        d();
    }

    private void a(Canvas canvas, int i2, int i3, float f2) {
        a(i2, i3);
        this.w.addCircle(this.o / 2.0f, this.p / 2.0f, f2, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(Canvas canvas, int i2, int i3, RectF rectF, float[] fArr) {
        a(i2, i3);
        this.w.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(int i2, int i3) {
        this.w.reset();
        this.v.setStrokeWidth(i2);
        this.v.setColor(i3);
        this.v.setStyle(Paint.Style.STROKE);
    }

    private void a() {
        if (this.b) {
            return;
        }
        RectF rectF = this.u;
        int i2 = this.f1373d;
        rectF.set(i2 / 2.0f, i2 / 2.0f, this.o - (i2 / 2.0f), this.p - (i2 / 2.0f));
    }

    private void a(boolean z) {
        if (z) {
            this.f1377h = 0;
        }
        c();
        a();
        invalidate();
    }
}
