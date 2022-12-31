package us.pinguo.inspire.adv.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.foundation.utils.l0;
import us.pinguo.ui.widget.GaussianBlur.GaussianBlurImageView;
/* loaded from: classes9.dex */
public class AdGaussianBlurImageView extends GaussianBlurImageView {
    public AdGaussianBlurImageView(Context context) {
        super(context);
    }

    @Override // us.pinguo.ui.uilview.UilImageView
    public void setImageUri(String str) {
        setImageUri(str, this.mDisplayImageOptions);
    }

    public AdGaussianBlurImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void setImageUri(String str, c cVar) {
        ImageLoader.getInstance().l(str, this.mImageViewAware, cVar, this, this);
        l0.a(this.mImageViewAware);
    }

    public AdGaussianBlurImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
