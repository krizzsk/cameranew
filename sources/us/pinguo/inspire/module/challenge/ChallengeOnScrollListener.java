package us.pinguo.inspire.module.challenge;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.c360.i18n.R;
/* loaded from: classes9.dex */
public class ChallengeOnScrollListener extends RecyclerView.OnScrollListener {
    private static final int ShowRefreshIndex = 3;
    private ImageView mChallengeBtn;
    private TextView mChallengeTxt;
    private String mFeedsStr;
    private String mRefreshStr;

    public ChallengeOnScrollListener(View view) {
        View findViewWithTag = view.getRootView().findViewWithTag("radio_button1");
        if (findViewWithTag != null) {
            this.mChallengeBtn = (ImageView) findViewWithTag.findViewWithTag("radio_icon");
            this.mChallengeTxt = (TextView) findViewWithTag.findViewWithTag("radio_txt");
        }
        this.mRefreshStr = view.getResources().getString(R.string.portal_bottom_refresh);
        this.mFeedsStr = view.getResources().getString(vStudio.Android.Camera360.R.string.home_inspire_title);
    }

    public void checkShowRefreshBtn(LinearLayoutManager linearLayoutManager) {
        if (this.mChallengeBtn == null || this.mChallengeTxt == null) {
            return;
        }
        if (linearLayoutManager.findFirstVisibleItemPosition() >= 3) {
            if (this.mRefreshStr.equals(this.mChallengeTxt.getText())) {
                return;
            }
            this.mChallengeBtn.setImageResource(vStudio.Android.Camera360.R.drawable.portal_feeds_refresh_selector);
            this.mChallengeTxt.setText(R.string.portal_bottom_refresh);
        } else if (this.mFeedsStr.equals(this.mChallengeTxt.getText())) {
        } else {
            this.mChallengeBtn.setImageResource(vStudio.Android.Camera360.R.drawable.portal_feeds_selector);
            this.mChallengeTxt.setText(this.mFeedsStr);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        checkShowRefreshBtn((LinearLayoutManager) recyclerView.getLayoutManager());
    }
}
