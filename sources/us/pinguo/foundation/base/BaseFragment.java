package us.pinguo.foundation.base;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.statistics.f;
import us.pinguo.foundation.statistics.g;
import us.pinguo.foundation.statistics.l;
@Instrumented
/* loaded from: classes4.dex */
public class BaseFragment extends Fragment implements us.pinguo.foundation.ui.d {
    protected boolean mIsPausing = true;
    protected boolean mDestroyed = true;
    private boolean mPageStarted = false;
    protected boolean mEnableDefaultFragmentVisibleStrategy = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        final /* synthetic */ Handler a;

        /* renamed from: us.pinguo.foundation.base.BaseFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class RunnableC0393a implements Runnable {
            RunnableC0393a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseFragment.this.onFirstFrameVisible();
            }
        }

        a(Handler handler) {
            this.a = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.post(new RunnableC0393a());
        }
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    protected String getPageId() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getPageShowParam() {
        return "src=" + PageStack.getInstance().e();
    }

    public Bundle getSafeArguments() {
        Bundle arguments = getArguments();
        return arguments == null ? new Bundle() : arguments;
    }

    public final boolean isDestoryed() {
        return this.mDestroyed;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mIsPausing = true;
        this.mDestroyed = false;
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mDestroyed = true;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFirstFrameVisible() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFragmentHide() {
        us.pinguo.common.log.a.k("onFragmentInvisible," + getClass().getSimpleName(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFragmentShow() {
        us.pinguo.common.log.a.k("onFragmentVisible," + getClass().getSimpleName(), new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPageEnd() {
        if (this.mPageStarted) {
            if (this instanceof us.pinguo.foundation.statistics.e) {
                f.e(((us.pinguo.foundation.statistics.e) this).C(), true);
            } else {
                g.e(getPageId());
            }
        }
        this.mPageStarted = false;
    }

    protected void onPageShow() {
        if (PageStack.getInstance().d() <= 1) {
            l.onEvent(getActivity(), getPageId());
        } else {
            l.onEvent(getActivity(), getPageId(), getPageShowParam());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPageStart() {
        if (!this.mPageStarted) {
            if (this instanceof us.pinguo.foundation.statistics.e) {
                f.f(((us.pinguo.foundation.statistics.e) this).C());
            } else {
                g.f(getPageId());
            }
            onPageShow();
        }
        this.mPageStarted = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        VdsAgent.onFragmentPause(this);
        this.mIsPausing = true;
        super.onPause();
        if (useDefaultPageStatistic()) {
            onPageEnd();
        }
        if (this.mEnableDefaultFragmentVisibleStrategy) {
            onFragmentHide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        VdsAgent.onFragmentResume(this);
        this.mIsPausing = false;
        super.onResume();
        if (useDefaultPageStatistic()) {
            onPageStart();
        }
        if (this.mEnableDefaultFragmentVisibleStrategy) {
            onFragmentShow();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.post(new a(new Handler()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnClickListener(View view, int i2, View.OnClickListener onClickListener) {
        view.findViewById(i2).setOnClickListener(onClickListener);
    }

    @Override // us.pinguo.foundation.ui.d
    public void setOrientation(int i2, boolean z) {
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }

    protected boolean useDefaultPageStatistic() {
        return true;
    }
}
