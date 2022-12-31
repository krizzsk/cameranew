package us.pinguo.inspire.module.discovery.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.easyload.EasySpListFragment;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.cell.DiscoveryWaterFallWorkCell;
import us.pinguo.inspire.module.discovery.decoration.DiscoverySquareDecoration;
import us.pinguo.inspire.module.discovery.entity.task.DiscoveryTaskResp;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.R;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class DiscoveryTaskFragment extends EasySpListFragment<DiscoveryTaskResp> {
    public static final String EXTRA_REC_ID = "recId";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_TYPE = "type";
    private static final int TYPE_HOT = 0;
    private static final int TYPE_OVER = 1;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoveryTaskFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tv_right_toolbar) {
                Context context = view.getContext();
                Intent intent = new Intent();
                intent.setClassName(context, "us.pinguo.inspire.module.MissionDetail.TaskDetailActivity");
                intent.putExtra("task_id", DiscoveryTaskFragment.this.getArguments().getString("recId"));
                context.startActivity(intent);
            }
        }
    };

    private List<us.pinguo.widget.common.cell.recycler.b> createCellList(DiscoveryTaskResp discoveryTaskResp) {
        ArrayList arrayList = new ArrayList();
        for (InspireWork inspireWork : discoveryTaskResp.work) {
            arrayList.add(new DiscoveryWaterFallWorkCell(inspireWork));
        }
        return arrayList;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("taskId", getArguments().getString("recId"));
        hashMap.put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId());
        hashMap.put("sp", "1");
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public Type getType() {
        return new com.google.gson.t.a<BaseResponse<DiscoveryTaskResp>>() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoveryTaskFragment.2
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        int i2 = getArguments().getInt("type");
        return i2 != 0 ? i2 != 1 ? "/feed/hotVideo" : "/discover/overTask" : "/discover/hotTask";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        this.mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.mRecyclerView.addItemDecoration(new DiscoverySquareDecoration(us.pinguo.foundation.t.b.a.a(getActivity(), 7.5f)));
        setLoadMoreEnabled(true);
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        setTitle(getArguments().getString("title"));
        View view = this.mRootView;
        int i2 = R.id.tv_right_toolbar;
        TextView textView = (TextView) view.findViewById(i2);
        textView.setVisibility(0);
        textView.setText(vStudio.Android.Camera360.R.string.goto_challenge);
        textView.setTextColor(-465124);
        setOnClickListener(this.mRootView, i2, this.onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(DiscoveryTaskResp discoveryTaskResp) {
        return createCellList(discoveryTaskResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(DiscoveryTaskResp discoveryTaskResp) {
        return createCellList(discoveryTaskResp);
    }
}
