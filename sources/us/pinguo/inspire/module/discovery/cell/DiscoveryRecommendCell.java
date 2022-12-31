package us.pinguo.inspire.module.discovery.cell;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.decoration.RecommendChildCellDecoration;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryRec;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryRecommendCell extends us.pinguo.widget.common.cell.recycler.b<List<DiscoveryRec>, c> implements View.OnClickListener {

    /* loaded from: classes9.dex */
    private static class MyItemDecoration extends RecyclerView.ItemDecoration {
        private int space = (int) (us.pinguo.foundation.t.b.a.j(Inspire.a()) * 0.025d);

        private MyItemDecoration() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.right = this.space;
            rect.left = 0;
        }
    }

    public DiscoveryRecommendCell(List<DiscoveryRec> list) {
        super(list);
    }

    private List<us.pinguo.widget.common.cell.recycler.b> createCells(List<DiscoveryRec> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (DiscoveryRec discoveryRec : list) {
                arrayList.add(new DiscoveryRecommendChildCell(discoveryRec));
            }
            return arrayList;
        }
        return null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discovery_square_recommend_cell, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_discovery_square_hot);
        recyclerView.addItemDecoration(new RecommendChildCellDecoration(us.pinguo.foundation.t.b.a.a(recyclerView.getContext(), 12.0f)));
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext(), 0, false));
        return new c(inflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return DiscoverySquareCellType.RECOMMEND.ordinal();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) cVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        us.pinguo.widget.common.cell.recycler.a aVar = new us.pinguo.widget.common.cell.recycler.a();
        ((RecyclerView) cVar.getView(R.id.rv_discovery_square_hot)).setAdapter(aVar);
        aVar.addAll(createCells((List) this.mData));
        cVar.setOnClickListener(R.id.ll_more_recommend_cell, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ll_more_recommend_cell) {
            l.onEvent(view.getContext(), "Community_Discovery_SelectedTopic_More_Click");
            AppGoto.getInstance().c("app://camera360.discovery.topiclist").b(view.getContext());
        }
    }
}
