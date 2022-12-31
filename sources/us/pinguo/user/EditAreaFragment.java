package us.pinguo.user;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public abstract class EditAreaFragment extends BaseAbsListFragment {
    protected abstract String f0();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        setLoadMoreEnabled(false);
        setPullToRefreshEnabled(false);
        setTitle(f0());
    }

    @Override // us.pinguo.user.BaseAbsListFragment
    protected void onDataRefresh() {
    }

    @Override // us.pinguo.user.BaseAbsListFragment
    protected void onLoadMore() {
    }

    @Override // us.pinguo.user.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
