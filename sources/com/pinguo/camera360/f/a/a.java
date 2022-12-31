package com.pinguo.camera360.f.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
/* compiled from: AbsRecycleAdapter.java */
/* loaded from: classes3.dex */
public abstract class a<T, K extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<K> {
    protected List<T> a;

    public void e(List<T> list) {
        List<T> list2 = this.a;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.a.addAll(list);
                return;
            }
            return;
        }
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
