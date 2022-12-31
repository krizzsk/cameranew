package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import us.pinguo.foundation.t.b.a;
import us.pinguo.ui.R;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.uilview.c;
/* loaded from: classes9.dex */
public class FeedsFeatureDrawable extends c {
    protected Context mAppContext;
    protected Bitmap mBitmap;
    private int mBottomPadding;
    private int mCenterMargin;
    private int mIconSize;
    private int mLeftPadding;
    protected Paint mPaint;
    private int mPressColor;
    private int mRedPointColor;
    private int mRedPointRadius;
    private int mRightPadding;
    private String mShortText;
    private String mText;
    private int mTextColor;
    protected TextPaint mTextPaint;
    private int mTextSize;
    private float mTextX;
    private float mTextY;
    private int mTopPadding;
    private Rect mBitmapRect = new Rect();
    private Rect mIconRect = new Rect();
    private RectF mIconAreaRect = new RectF();
    private boolean mShowRedPoint = false;

    public FeedsFeatureDrawable(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mIconSize = a.a(applicationContext, 36.0f);
        this.mTextSize = a.o(this.mAppContext, 12);
        this.mTextColor = this.mAppContext.getResources().getColor(R.color.text_primary);
        this.mCenterMargin = a.a(this.mAppContext, 4.0f);
        int a = a.a(this.mAppContext, 8.0f);
        this.mRightPadding = a;
        this.mLeftPadding = a;
        this.mTopPadding = a.a(this.mAppContext, 8.0f);
        this.mBottomPadding = a.a(this.mAppContext, 0.0f);
        this.mRedPointRadius = a.a(this.mAppContext, 3.0f);
        this.mRedPointColor = -1025965;
        this.mPressColor = -3355444;
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mPaint = new Paint();
    }

    protected void calBitmapRect() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.mBitmap == null) {
            return;
        }
        if (this.mBitmapRect.width() < this.mIconAreaRect.width() && this.mBitmapRect.height() < this.mIconAreaRect.height()) {
            RectF rectF = this.mIconAreaRect;
            float width = rectF.left + (rectF.width() / 2.0f);
            RectF rectF2 = this.mIconAreaRect;
            float height = rectF2.top + (rectF2.height() / 2.0f);
            i4 = (int) (width - (this.mBitmapRect.width() / 2));
            i3 = (int) (width + (this.mBitmapRect.width() / 2));
            i5 = (int) (height - (this.mBitmapRect.height() / 2));
            i2 = (int) (height + (this.mBitmapRect.height() / 2));
        } else if (this.mBitmapRect.width() > this.mBitmapRect.height()) {
            RectF rectF3 = this.mIconAreaRect;
            int i6 = (int) rectF3.right;
            float height2 = rectF3.top + (rectF3.height() / 2.0f);
            float width2 = (this.mIconAreaRect.width() * (this.mBitmapRect.height() / this.mBitmapRect.width())) / 2.0f;
            i5 = (int) (height2 - width2);
            i2 = (int) (height2 + width2);
            i4 = (int) rectF3.left;
            i3 = i6;
        } else {
            RectF rectF4 = this.mIconAreaRect;
            int i7 = (int) rectF4.top;
            i2 = (int) rectF4.bottom;
            float width3 = rectF4.left + (rectF4.width() / 2.0f);
            float height3 = (this.mIconAreaRect.height() * (this.mBitmapRect.width() / this.mBitmapRect.height())) / 2.0f;
            i3 = (int) (width3 + height3);
            i4 = (int) (width3 - height3);
            i5 = i7;
        }
        this.mIconRect.set(i4, i5, i3, i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (isPressed()) {
            this.mTextPaint.setColor(this.mPressColor);
            canvas.drawRect(getBounds(), this.mTextPaint);
            this.mTextPaint.setColor(this.mTextColor);
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.mBitmapRect, this.mIconRect, this.mPaint);
        }
        String str = this.mShortText;
        if (str == null) {
            str = this.mText;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        canvas.drawText(str, this.mTextX, this.mTextY, this.mTextPaint);
    }

    @Override // us.pinguo.ui.uilview.c
    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.mBitmap;
        return (bitmap == null || bitmap.hasAlpha()) ? -3 : -1;
    }

    protected boolean isPressed() {
        int[] state = getState();
        if (state != null && state.length != 0) {
            for (int i2 : state) {
                if (i2 == 16842919) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        rect.width();
        rect.height();
        int i2 = rect.left + this.mLeftPadding;
        int i3 = rect.right - this.mRightPadding;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        int i4 = (int) (fontMetrics.descent - fontMetrics.ascent);
        if (!TextUtils.isEmpty(this.mText)) {
            float measureText = this.mTextPaint.measureText(this.mText);
            float f2 = i3 - i2;
            if (measureText <= f2) {
                this.mShortText = this.mText;
            } else {
                this.mShortText = ((Object) TextUtils.ellipsize(this.mText, this.mTextPaint, measureText, TextUtils.TruncateAt.END)) + "";
                measureText = f2;
            }
            this.mTextX = (rect.left + (rect.width() / 2)) - (measureText / 2.0f);
            this.mTextY = (rect.bottom - this.mBottomPadding) - i4;
        }
        float f3 = rect.top + this.mTopPadding;
        float f4 = i2;
        float f5 = i3;
        float f6 = ((rect.bottom - this.mBottomPadding) - i4) - this.mCenterMargin;
        float f7 = f5 - f4;
        int i5 = this.mIconSize;
        if (f7 > i5) {
            float f8 = f4 + (f7 / 2.0f);
            f5 = f8 + (i5 / 2);
            f4 = f8 - (i5 / 2);
        }
        float f9 = f6 - f3;
        if (f9 > i5) {
            float f10 = f3 + (f9 / 2.0f);
            float f11 = (i5 / 2) + f10;
            f3 = f10 - (i5 / 2);
            f6 = f11;
        }
        this.mIconAreaRect.set(f4, f3, f5, f6);
        calBitmapRect();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.mTextPaint.setAlpha(i2);
    }

    @Override // us.pinguo.ui.uilview.c
    public boolean setBitmap(Bitmap bitmap) {
        if (this.mBitmap == bitmap) {
            return false;
        }
        this.mBitmapRect.set(0, 0, bitmap == null ? 0 : bitmap.getWidth(), bitmap == null ? 0 : bitmap.getHeight());
        this.mBitmap = bitmap;
        calBitmapRect();
        invalidateSelf();
        return true;
    }

    public void setBottomPadding(int i2) {
        this.mBottomPadding = i2;
    }

    public void setBoundsForceChange(int i2, int i3, int i4, int i5) {
        if (getBounds().equals(new Rect(i2, i3, i4, i5))) {
            setBounds(i2, i3, i4, i5);
            onBoundsChange(getBounds());
            return;
        }
        setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mTextPaint.setColorFilter(colorFilter);
    }

    @Override // us.pinguo.ui.uilview.c
    public void setImageUri(String str) {
        super.setImageUri(PhotoImageView.addQiNiuSuffix(str, this.mWidth, this.mHeight, false));
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 = this.mLeftPadding;
        }
        this.mLeftPadding = i2;
        if (i3 < 0) {
            i3 = this.mTopPadding;
        }
        this.mTopPadding = i3;
        if (i4 < 0) {
            i4 = this.mRightPadding;
        }
        this.mRightPadding = i4;
        if (i5 < 0) {
            i5 = this.mBottomPadding;
        }
        this.mBottomPadding = i5;
    }

    public void setShowRedPoint(boolean z) {
        this.mShowRedPoint = z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTopPadding(int i2) {
        this.mTopPadding = i2;
    }
}
