package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* loaded from: classes6.dex */
public class RotateImageView extends TwoStateImageView implements us.pinguo.foundation.ui.d {
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12181d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12182e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12183f;

    /* renamed from: g  reason: collision with root package name */
    private long f12184g;

    /* renamed from: h  reason: collision with root package name */
    private long f12185h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f12186i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable[] f12187j;

    /* renamed from: k  reason: collision with root package name */
    private TransitionDrawable f12188k;

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
        this.f12181d = 0;
        this.f12182e = false;
        this.f12183f = true;
        this.f12184g = 0L;
        this.f12185h = 0L;
    }

    public int a() {
        return this.f12181d;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        if (this.b != this.f12181d) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f12185h) {
                int i4 = (int) (currentAnimationTimeMillis - this.f12184g);
                int i5 = this.c;
                if (!this.f12182e) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * BaseBlurEffect.ROTATION_270) / 1000);
                this.b = i6 >= 0 ? i6 % BaseBlurEffect.ROTATION_360 : (i6 % BaseBlurEffect.ROTATION_360) + BaseBlurEffect.ROTATION_360;
                invalidate();
            } else {
                this.b = this.f12181d;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        boolean z = width < i2 || height < i3 || width > i2 || height > i3;
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER && z) {
            float f2 = width;
            float f3 = height;
            float min = Math.min(f2 / i2, f3 / i3);
            canvas.scale(min, min, f2 / 2.0f, f3 / 2.0f);
        }
        canvas.translate(paddingLeft + (width / 2.0f), paddingTop + (height / 2.0f));
        canvas.rotate(-this.b);
        canvas.translate((-i2) / 2.0f, (-i3) / 2.0f);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            this.f12186i = null;
            this.f12187j = null;
            setImageDrawable(null);
            setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.f12186i = ThumbnailUtils.extractThumbnail(bitmap, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom());
        Drawable[] drawableArr = this.f12187j;
        if (drawableArr != null && this.f12183f) {
            drawableArr[0] = drawableArr[1];
            drawableArr[1] = new BitmapDrawable(getContext().getResources(), this.f12186i);
            TransitionDrawable transitionDrawable = new TransitionDrawable(this.f12187j);
            this.f12188k = transitionDrawable;
            setImageDrawable(transitionDrawable);
            this.f12188k.startTransition(500);
        } else {
            Drawable[] drawableArr2 = new Drawable[2];
            this.f12187j = drawableArr2;
            drawableArr2[1] = new BitmapDrawable(getContext().getResources(), this.f12186i);
            setImageDrawable(this.f12187j[1]);
        }
        setVisibility(0);
    }

    public void setDegree(int i2) {
        setOrientation(i2 % BaseBlurEffect.ROTATION_360, false);
    }

    @Override // us.pinguo.foundation.ui.d
    public void setOrientation(int i2, boolean z) {
        this.f12183f = z;
        int i3 = i2 >= 0 ? i2 % BaseBlurEffect.ROTATION_360 : (i2 % BaseBlurEffect.ROTATION_360) + BaseBlurEffect.ROTATION_360;
        if (i3 == this.f12181d) {
            return;
        }
        this.f12181d = i3;
        if (z) {
            this.c = this.b;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f12184g = currentAnimationTimeMillis;
            int i4 = this.f12181d - this.b;
            if (i4 < 0) {
                i4 += BaseBlurEffect.ROTATION_360;
            }
            if (i4 > 180) {
                i4 -= 360;
            }
            this.f12182e = i4 >= 0;
            this.f12185h = currentAnimationTimeMillis + ((Math.abs(i4) * 1000) / BaseBlurEffect.ROTATION_270);
        } else {
            this.b = i3;
        }
        invalidate();
    }

    public RotateImageView(Context context) {
        super(context);
        this.b = 0;
        this.c = 0;
        this.f12181d = 0;
        this.f12182e = false;
        this.f12183f = true;
        this.f12184g = 0L;
        this.f12185h = 0L;
    }
}
