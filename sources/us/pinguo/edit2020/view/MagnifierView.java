package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: MagnifierView.kt */
/* loaded from: classes4.dex */
public final class MagnifierView extends View {
    private float a;
    private final PointF b;
    private final Paint c;

    /* renamed from: d  reason: collision with root package name */
    private float f10699d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10700e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10701f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10702g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = getContext().getResources().getDimension(R.dimen.magnifier_indicator_size_big);
        this.b = new PointF();
        this.c = new Paint(1);
        this.f10699d = getResources().getDimension(R.dimen.body_shape_line_width);
        this.f10700e = -1;
        this.f10701f = Color.parseColor("#250D0D0D");
    }

    private final void a(Canvas canvas) {
        this.c.setColor(Color.parseColor("#88ffffff"));
        PointF pointF = this.b;
        float f2 = pointF.x;
        float f3 = this.a;
        float f4 = 6;
        float f5 = pointF.y;
        canvas.drawLine(f2 - (f3 / f4), f5, f2 + (f3 / f4), f5, this.c);
        PointF pointF2 = this.b;
        float f6 = pointF2.x;
        float f7 = pointF2.y;
        float f8 = this.a;
        canvas.drawLine(f6, f7 - (f8 / f4), f6, f7 + (f8 / f4), this.c);
    }

    public final void b(float f2, float f3) {
        this.b.x = (getMeasuredWidth() * 0.5f) + f2;
        this.b.y = (getMeasuredHeight() * 0.5f) + f3;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        PointF pointF = this.b;
        float f2 = pointF.x;
        float f3 = pointF.y;
        float f4 = this.a * 0.5f;
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(this.f10701f);
        canvas.drawCircle(f2, f3, f4, this.c);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(this.f10700e);
        this.c.setStrokeWidth(this.f10699d);
        canvas.drawCircle(f2, f3, f4, this.c);
        this.c.setColor(-1);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f5 = this.f10699d * 0.5f;
        canvas.drawRect(f5, f5, measuredWidth - f5, measuredHeight - f5, this.c);
        if (this.f10702g) {
            a(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.b.x = getMeasuredWidth() * 0.5f;
        this.b.y = getMeasuredHeight() * 0.5f;
    }

    public final void setShowCross(boolean z) {
        if (this.f10702g != z) {
            this.f10702g = z;
            invalidate();
        }
    }

    public final void setSize(float f2) {
        if (f2 == this.a) {
            return;
        }
        this.a = f2;
        invalidate();
    }

    public final void setStrokeWidth(float f2) {
        this.f10699d = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = getContext().getResources().getDimension(R.dimen.magnifier_indicator_size_big);
        this.b = new PointF();
        this.c = new Paint(1);
        this.f10699d = getResources().getDimension(R.dimen.body_shape_line_width);
        this.f10700e = -1;
        this.f10701f = Color.parseColor("#250D0D0D");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = getContext().getResources().getDimension(R.dimen.magnifier_indicator_size_big);
        this.b = new PointF();
        this.c = new Paint(1);
        this.f10699d = getResources().getDimension(R.dimen.body_shape_line_width);
        this.f10700e = -1;
        this.f10701f = Color.parseColor("#250D0D0D");
    }
}
