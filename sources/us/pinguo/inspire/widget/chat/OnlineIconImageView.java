package us.pinguo.inspire.widget.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class OnlineIconImageView extends ImageView {
    public OnlineIconImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int i4 = getLayoutParams().height;
        if (size >= i4) {
            size = i4;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public OnlineIconImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OnlineIconImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
