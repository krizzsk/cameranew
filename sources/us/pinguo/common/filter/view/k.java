package us.pinguo.common.filter.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: EditFilterPackageDecoration.kt */
/* loaded from: classes4.dex */
public final class k extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        if (((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition() == 0) {
            outRect.left = us.pinguo.common.widget.i.a.a(16);
            outRect.right = 0;
            outRect.top = 0;
            outRect.bottom = 0;
        }
    }
}
