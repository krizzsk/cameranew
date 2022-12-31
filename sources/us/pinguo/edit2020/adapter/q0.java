package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.q0;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
/* compiled from: StickerManagementAdapter.kt */
/* loaded from: classes4.dex */
public final class q0 extends ListAdapter<StaticSticker, b> {
    private static final a b = new a();
    private final kotlin.jvm.b.p<String, Integer, kotlin.u> a;

    /* compiled from: StickerManagementAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends DiffUtil.ItemCallback<StaticSticker> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a */
        public boolean areContentsTheSame(StaticSticker oldItem, StaticSticker newItem) {
            kotlin.jvm.internal.s.h(oldItem, "oldItem");
            kotlin.jvm.internal.s.h(newItem, "newItem");
            return kotlin.jvm.internal.s.c(oldItem.getSid(), oldItem.getSid());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(StaticSticker oldItem, StaticSticker newItem) {
            kotlin.jvm.internal.s.h(oldItem, "oldItem");
            kotlin.jvm.internal.s.h(newItem, "newItem");
            return kotlin.jvm.internal.s.c(oldItem, newItem);
        }
    }

    /* compiled from: StickerManagementAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {
        private String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, final kotlin.jvm.b.p<? super String, ? super Integer, kotlin.u> onDeleteClick) {
            super(view);
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(onDeleteClick, "onDeleteClick");
            ((ImageView) this.itemView.findViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    q0.b.a(q0.b.this, onDeleteClick, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(b this$0, kotlin.jvm.b.p onDeleteClick, View view) {
            VdsAgent.lambdaOnClick(view);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(onDeleteClick, "$onDeleteClick");
            int adapterPosition = this$0.getAdapterPosition();
            if (adapterPosition == -1) {
                return;
            }
            String str = this$0.a;
            if (str == null) {
                str = "";
            }
            onDeleteClick.invoke(str, Integer.valueOf(adapterPosition));
        }

        public final void b(StaticSticker staticSticker) {
            kotlin.jvm.internal.s.h(staticSticker, "staticSticker");
            this.a = staticSticker.getSid();
            ((TextView) this.itemView.findViewById(R.id.tvName)).setText(staticSticker.getName());
            ((SimpleDraweeView) this.itemView.findViewById(R.id.ivCover)).setImageURI(staticSticker.getIcon());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public q0(kotlin.jvm.b.p<? super String, ? super Integer, kotlin.u> onDeleteClick) {
        super(b);
        kotlin.jvm.internal.s.h(onDeleteClick, "onDeleteClick");
        this.a = onDeleteClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(b holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        StaticSticker item = getItem(i2);
        if (item == null) {
            return;
        }
        holder.b(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public b onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sticker_management_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…rent, false\n            )");
        return new b(inflate, this.a);
    }

    public final void g(int i2) {
        List W;
        if (i2 < 0 || i2 >= getItemCount()) {
            return;
        }
        List<StaticSticker> currentList = getCurrentList();
        kotlin.jvm.internal.s.g(currentList, "currentList");
        W = kotlin.collections.c0.W(currentList);
        W.remove(i2);
        submitList(W);
    }
}
