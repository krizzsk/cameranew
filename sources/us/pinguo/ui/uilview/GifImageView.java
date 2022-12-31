package us.pinguo.ui.uilview;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes6.dex */
public class GifImageView extends SimpleDraweeView {
    public GifImageView(Context context) {
        super(context);
    }

    public void setGifImageUrl(String str) {
        e L = com.facebook.drawee.backends.pipeline.c.h().L(str);
        L.y(true);
        setController(L.build());
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
