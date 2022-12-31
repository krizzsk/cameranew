package us.pinguo.camera2020.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: HalfColorView.kt */
/* loaded from: classes3.dex */
public final class HalfColorView extends ImageView {
    private boolean a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9474d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f9475e;

    /* renamed from: f  reason: collision with root package name */
    private float f9476f;

    /* renamed from: g  reason: collision with root package name */
    private float f9477g;

    /* renamed from: h  reason: collision with root package name */
    private float f9478h;

    /* renamed from: i  reason: collision with root package name */
    private int f9479i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f9480j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HalfColorView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.f9474d = -16711681;
        this.f9475e = new RectF();
        this.f9479i = SupportMenu.CATEGORY_MASK;
        Paint paint = new Paint(1);
        this.f9480j = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        if (this.b) {
            Paint paint = this.f9480j;
            if (this.a) {
                paint.setColor(this.c);
                canvas.drawArc(this.f9475e, 90.0f, 180.0f, false, paint);
                paint.setColor(this.f9474d);
                canvas.drawArc(this.f9475e, -90.0f, 180.0f, false, paint);
                return;
            }
            paint.setColor(this.f9479i);
            canvas.drawCircle(this.f9476f, this.f9477g, this.f9478h, paint);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float f2 = (measuredWidth >= measuredHeight ? measuredHeight : measuredWidth) * 0.5f;
        this.f9478h = f2;
        float f3 = measuredWidth * 0.5f;
        this.f9476f = f3;
        float f4 = measuredHeight * 0.5f;
        this.f9477g = f4;
        RectF rectF = this.f9475e;
        rectF.left = f3 - f2;
        rectF.top = f4 - f2;
        rectF.right = f3 + f2;
        rectF.bottom = f4 + f2;
    }

    public final void setColor(int i2) {
        this.f9479i = i2;
    }

    public final void setEnableColorShow(boolean z) {
        this.b = z;
    }

    public final void setEnableHalfShow(boolean z) {
        this.a = z;
    }

    public final void setTwoColors(int i2, int i3) {
        this.c = i2;
        this.f9474d = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HalfColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.f9474d = -16711681;
        this.f9475e = new RectF();
        this.f9479i = SupportMenu.CATEGORY_MASK;
        Paint paint = new Paint(1);
        this.f9480j = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HalfColorView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.f9474d = -16711681;
        this.f9475e = new RectF();
        this.f9479i = SupportMenu.CATEGORY_MASK;
        Paint paint = new Paint(1);
        this.f9480j = paint;
        paint.setStyle(Paint.Style.FILL);
    }
}
