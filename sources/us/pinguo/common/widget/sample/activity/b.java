package us.pinguo.common.widget.sample.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.s;
import us.pinguo.common.widget.R;
/* compiled from: TestRecyclerAdapter.kt */
/* loaded from: classes4.dex */
public final class b extends RecyclerView.Adapter<c> {
    private ArrayList<a> a = new ArrayList<>();

    public final ArrayList<a> e() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(c holder, int i2) {
        s.h(holder, "holder");
        holder.a().setImageResource(this.a.get(i2).a());
        holder.b().setText(this.a.get(i2).b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public c onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recyclerview_item_layout, parent, false);
        s.g(inflate, "from(parent.context).inf…em_layout, parent, false)");
        return new c(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
