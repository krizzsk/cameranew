package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a;
/* loaded from: classes3.dex */
public class TestPagerIndicator extends View implements c {
    private Paint a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f8917d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f8918e;

    /* renamed from: f  reason: collision with root package name */
    private List<a> f8919f;

    public TestPagerIndicator(Context context) {
        super(context);
        this.f8917d = new RectF();
        this.f8918e = new RectF();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b = SupportMenu.CATEGORY_MASK;
        this.c = -16711936;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void a(List<a> list) {
        this.f8919f = list;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.a.setColor(this.b);
        canvas.drawRect(this.f8917d, this.a);
        this.a.setColor(this.c);
        canvas.drawRect(this.f8918e, this.a);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.f8919f;
        if (list == null || list.isEmpty()) {
            return;
        }
        a a = net.lucode.hackware.magicindicator.a.a(this.f8919f, i2);
        a a2 = net.lucode.hackware.magicindicator.a.a(this.f8919f, i2 + 1);
        RectF rectF = this.f8917d;
        int i4 = a.a;
        rectF.left = i4 + ((a2.a - i4) * f2);
        int i5 = a.b;
        rectF.top = i5 + ((a2.b - i5) * f2);
        int i6 = a.c;
        rectF.right = i6 + ((a2.c - i6) * f2);
        int i7 = a.f8894d;
        rectF.bottom = i7 + ((a2.f8894d - i7) * f2);
        RectF rectF2 = this.f8918e;
        int i8 = a.f8895e;
        rectF2.left = i8 + ((a2.f8895e - i8) * f2);
        int i9 = a.f8896f;
        rectF2.top = i9 + ((a2.f8896f - i9) * f2);
        int i10 = a.f8897g;
        rectF2.right = i10 + ((a2.f8897g - i10) * f2);
        int i11 = a.f8898h;
        rectF2.bottom = i11 + ((a2.f8898h - i11) * f2);
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c
    public void onPageSelected(int i2) {
    }

    public void setInnerRectColor(int i2) {
        this.c = i2;
    }

    public void setOutRectColor(int i2) {
        this.b = i2;
    }
}
