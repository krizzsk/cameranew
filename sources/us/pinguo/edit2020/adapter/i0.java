package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.widget.CollectAnimImageView;
import us.pinguo.repository2020.entity.Material;
/* compiled from: MaterialAdapter.kt */
/* loaded from: classes4.dex */
public final class i0 extends RecyclerView.Adapter<a> {
    private List<? extends Material> a;
    private MaterialAdapter$Companion$MaterialType b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private b f10132d;

    /* compiled from: MaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: MaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, Material material);

        void b(View view, int i2, Material material);
    }

    /* compiled from: MaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MaterialAdapter$Companion$MaterialType.values().length];
            iArr[MaterialAdapter$Companion$MaterialType.COMMON.ordinal()] = 1;
            iArr[MaterialAdapter$Companion$MaterialType.TEMPLATE.ordinal()] = 2;
            a = iArr;
        }
    }

    public i0(List<? extends Material> list, MaterialAdapter$Companion$MaterialType materialType) {
        kotlin.jvm.internal.s.h(materialType, "materialType");
        this.b = MaterialAdapter$Companion$MaterialType.COMMON;
        this.a = list;
        this.b = materialType;
        if (list == null) {
            return;
        }
        for (Material material : list) {
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
    public static final boolean i(Material material, a holder, i0 this$0, int i2, View view) {
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        boolean z = false;
        if (material != null && material.isInstalled()) {
            z = true;
        }
        if (z && !kotlin.jvm.internal.s.c(material.getPid(), Material.MATERIAL_SELECT_NONE_FLAG)) {
            if (material.isCollected().get()) {
                ((CollectAnimImageView) holder.itemView.findViewById(R.id.iconFavorite)).a();
            } else {
                ((CollectAnimImageView) holder.itemView.findViewById(R.id.iconFavorite)).e();
            }
            b bVar = this$0.f10132d;
            if (bVar != null) {
                bVar.b(holder.itemView, i2, material);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i0 this$0, a holder, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        b bVar = this$0.f10132d;
        if (bVar != null) {
            View view2 = holder.itemView;
            List<? extends Material> list = this$0.a;
            bVar.a(view2, i2, list == null ? null : list.get(i2));
        }
        this$0.c = i2;
    }

    public final List<Material> e() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends Material> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(final a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 < 0) {
            return;
        }
        MaterialAdapter$Companion$MaterialType materialAdapter$Companion$MaterialType = this.b;
        if (materialAdapter$Companion$MaterialType == MaterialAdapter$Companion$MaterialType.COMMON) {
            us.pinguo.edit2020.databinding.e eVar = (us.pinguo.edit2020.databinding.e) DataBindingUtil.findBinding(holder.itemView);
            if (eVar != null) {
                List<? extends Material> list = this.a;
                eVar.a(list != null ? list.get(i2) : null);
            }
        } else if (materialAdapter$Companion$MaterialType == MaterialAdapter$Companion$MaterialType.TEMPLATE) {
            List<? extends Material> list2 = this.a;
            final Material material = list2 != null ? list2.get(i2) : null;
            us.pinguo.edit2020.databinding.i iVar = (us.pinguo.edit2020.databinding.i) DataBindingUtil.findBinding(holder.itemView);
            if (iVar != null) {
                iVar.a(material);
            }
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: us.pinguo.edit2020.adapter.h
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean i3;
                    i3 = i0.i(Material.this, holder, this, i2, view);
                    return i3;
                }
            });
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i0.j(i0.this, holder, i2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        View root;
        kotlin.jvm.internal.s.h(parent, "parent");
        int i3 = c.a[this.b.ordinal()];
        if (i3 == 1) {
            root = ((us.pinguo.edit2020.databinding.e) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_material, parent, false)).getRoot();
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            root = ((us.pinguo.edit2020.databinding.i) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_material_template, parent, false)).getRoot();
        }
        kotlin.jvm.internal.s.g(root, "when (materialType) {\n  … ).root\n                }");
        return new a(root);
    }

    public final void l(List<? extends Material> list) {
        if (list == null) {
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public final void m(b onMaterialItemClick) {
        kotlin.jvm.internal.s.h(onMaterialItemClick, "onMaterialItemClick");
        this.f10132d = onMaterialItemClick;
    }
}
