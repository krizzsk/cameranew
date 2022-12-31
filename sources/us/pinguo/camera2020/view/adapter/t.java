package us.pinguo.camera2020.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedList;
import java.util.List;
import us.pinguo.camera2020.R;
import us.pinguo.repository2020.database.sticker.Sticker;
/* compiled from: StickerManageAdapter.kt */
/* loaded from: classes3.dex */
public final class t extends RecyclerView.Adapter<b> {
    private List<Sticker> a;
    private final LinkedList<Integer> b = new LinkedList<>();
    private a c;

    /* compiled from: StickerManageAdapter.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar, int i2, String str);
    }

    /* compiled from: StickerManageAdapter.kt */
    /* loaded from: classes3.dex */
    public final class b extends RecyclerView.ViewHolder {
        private final SimpleDraweeView a;
        private final ImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t this$0, View viewItem) {
            super(viewItem);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(viewItem, "viewItem");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewItem.findViewById(R.id.imgIcon);
            kotlin.jvm.internal.s.g(simpleDraweeView, "viewItem.imgIcon");
            this.a = simpleDraweeView;
            ImageView imageView = (ImageView) viewItem.findViewById(R.id.imgVipIconInManagement);
            kotlin.jvm.internal.s.g(imageView, "viewItem.imgVipIconInManagement");
            this.b = imageView;
        }

        public final SimpleDraweeView a() {
            return this.a;
        }

        public final ImageView b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(t this$0, b holder, int i2, Sticker sticker, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(sticker, "$sticker");
        a aVar = this$0.c;
        if (aVar == null) {
            return;
        }
        aVar.a(holder, i2, sticker.getPid());
    }

    public final List<Sticker> e() {
        return this.a;
    }

    public final LinkedList<Integer> f() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Sticker> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(final b holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        List<Sticker> list = this.a;
        final Sticker sticker = list == null ? null : list.get(i2);
        if (sticker == null) {
            return;
        }
        holder.a().setImageURI(sticker.getIcon());
        ImageView b2 = holder.b();
        int i3 = sticker.isVip() ? 0 : 8;
        b2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(b2, i3);
        holder.itemView.setBackgroundResource(this.b.contains(Integer.valueOf(i2)) ? R.drawable.sticker_item_selection_dark : 0);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.i(t.this, holder, i2, sticker, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public b onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sticker_manage_grid_item, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…grid_item, parent, false)");
        return new b(this, inflate);
    }

    public final void k(a aVar) {
        this.c = aVar;
    }

    public final void l(List<Sticker> list) {
        this.a = list;
    }
}
