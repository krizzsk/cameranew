package us.pinguo.inspire.cell.recycler;

import androidx.fragment.app.Fragment;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
/* loaded from: classes9.dex */
public abstract class PortalChildFragment extends BaseAbsListFragment implements us.pinguo.librouter.module.inspire.c {
    @Override // us.pinguo.librouter.module.inspire.c
    public Fragment getFragment() {
        return this;
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onTabClickWhenSelected() {
        FlingFilterRecyclerView flingFilterRecyclerView = this.mRecyclerView;
        if (flingFilterRecyclerView != null) {
            flingFilterRecyclerView.scrollToPosition(0);
            if (this.mRefreshLayout.isRefreshing()) {
                return;
            }
            triggerRefresh();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void releaseResource() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null || cVar.getItemCount() == 0) {
            return;
        }
        int itemCount = this.mAdapter.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(i2);
            if (item != null && item.mViewHolder != 0) {
                item.releaseResource();
            }
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void reloadResource() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null || cVar.getItemCount() == 0) {
            return;
        }
        int itemCount = this.mAdapter.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(i2);
            if (item != null && item.mViewHolder != 0) {
                item.reloadResource();
            }
        }
    }
}
