package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import java.util.Map;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable;
/* compiled from: StickerStoreListAdapter.kt */
/* loaded from: classes4.dex */
public final class r0 extends RecyclerView.Adapter<a> {
    private List<StaticStickerCategory> a;
    private Map<String, StaticStickerCategoryTable> b;
    private kotlin.jvm.b.l<? super StaticStickerCategory, kotlin.u> c;

    /* compiled from: StickerStoreListAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        private final TextView a;
        private final TextView b;
        private final ImageView c;

        /* renamed from: d  reason: collision with root package name */
        private final SimpleDraweeView f10144d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
            this.a = (TextView) itemView.findViewById(R.id.tvName);
            this.b = (TextView) itemView.findViewById(R.id.tvDesc);
            this.c = (ImageView) itemView.findViewById(R.id.ivVipImg);
            this.f10144d = (SimpleDraweeView) itemView.findViewById(R.id.ivCover);
        }

        public final SimpleDraweeView a() {
            return this.f10144d;
        }

        public final ImageView b() {
            return this.c;
        }

        public final TextView c() {
            return this.b;
        }

        public final TextView d() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(r0 this$0, StaticStickerCategory it, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "$it");
        kotlin.jvm.b.l<? super StaticStickerCategory, kotlin.u> lVar = this$0.c;
        if (lVar == null) {
            return;
        }
        lVar.invoke(it);
    }

    public final List<StaticStickerCategory> e() {
        return this.a;
    }

    public final Map<String, StaticStickerCategoryTable> f() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<StaticStickerCategory> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        List<StaticStickerCategory> list = this.a;
        String str = null;
        final StaticStickerCategory staticStickerCategory = list == null ? null : list.get(i2);
        if (staticStickerCategory == null) {
            return;
        }
        holder.d().setText(staticStickerCategory.getName());
        String store_icon = staticStickerCategory.getStore_icon();
        boolean z = true;
        if (store_icon == null || store_icon.length() == 0) {
            holder.a().setImageURI(staticStickerCategory.getIcon());
        } else {
            holder.a().setImageURI(staticStickerCategory.getStore_icon());
        }
        ImageView b = holder.b();
        kotlin.jvm.internal.s.g(b, "holder.ivVipImg");
        Integer vip = staticStickerCategory.getVip();
        int i3 = (vip == null || vip.intValue() != 0) ? false : false ? 4 : 0;
        b.setVisibility(i3);
        VdsAgent.onSetViewVisibility(b, i3);
        TextView c = holder.c();
        Map<String, StaticStickerCategoryTable> f2 = f();
        if (f2 != null) {
            String pid = staticStickerCategory.getPid();
            if (pid == null) {
                pid = "";
            }
            str = us.pinguo.edit2020.utils.h.a(f2, pid, staticStickerCategory.getVip());
        }
        c.setText(str);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.i(r0.this, staticStickerCategory, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sticker_store, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…ker_store, parent, false)");
        return new a(inflate);
    }

    public final void k(List<StaticStickerCategory> list) {
        this.a = list;
    }

    public final void l(Map<String, StaticStickerCategoryTable> map) {
        this.b = map;
    }

    public final void m(kotlin.jvm.b.l<? super StaticStickerCategory, kotlin.u> lVar) {
        this.c = lVar;
    }
}
