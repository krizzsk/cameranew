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
/* compiled from: BoldTipView.kt */
/* loaded from: classes4.dex */
public final class BoldTipView extends View {
    private final PointF a;
    private final Paint b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private float f10624d;

    /* renamed from: e  reason: collision with root package name */
    private float f10625e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoldTipView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new PointF();
        this.b = new Paint(1);
        this.c = Color.parseColor("#B2FFFFFF");
        this.f10624d = getResources().getDimension(R.dimen.body_shape_line_width);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10625e = us.pinguo.util.g.b(context2, 48.0f);
    }

    public final float a() {
        return this.f10625e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(this.c);
        this.b.setStrokeWidth(this.f10624d);
        PointF pointF = this.a;
        canvas.drawCircle(pointF.x, pointF.y, this.f10625e * 0.5f, this.b);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.x = getMeasuredWidth() * 0.5f;
        this.a.y = getMeasuredHeight() * 0.5f;
    }

    public final void setSize(float f2) {
        this.f10625e = f2;
        invalidate();
    }

    public final void setStrokeWidth(float f2) {
        this.f10624d = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoldTipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new PointF();
        this.b = new Paint(1);
        this.c = Color.parseColor("#B2FFFFFF");
        this.f10624d = getResources().getDimension(R.dimen.body_shape_line_width);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10625e = us.pinguo.util.g.b(context2, 48.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoldTipView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new PointF();
        this.b = new Paint(1);
        this.c = Color.parseColor("#B2FFFFFF");
        this.f10624d = getResources().getDimension(R.dimen.body_shape_line_width);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10625e = us.pinguo.util.g.b(context2, 48.0f);
    }
}
