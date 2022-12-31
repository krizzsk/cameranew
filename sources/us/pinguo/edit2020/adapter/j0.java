package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.entity.Material;
/* compiled from: MaterialCategoryAdapter.kt */
/* loaded from: classes4.dex */
public final class j0 extends RecyclerView.Adapter<a> {
    private List<? extends Material> a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private b f10133d;

    /* compiled from: MaterialCategoryAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: MaterialCategoryAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, Material material);
    }

    public j0(List<? extends Material> materialCategories) {
        kotlin.jvm.internal.s.h(materialCategories, "materialCategories");
        this.b = -1;
        this.a = materialCategories;
        for (Material material : materialCategories) {
            ObservableBoolean isSelected = material.isSelected();
            boolean z = false;
            if (isSelected != null && isSelected.get()) {
                z = true;
                continue;
            }
            if (z) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(j0 this$0, int i2, a holder, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        this$0.b = i2;
        b bVar = this$0.f10133d;
        if (bVar != null) {
            bVar.a(holder.itemView, i2, this$0.a.get(i2));
        }
        this$0.c = i2;
    }

    public final List<Material> e() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(final a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 < 0) {
            return;
        }
        us.pinguo.edit2020.databinding.g gVar = (us.pinguo.edit2020.databinding.g) DataBindingUtil.findBinding(holder.itemView);
        if (gVar != null) {
            gVar.a(this.a.get(i2));
        }
        us.pinguo.edit2020.databinding.g gVar2 = (us.pinguo.edit2020.databinding.g) DataBindingUtil.findBinding(holder.itemView);
        if (gVar2 != null) {
            gVar2.b(Integer.valueOf(i2));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.h(j0.this, i2, holder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View root = ((us.pinguo.edit2020.databinding.g) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_material_category, parent, false)).getRoot();
        kotlin.jvm.internal.s.g(root, "inflate<ItemMaterialCate…gory, parent, false).root");
        return new a(root);
    }

    public final void j(List<? extends Material> list) {
        if (list == null) {
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public final void k(b bVar) {
        this.f10133d = bVar;
    }
}
