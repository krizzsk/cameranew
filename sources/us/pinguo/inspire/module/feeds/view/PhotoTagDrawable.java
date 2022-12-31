package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.Inspire;
import us.pinguo.ui.uilview.b;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PhotoTagDrawable extends b {
    private int mBgColor;
    private RectF mBgRect;
    private float mDescent;
    private float mLen;
    private int mMargin;
    private int mMinWidth;
    private int mPadding;
    private Paint mPaint;
    private int mRadius;
    private boolean mShowTag;
    private String mTagTxt;
    private int mTextColor;
    private float mTextHeight;
    private int mTextSize;

    public PhotoTagDrawable(Bitmap bitmap, int i2, int i3) {
        super(bitmap, i2, i3);
        this.mLen = -1.0f;
        this.mBgRect = new RectF();
    }

    @Override // us.pinguo.ui.uilview.b, us.pinguo.foundation.t.a.b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.mShowTag || TextUtils.isEmpty(this.mTagTxt)) {
            return;
        }
        if (this.mLen < 0.0f) {
            this.mLen = this.mPaint.measureText(this.mTagTxt);
        }
        Rect bounds = getBounds();
        int i2 = bounds.right;
        int i3 = this.mMargin;
        float f2 = i2 - i3;
        int i4 = this.mPadding;
        float f3 = (f2 - (i4 * 2)) - this.mLen;
        int i5 = this.mMinWidth;
        if (f2 - f3 < i5) {
            f3 = f2 - i5;
        }
        float f4 = bounds.top + i3;
        float f5 = this.mTextHeight + f4 + (i4 * 2);
        this.mBgRect.set(f3, f4, f2, f5);
        this.mPaint.setColor(this.mBgColor);
        RectF rectF = this.mBgRect;
        int i6 = this.mRadius;
        canvas.drawRoundRect(rectF, i6, i6, this.mPaint);
        this.mPaint.setColor(this.mTextColor);
        canvas.drawText(this.mTagTxt, (f3 + ((f2 - f3) / 2.0f)) - (this.mLen / 2.0f), (f5 - this.mDescent) - this.mPadding, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.b, us.pinguo.ui.uilview.d
    public void init() {
        super.init();
        Context a = Inspire.a();
        if (a == null) {
            return;
        }
        this.mTagTxt = a.getString(R.string.feeds_long_pic);
        this.mTextColor = a.getResources().getColor(us.pinguo.ui.R.color.text_white);
        this.mBgColor = 1711276032;
        this.mRadius = a.a(a, 2.0f);
        this.mTextSize = a.o(a, 10);
        this.mMargin = a.a(a, 10.0f);
        this.mPadding = a.a(a, 5.0f);
        this.mMinWidth = a.a(a, 30.0f);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        this.mTextHeight = Math.abs(fontMetrics.descent) + Math.abs(fontMetrics.ascent);
        this.mDescent = Math.abs(fontMetrics.descent);
    }

    public void setShowTag(boolean z) {
        this.mShowTag = z;
    }

    public void setTagText(String str) {
        if (str == null) {
            str = "";
        }
        this.mTagTxt = str;
        this.mLen = this.mPaint.measureText(str);
    }
}
