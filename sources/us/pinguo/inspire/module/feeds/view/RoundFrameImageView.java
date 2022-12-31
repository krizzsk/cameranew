package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.k.c;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
import d.f.a.b.d;
import us.pinguo.foundation.t.b.a;
import us.pinguo.foundation.utils.f0;
/* loaded from: classes9.dex */
public class RoundFrameImageView extends AppCompatImageView {
    private int mCornerRadius;
    private Bitmap mFrameBitmap;
    private String mFramePath;
    private int mFrameWidth;
    private int mPadding;
    private Paint mPaint;
    private RectF mRectF;
    private Bitmap mThirdIconBitmap;
    private String mThirdIconUri;

    public RoundFrameImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPadding = a.a(getContext(), 9.0f);
        this.mFrameWidth = a.a(getContext(), 1.5f);
        this.mCornerRadius = a.a(getContext(), 4.0f);
        this.mPaint = new Paint(1);
    }

    public void copyFrom(RoundFrameImageView roundFrameImageView) {
        this.mThirdIconUri = roundFrameImageView.mThirdIconUri;
        this.mThirdIconBitmap = roundFrameImageView.mThirdIconBitmap;
    }

    public void loadFrame(String str) {
        if (f0.b(str, this.mFramePath)) {
            return;
        }
        this.mFramePath = str;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 320;
        options.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.mFramePath);
            this.mFrameBitmap = decodeFile;
            setImageBitmap(decodeFile);
        } catch (Exception e2) {
            d.c(e2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mThirdIconBitmap != null) {
            if (this.mPaint == null) {
                init();
                this.mRectF = new RectF();
            }
            RectF rectF = this.mRectF;
            int i2 = this.mPadding;
            rectF.set(i2, i2, getWidth() - this.mPadding, getHeight() - this.mPadding);
            Paint paint = this.mPaint;
            Bitmap bitmap = this.mThirdIconBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            RectF rectF2 = this.mRectF;
            int i3 = this.mCornerRadius;
            canvas.drawRoundRect(rectF2, i3, i3, this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void setThirdIconUri(String str) {
        if (f0.b(this.mThirdIconUri, str)) {
            return;
        }
        this.mThirdIconUri = str;
        if (str != null && str.startsWith(ParamItem.DRAWABLE_PREFIX)) {
            try {
                this.mThirdIconBitmap = BitmapFactory.decodeResource(getResources(), Integer.parseInt(this.mThirdIconUri.substring(11)));
                invalidate();
                return;
            } catch (Exception unused) {
            }
        }
        ImageLoader.getInstance().t(this.mThirdIconUri, new c() { // from class: us.pinguo.inspire.module.feeds.view.RoundFrameImageView.1
            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                RoundFrameImageView.this.mThirdIconBitmap = bitmap;
                RoundFrameImageView.this.invalidate();
            }
        });
    }

    public RoundFrameImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
