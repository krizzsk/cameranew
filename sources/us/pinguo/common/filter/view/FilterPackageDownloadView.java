package us.pinguo.common.filter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.commonui.R;
import us.pinguo.foundation.utils.n0;
/* compiled from: FilterPackageDownloadView.kt */
/* loaded from: classes4.dex */
public final class FilterPackageDownloadView extends View {
    private boolean a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f9881d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f9882e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f9883f;

    /* renamed from: g  reason: collision with root package name */
    private final VectorDrawableCompat f9884g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f9885h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f9886i;

    /* renamed from: j  reason: collision with root package name */
    private final float f9887j;

    /* compiled from: FilterPackageDownloadView.kt */
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
    public FilterPackageDownloadView(Context context) {
        this(context, null);
        s.h(context, "context");
    }

    private final void a(Canvas canvas, a aVar, float f2, int i2) {
        this.f9883f.setShader(null);
        this.f9883f.setStyle(Paint.Style.FILL);
        this.f9883f.setFlags(1);
        this.f9883f.setStrokeWidth(n0.b(3.0f));
        this.f9883f.setStrokeCap(Paint.Cap.ROUND);
        RectF rectF = new RectF(aVar.a() - f2, aVar.a() - f2, aVar.a() + f2, aVar.a() + f2);
        this.f9881d = ((i2 * 360.0f) / this.c) * 1.0f;
        if (i2 > 0 && i2 < 100) {
            this.f9883f.setColor(-1);
            this.f9882e.setColor(getResources().getColor(R.color.color_camera_theme_80_dark));
        } else {
            this.f9883f.setColor(0);
            this.f9882e.setColor(0);
        }
        us.pinguo.common.log.a.k(s.q("FilterPackageDownloadView:currentValue->", Integer.valueOf(i2)), new Object[0]);
        if (canvas != null) {
            canvas.drawCircle(aVar.a(), aVar.a(), f2, this.f9882e);
        }
        if (canvas == null) {
            return;
        }
        canvas.drawArc(rectF, -90.0f, this.f9881d, true, this.f9883f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int b;
        int b2;
        int b3;
        int b4;
        int i2;
        s.h(canvas, "canvas");
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i3 = (this.a && ((i2 = this.b) == 0 || i2 == -1)) ? 100 : this.b;
        Path path = new Path();
        a aVar = new a();
        aVar.b((width / 2.0f) + getPaddingStart());
        aVar.c((height / 2.0f) + getPaddingTop());
        float min = Math.min(width / 2, height / 2) * 0.6f;
        this.f9886i.set(0, 0, getWidth(), getHeight());
        Drawable drawable = this.f9885h;
        if (drawable != null) {
            drawable.setBounds(this.f9886i);
        }
        Drawable drawable2 = this.f9885h;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (this.a && (i3 == 100 || i3 == 0 || i3 == -1)) {
            float f2 = 24 * this.f9887j;
            VectorDrawableCompat vectorDrawableCompat = this.f9884g;
            if (vectorDrawableCompat != null) {
                Rect rect = this.f9886i;
                float f3 = 2;
                b = kotlin.y.c.b(rect.left + ((rect.width() - f2) / f3));
                Rect rect2 = this.f9886i;
                b2 = kotlin.y.c.b(rect2.top + ((rect2.height() - f2) / f3));
                Rect rect3 = this.f9886i;
                b3 = kotlin.y.c.b(rect3.left + ((rect3.width() + f2) / f3));
                Rect rect4 = this.f9886i;
                b4 = kotlin.y.c.b(rect4.left + ((rect4.height() + f2) / f3));
                vectorDrawableCompat.setBounds(b, b2, b3, b4);
                vectorDrawableCompat.draw(canvas);
            }
        }
        canvas.save();
        path.addCircle(aVar.a(), aVar.a(), min - n0.b(2.0f), Path.Direction.CW);
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        a(canvas, aVar, min, i3);
    }

    public final void setDownloadProgress(int i2) {
        this.b = i2;
        invalidate();
    }

    public final void setHasSelected(boolean z) {
        this.a = z;
        postInvalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterPackageDownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.c = 100;
        this.f9882e = new Paint();
        this.f9883f = new Paint();
        this.f9884g = VectorDrawableCompat.create(getResources(), R.drawable.ic_item_selected, null);
        this.f9886i = new Rect();
        this.f9887j = getResources().getDisplayMetrics().density;
        this.f9883f.setColor(-1);
        this.f9883f.setAntiAlias(true);
        this.f9883f.setDither(true);
        this.f9882e.setColor(getResources().getColor(R.color.color_camera_theme_80_dark));
        this.f9882e.setAntiAlias(true);
        this.f9882e.setDither(true);
        if (getBackground() == null) {
            this.f9885h = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_filter_item_selected, null);
        }
    }
}
