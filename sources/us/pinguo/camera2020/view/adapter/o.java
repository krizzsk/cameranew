package us.pinguo.camera2020.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import us.pinguo.camera2020.R;
/* compiled from: InfiniteRecyclerViewAdapter.kt */
/* loaded from: classes3.dex */
public final class o extends RecyclerView.Adapter<p> {
    private final ArrayList<w> a;

    public o(ArrayList<w> data) {
        kotlin.jvm.internal.s.h(data, "data");
        ArrayList<w> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.addAll(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(p holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        ArrayList<w> arrayList = this.a;
        w wVar = arrayList.get(i2 % arrayList.size());
        kotlin.jvm.internal.s.g(wVar, "dataList[position % dataList.size]");
        w wVar2 = wVar;
        holder.b().setText(wVar2.b());
        holder.a().setActualImageResource(wVar2.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public p onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vip_half_screen_banner_item_layout, parent, false);
        kotlin.jvm.internal.s.g(itemView, "itemView");
        return new p(itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
