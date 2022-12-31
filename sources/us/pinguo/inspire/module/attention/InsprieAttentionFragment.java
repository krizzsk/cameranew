package us.pinguo.inspire.module.attention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InsprieAttentionFragment extends BaseAbsListFragment implements IAttentionView {
    public static final String MASTER_ID_KEY = "master_id";
    private InspireAttentionPresenter mAttentionPresenter;
    private String mFrom;
    private String mMasterUserId;

    private List<us.pinguo.widget.common.cell.recycler.b> getCells(List<InspireAttention> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(new AttentionItemCell(list.get(i2)));
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public void appendDataList(List<InspireAttention> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mAdapter.addAll(getCells(list));
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public String getMasterUserId() {
        String str = this.mMasterUserId;
        return str == null ? s0.getInstance().getUserId() : str;
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public int getType() {
        return this.mFrom.equals(AttentionActivity.FROM_ATTENTION) ? 1 : 2;
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public void hideLoadMore() {
        this.mAdapter.hideFooter();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        initView();
        InspireAttentionPresenter inspireAttentionPresenter = new InspireAttentionPresenter();
        this.mAttentionPresenter = inspireAttentionPresenter;
        inspireAttentionPresenter.attachView(this);
        replaceTitle(null);
        this.mAdapter.showLoading();
    }

    public void initView() {
    }

    public boolean isFansList() {
        return getType() == 2;
    }

    public boolean isMyPersonalCenter() {
        return this.mMasterUserId.equals(s0.getInstance().getUserId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        us.pinguo.common.log.a.m("InsprieAttentionFragment", "onActivityResult.........." + i2, new Object[0]);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mMasterUserId = getArguments().getString(MASTER_ID_KEY);
        this.mFrom = getArguments().getString(AttentionActivity.FROM_KEY);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
        if (this.mAttentionPresenter != null) {
            String userId = s0.getInstance().getUserId();
            if (getType() == 1) {
                this.mAttentionPresenter.fetchFollows(userId, getMasterUserId());
            } else {
                this.mAttentionPresenter.fetchFans(userId, getMasterUserId());
            }
        }
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        InspireAttentionPresenter inspireAttentionPresenter = this.mAttentionPresenter;
        if (inspireAttentionPresenter != null) {
            inspireAttentionPresenter.detachView();
            this.mAttentionPresenter = null;
        }
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        if (this.mAttentionPresenter != null) {
            String userId = s0.getInstance().getUserId();
            if (getType() == 1) {
                this.mAttentionPresenter.loadMoreFollows(userId, getMasterUserId(), this.mAttentionPresenter.getAttentionSp());
            } else {
                this.mAttentionPresenter.loadMoreFans(userId, getMasterUserId(), this.mAttentionPresenter.getFansSp());
            }
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public void removeItem(AttentionItemCell attentionItemCell) {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null) {
            return;
        }
        cVar.remove(attentionItemCell);
        this.mAdapter.notifyItemChanged(this.mAdapter.indexOf(attentionItemCell));
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public void setAttentionList(List<InspireAttention> list) {
        if (list != null && list.size() != 0) {
            this.mAdapter.set(getCells(list));
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        us.pinguo.inspire.base.c.a(this.mAdapter, !TextUtils.isDigitsOnly(this.mMasterUserId) && this.mMasterUserId.equals(s0.getInstance().getUserId()));
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public void setComplete() {
        this.mAdapter.hideLoading();
        onRefreshComplete();
    }

    @Override // us.pinguo.inspire.module.attention.IAttentionView
    public void showFansList(List<InspireAttention> list) {
        if (list != null && list.size() != 0) {
            this.mAdapter.set(getCells(list));
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        us.pinguo.inspire.base.c.c(this.mAdapter, !TextUtils.isDigitsOnly(this.mMasterUserId) && this.mMasterUserId.equals(s0.getInstance().getUserId()));
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
