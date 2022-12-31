package us.pinguo.inspire.module.comment;

import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.BaseShareDialog;
import us.pinguo.share.util.InspireShareUtils;
/* compiled from: FeedsInfoFragment.kt */
/* loaded from: classes9.dex */
public final class FeedsInfoFragment$onShareClick$1 implements PGShareListener {
    final /* synthetic */ FeedsInfoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedsInfoFragment$onShareClick$1(FeedsInfoFragment feedsInfoFragment) {
        this.this$0 = feedsInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onShareComplete$lambda-0  reason: not valid java name */
    public static final void m146onShareComplete$lambda0(Integer num) {
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareCancel(ShareSite shareSite) {
        kotlin.jvm.internal.s.h(shareSite, "shareSite");
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String a0 = BaseShareDialog.a0(shareSite);
        InspireWork currentWork = this.this$0.getCurrentWork();
        cVar.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, a0, "challenge_work_detail_page", currentWork == null ? null : currentWork.workId, "share_cancel");
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareComplete(ShareSite shareSite, boolean z) {
        kotlin.jvm.internal.s.h(shareSite, "shareSite");
        if (!z) {
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String a0 = BaseShareDialog.a0(shareSite);
            InspireWork currentWork = this.this$0.getCurrentWork();
            cVar.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, a0, "challenge_work_detail_page", currentWork == null ? null : currentWork.workId, "share_success");
        }
        InspireWork currentWork2 = this.this$0.getCurrentWork();
        kotlin.jvm.internal.s.e(currentWork2);
        InspireWorkBulkLoader.increaseShareCompletion(currentWork2.workId).subscribe(w.a, v.a);
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareError(ShareSite shareSite, Throwable throwable) {
        kotlin.jvm.internal.s.h(shareSite, "shareSite");
        kotlin.jvm.internal.s.h(throwable, "throwable");
    }
}
