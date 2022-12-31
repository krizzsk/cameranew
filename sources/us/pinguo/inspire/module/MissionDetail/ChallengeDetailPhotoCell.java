package us.pinguo.inspire.module.MissionDetail;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.widget.fresco.PhotoDraweeView;
import us.pinguo.inspire.widget.fresco.WebpDraweeView;
import us.pinguo.inspire.widget.like.LikeImageView;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChallengeDetailPhotoCell extends us.pinguo.inspire.cell.recycler.e<InspireWork, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, us.pinguo.inspire.widget.like.a {
    private long mShowTime;
    protected InspireTask mTask;

    public ChallengeDetailPhotoCell(InspireTask inspireTask, InspireWork inspireWork) {
        super(inspireWork);
        this.mTask = inspireTask;
        registerWorkLikeEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(us.pinguo.inspire.event.f fVar) {
        if (f0.b(fVar.a, ((InspireWork) this.mData).workId)) {
            T t = this.mData;
            ((InspireWork) t).likeSum = fVar.b;
            ((InspireWork) t).like = fVar.c;
            updateLike(this.mViewHolder);
        }
    }

    private void checkRotate(us.pinguo.widget.common.cell.recycler.c cVar) {
        WebpDraweeView webpDraweeView = (WebpDraweeView) cVar.getView(R.id.challenge_cell_img);
        boolean q = us.pinguo.inspire.util.transition.h.a.q((InspireWork) this.mData);
        boolean z = webpDraweeView.getTag(R.id.tag_rotated) != null && ((Boolean) webpDraweeView.getTag(R.id.tag_rotated)).booleanValue();
        if (q && !z) {
            ViewGroup.LayoutParams layoutParams = webpDraweeView.getLayoutParams();
            TaskCellSize taskCellSize = TaskCellSize.INSTANCE;
            layoutParams.width = taskCellSize.getVideoCellHeight();
            layoutParams.height = taskCellSize.getVideoCellWidth();
            webpDraweeView.setRotation(90.0f);
            webpDraweeView.setLayoutParams(layoutParams);
            webpDraweeView.setTag(R.id.tag_rotated, Boolean.TRUE);
        } else if (q || !z) {
        } else {
            ViewGroup.LayoutParams layoutParams2 = webpDraweeView.getLayoutParams();
            TaskCellSize taskCellSize2 = TaskCellSize.INSTANCE;
            layoutParams2.width = taskCellSize2.getVideoCellWidth();
            layoutParams2.height = taskCellSize2.getVideoCellHeight();
            webpDraweeView.setRotation(0.0f);
            webpDraweeView.setLayoutParams(layoutParams2);
            webpDraweeView.setTag(R.id.tag_rotated, Boolean.FALSE);
        }
    }

    private void registerWorkLikeEvent() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.f.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChallengeDetailPhotoCell.this.b((us.pinguo.inspire.event.f) obj);
            }
        }, a.a));
    }

    private void setTag(us.pinguo.widget.common.cell.recycler.c cVar) {
        TextView textView = (TextView) cVar.getView(R.id.challenge_cell_tag);
        checkRotate(cVar);
        T t = this.mData;
        if (((InspireWork) t).isKing) {
            textView.setVisibility(0);
            textView.setBackgroundResource(R.drawable.challenge_tag_king);
            textView.setText(R.string.challenge_king);
        } else if (((InspireWork) t).isDemo) {
            textView.setVisibility(0);
            textView.setBackgroundResource(R.drawable.challenge_tag_official);
            textView.setText(R.string.challenge_official);
        } else {
            textView.setVisibility(8);
        }
    }

    private void updateLike(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areContentsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        boolean areContentsTheSame = super.areContentsTheSame(bVar);
        T t = this.mData;
        return (((InspireWork) t).isDemo && ((InspireWork) t).isVideo()) ? areContentsTheSame && f0.b(((InspireWork) this.mData).getWorkUrl(), ((InspireWork) bVar.getData()).getWorkUrl()) && f0.b(((InspireWork) this.mData).webpUrl, ((InspireWork) bVar.getData()).webpUrl) : areContentsTheSame;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.challenge_detail_cell_layout, viewGroup, false));
    }

    public View getShareElement() {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return null;
        }
        return vh.getView(R.id.challenge_cell_img);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.inspire.widget.like.a
    public boolean isLiked() {
        return ((InspireWork) this.mData).isLiked();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        setPhoto(cVar);
        String i2 = us.pinguo.inspire.util.transition.h.a.i((InspireWork) this.mData);
        ViewCompat.setTransitionName(cVar.getView(R.id.challenge_cell_img), i2);
        cVar.getView(R.id.challenge_cell_img).setTag(i2);
        final LikeImageView likeImageView = (LikeImageView) cVar.getView(R.id.challenge_cell_like);
        likeImageView.k(this, R.drawable.icon_square_unlike, R.drawable.icon_square_like, ((InspireWork) this.mData).workId, this, cVar.itemView, this, (ImageView) cVar.getView(R.id.challenge_cell_like_anim));
        likeImageView.setOnDoubleClickListener(new f.b() { // from class: us.pinguo.inspire.module.MissionDetail.ChallengeDetailPhotoCell.1
            @Override // us.pinguo.user.util.f.b
            public void onDoubleClick(View view) {
                if (likeImageView.j().isLiked()) {
                    us.pinguo.foundation.statistics.h.a.k("challenge_work_list", "", "challenge_task_detail_page", ((InspireWork) ((us.pinguo.widget.common.cell.recycler.b) ChallengeDetailPhotoCell.this).mData).workId, "double_click_to_like");
                }
            }

            @Override // us.pinguo.user.util.f.b
            public void onSingleClick(View view) {
            }
        });
        setTag(cVar);
        updateLike(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InspireWorkBulkLoader.AdVideo taskAdVideo;
        if (us.pinguo.foundation.utils.j.a(1000L) || this.mData == 0) {
            return;
        }
        View view2 = this.mViewHolder.getView(R.id.challenge_cell_img);
        Intent intent = new Intent();
        intent.putExtra("task_info", InspireWork.TaskInfo.fromTask(this.mTask));
        Activity d2 = ActivityRecorder.getInstance().d();
        if ((d2 instanceof TaskDetailActivity) && (taskAdVideo = ((TaskDetailActivity) d2).getTaskAdVideo()) != null) {
            intent.putExtra("task_ad_video", taskAdVideo);
        }
        FeedsList.setFeedsList(this.mAdapter.getCells(), this);
        FeedsList.enterDetailPage(view.getContext(), "", "", (InspireWork) this.mData, "from_discovery", this.mAdapter, this, 0, us.pinguo.inspire.util.transition.h.a.f(ActivityRecorder.getInstance().d(), view2), intent);
        us.pinguo.foundation.statistics.h.a.p0(((InspireWork) this.mData).workId, "click", String.valueOf(1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onHide() {
        super.onHide();
        us.pinguo.foundation.statistics.h.a.p0(((InspireWork) this.mData).workId, "show", String.valueOf(System.currentTimeMillis() - this.mShowTime));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        super.onShow();
        this.mShowTime = System.currentTimeMillis();
    }

    @Override // us.pinguo.inspire.widget.like.a
    public void setLikeState(boolean z) {
        if (z) {
            T t = this.mData;
            ((InspireWork) t).like = 1;
            ((InspireWork) t).likeSum++;
        } else {
            T t2 = this.mData;
            ((InspireWork) t2).like = 0;
            ((InspireWork) t2).likeSum--;
        }
        updateLike(this.mViewHolder);
    }

    public void setPhoto(us.pinguo.widget.common.cell.recycler.c cVar) {
        TaskCellSize taskCellSize = TaskCellSize.INSTANCE;
        int photoCellWidth = taskCellSize.getPhotoCellWidth();
        int photoCellHeight = taskCellSize.getPhotoCellHeight(((InspireWork) this.mData).getWidth(), ((InspireWork) this.mData).getHeight());
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) cVar.getView(R.id.challenge_cell_img);
        ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
        layoutParams.width = photoCellWidth;
        layoutParams.height = photoCellHeight;
        cVar.itemView.setLayoutParams(layoutParams);
        photoDraweeView.setImageSize(photoCellWidth, photoCellHeight);
        photoDraweeView.setImageURI(((InspireWork) this.mData).getWorkUrl());
    }
}
