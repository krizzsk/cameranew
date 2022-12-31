package us.pinguo.widet;

import android.content.Context;
import android.util.AttributeSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* loaded from: classes6.dex */
public class FixBugSwipeRefreshLayout extends SwipeRefreshLayout {
    private boolean mMeasured;
    private boolean mPreMeasureRefreshing;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            FixBugSwipeRefreshLayout.super.setRefreshing(this.a);
        }
    }

    public FixBugSwipeRefreshLayout(Context context) {
        super(context);
        this.mMeasured = false;
        this.mPreMeasureRefreshing = false;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.mMeasured) {
            return;
        }
        this.mMeasured = true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public void setRefreshing(boolean z) {
        if (this.mMeasured) {
            super.setRefreshing(z);
        } else {
            post(new a(z));
        }
    }

    public FixBugSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasured = false;
        this.mPreMeasureRefreshing = false;
    }
}
