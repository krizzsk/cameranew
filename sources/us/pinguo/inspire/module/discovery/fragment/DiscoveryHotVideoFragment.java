package us.pinguo.inspire.module.discovery.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.easyload.EasySpListFragment;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.cell.hotvideo.HotVideoCell;
import us.pinguo.inspire.module.discovery.cell.hotvideo.HotVideoOccupyCell;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryHotVideoResp;
import us.pinguo.inspire.module.discovery.presenter.HotVideoPresenter;
import us.pinguo.inspire.util.x;
import us.pinguo.inspire.widget.videocell.e;
import us.pinguo.user.a1.m;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryHotVideoFragment extends EasySpListFragment<DiscoveryHotVideoResp> {
    public static final String WORK_ID = "workId";
    private boolean mFirstTimeRequestData = true;
    protected HotVideoPresenter mPresenter;
    private Toolbar mToolbar;
    private String mWorkId;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ boolean v0(MenuItem menuItem) {
        getActivity().onBackPressed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(DiscoveryHotVideoResp discoveryHotVideoResp) {
        return null;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "enter_hot_video_page";
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        String string = getArguments() != null ? getArguments().getString(WORK_ID) : "";
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.mFirstTimeRequestData && !TextUtils.isEmpty(string)) {
            hashMap.put("vId", string);
        }
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public Type getType() {
        return new com.google.gson.t.a<BaseResponse<DiscoveryHotVideoResp>>() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment.1
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/feed/hotVideo";
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initConfig() {
        super.initConfig();
        setCacheEnabled(false);
        setLoadMoreEnabled(false);
        setDeleteDuplicateEanbled(false);
        this.mPresenter = new HotVideoPresenter(this.mRecyclerView, (e) this.mAdapter);
        ((e) this.mAdapter).setVideoLoadCompleteListener(null);
        ((e) this.mAdapter).setInspireVideoPresenter(this.mPresenter);
        this.mPresenter.onViewCreated();
        this.mPresenter.setSilent(false);
        adddOnDataRefreshListener(this.mPresenter);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initHeaderTitleBar(View view) {
        this.mTitleContainer.setVisibility(8);
        view.findViewById(R.id.base_fragment_title_container_res_0x7d060019).setVisibility(0);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.base_fragment_header_tool_bar_res_0x7d060017);
        this.mToolbar = toolbar;
        toolbar.setTitleTextAppearance(getActivity(), us.pinguo.user.R.style.ToolBar_TextSize);
        this.mToolbar.setTitleTextColor(-1);
        String string = getArguments() != null ? getArguments().getString("KEY_TITLE") : null;
        Toolbar toolbar2 = this.mToolbar;
        if (string == null) {
            string = getString(R.string.featured_videos);
        }
        toolbar2.setTitle(string);
        this.mToolbar.inflateMenu(R.menu.hot_video_menu);
        x.a(this.mToolbar, this.mRecyclerView);
        this.mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: us.pinguo.inspire.module.discovery.fragment.a
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DiscoveryHotVideoFragment.this.v0(menuItem);
            }
        });
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mPresenter.onDestroyView();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPresenter.onPause();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void onRefreshCellsAdded() {
        super.onRefreshCellsAdded();
        this.mPresenter.stopCurrentVideo();
        this.mPresenter.onRefreshCellsAdded(this.mWorkId);
        this.mFirstTimeRequestData = false;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPresenter.onResume();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setBackgroundColor(view.getResources().getColor(R.color.hot_video_page_bg));
        this.mWorkId = getArguments() != null ? getArguments().getString(WORK_ID) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(DiscoveryHotVideoResp discoveryHotVideoResp) {
        ArrayList arrayList = new ArrayList();
        List<InspireWork> list = discoveryHotVideoResp.items;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            arrayList.add(new HotVideoOccupyCell(discoveryHotVideoResp.items.get(0)));
            while (true) {
                InspireWork inspireWork = null;
                if (i2 >= discoveryHotVideoResp.items.size()) {
                    break;
                }
                InspireWork inspireWork2 = discoveryHotVideoResp.items.get(i2);
                if (i2 < discoveryHotVideoResp.items.size() - 1) {
                    inspireWork = discoveryHotVideoResp.items.get(i2 + 1);
                }
                arrayList.add(new HotVideoCell(inspireWork2, inspireWork));
                i2++;
            }
            arrayList.add(new HotVideoOccupyCell(null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public e initAdapter() {
        e eVar = new e();
        m mVar = (m) eVar.getLodingCell();
        if (mVar != null) {
            mVar.b(getActivity().getResources().getColor(R.color.video_bg));
        }
        return eVar;
    }
}
