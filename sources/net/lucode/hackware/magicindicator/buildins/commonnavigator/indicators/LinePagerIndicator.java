package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.d.b;
/* loaded from: classes3.dex */
public class LinePagerIndicator extends View implements c {
    private int a;
    private Interpolator b;
    private Interpolator c;

    /* renamed from: d  reason: collision with root package name */
    private float f8908d;

    /* renamed from: e  reason: collision with root package name */
    private float f8909e;

    /* renamed from: f  reason: collision with root package name */
    private float f8910f;

    /* renamed from: g  reason: collision with root package name */
    private float f8911g;

    /* renamed from: h  reason: collision with root package name */
    private float f8912h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f8913i;

    /* renamed from: j  reason: collision with root package name */
    private List<a> f8914j;

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f8915k;

    /* renamed from: l  reason: collision with root package name */
    private RectF f8916l;

    public LinePagerIndicator(Context context) {
        super(context);
        this.b = new LinearInterpolator();
        this.c = new LinearInterpolator();
        this.f8916l = new RectF();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f8913i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f8909e = b.a(context, 3.0d);
        this.f8911g = b.a(context, 10.0d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.f8914j = list;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f8916l;
        float f2 = this.f8912h;
        canvas.drawRoundRect(rectF, f2, f2, this.f8913i);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        float b;
        float b2;
        float b3;
        float f3;
        float f4;
        int i4;
        List<a> list = this.f8914j;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.f8915k;
        if (list2 != null && list2.size() > 0) {
            this.f8913i.setColor(net.lucode.hackware.magicindicator.d.a.a(f2, this.f8915k.get(Math.abs(i2) % this.f8915k.size()).intValue(), this.f8915k.get(Math.abs(i2 + 1) % this.f8915k.size()).intValue()));
        }
        a a = net.lucode.hackware.magicindicator.a.a(this.f8914j, i2);
        a a2 = net.lucode.hackware.magicindicator.a.a(this.f8914j, i2 + 1);
        int i5 = this.a;
        if (i5 == 0) {
            f4 = this.f8910f;
            b = a.a + f4;
            f3 = a2.a + f4;
            b2 = a.c - f4;
            i4 = a2.c;
        } else if (i5 == 1) {
            f4 = this.f8910f;
            b = a.f8895e + f4;
            f3 = a2.f8895e + f4;
            b2 = a.f8897g - f4;
            i4 = a2.f8897g;
        } else {
            b = a.a + ((a.b() - this.f8911g) / 2.0f);
            float b4 = a2.a + ((a2.b() - this.f8911g) / 2.0f);
            b2 = ((a.b() + this.f8911g) / 2.0f) + a.a;
            b3 = ((a2.b() + this.f8911g) / 2.0f) + a2.a;
            f3 = b4;
            this.f8916l.left = b + ((f3 - b) * this.b.getInterpolation(f2));
            this.f8916l.right = b2 + ((b3 - b2) * this.c.getInterpolation(f2));
            this.f8916l.top = (getHeight() - this.f8909e) - this.f8908d;
            this.f8916l.bottom = getHeight() - this.f8908d;
            invalidate();
        }
        b3 = i4 - f4;
        this.f8916l.left = b + ((f3 - b) * this.b.getInterpolation(f2));
        this.f8916l.right = b2 + ((b3 - b2) * this.c.getInterpolation(f2));
        this.f8916l.top = (getHeight() - this.f8909e) - this.f8908d;
        this.f8916l.bottom = getHeight() - this.f8908d;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i2) {
    }

    public void setColors(Integer... numArr) {
        this.f8915k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.c = interpolator;
        if (interpolator == null) {
            this.c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f2) {
        this.f8909e = f2;
    }

    public void setLineWidth(float f2) {
        this.f8911g = f2;
    }

    public void setMode(int i2) {
        if (i2 != 2 && i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("mode " + i2 + " not supported.");
        }
        this.a = i2;
    }

    public void setRoundRadius(float f2) {
        this.f8912h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.b = interpolator;
        if (interpolator == null) {
            this.b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f2) {
        this.f8910f = f2;
    }

    public void setYOffset(float f2) {
        this.f8908d = f2;
    }
}
