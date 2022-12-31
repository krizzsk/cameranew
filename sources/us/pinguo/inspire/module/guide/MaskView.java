package us.pinguo.inspire.module.guide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes9.dex */
public class MaskView extends ViewGroup {
    private String flag;
    private final RectF mChildTmpRect;
    private int mCorner;
    private boolean mCustomFullingRect;
    private Paint mEraser;
    private Bitmap mEraserBitmap;
    private Canvas mEraserCanvas;
    private final Paint mFullingPaint;
    private final RectF mFullingRect;
    private int mPadding;
    private Paint mPaint;
    private int mStyle;
    private final RectF mTargetRect;
    private boolean overlayTarget;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private Paint transparentPaint;

    public MaskView(Context context, String str) {
        this(context, null, 0);
        this.flag = str;
    }

    private void horizontalChildPositionLayout(View view, RectF rectF, int i2) {
        if (i2 == 16) {
            float f2 = this.mTargetRect.left;
            rectF.left = f2;
            rectF.right = f2 + view.getMeasuredWidth();
        } else if (i2 == 32) {
            rectF.left = (this.mTargetRect.width() - view.getMeasuredWidth()) / 2.0f;
            rectF.right = (this.mTargetRect.width() + view.getMeasuredWidth()) / 2.0f;
            rectF.offset(this.mTargetRect.left, 0.0f);
        } else if (i2 != 48) {
        } else {
            float f3 = this.mTargetRect.right;
            rectF.right = f3;
            rectF.left = f3 - view.getMeasuredWidth();
        }
    }

    private void resetOutPath() {
        int i2 = this.mPadding;
        if (i2 != 0 && this.paddingLeft == 0) {
            this.mTargetRect.left -= i2;
        }
        if (i2 != 0 && this.paddingTop == 0) {
            this.mTargetRect.top -= i2;
        }
        if (i2 != 0 && this.paddingRight == 0) {
            this.mTargetRect.right += i2;
        }
        if (i2 != 0 && this.paddingBottom == 0) {
            this.mTargetRect.bottom += i2;
        }
        int i3 = this.paddingLeft;
        if (i3 != 0) {
            this.mTargetRect.left -= i3;
        }
        int i4 = this.paddingTop;
        if (i4 != 0) {
            this.mTargetRect.top -= i4;
        }
        int i5 = this.paddingRight;
        if (i5 != 0) {
            this.mTargetRect.right += i5;
        }
        int i6 = this.paddingBottom;
        if (i6 != 0) {
            this.mTargetRect.bottom += i6;
        }
    }

    private void verticalChildPositionLayout(View view, RectF rectF, int i2) {
        if (i2 == 16) {
            float f2 = this.mTargetRect.top;
            rectF.top = f2;
            rectF.bottom = f2 + view.getMeasuredHeight();
        } else if (i2 == 32) {
            rectF.top = (this.mTargetRect.width() - view.getMeasuredHeight()) / 2.0f;
            rectF.bottom = (this.mTargetRect.width() + view.getMeasuredHeight()) / 2.0f;
            rectF.offset(0.0f, this.mTargetRect.top);
        } else if (i2 != 48) {
        } else {
            RectF rectF2 = this.mTargetRect;
            rectF.bottom = rectF2.bottom;
            rectF.top = rectF2.bottom - view.getMeasuredHeight();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            try {
                drawChild(canvas, getChildAt(i2), drawingTime);
            } catch (NullPointerException unused) {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            clearFocus();
            this.mEraserCanvas.setBitmap(null);
            this.mEraserBitmap = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mEraserBitmap.eraseColor(0);
        this.mEraserCanvas.drawColor(this.mFullingPaint.getColor());
        if (this.overlayTarget) {
            return;
        }
        if (!"feed".equals(this.flag) && !"profile".equals(this.flag) && !"publish".equals(this.flag)) {
            int i2 = this.mStyle;
            if (i2 == 0) {
                Canvas canvas2 = this.mEraserCanvas;
                RectF rectF = this.mTargetRect;
                int i3 = this.mCorner;
                canvas2.drawRoundRect(rectF, i3, i3, this.mEraser);
            } else if (i2 != 1) {
                Canvas canvas3 = this.mEraserCanvas;
                RectF rectF2 = this.mTargetRect;
                int i4 = this.mCorner;
                canvas3.drawRoundRect(rectF2, i4, i4, this.mEraser);
            } else {
                this.mEraserCanvas.drawCircle(this.mTargetRect.centerX(), this.mTargetRect.centerY(), this.mTargetRect.width() / 2.0f, this.mEraser);
            }
        }
        canvas.drawBitmap(this.mEraserBitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams;
        int childCount = getChildCount();
        float f2 = getResources().getDisplayMetrics().density;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                int i7 = layoutParams.targetAnchor;
                if (i7 == 1) {
                    RectF rectF = this.mChildTmpRect;
                    float f3 = this.mTargetRect.left;
                    rectF.right = f3;
                    rectF.left = f3 - childAt.getMeasuredWidth();
                    verticalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                } else if (i7 == 2) {
                    RectF rectF2 = this.mChildTmpRect;
                    float f4 = this.mTargetRect.top;
                    rectF2.bottom = f4;
                    rectF2.top = f4 - childAt.getMeasuredHeight();
                    horizontalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                } else if (i7 == 3) {
                    RectF rectF3 = this.mChildTmpRect;
                    float f5 = this.mTargetRect.right;
                    rectF3.left = f5;
                    rectF3.right = f5 + childAt.getMeasuredWidth();
                    verticalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                } else if (i7 == 4) {
                    RectF rectF4 = this.mChildTmpRect;
                    float f6 = this.mTargetRect.bottom;
                    rectF4.top = f6;
                    rectF4.bottom = f6 + childAt.getMeasuredHeight();
                    horizontalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                } else if (i7 == 5) {
                    this.mChildTmpRect.left = (((int) this.mTargetRect.width()) - childAt.getMeasuredWidth()) >> 1;
                    this.mChildTmpRect.top = (((int) this.mTargetRect.height()) - childAt.getMeasuredHeight()) >> 1;
                    this.mChildTmpRect.right = (((int) this.mTargetRect.width()) + childAt.getMeasuredWidth()) >> 1;
                    this.mChildTmpRect.bottom = (((int) this.mTargetRect.height()) + childAt.getMeasuredHeight()) >> 1;
                    RectF rectF5 = this.mChildTmpRect;
                    RectF rectF6 = this.mTargetRect;
                    rectF5.offset(rectF6.left, rectF6.top);
                }
                this.mChildTmpRect.offset((int) ((layoutParams.offsetX * f2) + 0.5f), (int) ((layoutParams.offsetY * f2) + 0.5f));
                RectF rectF7 = this.mChildTmpRect;
                childAt.layout((int) rectF7.left, (int) rectF7.top, (int) rectF7.right, (int) rectF7.bottom);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        if (!this.mCustomFullingRect) {
            this.mFullingRect.set(0.0f, 0.0f, size, size2);
            resetOutPath();
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    childAt.setLayoutParams(layoutParams);
                }
                measureChild(childAt, size - 2147483648, Integer.MIN_VALUE + size2);
            }
        }
    }

    public void setFullingAlpha(int i2) {
        this.mFullingPaint.setAlpha(i2);
        invalidate();
    }

    public void setFullingColor(int i2) {
        this.mFullingPaint.setColor(i2);
        invalidate();
    }

    public void setFullingRect(Rect rect) {
        this.mFullingRect.set(rect);
        resetOutPath();
        this.mCustomFullingRect = true;
        invalidate();
    }

    public void setHighTargetCorner(int i2) {
        this.mCorner = i2;
    }

    public void setHighTargetGraphStyle(int i2) {
        this.mStyle = i2;
    }

    public void setOverlayTarget(boolean z) {
        this.overlayTarget = z;
    }

    public void setPadding(int i2) {
        this.mPadding = i2;
    }

    public void setPaddingBottom(int i2) {
        this.paddingBottom = i2;
    }

    public void setPaddingLeft(int i2) {
        this.paddingLeft = i2;
    }

    public void setPaddingRight(int i2) {
        this.paddingRight = i2;
    }

    public void setPaddingTop(int i2) {
        this.paddingTop = i2;
    }

    public void setTargetRect(Rect rect) {
        this.mTargetRect.set(rect);
        resetOutPath();
        invalidate();
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTargetRect = new RectF();
        this.mFullingRect = new RectF();
        this.mChildTmpRect = new RectF();
        this.mFullingPaint = new Paint();
        this.mPadding = 0;
        this.paddingLeft = 0;
        this.paddingTop = 0;
        this.paddingRight = 0;
        this.paddingBottom = 0;
        this.mCorner = 0;
        this.mStyle = 0;
        setWillNotDraw(false);
        Point point = new Point();
        point.x = getResources().getDisplayMetrics().widthPixels;
        int i3 = getResources().getDisplayMetrics().heightPixels;
        point.y = i3;
        this.mEraserBitmap = Bitmap.createBitmap(point.x, i3, Bitmap.Config.ARGB_8888);
        this.mEraserCanvas = new Canvas(this.mEraserBitmap);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1879048192);
        Paint paint2 = new Paint();
        this.transparentPaint = paint2;
        paint2.setColor(getResources().getColor(17170445));
        this.transparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint3 = new Paint();
        this.mEraser = paint3;
        paint3.setColor(-1);
        this.mEraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mEraser.setFlags(1);
    }

    /* loaded from: classes9.dex */
    static class LayoutParams extends ViewGroup.LayoutParams {
        public static final int ANCHOR_BOTTOM = 4;
        public static final int ANCHOR_LEFT = 1;
        public static final int ANCHOR_OVER = 5;
        public static final int ANCHOR_RIGHT = 3;
        public static final int ANCHOR_TOP = 2;
        public static final int PARENT_CENTER = 32;
        public static final int PARENT_END = 48;
        public static final int PARENT_START = 16;
        public int offsetX;
        public int offsetY;
        public int targetAnchor;
        public int targetParentPosition;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.targetAnchor = 4;
            this.targetParentPosition = 32;
            this.offsetX = 0;
            this.offsetY = 0;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.targetAnchor = 4;
            this.targetParentPosition = 32;
            this.offsetX = 0;
            this.offsetY = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.targetAnchor = 4;
            this.targetParentPosition = 32;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }
}
