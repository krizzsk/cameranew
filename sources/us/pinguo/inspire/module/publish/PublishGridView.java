package us.pinguo.inspire.module.publish;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import us.pinguo.inspire.R;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes9.dex */
public class PublishGridView extends View implements View.OnClickListener {
    private static final int COLUMN = 4;
    private static final int COUNT = 9;
    private boolean mClicking;
    private int mColumn;
    private int mDividerColor;
    private int mDividerWidth;
    protected PublishDrawable[] mDrawables;
    private List<InspireWork> mFeatureWorks;
    private List<String> mFeatures;
    private int mGridMargin;
    private boolean mIsPublishPage;
    private OnItemClick mOnItemClick;
    private Paint mPaint;
    private PointF mTouchPoint;
    private DeleteItemClick onDeleItemClick;
    private OnItemFinal onFinal;

    /* loaded from: classes9.dex */
    public interface DeleteItemClick {
        void deleteItemClick(View view, int i2);
    }

    /* loaded from: classes9.dex */
    public interface OnItemClick {
        void onItemClick(View view, int i2);
    }

    /* loaded from: classes9.dex */
    public interface OnItemFinal {
        void onItemFinal(View view, int i2);
    }

    public PublishGridView(Context context) {
        super(context);
        this.mColumn = 4;
        this.mTouchPoint = new PointF();
        init(context, null);
    }

    private int getTouchIndex() {
        int width = getWidth();
        int i2 = this.mColumn;
        PointF pointF = this.mTouchPoint;
        float f2 = width / i2;
        return ((int) (pointF.x / f2)) + (((int) (pointF.y / f2)) * i2);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mColumn = 4;
        int i2 = 9;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PublishGridView);
            this.mColumn = obtainStyledAttributes.getInt(0, 4);
            i2 = obtainStyledAttributes.getInt(1, 9);
        }
        this.mDrawables = new PublishDrawable[i2];
        this.mGridMargin = us.pinguo.foundation.t.b.a.a(getContext(), 4.0f);
        initDrawables();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(this.mDividerColor);
        this.mPaint.setStrokeWidth(this.mDividerWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        setOnClickListener(this);
    }

    private void measureMode9(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int i4 = this.mGridMargin;
        int i5 = this.mColumn;
        int i6 = (size - (i4 * (i5 - 1))) / i5;
        int count = getCount();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < count; i9++) {
            this.mDrawables[i9].setBounds(i7, i8, i7 + i6, i8 + i6);
            int i10 = this.mColumn;
            if (i9 % i10 == i10 - 1) {
                i8 += this.mGridMargin + i6;
                i7 = 0;
            } else {
                i7 += this.mGridMargin + i6;
            }
        }
        int i11 = this.mColumn;
        int i12 = count / i11;
        if (count % i11 != 0) {
            i12++;
        }
        setMeasuredDimension(size, (i6 * i12) + ((i12 - 1) * this.mGridMargin));
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int touchIndex = getTouchIndex();
        PublishDrawable[] publishDrawableArr = this.mDrawables;
        if (touchIndex < publishDrawableArr.length) {
            publishDrawableArr[touchIndex].setState(getDrawableState());
        }
    }

    public Bitmap getBitmap(int i2) {
        PublishDrawable[] publishDrawableArr = this.mDrawables;
        if (publishDrawableArr == null || i2 >= publishDrawableArr.length) {
            return null;
        }
        return publishDrawableArr[i2].getBitmap();
    }

    public int getCount() {
        List<InspireWork> list = this.mFeatureWorks;
        if (list == null) {
            List<String> list2 = this.mFeatures;
            if (list2 == null) {
                return 0;
            }
            return list2.size();
        }
        return list.size();
    }

    public Rect getItemBoundsInWindow(int i2) {
        PublishDrawable[] publishDrawableArr;
        Rect rect = new Rect();
        if (i2 >= 0 && (publishDrawableArr = this.mDrawables) != null && i2 < publishDrawableArr.length) {
            rect.set(publishDrawableArr[i2].getBounds());
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            rect.offset(iArr[0], iArr[1]);
        }
        return rect;
    }

    protected void initDrawables() {
        int i2 = 0;
        while (true) {
            PublishDrawable[] publishDrawableArr = this.mDrawables;
            if (i2 >= publishDrawableArr.length) {
                return;
            }
            publishDrawableArr[i2] = new PublishDrawable(getContext());
            this.mDrawables[i2].setCallback(this);
            i2++;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int touchIndex;
        if (us.pinguo.foundation.utils.j.a(600L) || this.mClicking) {
            return;
        }
        this.mClicking = true;
        if (this.mOnItemClick != null && (touchIndex = getTouchIndex()) <= getCount() - 1) {
            PublishDrawable publishDrawable = this.mDrawables[touchIndex];
            Rect bounds = publishDrawable.getBounds();
            Bitmap closeIcon = publishDrawable.getCloseIcon();
            int width = bounds.right - closeIcon.getWidth();
            int i2 = bounds.top;
            Rect rect = new Rect(width, i2, bounds.right, closeIcon.getHeight() + i2);
            PointF pointF = this.mTouchPoint;
            if (rect.contains((int) pointF.x, (int) pointF.y)) {
                DeleteItemClick deleteItemClick = this.onDeleItemClick;
                if (deleteItemClick != null) {
                    deleteItemClick.deleteItemClick(this, touchIndex);
                }
            } else if (touchIndex == getCount() - 1 && this.mIsPublishPage) {
                List<String> list = this.mFeatures;
                if (list != null && touchIndex == list.size() - 1 && this.mFeatures.size() == 9) {
                    if (this.mFeatures.get(touchIndex).contains("drawable")) {
                        OnItemFinal onItemFinal = this.onFinal;
                        if (onItemFinal != null) {
                            onItemFinal.onItemFinal(this, touchIndex);
                        }
                        this.mClicking = false;
                        return;
                    }
                    this.mOnItemClick.onItemClick(this, touchIndex);
                    this.mClicking = false;
                    return;
                }
                OnItemFinal onItemFinal2 = this.onFinal;
                if (onItemFinal2 != null) {
                    onItemFinal2.onItemFinal(this, touchIndex);
                }
            } else {
                this.mOnItemClick.onItemClick(this, touchIndex);
            }
        }
        this.mClicking = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            PublishDrawable[] publishDrawableArr = this.mDrawables;
            if (i2 >= publishDrawableArr.length) {
                return;
            }
            publishDrawableArr[i2].draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size;
        List<InspireWork> list = this.mFeatureWorks;
        if (list != null) {
            size = list.size();
        } else {
            List<String> list2 = this.mFeatures;
            size = list2 == null ? 0 : list2.size();
        }
        if (size == 0) {
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

    public void setCount(int i2) {
        this.mDrawables = new PublishDrawable[i2];
        initDrawables();
    }

    public void setDividerWidthPx(int i2) {
        this.mDividerWidth = i2;
    }

    public void setGridMargin(int i2) {
        this.mGridMargin = i2;
    }

    public void setOnDeleItemClick(DeleteItemClick deleteItemClick) {
        this.onDeleItemClick = deleteItemClick;
    }

    public void setOnFinal(OnItemFinal onItemFinal) {
        this.onFinal = onItemFinal;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.mOnItemClick = onItemClick;
    }

    public void setPublishPage(boolean z) {
        this.mIsPublishPage = z;
    }

    public void setUris(List<String> list) {
        if (list != null && list.size() != 0) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.mFeatures = list;
            int j2 = us.pinguo.foundation.t.b.a.j(getContext()) / this.mColumn;
            us.pinguo.common.log.a.k("size:" + j2 + "X" + j2, new Object[0]);
            for (int i2 = 0; i2 < this.mFeatures.size(); i2++) {
                PublishDrawable publishDrawable = this.mDrawables[i2];
                publishDrawable.setSize(j2, j2);
                publishDrawable.setShowClose(true);
                if (publishDrawable.getUri() != null && !publishDrawable.getUri().equals(this.mFeatures.get(i2))) {
                    publishDrawable.setBitmap(null);
                }
                publishDrawable.setLoadingColor(getResources().getColor(us.pinguo.ui.R.color.inspire_loading_color));
                publishDrawable.setImageUri(this.mFeatures.get(i2));
                if (i2 == this.mFeatures.size() - 1 && this.mFeatures.size() < 9) {
                    publishDrawable.setShowClose(false);
                }
                if (i2 == this.mFeatures.size() - 1 && this.mFeatures.size() == 9) {
                    if (this.mFeatures.get(i2).contains("drawable")) {
                        publishDrawable.setShowClose(false);
                    } else {
                        publishDrawable.setShowClose(true);
                    }
                }
            }
            requestLayout();
            invalidate();
            return;
        }
        setVisibility(4);
    }

    public void setWorks(List<InspireWork> list) {
        if (list != null && list.size() != 0) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            List<InspireWork> list2 = this.mFeatureWorks;
            int size = list2 == null ? 0 : list2.size();
            this.mFeatureWorks = list;
            int j2 = us.pinguo.foundation.t.b.a.j(getContext()) / this.mColumn;
            us.pinguo.common.log.a.k("size:" + j2 + "X" + j2, new Object[0]);
            for (int i2 = 0; i2 < this.mFeatureWorks.size(); i2++) {
                InspireWork inspireWork = this.mFeatureWorks.get(i2);
                PublishDrawable publishDrawable = this.mDrawables[i2];
                publishDrawable.setSize(j2, j2);
                if (publishDrawable.getUri() != null && !publishDrawable.getUri().equals(inspireWork.getWorkUrl())) {
                    publishDrawable.setBitmap(null);
                }
                publishDrawable.setLoadingColor(getResources().getColor(us.pinguo.ui.R.color.inspire_loading_color));
                publishDrawable.setWorkType(inspireWork.workType);
                publishDrawable.setPhotoCount(inspireWork.getMembersCount());
                if (inspireWork.isVideo()) {
                    int j3 = us.pinguo.foundation.t.b.a.j(getContext()) / this.mColumn;
                    PhotoImageView.b generateSize = PhotoImageView.generateSize(inspireWork.width, inspireWork.height, j3, j3);
                    publishDrawable.setImageUri(this.mFeatureWorks.get(i2).getWorkUrl(), generateSize.a, generateSize.b, true);
                } else {
                    publishDrawable.setImageUri(this.mFeatureWorks.get(i2).getWorkUrl());
                }
            }
            if (size != list.size()) {
                requestLayout();
            }
        } else if (!us.pinguo.foundation.d.f10985d) {
            us.pinguo.common.log.a.e("features is null or empty", new Object[0]);
            setVisibility(4);
        } else {
            throw new NullPointerException("features is null or empty");
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }

    public PublishGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColumn = 4;
        this.mTouchPoint = new PointF();
        init(context, attributeSet);
    }

    public PublishGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mColumn = 4;
        this.mTouchPoint = new PointF();
        init(context, attributeSet);
    }
}
