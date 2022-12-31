package us.pinguo.inspire.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class GravityImageView extends AppCompatImageView {
    public static final int BOTTOM = 1;
    public static final int CENTER = 18;
    public static final int CENTER_HORIZONTAL = 16;
    public static final int CENTER_VERTICAL = 2;
    public static final int CROP = 3;
    public static final int END = 128;
    public static final int INSIDE = 2;
    public static final int LEFT = 8;
    public static final int NONE = 1;
    public static final int RIGHT = 32;
    public static final int START = 64;
    public static final int TOP = 4;
    private int imageGravity;
    private final RectF imageRect;
    private int imageScaleMode;
    private final boolean isRtl;
    private final Matrix matrix;

    public GravityImageView(Context context) {
        this(context, null);
    }

    private void applyCenterAndScaleMode(float f2, float f3) {
        float max;
        float f4 = f2 / 2.0f;
        float f5 = f3 / 2.0f;
        this.matrix.postTranslate(f4 - (this.imageRect.width() / 2.0f), f5 - (this.imageRect.height() / 2.0f));
        if (this.imageScaleMode == 1) {
            return;
        }
        float width = f2 / this.imageRect.width();
        float height = f3 / this.imageRect.height();
        if (this.imageScaleMode == 2) {
            max = Math.min(width, height);
        } else {
            max = Math.max(width, height);
        }
        this.matrix.postScale(max, max, f4, f5);
    }

    private void applyGravity(float f2, float f3) {
        boolean z;
        RectF rectF = this.imageRect;
        rectF.set(rectF);
        this.matrix.mapRect(this.imageRect);
        float width = (f2 / 2.0f) - (this.imageRect.width() / 2.0f);
        float height = (f3 / 2.0f) - (this.imageRect.height() / 2.0f);
        int i2 = this.imageGravity;
        if ((i2 & 8) != 0 || ((z = this.isRtl) && (i2 & 128) != 0)) {
            this.matrix.postTranslate(-width, 0.0f);
        } else if ((i2 & 32) != 0 || (z && (i2 & 64) != 0)) {
            this.matrix.postTranslate(width, 0.0f);
        }
        int i3 = this.imageGravity;
        if ((i3 & 4) != 0) {
            this.matrix.postTranslate(0.0f, -height);
        } else if ((i3 & 1) != 0) {
            this.matrix.postTranslate(0.0f, height);
        }
    }

    private void updateMatrix(int i2, int i3) {
        Drawable drawable;
        Matrix matrix;
        if (getDrawable() == null || (matrix = this.matrix) == null) {
            return;
        }
        matrix.reset();
        this.imageRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        float f2 = i2;
        float f3 = i3;
        applyCenterAndScaleMode(f2, f3);
        applyGravity(f2, f3);
        setImageMatrix(this.matrix);
    }

    public int getImageGravity() {
        return this.imageGravity;
    }

    public int getImageScaleMode() {
        return this.imageScaleMode;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        updateMatrix(i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        updateMatrix(getWidth(), getHeight());
    }

    public void setImageGravity(int i2) {
        this.imageGravity = i2;
        updateMatrix(getWidth(), getHeight());
    }

    public void setImageScaleMode(int i2) {
        this.imageScaleMode = i2;
        updateMatrix(getWidth(), getHeight());
    }

    public GravityImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gravityImageViewStyle);
    }

    public GravityImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.matrix = new Matrix();
        this.imageRect = new RectF();
        setScaleType(ImageView.ScaleType.MATRIX);
        this.isRtl = ViewCompat.getLayoutDirection(this) == 1;
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us.pinguo.inspire.R.styleable.GravityImageView, i2, 0);
        this.imageScaleMode = obtainStyledAttributes.getInt(2, 1);
        this.imageGravity = obtainStyledAttributes.getInt(1, 18);
        obtainStyledAttributes.recycle();
    }
}
