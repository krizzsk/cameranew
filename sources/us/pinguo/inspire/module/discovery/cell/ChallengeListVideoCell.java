package us.pinguo.inspire.module.discovery.cell;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentLayoutHelper;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.util.transition.h;
import us.pinguo.inspire.widget.fresco.WebpDraweeView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChallengeListVideoCell extends ChallengeListPhotoCell {
    private static final float VISIBLE_AREA = 0.6666667f;
    private int[] mLoc;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private Rect mTempRect3;

    public ChallengeListVideoCell(InspireTask inspireTask, InspireWork inspireWork) {
        super(inspireTask, inspireWork);
        this.mLoc = new int[2];
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRect3 = new Rect();
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
        View view = vh.getView(R.id.challenge_cell_content_layout);
        view.getLocationInWindow(this.mLoc);
        int[] iArr = this.mLoc;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth() + i2;
        int height = view.getHeight() + i3;
        Activity d2 = ActivityRecorder.getInstance().d();
        if (d2 == null) {
            return;
        }
        View findViewById = d2.findViewById(16908290);
        this.mTempRect1.set(i2, i3, width, height);
        this.mTempRect2.set(0, 0, findViewById.getWidth(), findViewById.getHeight());
        if (this.mTempRect3.setIntersect(this.mTempRect1, this.mTempRect2) && this.mTempRect3.width() * this.mTempRect3.height() > this.mTempRect1.width() * this.mTempRect1.height() * VISIBLE_AREA) {
            tryShowWebp(true);
        } else {
            tryShowWebp(false);
        }
    }

    @Override // us.pinguo.inspire.module.discovery.cell.ChallengeListPhotoCell
    public void setPhoto(c cVar) {
        WebpDraweeView webpDraweeView = (WebpDraweeView) cVar.getView(R.id.challenge_cell_img);
        ViewCompat.setTransitionName(webpDraweeView, h.a.i((InspireWork) this.mData));
        if (checkShowWebp()) {
            webpDraweeView.q();
        } else {
            showVideoThumb(cVar);
        }
    }

    public void showVideoThumb(c cVar) {
        WebpDraweeView webpDraweeView = (WebpDraweeView) cVar.getView(R.id.challenge_cell_img);
        ViewCompat.setTransitionName(webpDraweeView, h.a.i((InspireWork) this.mData));
        PercentLayoutHelper.PercentLayoutInfo a = ((PercentFrameLayout.LayoutParams) webpDraweeView.getLayoutParams()).a();
        float j2 = us.pinguo.foundation.t.b.a.j(webpDraweeView.getContext());
        webpDraweeView.setVideoThumb(((InspireWork) this.mData).getWorkUrl(), ((InspireWork) this.mData).getWidth(), ((InspireWork) this.mData).getHeight(), (int) (a.a.a * j2), (int) (j2 * a.b.a));
    }
}
