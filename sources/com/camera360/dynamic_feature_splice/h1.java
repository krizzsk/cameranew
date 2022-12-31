package com.camera360.dynamic_feature_splice;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: PreviewRecyclerDecoration.kt */
/* loaded from: classes8.dex */
public final class h1 extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(outRect, "outRect");
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = us.pinguo.foundation.t.b.a.a(parent.getContext(), 15.5f);
        } else {
            outRect.left = 0;
        }
        outRect.top = 0;
        outRect.right = 0;
        outRect.bottom = 0;
    }
}
