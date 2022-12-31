package us.pinguo.inspire.module.feeds.model;

import android.app.Activity;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.foundation.R;
import us.pinguo.inspire.module.feeds.IFeedsView;
import us.pinguo.inspire.module.feeds.cell.FeedsFollowTitleCell;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
import us.pinguo.inspire.widget.InspireToast;
/* loaded from: classes9.dex */
public class FeedsFollowPresenter extends us.pinguo.foundation.p.a {
    private IFeedsView mFeedsView;
    private boolean mFirstRefresh = true;
    private Handler mHandler;
    private boolean mRefreshed;
    private List<us.pinguo.widget.common.cell.recycler.b> mUploadFailCells;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(List list) {
        IFeedsView iFeedsView;
        if (this.mRefreshed || (iFeedsView = this.mFeedsView) == null) {
            return;
        }
        iFeedsView.refreshFeedsAfterTopCells(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(Throwable th) {
        IFeedsView iFeedsView;
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        if (this.mRefreshed || (iFeedsView = this.mFeedsView) == null) {
            return;
        }
        iFeedsView.refreshFeedsAfterTopCells(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(List list) {
        this.mFeedsView.addData(list, FeedsFollowManager.NO_MORE_SP.equals(FeedsFollowManager.sSp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mFeedsView.addData(new ArrayList(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(List list) {
        this.mFirstRefresh = false;
        if (list != null && list.size() > 0) {
            this.mRefreshed = true;
        }
        IFeedsView iFeedsView = this.mFeedsView;
        if (iFeedsView != null) {
            iFeedsView.refreshFeedsAfterTopCells(list);
            this.mFeedsView.stopRefreshAnim();
        }
        if (list != null && list.size() > 0 && (list.get(0) instanceof FeedsFollowTitleCell)) {
            this.mFeedsView.disableLoadMore();
        } else {
            this.mFeedsView.enableLoadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(Activity activity, Throwable th) {
        us.pinguo.foundation.e.e(th);
        if (us.pinguo.user.util.m.a(th)) {
            us.pinguo.user.util.m.b(activity);
            InspireToast.makeText(activity, R.string.user_expired, 0).show();
        } else if (!this.mFirstRefresh || this.mFeedsView.getAdapter().getItemCount() <= FeedsTopManager.getTopCellCount(this.mFeedsView.getAdapter().getCells())) {
            us.pinguo.user.util.i.b(th);
        }
        us.pinguo.common.log.a.f(th);
        IFeedsView iFeedsView = this.mFeedsView;
        if (iFeedsView != null) {
            iFeedsView.showErrorWhenEmpty();
            this.mFeedsView.stopRefreshAnim();
        }
        this.mFirstRefresh = false;
    }

    private void loadLocalCacheFeeds() {
        addSubscription(FeedsFollowManager.loadCacheFollowFeeds().subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.model.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.b((List) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.feeds.model.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.d((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(us.pinguo.inspire_proxy.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.mFeedsView.deleteWork(aVar.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(UpdatePublishStateEvent updatePublishStateEvent) {
        IFeedsView iFeedsView = this.mFeedsView;
        if (iFeedsView != null) {
            iFeedsView.onUpdatePublishStateEvent(updatePublishStateEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(final UpdatePublishStateEvent updatePublishStateEvent) {
        if (updatePublishStateEvent == null || updatePublishStateEvent.getFilterType() != 0) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: us.pinguo.inspire.module.feeds.model.l
            @Override // java.lang.Runnable
            public final void run() {
                FeedsFollowPresenter.this.q(updatePublishStateEvent);
            }
        });
    }

    private void registerFeedDeleteObserver() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire_proxy.a.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.model.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.o((us.pinguo.inspire_proxy.a.a) obj);
            }
        }, g.a));
    }

    private void registerUpdatePublishStateEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(UpdatePublishStateEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.model.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.s((UpdatePublishStateEvent) obj);
            }
        }, i.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        this.mFeedsView = (IFeedsView) bVar;
        this.mRefreshed = false;
        this.mFirstRefresh = true;
        this.mHandler = new Handler();
        this.mUploadFailCells = FeedsFollowManager.getUploadStateCells();
        registerUpdatePublishStateEvent();
        registerFeedDeleteObserver();
    }

    @Override // us.pinguo.foundation.p.a
    public void detachView() {
        super.detachView();
        this.mFeedsView = null;
    }

    public void initData(Activity activity) {
        if (!us.pinguo.foundation.utils.k.a(this.mUploadFailCells)) {
            this.mFeedsView.setData(this.mUploadFailCells);
        }
        loadLocalCacheFeeds();
        refresh(activity);
    }

    public void loadMore() {
        addSubscription(FeedsFollowManager.loadMoreFeeds().subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.model.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.f((List) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.feeds.model.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.h((Throwable) obj);
            }
        }));
    }

    public void refresh(final Activity activity) {
        addSubscription(FeedsFollowManager.refreshFollowFeeds().subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.model.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.j((List) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.feeds.model.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsFollowPresenter.this.l(activity, (Throwable) obj);
            }
        }));
    }
}
