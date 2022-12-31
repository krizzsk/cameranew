package us.pinguo.inspire.module.feeds;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
/* loaded from: classes9.dex */
public interface IFeedsView extends us.pinguo.foundation.p.b {
    void addData(List<us.pinguo.widget.common.cell.recycler.b> list, boolean z);

    void deleteWork(String str);

    void disableLoadMore();

    void enableLoadMore();

    us.pinguo.widget.common.cell.recycler.a getAdapter();

    RecyclerView getRecyclerView();

    void onUpdatePublishStateEvent(UpdatePublishStateEvent updatePublishStateEvent);

    void refreshFeedsAfterTopCells(List<us.pinguo.widget.common.cell.recycler.b> list);

    void setData(List<us.pinguo.widget.common.cell.recycler.b> list);

    void showErrorWhenEmpty();

    void stopRefreshAnim();
}
