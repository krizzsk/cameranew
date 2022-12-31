package us.pinguo.inspire.module.MissionDetail;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.widget.fresco.WebpDraweeView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChallengeDetailVideoCell extends ChallengeDetailPhotoCell implements View.OnClickListener {
    private static final float VISIBLE_AREA = 0.6666667f;
    private int[] mLoc;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private Rect mTempRect3;

    public ChallengeDetailVideoCell(InspireTask inspireTask, InspireWork inspireWork) {
        super(inspireTask, inspireWork);
        this.mLoc = new int[2];
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRect3 = new Rect();
    }

    private void showVideoThumb(us.pinguo.widget.common.cell.recycler.c cVar) {
        WebpDraweeView webpDraweeView = (WebpDraweeView) cVar.getView(R.id.challenge_cell_img);
        TaskCellSize taskCellSize = TaskCellSize.INSTANCE;
        webpDraweeView.setVideoThumb(((InspireWork) this.mData).getWorkUrl(), ((InspireWork) this.mData).getWidth(), ((InspireWork) this.mData).getHeight(), taskCellSize.getVideoCellWidth(), taskCellSize.getVideoCellHeight());
    }

    private void startPlay(SimpleDraweeView simpleDraweeView) {
        Animatable e2 = simpleDraweeView.d().e();
        if (e2 != null) {
            e2.start();
        }
    }

    private void stopPlay(SimpleDraweeView simpleDraweeView) {
        Animatable e2;
        if (simpleDraweeView == null || simpleDraweeView.d() == null || (e2 = simpleDraweeView.d().e()) == null) {
            return;
        }
        e2.stop();
    }

    private void tryShowWebp(boolean z) {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return;
        }
        WebpDraweeView webpDraweeView = (WebpDraweeView) vh.getView(R.id.challenge_cell_img);
        if (checkShowWebp()) {
            webpDraweeView.setWebp(((InspireWork) this.mData).webpUrl, z);
        } else {
            showVideoThumb(this.mViewHolder);
        }
    }

    public boolean checkShowWebp() {
        return !TextUtils.isEmpty(((InspireWork) this.mData).webpUrl) && WebpDraweeView.p();
    }

    public void checkVisibleChange() {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return;
        }
        WebpDraweeView webpDraweeView = (WebpDraweeView) vh.getView(R.id.challenge_cell_img);
        webpDraweeView.getLocationInWindow(this.mLoc);
        int[] iArr = this.mLoc;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = webpDraweeView.getWidth() + i2;
        int height = webpDraweeView.getHeight() + i3;
        Activity d2 = ActivityRecorder.getInstance().d();
        if (d2 == null) {
            return;
        }
        View findViewById = d2.findViewById(16908290);
        this.mTempRect1.set(i2, i3, width, height);
        this.mTempRect2.set(0, 0, findViewById.getWidth(), findViewById.getHeight());
        if (this.mTempRect2.width() == 0 || this.mTempRect2.height() == 0) {
            this.mTempRect2.set(0, 0, us.pinguo.foundation.t.b.a.j(d2), us.pinguo.foundation.t.b.a.h(d2));
        }
        if (this.mTempRect3.setIntersect(this.mTempRect1, this.mTempRect2) && this.mTempRect3.width() * this.mTempRect3.height() > this.mTempRect1.width() * this.mTempRect1.height() * VISIBLE_AREA) {
            tryShowWebp(true);
        } else {
            tryShowWebp(false);
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.ChallengeDetailPhotoCell, us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c createViewHolder = super.createViewHolder(viewGroup);
        View view = createViewHolder.itemView;
        TaskCellSize taskCellSize = TaskCellSize.INSTANCE;
        view.setLayoutParams(new ViewGroup.LayoutParams(taskCellSize.getVideoCellWidth(), taskCellSize.getVideoCellHeight()));
        return createViewHolder;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.ChallengeDetailPhotoCell, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.ChallengeDetailPhotoCell
    public void setPhoto(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (checkShowWebp()) {
            WebpDraweeView webpDraweeView = (WebpDraweeView) cVar.getView(R.id.challenge_cell_img);
            webpDraweeView.o = this;
            webpDraweeView.q();
            return;
        }
        showVideoThumb(cVar);
    }

    public void setWebp(us.pinguo.widget.common.cell.recycler.c cVar) {
        ((WebpDraweeView) cVar.getView(R.id.challenge_cell_img)).setWebp(((InspireWork) this.mData).webpUrl, true);
    }
}
