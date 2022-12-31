package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.R;
/* compiled from: CommonRoundHelper.java */
/* loaded from: classes6.dex */
public class g {
    private int a = n0.c(4);
    private Paint b = null;
    private Matrix c = null;

    /* renamed from: d  reason: collision with root package name */
    private BitmapShader f12290d = null;

    /* renamed from: e  reason: collision with root package name */
    private RectF f12291e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private ImageView f12292f;

    public g(ImageView imageView, Context context, @Nullable AttributeSet attributeSet, int i2) {
        this.f12292f = imageView;
        b();
        c(context, attributeSet, i2);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? this.f12292f.getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? this.f12292f.getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void b() {
        this.c = new Matrix();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonRoundImageView, i2, 0);
        this.a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CommonRoundImageView_common_radio, n0.c(4));
        obtainStyledAttributes.recycle();
    }

    public void d(Canvas canvas) {
        if (this.f12292f.getDrawable() == null) {
            return;
        }
        Bitmap a = a(this.f12292f.getDrawable());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f12290d = new BitmapShader(a, tileMode, tileMode);
        float width = this.f12292f.getWidth();
        float height = this.f12292f.getHeight();
        float width2 = a.getWidth();
        float height2 = a.getHeight();
        float f2 = 1.0f;
        if (width2 != width || height2 != height) {
            f2 = Math.max((width * 1.0f) / width2, (1.0f * height) / height2);
        }
        this.c.reset();
        float f3 = ((width2 * f2) - width) / 2.0f;
        float f4 = ((height2 * f2) - height) / 2.0f;
        this.c.setScale(f2, f2);
        int i2 = (f3 > 0.1d ? 1 : (f3 == 0.1d ? 0 : -1));
        if (i2 > 0 || f4 > 0.1d) {
            this.c.postTranslate(i2 > 0 ? -f3 : 0.0f, ((double) f4) > 0.1d ? -f4 : 0.0f);
        }
        this.f12290d.setLocalMatrix(this.c);
        this.b.setShader(this.f12290d);
        this.f12291e.set(0.0f, 0.0f, width, height);
        RectF rectF = this.f12291e;
        int i3 = this.a;
        canvas.drawRoundRect(rectF, i3, i3, this.b);
    }

    public void e(int i2) {
        this.a = i2;
        this.f12292f.invalidate();
    }
}
