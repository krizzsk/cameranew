package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b;
/* loaded from: classes3.dex */
public class ClipPagerTitleView extends View implements b {
    private String a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8935d;

    /* renamed from: e  reason: collision with root package name */
    private float f8936e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f8937f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f8938g;

    public ClipPagerTitleView(Context context) {
        super(context);
        this.f8938g = new Rect();
        i(context);
    }

    private void i(Context context) {
        int a = net.lucode.hackware.magicindicator.d.b.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f8937f = paint;
        paint.setTextSize(a);
        int a2 = net.lucode.hackware.magicindicator.d.b.a(context, 10.0d);
        setPadding(a2, 0, a2, 0);
    }

    private int j(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : this.f8938g.height() + getPaddingTop() + getPaddingBottom();
        }
        return Math.min(this.f8938g.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    private void k() {
        Paint paint = this.f8937f;
        String str = this.a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f8938g);
    }

    private int l(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : this.f8938g.width() + getPaddingLeft() + getPaddingRight();
        }
        return Math.min(this.f8938g.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void a(int i2, int i3) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        this.f8935d = z;
        this.f8936e = f2;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void c(int i2, int i3) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        this.f8935d = !z;
        this.f8936e = 1.0f - f2;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int e() {
        Paint.FontMetrics fontMetrics = this.f8937f.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int f() {
        Paint.FontMetrics fontMetrics = this.f8937f.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int g() {
        return getLeft() + (getWidth() / 2) + (this.f8938g.width() / 2);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int h() {
        return (getLeft() + (getWidth() / 2)) - (this.f8938g.width() / 2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f8937f.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f8937f.setColor(this.b);
        float width = (getWidth() - this.f8938g.width()) / 2;
        float f2 = height;
        canvas.drawText(this.a, width, f2, this.f8937f);
        canvas.save(2);
        if (this.f8935d) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.f8936e, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.f8936e), 0.0f, getWidth(), getHeight());
        }
        this.f8937f.setColor(this.c);
        canvas.drawText(this.a, width, f2, this.f8937f);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        k();
        setMeasuredDimension(l(i2), j(i3));
    }

    public void setClipColor(int i2) {
        this.c = i2;
        invalidate();
    }

    public void setText(String str) {
        this.a = str;
        requestLayout();
    }

    public void setTextColor(int i2) {
        this.b = i2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f8937f.setTextSize(f2);
        requestLayout();
    }
}
