package us.pinguo.inspire.module.profile.cell;

import rx.functions.Action1;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
/* loaded from: classes9.dex */
public class ProfileFeedsCell extends FeedsPhotoCell {
    public static final int TYPE = 1;
    private String mWorkId;

    public ProfileFeedsCell(InspireWork inspireWork) {
        super(InspireFeed.convertWorkToFeed(inspireWork));
        this.mWorkId = inspireWork.getWorkId();
        registerUpdateCommentCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(FeedsPhotoCellProxy.InspireCommentEvent inspireCommentEvent) {
        if (this.mWorkId.equals(inspireCommentEvent.workId)) {
            updateComment(inspireCommentEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Throwable th) {
        us.pinguo.common.log.a.f(th);
        Inspire.f(th);
    }

    private void registerUpdateCommentCount() {
        addSubscription(us.pinguo.foundation.r.d.a().c(FeedsPhotoCellProxy.InspireCommentEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.cell.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileFeedsCell.this.b((FeedsPhotoCellProxy.InspireCommentEvent) obj);
            }
        }, b.a));
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell
    public String getFid() {
        return this.mWorkId;
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    public String getWorkId() {
        return this.mWorkId;
    }

    public ProfileFeedsCell(InspireFeed inspireFeed) {
        super(inspireFeed);
        this.mWorkId = inspireFeed.getFcnt().workId;
        registerUpdateCommentCount();
    }
}
