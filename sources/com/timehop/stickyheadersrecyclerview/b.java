package com.timehop.stickyheadersrecyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
/* compiled from: StickyRecyclerHeadersAdapter.java */
/* loaded from: classes3.dex */
public interface b<VH extends RecyclerView.ViewHolder> {
    VH a(ViewGroup viewGroup);

    void b(VH vh, int i2);

    long c(int i2);

    int getItemCount();
}
