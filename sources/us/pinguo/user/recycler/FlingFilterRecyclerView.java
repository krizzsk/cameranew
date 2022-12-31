package us.pinguo.user.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class FlingFilterRecyclerView extends ScrollListenerRecyclerView {
    private boolean mFlingEnable;
    private boolean mTouched;

    public FlingFilterRecyclerView(Context context) {
        super(context);
        this.mFlingEnable = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i2, int i3) {
        if (this.mFlingEnable) {
            return super.fling(i2, i3);
        }
        return false;
    }

    public boolean isTouched() {
        return this.mTouched;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mTouched = true;
        return super.onTouchEvent(motionEvent);
    }

    public void setFlingEnabled(boolean z) {
        this.mFlingEnable = z;
    }

    public FlingFilterRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlingEnable = true;
    }

    public FlingFilterRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mFlingEnable = true;
    }
}
