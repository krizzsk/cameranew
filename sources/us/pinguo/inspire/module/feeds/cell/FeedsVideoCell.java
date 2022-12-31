package us.pinguo.inspire.module.feeds.cell;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.collection.GrowingIO;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedContent;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.inspire.widget.videocell.d;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsVideoCell extends us.pinguo.inspire.widget.videocell.d<InspireFeed, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, f.b {
    private us.pinguo.user.util.f mDoubleClickDetector;
    private FeedsVideoCellProxy mProxy;
    private InspireFeed mRemoteFeed;

    public FeedsVideoCell(InspireFeed inspireFeed) {
        super(inspireFeed);
        this.mDoubleClickDetector = new us.pinguo.user.util.f();
        FeedsVideoCellProxy feedsVideoCellProxy = new FeedsVideoCellProxy(inspireFeed);
        this.mProxy = feedsVideoCellProxy;
        feedsVideoCellProxy.setCell(this);
    }

    private void scrollToCenter() {
        VH vh;
        View view;
        if (this.mPresenter.getCurrentItem() == this.mAdapter.indexOf(this) || (vh = this.mViewHolder) == 0 || (view = vh.itemView) == null) {
            return;
        }
        this.mRecyclerView.scrollBy(0, view.getTop() - ((this.mRecyclerView.getHeight() / 2) - (this.mViewHolder.itemView.getHeight() / 2)));
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
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

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return "Community_Portal_Feed_Show";
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.inspire.cell.recycler.a
    protected String getTimeKey() {
        return "community_feed_focus_timespend";
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 3;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public String getVideoUrl() {
        T t = this.mData;
        return (t == 0 || ((InspireFeed) t).videoCnt == null || ((InspireFeed) t).videoCnt.videos == null || ((InspireFeed) t).videoCnt.videos.size() <= 0) ? "" : ((InspireFeed) this.mData).videoCnt.videos.get(0).url;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected InspireVideoView getVideoView(us.pinguo.widget.common.cell.recycler.c cVar) {
        InspireVideoView inspireVideoView = cVar == null ? null : (InspireVideoView) cVar.getView(R.id.feeds_photo_video);
        if (inspireVideoView != null) {
            inspireVideoView.setOnClickListener(this);
        }
        return inspireVideoView;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected d.b getViewSize() {
        d.b bVar = new d.b();
        T t = this.mData;
        if (t != 0 && ((InspireFeed) t).videoCnt != null && ((InspireFeed) t).videoCnt.videos != null && ((InspireFeed) t).videoCnt.videos.size() > 0) {
            bVar.a = ((InspireFeed) this.mData).videoCnt.videos.get(0).width;
            bVar.b = ((InspireFeed) this.mData).videoCnt.videos.get(0).height;
            bVar.c = ((InspireFeed) this.mData).videoCnt.videos.get(0).mockRotation;
        } else {
            bVar.a = 1;
            bVar.b = 1;
        }
        return bVar;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected void onBindOtherView(us.pinguo.widget.common.cell.recycler.c cVar) {
        this.mProxy.onBindViewHolder(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof InspireVideoView) {
            this.mDoubleClickDetector.d(view, this);
        }
    }

    @Override // us.pinguo.user.util.f.b
    public void onDoubleClick(View view) {
        T t = this.mData;
        InspireFeedContent fcnt = t == 0 ? null : ((InspireFeed) t).getFcnt();
        if (fcnt == null) {
            return;
        }
        if (fcnt.like == 0) {
            this.mProxy.collect(view, fcnt);
        } else {
            this.mProxy.showLikeAnim();
        }
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

    @Override // us.pinguo.user.util.f.b
    public void onSingleClick(View view) {
        this.mProxy.intentToDetail(view, 0);
        if (getStat() != null) {
            l.c("Feed_ContentInteraction", getStat());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, us.pinguo.inspire.module.discovery.entity.InspireFeed] */
    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        super.onViewRecycled();
        ?? r0 = this.mRemoteFeed;
        if (r0 != 0) {
            this.mData = r0;
            this.mProxy.mData = r0;
        }
        this.mProxy.onViewRecycled();
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected void refreshVideoSize(int i2, int i3) {
        super.refreshVideoSize(i2, i3);
        T t = this.mData;
        if (t == 0 || ((InspireFeed) t).videoCnt == null || ((InspireFeed) t).videoCnt.videos == null || ((InspireFeed) t).videoCnt.videos.size() <= 0) {
            return;
        }
        ((InspireFeed) this.mData).videoCnt.videos.get(0).width = i2;
        ((InspireFeed) this.mData).videoCnt.videos.get(0).height = i3;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar != null) {
            this.mProxy.releaseResource(cVar);
            PhotoImageView photoImageView = (PhotoImageView) this.mViewHolder.getView(R.id.piv_photo_video_view);
            if (photoImageView != null) {
                photoImageView.setImageDrawable(null);
            }
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        this.mProxy.reloadResource(this.mViewHolder);
        PhotoImageView photoImageView = (PhotoImageView) this.mViewHolder.getView(R.id.piv_photo_video_view);
        d.b viewSize = getViewSize();
        String videoUrl = getVideoUrl();
        if (photoImageView != null) {
            photoImageView.setVideoImageUrl(videoUrl, viewSize.a, viewSize.b);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void setRecyclerView(RecyclerView recyclerView) {
        super.setRecyclerView(recyclerView);
        this.mProxy.setRecyclerView(recyclerView);
    }

    public void setRemoteFeed(InspireFeed inspireFeed) {
        this.mRemoteFeed = inspireFeed;
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
        super.updateData((FeedsVideoCell) inspireFeed);
    }
}
