package us.pinguo.camera360.shop.manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.camera360.shop.data.FilterType;
import vStudio.Android.Camera360.R;
/* compiled from: StoreFilterItemAdapter.kt */
/* loaded from: classes4.dex */
public final class u0 extends RecyclerView.Adapter<a> {
    private List<? extends us.pinguo.camera360.shop.data.g> a;
    private b b;

    /* compiled from: StoreFilterItemAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: StoreFilterItemAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a(us.pinguo.camera360.shop.data.g gVar, int i2);
    }

    public u0(List<? extends us.pinguo.camera360.shop.data.g> filterItems) {
        kotlin.jvm.internal.s.h(filterItems, "filterItems");
        this.a = filterItems;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(u0 this$0, us.pinguo.camera360.shop.data.g filter, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(filter, "$filter");
        b bVar = this$0.b;
        if (bVar == null) {
            return;
        }
        bVar.a(filter, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        final us.pinguo.camera360.shop.data.g gVar = this.a.get(i2);
        ((TextView) holder.itemView.findViewById(R.id.store_manager_item_order)).setText(String.valueOf(us.pinguo.camera360.shop.data.i.e().k(gVar.getPackageId(), new FilterType[0]).c(new FilterType[0]).indexOf(gVar) + 1));
        ((TextView) holder.itemView.findViewById(R.id.store_manager_item_text)).setText(gVar.getName());
        ((ImageView) holder.itemView.findViewById(R.id.store_manager_item_close)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u0.g(u0.this, gVar, i2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_manager_filter_item, parent, false);
        kotlin.jvm.internal.s.g(itemView, "itemView");
        return new a(itemView);
    }

    public final void i(List<? extends us.pinguo.camera360.shop.data.g> filterItems) {
        kotlin.jvm.internal.s.h(filterItems, "filterItems");
        this.a = filterItems;
    }

    public final void j(b bVar) {
        this.b = bVar;
    }
}
