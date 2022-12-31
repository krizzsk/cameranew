package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
import net.lucode.hackware.magicindicator.d.b;
/* loaded from: classes3.dex */
public class BezierPagerIndicator extends View implements c {
    private List<a> a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f8899d;

    /* renamed from: e  reason: collision with root package name */
    private float f8900e;

    /* renamed from: f  reason: collision with root package name */
    private float f8901f;

    /* renamed from: g  reason: collision with root package name */
    private float f8902g;

    /* renamed from: h  reason: collision with root package name */
    private float f8903h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f8904i;

    /* renamed from: j  reason: collision with root package name */
    private Path f8905j;

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f8906k;

    /* renamed from: l  reason: collision with root package name */
    private Interpolator f8907l;
    private Interpolator m;

    public BezierPagerIndicator(Context context) {
        super(context);
        this.f8905j = new Path();
        this.f8907l = new AccelerateInterpolator();
        this.m = new DecelerateInterpolator();
        c(context);
    }

    private void b(Canvas canvas) {
        this.f8905j.reset();
        float height = (getHeight() - this.f8901f) - this.f8902g;
        this.f8905j.moveTo(this.f8900e, height);
        this.f8905j.lineTo(this.f8900e, height - this.f8899d);
        Path path = this.f8905j;
        float f2 = this.f8900e;
        float f3 = this.c;
        path.quadTo(f2 + ((f3 - f2) / 2.0f), height, f3, height - this.b);
        this.f8905j.lineTo(this.c, this.b + height);
        Path path2 = this.f8905j;
        float f4 = this.f8900e;
        path2.quadTo(((this.c - f4) / 2.0f) + f4, height, f4, this.f8899d + height);
        this.f8905j.close();
        canvas.drawPath(this.f8905j, this.f8904i);
    }

    private void c(Context context) {
        Paint paint = new Paint(1);
        this.f8904i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f8902g = b.a(context, 3.5d);
        this.f8903h = b.a(context, 2.0d);
        this.f8901f = b.a(context, 1.5d);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.a = list;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.c, (getHeight() - this.f8901f) - this.f8902g, this.b, this.f8904i);
        canvas.drawCircle(this.f8900e, (getHeight() - this.f8901f) - this.f8902g, this.f8899d, this.f8904i);
        b(canvas);
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
        List<Integer> list2 = this.f8906k;
        if (list2 != null && list2.size() > 0) {
            this.f8904i.setColor(net.lucode.hackware.magicindicator.d.a.a(f2, this.f8906k.get(Math.abs(i2) % this.f8906k.size()).intValue(), this.f8906k.get(Math.abs(i2 + 1) % this.f8906k.size()).intValue()));
        }
        a a = net.lucode.hackware.magicindicator.a.a(this.a, i2);
        a a2 = net.lucode.hackware.magicindicator.a.a(this.a, i2 + 1);
        int i4 = a.a;
        float f3 = i4 + ((a.c - i4) / 2);
        int i5 = a2.a;
        float f4 = (i5 + ((a2.c - i5) / 2)) - f3;
        this.c = (this.f8907l.getInterpolation(f2) * f4) + f3;
        this.f8900e = f3 + (f4 * this.m.getInterpolation(f2));
        float f5 = this.f8902g;
        this.b = f5 + ((this.f8903h - f5) * this.m.getInterpolation(f2));
        float f6 = this.f8903h;
        this.f8899d = f6 + ((this.f8902g - f6) * this.f8907l.getInterpolation(f2));
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i2) {
    }

    public void setColors(Integer... numArr) {
        this.f8906k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.m = interpolator;
        if (interpolator == null) {
            this.m = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f2) {
        this.f8902g = f2;
    }

    public void setMinCircleRadius(float f2) {
        this.f8903h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f8907l = interpolator;
        if (interpolator == null) {
            this.f8907l = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f2) {
        this.f8901f = f2;
    }
}
