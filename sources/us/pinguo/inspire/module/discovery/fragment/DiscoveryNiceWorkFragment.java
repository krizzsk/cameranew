package us.pinguo.inspire.module.discovery.fragment;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.easyload.EasySpListFragment;
import us.pinguo.inspire.cell.recycler.c;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.cell.RecommendBannerCell;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.RecommendBanner;
import us.pinguo.inspire.module.discovery.entity.nicework.DiscoveryNiceWorkResp;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsVideoCell;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.util.x;
import us.pinguo.inspire.widget.videocell.e;
import us.pinguo.inspire.widget.videocell.f;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryNiceWorkFragment extends EasySpListFragment<DiscoveryNiceWorkResp> {
    public static final String EXTRA_REC_ID = "recId";
    protected f mPresenter;
    private Toolbar mToolbar;

    private List<us.pinguo.widget.common.cell.recycler.b> createWorkCells(DiscoveryNiceWorkResp discoveryNiceWorkResp) {
        ArrayList arrayList = new ArrayList();
        List<InspireWork> list = discoveryNiceWorkResp.work;
        if (list != null) {
            for (InspireWork inspireWork : list) {
                InspireFeed convertWorkToFeed = InspireFeed.convertWorkToFeed(inspireWork);
                String str = convertWorkToFeed.type;
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case 104256825:
                        if (str.equals(InspireFeed.TYPE_MULTI)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 106642994:
                        if (str.equals("photo")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 112202875:
                        if (str.equals("video")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        FeedsPhotoCell feedsPhotoCell = new FeedsPhotoCell(convertWorkToFeed);
                        feedsPhotoCell.setShowTime(false);
                        arrayList.add(feedsPhotoCell);
                        break;
                    case 1:
                        FeedsPhotoCell feedsPhotoCell2 = new FeedsPhotoCell(convertWorkToFeed);
                        feedsPhotoCell2.setShowTime(false);
                        arrayList.add(feedsPhotoCell2);
                        break;
                    case 2:
                        FeedsVideoCell feedsVideoCell = new FeedsVideoCell(convertWorkToFeed);
                        feedsVideoCell.setShowTime(false);
                        arrayList.add(feedsVideoCell);
                        break;
                }
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_SelectedTopic_Detail_Page";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public String getPageShowParam() {
        String string = getArguments().getString("recId");
        return "topic_id=" + string + "," + super.getPageShowParam();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        String string = getArguments().getString("recId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("recId", string);
        hashMap.put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId());
        hashMap.put("sp", "1");
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public Type getType() {
        return new com.google.gson.t.a<BaseResponse<DiscoveryNiceWorkResp>>() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoveryNiceWorkFragment.1
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/discover/niceWork";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initConfig() {
        f fVar = new f(this.mRecyclerView, (e) this.mAdapter);
        this.mPresenter = fVar;
        ((e) this.mAdapter).setVideoLoadCompleteListener(fVar.getVideoLoadCompleteListener());
        ((e) this.mAdapter).setInspireVideoPresenter(this.mPresenter);
        this.mPresenter.onViewCreated();
        this.mPresenter.setSilent(true);
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
        recyclerView.setTag(this);
        recyclerView.addItemDecoration(new c(getActivity(), 12, 1, false));
        this.mAdapter.add(new RecommendBannerCell(new RecommendBanner("drawable://2097479978", "", "", "")));
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        this.mTitleContainer.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        FeedsList.onActivityResult(i2, i3, intent, this.mRecyclerView);
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

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPresenter.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(DiscoveryNiceWorkResp discoveryNiceWorkResp) {
        return createWorkCells(discoveryNiceWorkResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(DiscoveryNiceWorkResp discoveryNiceWorkResp) {
        ArrayList arrayList = new ArrayList();
        this.mToolbar.setTitle(discoveryNiceWorkResp.desc);
        arrayList.add(new RecommendBannerCell(new RecommendBanner(discoveryNiceWorkResp.cover, discoveryNiceWorkResp.title, discoveryNiceWorkResp.desc, discoveryNiceWorkResp.detail)));
        arrayList.addAll(createWorkCells(discoveryNiceWorkResp));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public e initAdapter() {
        return new e();
    }
}
