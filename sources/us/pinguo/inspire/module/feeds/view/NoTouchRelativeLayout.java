package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes9.dex */
public class NoTouchRelativeLayout extends RelativeLayout {
    private boolean mNoTouch;

    public NoTouchRelativeLayout(Context context) {
        super(context);
    }

    public boolean isNoTouch() {
        return this.mNoTouch;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.mNoTouch) {
            return true;
        }
        return onInterceptTouchEvent;
    }

    public void setNoTouch(boolean z) {
        this.mNoTouch = z;
    }

    public NoTouchRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoTouchRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
