package us.pinguo.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.n0;
/* compiled from: ImageRestorationProgressView.kt */
/* loaded from: classes4.dex */
public final class ImageRestorationProgressView extends View {
    private int a;
    private int b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f9962d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f9963e;

    /* compiled from: ImageRestorationProgressView.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private float a;

        public final float a() {
            return this.a;
        }

        public final void b(float f2) {
            this.a = f2;
        }

        public final void c(float f2) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageRestorationProgressView(Context context) {
        this(context, null);
        s.h(context, "context");
    }

    private final void a(Canvas canvas, a aVar, float f2, int i2) {
        this.f9963e.setShader(null);
        this.f9963e.setStyle(Paint.Style.FILL);
        this.f9963e.setFlags(1);
        this.f9963e.setStrokeWidth(n0.b(3.0f));
        this.f9963e.setStrokeCap(Paint.Cap.ROUND);
        RectF rectF = new RectF(aVar.a() - f2, aVar.a() - f2, aVar.a() + f2, aVar.a() + f2);
        this.c = ((i2 * 360.0f) / this.b) * 1.0f;
        this.f9963e.setColor(getResources().getColor(us.pinguo.commonui.R.color.color_fab615));
        this.f9962d.setColor(getResources().getColor(us.pinguo.commonui.R.color.filter_bubble_grey));
        us.pinguo.common.log.a.k(s.q("FilterPackageDownloadView:currentValue->", Integer.valueOf(i2)), new Object[0]);
        if (canvas != null) {
            canvas.drawCircle(aVar.a(), aVar.a(), f2, this.f9962d);
        }
        if (canvas == null) {
            return;
        }
        canvas.drawArc(rectF, -90.0f, this.c, true, this.f9963e);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        Path path = new Path();
        a aVar = new a();
        aVar.b((width / 2.0f) + getPaddingStart());
        aVar.c((height / 2.0f) + getPaddingTop());
        float min = Math.min(width / 2, height / 2) * 1.0f;
        canvas.save();
        path.addCircle(aVar.a(), aVar.a(), min - n0.b(4.0f), Path.Direction.CW);
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        a(canvas, aVar, min, this.a);
    }

    public final void setProgress(int i2) {
        this.a = i2;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageRestorationProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRestorationProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.b = 100;
        this.f9962d = new Paint();
        Paint paint = new Paint();
        this.f9963e = paint;
        paint.setColor(getResources().getColor(us.pinguo.commonui.R.color.filter_bubble_grey));
        this.f9963e.setAntiAlias(true);
        this.f9963e.setDither(true);
        this.f9962d.setColor(getResources().getColor(us.pinguo.commonui.R.color.color_fab615));
        this.f9962d.setAntiAlias(true);
        this.f9962d.setDither(true);
    }
}
