package us.pinguo.edit2020.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: ScrollableTextListView.kt */
/* loaded from: classes4.dex */
public final class o0 extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(outRect, "outRect");
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = us.pinguo.common.widget.i.a.a(12);
        outRect.right = us.pinguo.common.widget.i.a.a(12);
    }
}
