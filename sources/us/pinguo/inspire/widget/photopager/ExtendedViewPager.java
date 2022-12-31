package us.pinguo.inspire.widget.photopager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes9.dex */
public class ExtendedViewPager extends ViewPager {
    public ExtendedViewPager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        if (view instanceof TouchImageView) {
            return ((TouchImageView) view).B(-i2);
        }
        return super.canScroll(view, z, i2, i3, i4);
    }

    public ExtendedViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
