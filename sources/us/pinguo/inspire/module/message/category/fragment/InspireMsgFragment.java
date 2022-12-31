package us.pinguo.inspire.module.message.category.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.cell.recycler.PortalChildEasyListFragment;
import us.pinguo.inspire.model.InspireMsgCountResp;
import us.pinguo.inspire.module.message.category.InspireMsgLoader;
import us.pinguo.inspire.module.message.category.cell.MessageAwardCell;
import us.pinguo.inspire.module.message.category.cell.MessageMainHeaderCell;
import us.pinguo.inspire.module.message.category.cell.MessageMainSystemCell;
import us.pinguo.inspire.module.message.category.entity.SystemMsg;
import us.pinguo.inspire.module.message.category.listener.OnMsgClickInterceptor;
import us.pinguo.inspire.module.message.category.vo.InspireSystemMsgResp;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.s0;
import us.pinguo.user.ui.FastLoginDialog;
import us.pinguo.user.ui.PGLoginMainActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireMsgFragment extends PortalChildEasyListFragment<InspireSystemMsgResp> {
    public static final String ACTION_INSPIRE_EDIT_USER = "app://camera360/profile/editinfo";
    public static final String ACTION_INSPIRE_FIND_FRIEND = "app://camera360/findfriend";
    public static final String IS_IN_PORTAL = "IS_IN_PORTAL";
    private FastLoginDialog mLoginDialog;
    private boolean mLoginDialogDismissed = true;
    private OnMsgClickInterceptor mOnMsgClickInterceptor = new OnMsgClickInterceptor() { // from class: us.pinguo.inspire.module.message.category.fragment.InspireMsgFragment.1
        @Override // us.pinguo.inspire.module.message.category.listener.OnMsgClickInterceptor
        public boolean onClick() {
            if (s0.getInstance().e()) {
                return false;
            }
            InspireMsgFragment.this.showLoginDialog();
            return true;
        }
    };
    private boolean mSelected;

    private void loadMsgCount() {
        addSubscription(InspireMsgLoader.getInstance().getMsgCountFromCache().subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.r
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMsgFragment.this.v0((InspireMsgCountResp) obj);
            }
        }, p.a));
    }

    private void loadMsgCountFromServer(final InspireMsgCountResp inspireMsgCountResp) {
        addSubscription(InspireMsgLoader.getInstance().getMsgCountFromServer().subscribe(new Action1() { // from class: us.pinguo.inspire.module.message.category.fragment.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireMsgFragment.this.y0(inspireMsgCountResp, (InspireMsgCountResp) obj);
            }
        }, s.a));
    }

    private void refresh() {
        if (this.mRefreshLayout != null) {
            initRecycleView(this.mRecyclerView, this.mAdapter);
            loadData();
            loadMsgCount();
        }
    }

    private void refreshShadowView() {
        List cells = this.mAdapter.getCells();
        if (cells != null) {
            for (int i2 = 1; i2 < cells.size() - 1; i2++) {
                us.pinguo.widget.common.cell.recycler.b bVar = (us.pinguo.widget.common.cell.recycler.b) cells.get(i2);
                if (bVar instanceof MessageMainSystemCell) {
                    MessageMainSystemCell messageMainSystemCell = (MessageMainSystemCell) bVar;
                    if (messageMainSystemCell.isLast()) {
                        messageMainSystemCell.setLast(false);
                        bVar.updateData(messageMainSystemCell.getData());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoginDialog() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
        Intent intent = new Intent();
        intent.setClass(activity, PGLoginMainActivity.class);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(InspireMsgCountResp inspireMsgCountResp) {
        if (inspireMsgCountResp != null) {
            this.mAdapter.getItem(0).updateData(inspireMsgCountResp);
        }
        loadMsgCountFromServer(inspireMsgCountResp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w0(Throwable th) {
        d.f.a.b.d.c(th);
        us.pinguo.foundation.e.e(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(InspireMsgCountResp inspireMsgCountResp, InspireMsgCountResp inspireMsgCountResp2) {
        if (inspireMsgCountResp2 != null && (inspireMsgCountResp == null || inspireMsgCountResp2.hashCode() != inspireMsgCountResp.hashCode())) {
            this.mAdapter.getItem(0).updateData(inspireMsgCountResp2);
        }
        if (inspireMsgCountResp2 == null || inspireMsgCountResp2.msgCount == null) {
            return;
        }
        InspireMsgLoader.getInstance().saveTabMsgCount(inspireMsgCountResp2.msgCount.getCount());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void clearNewStatus() {
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected int getHeaderCount() {
        return 1;
    }

    public boolean getNewStatus() {
        return false;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_Message_Page";
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId());
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public Type getType() {
        return new com.google.gson.t.a<BaseResponse<InspireSystemMsgResp>>() { // from class: us.pinguo.inspire.module.message.category.fragment.InspireMsgFragment.2
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/msg/userMsg/sysList";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initConfig() {
        super.initConfig();
        setIgnoreErrorToast(true);
        setShowStateEnabled(false);
        setRefreshAll(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        this.mAdapter.clear();
        MessageMainHeaderCell messageMainHeaderCell = new MessageMainHeaderCell(InspireMsgCountResp.NullMsgCount);
        messageMainHeaderCell.setOnMsgClickInterceptor(this.mOnMsgClickInterceptor);
        this.mAdapter.add(messageMainHeaderCell);
        setPullToRefreshEnabled(true);
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean(IS_IN_PORTAL)) {
            setTitle(R.string.msg_title);
            getDefaultToolbar().setNavigationIcon((Drawable) null);
            return;
        }
        setTitle(R.string.inspire_title_msg_mine);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public boolean onBackPressed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void onLoadMoreCellsAdded() {
        super.onLoadMoreCellsAdded();
        refreshShadowView();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogin() {
        refresh();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogout() {
        initRecycleView(this.mRecyclerView, this.mAdapter);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPageEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void onRefreshCellsAdded() {
        super.onRefreshCellsAdded();
        refreshShadowView();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mSelected) {
            onPageStart();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onSelected() {
        this.mSelected = true;
        onPageStart();
        refresh();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onUnSelected() {
        this.mSelected = false;
        onPageEnd();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        loadMsgCount();
        us.pinguo.foundation.g.d(false);
        us.pinguo.foundation.g.e(false);
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected boolean useDefaultPageStatistic() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public HashMap<String, String> addParamForPage(InspireSystemMsgResp inspireSystemMsgResp) {
        BigDecimal bigDecimal;
        HashMap<String, String> hashMap = new HashMap<>();
        if (inspireSystemMsgResp != null && (bigDecimal = inspireSystemMsgResp.sp) != null) {
            hashMap.put("sp", bigDecimal.toPlainString());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(InspireSystemMsgResp inspireSystemMsgResp) {
        return createCells(inspireSystemMsgResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(InspireSystemMsgResp inspireSystemMsgResp) {
        List<SystemMsg> list = inspireSystemMsgResp.list;
        if (list != null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < size) {
                SystemMsg systemMsg = inspireSystemMsgResp.list.get(i2);
                if (systemMsg.isAward()) {
                    MessageAwardCell messageAwardCell = new MessageAwardCell(systemMsg);
                    messageAwardCell.setLast(i2 == size + (-1));
                    arrayList.add(messageAwardCell);
                } else {
                    MessageMainSystemCell messageMainSystemCell = new MessageMainSystemCell(systemMsg);
                    messageMainSystemCell.setLast(i2 == size + (-1));
                    arrayList.add(messageMainSystemCell);
                }
                i2++;
            }
            return arrayList;
        }
        return null;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean isLoadMoreEnable(InspireSystemMsgResp inspireSystemMsgResp) {
        return inspireSystemMsgResp.sp.doubleValue() != -1.0d;
    }
}
