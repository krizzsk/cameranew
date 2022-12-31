package us.pinguo.inspire.module.photomovie.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: PhotoMovieMusicLayout.kt */
/* loaded from: classes9.dex */
final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int space;

    public SpaceItemDecoration(int i2) {
        this.space = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        if (((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition() == 0) {
            int i2 = this.space;
            outRect.left = i2;
            outRect.right = i2;
            return;
        }
        outRect.right = this.space;
    }

    public final int getSpace() {
        return this.space;
    }
}
