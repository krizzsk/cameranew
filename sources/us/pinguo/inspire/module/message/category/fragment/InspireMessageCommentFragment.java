package us.pinguo.inspire.module.message.category.fragment;

import android.os.Bundle;
import android.view.View;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.module.message.category.InspireMsgLoader;
import us.pinguo.inspire.module.message.category.cell.MessageCommentAtCell;
import us.pinguo.inspire.module.message.category.cell.MessageCommentCell;
import us.pinguo.inspire.module.message.category.cell.MessageCommentFlowerCell;
import us.pinguo.inspire.module.message.category.cell.MessageLikeCell;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.message.category.vo.InspireMsgResp;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireMessageCommentFragment extends BaseAbsListFragment {
    private static final int SP_NO_MORE_ITEMS = -1;
    private InspireMsgResp mFirstPageInspireMsgs;
    private InspireMsgResp mLastResp;
    private MessageType mMessageType;

    private ArrayList<us.pinguo.widget.common.cell.recycler.b> createList(List<InspireMsg> list) {
        if (list != null) {
            int size = list.size();
            ArrayList<us.pinguo.widget.common.cell.recycler.b> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                InspireMsg inspireMsg = list.get(i2);
                if ("comment".equals(inspireMsg.type)) {
                    arrayList.add(new MessageCommentCell(inspireMsg));
                } else if ("like".equals(inspireMsg.type)) {
                    arrayList.add(new MessageLikeCell(inspireMsg));
                } else if (InspireMsg.TYPE_AT.equals(inspireMsg.type)) {
                    arrayList.add(new MessageCommentAtCell(inspireMsg));
                } else if (!InspireMsg.TYPE_RELAY.equals(inspireMsg.type) && InspireMsg.TYPE_FLOWER.equals(inspireMsg.type)) {
                    arrayList.add(new MessageCommentFlowerCell(inspireMsg));
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(InspireMsgResp inspireMsgResp) {
        this.mFirstPageInspireMsgs = inspireMsgResp;
        this.mLastResp = inspireMsgResp;
        if (inspireMsgResp != null) {
            this.mAdapter.addAll(createList(inspireMsgResp.list));
            setLoadMoreEnabled(!new BigDecimal(-1).equals(inspireMsgResp.sp));
        }
        refreshMsgFromServer(inspireMsgResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        refreshMsgFromServer(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(InspireMsgResp inspireMsgResp) {
        this.mAdapter.hideFooter();
        if (inspireMsgResp != null) {
            this.mAdapter.addAll(createList(inspireMsgResp.list));
            this.mLastResp = inspireMsgResp;
            setLoadMoreEnabled(!new BigDecimal(-1).equals(inspireMsgResp.sp));
        }
    }

    private void initData() {
        this.mRefreshLayout.setRefreshing(true);
        loadMsg();
    }

    private void initViews() {
        MessageType messageType = (MessageType) getArguments().getSerializable("KEY_MESSAGE_TYPE");
        this.mMessageType = messageType;
        if (messageType == MessageType.COMMENT) {
            setTitle(R.string.msg_comment);
        } else if (messageType == MessageType.LIKE) {
            setTitle(R.string.msg_like);
        } else if (messageType == MessageType.AT) {
            setTitle(R.string.at_mine);
        } else if (messageType == MessageType.FLOWER) {
            setTitle(R.string.flower);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.user.util.i.b(th);
        this.mAdapter.hideFooter();
        us.pinguo.common.log.a.f(th);
    }

    private void loadMsg() {
        addSubscription(InspireMsgLoader.getInstance().getMessageFromCache(this.mMessageType).subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageCommentFragment.this.f0((InspireMsgResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageCommentFragment.this.h0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0() {
        this.mAdapter.hideFooter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(InspireMsgResp inspireMsgResp, InspireMsgResp inspireMsgResp2) {
        getActivity().setResult(-1);
        if (inspireMsgResp2 != null) {
            if (!us.pinguo.inspire.util.o.b(inspireMsgResp2, inspireMsgResp)) {
                ArrayList<us.pinguo.widget.common.cell.recycler.b> createList = createList(inspireMsgResp2.list);
                this.mFirstPageInspireMsgs = inspireMsgResp2;
                this.mLastResp = inspireMsgResp2;
                this.mAdapter.clear();
                this.mAdapter.addAll(createList);
            }
            setLoadMoreEnabled(!new BigDecimal(-1).equals(inspireMsgResp2.sp));
        }
        if (this.mAdapter.getItemCount() == 0) {
            us.pinguo.inspire.base.c.f(this.mAdapter, this.mMessageType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        this.mAdapter.showError();
        us.pinguo.user.util.i.b(th);
        this.mRefreshLayout.setRefreshing(false);
    }

    private void refreshMsgFromServer(final InspireMsgResp inspireMsgResp) {
        addSubscription(InspireMsgLoader.getInstance().getInspireMsgRespFromServer(new BigDecimal(0), this.mMessageType, true).subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageCommentFragment.this.p0(inspireMsgResp, (InspireMsgResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageCommentFragment.this.r0((Throwable) obj);
            }
        }, new Action0() { // from class: us.pinguo.inspire.module.message.category.fragment.d
            @Override // rx.functions.Action0
            public final void call() {
                InspireMessageCommentFragment.this.t0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0() {
        this.mRefreshLayout.setRefreshing(false);
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
        addSubscription(InspireMsgLoader.getInstance().getInspireMsgRespFromServer(bigDecimal, this.mMessageType, false).subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageCommentFragment.this.j0((InspireMsgResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMessageCommentFragment.this.l0((Throwable) obj);
            }
        }, new Action0() { // from class: us.pinguo.inspire.module.message.category.fragment.h
            @Override // rx.functions.Action0
            public final void call() {
                InspireMessageCommentFragment.this.n0();
            }
        }));
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initViews();
        setBackBtnVisiable(view);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
