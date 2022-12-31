package us.pinguo.user.util;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.h0;
import kotlin.collections.v;
import kotlin.jvm.internal.s;
/* compiled from: CellVisibleHelper.kt */
/* loaded from: classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    private final void b(RecyclerView recyclerView, int i2, int i3) {
        kotlin.z.d h2;
        int o;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type us.pinguo.widget.common.cell.recycler.BaseRecyclerAdapter<*, *>");
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) adapter;
        us.pinguo.widget.common.cell.recycler.b item = aVar.getItem(i2);
        us.pinguo.widget.common.cell.recycler.b item2 = aVar.getItem(i3);
        if (item != null) {
            item.setShown(true);
        }
        if (i2 > 0) {
            us.pinguo.widget.common.cell.recycler.b item3 = aVar.getItem(i2 - 1);
            s.e(item3);
            item3.setShown(false);
        }
        if (item2 != null) {
            item2.setShown(true);
        }
        if (i3 < aVar.getItemCount() - 1) {
            us.pinguo.widget.common.cell.recycler.b item4 = aVar.getItem(i3 + 1);
            s.e(item4);
            item4.setShown(false);
        }
        h2 = kotlin.z.j.h(i2 + 1, i3);
        o = v.o(h2, 10);
        ArrayList<us.pinguo.widget.common.cell.recycler.b> arrayList = new ArrayList(o);
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.getItem(((h0) it).nextInt()));
        }
        for (us.pinguo.widget.common.cell.recycler.b bVar : arrayList) {
            s.e(bVar);
            bVar.setShown(true);
        }
    }

    private final void c(RecyclerView recyclerView, boolean z) {
        int i2;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i3 = -1;
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            i3 = linearLayoutManager.findFirstVisibleItemPosition();
            i2 = linearLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            i3 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            i2 = staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
        } else if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            i3 = gridLayoutManager.findFirstVisibleItemPosition();
            i2 = gridLayoutManager.findLastVisibleItemPosition();
        } else {
            i2 = -1;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type us.pinguo.widget.common.cell.recycler.BaseRecyclerAdapter<*, *>");
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) adapter;
        kotlin.z.d dVar = new kotlin.z.d(i3, i2);
        ArrayList<us.pinguo.widget.common.cell.recycler.b> arrayList = new ArrayList();
        Iterator<Integer> it = dVar.iterator();
        while (it.hasNext()) {
            us.pinguo.widget.common.cell.recycler.b item = aVar.getItem(((h0) it).nextInt());
            if (item != null) {
                arrayList.add(item);
            }
        }
        for (us.pinguo.widget.common.cell.recycler.b bVar : arrayList) {
            bVar.setShown(z);
        }
    }

    public final void a(RecyclerView recyclerView) {
        int i2;
        if ((recyclerView == null ? null : recyclerView.getAdapter()) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i3 = -1;
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            i3 = linearLayoutManager.findFirstVisibleItemPosition();
            i2 = linearLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int i4 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            i2 = staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
            i3 = i4;
        } else if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            i3 = gridLayoutManager.findFirstVisibleItemPosition();
            i2 = gridLayoutManager.findLastVisibleItemPosition();
        } else {
            i2 = -1;
        }
        b(recyclerView, i3, i2);
    }

    public final void d(RecyclerView recyclerView) {
        c(recyclerView, false);
    }

    public final void e(RecyclerView recyclerView) {
        c(recyclerView, true);
    }
}
