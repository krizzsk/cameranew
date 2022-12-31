package us.pinguo.inspire.module.publish.event;

import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.publish.vo.PublishData;
/* loaded from: classes9.dex */
public class UpdatePublishStateEvent {
    public static final int COMMENT_FILTER_TYPE = 1;
    public static final int FEED_FILTER_TYPE = 0;
    public static final int SHARE_UPLOAD_FILTER_TYPE = 2;
    public String errorMsg;
    private int filterType;
    private InspireComment inspireComment;
    private InspireWork inspireWork;
    public PublishData publishData;
    public long transferred;

    public int getFilterType() {
        return this.filterType;
    }

    public InspireComment getInspireComment() {
        return this.inspireComment;
    }

    public InspireWork getInspireWork() {
        return this.inspireWork;
    }

    public void setFilterType(int i2) {
        this.filterType = i2;
    }

    public void setInspireComment(InspireComment inspireComment) {
        this.inspireComment = inspireComment;
    }

    public void setInspireWork(InspireWork inspireWork) {
        this.inspireWork = inspireWork;
    }
}
