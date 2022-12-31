package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class IndicatorView extends View {

    /* renamed from: i  reason: collision with root package name */
    private static final String f9739i = IndicatorView.class.getSimpleName();
    private Context a;
    private Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9740d;

    /* renamed from: e  reason: collision with root package name */
    private int f9741e;

    /* renamed from: f  reason: collision with root package name */
    private int f9742f;

    /* renamed from: g  reason: collision with root package name */
    private int f9743g;

    /* renamed from: h  reason: collision with root package name */
    private int f9744h;

    public IndicatorView(Context context) {
        super(context);
        this.b = new Paint();
        this.f9743g = -13290187;
        this.f9744h = -3552823;
        this.a = getContext();
        this.b.setStyle(Paint.Style.FILL);
        this.c = us.pinguo.foundation.t.b.a.a(this.a, 3.0f);
    }

    private void a(Canvas canvas) {
        if (this.f9740d < 2) {
            return;
        }
        int i2 = this.c;
        int i3 = i2 * 2;
        int i4 = this.f9742f - i2;
        for (int i5 = 0; i5 < this.f9740d; i5++) {
            if (i5 == this.f9741e) {
                this.b.setColor(this.f9743g);
            } else {
                this.b.setColor(this.f9744h);
            }
            canvas.drawCircle((i5 * 2 * i3) + i2, i4, i2, this.b);
        }
    }

    private void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f9742f = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4 = ((this.f9740d * 2) - 1) * 2 * this.c;
        String str = f9739i;
        us.pinguo.common.log.a.m(str, "onMeasure realWidth=" + i4, new Object[0]);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c * 2, 1073741824));
    }

    public void setCurrentIndex(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = this.f9740d;
            if (i2 >= i3) {
                i2 = i3;
            }
        }
        this.f9741e = i2;
        b();
    }

    public void setIndicatorRadius(int i2) {
        this.c = i2;
        requestLayout();
        b();
    }

    public void setSelectedColor(int i2) {
        this.f9743g = i2;
        b();
    }

    public void setSize(int i2) {
        this.f9740d = i2;
        this.f9741e = 0;
        requestLayout();
        b();
    }

    public void setUnSelectedColor(int i2) {
        this.f9744h = i2;
        b();
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Paint();
        this.f9743g = -13290187;
        this.f9744h = -3552823;
        this.a = getContext();
        this.b.setStyle(Paint.Style.FILL);
        this.c = us.pinguo.foundation.t.b.a.a(this.a, 3.0f);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new Paint();
        this.f9743g = -13290187;
        this.f9744h = -3552823;
        this.a = getContext();
        this.b.setStyle(Paint.Style.FILL);
        this.c = us.pinguo.foundation.t.b.a.a(this.a, 3.0f);
    }
}
