package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.controller.e3;
/* compiled from: BlurringOvalView.kt */
/* loaded from: classes4.dex */
public final class BlurringOvalView extends View {
    private final Paint a;
    private final RectF b;
    private final RectF c;

    /* renamed from: d  reason: collision with root package name */
    private final PointF f10608d;

    /* renamed from: e  reason: collision with root package name */
    private float f10609e;

    /* renamed from: f  reason: collision with root package name */
    private float f10610f;

    /* renamed from: g  reason: collision with root package name */
    private float f10611g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10612h;

    /* renamed from: i  reason: collision with root package name */
    private e3 f10613i;

    /* renamed from: j  reason: collision with root package name */
    private BlurShape f10614j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurringOvalView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = new RectF();
        this.c = new RectF();
        this.f10608d = new PointF();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 1.0f));
        this.f10614j = BlurShape.Oval;
    }

    public final void a() {
        this.f10612h = true;
        invalidate();
    }

    public final void b(float f2, float f3, float f4, float f5, float f6) {
        this.f10612h = false;
        setShape(BlurShape.Line);
        this.f10611g = f6;
        PointF pointF = this.f10608d;
        pointF.x = f2;
        pointF.y = f3;
        this.f10609e = f4;
        this.f10610f = f5;
        invalidate();
    }

    public final void c(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f10612h = false;
        setShape(BlurShape.Oval);
        this.f10611g = f8;
        RectF rectF = this.b;
        rectF.left = f2 - f4;
        rectF.top = f3 - f5;
        rectF.right = f4 + f2;
        rectF.bottom = f5 + f3;
        RectF rectF2 = this.c;
        rectF2.left = f2 - f6;
        rectF2.top = f3 - f7;
        rectF2.right = f2 + f6;
        rectF2.bottom = f3 + f7;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int save;
        kotlin.jvm.internal.s.h(canvas, "canvas");
        if (this.f10612h) {
            return;
        }
        if (this.f10614j == BlurShape.Oval) {
            float f2 = this.f10611g;
            float centerX = this.b.centerX();
            float centerY = this.b.centerY();
            save = canvas.save();
            canvas.rotate(f2, centerX, centerY);
            try {
                canvas.drawOval(this.b, this.a);
                canvas.drawOval(this.c, this.a);
                return;
            } finally {
            }
        }
        float f3 = this.f10611g;
        PointF pointF = this.f10608d;
        float f4 = pointF.x;
        float f5 = pointF.y;
        save = canvas.save();
        canvas.rotate(f3, f4, f5);
        try {
            canvas.drawLine((-getMeasuredHeight()) * 5.0f, this.f10608d.y - this.f10609e, getMeasuredHeight() * 5.0f, this.f10608d.y - this.f10609e, this.a);
            canvas.drawLine((-getMeasuredHeight()) * 5.0f, this.f10608d.y + this.f10609e, getMeasuredHeight() * 5.0f, this.f10608d.y + this.f10609e, this.a);
            canvas.drawLine((-getMeasuredHeight()) * 5.0f, (this.f10608d.y - this.f10609e) - this.f10610f, getMeasuredHeight() * 5.0f, (this.f10608d.y - this.f10609e) - this.f10610f, this.a);
            canvas.drawLine((-getMeasuredHeight()) * 5.0f, this.f10608d.y + this.f10609e + this.f10610f, getMeasuredHeight() * 5.0f, this.f10608d.y + this.f10609e + this.f10610f, this.a);
        } finally {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        e3 e3Var;
        kotlin.jvm.internal.s.h(event, "event");
        super.onTouchEvent(event);
        if ((getVisibility() == 0) && (e3Var = this.f10613i) != null) {
            return e3Var.b(event);
        }
        return false;
    }

    public final void setConsumer(e3 e3Var) {
        this.f10613i = e3Var;
    }

    public final void setShape(BlurShape value) {
        kotlin.jvm.internal.s.h(value, "value");
        if (value != this.f10614j) {
            this.f10614j = value;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurringOvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = new RectF();
        this.c = new RectF();
        this.f10608d = new PointF();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 1.0f));
        this.f10614j = BlurShape.Oval;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurringOvalView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = new RectF();
        this.c = new RectF();
        this.f10608d = new PointF();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 1.0f));
        this.f10614j = BlurShape.Oval;
    }
}
