package us.pinguo.inspire.widget.photopager;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes9.dex */
public class FullScreenImageView extends PhotoImageView {
    private Rect a;

    public FullScreenImageView(Context context) {
        super(context);
        this.a = new Rect();
    }

    @Override // android.view.View
    public void layout(int i2, int i3, int i4, int i5) {
        Rect rect = this.a;
        if (i2 == rect.left && i3 == rect.top && i4 == rect.right && i5 == rect.bottom) {
            super.layout(i2, i3, i4, i5);
        }
    }

    public void setLayoutRect(int i2, int i3, int i4, int i5) {
        this.a.set(i2, i3, i4, i5);
    }

    public FullScreenImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
    }

    public FullScreenImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Rect();
    }
}
