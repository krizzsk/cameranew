package com.pinguo.camera360.sticker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import us.pinguo.ui.R;
/* loaded from: classes3.dex */
public class CircleSelectorImageView extends AppCompatImageView {
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_FILL_COLOR = 0;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private ColorFilter mColorFilter;
    private boolean mDisableCircularTransformation;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private int mFillColor;
    private final Paint mFillPaint;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    public CircleSelectorImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        init();
    }

    private void applyColorFilter() {
        Paint paint = this.mBitmapPaint;
        if (paint != null) {
            paint.setColorFilter(this.mColorFilter);
        }
    }

    private RectF calculateBounds() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f2 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    private void initializeBitmap() {
        if (this.mDisableCircularTransformation) {
            this.mBitmap = null;
        } else {
            this.mBitmap = getBitmapFromDrawable(getDrawable());
        }
        setup();
    }

    private void setup() {
        int i2;
        if (!this.mReady) {
            this.mSetupPending = true;
        } else if (getWidth() == 0 && getHeight() == 0) {
        } else {
            if (this.mBitmap == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mFillPaint.setStyle(Paint.Style.FILL);
            this.mFillPaint.setAntiAlias(true);
            this.mFillPaint.setColor(this.mFillColor);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBorderRect.set(calculateBounds());
            this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
            this.mDrawableRect.set(this.mBorderRect);
            if (!this.mBorderOverlay && (i2 = this.mBorderWidth) > 0) {
                this.mDrawableRect.inset(i2 - 1.0f, i2 - 1.0f);
            }
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
            applyColorFilter();
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        this.mShaderMatrix.set(null);
        float f2 = 0.0f;
        if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
            width = this.mDrawableRect.height() / this.mBitmapHeight;
            f2 = (this.mDrawableRect.width() - (this.mBitmapWidth * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.mDrawableRect.width() / this.mBitmapWidth;
            height = (this.mDrawableRect.height() - (this.mBitmapHeight * width)) * 0.5f;
        }
        this.mShaderMatrix.setScale(width, width);
        Matrix matrix = this.mShaderMatrix;
        RectF rectF = this.mDrawableRect;
        matrix.postTranslate(((int) (f2 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Deprecated
    public int getFillColor() {
        return this.mFillColor;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public boolean isBorderOverlay() {
        return this.mBorderOverlay;
    }

    public boolean isDisableCircularTransformation() {
        return this.mDisableCircularTransformation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDisableCircularTransformation) {
            super.onDraw(canvas);
        } else if (this.mBitmap == null) {
        } else {
            if (this.mFillColor != 0) {
                canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mFillPaint);
            }
            canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
            if (this.mBorderWidth > 0) {
                canvas.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        setup();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        if (i2 == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i2;
        this.mBorderPaint.setColor(i2);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(@ColorRes int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.mBorderOverlay) {
            return;
        }
        this.mBorderOverlay = z;
        setup();
    }

    public void setBorderWidth(int i2) {
        if (i2 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i2;
        setup();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.mColorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        applyColorFilter();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.mDisableCircularTransformation == z) {
            return;
        }
        this.mDisableCircularTransformation = z;
        initializeBitmap();
    }

    @Deprecated
    public void setFillColor(@ColorInt int i2) {
        if (i2 == this.mFillColor) {
            return;
        }
        this.mFillColor = i2;
        this.mFillPaint.setColor(i2);
        invalidate();
    }

    @Deprecated
    public void setFillColorResource(@ColorRes int i2) {
        setFillColor(getContext().getResources().getColor(i2));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        super.setImageResource(i2);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initializeBitmap();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        setup();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        setup();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleSelectorImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSelectorImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleSelectorImageView, i2, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(0, -16777216);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(1, false);
        this.mFillColor = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        init();
    }
}
