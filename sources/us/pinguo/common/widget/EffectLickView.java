package us.pinguo.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.utils.n0;
/* loaded from: classes4.dex */
public class EffectLickView extends View {
    private Bitmap a;
    private Paint b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private int f9950d;

    /* renamed from: e  reason: collision with root package name */
    private Path f9951e;

    /* renamed from: f  reason: collision with root package name */
    private int f9952f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f9953g;

    /* renamed from: h  reason: collision with root package name */
    private float f9954h;

    /* renamed from: i  reason: collision with root package name */
    private float f9955i;

    /* renamed from: j  reason: collision with root package name */
    private float f9956j;

    /* renamed from: k  reason: collision with root package name */
    private float f9957k;

    public EffectLickView(Context context) {
        super(context);
        this.f9951e = new Path();
        this.f9954h = n0.c(4);
        this.f9955i = n0.c(4);
        this.f9956j = n0.c(4);
        this.f9957k = Resources.getSystem().getDisplayMetrics().density;
    }

    private void a() {
        if (this.a == null) {
            try {
                this.a = BitmapFactory.decodeResource(getResources(), us.pinguo.commonui.R.drawable.camera_filter_collection_icon);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.b == null) {
            Paint paint = new Paint(1);
            this.b = paint;
            paint.setColor(-39312);
            this.b.setStyle(Paint.Style.FILL);
        }
        if (this.f9950d == 0) {
            this.f9950d = (int) ((getResources().getDisplayMetrics().density * 21.0f) + 0.5f);
        }
        if (this.f9952f == 0) {
            this.f9952f = (int) ((this.f9957k * 3.0f) + 0.5f);
        }
        if (this.f9953g == null) {
            this.f9953g = new RectF(0.0f, 0.0f, getWidth(), getHeight());
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
        float width = (getWidth() + getHeight()) - this.f9950d;
        int i2 = (int) (width * f2);
        this.f9951e.reset();
        this.f9951e.moveTo(this.f9954h, 0.0f);
        if (i2 > getHeight()) {
            float f3 = width * (1.0f - f2);
            this.f9951e.lineTo(this.f9950d + f3, 0.0f);
            Path path = this.f9951e;
            int i3 = this.f9950d;
            path.lineTo(i3 + f3, (i3 + f3) - this.f9956j);
            Path path2 = this.f9951e;
            int i4 = this.f9950d;
            float f4 = this.f9956j;
            path2.quadTo(i4 + f3, (i4 + f3) - f4, (i4 + f3) - f4, i4 + f3);
            this.f9951e.lineTo(0.0f, this.f9950d + f3);
            this.f9951e.lineTo(0.0f, this.f9955i);
            this.f9951e.quadTo(0.0f, 0.0f, this.f9954h, 0.0f);
            this.f9951e.close();
        } else {
            this.f9951e.lineTo(getWidth(), 0.0f);
            this.f9951e.lineTo(getWidth(), getHeight() - i2);
            this.f9951e.lineTo(getWidth(), getHeight() - this.f9956j);
            this.f9951e.quadTo(getWidth(), getHeight(), getWidth() - this.f9956j, getHeight());
            this.f9951e.lineTo(getWidth() - i2, getHeight());
            this.f9951e.lineTo(0.0f, getHeight());
            this.f9951e.lineTo(0.0f, this.f9955i);
            this.f9951e.quadTo(0.0f, 0.0f, this.f9954h, 0.0f);
            this.f9951e.close();
        }
        canvas.drawPath(this.f9951e, this.b);
        if (this.a != null) {
            float width2 = (this.f9950d / 3) + (((getWidth() / 2) - (this.f9950d / 3)) * (1.0f - f2));
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
        this.f9951e = new Path();
        this.f9954h = n0.c(4);
        this.f9955i = n0.c(4);
        this.f9956j = n0.c(4);
        this.f9957k = Resources.getSystem().getDisplayMetrics().density;
        float dimensionPixelSize = context.obtainStyledAttributes(attributeSet, us.pinguo.commonui.R.styleable.EffectLickView).getDimensionPixelSize(us.pinguo.commonui.R.styleable.EffectLickView_radius, n0.c(4));
        this.f9954h = dimensionPixelSize;
        this.f9955i = dimensionPixelSize;
        b();
    }

    public EffectLickView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9951e = new Path();
        this.f9954h = n0.c(4);
        this.f9955i = n0.c(4);
        this.f9956j = n0.c(4);
        this.f9957k = Resources.getSystem().getDisplayMetrics().density;
    }
}
