package com.timehop.stickyheadersrecyclerview;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: HeaderPositionCalculator.java */
/* loaded from: classes3.dex */
public class a {
    private final b a;
    private final com.timehop.stickyheadersrecyclerview.g.b b;
    private final com.timehop.stickyheadersrecyclerview.d.a c;

    /* renamed from: d  reason: collision with root package name */
    private final com.timehop.stickyheadersrecyclerview.e.a f8312d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f8313e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f8314f = new Rect();

    public a(b bVar, com.timehop.stickyheadersrecyclerview.d.a aVar, com.timehop.stickyheadersrecyclerview.g.b bVar2, com.timehop.stickyheadersrecyclerview.e.a aVar2) {
        this.a = bVar;
        this.c = aVar;
        this.b = bVar2;
        this.f8312d = aVar2;
    }

    private View a(RecyclerView recyclerView, View view) {
        boolean b = this.b.b(recyclerView);
        int i2 = b ? -1 : 1;
        for (int childCount = b ? recyclerView.getChildCount() - 1 : 0; childCount >= 0 && childCount <= recyclerView.getChildCount() - 1; childCount += i2) {
            View childAt = recyclerView.getChildAt(childCount);
            if (!j(recyclerView, childAt, view, this.b.a(recyclerView))) {
                return childAt;
            }
        }
        return null;
    }

    private int b(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    private int c(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    private boolean f(int i2) {
        return i2 < 0 || i2 >= this.a.getItemCount();
    }

    private void g(Rect rect, RecyclerView recyclerView, View view, View view2, int i2) {
        int i3;
        int max;
        int i4;
        this.f8312d.b(this.f8313e, view);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        int i5 = 0;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i6 = marginLayoutParams.leftMargin;
            i5 = marginLayoutParams.topMargin;
            i3 = i6;
        } else {
            i3 = 0;
        }
        if (i2 == 1) {
            max = (view2.getLeft() - i3) + this.f8313e.left;
            i4 = Math.max(((view2.getTop() - i5) - view.getHeight()) - this.f8313e.bottom, c(recyclerView) + this.f8313e.top);
        } else {
            int top = (view2.getTop() - i5) + this.f8313e.top;
            max = Math.max(((view2.getLeft() - i3) - view.getWidth()) - this.f8313e.right, b(recyclerView) + this.f8313e.left);
            i4 = top;
        }
        rect.set(max, i4, view.getWidth() + max, view.getHeight() + i4);
    }

    private boolean i(RecyclerView recyclerView, View view) {
        View a = a(recyclerView, view);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(a);
        if (childAdapterPosition == -1) {
            return false;
        }
        boolean b = this.b.b(recyclerView);
        if (childAdapterPosition > 0 && d(childAdapterPosition, b)) {
            View a2 = this.c.a(recyclerView, childAdapterPosition);
            this.f8312d.b(this.f8313e, a2);
            this.f8312d.b(this.f8314f, view);
            if (this.b.a(recyclerView) == 1) {
                int top = ((a.getTop() - this.f8313e.bottom) - a2.getHeight()) - this.f8313e.top;
                int paddingTop = recyclerView.getPaddingTop() + view.getBottom();
                Rect rect = this.f8314f;
                if (top < paddingTop + rect.top + rect.bottom) {
                    return true;
                }
            } else {
                int left = ((a.getLeft() - this.f8313e.right) - a2.getWidth()) - this.f8313e.left;
                int paddingLeft = recyclerView.getPaddingLeft() + view.getRight();
                Rect rect2 = this.f8314f;
                if (left < paddingLeft + rect2.left + rect2.right) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean j(RecyclerView recyclerView, View view, View view2, int i2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.f8312d.b(this.f8313e, view2);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1 || this.c.a(recyclerView, childAdapterPosition) != view2) {
            return false;
        }
        if (i2 == 1) {
            int top = view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int bottom = view2.getBottom();
            Rect rect = this.f8313e;
            if (top > bottom + rect.bottom + rect.top) {
                return false;
            }
        } else {
            int left = view.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int right = view2.getRight();
            Rect rect2 = this.f8313e;
            if (left > right + rect2.right + rect2.left) {
                return false;
            }
        }
        return true;
    }

    private void k(RecyclerView recyclerView, int i2, Rect rect, View view, View view2, View view3) {
        this.f8312d.b(this.f8313e, view3);
        this.f8312d.b(this.f8314f, view);
        if (i2 == 1) {
            int c = c(recyclerView);
            Rect rect2 = this.f8314f;
            int i3 = c + rect2.top + rect2.bottom;
            int top = view2.getTop() - view3.getHeight();
            Rect rect3 = this.f8313e;
            int height = (((top - rect3.bottom) - rect3.top) - view.getHeight()) - i3;
            if (height < i3) {
                rect.top += height;
                return;
            }
            return;
        }
        int b = b(recyclerView);
        Rect rect4 = this.f8314f;
        int i4 = b + rect4.left + rect4.right;
        int left = view2.getLeft() - view3.getWidth();
        Rect rect5 = this.f8313e;
        int width = (((left - rect5.right) - rect5.left) - view.getWidth()) - i4;
        if (width < i4) {
            rect.left += width;
        }
    }

    public boolean d(int i2, boolean z) {
        if (f(i2)) {
            return false;
        }
        long c = this.a.c(i2);
        if (c < 0) {
            return false;
        }
        int i3 = (z ? 1 : -1) + i2;
        return i2 == (z ? this.a.getItemCount() - 1 : 0) || c != (f(i3) ? -1L : this.a.c(i3));
    }

    public boolean e(View view, int i2, int i3) {
        int left;
        int i4;
        this.f8312d.b(this.f8313e, view);
        if (i2 == 1) {
            left = view.getTop();
            i4 = this.f8313e.top;
        } else {
            left = view.getLeft();
            i4 = this.f8313e.left;
        }
        return left <= i4 && this.a.c(i3) >= 0;
    }

    public void h(Rect rect, RecyclerView recyclerView, View view, View view2, boolean z) {
        g(rect, recyclerView, view, view2, this.b.a(recyclerView));
        if (z && i(recyclerView, view)) {
            View a = a(recyclerView, view);
            k(recyclerView, this.b.a(recyclerView), rect, view, a, this.c.a(recyclerView, recyclerView.getChildAdapterPosition(a)));
        }
    }
}
