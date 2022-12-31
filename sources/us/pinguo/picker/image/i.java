package us.pinguo.picker.image;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: SpliceDecoration.kt */
/* loaded from: classes5.dex */
public final class i extends RecyclerView.ItemDecoration {
    private final int a;

    public i(int i2) {
        this.a = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        int i2 = this.a;
        outRect.set(i2, i2, i2, i2);
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = 0;
        }
    }
}
