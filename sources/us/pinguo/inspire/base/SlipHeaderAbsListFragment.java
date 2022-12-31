package us.pinguo.inspire.base;

import androidx.appcompat.widget.Toolbar;
import us.pinguo.inspire.widget.videocell.InspireVideoFragment;
/* loaded from: classes9.dex */
public abstract class SlipHeaderAbsListFragment extends InspireVideoFragment {
    public d getScrollListener(Toolbar toolbar, us.pinguo.inspire.cell.recycler.d dVar) {
        return new d(toolbar, dVar);
    }

    public void initSlipHeaderScroll(Toolbar toolbar) {
        if (this.mAdapter.getItemCount() == 0) {
            return;
        }
        us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(0);
        if (item instanceof us.pinguo.inspire.cell.recycler.d) {
            this.mRecyclerView.addOnScrollListener(getScrollListener(toolbar, (us.pinguo.inspire.cell.recycler.d) item));
        }
    }
}
