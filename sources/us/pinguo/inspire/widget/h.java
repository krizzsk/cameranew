package us.pinguo.inspire.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: GridSpacingItemDecoration.kt */
/* loaded from: classes9.dex */
public final class h extends RecyclerView.ItemDecoration {
    private final int a;
    private final int b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11360d;

    public h(int i2, int i3, boolean z, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = z;
        this.f11360d = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int i2;
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view) - this.f11360d;
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (childAdapterPosition >= 0) {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                i2 = ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
            } else {
                i2 = childAdapterPosition % this.a;
            }
            if (this.c) {
                int i3 = this.b;
                int i4 = this.a;
                outRect.left = i3 - ((i2 * i3) / i4);
                outRect.right = ((i2 + 1) * i3) / i4;
                if (childAdapterPosition < i4) {
                    outRect.top = i3;
                }
                outRect.bottom = i3;
                return;
            }
            int i5 = this.b;
            int i6 = this.a;
            outRect.left = (i2 * i5) / i6;
            outRect.right = i5 - (((i2 + 1) * i5) / i6);
            if (childAdapterPosition >= i6) {
                outRect.top = i5;
                return;
            }
            return;
        }
        outRect.left = 0;
        outRect.right = 0;
        outRect.top = 0;
        outRect.bottom = 0;
    }
}
