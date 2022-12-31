package us.pinguo.inspire.module.feeds.cell;

import android.view.ViewGroup;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
/* loaded from: classes9.dex */
public class FeedsTaskCell extends FeedsBaseCell<InspireFeed, us.pinguo.widget.common.cell.recycler.c> {
    private FeedsTaskCellProxy mProxy;

    public FeedsTaskCell(InspireFeed inspireFeed) {
        super(inspireFeed);
        this.mProxy = new FeedsTaskCellProxy(inspireFeed);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return this.mProxy.createViewHolder(viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 4;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        this.mProxy.onBindViewHolder(cVar);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        super.onViewRecycled();
        this.mProxy.onViewRecycled();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        this.mProxy.releaseResource(this.mViewHolder);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        this.mProxy.reloadResource(this.mViewHolder);
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    public void setStat(FeedStat feedStat) {
        super.setStat(feedStat);
        this.mProxy.setStat(feedStat);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void updateData(InspireFeed inspireFeed) {
        super.updateData((FeedsTaskCell) inspireFeed);
        this.mProxy.updateData(inspireFeed);
    }
}
