package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: CircleColorItemView.kt */
/* loaded from: classes4.dex */
public final class CircleColorItemView extends View {
    private final Paint a;
    private final PointF b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10631d;

    /* renamed from: e  reason: collision with root package name */
    private float f10632e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f10633f;

    /* renamed from: g  reason: collision with root package name */
    private int f10634g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10635h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10636i;

    /* renamed from: j  reason: collision with root package name */
    private int f10637j;

    /* renamed from: k  reason: collision with root package name */
    private int f10638k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleColorItemView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = new PointF();
        this.c = getContext().getResources().getDimension(R.dimen.circle_color_content_radius);
        this.f10631d = getContext().getResources().getDimension(R.dimen.circle_color_ring_radius);
        this.f10632e = getContext().getResources().getDimension(R.dimen.circle_color_ring_stroke_width);
        this.f10634g = SupportMenu.CATEGORY_MASK;
        this.f10637j = SupportMenu.CATEGORY_MASK;
        this.f10638k = SupportMenu.CATEGORY_MASK;
    }

    public final boolean a() {
        return this.f10635h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        this.a.setColor(this.f10634g);
        float f2 = this.c;
        if (this.f10635h) {
            f2 -= this.f10632e;
            float f3 = this.f10631d;
            Integer num = this.f10633f;
            if (num != null) {
                this.a.setColor(num.intValue());
                if (this.f10632e == getContext().getResources().getDimension(R.dimen.circle_color_ring_stroke_width) * 2.0f) {
                    f3 = this.c;
                    f2 = f3 - (this.f10632e * 0.5f);
                }
                if (this.f10632e == getContext().getResources().getDimension(R.dimen.circle_color_individual_ring_width)) {
                    f3 = this.c - (this.f10632e * 0.5f);
                }
            } else {
                this.a.setColor(this.f10634g);
            }
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.f10632e);
            PointF pointF = this.b;
            canvas.drawCircle(pointF.x, pointF.y, f3, this.a);
        }
        this.a.setStyle(Paint.Style.FILL);
        if (this.f10636i) {
            this.a.setColor(this.f10638k);
            PointF pointF2 = this.b;
            float f4 = pointF2.x;
            float f5 = pointF2.y;
            canvas.drawArc(f4 - f2, f5 - f2, f4 + f2, f5 + f2, 90.0f, 180.0f, true, this.a);
            this.a.setColor(this.f10637j);
            PointF pointF3 = this.b;
            float f6 = pointF3.x;
            float f7 = pointF3.y;
            canvas.drawArc(f6 - f2, f7 - f2, f6 + f2, f7 + f2, -90.0f, 180.0f, true, this.a);
            return;
        }
        this.a.setColor(this.f10634g);
        PointF pointF4 = this.b;
        canvas.drawCircle(pointF4.x, pointF4.y, f2, this.a);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.b.x = getMeasuredWidth() * 0.5f;
        this.b.y = getMeasuredHeight() * 0.5f;
    }

    public final void setColor(int i2) {
        if (i2 == this.f10634g) {
            return;
        }
        this.f10634g = i2;
        invalidate();
    }

    public final void setEnableHalf(boolean z) {
        if (z == this.f10636i) {
            return;
        }
        this.f10636i = z;
        invalidate();
    }

    public final void setEnableRing(boolean z) {
        if (z == this.f10635h) {
            return;
        }
        this.f10635h = z;
        invalidate();
    }

    public final void setIndividualRingColor(Integer num) {
        if (kotlin.jvm.internal.s.c(num, this.f10633f)) {
            return;
        }
        this.f10633f = num;
        invalidate();
    }

    public final void setLeftHalfColor(int i2) {
        if (i2 == this.f10638k) {
            return;
        }
        this.f10638k = i2;
        invalidate();
    }

    public final void setRightHalfColor(int i2) {
        if (i2 == this.f10637j) {
            return;
        }
        this.f10637j = i2;
        invalidate();
    }

    public final void setRingWidth(float f2) {
        if (f2 == this.f10632e) {
            return;
        }
        this.f10632e = f2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleColorItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = new PointF();
        this.c = getContext().getResources().getDimension(R.dimen.circle_color_content_radius);
        this.f10631d = getContext().getResources().getDimension(R.dimen.circle_color_ring_radius);
        this.f10632e = getContext().getResources().getDimension(R.dimen.circle_color_ring_stroke_width);
        this.f10634g = SupportMenu.CATEGORY_MASK;
        this.f10637j = SupportMenu.CATEGORY_MASK;
        this.f10638k = SupportMenu.CATEGORY_MASK;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleColorItemView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = new PointF();
        this.c = getContext().getResources().getDimension(R.dimen.circle_color_content_radius);
        this.f10631d = getContext().getResources().getDimension(R.dimen.circle_color_ring_radius);
        this.f10632e = getContext().getResources().getDimension(R.dimen.circle_color_ring_stroke_width);
        this.f10634g = SupportMenu.CATEGORY_MASK;
        this.f10637j = SupportMenu.CATEGORY_MASK;
        this.f10638k = SupportMenu.CATEGORY_MASK;
    }
}
