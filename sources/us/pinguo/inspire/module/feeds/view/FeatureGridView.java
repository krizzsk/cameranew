package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import us.pinguo.foundation.d;
import us.pinguo.foundation.t.b.a;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeatureGridView extends View implements View.OnClickListener {
    public static final int COLUMN = 3;
    private static final int COUNT = 6;
    public static final float FEATURE_GRID_WH_RATE = 1.5f;
    private static boolean test = false;
    private int mColumn;
    private int mDividerColor;
    private int mDividerWidth;
    private int mDrawCount;
    protected FeedsFeatureDrawable[] mDrawables;
    private Feature[] mFeatures;
    private OnItemClick mOnItemClick;
    private Paint mPaint;
    private PointF mTouchPoint;

    /* loaded from: classes9.dex */
    public static class Feature {
        public int defaultImg;
        public String text;
        public String uri;

        public Feature(String str, String str2, int i2) {
            this.uri = str;
            this.text = str2;
            this.defaultImg = i2;
        }
    }

    /* loaded from: classes9.dex */
    public interface OnItemClick {
        void onItemClick(View view, int i2);
    }

    public FeatureGridView(Context context) {
        super(context);
        this.mDrawables = new FeedsFeatureDrawable[6];
        this.mColumn = 3;
        this.mTouchPoint = new PointF();
        init();
    }

    private void drawDividers(Canvas canvas) {
        int height = getHeight();
        if (this.mDrawCount > 3) {
            int i2 = height / 2;
            canvas.drawLine(0.0f, i2 - (this.mDividerWidth / 2), getWidth(), i2 + (this.mDividerWidth / 2), this.mPaint);
        }
        float f2 = height;
        canvas.drawLine(0.0f, height - this.mDividerWidth, getWidth(), f2, this.mPaint);
        int i3 = this.mDividerWidth / 2;
        int width = getWidth() / 3;
        canvas.drawLine(width - i3, 0.0f, width + i3, f2, this.mPaint);
        int i4 = width * 2;
        canvas.drawLine(i4 - i3, 0.0f, i4 + i3, f2, this.mPaint);
        int i5 = width * 3;
        canvas.drawLine(i5 - i3, 0.0f, i5 + i3, f2, this.mPaint);
    }

    private int getTouchIndex() {
        float width = getWidth() / 3;
        PointF pointF = this.mTouchPoint;
        return ((int) (pointF.x / width)) + ((pointF.y > ((float) ((int) (width / 1.5f))) ? 1 : 0) * 3);
    }

    private void init() {
        this.mDividerWidth = a.a(getContext(), 0.5f);
        this.mDividerColor = getResources().getColor(R.color.divider_color_res_0x7d03000b);
        initDrawables();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(this.mDividerColor);
        this.mPaint.setStrokeWidth(this.mDividerWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        setOnClickListener(this);
    }

    private void measureMode9(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int i5 = size / 3;
        int i6 = (int) (i5 / 1.5f);
        int b = a.b(getResources(), 4.0f);
        int b2 = a.b(getResources(), 4.0f);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i4 = this.mDrawCount;
            if (i7 >= i4) {
                break;
            }
            FeedsFeatureDrawable feedsFeatureDrawable = this.mDrawables[i7];
            if (i7 / 3 >= 1) {
                feedsFeatureDrawable.setBottomPadding(b);
                feedsFeatureDrawable.setTopPadding(b2);
                feedsFeatureDrawable.setBoundsForceChange(i8, i9, i8 + i5, i9 + i6);
            } else {
                feedsFeatureDrawable.setBoundsForceChange(i8, i9, i8 + i5, i9 + i6);
            }
            int i10 = this.mColumn;
            if (i7 % i10 == i10 - 1) {
                i9 += i6;
                i8 = 0;
            } else {
                i8 += i5;
            }
            i7++;
        }
        int i11 = this.mColumn;
        int i12 = i4 / i11;
        if (i4 % i11 != 0) {
            i12++;
        }
        setMeasuredDimension(size, i12 * i6);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int touchIndex = getTouchIndex();
        Feature[] featureArr = this.mFeatures;
        int length = featureArr == null ? 0 : featureArr.length;
        FeedsFeatureDrawable[] feedsFeatureDrawableArr = this.mDrawables;
        if (touchIndex >= feedsFeatureDrawableArr.length || touchIndex >= length) {
            return;
        }
        feedsFeatureDrawableArr[touchIndex].setState(getDrawableState());
    }

    protected void initDrawables() {
        int i2 = 0;
        while (true) {
            FeedsFeatureDrawable[] feedsFeatureDrawableArr = this.mDrawables;
            if (i2 >= feedsFeatureDrawableArr.length) {
                return;
            }
            feedsFeatureDrawableArr[i2] = new FeedsFeatureDrawable(getContext());
            this.mDrawables[i2].setCallback(this);
            i2++;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClick onItemClick = this.mOnItemClick;
        if (onItemClick != null) {
            onItemClick.onItemClick(this, getTouchIndex());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.mDrawCount; i2++) {
            FeedsFeatureDrawable[] feedsFeatureDrawableArr = this.mDrawables;
            if (i2 >= feedsFeatureDrawableArr.length) {
                break;
            }
            feedsFeatureDrawableArr[i2].draw(canvas);
        }
        drawDividers(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        Feature[] featureArr = this.mFeatures;
        if ((featureArr == null ? 0 : featureArr.length) == 0) {
            super.onMeasure(i2, i3);
        } else {
            measureMode9(i2, i3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mTouchPoint.set(motionEvent.getX(), motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
    }

    public void setColumn(int i2) {
        this.mColumn = i2;
    }

    public void setDividerWidthPx(int i2) {
        this.mDividerWidth = i2;
    }

    public void setFeatures(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.mFeatures = featureArr;
            this.mDrawCount = 0;
            int j2 = a.j(getContext()) / 3;
            us.pinguo.common.log.a.k("size:" + j2 + "X" + j2, new Object[0]);
            for (int i2 = 0; i2 < this.mFeatures.length; i2++) {
                FeedsFeatureDrawable[] feedsFeatureDrawableArr = this.mDrawables;
                if (i2 >= feedsFeatureDrawableArr.length || i2 >= featureArr.length) {
                    break;
                }
                if (feedsFeatureDrawableArr[i2] != null && featureArr[i2] != null) {
                    FeedsFeatureDrawable feedsFeatureDrawable = feedsFeatureDrawableArr[i2];
                    feedsFeatureDrawable.setSize(j2, j2);
                    if (feedsFeatureDrawable.getUri() != null && !feedsFeatureDrawable.getUri().equals(featureArr[i2].uri)) {
                        feedsFeatureDrawable.setBitmap(null);
                    }
                    feedsFeatureDrawable.setText(featureArr[i2].text);
                    if (!TextUtils.isEmpty(featureArr[i2].uri)) {
                        feedsFeatureDrawable.setImageUri(featureArr[i2].uri);
                    } else {
                        feedsFeatureDrawable.setImageResource(getContext(), featureArr[i2].defaultImg);
                    }
                    this.mDrawCount++;
                }
            }
            requestLayout();
        } else if (!d.f10985d) {
            us.pinguo.common.log.a.e("features is null or empty", new Object[0]);
            setVisibility(4);
        } else {
            throw new NullPointerException("features is null or empty");
        }
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.mOnItemClick = onItemClick;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }

    public FeatureGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawables = new FeedsFeatureDrawable[6];
        this.mColumn = 3;
        this.mTouchPoint = new PointF();
        init();
    }

    public FeatureGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDrawables = new FeedsFeatureDrawable[6];
        this.mColumn = 3;
        this.mTouchPoint = new PointF();
        init();
    }
}
