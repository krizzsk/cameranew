package us.pinguo.inspire.module.feeds.cell;

import android.view.ViewGroup;
import com.growingio.android.sdk.collection.GrowingIO;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.inspire.widget.videocell.d;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsTaskVideoCell extends us.pinguo.inspire.widget.videocell.d<InspireFeed, us.pinguo.widget.common.cell.recycler.c> {
    private FeedsTaskVideoCellProxy mProxy;

    public FeedsTaskVideoCell(InspireFeed inspireFeed) {
        super(inspireFeed);
        this.mProxy = new FeedsTaskVideoCellProxy(inspireFeed);
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c createViewHolder = this.mProxy.createViewHolder(viewGroup);
        GrowingIO.setViewContent(createViewHolder.itemView, getData().fid);
        return createViewHolder;
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return "Community_Portal_Feed_Show";
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 4;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public String getVideoUrl() {
        T t = this.mData;
        return (t == 0 || ((InspireFeed) t).latestTaskCnt == null || ((InspireFeed) t).latestTaskCnt.videos == null || ((InspireFeed) t).latestTaskCnt.videos.size() <= 0) ? "" : ((InspireFeed) this.mData).latestTaskCnt.videos.get(0).url;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.d
    public InspireVideoView getVideoView(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar == null) {
            return null;
        }
        return (InspireVideoView) cVar.getView(R.id.feeds_task_video);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.d
    public d.b getViewSize() {
        d.b bVar = new d.b();
        T t = this.mData;
        if (t != 0 && ((InspireFeed) t).latestTaskCnt != null && ((InspireFeed) t).latestTaskCnt.videos != null && ((InspireFeed) t).latestTaskCnt.videos.size() > 0) {
            bVar.a = ((InspireFeed) this.mData).latestTaskCnt.videos.get(0).width;
            bVar.b = ((InspireFeed) this.mData).latestTaskCnt.videos.get(0).height;
        }
        if (bVar.a <= 0 || bVar.b <= 0) {
            bVar.a = 750;
            bVar.b = 550;
        }
        return bVar;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected void onBindOtherView(us.pinguo.widget.common.cell.recycler.c cVar) {
        this.mProxy.onBindViewHolder(cVar);
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
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

    @Override // us.pinguo.inspire.cell.recycler.a
    public void setStat(FeedStat feedStat) {
        super.setStat(feedStat);
        this.mProxy.setStat(feedStat);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void updateData(InspireFeed inspireFeed) {
        super.updateData((FeedsTaskVideoCell) inspireFeed);
        this.mProxy.updateData(inspireFeed);
    }
}
