package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
/* compiled from: BackgroundTemplateDecoration.kt */
/* loaded from: classes4.dex */
public final class v extends RecyclerView.ItemDecoration {
    private final Rect a = new Rect();
    private final Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f10153d;

    /* renamed from: e  reason: collision with root package name */
    private float f10154e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10155f;

    /* renamed from: g  reason: collision with root package name */
    private List<Integer> f10156g;

    public v() {
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = -1;
        paint.setStrokeWidth(this.f10154e);
        paint.setColor(this.c);
    }

    public final void a(int i2) {
        this.c = i2;
        this.b.setColor(i2);
    }

    public final void b(float f2) {
        this.f10153d = f2;
    }

    public final void c(List<Integer> list) {
        this.f10156g = list;
    }

    public final void d(float f2) {
        this.f10154e = f2;
        this.b.setStrokeWidth(f2);
    }

    public final void e(boolean z) {
        this.f10155f = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(outRect, "outRect");
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null || adapter.getItemCount() == 0) {
            return;
        }
        Context context = parent.getContext();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
        kotlin.jvm.internal.s.g(context, "context");
        int a = us.pinguo.util.g.a(context, 12.0f);
        outRect.top = a;
        outRect.bottom = a;
        boolean z = false;
        if (viewLayoutPosition == 0) {
            outRect.left = us.pinguo.util.g.a(context, 16.0f);
        } else {
            List<Integer> list = this.f10156g;
            if (list != null && list.contains(Integer.valueOf(viewLayoutPosition + (-1)))) {
                outRect.left = us.pinguo.util.g.a(context, 12.0f);
            } else {
                outRect.left = us.pinguo.util.g.a(context, 2.0f);
            }
        }
        if (viewLayoutPosition + 1 == adapter.getItemCount()) {
            outRect.right = us.pinguo.util.g.a(context, 16.0f);
            return;
        }
        List<Integer> list2 = this.f10156g;
        if (list2 != null && list2.contains(Integer.valueOf(viewLayoutPosition))) {
            z = true;
        }
        if (z) {
            outRect.right = us.pinguo.util.g.a(context, 12.0f);
        } else {
            outRect.right = us.pinguo.util.g.a(context, 2.0f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int b;
        kotlin.jvm.internal.s.h(c, "c");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        super.onDrawOver(c, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager != null && this.f10155f) {
            for (View view : ViewGroupKt.getChildren(parent)) {
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                List<Integer> list = this.f10156g;
                boolean z = false;
                if (list != null && list.contains(Integer.valueOf(childAdapterPosition))) {
                    z = true;
                }
                if (z) {
                    layoutManager.getDecoratedBoundsWithMargins(view, this.a);
                    int i2 = this.a.right;
                    b = kotlin.y.c.b(view.getTranslationX());
                    float f2 = i2 + b;
                    float f3 = f2 - this.f10154e;
                    float f4 = f3 + ((f2 - f3) * 0.5f);
                    float f5 = 2;
                    c.drawLine(f4, (parent.getHeight() - this.f10153d) / f5, f4, (parent.getHeight() + this.f10153d) / f5, this.b);
                }
            }
        }
    }
}
