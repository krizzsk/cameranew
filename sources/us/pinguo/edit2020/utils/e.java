package us.pinguo.edit2020.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: GridSpaceItemDecoration.kt */
/* loaded from: classes4.dex */
public final class e extends RecyclerView.ItemDecoration {
    private final int a;
    private final boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10577d;

    /* renamed from: e  reason: collision with root package name */
    private int f10578e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final int f10579f = -1;

    public e(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    public final e a(int i2) {
        this.f10578e = i2;
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int i2;
        int i3;
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        int itemCount = state.getItemCount() - 1;
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (this.f10577d > childAdapterPosition || childAdapterPosition > itemCount - this.f10578e) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanCount = gridLayoutManager.getSpanCount();
            int spanSize = spanSizeLookup.getSpanSize(childAdapterPosition);
            this.c = spanCount / spanSize;
            i3 = spanSizeLookup.getSpanIndex(childAdapterPosition, spanCount) / spanSize;
            i2 = spanSizeLookup.getSpanGroupIndex(childAdapterPosition, spanCount) - this.f10577d;
        } else {
            i2 = -1;
            i3 = 0;
        }
        int i4 = childAdapterPosition - this.f10577d;
        if (this.b) {
            int i5 = this.a;
            int i6 = this.c;
            outRect.left = i5 - ((i3 * i5) / i6);
            outRect.right = ((i3 + 1) * i5) / i6;
            if (i2 <= -1) {
                int i7 = this.f10579f;
                if ((i7 == -1 || i4 < i7) && i4 < i6) {
                    outRect.top = i5;
                }
            } else if (i2 < 1 && i4 < i6) {
                outRect.top = i5;
            }
            outRect.bottom = i5;
            return;
        }
        int i8 = this.a;
        int i9 = this.c;
        outRect.left = (i3 * i8) / i9;
        outRect.right = i8 - (((i3 + 1) * i8) / i9);
        if (i2 > -1) {
            if (i2 >= 1) {
                outRect.top = i8;
                return;
            }
            return;
        }
        if (i4 < i9 && (this.f10579f == -1 || i4 == 0)) {
            r0 = false;
        }
        if (r0) {
            outRect.top = i8;
        }
    }
}
