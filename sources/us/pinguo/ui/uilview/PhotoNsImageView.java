package us.pinguo.ui.uilview;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class PhotoNsImageView extends PhotoImageView {
    public PhotoNsImageView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        setDisplayer(new us.pinguo.foundation.t.a.d(400, true, true, false));
    }

    public PhotoNsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PhotoNsImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
