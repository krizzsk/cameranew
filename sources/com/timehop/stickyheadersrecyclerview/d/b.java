package com.timehop.stickyheadersrecyclerview.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: HeaderViewCache.java */
/* loaded from: classes3.dex */
public class b implements a {
    private final com.timehop.stickyheadersrecyclerview.b a;
    private final LongSparseArray<View> b = new LongSparseArray<>();
    private final com.timehop.stickyheadersrecyclerview.g.b c;

    public b(com.timehop.stickyheadersrecyclerview.b bVar, com.timehop.stickyheadersrecyclerview.g.b bVar2) {
        this.a = bVar;
        this.c = bVar2;
    }

    @Override // com.timehop.stickyheadersrecyclerview.d.a
    public View a(RecyclerView recyclerView, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        long c = this.a.c(i2);
        View view = this.b.get(c);
        if (view == null) {
            RecyclerView.ViewHolder a = this.a.a(recyclerView);
            this.a.b(a, i2);
            view = a.itemView;
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            if (this.c.a(recyclerView) == 1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 0);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
            }
            view.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.b.put(c, view);
        }
        return view;
    }
}
