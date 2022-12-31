package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
/* loaded from: classes6.dex */
public class ViewFlipper3d extends ViewFlipper {
    private Animation a;
    private Animation b;

    public ViewFlipper3d(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (getChildCount() != 0) {
            i2 = getChildAt(0).getMeasuredWidth();
            i3 = getChildAt(0).getMeasuredHeight();
        }
        float f2 = i2 / 2;
        float f3 = i3 / 2;
        i iVar = new i(0.0f, 90.0f, f2, f3, 0.0f, false);
        this.b = iVar;
        iVar.setDuration(600L);
        this.b.setFillAfter(false);
        this.b.setInterpolator(new AccelerateInterpolator());
        i iVar2 = new i(-90.0f, 0.0f, f2, f3, 0.0f, false);
        this.a = iVar2;
        iVar2.setDuration(600L);
        this.a.setStartOffset(600L);
        this.a.setFillAfter(false);
        this.a.setInterpolator(new AccelerateInterpolator());
        setInAnimation(this.a);
        setOutAnimation(this.b);
    }

    public ViewFlipper3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
