package us.pinguo.edit2020.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.edit2020.R;
/* loaded from: classes4.dex */
public class EffectLickView extends View {
    private Bitmap a;
    private Paint b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private int f10645d;

    /* renamed from: e  reason: collision with root package name */
    private Path f10646e;

    /* renamed from: f  reason: collision with root package name */
    private int f10647f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f10648g;

    /* renamed from: h  reason: collision with root package name */
    private float f10649h;

    /* renamed from: i  reason: collision with root package name */
    private float f10650i;

    /* renamed from: j  reason: collision with root package name */
    private float f10651j;

    /* renamed from: k  reason: collision with root package name */
    private float f10652k;

    public EffectLickView(Context context) {
        super(context);
        this.f10646e = new Path();
        this.f10649h = us.pinguo.foundation.utils.n0.c(4);
        this.f10650i = us.pinguo.foundation.utils.n0.c(4);
        this.f10651j = us.pinguo.foundation.utils.n0.c(4);
        this.f10652k = Resources.getSystem().getDisplayMetrics().density;
    }

    private void a() {
        if (this.a == null) {
            try {
                this.a = BitmapFactory.decodeResource(getResources(), R.drawable.camera_filter_collection_icon);
            } catch (OutOfMemoryError unused) {
            }
        }
        if (this.b == null) {
            Paint paint = new Paint(1);
            this.b = paint;
            paint.setColor(-39312);
            this.b.setStyle(Paint.Style.FILL);
        }
        if (this.f10645d == 0) {
            this.f10645d = (int) ((getResources().getDisplayMetrics().density * 21.0f) + 0.5f);
        }
        if (this.f10647f == 0) {
            this.f10647f = (int) ((this.f10652k * 3.0f) + 0.5f);
        }
        if (this.f10648g == null) {
            this.f10648g = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    @TargetApi(11)
    private void b() {
        setLayerType(1, null);
    }

    private void c(Canvas canvas) {
        this.b.setAlpha((int) (this.c * 255.0f));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.b);
        if (this.a == null) {
            return;
        }
        canvas.drawBitmap(this.a, (getWidth() / 2.0f) - (this.a.getWidth() / 2.0f), (getHeight() / 2.0f) - (this.a.getHeight() / 2.0f), this.b);
    }

    private void d(Canvas canvas) {
        Bitmap bitmap;
        float f2 = this.c;
        this.b.setAlpha((int) (255.0f * f2));
        float width = (getWidth() + getHeight()) - this.f10645d;
        int i2 = (int) (width * f2);
        this.f10646e.reset();
        this.f10646e.moveTo(this.f10649h, 0.0f);
        if (i2 > getHeight()) {
            float f3 = width * (1.0f - f2);
            this.f10646e.lineTo(this.f10645d + f3, 0.0f);
            Path path = this.f10646e;
            int i3 = this.f10645d;
            path.lineTo(i3 + f3, (i3 + f3) - this.f10651j);
            Path path2 = this.f10646e;
            int i4 = this.f10645d;
            float f4 = this.f10651j;
            path2.quadTo(i4 + f3, (i4 + f3) - f4, (i4 + f3) - f4, i4 + f3);
            this.f10646e.lineTo(0.0f, this.f10645d + f3);
            this.f10646e.lineTo(0.0f, this.f10650i);
            this.f10646e.quadTo(0.0f, 0.0f, this.f10649h, 0.0f);
            this.f10646e.close();
        } else {
            this.f10646e.lineTo(getWidth(), 0.0f);
            this.f10646e.lineTo(getWidth(), getHeight() - i2);
            this.f10646e.lineTo(getWidth(), getHeight() - this.f10651j);
            this.f10646e.quadTo(getWidth(), getHeight(), getWidth() - this.f10651j, getHeight());
            this.f10646e.lineTo(getWidth() - i2, getHeight());
            this.f10646e.lineTo(0.0f, getHeight());
            this.f10646e.lineTo(0.0f, this.f10650i);
            this.f10646e.quadTo(0.0f, 0.0f, this.f10649h, 0.0f);
            this.f10646e.close();
        }
        canvas.drawPath(this.f10646e, this.b);
        if (this.a != null) {
            float width2 = (this.f10645d / 3) + (((getWidth() / 2) - (this.f10645d / 3)) * (1.0f - f2));
            canvas.drawBitmap(this.a, width2 - (bitmap.getWidth() / 2), width2 - (this.a.getHeight() / 2), this.b);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a();
        if (this.c < 0.2f) {
            c(canvas);
        } else {
            d(canvas);
        }
    }

    public void setRate(float f2) {
        this.c = f2;
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        invalidate();
    }

    public EffectLickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10646e = new Path();
        this.f10649h = us.pinguo.foundation.utils.n0.c(4);
        this.f10650i = us.pinguo.foundation.utils.n0.c(4);
        this.f10651j = us.pinguo.foundation.utils.n0.c(4);
        this.f10652k = Resources.getSystem().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EffectLickView);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EffectLickView_radius, us.pinguo.foundation.utils.n0.c(4));
        obtainStyledAttributes.recycle();
        float f2 = dimensionPixelSize;
        this.f10649h = f2;
        this.f10650i = f2;
        b();
    }

    public EffectLickView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10646e = new Path();
        this.f10649h = us.pinguo.foundation.utils.n0.c(4);
        this.f10650i = us.pinguo.foundation.utils.n0.c(4);
        this.f10651j = us.pinguo.foundation.utils.n0.c(4);
        this.f10652k = Resources.getSystem().getDisplayMetrics().density;
    }
}
