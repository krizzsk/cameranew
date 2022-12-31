package us.pinguo.inspire.module.masterlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import us.pinguo.widet.FixBugSwipeRefreshLayout;
/* loaded from: classes9.dex */
public class VpSwipeRefreshLayout extends FixBugSwipeRefreshLayout {
    private float mInitialDownX;
    private float mInitialDownY;

    public VpSwipeRefreshLayout(Context context) {
        super(context);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInitialDownX = motionEvent.getX();
            this.mInitialDownY = motionEvent.getY();
        } else if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.mInitialDownX) > Math.abs(motionEvent.getY() - this.mInitialDownY)) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public VpSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
