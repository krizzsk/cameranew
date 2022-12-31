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
import us.pinguo.repository2020.entity.PaintMaterial;
/* compiled from: PaintMaterialAdapter.kt */
/* loaded from: classes4.dex */
public final class n0 extends RecyclerView.Adapter<a> {
    private List<PaintMaterial> a;
    private int b;
    private ObservableBoolean c;

    /* renamed from: d  reason: collision with root package name */
    private b f10138d;

    /* compiled from: PaintMaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: PaintMaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, PaintMaterial paintMaterial);
    }

    public n0(List<PaintMaterial> paintMaterialList) {
        kotlin.jvm.internal.s.h(paintMaterialList, "paintMaterialList");
        this.c = new ObservableBoolean(false);
        this.a = paintMaterialList;
        for (PaintMaterial paintMaterial : paintMaterialList) {
            ObservableBoolean isSelected = paintMaterial.isSelected();
            boolean z = true;
            if (isSelected == null || !isSelected.get()) {
                z = false;
                continue;
            }
            if (z) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(n0 this$0, a holder, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        b bVar = this$0.f10138d;
        if (bVar != null) {
            bVar.a(holder.itemView, i2, this$0.a.get(i2));
        }
        this$0.b = i2;
    }

    public final List<PaintMaterial> e() {
        return this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (((r0 == null || (r0 = r0.getPackages()) == null || !r0.containsAll(r7.a)) ? false : true) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00eb, code lost:
        if (r0 == true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ed, code lost:
        if (r5 == false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.adapter.n0.f():int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(final a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 < 0) {
            return;
        }
        this.a.get(i2).setDark(this.c);
        us.pinguo.edit2020.databinding.k kVar = (us.pinguo.edit2020.databinding.k) DataBindingUtil.findBinding(holder.itemView);
        if (kVar != null) {
            kVar.a(this.a.get(i2));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n0.i(n0.this, holder, i2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View root = ((us.pinguo.edit2020.databinding.k) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_paint_material, parent, false)).getRoot();
        kotlin.jvm.internal.s.g(root, "inflate<ItemPaintMateria…rial, parent, false).root");
        return new a(root);
    }

    public final void k(b onPaintMaterialItemClick) {
        kotlin.jvm.internal.s.h(onPaintMaterialItemClick, "onPaintMaterialItemClick");
        this.f10138d = onPaintMaterialItemClick;
    }
}
