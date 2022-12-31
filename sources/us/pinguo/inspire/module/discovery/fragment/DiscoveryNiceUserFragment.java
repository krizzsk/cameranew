package us.pinguo.inspire.module.discovery.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.easyload.EasyListFragment;
import us.pinguo.inspire.module.discovery.cell.RecommendBannerCell;
import us.pinguo.inspire.module.discovery.cell.niceuser.NiceUserCell;
import us.pinguo.inspire.module.discovery.entity.RecommendBanner;
import us.pinguo.inspire.module.discovery.entity.niceuser.DiscoveryNiceUserResponse;
import us.pinguo.inspire.module.discovery.entity.niceuser.NiceUser;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.util.x;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryNiceUserFragment extends EasyListFragment<DiscoveryNiceUserResponse> {
    public static final String EXTRA_REC_ID = "recId";
    private Toolbar mToolbar;

    private List<us.pinguo.widget.common.cell.recycler.b> createWorkCells(DiscoveryNiceUserResponse discoveryNiceUserResponse) {
        ArrayList arrayList = new ArrayList();
        List<NiceUser> list = discoveryNiceUserResponse.user;
        if (list != null) {
            for (NiceUser niceUser : list) {
                arrayList.add(new NiceUserCell(niceUser));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public HashMap<String, String> addParamForPage(DiscoveryNiceUserResponse discoveryNiceUserResponse) {
        return null;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_SelectedTopic_Detail_Page";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public String getPageShowParam() {
        String string = getArguments() != null ? getArguments().getString("recId") : "";
        return "topic_id=" + string + "," + super.getPageShowParam();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        String string = getArguments() != null ? getArguments().getString("recId") : "";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("recId", string);
        hashMap.put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId());
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public Type getType() {
        return new com.google.gson.t.a<BaseResponse<DiscoveryNiceUserResponse>>() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoveryNiceUserFragment.1
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/discover/niceUser";
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initHeaderTitleBar(View view) {
        super.initHeaderTitleBar(view);
        this.mTitleContainer.setVisibility(8);
        view.findViewById(R.id.base_fragment_title_container_res_0x7d060019).setVisibility(0);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.base_fragment_header_tool_bar_res_0x7d060017);
        this.mToolbar = toolbar;
        x.b(toolbar, this.mRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        recyclerView.addItemDecoration(new us.pinguo.inspire.cell.recycler.b(12));
        this.mAdapter.add(new RecommendBannerCell(new RecommendBanner("drawable://2097479978", "", "", "")));
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        this.mTitleContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean isLoadMoreEnable(DiscoveryNiceUserResponse discoveryNiceUserResponse) {
        return false;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(DiscoveryNiceUserResponse discoveryNiceUserResponse) {
        return createWorkCells(discoveryNiceUserResponse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(DiscoveryNiceUserResponse discoveryNiceUserResponse) {
        ArrayList arrayList = new ArrayList();
        RecommendBanner recommendBanner = new RecommendBanner(discoveryNiceUserResponse.cover, discoveryNiceUserResponse.title, discoveryNiceUserResponse.desc, discoveryNiceUserResponse.detail);
        this.mToolbar.setTitle(discoveryNiceUserResponse.desc);
        arrayList.add(new RecommendBannerCell(recommendBanner));
        arrayList.addAll(createWorkCells(discoveryNiceUserResponse));
        return arrayList;
    }
}
