package us.pinguo.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: WaterFillingView.kt */
/* loaded from: classes4.dex */
public final class WaterFillingView extends View {
    private final RectF a;
    private final Paint b;
    private final PorterDuffXfermode c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f9977d;

    /* renamed from: e  reason: collision with root package name */
    private int f9978e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9979f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterFillingView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = new RectF();
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint.setColor(getContext().getResources().getColor(R.color.color_camera_theme_dark));
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        Bitmap v = us.pinguo.util.e.v(this.f9977d, Math.max(getWidth(), getHeight()), 2, 0);
        if (v == null) {
            return;
        }
        this.a.left = (getWidth() - v.getWidth()) / 2.0f;
        RectF rectF = this.a;
        rectF.right = rectF.left + v.getWidth();
        this.a.top = (getHeight() - v.getHeight()) / 2.0f;
        RectF rectF2 = this.a;
        rectF2.bottom = rectF2.top + v.getHeight();
        canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.b);
        RectF rectF3 = this.a;
        canvas.drawBitmap(v, rectF3.left, rectF3.top, this.b);
        this.b.setXfermode(this.c);
        boolean z = this.f9979f;
        if (!z) {
            this.b.setColor(getContext().getResources().getColor(R.color.color_camera_theme_dark));
            RectF rectF4 = this.a;
            canvas.drawRect(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, this.b);
        } else if (!z && this.f9978e != 100) {
            this.b.setColor(getContext().getResources().getColor(R.color.color_camera_theme_dark));
            RectF rectF5 = this.a;
            canvas.drawRect(rectF5.left, rectF5.top, rectF5.right, rectF5.bottom - ((this.f9978e / 100.0f) * rectF5.height()), this.b);
        } else {
            this.b.setColor(getContext().getResources().getColor(R.color.color_camera_theme_black));
            RectF rectF6 = this.a;
            canvas.drawRect(rectF6.left, rectF6.top, rectF6.right, rectF6.bottom, this.b);
        }
        this.b.setXfermode(null);
        canvas.restore();
    }

    public final void setProgress(int i2) {
        if (this.f9978e == i2 || i2 < 0 || i2 > 100) {
            return;
        }
        this.f9978e = i2;
        invalidate();
    }

    public final void setSelect(boolean z) {
        if (this.f9979f != z) {
            this.f9979f = z;
            invalidate();
        }
    }

    public final void setSrcBitmap(Bitmap bitmap) {
        if (s.c(this.f9977d, bitmap)) {
            return;
        }
        this.f9977d = bitmap;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterFillingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        s.h(attributeSet, "attributeSet");
        new LinkedHashMap();
        this.a = new RectF();
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint.setColor(getContext().getResources().getColor(R.color.color_camera_theme_dark));
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterFillingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        s.h(attributeSet, "attributeSet");
        new LinkedHashMap();
        this.a = new RectF();
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint.setColor(getContext().getResources().getColor(R.color.color_camera_theme_dark));
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
    }
}
