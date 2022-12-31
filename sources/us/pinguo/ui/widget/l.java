package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.s;
/* compiled from: StickySeekBarBubble.kt */
/* loaded from: classes6.dex */
public final class l extends Drawable {
    private Drawable a;
    private String b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private int f12306d;

    /* renamed from: e  reason: collision with root package name */
    private Float f12307e;

    /* renamed from: f  reason: collision with root package name */
    private Float f12308f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f12309g;

    public l(Drawable content) {
        s.h(content, "content");
        this.a = content;
        this.b = "0";
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        this.c = us.pinguo.util.g.b(b, 10.0f);
        this.f12306d = -1;
        Paint paint = new Paint(1);
        this.f12309g = paint;
        paint.setColor(-1);
        paint.setTextSize(this.c);
    }

    public final void a(Drawable value) {
        s.h(value, "value");
        if (s.c(value, this.a)) {
            return;
        }
        this.a = value;
        invalidateSelf();
    }

    public final void b(String value) {
        s.h(value, "value");
        if (s.c(value, this.b)) {
            return;
        }
        this.b = value;
        invalidateSelf();
    }

    public final void c(Float f2) {
        if (s.b(f2, this.f12308f)) {
            return;
        }
        this.f12308f = f2;
        invalidateSelf();
    }

    public final void d(int i2) {
        if (i2 != this.f12306d) {
            this.f12306d = i2;
            this.f12309g.setColor(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        s.h(canvas, "canvas");
        this.a.draw(canvas);
        float measureText = this.f12309g.measureText(this.b);
        float f2 = this.c;
        Float f3 = this.f12307e;
        float intrinsicWidth = f3 == null ? (getIntrinsicWidth() - measureText) * 0.5f : f3.floatValue();
        Float f4 = this.f12308f;
        canvas.drawText(this.b, getBounds().left + intrinsicWidth, getBounds().bottom - (f4 == null ? ((getIntrinsicHeight() - f2) * 0.5f) + this.f12309g.descent() : f4.floatValue()), this.f12309g);
    }

    public final void e(float f2) {
        if (f2 == this.c) {
            return;
        }
        this.c = f2;
        this.f12309g.setTextSize(f2);
        invalidateSelf();
    }

    public final void f(Float f2) {
        if (s.b(f2, this.f12307e)) {
            return;
        }
        this.f12307e = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f12309g.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f12309g.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 255 - this.f12309g.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f12309g.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect bounds) {
        s.h(bounds, "bounds");
        super.setBounds(bounds);
        this.a.setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12309g.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        this.a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.a.setBounds(i2, i3, i4, i5);
    }
}
