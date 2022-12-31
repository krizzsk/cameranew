package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes6.dex */
public class RoundGifImageView extends AppCompatImageView {
    private float a;
    private Canvas b;
    private Bitmap c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12189d;

    public RoundGifImageView(Context context) {
        super(context);
        this.f12189d = new Paint();
    }

    private void a() {
        if (this.b != null) {
            return;
        }
        this.c = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.b = new Canvas(this.c);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        a();
        super.onDraw(this.b);
        Paint paint = this.f12189d;
        Bitmap bitmap = this.c;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, this.f12189d);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.c = null;
        this.b = null;
    }

    public void setCornerRadius(float f2) {
        this.a = f2;
        invalidate();
    }

    public void setGifPath(String str) {
        try {
            pl.droidsonroids.gif.c cVar = new pl.droidsonroids.gif.c(str);
            setImageDrawable(cVar);
            cVar.start();
        } catch (Throwable th) {
            us.pinguo.common.log.a.f(th);
        }
    }

    public RoundGifImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12189d = new Paint();
    }

    public RoundGifImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12189d = new Paint();
    }
}
