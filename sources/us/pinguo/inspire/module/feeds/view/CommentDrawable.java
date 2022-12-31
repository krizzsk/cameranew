package us.pinguo.inspire.module.feeds.view;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import d.f.a.b.d;
import us.pinguo.foundation.t.a.a;
import us.pinguo.inspire.module.feeds.view.FeedsPhotoCommentView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeedsPhotoCommentView.java */
/* loaded from: classes9.dex */
public class CommentDrawable extends Drawable {
    private int mAlpha;
    private int mBgColor;
    private Paint.FontMetrics mFontMetrics;
    private int mPaddingLR;
    private int mPaddingTB;
    protected final TextPaint mPaint;
    private int mRadius;
    private FeedsPhotoCommentView.CommentSeg[] mSegs;
    private float mTextLen;
    private int mTransY;
    private int mWidth;
    private RectF mRect = new RectF();
    private RectF mTransRect = new RectF();

    /* compiled from: FeedsPhotoCommentView.java */
    /* loaded from: classes9.dex */
    protected class CommentDrawableDisplayer extends a {
        public CommentDrawableDisplayer(CommentDrawable commentDrawable) {
            this(0, false, false, false);
        }

        private void animate(int i2) {
            if (CommentDrawable.this.isVisible()) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.feeds.view.CommentDrawable.CommentDrawableDisplayer.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        CommentDrawable.this.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                ofInt.setDuration(i2);
                ofInt.setInterpolator(new DecelerateInterpolator());
                ofInt.start();
            }
        }

        @Override // us.pinguo.foundation.t.a.a, com.nostra13.universalimageloader.core.i.a
        public void display(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
            if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
                animate(this.durationMillis);
            }
        }

        public CommentDrawableDisplayer(int i2, boolean z, boolean z2, boolean z3) {
            super(i2, z, z2, z3);
        }
    }

    public CommentDrawable(Resources resources) {
        TextPaint textPaint = new TextPaint();
        this.mPaint = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(us.pinguo.foundation.t.b.a.p(resources, 12.0f));
        textPaint.setStyle(Paint.Style.FILL);
        this.mRadius = us.pinguo.foundation.t.b.a.b(resources, 2.0f);
        this.mPaddingLR = us.pinguo.foundation.t.b.a.b(resources, 8.0f);
        this.mPaddingTB = us.pinguo.foundation.t.b.a.b(resources, 2.0f);
        this.mBgColor = 2130706432;
        this.mFontMetrics = textPaint.getFontMetrics();
    }

    private void measure(Rect rect) {
        int width = rect.width() - (this.mPaddingLR * 2);
        this.mTextLen = 0.0f;
        FeedsPhotoCommentView.CommentSeg[] commentSegArr = this.mSegs;
        if (commentSegArr != null && commentSegArr.length > 0) {
            int length = commentSegArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                FeedsPhotoCommentView.CommentSeg commentSeg = commentSegArr[i2];
                float measureText = TextUtils.isEmpty(commentSeg.text) ? 0.0f : this.mPaint.measureText(commentSeg.text);
                commentSeg.width = measureText;
                float f2 = this.mTextLen + measureText;
                this.mTextLen = f2;
                float f3 = width;
                if (f2 > f3) {
                    commentSeg.shortText = TextUtils.isEmpty(commentSeg.text) ? "" : TextUtils.ellipsize(commentSeg.text, this.mPaint, f3 - (f2 - measureText), TextUtils.TruncateAt.END);
                    commentSeg.shortWidth = this.mPaint.measureText(((Object) commentSeg.shortText) + "");
                    this.mTextLen = (this.mTextLen + this.mPaint.measureText(String.valueOf(commentSeg.shortText))) - commentSeg.width;
                } else {
                    i2++;
                }
            }
        }
        if (FeedsPhotoCommentView.mLTR) {
            RectF rectF = this.mRect;
            int i3 = rect.left;
            rectF.set(i3, rect.top, this.mTextLen + i3 + (this.mPaddingLR * 2), rect.bottom);
            return;
        }
        RectF rectF2 = this.mRect;
        int i4 = rect.right;
        rectF2.set((i4 - this.mTextLen) - (this.mPaddingLR * 2), rect.top, i4, rect.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f2;
        d.d("draw,alpha:" + this.mAlpha, new Object[0]);
        this.mTransRect.set(this.mRect);
        this.mTransRect.offset(0.0f, (float) this.mTransY);
        float f3 = ((float) this.mAlpha) / 255.0f;
        this.mPaint.setColor(Color.argb((int) (Color.alpha(this.mBgColor) * f3), Color.red(this.mBgColor), Color.green(this.mBgColor), Color.blue(this.mBgColor)));
        RectF rectF = this.mTransRect;
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mPaint);
        FeedsPhotoCommentView.CommentSeg[] commentSegArr = this.mSegs;
        if (commentSegArr == null || commentSegArr.length == 0) {
            return;
        }
        RectF rectF2 = this.mTransRect;
        float f4 = rectF2.left + this.mPaddingLR;
        float f5 = (rectF2.bottom - this.mFontMetrics.descent) - this.mPaddingTB;
        boolean z = FeedsPhotoCommentView.mLTR;
        int length = z ? 0 : commentSegArr.length - 1;
        while (true) {
            if (z) {
                if (length >= this.mSegs.length) {
                    return;
                }
            } else if (length < 0) {
                return;
            }
            FeedsPhotoCommentView.CommentSeg commentSeg = this.mSegs[length];
            if (!TextUtils.isEmpty(commentSeg.text)) {
                this.mPaint.setColor(Color.argb((int) (Color.alpha(commentSeg.color) * f3), Color.red(commentSeg.color), Color.green(commentSeg.color), Color.blue(commentSeg.color)));
                if (!TextUtils.isEmpty(commentSeg.shortText)) {
                    canvas.drawText(String.valueOf(commentSeg.shortText), f4, f5, this.mPaint);
                    f2 = commentSeg.shortWidth;
                } else {
                    canvas.drawText(commentSeg.text, f4, f5, this.mPaint);
                    f2 = commentSeg.width;
                }
                f4 += f2;
            }
            length = z ? length + 1 : length - 1;
        }
    }

    public float getBottom() {
        return this.mRect.bottom;
    }

    public int getHeight() {
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        return ((int) (fontMetrics.descent - fontMetrics.ascent)) + (this.mPaddingTB * 2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        measure(getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.mAlpha) {
            this.mAlpha = i2;
            d.d("setAlpha,alpha:" + this.mPaint.getAlpha(), new Object[0]);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mPaint.getColorFilter()) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public void setText(FeedsPhotoCommentView.CommentSeg[] commentSegArr) {
        this.mSegs = commentSegArr;
        measure(getBounds());
    }

    public void setTransY(int i2) {
        if (i2 != this.mTransY) {
            this.mTransY = i2;
        }
    }
}
