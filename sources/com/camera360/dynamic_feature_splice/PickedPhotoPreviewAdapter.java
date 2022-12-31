package com.camera360.dynamic_feature_splice;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.picker.image.PickItem;
import us.pinguo.ui.uilview.AlphaImageView;
/* compiled from: PickedPhotoPreviewAdapter.kt */
/* loaded from: classes8.dex */
public final class PickedPhotoPreviewAdapter extends RecyclerView.Adapter<a> {
    private kotlin.jvm.b.p<? super Integer, ? super PickItem, kotlin.u> b;
    private ArrayList<PickItem> a = new ArrayList<>();
    private final Handler c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private boolean f2153d = true;

    /* compiled from: PickedPhotoPreviewAdapter.kt */
    /* loaded from: classes8.dex */
    public final class a extends RecyclerView.ViewHolder implements us.pinguo.picker.image.b {
        private ImageView a;
        private AlphaImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PickedPhotoPreviewAdapter this$0, View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(itemView, "itemView");
            this.a = (ImageView) itemView.findViewById(R.id.img_main_content);
            this.b = (AlphaImageView) itemView.findViewById(R.id.img_cancel_pick);
        }

        public final AlphaImageView a() {
            return this.b;
        }

        public final ImageView b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(PickedPhotoPreviewAdapter this$0, int i2, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.b.p<? super Integer, ? super PickItem, kotlin.u> pVar = this$0.b;
        if (pVar == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(i2), this$0.i(i2));
    }

    public final void f(PickItem image) {
        kotlin.jvm.internal.s.h(image, "image");
        this.a.add(image);
        notifyItemInserted(this.a.size() - 1);
        notifyItemRangeChanged(this.a.size() - 1, 1);
    }

    public final void g() {
        this.a.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public final PickItem h(String path) {
        kotlin.jvm.internal.s.h(path, "path");
        Iterator<PickItem> it = this.a.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (kotlin.jvm.internal.s.c(path, it.next().path)) {
                break;
            } else {
                i2++;
            }
        }
        return i(i2);
    }

    public final PickItem i(int i2) {
        PickItem remove = this.a.remove(i2);
        kotlin.jvm.internal.s.g(remove, "mData.removeAt(index)");
        PickItem pickItem = remove;
        notifyItemRemoved(i2);
        if (this.a.size() == 0) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeChanged(i2, this.a.size() - i2);
        }
        return pickItem;
    }

    public final boolean j() {
        return this.f2153d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        AlphaImageView a2 = holder.a();
        if (a2 != null) {
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickedPhotoPreviewAdapter.m(PickedPhotoPreviewAdapter.this, i2, view);
                }
            });
        }
        PickItem pickItem = this.a.get(i2);
        kotlin.jvm.internal.s.g(pickItem, "mData[position]");
        PickItem pickItem2 = pickItem;
        us.pinguo.picker.image.g gVar = us.pinguo.picker.image.g.a;
        String str = pickItem2.path;
        kotlin.jvm.internal.s.g(str, "item.path");
        gVar.e(holder, str, pickItem2.ori, new PickedPhotoPreviewAdapter$onBindViewHolder$2(this, holder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(vStudio.Android.Camera360.R.layout.picked_item_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…em_layout, parent, false)");
        return new a(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onViewRecycled(a holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        us.pinguo.picker.image.g.a.c(holder);
    }

    public final void p(ArrayList<PickItem> list) {
        kotlin.jvm.internal.s.h(list, "list");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public final void q(boolean z) {
        this.f2153d = z;
    }

    public final void r(kotlin.jvm.b.p<? super Integer, ? super PickItem, kotlin.u> callback) {
        kotlin.jvm.internal.s.h(callback, "callback");
        this.b = callback;
    }
}
