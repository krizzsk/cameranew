package us.pinguo.user.recycler;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.user.a1.j;
import us.pinguo.user.a1.k;
import us.pinguo.user.a1.l;
import us.pinguo.user.a1.m;
import us.pinguo.user.a1.n;
import us.pinguo.user.a1.o;
/* compiled from: LmAdapter.java */
/* loaded from: classes6.dex */
public class c extends us.pinguo.widget.common.cell.recycler.a {
    public static final int TYPE_EMPTY = 2147483646;
    public static final int TYPE_ERROR = 2147483645;
    public static final int TYPE_FOOTER = Integer.MAX_VALUE;
    public static final int TYPE_LODING = 2147483644;
    public static final int TYPE_NO_MORE = 2147483643;
    private us.pinguo.widget.common.cell.recycler.b mLoginCell;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private us.pinguo.widget.common.cell.recycler.b mFooterCell = new l(null);
    private us.pinguo.widget.common.cell.recycler.b mEmptyCell = new j(null);
    private us.pinguo.widget.common.cell.recycler.b mErrorCell = new k(null);
    private us.pinguo.widget.common.cell.recycler.b mLodingCell = new m(null);
    private us.pinguo.widget.common.cell.recycler.b mNoMoreCell = new o(null);

    /* compiled from: LmAdapter.java */
    /* loaded from: classes6.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ GridLayoutManager a;

        a(GridLayoutManager gridLayoutManager) {
            this.a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            int itemViewType = c.this.getItemViewType(i2);
            if ((c.this.getItem(i2) instanceof b) || itemViewType == Integer.MAX_VALUE || itemViewType == 2147483646 || itemViewType == 2147483645 || itemViewType == 2147483644 || itemViewType == 2147483643) {
                return this.a.getSpanCount();
            }
            return 1;
        }
    }

    /* compiled from: LmAdapter.java */
    /* loaded from: classes6.dex */
    public interface b {
    }

    private void showSwipeRefreshLayout() {
        SwipeRefreshLayout swipeRefreshLayout = this.mSwipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    public void appendCellsAndHideFooter(List<us.pinguo.widget.common.cell.recycler.b> list) {
        boolean z;
        int size = this.mCells.size();
        if (size > 0) {
            int i2 = size - 1;
            if (this.mCells.get(i2) == this.mFooterCell) {
                this.mCells.remove(i2);
                z = true;
                if (list == null && list.size() != 0) {
                    this.mCells.addAll(list);
                    if (z) {
                        notifyItemChanged(size - 1);
                        notifyItemRangeInserted(size, list.size() - 1);
                        return;
                    }
                    notifyItemRangeInserted(size, list.size());
                    return;
                }
                notifyItemRemoved(size - 1);
            }
        }
        z = false;
        if (list == null) {
        }
        notifyItemRemoved(size - 1);
    }

    public us.pinguo.widget.common.cell.recycler.b getLodingCell() {
        return this.mLodingCell;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return this.mSwipeRefreshLayout;
    }

    public void hideEmpty() {
        remove(this.mEmptyCell);
    }

    public void hideError() {
        remove(this.mErrorCell);
    }

    public void hideFooter() {
        remove(this.mFooterCell);
    }

    public void hideLoading() {
        remove(this.mLodingCell);
    }

    public void hideLogin() {
        remove(this.mLoginCell);
    }

    public void hideNoMoreContent() {
        remove(this.mNoMoreCell);
    }

    public boolean isEmpty() {
        return this.mCells.contains(this.mEmptyCell);
    }

    public boolean isError() {
        return this.mCells.contains(this.mErrorCell);
    }

    public boolean isFootShowing() {
        return indexOf(this.mFooterCell) != -1;
    }

    public boolean isLoadingShowing() {
        return this.mCells.contains(this.mLodingCell);
    }

    public boolean isNoMoreShowing() {
        return this.mCells.contains(this.mNoMoreCell);
    }

    public boolean isShowingLogin() {
        return this.mCells.contains(this.mLoginCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager));
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.a
    public void onDestroyView() {
        super.onDestroyView();
        this.mSwipeRefreshLayout = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            int itemViewType = viewHolder.getItemViewType();
            if ((getItem(viewHolder.getAdapterPosition()) instanceof b) || itemViewType == Integer.MAX_VALUE || itemViewType == 2147483646 || itemViewType == 2147483644 || itemViewType == 2147483643 || itemViewType == 2147483645) {
                ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
            }
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.a
    public void remove(int i2) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (getItem(i2) == this.mLodingCell && (swipeRefreshLayout = this.mSwipeRefreshLayout) != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        super.remove(i2);
    }

    public void removeFooterNotNotify() {
        this.mCells.remove(this.mFooterCell);
    }

    public void setEmptyCell(us.pinguo.widget.common.cell.recycler.b bVar) {
        this.mEmptyCell = bVar;
    }

    public void setErrorCell(us.pinguo.widget.common.cell.recycler.b bVar) {
        this.mErrorCell = bVar;
    }

    public void setFooterCell(us.pinguo.widget.common.cell.recycler.b bVar) {
        this.mFooterCell = bVar;
    }

    public void setNoMoreCell(us.pinguo.widget.common.cell.recycler.b bVar) {
        this.mNoMoreCell = bVar;
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.mSwipeRefreshLayout = swipeRefreshLayout;
    }

    public void showEmpty() {
        if (isEmpty()) {
            return;
        }
        clear();
        add(this.mEmptyCell);
    }

    public void showError() {
        if (isError()) {
            return;
        }
        clear();
        add(this.mErrorCell);
    }

    public void showFooter() {
        add(this.mFooterCell);
    }

    public void showLoading() {
        if (isLoadingShowing()) {
            return;
        }
        clear();
        showSwipeRefreshLayout();
    }

    public void showLogin(FragmentManager fragmentManager) {
        if (isShowingLogin()) {
            return;
        }
        if (this.mLoginCell == null) {
            n nVar = new n(fragmentManager);
            nVar.a(this.mSwipeRefreshLayout);
            this.mLoginCell = nVar;
        }
        clear();
        add(this.mLoginCell);
    }

    public void showNoMoreContent() {
        List<C> list = this.mCells;
        if (list == 0 || list.contains(this.mNoMoreCell)) {
            return;
        }
        add(this.mNoMoreCell);
    }

    @Override // us.pinguo.widget.common.cell.recycler.a
    public void remove(us.pinguo.widget.common.cell.recycler.b bVar) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (bVar == this.mLodingCell && (swipeRefreshLayout = this.mSwipeRefreshLayout) != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        super.remove((c) bVar);
    }

    public void showEmpty(int i2) {
        if (i2 >= 0) {
            if (us.pinguo.foundation.utils.k.a(this.mCells)) {
                this.mCells = new ArrayList();
            } else {
                this.mCells = new ArrayList(this.mCells.subList(0, i2));
            }
            this.mCells.remove(this.mErrorCell);
            this.mCells.remove(this.mFooterCell);
            this.mCells.remove(this.mLodingCell);
            this.mCells.remove(this.mNoMoreCell);
            add(this.mEmptyCell);
            if (this.mBeginChange.get()) {
                return;
            }
            notifyDataSetChanged();
            return;
        }
        throw new IndexOutOfBoundsException("keepHeaderCount out of Bounds");
    }

    public void showError(int i2) {
        if (i2 >= 0) {
            if (us.pinguo.foundation.utils.k.a(this.mCells)) {
                this.mCells = new ArrayList();
            } else {
                this.mCells = new ArrayList(this.mCells.subList(0, i2));
            }
            this.mCells.remove(this.mEmptyCell);
            this.mCells.remove(this.mFooterCell);
            this.mCells.remove(this.mLodingCell);
            this.mCells.remove(this.mNoMoreCell);
            this.mCells.add(this.mErrorCell);
            if (this.mBeginChange.get()) {
                return;
            }
            notifyDataSetChanged();
            return;
        }
        throw new IndexOutOfBoundsException("keepHeaderCount out of Bounds");
    }

    public void showLoading(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("keepHeaderCount out of Bounds");
        }
        if (i2 == 0) {
            showLoading();
            return;
        }
        if (us.pinguo.foundation.utils.k.a(this.mCells)) {
            this.mCells = new ArrayList();
        } else {
            this.mCells = new ArrayList(this.mCells.subList(0, i2));
        }
        this.mCells.remove(this.mErrorCell);
        this.mCells.remove(this.mFooterCell);
        this.mCells.remove(this.mEmptyCell);
        ((m) this.mLodingCell).c(i2);
        notifyDataSetChanged();
        showSwipeRefreshLayout();
    }

    public void showEmpty(int i2, int i3, int i4) {
        if (i2 >= 0) {
            ArrayList arrayList = new ArrayList(this.mCells.subList(0, i2));
            this.mCells = arrayList;
            arrayList.remove(this.mErrorCell);
            this.mCells.remove(this.mFooterCell);
            this.mCells.remove(this.mLodingCell);
            this.mCells.remove(this.mNoMoreCell);
            ((j) this.mEmptyCell).a(i2);
            ((j) this.mEmptyCell).b(i3);
            ((j) this.mEmptyCell).c(i4);
            add(this.mEmptyCell);
            if (this.mBeginChange.get()) {
                return;
            }
            notifyDataSetChanged();
            return;
        }
        throw new IndexOutOfBoundsException("keepHeaderCount out of Bounds");
    }
}
