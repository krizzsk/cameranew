package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import us.pinguo.edit2020.R;
/* compiled from: CircleColorListDecoration.kt */
/* loaded from: classes4.dex */
public final class y extends RecyclerView.ItemDecoration {
    private final int a;
    private int b;
    private int c;

    public y(int i2, int i3, int i4) {
        int i5;
        this.a = i4;
        Context context = us.pinguo.foundation.e.b();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hsl_color_item_size);
        this.b = (i2 - dimensionPixelSize) / 2;
        if (i4 > 1) {
            kotlin.jvm.internal.s.g(context, "context");
            i5 = ((us.pinguo.util.h.i(context) - (i3 * 2)) - (dimensionPixelSize * i4)) / ((i4 - 1) * 2);
        } else {
            kotlin.jvm.internal.s.g(context, "context");
            i5 = ((us.pinguo.util.h.i(context) - (i3 * 2)) - (i4 * dimensionPixelSize)) / 2;
        }
        this.c = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(outRect, "outRect");
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
        if (viewLayoutPosition == 0) {
            outRect.left = 0;
            outRect.right = this.c;
        } else if (viewLayoutPosition == this.a - 1) {
            outRect.left = this.c;
            outRect.right = 0;
        } else {
            int i2 = this.c;
            outRect.left = i2;
            outRect.right = i2;
        }
        int i3 = this.b;
        outRect.top = i3;
        outRect.bottom = i3;
    }
}
