package us.pinguo.inspire.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class HighLightView extends ImageView implements Runnable {
    private Bitmap a;
    private Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private long f11316d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f11317e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f11318f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f11319g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f11320h;

    /* renamed from: i  reason: collision with root package name */
    private Matrix f11321i;

    /* renamed from: j  reason: collision with root package name */
    private TimeInterpolator f11322j;

    public HighLightView(Context context) {
        super(context);
        this.b = new Paint();
        this.c = 2400;
        this.f11317e = new RectF();
        this.f11318f = new RectF();
        this.f11319g = new RectF();
        this.f11320h = new RectF();
        this.f11321i = new Matrix();
        this.f11322j = new DecelerateInterpolator(2.0f);
    }

    private void a() {
        if (this.a != null) {
            return;
        }
        try {
            this.a = BitmapFactory.decodeResource(getResources(), R.drawable.coin_highlight);
        } catch (OutOfMemoryError e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a != null && (getDrawable() instanceof BitmapDrawable)) {
            canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.b, 31);
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            this.f11319g.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f11320h.set(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            this.f11321i.setRectToRect(this.f11319g, this.f11320h, Matrix.ScaleToFit.CENTER);
            canvas.drawBitmap(bitmap, this.f11321i, this.b);
            this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            this.f11317e.set(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
            RectF rectF = this.f11317e;
            Rect rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            canvas.save();
            canvas.rotate(45.0f, this.f11318f.centerX(), this.f11318f.centerY());
            this.b.setAlpha(204);
            canvas.drawBitmap(this.a, rect, this.f11318f, this.b);
            this.b.setAlpha(255);
            this.b.setXfermode(null);
            canvas.restore();
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f11316d == -1) {
            this.f11316d = System.currentTimeMillis();
        }
        float currentTimeMillis = ((float) (System.currentTimeMillis() - this.f11316d)) / this.c;
        if (currentTimeMillis >= 1.0f) {
            this.a = null;
            return;
        }
        float interpolation = this.f11322j.getInterpolation(currentTimeMillis);
        a();
        float width = getWidth();
        float height = getHeight();
        float f2 = width + ((((-getWidth()) * 1.5f) - width) * interpolation);
        float f3 = height + ((((-getHeight()) * 1.5f) - height) * interpolation);
        this.f11318f.set(f2, f3, this.f11317e.width() + f2, (((int) Math.sqrt(Math.pow(getWidth(), 2.0d) + Math.pow(getHeight(), 2.0d))) * 3) + f3);
        this.f11321i.setRectToRect(this.f11317e, this.f11318f, Matrix.ScaleToFit.FILL);
        invalidate();
        postDelayed(this, 6L);
    }

    public HighLightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Paint();
        this.c = 2400;
        this.f11317e = new RectF();
        this.f11318f = new RectF();
        this.f11319g = new RectF();
        this.f11320h = new RectF();
        this.f11321i = new Matrix();
        this.f11322j = new DecelerateInterpolator(2.0f);
    }

    public HighLightView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new Paint();
        this.c = 2400;
        this.f11317e = new RectF();
        this.f11318f = new RectF();
        this.f11319g = new RectF();
        this.f11320h = new RectF();
        this.f11321i = new Matrix();
        this.f11322j = new DecelerateInterpolator(2.0f);
    }
}
