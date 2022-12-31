package us.pinguo.inspire.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: MaxHeightLayoutManager.kt */
/* loaded from: classes9.dex */
public final class MaxHeightLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightLayoutManager(Context context) {
        super(context);
        s.h(context, "context");
        us.pinguo.foundation.t.b.a.a(context, 360.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3) {
        s.h(recycler, "recycler");
        s.h(state, "state");
        super.onMeasure(recycler, state, i2, i3);
    }
}
