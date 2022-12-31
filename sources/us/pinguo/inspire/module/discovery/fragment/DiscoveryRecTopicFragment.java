package us.pinguo.inspire.module.discovery.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.easyload.EasySpListFragment;
import us.pinguo.inspire.module.discovery.cell.topic.RecommendTopicCell;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryRec;
import us.pinguo.inspire.module.discovery.entity.topic.DiscoveryRecResp;
import us.pinguo.inspire.widget.g;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryRecTopicFragment extends EasySpListFragment<DiscoveryRecResp> {
    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_SelectedTopic_List_Page";
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sp", "1");
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected Type getType() {
        return new com.google.gson.t.a<BaseResponse<DiscoveryRecResp>>() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoveryRecTopicFragment.1
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/discover/rec";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        recyclerView.addItemDecoration(new g(us.pinguo.foundation.t.b.a.a(recyclerView.getContext(), 12.0f), us.pinguo.foundation.t.b.a.a(recyclerView.getContext(), 12.0f)));
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        String string = getArguments() == null ? "" : getArguments().getString("KEY_TITLE");
        if (!TextUtils.isEmpty(string)) {
            setTitle(string);
        } else {
            setTitle(R.string.selected_topics);
        }
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(DiscoveryRecResp discoveryRecResp) {
        return createCells(discoveryRecResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(DiscoveryRecResp discoveryRecResp) {
        List<DiscoveryRec> list;
        ArrayList arrayList = new ArrayList();
        if (discoveryRecResp != null && (list = discoveryRecResp.items) != null) {
            for (DiscoveryRec discoveryRec : list) {
                arrayList.add(new RecommendTopicCell(discoveryRec));
            }
        }
        return arrayList;
    }
}
