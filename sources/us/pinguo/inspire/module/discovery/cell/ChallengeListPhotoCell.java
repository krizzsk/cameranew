package us.pinguo.inspire.module.discovery.cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.drawable.p;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentLayoutHelper;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.j;
import us.pinguo.inspire.cell.recycler.e;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.util.transition.h;
import us.pinguo.inspire.widget.fresco.PhotoDraweeView;
import us.pinguo.inspire.widget.like.LikeImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChallengeListPhotoCell extends e<InspireWork, c> implements View.OnClickListener, us.pinguo.inspire.util.transition.c {
    private OnShowListener mOnShowListener;
    private DiscoveryTaskCell mParentCell;
    protected InspireTask mTask;

    /* loaded from: classes9.dex */
    public interface OnShowListener {
        void onShow();
    }

    public ChallengeListPhotoCell(InspireTask inspireTask, InspireWork inspireWork) {
        super(inspireWork);
        this.mTask = inspireTask;
    }

    private void setTag(c cVar) {
        TextView textView = (TextView) cVar.getView(R.id.challenge_cell_tag);
        if (((InspireWork) this.mData).isDemo) {
            textView.setVisibility(0);
            textView.setBackgroundResource(R.drawable.challenge_tag_official);
            textView.setText(R.string.challenge_official);
            return;
        }
        textView.setVisibility(8);
    }

    protected void adjustSize(c cVar) {
        ViewGroup viewGroup = (ViewGroup) cVar.getView(R.id.challenge_cell_content_layout);
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) cVar.getView(R.id.challenge_cell_img);
        PercentFrameLayout.LayoutParams layoutParams = (PercentFrameLayout.LayoutParams) viewGroup.getLayoutParams();
        PercentFrameLayout.LayoutParams layoutParams2 = (PercentFrameLayout.LayoutParams) photoDraweeView.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo a = layoutParams2.a();
        PercentLayoutHelper.PercentLayoutInfo a2 = layoutParams.a();
        if (((InspireWork) this.mData).isVideo()) {
            if (h.a.q((InspireWork) this.mData)) {
                a.a.a = 0.388f;
                a.b.a = 0.291f;
                photoDraweeView.setRotation(90.0f);
            } else {
                a.a.a = 0.291f;
                a.b.a = 0.388f;
                photoDraweeView.setRotation(0.0f);
            }
            a2.a.a = 0.291f;
        } else {
            if (((InspireWork) this.mData).getWidth() > ((InspireWork) this.mData).getHeight()) {
                a.b.a = 0.388f;
                a.a.a = 0.5173f;
                a2.a.a = 0.5173f;
            } else {
                a.b.a = 0.388f;
                a.a.a = 0.291f;
                a2.a.a = 0.291f;
            }
            photoDraweeView.setRotation(0.0f);
        }
        photoDraweeView.setLayoutParams(layoutParams2);
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areContentsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        return super.areContentsTheSame(bVar) && f0.b(((InspireWork) this.mData).getWorkUrl(), ((InspireWork) bVar.getData()).getWorkUrl()) && f0.b(((InspireWork) this.mData).webpUrl, ((InspireWork) bVar.getData()).webpUrl) && ((InspireWork) this.mData).isDemo == ((InspireWork) bVar.getData()).isDemo;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.challenge_cell_layout, viewGroup, false));
    }

    @Override // us.pinguo.inspire.util.transition.c
    public View getChangedShareElement() {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return null;
        }
        return vh.getView(R.id.challenge_cell_img);
    }

    public DiscoveryTaskCell getParentCell() {
        return this.mParentCell;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        adjustSize(cVar);
        setPhoto(cVar);
        LikeImageView likeImageView = (LikeImageView) cVar.getView(R.id.challenge_cell_like);
        T t = this.mData;
        likeImageView.k((us.pinguo.inspire.widget.like.a) t, R.drawable.icon_square_unlike, R.drawable.icon_square_like, ((InspireWork) t).workId, this, cVar.itemView, this, (ImageView) cVar.getView(R.id.challenge_cell_like_anim));
        setTag(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DiscoveryTaskCell discoveryTaskCell;
        if (j.a(1000L) || this.mViewHolder == 0 || (discoveryTaskCell = this.mParentCell) == null) {
            return;
        }
        discoveryTaskCell.enterTaskDetail();
        us.pinguo.foundation.statistics.h.a.A0("challenge_task_list", ((InspireWork) this.mData).taskId, "click_into");
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    public ChallengeListPhotoCell setParentCell(DiscoveryTaskCell discoveryTaskCell) {
        this.mParentCell = discoveryTaskCell;
        return this;
    }

    public void setPhoto(c cVar) {
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) cVar.getView(R.id.challenge_cell_img);
        ViewCompat.setTransitionName(photoDraweeView, h.a.i((InspireWork) this.mData));
        photoDraweeView.e().v(null);
        photoDraweeView.e().u(p.c.f2566g);
        PercentLayoutHelper.PercentLayoutInfo a = ((PercentFrameLayout.LayoutParams) photoDraweeView.getLayoutParams()).a();
        float j2 = us.pinguo.foundation.t.b.a.j(photoDraweeView.getContext());
        photoDraweeView.setImageSize((int) (a.a.a * j2), (int) (j2 * a.b.a));
        photoDraweeView.setImageURI(((InspireWork) this.mData).getWorkUrl());
    }
}
