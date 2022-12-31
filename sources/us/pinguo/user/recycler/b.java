package us.pinguo.user.recycler;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: LinearItemDecoration.java */
/* loaded from: classes6.dex */
public class b extends RecyclerView.ItemDecoration {
    private int a;

    private Rect e(Rect rect, Rect rect2) {
        return (rect2 == null || rect2.equals(rect)) ? rect : rect2;
    }

    protected void a(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        throw null;
    }

    protected void b(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        throw null;
    }

    protected void c(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        throw null;
    }

    protected void d(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        throw null;
    }

    protected Rect f(Rect rect, boolean z, boolean z2) {
        if (rect == null) {
            rect = new Rect();
        }
        if (z2 && z) {
            int i2 = this.a;
            rect.set(0, i2, 0, i2);
        } else if (z) {
            int i3 = this.a;
            rect.set(0, i3, 0, i3 / 2);
        } else if (z2) {
            int i4 = this.a;
            rect.set(0, i4 / 2, 0, i4);
        } else {
            int i5 = this.a;
            rect.set(0, i5 / 2, 0, i5 / 2);
        }
        return rect;
    }

    protected final boolean g(View view, RecyclerView recyclerView) {
        return recyclerView.getChildViewHolder(view).getAdapterPosition() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getAdapter() != null && (recyclerView.getAdapter() instanceof us.pinguo.widget.common.cell.recycler.a)) {
            if (recyclerView.getChildAdapterPosition(view) < 0) {
                return;
            }
            int adapterPosition = recyclerView.getChildViewHolder(view).getAdapterPosition();
            us.pinguo.widget.common.cell.recycler.b item = ((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(adapterPosition);
            Rect f2 = f(null, adapterPosition == 0, adapterPosition == recyclerView.getAdapter().getItemCount() - 1);
            if (item instanceof a) {
                if (!((a) item).setDecorationRect(((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(adapterPosition - 1), ((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(adapterPosition + 1), rect, f2)) {
                    rect.set(f2);
                }
            } else {
                rect.set(f2);
            }
            if (item != null) {
                item.setDecorationRect(new Rect(rect));
                return;
            }
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
    }

    protected final boolean h(View view, RecyclerView recyclerView) {
        return recyclerView.getChildViewHolder(view).getAdapterPosition() == recyclerView.getAdapter().getItemCount() - 1;
    }

    public void i(int i2) {
        this.a = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Rect rect;
        boolean z;
        boolean z2;
        if (recyclerView.getAdapter() == null || !(recyclerView.getAdapter() instanceof us.pinguo.widget.common.cell.recycler.a)) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter();
        int i2 = 0;
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = recyclerView.getChildAt(i3);
            boolean g2 = g(childAt, recyclerView);
            boolean h2 = h(childAt, recyclerView);
            f(rect3, g2, h2);
            int adapterPosition = recyclerView.getChildViewHolder(childAt).getAdapterPosition();
            us.pinguo.widget.common.cell.recycler.b item = aVar.getItem(adapterPosition);
            Rect decorationRect = item == null ? null : item.getDecorationRect();
            boolean z3 = true;
            if (item instanceof a) {
                us.pinguo.widget.common.cell.recycler.b item2 = ((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(adapterPosition - 1);
                us.pinguo.widget.common.cell.recycler.b item3 = ((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(adapterPosition + 1);
                rect2.set(i2, i2, i2, i2);
                a aVar2 = (a) item;
                z2 = aVar2.setDecorationRect(item2, item3, rect2, rect3);
                rect = decorationRect;
                z = h2;
                z3 = !aVar2.drawDecoration(e(z2 ? rect2 : rect3, decorationRect), canvas, childAt, recyclerView, state);
            } else {
                rect = decorationRect;
                z = h2;
                z2 = false;
            }
            if (z3) {
                Rect e2 = e(z2 ? rect2 : rect3, rect);
                if (z && g2) {
                    d(e2, canvas, childAt, recyclerView, state);
                } else if (g2) {
                    a(e2, canvas, childAt, recyclerView, state);
                } else if (z) {
                    b(e2, canvas, childAt, recyclerView, state);
                } else {
                    c(e2, canvas, childAt, recyclerView, state);
                }
            }
            i3++;
            i2 = 0;
        }
    }
}
