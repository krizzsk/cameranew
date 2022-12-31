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
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
/* compiled from: BackgroundBlurMaterialAdapter.kt */
/* loaded from: classes4.dex */
public final class t extends RecyclerView.Adapter<a> {
    private List<? extends BackgroundBlurMaterial> a;
    private BackgroundBlurMaterialAdapter$Companion$MaterialType b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private b f10145d;

    /* compiled from: BackgroundBlurMaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: BackgroundBlurMaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, BackgroundBlurMaterial backgroundBlurMaterial);
    }

    /* compiled from: BackgroundBlurMaterialAdapter.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BackgroundBlurMaterialAdapter$Companion$MaterialType.values().length];
            iArr[BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR.ordinal()] = 1;
            iArr[BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR_SHAPE.ordinal()] = 2;
            a = iArr;
        }
    }

    public t(List<? extends BackgroundBlurMaterial> list, BackgroundBlurMaterialAdapter$Companion$MaterialType materialType) {
        kotlin.jvm.internal.s.h(materialType, "materialType");
        this.b = BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR;
        this.a = list;
        this.b = materialType;
        if (list == null) {
            return;
        }
        for (BackgroundBlurMaterial backgroundBlurMaterial : list) {
            ObservableBoolean isSelected = backgroundBlurMaterial.isSelected();
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
    public static final void g(t this$0, a holder, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        b bVar = this$0.f10145d;
        if (bVar != null) {
            View view2 = holder.itemView;
            List<? extends BackgroundBlurMaterial> list = this$0.a;
            bVar.a(view2, i2, list == null ? null : list.get(i2));
        }
        this$0.c = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(final a holder, final int i2) {
        us.pinguo.edit2020.databinding.c cVar;
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 < 0) {
            return;
        }
        List<? extends BackgroundBlurMaterial> list = this.a;
        BackgroundBlurMaterial backgroundBlurMaterial = list == null ? null : list.get(i2);
        BackgroundBlurMaterialAdapter$Companion$MaterialType backgroundBlurMaterialAdapter$Companion$MaterialType = this.b;
        if (backgroundBlurMaterialAdapter$Companion$MaterialType == BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR && (backgroundBlurMaterial instanceof BackgroundBlur)) {
            us.pinguo.edit2020.databinding.a aVar = (us.pinguo.edit2020.databinding.a) DataBindingUtil.findBinding(holder.itemView);
            if (aVar != null) {
                aVar.a((BackgroundBlur) backgroundBlurMaterial);
            }
        } else if (backgroundBlurMaterialAdapter$Companion$MaterialType == BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR_SHAPE && (cVar = (us.pinguo.edit2020.databinding.c) DataBindingUtil.findBinding(holder.itemView)) != null) {
            cVar.a(backgroundBlurMaterial);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.g(t.this, holder, i2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends BackgroundBlurMaterial> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        View root;
        kotlin.jvm.internal.s.h(parent, "parent");
        int i3 = c.a[this.b.ordinal()];
        if (i3 == 1) {
            root = ((us.pinguo.edit2020.databinding.a) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_background_blur_lens, parent, false)).getRoot();
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            root = ((us.pinguo.edit2020.databinding.c) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_background_blur_shape, parent, false)).getRoot();
        }
        kotlin.jvm.internal.s.g(root, "when (materialType) {\n  … ).root\n                }");
        return new a(root);
    }

    public final void i(List<? extends BackgroundBlurMaterial> list) {
        if (list == null) {
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public final void j(b bVar) {
        this.f10145d = bVar;
    }
}
