package us.pinguo.camera2020.view.adapter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.utils.n0;
/* compiled from: RoundDividerItemDecoration.kt */
/* loaded from: classes3.dex */
public final class r extends RecyclerView.ItemDecoration {
    private final Paint a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9374d;

    public r() {
        Paint paint = new Paint();
        this.a = paint;
        this.c = -1;
        this.f9374d = -1;
        paint.setColor(us.pinguo.foundation.e.b().getResources().getColor(R.color.color_camera_theme_dark));
        paint.setStrokeWidth(n0.c(1));
    }

    public final boolean a() {
        return this.b;
    }

    public final int b() {
        return this.f9374d;
    }

    public final int c() {
        return this.c;
    }

    public final void d(boolean z) {
        this.b = z;
    }

    public final void e(int i2) {
        this.f9374d = i2;
    }

    public final void f(int i2) {
        this.c = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(outRect, "outRect");
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (this.b) {
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition != this.c && childAdapterPosition != this.f9374d) {
                outRect.right = 0;
            } else {
                outRect.right = n0.c(4);
            }
            if (childAdapterPosition != this.c + 1 && childAdapterPosition != this.f9374d + 1) {
                outRect.left = 0;
                return;
            } else {
                outRect.left = n0.c(4);
                return;
            }
        }
        outRect.left = 0;
        outRect.right = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(c, "c");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        super.onDrawOver(c, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        int i2 = 0;
        for (View view : ViewGroupKt.getChildren(parent)) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                View view2 = view;
                int childAdapterPosition = parent.getChildAdapterPosition(view2);
                if ((b() == childAdapterPosition || c() == childAdapterPosition) && a()) {
                    Rect rect = new Rect();
                    if (layoutManager != null) {
                        layoutManager.getDecoratedBoundsWithMargins(view2, rect);
                    }
                    c.drawCircle(rect.right, n0.c(35), n0.c(2), this.a);
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }
}
