package us.pinguo.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: ScrollCenterLayoutManager.kt */
/* loaded from: classes4.dex */
public final class ScrollCenterLayoutManager extends LinearLayoutManager {

    /* compiled from: ScrollCenterLayoutManager.kt */
    /* loaded from: classes4.dex */
    private static final class CenterSmoothScroller extends LinearSmoothScroller {
        private float a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CenterSmoothScroller(Context context) {
            super(context);
            s.h(context, "context");
            this.a = 300.0f;
        }

        public final void a(float f2) {
            this.a = f2;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
            return (i4 + ((i5 - i4) / 2)) - (i2 + ((i3 - i2) / 2));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i2) {
            s.h(view, "view");
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
                return 0;
            }
            return calculateDtToFit(view.getLeft(), view.getRight(), layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return displayMetrics != null ? this.a / displayMetrics.densityDpi : super.calculateSpeedPerPixel(displayMetrics);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollCenterLayoutManager(Context context) {
        super(context);
        s.h(context, "context");
    }

    public final void a(Context context, int i2, float f2) {
        s.h(context, "context");
        if (i2 == -1) {
            return;
        }
        CenterSmoothScroller centerSmoothScroller = new CenterSmoothScroller(context);
        centerSmoothScroller.setTargetPosition(i2);
        centerSmoothScroller.a(f2);
        startSmoothScroll(centerSmoothScroller);
    }

    public ScrollCenterLayoutManager(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    public ScrollCenterLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
