package us.pinguo.inspire.base.easyload;

import android.os.Bundle;
import android.view.View;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.util.o;
/* loaded from: classes9.dex */
public abstract class EasyListFragment<T> extends BaseAbsListFragment {
    private boolean mCacheEnabled;
    private boolean mCacheLoaded;
    private boolean mDeleteDuplicateEnabled;
    private T mFirstResp;
    private boolean mForceRefreshEnabled;
    private boolean mIgnoreErrorToast;
    private T mLastResp;
    private Subscription mLoadMoreSubscription;
    private boolean mRefreshAll;
    protected View mRootView;
    private boolean mShowStateEnabled;
    private l<T> mLoader = new l<>();
    private boolean mFirstRequest = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e0 */
    public /* synthetic */ void f0(Object obj) {
        this.mFirstResp = obj;
        this.mLastResp = obj;
        if (obj != 0) {
            this.mAdapter.addAll(obj != 0 ? createCells(obj) : null);
            setLoadMoreEnabled(isLoadMoreEnable(obj));
            this.mCacheLoaded = true;
            onCacheDataLoaded();
        }
        refreshDataFromServer(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        refreshDataFromServer(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i0 */
    public /* synthetic */ void j0(Object obj) {
        this.mAdapter.hideFooter();
        setLoadingMore(false);
        if (obj != 0) {
            List<us.pinguo.widget.common.cell.recycler.b> appendCells = appendCells(obj);
            if (this.mDeleteDuplicateEnabled) {
                o.a(appendCells);
            }
            this.mAdapter.addAll(appendCells);
            this.mLastResp = obj;
            setLoadMoreEnabled(isLoadMoreEnable(obj));
            onLoadMoreCellsAdded();
            if (checkNomore(obj)) {
                this.mAdapter.showNoMoreContent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        this.mAdapter.hideFooter();
        setLoadingMore(false);
        us.pinguo.user.util.i.b(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0() {
        this.mAdapter.hideFooter();
        setLoadingMore(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o0 */
    public /* synthetic */ void p0(Object obj) {
        Subscription subscription = this.mLoadMoreSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mLoadMoreSubscription.unsubscribe();
        }
        getActivity().setResult(-1);
        if (obj != 0) {
            List<us.pinguo.widget.common.cell.recycler.b> list = null;
            if (obj != 0) {
                list = createCells(obj);
                if (this.mDeleteDuplicateEnabled) {
                    o.a(list);
                }
            }
            this.mFirstResp = obj;
            this.mLastResp = obj;
            this.mAdapter.beginChange();
            this.mAdapter.hideEmpty();
            this.mAdapter.hideLoading();
            this.mAdapter.hideError();
            if (list != null) {
                if (!this.mForceRefreshEnabled && !this.mRefreshAll) {
                    int headerCount = getHeaderCount();
                    if (list != null && this.mAdapter.getCells() != null) {
                        if (headerCount > 0) {
                            list.addAll(0, new ArrayList(this.mAdapter.getCells().subList(0, headerCount)));
                        }
                        this.mAdapter.set(list);
                        if (this.mAdapter.getItemCount() <= getHeaderCount() && this.mShowStateEnabled) {
                            this.mAdapter.showEmpty(getHeaderCount());
                        }
                        this.mAdapter.endChange(true);
                        onRefreshCellsAdded();
                        setLoadMoreEnabled(isLoadMoreEnable(obj));
                    }
                } else {
                    this.mAdapter.remove(getHeaderCount(), this.mAdapter.getItemCount() - 1);
                    this.mAdapter.addAll(getHeaderCount(), list);
                    if (this.mAdapter.getItemCount() <= getHeaderCount() && this.mShowStateEnabled) {
                        this.mAdapter.showEmpty(getHeaderCount());
                    }
                    if (this.mRefreshAll) {
                        this.mAdapter.endChange(false);
                        this.mAdapter.notifyDataSetChanged();
                    } else {
                        this.mAdapter.endChange(true);
                    }
                    onRefreshCellsAdded();
                    setLoadMoreEnabled(isLoadMoreEnable(obj));
                }
            } else {
                this.mAdapter.endChange(false);
                this.mAdapter.notifyDataSetChanged();
                setLoadMoreEnabled(isLoadMoreEnable(obj));
            }
        }
        this.mFirstRequest = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(Throwable th) {
        this.mAdapter.hideLoading();
        if (this.mRefreshLayout.isRefreshing() || !this.mFirstRequest || !this.mCacheLoaded || !this.mIgnoreErrorToast) {
            us.pinguo.user.util.i.b(th);
        }
        this.mRefreshLayout.setRefreshing(false);
        if ((th instanceof Fault) && Payload.FAULT_CODES.contains(Integer.valueOf(((Fault) th).getStatus()))) {
            this.mAdapter.showEmpty();
            return;
        }
        if (this.mShowStateEnabled && this.mAdapter.getItemCount() <= getHeaderCount()) {
            this.mAdapter.showError(getHeaderCount());
        }
        this.mFirstRequest = false;
    }

    private void refreshDataFromServer(T t) {
        if (getActivity() == null) {
            return;
        }
        if (t == null && this.mShowStateEnabled) {
            this.mAdapter.showLoading(getHeaderCount());
        }
        String str = getUrl() + getParam().hashCode();
        if (!this.mCacheEnabled) {
            str = null;
        }
        Subscription subscription = this.mLoadMoreSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mLoadMoreSubscription.unsubscribe();
        }
        addSubscription(this.mLoader.b(getUrl(), getParam(), str, getType()).subscribe(new Action1() { // from class: us.pinguo.inspire.base.easyload.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EasyListFragment.this.p0(obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.base.easyload.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EasyListFragment.this.r0((Throwable) obj);
            }
        }, new Action0() { // from class: us.pinguo.inspire.base.easyload.g
            @Override // rx.functions.Action0
            public final void call() {
                EasyListFragment.this.t0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0() {
        this.mFirstRequest = false;
        this.mAdapter.hideLoading();
        this.mRefreshLayout.setRefreshing(false);
    }

    protected abstract HashMap<String, String> addParamForPage(T t);

    protected abstract List<us.pinguo.widget.common.cell.recycler.b> appendCells(T t);

    protected boolean checkNomore(T t) {
        return false;
    }

    protected abstract List<us.pinguo.widget.common.cell.recycler.b> createCells(T t);

    protected int getHeaderCount() {
        return 0;
    }

    protected abstract HashMap<String, String> getParam();

    protected abstract Type getType();

    protected abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initConfig() {
        this.mCacheEnabled = true;
        this.mDeleteDuplicateEnabled = true;
        this.mShowStateEnabled = true;
        this.mForceRefreshEnabled = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
        loadData();
    }

    protected abstract void initTitle();

    protected abstract boolean isLoadMoreEnable(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadData() {
        addSubscription(this.mLoader.a(getUrl() + getParam().hashCode(), getType()).subscribe(new Action1() { // from class: us.pinguo.inspire.base.easyload.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EasyListFragment.this.f0(obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.base.easyload.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EasyListFragment.this.h0((Throwable) obj);
            }
        }));
    }

    protected void onCacheDataLoaded() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void onDataRefresh() {
        refreshDataFromServer(this.mFirstResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFirstFrameVisible() {
        super.onFirstFrameVisible();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void onLoadMore() {
        if (this.mRefreshLayout.isRefreshing() || this.mAdapter.isLoadingShowing()) {
            return;
        }
        HashMap<String, String> param = getParam();
        HashMap<String, String> addParamForPage = addParamForPage(this.mLastResp);
        if (addParamForPage != null) {
            param.putAll(addParamForPage);
        }
        Subscription subscribe = this.mLoader.b(getUrl(), param, null, getType()).subscribe(new Action1() { // from class: us.pinguo.inspire.base.easyload.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EasyListFragment.this.j0(obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.base.easyload.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EasyListFragment.this.l0((Throwable) obj);
            }
        }, new Action0() { // from class: us.pinguo.inspire.base.easyload.c
            @Override // rx.functions.Action0
            public final void call() {
                EasyListFragment.this.n0();
            }
        });
        this.mLoadMoreSubscription = subscribe;
        addSubscription(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadMoreCellsAdded() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRefreshCellsAdded() {
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mRootView = view;
        super.onViewCreated(view, bundle);
        setBackBtnVisiable(view);
        initTitle();
        initConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCacheEnabled(boolean z) {
        this.mCacheEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDeleteDuplicateEanbled(boolean z) {
        this.mDeleteDuplicateEnabled = z;
    }

    public void setForceRefreshEnabled(boolean z) {
        this.mForceRefreshEnabled = z;
    }

    public void setIgnoreErrorToast(boolean z) {
        this.mIgnoreErrorToast = z;
    }

    public void setRefreshAll(boolean z) {
        this.mRefreshAll = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setShowStateEnabled(boolean z) {
        this.mShowStateEnabled = z;
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
