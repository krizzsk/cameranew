package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.ui.R;
import us.pinguo.ui.uilview.b;
/* loaded from: classes9.dex */
public class FeedsPublishGridView extends PhotoGridView {
    public FeedsPublishGridView(Context context) {
        super(context);
    }

    private void browsePic(final int i2) {
        ArrayList arrayList = new ArrayList();
        FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
        InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
        PhotoGridView.b[] bVarArr = this.mPhotos;
        inspireFeedPhoto.width = bVarArr[i2].a;
        inspireFeedPhoto.height = bVarArr[i2].b;
        inspireFeedPhoto.url = bVarArr[i2].c;
        fullScreenPhoto.photo = inspireFeedPhoto;
        fullScreenPhoto.rect = getItemBoundsInWindow(i2);
        arrayList.add(fullScreenPhoto);
        Bitmap[] bitmaps = getBitmaps();
        if (i2 < bitmaps.length) {
            bitmaps = new Bitmap[]{bitmaps[i2]};
        }
        PictureViewPagerDialogFragment.showFullScreenPics(((FragmentActivity) getContext()).getSupportFragmentManager(), bitmaps, arrayList, 0, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.feeds.view.FeedsPublishGridView.1
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i3) {
                return FeedsPublishGridView.this.getItemBoundsInWindow(i2);
            }
        });
    }

    public boolean getSelect(int i2) {
        b[] bVarArr = this.mDrawables;
        if (i2 >= bVarArr.length || i2 >= this.mDrawCount || i2 < 0) {
            return false;
        }
        return ((PublishImgDrawable) bVarArr[i2]).isSelected();
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView
    protected int getTouchIndex() {
        for (int i2 = 0; i2 < this.mDrawCount; i2++) {
            b[] bVarArr = this.mDrawables;
            if (i2 >= bVarArr.length) {
                break;
            }
            PublishImgDrawable publishImgDrawable = (PublishImgDrawable) bVarArr[i2];
            if (publishImgDrawable != null) {
                Rect bounds = publishImgDrawable.getBounds();
                PointF pointF = this.mTouchPoint;
                if (isInRect(pointF.x, pointF.y, bounds)) {
                    PointF pointF2 = this.mTouchPoint;
                    if (isInRect(pointF2.x, pointF2.y, publishImgDrawable.getSelectBounds())) {
                        return i2;
                    }
                    browsePic(i2);
                    return -1;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.PhotoGridView
    public void initDrawables() {
        this.mDrawables = new PublishImgDrawable[9];
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.mDrawables;
            if (i2 < bVarArr.length) {
                bVarArr[i2] = new PublishImgDrawable(getResources());
                this.mDrawables[i2].setLoadingColor(getResources().getColor(R.color.inspire_loading_color));
                i2++;
            } else {
                setColumn(3);
                setGridMarginPx(a.b(getResources(), 1.0f));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.PhotoGridView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setSelect(int i2, boolean z) {
        b[] bVarArr = this.mDrawables;
        if (i2 >= bVarArr.length || i2 >= this.mDrawCount || i2 < 0) {
            return;
        }
        ((PublishImgDrawable) bVarArr[i2]).setSelected(z);
    }

    public FeedsPublishGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedsPublishGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
