package us.pinguo.inspire.module.discovery.cell;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.j;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.discovery.decoration.TaskVideoChildCellDecoration;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.ui.uilview.CircleImageView;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryTaskCell extends us.pinguo.widget.common.cell.recycler.b<InspireTask, c> implements View.OnClickListener, me.everything.a.a.a.c {
    private RecyclerView.OnScrollListener mOnScrollListener;
    private long mShowtime;
    private RecyclerView.RecycledViewPool mViewPool;

    /* loaded from: classes9.dex */
    private static final class DiscoveryTaskPayload {
        int picSum;
        List<InspireWork> rankList;

        public DiscoveryTaskPayload(int i2, List<InspireWork> list) {
            this.picSum = i2;
            this.rankList = list;
        }
    }

    public DiscoveryTaskCell(InspireTask inspireTask) {
        super(inspireTask);
    }

    private void addListener(RecyclerView recyclerView) {
        if (((InspireTask) this.mData).isVideo()) {
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryTaskCell.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView2, int i2, int i3) {
                    super.onScrolled(recyclerView2, i2, i3);
                    if (i3 == 0 && i2 == 0) {
                        return;
                    }
                    DiscoveryTaskCell.this.checkVisibleChange();
                }
            };
            this.mOnScrollListener = onScrollListener;
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    private boolean compareList(List<InspireWork> list, List<InspireWork> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        return list != null && list.equals(list2);
    }

    private List<us.pinguo.widget.common.cell.recycler.b> createCells(InspireTask inspireTask) {
        if (inspireTask != null) {
            boolean isVideo = inspireTask.isVideo();
            ArrayList arrayList = new ArrayList();
            for (InspireWork inspireWork : inspireTask.rankingList) {
                ChallengeListPhotoCell challengeListVideoCell = isVideo ? new ChallengeListVideoCell(inspireTask, inspireWork) : new ChallengeListPhotoCell(inspireTask, inspireWork);
                challengeListVideoCell.setParentCell(this);
                arrayList.add(challengeListVideoCell);
            }
            for (int size = arrayList.size(); size < 4; size++) {
                ChallengeListPhotoCell challengeListPhotoCell = new ChallengeListPhotoCell(inspireTask, new InspireWork());
                challengeListPhotoCell.setParentCell(this);
                arrayList.add(challengeListPhotoCell);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areContentsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        return ((InspireTask) this.mData).picSum == ((InspireTask) bVar.getData()).picSum && compareList(((InspireTask) this.mData).rankingList, ((InspireTask) bVar.getData()).rankingList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areItemsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        if (bVar == null) {
            return false;
        }
        DiffMode diffMode = getDiffMode();
        if (diffMode != null && diffMode == DiffMode.UNIQUE) {
            return getClass().isInstance(bVar);
        }
        return isDataEquals(bVar.getData());
    }

    public void checkVisibleChange() {
        if (this.mViewHolder == 0 || !((InspireTask) this.mData).isVideo()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) this.mViewHolder.getView(R.id.rv_discovery_square_hor_video);
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter();
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() + 1;
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() - 1; findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            ChallengeListPhotoCell challengeListPhotoCell = (ChallengeListPhotoCell) aVar.getItem(findFirstVisibleItemPosition);
            if (challengeListPhotoCell instanceof ChallengeListVideoCell) {
                ((ChallengeListVideoCell) challengeListPhotoCell).checkVisibleChange();
            }
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discovery_task_cell, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_discovery_square_hor_video);
        recyclerView.addItemDecoration(new TaskVideoChildCellDecoration(us.pinguo.foundation.t.b.a.a(recyclerView.getContext(), 1.7f)));
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext(), 0, false));
        return new c(inflate);
    }

    public void enterTaskDetail() {
        View view;
        VH vh = this.mViewHolder;
        if (vh == 0 || (view = vh.itemView) == null) {
            return;
        }
        Context context = view.getContext();
        Intent intent = new Intent(context, TaskDetailActivity.class);
        intent.putExtra("task_id", ((InspireTask) this.mData).taskId);
        intent.putExtra("key_from_page", "挑战");
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    @Nullable
    public Object getChangePayload(us.pinguo.widget.common.cell.recycler.b bVar) {
        InspireTask inspireTask = (InspireTask) bVar.getData();
        return new DiscoveryTaskPayload(inspireTask.picSum, inspireTask.rankingList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.DATA;
    }

    public RecyclerView getRecyclerView() {
        return (RecyclerView) this.mViewHolder.getView(R.id.rv_discovery_square_hor_video);
    }

    public ChallengeListPhotoCell getShareElementByWork(InspireWork inspireWork) {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return null;
        }
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) ((RecyclerView) vh.getView(R.id.rv_discovery_square_hor_video)).getAdapter();
        for (int i2 = 0; i2 < aVar.getItemCount(); i2++) {
            if (aVar.getItem(i2) instanceof ChallengeListPhotoCell) {
                ChallengeListPhotoCell challengeListPhotoCell = (ChallengeListPhotoCell) aVar.getItem(i2);
                if (challengeListPhotoCell.getData().equals(inspireWork)) {
                    return challengeListPhotoCell;
                }
            }
        }
        return null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return DiscoverySquareCellType.TASK_VIDEO.ordinal();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        us.pinguo.widget.common.cell.recycler.a aVar;
        CircleImageView circleImageView = (CircleImageView) cVar.getView(R.id.task_list_avatar);
        circleImageView.setImageUri(((InspireTask) this.mData).icon, R.drawable.challenge_default_avatar);
        ViewCompat.setTransitionName(circleImageView, ((InspireTask) this.mData).taskId + "_avatar");
        RecyclerView recyclerView = (RecyclerView) cVar.getView(R.id.rv_discovery_square_hor_video);
        recyclerView.setRecycledViewPool(this.mViewPool);
        addListener(recyclerView);
        new me.everything.a.a.a.a(new me.everything.a.a.a.h.b(recyclerView)).a(this);
        if (recyclerView.getAdapter() == null) {
            aVar = new us.pinguo.widget.common.cell.recycler.a();
            recyclerView.setAdapter(aVar);
        } else {
            aVar = (us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter();
        }
        aVar.beginChange();
        aVar.clear();
        aVar.addAll(createCells((InspireTask) this.mData));
        aVar.endChange(true);
        if (aVar.getItemCount() > 0) {
            recyclerView.scrollToPosition(0);
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = ((int) (us.pinguo.foundation.t.b.a.j(recyclerView.getContext()) * 0.388f)) + us.pinguo.foundation.t.b.a.b(recyclerView.getResources(), 7.5f);
        recyclerView.setLayoutParams(layoutParams);
        cVar.setText(R.id.task_list_title, ((InspireTask) this.mData).taskName);
        View view = cVar.getView(R.id.task_list_title);
        ViewCompat.setTransitionName(view, ((InspireTask) this.mData).taskId + "_name");
        cVar.setText(R.id.task_list_desc, ((InspireTask) this.mData).shortDesc);
        T t = this.mData;
        if (((InspireTask) t).award != null && !TextUtils.isEmpty(((InspireTask) t).award.awardTitle)) {
            LinearLayout linearLayout = (LinearLayout) cVar.getView(R.id.task_list_title_layout);
            linearLayout.setOrientation(0);
            cVar.setText(R.id.task_list_aware, "(" + linearLayout.getResources().getString(R.string.challenge_award) + ")");
            cVar.setVisible(R.id.task_list_aware, 0);
        } else {
            cVar.setVisible(R.id.task_list_aware, 8);
        }
        cVar.setText(R.id.task_list_num, String.valueOf(((InspireTask) this.mData).picSum));
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j.a(1000L)) {
            return;
        }
        enterTaskDetail();
        h.a.A0("challenge_task_list", ((InspireTask) this.mData).taskId, "click_into");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onHide() {
        super.onHide();
        h.a.R("challenge", ((InspireTask) this.mData).taskId, "show", String.valueOf(System.currentTimeMillis() - this.mShowtime));
    }

    @Override // me.everything.a.a.a.c
    public void onOverScrollStateChange(me.everything.a.a.a.b bVar, int i2, int i3) {
        if (i3 == 3 && i2 != 1) {
            enterTaskDetail();
            h.a.A0("challenge_task_list", ((InspireTask) this.mData).taskId, "slide_into");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        super.onShow();
        this.mShowtime = System.currentTimeMillis();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            ((RecyclerView) vh.getView(R.id.rv_discovery_square_hor_video)).removeOnScrollListener(this.mOnScrollListener);
        }
        super.onViewRecycled();
    }

    public DiscoveryTaskCell setViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        this.mViewPool = recycledViewPool;
        return this;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar, List<Object> list) {
        if (list.get(0) instanceof DiscoveryTaskPayload) {
            DiscoveryTaskPayload discoveryTaskPayload = (DiscoveryTaskPayload) list.get(0);
            cVar.setText(R.id.task_list_num, String.valueOf(discoveryTaskPayload.picSum));
            us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) ((RecyclerView) cVar.getView(R.id.rv_discovery_square_hor_video)).getAdapter();
            aVar.beginChange();
            aVar.clear();
            ArrayList arrayList = new ArrayList();
            for (InspireWork inspireWork : discoveryTaskPayload.rankList) {
                if (((InspireTask) this.mData).isVideo()) {
                    arrayList.add(new ChallengeListVideoCell((InspireTask) this.mData, inspireWork).setParentCell(this));
                } else {
                    arrayList.add(new ChallengeListPhotoCell((InspireTask) this.mData, inspireWork).setParentCell(this));
                }
            }
            aVar.set(arrayList);
            aVar.endChange(true);
        }
    }
}
