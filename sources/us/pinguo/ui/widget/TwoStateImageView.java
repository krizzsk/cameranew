package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class TwoStateImageView extends ImageView {
    private boolean a;

    public TwoStateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.a) {
            if (z) {
                setAlpha(255);
            } else {
                setAlpha(102);
            }
        }
    }

    public TwoStateImageView(Context context) {
        this(context, null);
    }
}
