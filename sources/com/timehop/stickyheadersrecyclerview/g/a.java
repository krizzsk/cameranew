package com.timehop.stickyheadersrecyclerview.g;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: LinearLayoutOrientationProvider.java */
/* loaded from: classes3.dex */
public class a implements b {
    private void c(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
        }
    }

    @Override // com.timehop.stickyheadersrecyclerview.g.b
    public int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        c(layoutManager);
        return ((LinearLayoutManager) layoutManager).getOrientation();
    }

    @Override // com.timehop.stickyheadersrecyclerview.g.b
    public boolean b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        c(layoutManager);
        return ((LinearLayoutManager) layoutManager).getReverseLayout();
    }
}
