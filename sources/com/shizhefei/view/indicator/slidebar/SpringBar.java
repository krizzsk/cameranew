package com.shizhefei.view.indicator.slidebar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
/* loaded from: classes3.dex */
public class SpringBar extends View implements ScrollBar {
    private int a;
    private Paint b;
    private Path c;

    /* renamed from: d  reason: collision with root package name */
    private a f7155d;

    /* renamed from: e  reason: collision with root package name */
    private a f7156e;

    /* renamed from: f  reason: collision with root package name */
    private float f7157f;

    /* renamed from: g  reason: collision with root package name */
    private float f7158g;

    /* renamed from: h  reason: collision with root package name */
    private float f7159h;

    /* renamed from: i  reason: collision with root package name */
    private float f7160i;

    /* renamed from: j  reason: collision with root package name */
    private float f7161j;

    /* renamed from: k  reason: collision with root package name */
    private float f7162k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        public float a() {
            throw null;
        }

        public float b() {
            throw null;
        }

        public float c() {
            throw null;
        }

        public void d(float f2) {
            throw null;
        }

        public void e(float f2) {
            throw null;
        }

        public void f(float f2) {
            throw null;
        }
    }

    private float e(float f2) {
        int i2 = this.a;
        return (((i2 * 2) - (i2 / 4)) - (i2 * (1.0f - f2))) + (i2 / 4.0f);
    }

    private void f() {
        float a2 = (float) (this.f7155d.a() * Math.sin(Math.atan((this.f7156e.c() - this.f7155d.c()) / (this.f7156e.b() - this.f7155d.b()))));
        float a3 = (float) (this.f7155d.a() * Math.cos(Math.atan((this.f7156e.c() - this.f7155d.c()) / (this.f7156e.b() - this.f7155d.b()))));
        float a4 = (float) (this.f7156e.a() * Math.sin(Math.atan((this.f7156e.c() - this.f7155d.c()) / (this.f7156e.b() - this.f7155d.b()))));
        float a5 = (float) (this.f7156e.a() * Math.cos(Math.atan((this.f7156e.c() - this.f7155d.c()) / (this.f7156e.b() - this.f7155d.b()))));
        float b = this.f7155d.b() - a2;
        float c = this.f7155d.c() + a3;
        float b2 = this.f7155d.b() + a2;
        float c2 = this.f7155d.c() - a3;
        float b3 = this.f7156e.b() - a4;
        float c3 = this.f7156e.c() + a5;
        float b4 = this.f7156e.b() + a4;
        float c4 = this.f7156e.c() - a5;
        float b5 = (this.f7156e.b() + this.f7155d.b()) / 2.0f;
        float c5 = (this.f7156e.c() + this.f7155d.c()) / 2.0f;
        this.c.reset();
        this.c.moveTo(b, c);
        this.c.quadTo(b5, c5, b3, c3);
        this.c.lineTo(b4, c4);
        this.c.quadTo(b5, c5, b2, c2);
        this.c.lineTo(b, c);
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public View a() {
        return this;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public int b(int i2) {
        float f2 = i2 / 2;
        this.f7155d.f(f2);
        this.f7156e.f(f2);
        float f3 = this.f7160i * f2;
        this.f7157f = f3;
        float f4 = f2 * this.f7161j;
        this.f7158g = f4;
        this.f7159h = f3 - f4;
        return i2;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public ScrollBar.Gravity c() {
        return ScrollBar.Gravity.CENTENT_BACKGROUND;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public int d(int i2) {
        this.a = i2;
        float f2 = this.f7162k;
        if (f2 < 0.02f || f2 > 0.98f) {
            onPageScrolled(0, 0.0f, 0);
            throw null;
        }
        return i2 * 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        f();
        canvas.drawColor(0);
        canvas.drawPath(this.c, this.b);
        this.f7156e.b();
        throw null;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public void onPageScrolled(int i2, float f2, int i3) {
        this.f7162k = f2;
        if (f2 < 0.02f || f2 > 0.98f) {
            this.f7156e.e(e(0.0f));
            throw null;
        } else if (f2 < 0.5f) {
            this.f7156e.d(this.f7158g);
            throw null;
        } else {
            this.f7156e.d((((f2 - 0.5f) / 0.5f) * this.f7159h) + this.f7158g);
            throw null;
        }
    }
}
