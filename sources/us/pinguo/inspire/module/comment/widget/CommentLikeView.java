package us.pinguo.inspire.module.comment.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class CommentLikeView extends View {
    private static Bitmap mDefaultAvatar;
    private int mAvatarSize;
    private us.pinguo.ui.uilview.a[] mDrawables;
    private List<String> mList;
    private int mPhotoMargin;

    public CommentLikeView(Context context) {
        super(context);
        this.mDrawables = new us.pinguo.ui.uilview.a[6];
        initView();
    }

    private Bitmap getDefaultAvatar() {
        if (mDefaultAvatar == null) {
            try {
                mDefaultAvatar = BitmapFactory.decodeResource(getResources(), R.drawable.default_avatar);
            } catch (OutOfMemoryError e2) {
                d.f.a.b.d.c(e2);
            }
        }
        return mDefaultAvatar;
    }

    private void initView() {
        this.mPhotoMargin = us.pinguo.foundation.t.b.a.a(getContext(), 5.0f);
        this.mAvatarSize = us.pinguo.foundation.t.b.a.a(getContext(), 20.0f);
        initDrawables();
    }

    private void measureWidth(int i2) {
        int size = this.mList.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            us.pinguo.ui.uilview.a[] aVarArr = this.mDrawables;
            if (i4 >= aVarArr.length) {
                break;
            }
            us.pinguo.ui.uilview.a aVar = aVarArr[i4];
            int i5 = this.mAvatarSize;
            aVar.setBounds(i3, 0, i3 + i5, i5 + 0);
            i3 += this.mAvatarSize + this.mPhotoMargin;
        }
        setMeasuredDimension(i3, i2);
    }

    protected void initDrawables() {
        int i2 = 0;
        while (true) {
            us.pinguo.ui.uilview.a[] aVarArr = this.mDrawables;
            if (i2 >= aVarArr.length) {
                return;
            }
            aVarArr[i2] = new us.pinguo.ui.uilview.a();
            this.mDrawables[i2].setCallback(this);
            this.mDrawables[i2].setLoadingColor(getResources().getColor(R.color.inspire_loading_color));
            i2++;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mDefaultAvatar = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mList == null) {
            super.onDraw(canvas);
            return;
        }
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            us.pinguo.ui.uilview.a[] aVarArr = this.mDrawables;
            if (i2 >= aVarArr.length) {
                return;
            }
            aVarArr[i2].draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        List<String> list = this.mList;
        if ((list == null ? 0 : list.size()) == 0) {
            super.onMeasure(i2, i3);
        } else {
            measureWidth(View.MeasureSpec.getSize(i3));
        }
    }

    public void setListUrl(List<String> list) {
        this.mList = list;
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            us.pinguo.ui.uilview.a[] aVarArr = this.mDrawables;
            if (i2 >= aVarArr.length) {
                break;
            }
            us.pinguo.ui.uilview.a aVar = aVarArr[i2];
            int i3 = this.mAvatarSize;
            aVar.setSize(i3, i3);
            if (aVar.getUri() != null && !aVar.getUri().equals(this.mList.get(i2))) {
                aVar.setBitmap(getDefaultAvatar());
            } else if (aVar.getUri() == null) {
                aVar.setBitmap(getDefaultAvatar());
            }
            aVar.setImageUri(this.mList.get(i2));
        }
        requestLayout();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }

    public CommentLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawables = new us.pinguo.ui.uilview.a[6];
        initView();
    }

    public CommentLikeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDrawables = new us.pinguo.ui.uilview.a[6];
        initView();
    }

    @TargetApi(21)
    public CommentLikeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mDrawables = new us.pinguo.ui.uilview.a[6];
        initView();
    }
}
