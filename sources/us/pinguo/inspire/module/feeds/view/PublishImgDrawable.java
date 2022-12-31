package us.pinguo.inspire.module.feeds.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;
import java.io.FileNotFoundException;
import us.pinguo.ui.uilview.b;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PublishImgDrawable extends b {
    private int mRightMargin;
    private Rect mSelectBounds = new Rect();
    private Drawable mSelectDrawable;
    private boolean mSelected;
    private int mTopMargin;
    private Drawable mUnselectDrawable;

    public PublishImgDrawable(Resources resources) {
        this.mSelectDrawable = resources.getDrawable(R.drawable.publish_guide_select);
        this.mUnselectDrawable = resources.getDrawable(R.drawable.publish_guide_unselected);
    }

    @Override // us.pinguo.ui.uilview.b, us.pinguo.foundation.t.a.b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.mSelected ? this.mSelectDrawable : this.mUnselectDrawable;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i2 = getBounds().right - this.mRightMargin;
        int i3 = getBounds().top - this.mTopMargin;
        drawable.setBounds(i2 - intrinsicWidth, i3, i2, intrinsicHeight + i3);
        this.mSelectBounds = drawable.getBounds();
        drawable.draw(canvas);
    }

    public Rect getSelectBounds() {
        return this.mSelectBounds;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    @Override // us.pinguo.ui.uilview.d, com.nostra13.universalimageloader.core.k.a
    public void onLoadingFailed(final String str, View view, FailReason failReason) {
        super.onLoadingFailed(str, view, failReason);
        if (failReason.a() instanceof FileNotFoundException) {
            new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.feeds.view.PublishImgDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    PublishImgDrawable.this.setImageUri(str);
                }
            }, 500L);
        }
    }

    public void setSelected(boolean z) {
        if (z == this.mSelected) {
            return;
        }
        this.mSelected = z;
        invalidateSelf();
    }
}
