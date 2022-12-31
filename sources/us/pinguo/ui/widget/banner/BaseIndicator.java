package us.pinguo.ui.widget.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes6.dex */
public abstract class BaseIndicator extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12253d;

    /* renamed from: e  reason: collision with root package name */
    private int f12254e;

    /* renamed from: f  reason: collision with root package name */
    private Scroller f12255f;

    /* renamed from: g  reason: collision with root package name */
    private int f12256g;

    /* renamed from: h  reason: collision with root package name */
    private int f12257h;

    public BaseIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12257h = IjkMediaCodecInfo.RANK_SECURE;
    }

    private void a() {
        int e2 = e();
        int i2 = this.f12254e;
        this.c = (e2 * i2) + (this.b * (i2 - 1)) + getPaddingLeft() + getPaddingRight();
        this.f12253d = d() + getPaddingBottom() + getPaddingTop();
    }

    protected abstract void b(Canvas canvas, int i2, int i3, int i4, float f2);

    public int c() {
        return this.f12254e;
    }

    public abstract int d();

    public abstract int e();

    public int f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Scroller scroller = this.f12255f;
        float f2 = 1.0f;
        if (scroller != null) {
            scroller.computeScrollOffset();
            f2 = (this.f12255f.getCurrX() * 1.0f) / 1000.0f;
            if (!this.f12255f.isFinished()) {
                invalidate();
            }
        }
        for (int i2 = 0; i2 < c(); i2++) {
            b(canvas, i2, this.f12256g, f(), f2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        a();
        setMeasuredDimension(this.c, this.f12253d);
    }

    public void setAnimationTime(int i2) {
        this.f12257h = i2;
    }

    public void setCellCount(int i2) {
        this.f12254e = i2;
    }

    public void setCurrentItem(int i2) {
        this.f12256g = f();
        if (i2 == this.a) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = this.f12254e;
            if (i2 >= i3) {
                i2 = i3 - 1;
            }
        }
        this.a = i2;
        if (i2 >= 0) {
            invalidate();
        }
        if (this.f12255f == null) {
            this.f12255f = new Scroller(getContext());
        }
        this.f12255f.startScroll(0, 0, 1000, 0, this.f12257h);
        invalidate();
    }

    public void setGapWidth(int i2) {
        this.b = i2;
    }

    public BaseIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context) {
        this(context, null);
    }
}
