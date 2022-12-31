package us.pinguo.common.recycler.a;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: BaseRecyclerViewHolder.kt */
/* loaded from: classes4.dex */
public class d extends RecyclerView.ViewHolder {
    private a a;

    /* compiled from: BaseRecyclerViewHolder.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void onViewRecycled();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View itemView) {
        super(itemView);
        s.h(itemView, "itemView");
        new SparseArray();
    }

    public final void a() {
        a aVar = this.a;
        if (aVar != null) {
            s.e(aVar);
            aVar.onViewRecycled();
            this.a = null;
        }
    }

    public final void b(a listener) {
        s.h(listener, "listener");
        this.a = listener;
    }
}
