package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Objects;
/* loaded from: classes2.dex */
public class StickyScrollLinearLayout extends LinearLayout implements NestedScrollingParent {
    private View a;
    private View b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private OverScroller f5800d;

    /* renamed from: e  reason: collision with root package name */
    private int f5801e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.LayoutManager f5802f;

    /* renamed from: g  reason: collision with root package name */
    private int f5803g;

    /* loaded from: classes2.dex */
    public interface a {
        View a();

        View b();

        View c();
    }

    public StickyScrollLinearLayout(Context context) {
        super(context);
        this.f5802f = null;
        this.f5803g = 1;
        c(context);
    }

    private void b() {
        View view = this.a;
        if (view == null) {
            return;
        }
        this.f5801e = view.getMeasuredHeight();
    }

    private void c(Context context) {
        setOrientation(1);
        this.f5800d = new OverScroller(context);
    }

    private void d() {
        this.c.getLayoutParams().height = getMeasuredHeight() - this.b.getMeasuredHeight();
        setMeasuredDimension(getMeasuredWidth(), this.a.getMeasuredHeight() + this.b.getMeasuredHeight() + this.c.getMeasuredHeight());
    }

    public void a(int i2) {
        this.f5800d.fling(0, getScrollY(), 0, i2, 0, 0, 0, this.f5801e);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f5800d.computeScrollOffset()) {
            scrollTo(0, this.f5800d.getCurrY());
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        Log.e("StickyScrollLayout", "getNestedScrollAxes");
        return 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.b == null || this.a == null || this.c == null) {
            return;
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Log.e("StickyScrollLayout", "onNestedFling");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        Log.e("StickyScrollLayout", "onNestedPreFling");
        if (getScrollY() >= this.f5801e) {
            return false;
        }
        a((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int findFirstCompletelyVisibleItemPosition;
        if (view instanceof XRecyclerView) {
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
            this.f5802f = layoutManager;
            if (layoutManager instanceof GridLayoutManager) {
                findFirstCompletelyVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] iArr2 = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) this.f5802f).findFirstCompletelyVisibleItemPositions(iArr2);
                findFirstCompletelyVisibleItemPosition = iArr2[0];
            } else {
                findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            }
            if (findFirstCompletelyVisibleItemPosition < 0) {
                return;
            }
            int scrollY = getScrollY();
            boolean z = i3 > 0 && scrollY < this.f5801e;
            Log.e("StickyScrollLayout", "mTopViewHeight == " + this.f5801e + "\ndy == " + i3 + "\nscrollY == " + scrollY + "\nhiddenTop && showTop " + z);
            if (!z) {
                z = i3 < 0 && scrollY >= 0 && (!ViewCompat.canScrollVertically(view, -1) || findFirstCompletelyVisibleItemPosition == this.f5803g);
                Log.e("StickyScrollLayout", "mTopViewHeight == " + this.f5801e + "\ndy == " + i3 + "\nscrollY == " + scrollY + "\nfirstVisiblePosition " + findFirstCompletelyVisibleItemPosition);
            }
            if (z) {
                scrollBy(0, i3);
                iArr[1] = i3;
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("insert your content must is XRecyclerView!");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Log.e("StickyScrollLayout", "onNestedScroll " + i3 + "----" + i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Log.e("StickyScrollLayout", "onNestedScrollAccepted");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        Log.e("StickyScrollLayout", "onStartNestedScroll " + view.toString() + "  " + view2.toString());
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Log.e("StickyScrollLayout", "onStopNestedScroll " + view.toString());
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.f5801e;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i3 != getScrollY()) {
            super.scrollTo(i2, i3);
        }
    }

    public void setInitInterface(@NonNull a aVar) {
        Objects.requireNonNull(aVar, "initInterface can not be null!");
        View c = aVar.c();
        this.a = c;
        if (c != null) {
            b();
        }
        this.b = aVar.b();
        View a2 = aVar.a();
        this.c = a2;
        if (a2 == null) {
            return;
        }
        d();
        requestLayout();
    }

    public void setTargetFirstVisiblePosition(int i2) {
        this.f5803g = i2;
    }

    public StickyScrollLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5802f = null;
        this.f5803g = 1;
        c(context);
    }
}
