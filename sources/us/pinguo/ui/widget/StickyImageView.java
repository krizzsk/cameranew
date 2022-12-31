package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes6.dex */
public class StickyImageView extends PhotoImageView {
    private int mCoverColor;
    private RectF mDstRect;
    private Rect mSrcRect;

    /* loaded from: classes6.dex */
    public static class a implements com.nostra13.universalimageloader.core.l.a {
        @Override // com.nostra13.universalimageloader.core.l.a
        public Bitmap a(Bitmap bitmap) {
            if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                return null;
            }
            float width = bitmap.getWidth() < bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
            return us.pinguo.foundation.t.b.b.e(bitmap, us.pinguo.foundation.t.b.b.b(null, bitmap.getWidth(), bitmap.getHeight(), width, width));
        }
    }

    public StickyImageView(Context context) {
        super(context);
        this.mDstRect = new RectF();
        this.mSrcRect = new Rect();
    }

    public int getCoverColor() {
        return this.mCoverColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        c.b bVar = new c.b();
        bVar.v(true);
        bVar.u(true);
        bVar.C(new a());
        this.mDisplayImageOptions = bVar.t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            if (bitmap != null) {
                float height = getHeight() / getWidth();
                if (height > 1.0f) {
                    height = 1.0f;
                }
                float f2 = (1.0f - height) / 2.0f;
                int width = bitmap.getWidth();
                this.mDstRect.set(0.0f, 0.0f, getWidth(), getHeight());
                float f3 = width;
                this.mSrcRect.set(0, (int) (f2 * f3), width, (int) (f3 * (1.0f - f2)));
                canvas.drawBitmap(bitmap, this.mSrcRect, this.mDstRect, (Paint) null);
            }
        } else {
            super.onDraw(canvas);
        }
        canvas.drawColor(this.mCoverColor);
    }

    public void setCoverColor(int i2) {
        this.mCoverColor = i2;
        invalidate();
    }

    public StickyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDstRect = new RectF();
        this.mSrcRect = new Rect();
    }

    public StickyImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDstRect = new RectF();
        this.mSrcRect = new Rect();
    }
}
