package us.pinguo.inspire.widget.quicksidebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import us.pinguo.inspire.widget.quicksidebar.tipsview.QuickSideBarTipsItemView;
/* loaded from: classes4.dex */
public class QuickSideBarTipsView extends RelativeLayout {
    private QuickSideBarTipsItemView a;

    public QuickSideBarTipsView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = new QuickSideBarTipsItemView(context, attributeSet);
        addView(this.a, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void setText(String str, int i2, float f2) {
        this.a.setText(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.topMargin = (int) (f2 - (getWidth() / 2.8d));
        this.a.setLayoutParams(layoutParams);
    }

    public QuickSideBarTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickSideBarTipsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
