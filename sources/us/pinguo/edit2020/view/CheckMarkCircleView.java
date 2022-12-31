package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: CheckMarkCircleView.kt */
/* loaded from: classes4.dex */
public final class CheckMarkCircleView extends View {
    private final Paint a;
    private final PointF b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10626d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10627e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.f f10628f;

    /* renamed from: g  reason: collision with root package name */
    private int f10629g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10630h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckMarkCircleView(Context context) {
        super(context);
        kotlin.f b;
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = new PointF();
        this.f10626d = us.pinguo.common.widget.i.a.b(1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10627e = us.pinguo.edit2020.utils.d.c(context2, R.color.color_graffiti_stroke);
        b = kotlin.h.b(CheckMarkCircleView$checkMarkResource$2.INSTANCE);
        this.f10628f = b;
        this.f10629g = SupportMenu.CATEGORY_MASK;
    }

    private final Bitmap a() {
        return (Bitmap) this.f10628f.getValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        this.a.setColor(this.f10629g);
        this.a.setStyle(Paint.Style.FILL);
        PointF pointF = this.b;
        canvas.drawCircle(pointF.x, pointF.y, this.c, this.a);
        this.a.setColor(this.f10627e);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f10626d);
        PointF pointF2 = this.b;
        canvas.drawCircle(pointF2.x, pointF2.y, this.c, this.a);
        if (this.f10630h) {
            this.a.setColor(-1);
            canvas.drawBitmap(a(), this.b.x - (a().getWidth() / 2), this.b.y - (a().getHeight() / 2), this.a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.b.x = getMeasuredWidth() * 0.5f;
        this.b.y = getMeasuredHeight() * 0.5f;
        this.c = getMeasuredWidth() / 2.0f;
    }

    public final void setColor(int i2) {
        if (i2 == this.f10629g) {
            return;
        }
        this.f10629g = i2;
    }

    public final void setEnableRing(boolean z) {
        if (z == this.f10630h) {
            return;
        }
        this.f10630h = z;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckMarkCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.f b;
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = new PointF();
        this.f10626d = us.pinguo.common.widget.i.a.b(1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10627e = us.pinguo.edit2020.utils.d.c(context2, R.color.color_graffiti_stroke);
        b = kotlin.h.b(CheckMarkCircleView$checkMarkResource$2.INSTANCE);
        this.f10628f = b;
        this.f10629g = SupportMenu.CATEGORY_MASK;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckMarkCircleView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.f b;
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = new PointF();
        this.f10626d = us.pinguo.common.widget.i.a.b(1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10627e = us.pinguo.edit2020.utils.d.c(context2, R.color.color_graffiti_stroke);
        b = kotlin.h.b(CheckMarkCircleView$checkMarkResource$2.INSTANCE);
        this.f10628f = b;
        this.f10629g = SupportMenu.CATEGORY_MASK;
    }
}
