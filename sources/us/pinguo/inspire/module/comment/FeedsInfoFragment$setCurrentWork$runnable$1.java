package us.pinguo.inspire.module.comment;

import android.content.Context;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
/* compiled from: FeedsInfoFragment.kt */
/* loaded from: classes9.dex */
public final class FeedsInfoFragment$setCurrentWork$runnable$1 implements Runnable {
    final /* synthetic */ BaseInfoCell $cell;
    final /* synthetic */ int $pos;
    final /* synthetic */ FeedsInfoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedsInfoFragment$setCurrentWork$runnable$1(FeedsInfoFragment feedsInfoFragment, int i2, BaseInfoCell baseInfoCell) {
        this.this$0 = feedsInfoFragment;
        this.$pos = i2;
        this.$cell = baseInfoCell;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        i2 = this.this$0.mCurrentIndex;
        if (i2 == this.$pos) {
            BaseInfoCell baseInfoCell = this.$cell;
            if ((baseInfoCell == null ? null : baseInfoCell.getMViewHolder()) != null) {
                InfoVideoPresenter mVideoPresenter = this.this$0.getMVideoPresenter();
                if (mVideoPresenter == null) {
                    return;
                }
                mVideoPresenter.onPageSelect(this.$cell);
                return;
            }
            Context context = this.this$0.getContext();
            if (context == null) {
                return;
            }
            us.pinguo.foundation.l.c.b(context, new FeedsInfoFragment$setCurrentWork$runnable$1$run$1(this), 50L);
        }
    }
}
