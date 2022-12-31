package us.pinguo.inspire.module.feeds.cell;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.collection.GrowingIO;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
/* loaded from: classes9.dex */
public class FeedsPhotoCell extends FeedsBaseCell<InspireFeed, us.pinguo.widget.common.cell.recycler.c> {
    private FeedsPhotoCellProxy mProxy;

    public FeedsPhotoCell(InspireFeed inspireFeed) {
        super(inspireFeed);
        FeedsPhotoCellProxy feedsPhotoCellProxy = new FeedsPhotoCellProxy(inspireFeed);
        this.mProxy = feedsPhotoCellProxy;
        feedsPhotoCellProxy.setCell(this);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c createViewHolder = this.mProxy.createViewHolder(viewGroup);
        GrowingIO.setViewContent(createViewHolder.itemView, getFid());
        return createViewHolder;
    }

    public View getChangedShareElement() {
        return this.mProxy.getShareElement();
    }

    public String getFid() {
        return getData().fid;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 3;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        this.mProxy.onBindViewHolder(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.cell.recycler.a, us.pinguo.widget.common.cell.recycler.b
    public void onHide() {
        super.onHide();
        this.mProxy.onHide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.cell.recycler.a, us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        super.onShow();
        this.mProxy.onShow();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        super.onViewRecycled();
        this.mProxy.onViewRecycled();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
        this.mProxy.releaseResource(this.mViewHolder);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        this.mProxy.reloadResource(this.mViewHolder);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void setRecyclerView(RecyclerView recyclerView) {
        super.setRecyclerView(recyclerView);
        this.mProxy.setRecyclerView(recyclerView);
    }

    public void setSelectedInnerIndex(int i2) {
        this.mProxy.setSelectedTagFromTransition(i2);
    }

    public void setShowTime(boolean z) {
        this.mProxy.setShowTime(z);
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    public void setStat(FeedStat feedStat) {
        super.setStat(feedStat);
        this.mProxy.setStat(feedStat);
    }

    public void updateComment(FeedsPhotoCellProxy.InspireCommentEvent inspireCommentEvent) {
        this.mProxy.updateComment(inspireCommentEvent);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void updateData(InspireFeed inspireFeed) {
        this.mProxy.updateData(inspireFeed);
        super.updateData((FeedsPhotoCell) inspireFeed);
    }
}
