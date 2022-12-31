package us.pinguo.ui.widget.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class CellStandoutIndicator extends BaseIndicator {

    /* renamed from: i  reason: collision with root package name */
    private int f12258i;

    /* renamed from: j  reason: collision with root package name */
    private int f12259j;

    /* renamed from: k  reason: collision with root package name */
    private int f12260k;

    /* renamed from: l  reason: collision with root package name */
    private int f12261l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Paint t;

    public CellStandoutIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = new Paint();
        float f2 = getResources().getDisplayMetrics().density;
        setGapWidth((int) (4.0f * f2));
        setCellSize((int) (5.0f * f2), (int) (f2 * 10.0f));
        this.t.setAntiAlias(true);
    }

    @Override // us.pinguo.ui.widget.banner.BaseIndicator
    protected void b(Canvas canvas, int i2, int i3, int i4, float f2) {
        int i5;
        int i6;
        int g2 = (this.f12258i + g()) * i2;
        if (i2 == i4) {
            int i7 = this.f12258i;
            i5 = Math.round(i7 + ((this.f12259j - i7) * f2));
            int i8 = this.f12261l;
            int i9 = (int) (i8 + ((this.p - i8) * f2));
            int i10 = this.m;
            int i11 = (int) (i10 + ((this.q - i10) * f2));
            int i12 = this.n;
            int i13 = (int) (i12 + ((this.r - i12) * f2));
            int i14 = this.o;
            i6 = Color.argb(i9, i11, i13, (int) (i14 + (f2 * (this.s - i14))));
        } else if (i2 == i3) {
            int i15 = this.f12259j;
            i5 = Math.round(i15 - ((i15 - this.f12258i) * f2));
            int i16 = this.p;
            int i17 = (int) (i16 - ((i16 - this.f12261l) * f2));
            int i18 = this.q;
            int i19 = (int) (i18 - ((i18 - this.m) * f2));
            int i20 = this.r;
            int i21 = (int) (i20 - ((i20 - this.n) * f2));
            int i22 = this.s;
            i6 = Color.argb(i17, i19, i21, (int) (i22 - (f2 * (i22 - this.o))));
        } else {
            i5 = this.f12258i;
            i6 = this.f12260k;
        }
        this.t.setColor(i6);
        RectF rectF = new RectF(g2, getHeight() - i5, g2 + this.f12258i, getHeight());
        int i23 = this.f12258i;
        canvas.drawRoundRect(rectF, i23 / 2, i23 / 2, this.t);
    }

    @Override // us.pinguo.ui.widget.banner.BaseIndicator
    public int d() {
        return this.f12259j;
    }

    @Override // us.pinguo.ui.widget.banner.BaseIndicator
    public int e() {
        return this.f12258i;
    }

    public void setCellColor(int i2, int i3) {
        this.f12260k = i2;
        this.f12261l = Color.alpha(i2);
        this.m = Color.red(this.f12260k);
        this.n = Color.green(this.f12260k);
        this.o = Color.blue(this.f12260k);
        this.p = Color.alpha(i3);
        this.q = Color.red(i3);
        this.r = Color.green(i3);
        this.s = Color.blue(i3);
    }

    public void setCellSize(int i2, int i3) {
        this.f12258i = i2;
        this.f12259j = i3;
        requestLayout();
    }

    public CellStandoutIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CellStandoutIndicator(Context context) {
        this(context, null);
    }
}
