package us.pinguo.common.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: FunctionsCommonDecoration.kt */
/* loaded from: classes4.dex */
public final class g extends RecyclerView.ItemDecoration {
    private int a;
    private int b;

    public final void a(Context context, int i2, int i3) {
        s.h(context, "context");
        int i4 = us.pinguo.util.h.i(context);
        if (i2 == 1) {
            int i5 = (i4 - i3) / 2;
            this.a = i5;
            this.b = i5;
        } else if (i2 == 2) {
            int i6 = (i4 - (i3 * 2)) / 3;
            this.a = i6;
            this.b = i6 / 2;
        } else if (i2 == 3) {
            int i7 = (i4 - (i3 * 3)) / 6;
            this.a = i7;
            this.b = i7;
        } else if (i2 == 4) {
            int i8 = (i4 - (i3 * 4)) / 8;
            this.a = i8;
            this.b = i8;
        } else if (i2 == 5) {
            int i9 = (i4 - (i3 * 5)) / 10;
            this.a = i9;
            this.b = i9;
        } else if (i2 > 5) {
            int i10 = (int) ((i4 - (i3 * 5.5f)) / 11.0f);
            this.a = i10;
            this.b = i10;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
        if (viewLayoutPosition == 0) {
            outRect.left = this.a;
            outRect.right = this.b;
        } else if (viewLayoutPosition == adapter.getItemCount() - 1) {
            outRect.left = this.b;
            outRect.right = this.a;
        } else {
            int i2 = this.b;
            outRect.left = i2;
            outRect.right = i2;
        }
        outRect.top = 0;
        outRect.bottom = 0;
    }
}
