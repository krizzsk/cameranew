package us.pinguo.inspire.module.feeds.cell;

import android.view.View;
import java.util.List;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedContent;
import us.pinguo.inspire.module.feeds.view.FeedsCommentView;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsVideoCellProxy extends FeedsPhotoCellProxy {
    public FeedsVideoCellProxy(InspireFeed inspireFeed) {
        super(inspireFeed);
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy
    public View getShareElement() {
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null) {
            return null;
        }
        return ((InspireVideoView) cVar.getView(R.id.feeds_photo_video)).b();
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy
    protected void setComment(us.pinguo.widget.common.cell.recycler.c cVar, InspireFeedContent inspireFeedContent) {
        FeedsCommentView feedsCommentView = (FeedsCommentView) cVar.getView(R.id.feeds_video_comments);
        List<InspireComment> list = inspireFeedContent.comments;
        if (list != null && list.size() != 0) {
            feedsCommentView.setVisibility(0);
            feedsCommentView.setBottomExtraPadding(0);
            feedsCommentView.setComments(getCommentText(inspireFeedContent));
        } else {
            feedsCommentView.setComments(null);
            feedsCommentView.setVisibility(8);
        }
        feedsCommentView.showAnim();
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy
    protected void setPhotos(us.pinguo.widget.common.cell.recycler.c cVar) {
    }
}
