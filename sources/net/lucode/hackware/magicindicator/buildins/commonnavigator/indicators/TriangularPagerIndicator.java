package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.d.b;
/* loaded from: classes3.dex */
public class TriangularPagerIndicator extends View implements c {
    private List<a> a;
    private Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f8920d;

    /* renamed from: e  reason: collision with root package name */
    private int f8921e;

    /* renamed from: f  reason: collision with root package name */
    private int f8922f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8923g;

    /* renamed from: h  reason: collision with root package name */
    private float f8924h;

    /* renamed from: i  reason: collision with root package name */
    private Path f8925i;

    /* renamed from: j  reason: collision with root package name */
    private Interpolator f8926j;

    /* renamed from: k  reason: collision with root package name */
    private float f8927k;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.f8925i = new Path();
        this.f8926j = new LinearInterpolator();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = b.a(context, 3.0d);
        this.f8922f = b.a(context, 14.0d);
        this.f8921e = b.a(context, 8.0d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.a = list;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.b.setColor(this.f8920d);
        if (this.f8923g) {
            canvas.drawRect(0.0f, (getHeight() - this.f8924h) - this.f8921e, getWidth(), ((getHeight() - this.f8924h) - this.f8921e) + this.c, this.b);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.c) - this.f8924h, getWidth(), getHeight() - this.f8924h, this.b);
        }
        this.f8925i.reset();
        if (this.f8923g) {
            this.f8925i.moveTo(this.f8927k - (this.f8922f / 2), (getHeight() - this.f8924h) - this.f8921e);
            this.f8925i.lineTo(this.f8927k, getHeight() - this.f8924h);
            this.f8925i.lineTo(this.f8927k + (this.f8922f / 2), (getHeight() - this.f8924h) - this.f8921e);
        } else {
            this.f8925i.moveTo(this.f8927k - (this.f8922f / 2), getHeight() - this.f8924h);
            this.f8925i.lineTo(this.f8927k, (getHeight() - this.f8921e) - this.f8924h);
            this.f8925i.lineTo(this.f8927k + (this.f8922f / 2), getHeight() - this.f8924h);
        }
        this.f8925i.close();
        canvas.drawPath(this.f8925i, this.b);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.a;
        if (list == null || list.isEmpty()) {
            return;
        }
        a a = net.lucode.hackware.magicindicator.a.a(this.a, i2);
        a a2 = net.lucode.hackware.magicindicator.a.a(this.a, i2 + 1);
        int i4 = a.a;
        float f3 = i4 + ((a.c - i4) / 2);
        int i5 = a2.a;
        this.f8927k = f3 + (((i5 + ((a2.c - i5) / 2)) - f3) * this.f8926j.getInterpolation(f2));
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i2) {
    }

    public void setLineColor(int i2) {
        this.f8920d = i2;
    }

    public void setLineHeight(int i2) {
        this.c = i2;
    }

    public void setReverse(boolean z) {
        this.f8923g = z;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f8926j = interpolator;
        if (interpolator == null) {
            this.f8926j = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i2) {
        this.f8921e = i2;
    }

    public void setTriangleWidth(int i2) {
        this.f8922f = i2;
    }

    public void setYOffset(float f2) {
        this.f8924h = f2;
    }
}
