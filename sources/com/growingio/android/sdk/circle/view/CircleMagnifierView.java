package com.growingio.android.sdk.circle.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.WindowManager;
import com.growingio.android.sdk.circle.HybridEventEditDialog;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.FloatWindowManager;
import com.growingio.android.sdk.utils.SoftWareCanvas;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import com.growingio.android.sdk.view.FloatViewContainer;
/* loaded from: classes2.dex */
public class CircleMagnifierView extends View {
    private final float SCALE_FACTOR;
    private int mArrowWidthMax;
    private int mArrowWidthMin;
    private Bitmap mBitmap;
    private float mCurrentX;
    private float mCurrentY;
    private Rect mMaskRect;
    private int mMaxHitWidth;
    private int mRectHeight;
    private int mRectWidth;
    private RelativeLocation mRelativeLocation;

    /* loaded from: classes2.dex */
    enum RelativeLocation {
        TOP,
        LEFT,
        RIGHT
    }

    public CircleMagnifierView(Context context) {
        super(context);
        this.SCALE_FACTOR = 1.17f;
        this.mRelativeLocation = RelativeLocation.TOP;
        init();
    }

    private void mergeViews(View[] viewArr, float f2) {
        if (this.mBitmap == null) {
            this.mBitmap = Bitmap.createBitmap(this.mRectWidth, this.mRectHeight, Bitmap.Config.RGB_565);
        }
        SoftWareCanvas softWareCanvas = new SoftWareCanvas(this.mBitmap);
        softWareCanvas.scale(1.17f, 1.17f);
        softWareCanvas.translate((-this.mCurrentX) + (this.mRectWidth / 2.34f), (-this.mCurrentY) + (this.mRectHeight / 2.34f));
        int[] iArr = new int[2];
        boolean z = ViewHelper.getMainWindowCount(viewArr) > 1;
        WindowHelper.init();
        for (View view : viewArr) {
            if (!(view instanceof FloatViewContainer) && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && ViewHelper.isWindowNeedTraverse(view, WindowHelper.getWindowPrefix(view), z) && !HybridEventEditDialog.DO_NOT_DRAW.equals(view.getTag())) {
                view.getLocationOnScreen(iArr);
                softWareCanvas.save();
                softWareCanvas.translate(iArr[0], iArr[1]);
                view.draw(softWareCanvas);
                softWareCanvas.restore();
            }
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(Util.dp2Px(getContext(), 1.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Constants.GROWINGIO_COLOR_RED);
        softWareCanvas.drawRoundRect(new RectF(this.mMaskRect), f2, f2, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Constants.GROWINGIO_COLOR_LIGHT_RED);
        softWareCanvas.drawRoundRect(new RectF(this.mMaskRect), f2, f2, paint);
        softWareCanvas.destroy();
    }

    @SuppressLint({"RtlHardcoded"})
    public void attachToWindow() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, PendingStatus.FLOAT_VIEW_TYPE, 312, -3);
        layoutParams.gravity = 51;
        layoutParams.setTitle("CircleMagnifierWindow:" + getContext().getPackageName());
        setVisibility(8);
        FloatWindowManager.getInstance().addView(this, layoutParams);
    }

    public void init() {
        this.mMaxHitWidth = Util.dp2Px(getContext(), 80.0f);
        this.mRectWidth = Util.dp2Px(getContext(), 120.0f);
        this.mRectHeight = Util.dp2Px(getContext(), 80.0f);
        this.mArrowWidthMin = Util.dp2Px(getContext(), 16.0f);
        this.mArrowWidthMax = Util.dp2Px(getContext(), 18.0f);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
        if (sortedWindowViews.length <= 0) {
            return;
        }
        float f2 = getResources().getDisplayMetrics().density * 2.0f;
        float f3 = getResources().getDisplayMetrics().density * 5.0f;
        int i2 = this.mRectWidth / 2;
        int i3 = this.mRectHeight / 2;
        int i4 = 0;
        Path path = new Path();
        RelativeLocation relativeLocation = this.mRelativeLocation;
        if (relativeLocation == RelativeLocation.TOP) {
            path.moveTo(i2 - (this.mArrowWidthMax / 2), this.mRectHeight - f2);
            path.lineTo(i2, (this.mRectHeight + this.mArrowWidthMin) - f2);
            path.lineTo(i2 + (this.mArrowWidthMax / 2), this.mRectHeight - f2);
            path.close();
        } else if (relativeLocation == RelativeLocation.LEFT) {
            path.moveTo(this.mRectWidth - f2, i3 - (this.mArrowWidthMax / 2));
            path.lineTo((this.mRectWidth + this.mArrowWidthMin) - f2, i3);
            path.lineTo(this.mRectWidth - f2, i3 + (this.mArrowWidthMax / 2));
            path.close();
        } else if (relativeLocation == RelativeLocation.RIGHT) {
            i4 = this.mArrowWidthMin;
            float f4 = i4 + f2;
            path.moveTo(f4, i3 - (this.mArrowWidthMax / 2));
            path.lineTo(f2, i3);
            path.lineTo(f4, i3 + (this.mArrowWidthMax / 2));
            path.close();
        }
        Path path2 = new Path();
        float f5 = i4;
        path2.addRoundRect(new RectF(f2 + f5, f2, (this.mRectWidth + i4) - f2, this.mRectHeight - f2), f3, f3, Path.Direction.CCW);
        Paint paint = new Paint();
        paint.setColor(-986896);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setFilterBitmap(true);
        canvas.drawPath(path2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        mergeViews(sortedWindowViews, f3);
        canvas.save();
        canvas.translate(f5, 0.0f);
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f2);
        paint2.setColor(-986896);
        canvas.drawPath(path2, paint2);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(-986896);
        canvas.drawPath(path, paint2);
    }

    public void remove() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (getParent() != null) {
            FloatWindowManager.getInstance().removeView(this);
        }
    }

    public void showIfNeed(Rect rect, int i2, int i3) {
        int i4;
        if (rect != null && rect.width() < this.mMaxHitWidth && rect.height() < this.mMaxHitWidth) {
            float dp2Px = ((this.mRectWidth / 2) - Util.dp2Px(getContext(), 2.0f)) / 1.17f;
            float f2 = i2;
            float f3 = getResources().getDisplayMetrics().widthPixels - dp2Px;
            if (f2 > f3) {
                this.mCurrentX = f3;
            } else if (f2 < dp2Px) {
                this.mCurrentX = dp2Px;
            } else {
                this.mCurrentX = f2;
            }
            this.mCurrentY = i3 < this.mRectHeight / 2 ? i4 / 2 : i3;
            this.mMaskRect = rect;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            int dp2Px2 = Util.dp2Px(getContext(), 1.0f);
            int i5 = rect.top;
            int i6 = this.mRectHeight;
            int i7 = i5 - i6;
            int i8 = this.mArrowWidthMin;
            if (i7 >= i8 + dp2Px2) {
                layoutParams.width = this.mRectWidth;
                layoutParams.height = i6 + i8;
                layoutParams.x = (rect.left + (rect.width() / 2)) - (layoutParams.width / 2);
                layoutParams.y = (rect.top - layoutParams.height) - dp2Px2;
                this.mRelativeLocation = RelativeLocation.TOP;
            } else {
                int width = rect.left - getWidth();
                int i9 = this.mArrowWidthMin;
                if (width >= i9 + dp2Px2) {
                    int i10 = this.mRectWidth + i9;
                    layoutParams.width = i10;
                    layoutParams.height = this.mRectHeight;
                    layoutParams.x = (rect.left - i10) - dp2Px2;
                    layoutParams.y = (rect.top + (rect.height() / 2)) - (layoutParams.height / 2);
                    this.mRelativeLocation = RelativeLocation.LEFT;
                } else {
                    layoutParams.width = this.mRectWidth + i9;
                    layoutParams.height = this.mRectHeight;
                    layoutParams.x = rect.right + dp2Px2;
                    layoutParams.y = (rect.top + (rect.height() / 2)) - (layoutParams.height / 2);
                    this.mRelativeLocation = RelativeLocation.RIGHT;
                }
            }
            FloatWindowManager.getInstance().updateViewLayout(this, layoutParams);
            setVisibility(0);
            bringToFront();
            invalidate();
            return;
        }
        setVisibility(8);
    }
}
