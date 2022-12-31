package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.foundation.t.a.f;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeatureImageView extends PhotoImageView {
    private Bitmap mCacheBitmap;
    private Canvas mCanvas;
    private float mCornerRadius;
    private Paint mPaint;

    public FeatureImageView(Context context) {
        super(context);
    }

    private void initCacheBitmap() {
        if (this.mCanvas != null) {
            return;
        }
        this.mCacheBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mCacheBitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.feeds_feature_radius);
        c.b bVar = new c.b();
        bVar.w(this.mDisplayImageOptions);
        bVar.y(new f(dimensionPixelSize));
        a.C0453a c0453a = new a.C0453a();
        c0453a.d(true);
        bVar.z(c0453a);
        bVar.A(ImageScaleType.EXACTLY);
        this.mDisplayImageOptions = bVar.t();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setFilterBitmap(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mCornerRadius == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        initCacheBitmap();
        super.onDraw(this.mCanvas);
        Paint paint = this.mPaint;
        Bitmap bitmap = this.mCacheBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        float f2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, f2, f2, this.mPaint);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mCacheBitmap = null;
        this.mCanvas = null;
    }

    public void setCornerRadius(float f2) {
        this.mCornerRadius = f2;
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

    public void setGifRes(int i2) {
        try {
            pl.droidsonroids.gif.c cVar = new pl.droidsonroids.gif.c(getResources(), i2);
            setImageDrawable(cVar);
            cVar.start();
        } catch (Throwable th) {
            us.pinguo.common.log.a.f(th);
        }
    }

    public FeatureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeatureImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
