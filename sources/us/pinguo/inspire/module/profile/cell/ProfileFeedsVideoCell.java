package us.pinguo.inspire.module.profile.cell;

import rx.functions.Action1;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
import us.pinguo.inspire.module.feeds.cell.FeedsVideoCell;
/* loaded from: classes9.dex */
public class ProfileFeedsVideoCell extends FeedsVideoCell {
    public static final int TYPE_VIDEO = 2;
    private String mWorkId;

    public ProfileFeedsVideoCell(InspireWork inspireWork) {
        super(InspireFeed.convertWorkToFeed(inspireWork));
        this.mWorkId = inspireWork.getWorkId();
        registerUpdateCommentCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(FeedsPhotoCellProxy.InspireCommentEvent inspireCommentEvent) {
        if (this.mWorkId.equals(inspireCommentEvent.workId)) {
            updateComment(inspireCommentEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
    }

    private void registerUpdateCommentCount() {
        addSubscription(us.pinguo.foundation.r.d.a().c(FeedsPhotoCellProxy.InspireCommentEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.cell.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileFeedsVideoCell.this.d((FeedsPhotoCellProxy.InspireCommentEvent) obj);
            }
        }, d.a));
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsVideoCell
    public String getFid() {
        return this.mWorkId;
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsVideoCell, us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 2;
    }

    public String getWorkId() {
        return this.mWorkId;
    }

    public ProfileFeedsVideoCell(InspireFeed inspireFeed) {
        super(inspireFeed);
        this.mWorkId = inspireFeed.getFcnt().workId;
        registerUpdateCommentCount();
    }
}
