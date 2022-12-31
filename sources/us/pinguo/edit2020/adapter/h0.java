package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.edit2020.R;
/* compiled from: ManualMattingAdapter.kt */
/* loaded from: classes4.dex */
public final class h0 extends a0<us.pinguo.edit2020.bean.c0> {
    @Override // us.pinguo.edit2020.adapter.a0, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public b0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manual_matting_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…           parent, false)");
        return new b0(inflate);
    }
}
