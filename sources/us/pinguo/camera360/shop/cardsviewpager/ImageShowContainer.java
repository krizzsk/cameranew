package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class ImageShowContainer extends RelativeLayout {
    public ImageShowContainer(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int min = Math.min(RelativeLayout.getDefaultSize(getSuggestedMinimumWidth(), i2), RelativeLayout.getDefaultSize(getSuggestedMinimumHeight(), i3));
        setMeasuredDimension(min, min);
    }

    public ImageShowContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageShowContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
