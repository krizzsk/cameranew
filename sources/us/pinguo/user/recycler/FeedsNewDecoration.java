package us.pinguo.user.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.R;
/* loaded from: classes6.dex */
public class FeedsNewDecoration extends b {
    private int b;
    private Drawable c;

    /* renamed from: d  reason: collision with root package name */
    protected Drawable f12370d;

    /* renamed from: e  reason: collision with root package name */
    protected Drawable f12371e;

    /* renamed from: f  reason: collision with root package name */
    protected int f12372f;

    public FeedsNewDecoration(Context context) {
        this.f12372f = context.getResources().getDimensionPixelSize(R.dimen.feeds_shadow_height);
        this.b = context.getResources().getDimensionPixelSize(R.dimen.feeds_divider_height);
        this.c = new ColorDrawable(context.getResources().getColor(R.color.portal_page_bg));
        try {
            this.f12370d = context.getResources().getDrawable(us.pinguo.ui.R.drawable.feeds_divider_shadow_top);
            this.f12371e = context.getResources().getDrawable(us.pinguo.ui.R.drawable.feeds_divider_shadow_bottom);
        } catch (OutOfMemoryError unused) {
        }
        i(this.b);
    }

    private void drawShdow(Canvas canvas, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Drawable drawable = this.f12370d;
        if (drawable == null || this.f12371e == null) {
            return;
        }
        if (z) {
            drawable.setBounds(i2, i3, i4, this.f12372f + i3);
            this.f12370d.draw(canvas);
        }
        if (z2) {
            this.f12371e.setBounds(i2, i5 - this.f12372f, i3, i5);
            this.f12371e.draw(canvas);
        }
    }

    private void j(Canvas canvas, int i2, int i3, int i4, int i5) {
        this.c.setBounds(i2, i3, i4, i5);
        this.c.draw(canvas);
    }

    public static void k(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int left = recyclerView.getLeft();
        int right = recyclerView.getRight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        ColorDrawable colorDrawable = new ColorDrawable(recyclerView.getResources().getColor(R.color.portal_page_bg));
        if (rect.top > 0) {
            int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + Math.round(ViewCompat.getTranslationY(view));
            colorDrawable.setBounds(left, top - rect.top, right, top);
            colorDrawable.draw(canvas);
        }
        if (rect.bottom > 0) {
            int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + Math.round(ViewCompat.getTranslationY(view));
            colorDrawable.setBounds(left, bottom, right, rect.bottom + bottom);
            colorDrawable.draw(canvas);
        }
    }

    @Override // us.pinguo.user.recycler.b
    protected void a(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int left = recyclerView.getLeft();
        int right = recyclerView.getRight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (rect.top > 0) {
            int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + Math.round(ViewCompat.getTranslationY(view));
            int i2 = top - rect.top;
            this.c.setBounds(left, i2, right, top);
            this.c.draw(canvas);
            drawShdow(canvas, left, i2, right, top, true, true);
        }
        if (rect.bottom > 0) {
            int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + Math.round(ViewCompat.getTranslationY(view));
            int i3 = bottom + rect.bottom;
            this.c.setBounds(left, bottom, right, i3);
            this.c.draw(canvas);
            drawShdow(canvas, left, bottom, right, i3, true, false);
        }
    }

    @Override // us.pinguo.user.recycler.b
    protected void b(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int left = recyclerView.getLeft();
        int right = recyclerView.getRight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (rect.top > 0) {
            int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + Math.round(ViewCompat.getTranslationY(view));
            int i2 = top - rect.top;
            this.c.setBounds(left, i2, right, top);
            this.c.draw(canvas);
            drawShdow(canvas, left, i2, right, top, false, true);
        }
        if (rect.bottom > 0) {
            int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + Math.round(ViewCompat.getTranslationY(view));
            int i3 = bottom + rect.bottom;
            this.c.setBounds(left, bottom, right, i3);
            this.c.draw(canvas);
            drawShdow(canvas, left, bottom, right, i3, true, false);
        }
    }

    @Override // us.pinguo.user.recycler.b
    protected void c(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int left = recyclerView.getLeft();
        int right = recyclerView.getRight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (rect.top > 0) {
            int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + Math.round(ViewCompat.getTranslationY(view));
            int i2 = top - rect.top;
            this.c.setBounds(left, i2, right, top);
            this.c.draw(canvas);
            drawShdow(canvas, left, i2, right, top, false, true);
        }
        if (rect.bottom > 0) {
            int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + Math.round(ViewCompat.getTranslationY(view));
            int i3 = bottom + rect.bottom;
            this.c.setBounds(left, bottom, right, i3);
            this.c.draw(canvas);
            drawShdow(canvas, left, bottom, right, i3, true, false);
        }
    }

    @Override // us.pinguo.user.recycler.b
    protected void d(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int left = recyclerView.getLeft();
        int right = recyclerView.getRight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (rect.top > 0) {
            int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + Math.round(ViewCompat.getTranslationY(view));
            int i2 = top - rect.top;
            this.c.setBounds(left, i2, right, top);
            this.c.draw(canvas);
            drawShdow(canvas, left, i2, right, top, true, true);
        }
        if (rect.bottom > 0) {
            int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + Math.round(ViewCompat.getTranslationY(view));
            int i3 = bottom + rect.bottom;
            this.c.setBounds(left, bottom, right, i3);
            this.c.draw(canvas);
            drawShdow(canvas, left, bottom, right, i3, true, true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        if (recyclerView.getChildCount() > 0) {
            View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
            if (childAt.getBottom() < recyclerView.getHeight()) {
                us.pinguo.widget.common.cell.recycler.b item = ((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(recyclerView.getChildAdapterPosition(childAt));
                Rect decorationRect = item == null ? null : item.getDecorationRect();
                j(canvas, 0, childAt.getBottom() + (decorationRect == null ? this.f12372f : Math.min(decorationRect.bottom, this.f12372f)), recyclerView.getWidth(), recyclerView.getHeight());
                return;
            }
            return;
        }
        j(canvas, 0, 0, recyclerView.getWidth(), recyclerView.getHeight());
    }
}
