package us.pinguo.inspire.module.feeds;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.c360.i18n.R;
/* loaded from: classes9.dex */
public class FeedsOnScrollListener extends RecyclerView.OnScrollListener {
    private static final int ShowRefreshIndex = 3;
    private ImageView mFeedsBtn;
    private String mFeedsStr;
    private TextView mFeedsTxt;
    private String mRefreshStr;

    public FeedsOnScrollListener(View view) {
        View findViewWithTag = view.getRootView().findViewWithTag("radio_button0");
        if (findViewWithTag != null) {
            this.mFeedsBtn = (ImageView) findViewWithTag.findViewWithTag("radio_icon");
            this.mFeedsTxt = (TextView) findViewWithTag.findViewWithTag("radio_txt");
        }
        this.mRefreshStr = view.getResources().getString(R.string.portal_bottom_refresh);
        this.mFeedsStr = view.getResources().getString(vStudio.Android.Camera360.R.string.portal_bottom_feeds);
    }

    public void checkShowRefreshBtn(LinearLayoutManager linearLayoutManager) {
        if (this.mFeedsBtn == null || this.mFeedsTxt == null) {
            return;
        }
        if (linearLayoutManager.findFirstVisibleItemPosition() >= 3) {
            if (this.mRefreshStr.equals(this.mFeedsTxt.getText())) {
                return;
            }
            this.mFeedsBtn.setImageResource(vStudio.Android.Camera360.R.drawable.portal_feeds_refresh_selector);
            this.mFeedsTxt.setText(R.string.portal_bottom_refresh);
        } else if (this.mFeedsStr.equals(this.mFeedsTxt.getText())) {
        } else {
            this.mFeedsBtn.setImageResource(vStudio.Android.Camera360.R.drawable.portal_feeds_selector);
            this.mFeedsTxt.setText(this.mFeedsStr);
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
