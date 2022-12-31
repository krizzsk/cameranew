package us.pinguo.inspire.widget.videocell;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import us.pinguo.inspire.cell.recycler.PortalChildFragment;
/* loaded from: classes9.dex */
public abstract class InspireVideoFragment extends PortalChildFragment {
    protected f mVideoPresenter;

    protected f initVideoPresenter() {
        return new f(this.mRecyclerView, (e) this.mAdapter);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mVideoPresenter.onDestroyView();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mVideoPresenter.onPause();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mVideoPresenter.onResume();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        f initVideoPresenter = initVideoPresenter();
        this.mVideoPresenter = initVideoPresenter;
        ((e) this.mAdapter).setVideoLoadCompleteListener(initVideoPresenter.getVideoLoadCompleteListener());
        this.mVideoPresenter.onViewCreated();
        adddOnDataRefreshListener(this.mVideoPresenter);
        ((e) this.mAdapter).setInspireVideoPresenter(this.mVideoPresenter);
    }

    public void setSlient(boolean z) {
        f fVar = this.mVideoPresenter;
        if (fVar != null) {
            fVar.setSilent(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public e initAdapter() {
        return new e();
    }
}
