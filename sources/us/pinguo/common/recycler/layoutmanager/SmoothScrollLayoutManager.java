package us.pinguo.common.recycler.layoutmanager;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
import us.pinguo.commonui.R;
/* compiled from: SmoothScrollLayoutManager.kt */
/* loaded from: classes4.dex */
public final class SmoothScrollLayoutManager extends LinearLayoutManager {
    private int a;
    private int b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private LinearSmoothScroller f9947d;

    /* compiled from: SmoothScrollLayoutManager.kt */
    /* loaded from: classes4.dex */
    public static final class a extends LinearSmoothScroller {
        private final RecyclerView a;
        private int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecyclerView mRecyclerView, Context context) {
            super(context);
            s.h(mRecyclerView, "mRecyclerView");
            s.h(context, "context");
            this.a = mRecyclerView;
            this.b = Integer.MAX_VALUE;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i2) {
            int left;
            s.h(view, "view");
            int i3 = this.b;
            if (i3 == Integer.MAX_VALUE) {
                i3 = (this.a.getWidth() - view.getWidth()) / 2;
                left = view.getLeft();
            } else {
                left = view.getLeft();
            }
            return i3 - left;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i2) {
            s.h(view, "view");
            return 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothScrollLayoutManager(Context context, int i2, boolean z) {
        super(context, i2, z);
        s.h(context, "context");
        this.a = -1;
        this.c = true;
        this.b = context.getResources().getDimensionPixelSize(R.dimen.sticker_category_item_margin) + context.getResources().getDimensionPixelSize(R.dimen.sticker_category_list_view_width);
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void b(LinearSmoothScroller scroller) {
        s.h(scroller, "scroller");
        this.f9947d = scroller;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i2, int i3) {
        this.a = i2;
        super.scrollToPositionWithOffset(i2, i3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        s.h(recyclerView, "recyclerView");
        if (!(this.a == i2 && this.c) && recyclerView.getMeasuredWidth() > 0) {
            this.a = i2;
            LinearSmoothScroller linearSmoothScroller = this.f9947d;
            if (linearSmoothScroller == null) {
                scrollToPositionWithOffset(i2, (recyclerView.getMeasuredWidth() - this.b) / 2);
                return;
            }
            s.e(linearSmoothScroller);
            linearSmoothScroller.setTargetPosition(i2);
            startSmoothScroll(this.f9947d);
        }
    }
}
