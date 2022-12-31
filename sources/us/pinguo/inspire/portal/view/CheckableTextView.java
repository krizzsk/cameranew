package us.pinguo.inspire.portal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class CheckableTextView extends TextView {
    private static final int[] b = {16842912};
    private boolean a;

    public CheckableTextView(Context context) {
        super(context);
    }

    public boolean a() {
        return this.a;
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (a()) {
            TextView.mergeDrawableStates(onCreateDrawableState, b);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        if (this.a != z) {
            this.a = z;
            refreshDrawableState();
        }
        if (z) {
            setTextColor(-12806145);
        } else {
            setTextColor(1140850688);
        }
    }

    public CheckableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
