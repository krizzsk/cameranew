package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.d.b;
/* loaded from: classes3.dex */
public class WrapPagerIndicator extends View implements c {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f8928d;

    /* renamed from: e  reason: collision with root package name */
    private Interpolator f8929e;

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f8930f;

    /* renamed from: g  reason: collision with root package name */
    private List<a> f8931g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f8932h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f8933i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8934j;

    public WrapPagerIndicator(Context context) {
        super(context);
        this.f8929e = new LinearInterpolator();
        this.f8930f = new LinearInterpolator();
        this.f8933i = new RectF();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f8932h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a = b.a(context, 6.0d);
        this.b = b.a(context, 10.0d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.f8931g = list;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f8932h.setColor(this.c);
        RectF rectF = this.f8933i;
        float f2 = this.f8928d;
        canvas.drawRoundRect(rectF, f2, f2, this.f8932h);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.f8931g;
        if (list == null || list.isEmpty()) {
            return;
        }
        a a = net.lucode.hackware.magicindicator.a.a(this.f8931g, i2);
        a a2 = net.lucode.hackware.magicindicator.a.a(this.f8931g, i2 + 1);
        RectF rectF = this.f8933i;
        int i4 = a.f8895e;
        rectF.left = (i4 - this.b) + ((a2.f8895e - i4) * this.f8930f.getInterpolation(f2));
        RectF rectF2 = this.f8933i;
        rectF2.top = a.f8896f - this.a;
        int i5 = a.f8897g;
        rectF2.right = this.b + i5 + ((a2.f8897g - i5) * this.f8929e.getInterpolation(f2));
        RectF rectF3 = this.f8933i;
        rectF3.bottom = a.f8898h + this.a;
        if (!this.f8934j) {
            this.f8928d = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i2) {
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f8930f = interpolator;
        if (interpolator == null) {
            this.f8930f = new LinearInterpolator();
        }
    }

    public void setFillColor(int i2) {
        this.c = i2;
    }

    public void setHorizontalPadding(int i2) {
        this.b = i2;
    }

    public void setRoundRadius(float f2) {
        this.f8928d = f2;
        this.f8934j = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f8929e = interpolator;
        if (interpolator == null) {
            this.f8929e = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i2) {
        this.a = i2;
    }
}
