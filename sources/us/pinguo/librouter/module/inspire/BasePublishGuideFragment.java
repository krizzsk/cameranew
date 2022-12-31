package us.pinguo.librouter.module.inspire;

import us.pinguo.foundation.base.SubscriptionFragment;
/* loaded from: classes5.dex */
public class BasePublishGuideFragment extends SubscriptionFragment {
    private a mOnFirstFrameAvailableListener;
    protected Object mPublishAnim2;

    /* loaded from: classes5.dex */
    public interface a {
        void onFirstFrameAvailable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFirstFrameVisible() {
        super.onFirstFrameVisible();
        a aVar = this.mOnFirstFrameAvailableListener;
        if (aVar != null) {
            aVar.onFirstFrameAvailable();
        }
    }

    public void setOnFirstFrameAvailableListener(a aVar) {
        this.mOnFirstFrameAvailableListener = aVar;
    }

    public void setPublishAnim(Object obj) {
        this.mPublishAnim2 = obj;
    }
}
