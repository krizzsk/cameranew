package us.pinguo.inspire.module.discovery.listener;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryRefreshOnScrollerListener extends RecyclerView.OnScrollListener {
    private static final int SHOW_REFRESH_INDEX = 9;
    private ImageView mDiscoveryIconIv;
    private TextView mDiscoveryTextTv;

    public DiscoveryRefreshOnScrollerListener(Activity activity) {
        View findViewWithTag = activity.getWindow().getDecorView().findViewWithTag("radio_button1");
        this.mDiscoveryIconIv = (ImageView) findViewWithTag.findViewWithTag("radio_icon");
        this.mDiscoveryTextTv = (TextView) findViewWithTag.findViewWithTag("radio_txt");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i4 = layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0] : 0;
        if (layoutManager instanceof LinearLayoutManager) {
            i4 = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (i4 >= 9) {
            if ("discovery_refresh".equals(this.mDiscoveryIconIv.getTag())) {
                return;
            }
            this.mDiscoveryIconIv.setImageResource(R.drawable.portal_discovery_refresh_selector);
            this.mDiscoveryTextTv.setText(us.pinguo.c360.i18n.R.string.portal_bottom_refresh);
            this.mDiscoveryIconIv.setTag("discovery_refresh");
        } else if (TextUtils.isEmpty((CharSequence) this.mDiscoveryIconIv.getTag())) {
        } else {
            this.mDiscoveryIconIv.setImageResource(R.drawable.portal_discovery_selector);
            this.mDiscoveryTextTv.setText(R.string.home_inspire_title);
            this.mDiscoveryIconIv.setTag(null);
        }
    }
}
