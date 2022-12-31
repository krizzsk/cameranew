package us.pinguo.edit2020.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Iterator;
import java.util.List;
import us.pinguo.edit2020.R;
/* compiled from: ImageRestorationAdapter.kt */
/* loaded from: classes4.dex */
public final class g0 extends RecyclerView.Adapter<a> {
    private List<us.pinguo.edit2020.bean.z> a;
    private ImageRestorationAdapter$Companion$MaterialType b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private b f10130d;

    /* compiled from: ImageRestorationAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: ImageRestorationAdapter.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, us.pinguo.edit2020.bean.z zVar);
    }

    public g0(List<us.pinguo.edit2020.bean.z> list) {
        ImageRestorationAdapter$Companion$MaterialType imageRestorationAdapter$Companion$MaterialType = ImageRestorationAdapter$Companion$MaterialType.COMMON;
        this.b = imageRestorationAdapter$Companion$MaterialType;
        this.a = list;
        this.b = imageRestorationAdapter$Companion$MaterialType;
        int i2 = 0;
        if (list != null) {
            Iterator<us.pinguo.edit2020.bean.z> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (it.next().b()) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(g0 this$0, int i2, a holder, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        List<us.pinguo.edit2020.bean.z> list = this$0.a;
        us.pinguo.edit2020.bean.z zVar = list == null ? null : list.get(i2);
        if (zVar != null) {
            zVar.c(true);
        }
        b bVar = this$0.f10130d;
        if (bVar != null) {
            bVar.a(holder.itemView, i2, zVar);
        }
        List<us.pinguo.edit2020.bean.z> list2 = this$0.a;
        us.pinguo.edit2020.bean.z zVar2 = list2 != null ? list2.get(this$0.c) : null;
        if (zVar2 != null) {
            zVar2.c(false);
        }
        this$0.notifyItemChanged(this$0.c);
        this$0.c = i2;
        this$0.notifyItemChanged(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(final a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 < 0) {
            return;
        }
        List<us.pinguo.edit2020.bean.z> list = this.a;
        us.pinguo.edit2020.bean.z zVar = list == null ? null : list.get(i2);
        if (zVar != null) {
            Bitmap a2 = zVar.a();
            if (a2 != null) {
                ((SimpleDraweeView) holder.itemView.findViewById(R.id.ivFace)).setImageBitmap(a2);
            }
            View findViewById = holder.itemView.findViewById(R.id.vMaskSelected);
            kotlin.jvm.internal.s.g(findViewById, "holder.itemView.vMaskSelected");
            int i3 = zVar.b() ? 0 : 8;
            findViewById.setVisibility(i3);
            VdsAgent.onSetViewVisibility(findViewById, i3);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g0.g(g0.this, i2, holder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<us.pinguo.edit2020.bean.z> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_restoration, parent, false);
        kotlin.jvm.internal.s.g(itemView, "itemView");
        return new a(itemView);
    }

    public final void i() {
        Bitmap a2;
        List<us.pinguo.edit2020.bean.z> list = this.a;
        if (list == null) {
            return;
        }
        for (us.pinguo.edit2020.bean.z zVar : list) {
            Bitmap a3 = zVar.a();
            boolean z = false;
            if (a3 != null && a3.isRecycled()) {
                z = true;
            }
            if (!z && (a2 = zVar.a()) != null) {
                a2.recycle();
            }
        }
    }

    public final void j(b onMaterialItemClick) {
        kotlin.jvm.internal.s.h(onMaterialItemClick, "onMaterialItemClick");
        this.f10130d = onMaterialItemClick;
    }
}
