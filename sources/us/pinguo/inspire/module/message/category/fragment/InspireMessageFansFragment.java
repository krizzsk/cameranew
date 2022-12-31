package us.pinguo.inspire.module.message.category.fragment;

import android.os.Bundle;
import android.view.View;
import java.math.BigDecimal;
import java.util.ArrayList;
import rx.functions.Action0;
import rx.functions.Action1;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.module.message.category.InspireMsgLoader;
import us.pinguo.inspire.module.message.category.cell.MessageFansCell;
import us.pinguo.inspire.module.message.category.vo.InspireMsgResp;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireMessageFansFragment extends BaseAbsListFragment {
    private static final int SP_NO_MORE_ITEMS = -1;
    private InspireMsgResp mFirstPageInspireMsgs;
    private InspireMsgResp mLastResp;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(InspireMsgResp inspireMsgResp) {
        this.mFirstPageInspireMsgs = inspireMsgResp;
        this.mLastResp = inspireMsgResp;
        if (inspireMsgResp != null) {
            this.mAdapter.addAll(MessageFansCell.createList(inspireMsgResp.list));
            setLoadMoreEnabled(!new BigDecimal(-1).equals(inspireMsgResp.sp));
        }
        refreshMsgFromServer(inspireMsgResp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void i0(InspireMsgResp inspireMsgResp) {
        this.mAdapter.hideFooter();
        if (inspireMsgResp != null) {
            this.mAdapter.addAll(MessageFansCell.createList(inspireMsgResp.list));
            this.mLastResp = inspireMsgResp;
            setLoadMoreEnabled(!new BigDecimal(-1).equals(inspireMsgResp.sp));
        }
    }

    private void initData() {
        loadMsg();
    }

    private void initViews() {
        setTitle(R.string.msg_fans);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void k0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mAdapter.hideFooter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m0(InspireMsgResp inspireMsgResp, InspireMsgResp inspireMsgResp2) {
        getActivity().setResult(-1);
        if (inspireMsgResp2 != null) {
            if (!us.pinguo.inspire.util.o.b(inspireMsgResp2, inspireMsgResp)) {
                ArrayList<us.pinguo.widget.common.cell.recycler.b> createList = MessageFansCell.createList(inspireMsgResp2.list);
                this.mFirstPageInspireMsgs = inspireMsgResp2;
                this.mLastResp = inspireMsgResp2;
                this.mAdapter.clear();
                this.mAdapter.addAll(createList);
            }
            setLoadMoreEnabled(!new BigDecimal(-1).equals(inspireMsgResp2.sp));
        }
        if (this.mAdapter.getItemCount() == 0) {
            this.mAdapter.showEmpty();
        }
    }

    private void loadMsg() {
        addSubscription(InspireMsgLoader.getInstance().getMessageFromCache(MessageType.FANS).subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageFansFragment.this.f0((InspireMsgResp) obj);
            }
        }, k.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mAdapter.showError();
        this.mRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void q0() {
        this.mRefreshLayout.setRefreshing(false);
    }

    private void refreshMsgFromServer(final InspireMsgResp inspireMsgResp) {
        if (inspireMsgResp == null) {
            this.mAdapter.showLoading();
        }
        addSubscription(InspireMsgLoader.getInstance().getInspireMsgRespFromServer(new BigDecimal(0), MessageType.FANS, true).subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageFansFragment.this.m0(inspireMsgResp, (InspireMsgResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageFansFragment.this.o0((Throwable) obj);
            }
        }, new Action0() { // from class: us.pinguo.inspire.module.message.category.fragment.l
            @Override // rx.functions.Action0
            public final void call() {
                InspireMessageFansFragment.this.q0();
            }
        }));
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
        refreshMsgFromServer(this.mFirstPageInspireMsgs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFirstFrameVisible() {
        super.onFirstFrameVisible();
        initData();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        BigDecimal bigDecimal = new BigDecimal(0);
        InspireMsgResp inspireMsgResp = this.mLastResp;
        if (inspireMsgResp != null) {
            bigDecimal = inspireMsgResp.sp;
        }
        addSubscription(InspireMsgLoader.getInstance().getInspireMsgRespFromServer(bigDecimal, MessageType.FANS, false).subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageFansFragment.this.i0((InspireMsgResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.o
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageFansFragment.this.k0((Throwable) obj);
            }
        }));
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initViews();
        getContainerView().setBackgroundColor(-1);
        setBackBtnVisiable(view);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
